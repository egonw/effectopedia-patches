package org.qsari.effectopedia.data.quantification;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.base.io.BaseIO;
import org.qsari.effectopedia.base.io.BaseIOElement;
import org.qsari.effectopedia.base.io.Exportable;
import org.qsari.effectopedia.base.io.Importable;
import org.qsari.effectopedia.data.DataSource;
import org.qsari.effectopedia.data.objects.DescriptorType;
import org.qsari.effectopedia.data.objects.ObjectProperties;
import org.qsari.effectopedia.data.objects.ObjectProperty;
import org.qsari.effectopedia.data.objects.ObjectPropertyMultivalued;
import org.qsari.effectopedia.data.objects.ObjectPropertyMultivalued_Documented;
import org.qsari.effectopedia.data.objects.ObjectPropertyType;

public class Factors<F extends EffectopediaObject> implements Importable, Exportable, Cloneable
	{
		public Factors()
			{
				this.factors = null;
				this.owner = null;
				this.dataSource = null;
			}
		
		public Factors(F[] objectIDs, EffectopediaObject owner, DataSource dataSource)
			{
				this.factors = objectIDs;
				this.owner = owner;
				this.dataSource = dataSource;
			}
		
		public Factors<F> clone(EffectopediaObject owner, DataSource dataSource)
			{
				Factors<F> clone = new Factors<F>(factors, owner, dataSource);
				return clone;
			}
		
		public ArrayList<double[]> getAllFactorValuesAsDouble()
			{
				ArrayList<double[]> factorsData = new ArrayList<double[]>();
				for (EffectopediaObject object : getFactors())
					{
						ObjectProperty property = ((Factor) object).getCurrentState();
						if ((property != null) && (property instanceof ObjectPropertyMultivalued))
							factorsData.add(((ObjectPropertyMultivalued) property).getValuesAsDouble());
					}
				return factorsData;
			}
		
		public ArrayList<double[]> getAllFactorMinValuesAsDouble()
			{
				ArrayList<double[]> factorsData = new ArrayList<double[]>();
				for (EffectopediaObject object : getFactors())
					{
						ObjectProperty property = ((Factor) object).getCurrentState();
						if ((property != null) && (property instanceof ObjectPropertyMultivalued_Documented))
							factorsData.add(((ObjectPropertyMultivalued_Documented) property).getMinValuesAsDouble());
					}
				return factorsData;
			}
		
		public ArrayList<double[]> getAllFactorMaxValuesAsDouble()
			{
				ArrayList<double[]> factorsData = new ArrayList<double[]>();
				for (EffectopediaObject object : getFactors())
					{
						ObjectProperty property = ((Factor) object).getCurrentState();
						if ((property != null) && (property instanceof ObjectPropertyMultivalued_Documented))
							factorsData.add(((ObjectPropertyMultivalued_Documented) property).getMaxValuesAsDouble());
					}
				return factorsData;
			}
		
		public ArrayList<double[]> getAllFactorDescriptorValuesAsDouble(DescriptorType descriptorType)
			{
				ArrayList<double[]> factorsData = new ArrayList<double[]>();
				for (EffectopediaObject object : getFactors())
					{
						ObjectProperty property = ((Factor) object).getCurrentState();
						if ((property != null) && (property instanceof ObjectPropertyMultivalued_Documented))
							factorsData.add(((ObjectPropertyMultivalued_Documented) property).getDescriptorValuesAsDouble(descriptorType));
					}
				return factorsData;
			}
		
		public ObjectProperties getAllObjectProperties()
			{
				LinkedHashMap<ObjectPropertyType, ObjectProperty> properties = new LinkedHashMap<ObjectPropertyType, ObjectProperty>();
				for (EffectopediaObject object : getFactors())
					{
						ObjectProperty property = ((Factor) object).getCurrentState();
						if (property != null)
							properties.put((ObjectPropertyType) property.getType(), property);
					}
				return new ObjectProperties(owner, properties);
			}
		
		public ObjectProperties combineWith(ObjectProperty ptoperty)
			{
				LinkedHashMap<ObjectPropertyType, ObjectProperty> properties = new LinkedHashMap<ObjectPropertyType, ObjectProperty>();
				if (ptoperty != null)
					properties.put((ObjectPropertyType) ptoperty.getType(), ptoperty);
				for (EffectopediaObject object : getFactors())
					{
						ObjectProperty property = ((Factor) object).getCurrentState();
						if (property != null)
							properties.put((ObjectPropertyType) property.getType(), property);
					}
				return new ObjectProperties(owner, properties);
			}
		
		public ObjectProperties combineWith(ObjectProperties properties)
			{
				LinkedHashMap<ObjectPropertyType, ObjectProperty> propertiesMAP = new LinkedHashMap<ObjectPropertyType, ObjectProperty>();
				for (ObjectProperty property : properties.getProperties())
					propertiesMAP.put((ObjectPropertyType) property.getType(), property);
				for (EffectopediaObject object : getFactors())
					{
						ObjectProperty property = ((Factor) object).getCurrentState();
						if (property != null)
							propertiesMAP.put((ObjectPropertyType) property.getType(), property);
					}
				return new ObjectProperties(owner, propertiesMAP);
			}
		
		public EffectopediaObject getOwner()
			{
				return owner;
			}
		
		public void setOwner(EffectopediaObject owner)
			{
				this.owner = owner;
			}
		
		public int getCount()
			{
					return factors!=null?factors.length:0;
			}
		
		public F[] getFactors()
			{
				return factors;
			}
		
		protected void setFactors(F[] factors)
			{
				this.factors = factors;
			}

		public DataSource getDataSource()
			{
				return dataSource;
			}
		
		public void setDataSource(DataSource dataSource)
			{
				this.dataSource = dataSource;
			}
		
		public void load(BaseIOElement element, BaseIO io)
			{
			}
		
		@Override
		public BaseIOElement store(BaseIOElement element, BaseIO io)
			{
				return element;
			}
		
		protected EffectopediaObject	owner;
		protected DataSource									dataSource;
		protected F[]																factors;
	}
