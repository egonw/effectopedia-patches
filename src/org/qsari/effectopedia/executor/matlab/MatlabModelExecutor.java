package org.qsari.effectopedia.executor.matlab;

import org.qsari.effectopedia.core.modelling.AbstractFileBasedModelExecutor;
import org.qsari.effectopedia.core.modelling.ExecutableModel;
import org.qsari.effectopedia.core.modelling.ExecutionProgressUpdater;
import org.qsari.effectopedia.core.modelling.ModelExecutor;
import org.qsari.effectopedia.core.objects.Method_InSilicoGlobalModel;
import org.qsari.effectopedia.data.objects.DataValue_String;
import org.qsari.effectopedia.data.objects.DescriptorType;
import org.qsari.effectopedia.data.objects.ObjectProperties;
import org.qsari.effectopedia.data.objects.ObjectProperty;
import org.qsari.effectopedia.data.objects.ObjectPropertyMultivalued;
import org.qsari.effectopedia.data.objects.ObjectPropertyMultivalued_Documented;
import org.qsari.effectopedia.data.objects.Resource;

import matlabcontrol.MatlabConnectionException;
import matlabcontrol.MatlabInvocationException;
import matlabcontrol.MatlabProxy;
import matlabcontrol.MatlabProxyFactory;
import matlabcontrol.MatlabProxyFactoryOptions;
import matlabcontrol.extensions.MatlabNumericArray;
import matlabcontrol.extensions.MatlabTypeConverter;

public class MatlabModelExecutor extends AbstractFileBasedModelExecutor implements ModelExecutor, ExecutionProgressUpdater
	{
		public static final MatlabModelExecutor	EXECUTOR	= new MatlabModelExecutor();
		public boolean																										usePreviousSession;
		public boolean																										showMatlabInterface;
		protected MatlabProxyFactoryOptions					options;
		protected MatlabProxyFactory												factory;
		protected MatlabProxy																			proxy;
		protected MatlabExecutableModel									em;
		
		public static void main(String[] args) throws MatlabConnectionException, MatlabInvocationException
			{
				MatlabModelExecutor mme = new MatlabModelExecutor();
				mme.init();
				mme.disconnect(true);
			}
		
		public MatlabModelExecutor()
			{
				// ModelExecutorFactory.registerExecutor(this,
				// Resource.ResourceType.MATLAB_SOURCE_CODE);
			}
		
		@Override
		public void setGlobalModel(Method_InSilicoGlobalModel globalModel, Resource method)
			{
				this.model = globalModel;
				this.em = new MatlabExecutableModel(globalModel, method);
			}
		
		public void setGlobalModel(Method_InSilicoGlobalModel globalModel, MatlabExecutableModel em)
			{
				this.model = globalModel;
				this.em = em;
			}
		
		@Override
		public ExecutableModel getModel()
			{
				return em;
			}
		
		public boolean init()
			{
				if (!initResources())
					return false;
				
				if ((proxy != null) && (proxy.isConnected()))
					return true;
				options = new MatlabProxyFactoryOptions.Builder().setHidden(false).setUsePreviouslyControlledSession(true).build();
				// Create a proxy, which we will use to control MATLAB
				factory = new MatlabProxyFactory(options);
				
				try
					{
						proxy = factory.getProxy();
						fireProgressMade(5);
						proxy.eval("clear");
						// console.println(proxy.getIdentifier());
						console.println(proxy.toString());
						proxy.eval("addpath('" + workPath + "')");
					}
				catch (MatlabConnectionException e)
					{
						e.printStackTrace(console);
						proxy = null;
						return false;
					}
				catch (MatlabInvocationException e)
					{
						e.printStackTrace(console);
						return false;
					}
				return true;
			}
		
		protected boolean disconnect(boolean exit)
			{
				if (proxy == null)
					return true;
				try
					{
						if (exit)
						// exits Matlab
							{
								proxy.eval("rmpath('" + workPath + "')");
								proxy.exit();
							}
						else
							// Disconnect the proxy from Matlab
							proxy.disconnect();
						return true;
					}
				catch (MatlabInvocationException e)
					{
						e.printStackTrace(console);
						return false;
					}
			}
		
		public String objectPropertiesToMatlabStruct(String structName, String structDescription, ObjectProperties properties)
			{
				StringBuilder sb = new StringBuilder();
				sb.append(structName);
				sb.append(" = struct (...   %");
				sb.append(structDescription);
				sb.append("\n");
				for (ObjectProperty op : properties.getProperties())
					addObjectProperty(sb, "", op);
				if (properties.getCount() > 0)
					sb.deleteCharAt(lastObjPropDefEnd);
				sb.append(");\n");
				return sb.toString();
			}
		
		protected void addObjectProperty(StringBuilder sb, String preffix, ObjectProperty op)
			{
				String opName;
				if (preffix.length() > 0)
					opName = preffix + "_" + op.getType().getName();
				else
					opName = op.getType().getName();
				sb.append("'");
				sb.append(opName);
				sb.append("', ");
				if (op instanceof ObjectPropertyMultivalued)
					{
						int cnt = ((ObjectPropertyMultivalued) op).valuesCount();
						sb.append("[");
						for (int i = 0; i < cnt - 1; i++)
							{
								appendValidValue(sb, op.getType().getBaseValueType(), ((ObjectPropertyMultivalued) op).getValueAndUnitPair(i).getDisplayValue());
								sb.append(", ");
							}
						if (cnt > 0)
							appendValidValue(sb, op.getType().getBaseValueType(), ((ObjectPropertyMultivalued) op).getValueAndUnitPair(cnt - 1).getDisplayValue());
						sb.append("]");
					}
				else
					sb.append(op.getDisplayValue());
				lastObjPropDefEnd = sb.length();
				sb.append(",...   %");
				sb.append(op.getDisplayUnit());
				sb.append(" ");
				sb.append(op.getType().getDescription());
				sb.append("\n");
				if (op instanceof ObjectPropertyMultivalued_Documented)
					addDescriptors(sb, opName, (ObjectPropertyMultivalued_Documented) op);
				// TODO
				/*
				 * for (ValueAndUnit vu : op.getValuePairs()) { ObjectProperties
				 * subProperties = vu.getSubProperties(); if (subProperties != null) for
				 * (ObjectProperty subProp : subProperties.getProperties())
				 * addObjectProperty(sb, opName, subProp); }
				 */
			}
		
		protected void addDescriptors(StringBuilder sb, String preffix, ObjectPropertyMultivalued_Documented op)
			{
				int descrCnt = op.getType().getDescriptorsCount();
				for (int j = 0; j < descrCnt - 1; j++)
					{
						DescriptorType descriptorType = (DescriptorType) op.getType().getDescriptors().get(j);
						sb.append("'");
						sb.append(preffix);
						sb.append("_");
						sb.append(descriptorType.getName());
						sb.append("', ");
						
						sb.append("[");
						int cnt = op.valuesCount();
						for (int i = 0; i < cnt - 1; i++)
							{
								appendValidValue(sb, descriptorType.getBaseValueType(), op.getValueAndUnitPair(i).getDescriptor(descriptorType).getDisplayValue());
								sb.append(", ");
							}
						if (cnt > 0)
							appendValidValue(sb, descriptorType.getBaseValueType(), op.getValueAndUnitPair(cnt - 1).getDescriptor(descriptorType).getDisplayValue());
						sb.append("]");
						lastObjPropDefEnd = sb.length();
						sb.append(",...   %");
						String displUnit = op.getValueAndUnitPair(0).getDescriptor(descriptorType).getDisplayUnit();
						if (displUnit != null)
							{
								sb.append(displUnit);
								sb.append(" ");
							}
						sb.append(descriptorType.getDescription());
						sb.append("\n");
					}
				
			}
		
		protected void appendValidValue(StringBuilder sb, Class<?> baseType, String value)
			{
				if (baseType == DataValue_String.class)
					{
						sb.append("'");
						sb.append(value);
						sb.append("'");
					}
				else
					sb.append(((value != null) && (value.length() > 0)) ? value : "0");
			}
		
		public ObjectProperties MatlabStructToObjectProperties(String structName, ObjectProperties properties)
			{
				if (properties != null)
					{
						MatlabTypeConverter processor = new MatlabTypeConverter(proxy);
						structName += ".";
						for (ObjectProperty op : properties.getProperties())
							readProperty(processor, structName + op.getType().getName(), op);
					}
				return properties;
			}
		
		protected void readProperty(MatlabTypeConverter processor, String propertyName, ObjectProperty op)
			{
				try
					{
						if ((op instanceof ObjectPropertyMultivalued_Documented) || (op instanceof ObjectPropertyMultivalued))
							{
								ObjectPropertyMultivalued mvOP = ((ObjectPropertyMultivalued) op);
								MatlabNumericArray values = processor.getNumericArray(propertyName);
								mvOP.clearValuePairs();
								mvOP.add(values.getLength());
								for (int i = 0; i < values.getLength(); i++)
									mvOP.getValueAndUnitPair(i).setDoubleValue(values.getRealValue(i));
								if (mvOP instanceof ObjectPropertyMultivalued_Documented)
									readDescriptors(processor, propertyName, (ObjectPropertyMultivalued_Documented) op);
							}
						else
							{
								Object value = proxy.getVariable(propertyName);
								if (value instanceof String)
									op.setValue((String) value);
							}
					}
				catch (MatlabInvocationException e)
					{
						e.printStackTrace(console);
					}
				// TODO
				/*
				 * for (ValueAndUnit vu : op.getValuePairs()) { ObjectProperties
				 * subProperties = vu.getSubProperties(); if (subProperties != null) for
				 * (ObjectProperty subProp : subProperties.getProperties())
				 * readProperty(processor, propertyName + "_" + subProp.getType().getName(),
				 * subProp); }
				 */
			}
		
		protected void readDescriptors(MatlabTypeConverter processor, String propertyName, ObjectPropertyMultivalued_Documented op) throws MatlabInvocationException
			{
				int descrCnt = op.getType().getDescriptorsCount();
				for (int j = 0; j < descrCnt - 1; j++)
					{
						DescriptorType descriptorType = (DescriptorType) op.getType().getDescriptors().get(j);
						String descriptorFullName = propertyName + "_" + descriptorType.getName();
						MatlabNumericArray values = processor.getNumericArray(descriptorFullName);
						for (int i = 0; i < values.getLength(); i++)
							op.getValueAndUnitPair(i).getDescriptor(descriptorType).setFromDouble(values.getRealValue(i));
					}
			}
		
		@Override
		public void updateResources()
			{
				if (em != null)
					em.generateInitializer(null, model.getModelParamaters(), null);
			}
	}
