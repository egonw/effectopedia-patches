package org.qsari.effectopedia.data.generated;

import org.qsari.effectopedia.base.ids.IDs;
import org.qsari.effectopedia.core.objects.DescriptionSection;
import org.qsari.effectopedia.core.objects.DescriptionSection.ContentFormat;
import org.qsari.effectopedia.core.objects.Effect_DownstreamEffect;
import org.qsari.effectopedia.core.objects.Effect_MolecularInitiatingEvent;
import org.qsari.effectopedia.core.objects.Initiator_ChemicalStructure;
import org.qsari.effectopedia.core.objects.Link_ChemStructToMIE;
import org.qsari.effectopedia.core.objects.Link_EffectToEffect;
import org.qsari.effectopedia.core.objects.Method_InSilicoGlobalModel;
import org.qsari.effectopedia.core.objects.SubstanceData_InSilico;
import org.qsari.effectopedia.core.objects.TestResponseMapping;
import org.qsari.effectopedia.core.objects.Test_InSilico;
import org.qsari.effectopedia.data.DataSource;
import org.qsari.effectopedia.data.objects.DataUnit;
import org.qsari.effectopedia.data.objects.DataValue_Double;
import org.qsari.effectopedia.data.objects.DataValue_String;
import org.qsari.effectopedia.data.objects.DescriptorType;
import org.qsari.effectopedia.data.objects.ObjectProperties;
import org.qsari.effectopedia.data.objects.ObjectPropertyMultivalued_Documented;
import org.qsari.effectopedia.data.objects.ObjectPropertyType;
import org.qsari.effectopedia.data.objects.Resource;
import org.qsari.effectopedia.data.quantification.DataTemplates;
import org.qsari.effectopedia.defaults.DefaultDataTemplates;
import org.qsari.effectopedia.defaults.DefaultEffectopediaObjects;
import org.qsari.effectopedia.system.ActionTypes;

public class ModelTester extends SourceGeneratedPathway
	{
		
		public ModelTester(DataSource dataSource)
			{
				super("In-silico Model Tester Pathway Fragment", "in-silico model", dataSource, "D://Java//org.qsari.effectopedia//test//ModelTester");
			}

		public ModelTester(DataSource dataSource, boolean store)
			{
				super("In-silico Model Tester Pathway Fragment", "in-silico model", dataSource, "D://Java//org.qsari.effectopedia//test//ModelTester", store);
			}

		// revision 1
		protected Initiator_ChemicalStructure					chemical1;
		protected Effect_MolecularInitiatingEvent	mie1;
		protected Effect_DownstreamEffect									cellular_effect1;
		protected Test_InSilico																			mie1test1;
		protected Test_InSilico																			mie1test2;
		protected Test_InSilico																			mie1test3;
		protected Test_InSilico																			mie1test4;
		protected Method_InSilicoGlobalModel						gm1;
		protected Method_InSilicoGlobalModel						gm2;
		protected Method_InSilicoGlobalModel						gm3;
		protected Method_InSilicoGlobalModel						gm4;
		@Override
		public void generateContent()
			{
				genreateRevision1();
				storeRevision();
			}
			
		public void genreateRevision1()
			{
				
				chemical1 = new Initiator_ChemicalStructure(pathway, dataSource);
				chemical1.setTitle("Amylaniline");
				chemical1.getStructure2DImage().setValue("https://app.effectopedia.org/media/chem/amylaniline.png");
				chemical1.getIdentification().setPropertyValue(0, "33228443");
				chemical1.getIdentification().setPropertyValue(1, "4-n-Amylaniline");
				chemical1.getIdentification().setPropertyValue(2, "NC1=CC=C(C=C1)CCCCC");
				chemical1.getIdentification().setPropertyValue(3, "InChI=1S/C11H17N/c1-2-3-4-5-10-6-8-11(12)9-7-10/h6-9H,2-5,12H2,1H3");
				chemical1.getIdentification().setPropertyValue(4, "DGFTWBUZRHAHTH-UHFFFAOYSA-N");
				chemical1.getIdentification().setPropertyValue(6, "C11H17N");
				chemical1.getProperties().setPropertyValue(0, "163.2594");
				
				mie1 = new Effect_MolecularInitiatingEvent(pathway, dataSource);
				mie1.setTitle("mie1");
				mie1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				new Link_ChemStructToMIE(pathway, dataSource, chemical1, mie1);
				
				cellular_effect1 = new Effect_DownstreamEffect(pathway, dataSource);
				cellular_effect1.setTitle("ke1");
				cellular_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "cellular");
				cellular_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				new Link_EffectToEffect(pathway, dataSource, mie1, cellular_effect1);
				
				mie1test1 = new Test_InSilico(pathway, dataSource);
				mie1test1.setTitle("Linear Matlab Model");
				mie1test1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie1test1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				mie1test2 = new Test_InSilico(pathway, dataSource);
				mie1test2.setTitle("Linear Java Model");
				mie1test2.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie1test2.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				mie1test3 = new Test_InSilico(pathway, dataSource);
				mie1test3.setTitle("Linear R Model");
				mie1test3.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie1test3.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				mie1test4 = new Test_InSilico(pathway, dataSource);
				mie1test4.setTitle("R - Dose Response Model");
				mie1test4.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie1test4.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				new TestResponseMapping(pathway, dataSource, mie1test1, mie1);
				new TestResponseMapping(pathway, dataSource, mie1test2, mie1);
				new TestResponseMapping(pathway, dataSource, mie1test3, mie1);
				new TestResponseMapping(pathway, dataSource, mie1test4, mie1);
				
				gm1 = new Method_InSilicoGlobalModel(pathway, dataSource);
				gm1.setTitle("Global Linear Matlab Model");
				
				DescriptionSection sum = new DescriptionSection(gm1, dataSource, "Linear Model",
						" Simple linear model defined by two parameters slope and the intercept which can be used to estimate an average rate of change. </html>")
								.<DescriptionSection> makeItLive();
				sum.setFormat(ContentFormat.HTML);
				gm1.getDescriptionIDs().set(sum, 0);
				gm1.getModelCallers().add(mie1test1);
				mie1test1.getGlobalModelIDs().add(gm1);

				ObjectProperties modelParameters = gm1.getModelParamaters();
				DescriptorType dt1 = new DescriptorType("StDev", "Standard Deviation", DataValue_String.class, null).makeItLive();
				DescriptorType dt2 = new DescriptorType("SEM", "Standard Error of Mean", DataValue_String.class, null).makeItLive();
				ObjectPropertyType optLin1 = new ObjectPropertyType("V.1.5", "Intercept", "Intercept", null, Method_InSilicoGlobalModel.class,
						"Interseption defines the y value when x is equal to 0 (the point of interseption of the line with the vertical axis)", DataValue_Double.class, new DataUnit("kg"), ActionTypes.GM_PARAMETER).makeDocumented(null).makeItLive();
				optLin1.getDescriptors().add(dt1);
				optLin1.getDescriptors().add(dt2);
				ObjectPropertyMultivalued_Documented op1 = new ObjectPropertyMultivalued_Documented(gm1, optLin1);
				String[][] values = new String[][]
					{
					{ "0", "-10", "10", null, "0.04", null, "0.01", null, "",	null } };
				op1.assign(values);
				modelParameters.add(op1);
				
				ObjectPropertyType optLin2 = new ObjectPropertyType("V.1.6", "Slope", "Slope", null, Method_InSilicoGlobalModel.class, "Defines the steepnes of the line",
						DataValue_Double.class, null, ActionTypes.GM_PARAMETER).makeDocumented(null).makeItLive();
				optLin2.getDescriptors().add(dt1);
				optLin2.getDescriptors().add(dt2);
				ObjectPropertyMultivalued_Documented op2 = new ObjectPropertyMultivalued_Documented(gm1, optLin2);
				values = new String[][]
					{
					{ "1.0", "-10", "10", null, "0.04", null, "0.01", null, "",null } };
				op2.assign(values);
				modelParameters.add(op2);
				
				ObjectProperties modelMetaData = gm1.getModelMetadata();
				modelMetaData.getProperty(DefaultEffectopediaObjects.DEFAULT_GM_LICENSE).setValue("General Public License (GPL V 3.0)");
				modelMetaData.getProperty(DefaultEffectopediaObjects.DEFAULT_GM_VERSION).setValue("1.0");
				modelMetaData.getProperty(DefaultEffectopediaObjects.DEFAULT_GM_CITATION).setValue("http://www.purplemath.com/modules/strtlneq.htm");
				ObjectProperties sysReq = modelMetaData.getProperty(DefaultEffectopediaObjects.DEFAULT_GM_SYS_REQUIREMENTS).getValueAndUnit().getSubProperties();
				sysReq.getProperty(DefaultEffectopediaObjects.DEFAULT_GM_SYS_REQ_CMD_LINE_OPT).setValue("none");
				sysReq.getProperty(DefaultEffectopediaObjects.DEFAULT_GM_SYS_REQ_EST_RUNTIME).setValue("milliseconds");
				sysReq.getProperty(DefaultEffectopediaObjects.DEFAULT_GM_SYS_REQ_LIBRARIES).setValue("no additional libraries required");
				sysReq.getProperty(DefaultEffectopediaObjects.DEFAULT_GM_SYS_REQ_OS).setValue("Windows, Linux, Mac OS");
				sysReq.getProperty(DefaultEffectopediaObjects.DEFAULT_GM_SYS_REQ_PROG_LANGUAGE).setValue("Matlab");
				sysReq.getProperty(DefaultEffectopediaObjects.DEFAULT_GM_SYS_REQ_PROG_OPT).setValue("default");
				
				IDs<Resource> gm1resources = DefaultEffectopediaObjects.DEFAULT_MATLAB_RECOURCE_IDS.clone(gm1, gm1.getDataSource());
				gm1resources.getCachedObject(0).makeItLive();
				gm1resources.getCachedObject(1).setContent(
						"function model()\n"
						+ " global INPUT MODPAR OUTPUT\n"
						+ "\n"
						+ " OUTPUT.Tested_Subst_Log_Conc_Response_chemical_concentration = INPUT.Tested_Subst_Measured_Log_Conc;\n"
						+ " OUTPUT.Tested_Subst_Log_Conc_Response = zeros(size(OUTPUT.Tested_Subst_Log_Conc_Response_chemical_concentration));\n"
						+ " OUTPUT.Tested_Subst_Log_Conc_Response = MODPAR.Slope*INPUT.Tested_Subst_Measured_Log_Conc+MODPAR.Intercept;\n"
						+ " OUTPUT.Tested_Subst_Log_Conc_Response_stdiv_error = [];\n"
						+ " OUTPUT.Tested_Subst_Log_Conc_Response_sem_error = [];\n"
						+ " OUTPUT.Tested_Subst_Log_Conc_Response_ci95_error = [];\n"
						+ " OUTPUT.Tested_Subst_Log_Conc_Response_median = [];\n"
						+ "end\n");
				gm1.setResources(gm1resources);
				
				SubstanceData_InSilico subst_data1s = new SubstanceData_InSilico(mie1test1, chemical1, dataSource);
				ObjectProperties inputProp = subst_data1s.getLocalModelInputProperties();
				ObjectPropertyMultivalued_Documented chemConc = (ObjectPropertyMultivalued_Documented) inputProp.getProperty("Tested_Subst_Measured_Log_Conc");
				/*
				 * Value Min Max Unit, DEFAULT_TIME, Unit DEFAULT_LOG_MOL_NOM_CONCENTRATION,
				 * Unit DEFAULT_STDEV_ERROR, Unit DEFAULT_SEM_ERROR, Unit
				 * DEFAULT_CI95_ERROR, Unit DEFAULT_MEDIAN_VALUE, Unit DEFAULT_REPET_COUNT,
				 * Unit
				 */
				String[][] cValues = new String[][]
					{
					{ "-10", "-10.1", "-9.9", "logM", "0", "s", "-10", "logM", "", "", "0.1", "logM", "", "", "", "", "3", "", "", "" },
					{ "-9", "-9.1", "-8.9", "logM", "0", "s", "-9", "logM", "", "", "0.1", "logM", "", "", "", "", "3", "", "", "" },
					{ "-8", "-8.1", "-7.9", "logM", "0", "s", "-8", "logM", "", "", "0.1", "logM", "", "", "", "", "3", "", "", "" },
					{ "-7", "-7.1", "-6.9", "logM", "0", "s", "-7", "logM", "", "", "0.1", "logM", "", "", "", "", "3", "", "", "" },
					{ "-6", "-6.1", "-5.9", "logM", "0", "s", "-6", "logM", "", "", "0.1", "logM", "", "", "", "", "3", "", "", "" },
					{ "-5", "-5.1", "-4.9", "logM", "0", "s", "-5", "logM", "", "", "0.1", "logM", "", "", "", "", "3", "", "", "" },
					{ "-4", "-4.1", "-3.9", "logM", "0", "s", "-4", "logM", "", "", "0.1", "logM", "", "", "", "", "3", "", "", "" },
					{ "-3", "-3.1", "-2.9", "logM", "0", "s", "-3", "logM", "", "", "0.1", "logM", "", "", "", "", "3", "", "", "" },
					{ "-2", "-2.1", "-1.9", "logM", "0", "s", "-2", "logM", "", "", "0.1", "logM", "", "", "", "", "3", "", "", "" },
					{ "-1", "-1.1", "-0.9", "logM", "0", "s", "-1", "logM", "", "", "0.1", "logM", "", "", "", "", "3", "", "", "" } };
				chemConc.assign(cValues);
			
				gm2 = new Method_InSilicoGlobalModel(pathway, dataSource);
				gm2.setTitle("Global Linear Java Model");
				
				sum = new DescriptionSection(gm2, dataSource, "Linear Model",
						" Simple linear model defined by two parameters slope and the intercept which can be used to estimate an average rate of change. </html>")
								.<DescriptionSection> makeItLive();
				sum.setFormat(ContentFormat.HTML);
				gm2.getDescriptionIDs().set(sum, 0);
				gm2.getModelCallers().add(mie1test2);
				mie1test2.getGlobalModelIDs().add(gm2);

				modelParameters = gm2.getModelParamaters();
				op1 = new ObjectPropertyMultivalued_Documented(gm2, optLin1);
				values = new String[][]
					{
					{ "0", "-10", "10", null, "0.04", null, "0.01", null, "",	null } };
				op1.assign(values);
				modelParameters.add(op1);
				
				op2 = new ObjectPropertyMultivalued_Documented(gm2, optLin2);
				values = new String[][]
					{
					{ "1.0", "-10", "10", null, "0.04", null, "0.01", null, "",null } };
				op2.assign(values);
				modelParameters.add(op2);

				modelMetaData = gm2.getModelMetadata();
				modelMetaData.getProperty(DefaultEffectopediaObjects.DEFAULT_GM_LICENSE).setValue("General Public License (GPL V 3.0)");
				modelMetaData.getProperty(DefaultEffectopediaObjects.DEFAULT_GM_VERSION).setValue("1.0");
				modelMetaData.getProperty(DefaultEffectopediaObjects.DEFAULT_GM_CITATION).setValue("http://www.purplemath.com/modules/strtlneq.htm");
				sysReq = modelMetaData.getProperty(DefaultEffectopediaObjects.DEFAULT_GM_SYS_REQUIREMENTS).getValueAndUnit().getSubProperties();
				sysReq.getProperty(DefaultEffectopediaObjects.DEFAULT_GM_SYS_REQ_CMD_LINE_OPT).setValue("none");
				sysReq.getProperty(DefaultEffectopediaObjects.DEFAULT_GM_SYS_REQ_EST_RUNTIME).setValue("milliseconds");
				sysReq.getProperty(DefaultEffectopediaObjects.DEFAULT_GM_SYS_REQ_LIBRARIES).setValue("Java SDK 1.8");
				sysReq.getProperty(DefaultEffectopediaObjects.DEFAULT_GM_SYS_REQ_OS).setValue("Windows, Linux, Mac OS");
				sysReq.getProperty(DefaultEffectopediaObjects.DEFAULT_GM_SYS_REQ_PROG_LANGUAGE).setValue("Java");
				sysReq.getProperty(DefaultEffectopediaObjects.DEFAULT_GM_SYS_REQ_PROG_OPT).setValue("default");
				
				IDs<Resource> gm2resources = DefaultEffectopediaObjects.DEFAULT_JAVA_RECOURCE_IDS.clone(gm2, gm2.getDataSource());
				gm2resources.getCachedObject(0).makeItLive();
				gm2resources.getCachedObject(0).setName("JavaExecutableModel");
				gm2resources.getCachedObject(0).setContent("import java.io.PrintStream;\n"+
				"import java.util.ArrayList;\n"+
				"\n"+
				"import org.qsari.effectopedia.base.EffectopediaObject;\n"+
				"import org.qsari.effectopedia.core.modelling.ExecutableModel;\n"+
				"import org.qsari.effectopedia.core.modelling.ExecutionProgressListener;\n"+
				"\n"+
				"import org.qsari.effectopedia.data.objects.Descriptor;\n"+
				"import org.qsari.effectopedia.data.objects.DescriptorType;\n"+
				"import org.qsari.effectopedia.data.objects.ObjectProperties;\n"+
				"import org.qsari.effectopedia.data.objects.ObjectProperty;\n"+
				"import org.qsari.effectopedia.data.objects.ObjectProperty.ValueAndUnit;\n"+
				"import org.qsari.effectopedia.data.objects.ObjectPropertyMultivalued;\n"+
				"import org.qsari.effectopedia.data.objects.ObjectPropertyMultivalued_Documented;\n"+
				"import org.qsari.effectopedia.data.objects.ObjectPropertyMultivalued_Documented.Documented_Value;\n"+
				"import org.qsari.effectopedia.data.objects.ObjectPropertyType;\n"+
				"\n"+
				"/**\n"+
				" * <code>JavaExecutableModel</code> is free source code part of Effectopedia\n"+
				" * software: you can redistribute it and/or modify it under the terms of the GNU\n"+
				" * General Public License as published by the Free Software Foundation, either\n"+
				" * version 3 of the License, or (at your option) any later version.\n"+
				" *\n"+
				" * This program is distributed in the hope that it will be useful, but WITHOUT\n"+
				" * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS\n"+
				" * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more\n"+
				" * details.\n"+
				" *\n"+
				" * <p>\n"+
				" * <code>JavaExecutableModel</code> is a minimalistic implementation of the\n"+
				" * <code>ExecutableModel<code> interface which allows Effectopedia to execute models written\n"+
				" * in Java. Effectopedia needs Java SE Development Kit 7 (JDK) or later\n"+
				" * installed on the local machine in order to compile and execute this source\n"+
				" * code. You can istall JDK form <a\n"+
				" * href=\"http://www.oracle.com/technetwork/java/javase/downloads/index.html\"\n"+
				" * >here</a> For successful compilation you will also need\n"+
				" * <code>effectopedia.jar</code> which is either the file you are currently\n"+
				" * running or is supplied in the same directory as with your effectopedia.exe.\n"+
				" * In both cases Effectopedia should detect the location and pass it as a\n"+
				" * -classpath option to the java compiler.\n"+
				" * </p>\n"+
				" *\n"+
				" * @author <a href=\"mailto:hristo.aladjov@effectopedia.org\">Hristo Aladjov</a>\n"+
				" * @version 1.0\n"+
				" */\n"+
				"public class JavaExecutableModel implements ExecutableModel\n"+
				" {\n"+
				"  \n"+
				"  /**\n"+
				"   * The <code>execute</code> method performs the execution of this model. It\n"+
				"   * uses the supplied model parameters to calculate the model output based on\n"+
				"   * the model input. All method parameters and return result are represented\n"+
				"   * using the same self describing data structure <code>ObjectProperties</code>\n"+
				"   * . Please refer to <code>printObjectPropertys</code> to get better\n"+
				"   * understanding on how to use this structure.\n"+
				"   *\n"+
				"   * @param input\n"+
				"   *         The input data of the model represented as a list of object\n"+
				"   *         proeprties.\n"+
				"   * @param modelParameters\n"+
				"   *         The list of parameters of the model to be executed. This list is\n"+
				"   *         usually defined in the global in-silco model (\n"+
				"   *         <code>Method_InSilicoGlobalModel</code> class). The local values of\n"+
				"   *         the parameters can be modified in the Effectopedia interface (using\n"+
				"   *         sliders and drop down lists) and stored for each individual\n"+
				"   *         tested/predicted substance or\n"+
				"   * @param output\n"+
				"   *         The output data of the model represented as a list of object\n"+
				"   *         proeprties. In this particular implementation the output is a clone\n"+
				"   *         of the input (i.e. no data transformation is made)\n"+
				"   * @return execute <code>true</code> if the execution of the model was\n"+
				"   *         successful and <code>false</code> otherwise.\n"+
				"   * @see ObjectProperties\n"+
				"   * @see printObjectProperties\n"+
				"   * @since 1.0\n"+
				"   */\n"+
				"  @Override\n"+
				"  public boolean execute(ObjectProperties input, ObjectProperties modelParameters, ObjectProperties output)\n"+
				"   {\n"+
				"    fireExecutionProgressMade(0);\n"+
				"    console.println(\"Executing Model for:\");\n"+
				"    printObjectPropertys(input, \"I. Input\");\n"+
				"    printObjectPropertys(modelParameters, \"II. Model Parameters\");\n"+
				"    console.println(input.getProperty(0).getClass().getName());\n"+
				"    ObjectPropertyMultivalued_Documented inputChemConc = (ObjectPropertyMultivalued_Documented) input.getProperty(0);\n"+
				"    ObjectPropertyMultivalued_Documented outputResponse = (ObjectPropertyMultivalued_Documented) output.getProperty(0);\n"+
				"    int cnt = inputChemConc.valuesCount();\n"+
				"    // Verify it the output properties are properly initialized\n"+
				"    if (outputResponse.valuesCount() != cnt)\n"+
				"     {\n"+
				"      outputResponse.clearValuePairs();\n"+
				"      outputResponse.add(cnt);\n"+
				"     }\n"+
				"    // Calculate linear response\n"+
				"    Double slope = modelParameters.getProperty(\"Slope\").getValue().getAsDouble();\n"+
				"    Double intercept = modelParameters.getProperty(\"Intercept\").getValue().getAsDouble();\n"+
				"    int progress = 0;\n"+
				"    int progressStep = (cnt>0)?Math.round(100/cnt):100;\n"+
				"    for (int i = cnt - 1; i >= 0; i--)\n"+
				"     {\n"+
				"      Double x = inputChemConc.getValueAndUnitPair(i).getDoubleValue();\n"+
				"      Double y = slope*x+intercept;\n"+
				"      Documented_Value outputVal = outputResponse.getValueAndUnitPair(i); \n"+
				"      outputVal.setDoubleValue(y);\n"+
				"      outputVal.getDescriptor(1).setFromDouble(x);\n"+
				"      progress += progressStep;\n"+
				"      fireExecutionProgressMade(progress);\n"+
				"     }\n"+
				"    fireExecutionProgressMade(100);\n"+
				"    return true;\n"+
				"   }\n"+
				"  \n"+
				"  /**\n"+
				"   * Add a new <code>ExecutionProgressListener</code> to the list of listeners.\n"+
				"   * This allows Effectopedia interface to show the progress of the execution in\n"+
				"   * a progress bar.\n"+
				"   *\n"+
				"   * @param listener\n"+
				"   *         The <code>ExecutionProgressListener</code> to be added\n"+
				"   * @see ExecutionProgressListener\n"+
				"   * @since 1.0\n"+
				"   */\n"+
				"  @Override\n"+
				"  public void addExecutionProgressListener(ExecutionProgressListener listener)\n"+
				"   {\n"+
				"    listeners.add(listener);\n"+
				"   }\n"+
				"  \n"+
				"  /**\n"+
				"   * Remove a <code>ExecutionProgressListener</code> from the list of listeners.\n"+
				"   *\n"+
				"   * @param listener\n"+
				"   *         The <code>ExecutionProgressListener</code> to be removed\n"+
				"   * @see ExecutionProgressListener\n"+
				"   * @since 1.0\n"+
				"   */\n"+
				"  @Override\n"+
				"  public void removeExecutionProgressListener(ExecutionProgressListener listener)\n"+
				"   {\n"+
				"    listeners.remove(listener);\n"+
				"   }\n"+
				"  \n"+
				"  /**\n"+
				"   * Notifies all <code>ExecutionProgressListener</code> from the list for the\n"+
				"   * progress made.\n"+
				"   *\n"+
				"   * @param percentComplete\n"+
				"   *         The <code>percentComplete</code> is an integer number between 0 and\n"+
				"   *         100 which represents the progress of the model execution.\n"+
				"   * @see ExecutionProgressListener\n"+
				"   * @since 1.0\n"+
				"   */\n"+
				"  public void fireExecutionProgressMade(int percentComplete)\n"+
				"   {\n"+
				"    for (ExecutionProgressListener l : listeners)\n"+
				"     l.onProgress(percentComplete);\n"+
				"   }\n"+
				"  \n"+
				"  /**\n"+
				"   * Set the output print stream for this model. Effectopedia uses this method\n"+
				"   * to display all model messages in a console component. If method is called\n"+
				"   * with null argument then the output is reset to the default System.out\n"+
				"   * stream.\n"+
				"   *\n"+
				"   * @param percentComplete\n"+
				"   *         The <code>percentComplete</code> is an integer number between 0 and\n"+
				"   *         100 which represents the progress of the model execution.\n"+
				"   * @see ExecutionProgressListener\n"+
				"   * @since 1.0\n"+
				"   */\n"+
				"  public void setConsole(PrintStream console)\n"+
				"   {\n"+
				"    this.console = (console == null) ? System.out : console;\n"+
				"   }\n"+
				"  \n"+
				"  /**\n"+
				"   * Helper method not required by the <code>ExecutableModel</code> interface\n"+
				"   * which can be used to display the values of the object properties in the\n"+
				"   * print stream of the model to display all model.\n"+
				"   *\n"+
				"   * @param properties\n"+
				"   *         The <code>ObjectProperties</code> to be printed.\n"+
				"   * @param name\n"+
				"   *         Display name of the object property to be printed.\n"+
				"   * @see PrintStream\n"+
				"   * @since 1.0\n"+
				"   */\n"+
				"  public void printObjectPropertys(ObjectProperties properties, String name)\n"+
				"   {\n"+
				"    if (properties != null)\n"+
				"     {\n"+
				"      /**\n"+
				"       * <code>ObjectProperties</code> contains a reference to an\n"+
				"       * <code>ObjectPropertyTypeContainer</code> class which defines the\n"+
				"       * structure of this list of properties. This class is a list of\n"+
				"       * <code>ObjectPropertyType</code> objects which describe the individual\n"+
				"       * properties contained in the list.\n"+
				"       */\n"+
				"      this.console.println(name + \" (\" + properties.getTypes().size() + \")\");\n"+
				"      // Iterate over the contained ObjectProperties\n"+
				"      StringBuilder sb = new StringBuilder();\n"+
				"      for (ObjectProperty op : properties.getProperties())\n"+
				"       {\n"+
				"        // Get the type of the current object property - op\n"+
				"        ObjectPropertyType type = (ObjectPropertyType) op.getType();\n"+
				"        \n"+
				"        // Object property name\n"+
				"        sb.append(type.getName());\n"+
				"        // Object property type description\n"+
				"        sb.append(\" has the following description \");\n"+
				"        sb.append(type.getDescription());\n"+
				"        \n"+
				"        // Object property name\n"+
				"        sb.append(type.getName());\n"+
				"        // Check if the object property can contain multiple values.\n"+
				"        if (type.isAcceptingMultipleValues())\n"+
				"         // The op instance is of ObjectProperty type\n"+
				"         sb.append(\" can not contain multiple values.\\n\");\n"+
				"        else if (type.isDocumented())\n"+
				"         // The op instance is of ObjectProperty_Multivalued type\n"+
				"         sb.append(\" can contain multiple documented values.\\n\");\n"+
				"        else\n"+
				"         // The op instance is of ObjectPropertyMultivalued_Documented type\n"+
				"         sb.append(\" can contain multiple values.\\n\");\n"+
				"        \n"+
				"        sb.append(type.getName());\n"+
				"        sb.append(\" can contain data from type \");\n"+
				"        // The data type of the op value\n"+
				"        sb.append(type.getBaseValueType().getName());\n"+
				"        if (type.getFixedValuesList() != null)\n"+
				"         {\n"+
				"          sb.append(\" only from the following list of possible values: \");\n"+
				"          sb.append(type.getFixedValuesList().toString());\n"+
				"         }\n"+
				"        if (type.getDefaultUnit() != null)\n"+
				"         {\n"+
				"          sb.append(\" with the default data units of:\");\n"+
				"          sb.append(type.getDisplayUnit());\n"+
				"         }\n"+
				"        sb.append(\"\\n\");\n"+
				"        \n"+
				"        // Object property type can have zero or more additional descriptors\n"+
				"        if (type.getDescriptors().size() > 0)\n"+
				"         {\n"+
				"          sb.append(type.getName());\n"+
				"          sb.append(\" has \");\n"+
				"          sb.append(type.getDescriptors().size());\n"+
				"          sb.append(\" additional descriptor(s).These descriptors are:\\n\");\n"+
				"          \n"+
				"          for (DescriptorType descrType : type.getDescriptors().getAll())\n"+
				"           {\n"+
				"            // Descriptor types name\n"+
				"            sb.append(\"  \");\n"+
				"            sb.append(descrType.getName());\n"+
				"            sb.append(\" has the following description:\");\n"+
				"            // Descriptor types description\n"+
				"            sb.append(descrType.getDescription());\n"+
				"            sb.append(\" has values from type:\");\n"+
				"            sb.append(descrType.getBaseValueType().getName());\n"+
				"            if (descrType.getFixedValuesList() != null)\n"+
				"             {\n"+
				"              sb.append(\" and can have values only from the following list: \");\n"+
				"              sb.append(descrType.getFixedValuesList().toString());\n"+
				"             }\n"+
				"            if (descrType.getDefaultUnit() != null)\n"+
				"             {\n"+
				"              sb.append(\" with the default data units of:\");\n"+
				"              sb.append(descrType.getDisplayUnit());\n"+
				"             }\n"+
				"            sb.append(\"\\n\");\n"+
				"           }\n"+
				"         }\n"+
				"        \n"+
				"        printObjectPtopertyValues(op, sb);\n"+
				"        // Object properties can be hierarchical and contain list of sub\n"+
				"        // properties.Use the same method recursivly to display their structure\n"+
				"        // and values\n"+
				"        printObjectPropertys(op.getValueAndUnit().getSubProperties(), name + \".sub_properties\");\n"+
				"       }\n"+
				"      console.println(sb.toString());\n"+
				"     }\n"+
				"    else\n"+
				"     console.println(\"null\");\n"+
				"   }\n"+
				"  \n"+
				"  protected void printObjectPtopertyValues(ObjectProperty objectProperty, StringBuilder sb)\n"+
				"   {\n"+
				"    if (objectProperty instanceof ObjectPropertyMultivalued_Documented)\n"+
				"     {\n"+
				"      for (Documented_Value value : ((ObjectPropertyMultivalued_Documented) objectProperty).getValuePairs())\n"+
				"       {\n"+
				"        sb.append(objectProperty.getType().getName());\n"+
				"        sb.append(\" has the following value: \");\n"+
				"        sb.append(value.getDisplayValue());\n"+
				"        sb.append(value.getDisplayUnit());\n"+
				"        sb.append(\" and range [ \");\n"+
				"        sb.append(value.getDisplayMinValue());\n"+
				"        sb.append(value.getDisplayUnit());\n"+
				"        sb.append(\", \");\n"+
				"        sb.append(value.getDisplayMinValue());\n"+
				"        sb.append(value.getDisplayUnit());\n"+
				"        sb.append(\"] \");\n"+
				"        sb.append(\" descriptors: [\");\n"+
				"        for (Descriptor descriptor : value.getDescriptors())\n"+
				"         {\n"+
				"          sb.append(descriptor.getType().getName());\n"+
				"          sb.append(\": \");\n"+
				"          sb.append(descriptor.getDisplayValue());\n"+
				"          sb.append(descriptor.getDisplayUnit());\n"+
				"          sb.append(\" \");\n"+
				"         }\n"+
				"        sb.append(\"]\");\n"+
				"        \n"+
				"        sb.append(\" notes: \");\n"+
				"        sb.append(value.getNotes());\n"+
				"        \n"+
				"        sb.append(\" references: \");\n"+
				"        sb.append(value.getReferences());\n"+
				"        sb.append(value.getDisplayUnit());\n"+
				"        sb.append(\"\\n\");\n"+
				"       }\n"+
				"     }\n"+
				"    else if (objectProperty instanceof ObjectPropertyMultivalued)\n"+
				"     {\n"+
				"      for (ValueAndUnit value : ((ObjectPropertyMultivalued) objectProperty).getValuePairs())\n"+
				"       {\n"+
				"        sb.append(\"value: \");\n"+
				"        sb.append(value.getDisplayValue());\n"+
				"        sb.append(value.getDisplayUnit());\n"+
				"        sb.append(\"\\n\");\n"+
				"       }\n"+
				"     }\n"+
				"    else\n"+
				"     {\n"+
				"      sb.append(\"value: \");\n"+
				"      sb.append(objectProperty.getDisplayValue());\n"+
				"      sb.append(objectProperty.getDisplayUnit());\n"+
				"      sb.append(\"\\n\");\n"+
				"     }\n"+
				"   }\n"+
				"  \n"+
				"  protected PrintStream                          console   = System.out;\n"+
				"  protected ArrayList<ExecutionProgressListener> listeners = new ArrayList<ExecutionProgressListener>();\n"+
				" }\n"

);
				gm2.setResources(gm2resources);
				
				subst_data1s = new SubstanceData_InSilico(mie1test2, chemical1, dataSource);
				inputProp = subst_data1s.getLocalModelInputProperties();
				chemConc = (ObjectPropertyMultivalued_Documented) inputProp.getProperty("Tested_Subst_Measured_Log_Conc");
				/*
				 * Value Min Max Unit, DEFAULT_TIME, Unit DEFAULT_LOG_MOL_NOM_CONCENTRATION,
				 * Unit DEFAULT_STDEV_ERROR, Unit DEFAULT_SEM_ERROR, Unit
				 * DEFAULT_CI95_ERROR, Unit DEFAULT_MEDIAN_VALUE, Unit DEFAULT_REPET_COUNT,
				 * Unit
				 */
				cValues = new String[][]
					{
					{ "-10", "-10.1", "-9.9", "logM", "0", "s", "-10", "logM", "", "", "0.1", "logM", "", "", "", "", "3", "", "", "" },
					{ "-9", "-9.1", "-8.9", "logM", "0", "s", "-9", "logM", "", "", "0.1", "logM", "", "", "", "", "3", "", "", "" },
					{ "-8", "-8.1", "-7.9", "logM", "0", "s", "-8", "logM", "", "", "0.1", "logM", "", "", "", "", "3", "", "", "" },
					{ "-7", "-7.1", "-6.9", "logM", "0", "s", "-7", "logM", "", "", "0.1", "logM", "", "", "", "", "3", "", "", "" },
					{ "-6", "-6.1", "-5.9", "logM", "0", "s", "-6", "logM", "", "", "0.1", "logM", "", "", "", "", "3", "", "", "" },
					{ "-5", "-5.1", "-4.9", "logM", "0", "s", "-5", "logM", "", "", "0.1", "logM", "", "", "", "", "3", "", "", "" },
					{ "-4", "-4.1", "-3.9", "logM", "0", "s", "-4", "logM", "", "", "0.1", "logM", "", "", "", "", "3", "", "", "" },
					{ "-3", "-3.1", "-2.9", "logM", "0", "s", "-3", "logM", "", "", "0.1", "logM", "", "", "", "", "3", "", "", "" },
					{ "-2", "-2.1", "-1.9", "logM", "0", "s", "-2", "logM", "", "", "0.1", "logM", "", "", "", "", "3", "", "", "" },
					{ "-1", "-1.1", "-0.9", "logM", "0", "s", "-1", "logM", "", "", "0.1", "logM", "", "", "", "", "3", "", "", "" } };
				chemConc.assign(cValues);
				
				
				gm3 = new Method_InSilicoGlobalModel(pathway, dataSource);
				gm3.setTitle("Global Linear R Model");
				
				sum = new DescriptionSection(gm1, dataSource, "Linear Model",
						" Simple linear model defined by two parameters slope and the intercept which can be used to estimate an average rate of change. </html>")
								.<DescriptionSection> makeItLive();
				sum.setFormat(ContentFormat.HTML);
				gm3.getDescriptionIDs().set(sum, 0);
				gm3.getModelCallers().add(mie1test3);
				mie1test3.getGlobalModelIDs().add(gm3);

				modelParameters = gm3.getModelParamaters();
				op1 = new ObjectPropertyMultivalued_Documented(gm3, optLin1);
				values = new String[][]
					{
					{ "0", "-10", "10", null, "0.04", null, "0.01", null, "",	null } };
				op1.assign(values);
				modelParameters.add(op1);
				
				op2 = new ObjectPropertyMultivalued_Documented(gm3, optLin2);
				values = new String[][]
					{
					{ "1.0", "-10", "10", null, "0.04", null, "0.01", null, "",null } };
				op2.assign(values);
				modelParameters.add(op2);

				modelMetaData = gm3.getModelMetadata();
				modelMetaData.getProperty(DefaultEffectopediaObjects.DEFAULT_GM_LICENSE).setValue("General Public License (GPL V 3.0)");
				modelMetaData.getProperty(DefaultEffectopediaObjects.DEFAULT_GM_VERSION).setValue("1.0");
				modelMetaData.getProperty(DefaultEffectopediaObjects.DEFAULT_GM_CITATION).setValue("http://www.purplemath.com/modules/strtlneq.htm");
				sysReq = modelMetaData.getProperty(DefaultEffectopediaObjects.DEFAULT_GM_SYS_REQUIREMENTS).getValueAndUnit().getSubProperties();
				sysReq.getProperty(DefaultEffectopediaObjects.DEFAULT_GM_SYS_REQ_CMD_LINE_OPT).setValue("none");
				sysReq.getProperty(DefaultEffectopediaObjects.DEFAULT_GM_SYS_REQ_EST_RUNTIME).setValue("milliseconds");
				sysReq.getProperty(DefaultEffectopediaObjects.DEFAULT_GM_SYS_REQ_LIBRARIES).setValue("R, rJava");
				sysReq.getProperty(DefaultEffectopediaObjects.DEFAULT_GM_SYS_REQ_OS).setValue("Windows, Linux, Mac OS");
				sysReq.getProperty(DefaultEffectopediaObjects.DEFAULT_GM_SYS_REQ_PROG_LANGUAGE).setValue("R");
				sysReq.getProperty(DefaultEffectopediaObjects.DEFAULT_GM_SYS_REQ_PROG_OPT).setValue("default");
				
				IDs<Resource> gm3resources = DefaultEffectopediaObjects.DEFAULT_R_RECOURCE_IDS.clone(gm3, gm3.getDataSource());
				gm3resources.getCachedObject(0).makeItLive();
				gm3resources.getCachedObject(1).setContent(
						"OUTPUT$Tested_Subst_Log_Conc_Response_chemical_concentration <- INPUT$Tested_Subst_Measured_Log_Conc\n"
						+ "OUTPUT$Tested_Subst_Log_Conc_Response = rep(0, length(INPUT$Tested_Subst_Measured_Log_Conc))\n"
						+ "OUTPUT$Tested_Subst_Log_Conc_Response = MODPAR$Slope*INPUT$Tested_Subst_Measured_Log_Conc+MODPAR$Intercept;\n"
						+ "OUTPUT$Tested_Subst_Log_Conc_Response_stdiv_error = c();\n"
						+ "OUTPUT$Tested_Subst_Log_Conc_Response_sem_error = c();\n"
						+ "OUTPUT$Tested_Subst_Log_Conc_Response_ci95_error = c();\n"
						+ "OUTPUT$Tested_Subst_Log_Conc_Response_median = c();\n");
				gm3.setResources(gm3resources);
				
				subst_data1s = new SubstanceData_InSilico(mie1test3, chemical1, dataSource);
				inputProp = subst_data1s.getLocalModelInputProperties();
				chemConc = (ObjectPropertyMultivalued_Documented) inputProp.getProperty("Tested_Subst_Measured_Log_Conc");
				/*
				 * Value Min Max Unit, DEFAULT_TIME, Unit DEFAULT_LOG_MOL_NOM_CONCENTRATION,
				 * Unit DEFAULT_STDEV_ERROR, Unit DEFAULT_SEM_ERROR, Unit
				 * DEFAULT_CI95_ERROR, Unit DEFAULT_MEDIAN_VALUE, Unit DEFAULT_REPET_COUNT,
				 * Unit
				 */
				cValues = new String[][]
					{
					{ "-10", "-10.1", "-9.9", "logM", "0", "s", "-10", "logM", "", "", "0.1", "logM", "", "", "", "", "3", "", "", "" },
					{ "-9", "-9.1", "-8.9", "logM", "0", "s", "-9", "logM", "", "", "0.1", "logM", "", "", "", "", "3", "", "", "" },
					{ "-8", "-8.1", "-7.9", "logM", "0", "s", "-8", "logM", "", "", "0.1", "logM", "", "", "", "", "3", "", "", "" },
					{ "-7", "-7.1", "-6.9", "logM", "0", "s", "-7", "logM", "", "", "0.1", "logM", "", "", "", "", "3", "", "", "" },
					{ "-6", "-6.1", "-5.9", "logM", "0", "s", "-6", "logM", "", "", "0.1", "logM", "", "", "", "", "3", "", "", "" },
					{ "-5", "-5.1", "-4.9", "logM", "0", "s", "-5", "logM", "", "", "0.1", "logM", "", "", "", "", "3", "", "", "" },
					{ "-4", "-4.1", "-3.9", "logM", "0", "s", "-4", "logM", "", "", "0.1", "logM", "", "", "", "", "3", "", "", "" },
					{ "-3", "-3.1", "-2.9", "logM", "0", "s", "-3", "logM", "", "", "0.1", "logM", "", "", "", "", "3", "", "", "" },
					{ "-2", "-2.1", "-1.9", "logM", "0", "s", "-2", "logM", "", "", "0.1", "logM", "", "", "", "", "3", "", "", "" },
					{ "-1", "-1.1", "-0.9", "logM", "0", "s", "-1", "logM", "", "", "0.1", "logM", "", "", "", "", "3", "", "", "" } };
				chemConc.assign(cValues);

				
				
				gm4 = new Method_InSilicoGlobalModel(pathway, dataSource);
				gm4.setTitle("Global R Dose-Reposne Model");
				
				sum = new DescriptionSection(gm1, dataSource, " R Dose-Reposne Model",
						"Stimulation dose response (four parameters)\n"
						+ "Y = minResp + (maxResp-minResp)/(1+10^((logEC50-x)*HillSlope))\n"
						+ "where Y is the response\n"
						+ "x is the log10 dose or concentration\n"
						+ "minResp is the lowest value of the Y response\n"
						+ "maxResp is the plateaus of the Y response\n"
						+ "logEC50 is the log10 of  half maximal effective concentration (in the same units as x)\n"
						+ "HillSlope Hill slope factor (unitless)\n"
						+ "param[minResp,maxResp,logEC50,HillSlope]\n")
								.<DescriptionSection> makeItLive();
				sum.setFormat(ContentFormat.TEXT);
				gm4.getDescriptionIDs().set(sum, 0);
				gm4.getModelCallers().add(mie1test4);
				mie1test4.getGlobalModelIDs().add(gm4);

				
			 modelParameters = gm4.getModelParamaters();
				ObjectPropertyType opt1 = new ObjectPropertyType("V.1.1", "HillSlope", "HillSlope", null, Method_InSilicoGlobalModel.class,
						"Hill slope factor defines the steepnes and the curveture of the function", DataValue_Double.class, new DataUnit("kg"), ActionTypes.GM_PARAMETER).makeDocumented(null).makeItLive();
				opt1.getDescriptors().add(dt1);
				opt1.getDescriptors().add(dt2);
				op1 = new ObjectPropertyMultivalued_Documented(gm4, opt1);
				values = new String[][]
					{
					{ "0.8", "-10", "10", null, "0.04", null, "0.01", null, "",
					"Hill, A. V. (1910-01-22). \"The possible effects of the aggregation of the molecules of hæmoglobin on its dissociation curves\". J. Physiol. 40 (Suppl): iv–vii. doi:10.1113/jphysiol.1910.sp001386." } };
				op1.assign(values);
				modelParameters.add(op1);
				
				ObjectPropertyType opt2 = new ObjectPropertyType("V.1.2", "logEC50", "logEC50", null, Method_InSilicoGlobalModel.class, "logEC50 is the log10 of the half maximal effective concentration",
						DataValue_Double.class, new DataUnit("l"), ActionTypes.GM_PARAMETER).makeDocumented(null).makeItLive();
				opt2.getDescriptors().add(dt1);
				opt2.getDescriptors().add(dt2);
				op2 = new ObjectPropertyMultivalued_Documented(gm4, opt2);
				values = new String[][]
					{
					{ "-5", "-10", "-1", null, "0.04", null, "0.01", null, "",
					"Hill, A. V. (1910-01-22). \"The possible effects of the aggregation of the molecules of hæmoglobin on its dissociation curves\". J. Physiol. 40 (Suppl): iv–vii. doi:10.1113/jphysiol.1910.sp001386." } };
				op2.assign(values);
				modelParameters.add(op2);
				
				ObjectPropertyType opt3 = new ObjectPropertyType("V.1.3", "maxResp", "maxResp", null, Method_InSilicoGlobalModel.class, "Highest asymtotic value of the response", DataValue_Double.class,
						new DataUnit("%"), ActionTypes.GM_PARAMETER).makeDocumented(null).makeItLive();
				opt3.getDescriptors().add(dt1);
				opt3.getDescriptors().add(dt2);
				ObjectPropertyMultivalued_Documented op3 = new ObjectPropertyMultivalued_Documented(gm4, opt3);
				values = new String[][]
					{
					{ "100", "0", "100", "%", "0.4", null, "0.1", null, "",
					"Hill, A. V. (1910-01-22). \"The possible effects of the aggregation of the molecules of hæmoglobin on its dissociation curves\". J. Physiol. 40 (Suppl): iv–vii. doi:10.1113/jphysiol.1910.sp001386." } };
				op3.assign(values);
				modelParameters.add(op3);
				
				ObjectPropertyType opt4 = new ObjectPropertyType("V.1.4", "minResp", "minResp", null, Method_InSilicoGlobalModel.class, "Lowest asymtotic value of the response", DataValue_Double.class,
						new DataUnit("%"), ActionTypes.GM_PARAMETER).makeDocumented(null).makeItLive();
				opt4.getDescriptors().add(dt1);
				opt4.getDescriptors().add(dt2);
				ObjectPropertyMultivalued_Documented op4 = new ObjectPropertyMultivalued_Documented(gm4, opt4);
				values = new String[][]
					{
					{ "0", "0", "10", "%", "0.4", null, "0.1", null, "",
					"Hill, A. V. (1910-01-22). \"The possible effects of the aggregation of the molecules of hæmoglobin on its dissociation curves\". J. Physiol. 40 (Suppl): iv–vii. doi:10.1113/jphysiol.1910.sp001386." } };
				op4.assign(values);
				modelParameters.add(op4);
				
				modelMetaData = gm4.getModelMetadata();
				modelMetaData.getProperty(DefaultEffectopediaObjects.DEFAULT_GM_LICENSE).setValue("General Public License (GPL V 3.0)");
				modelMetaData.getProperty(DefaultEffectopediaObjects.DEFAULT_GM_VERSION).setValue("1.0");
				modelMetaData.getProperty(DefaultEffectopediaObjects.DEFAULT_GM_CITATION).setValue(
						"Hill, A. V. (1910-01-22). \"The possible effects of the aggregation of the molecules of hæmoglobin on its dissociation curves\". J. Physiol. 40 (Suppl): iv–vii. doi:10.1113/jphysiol.1910.sp001386.");
				sysReq = modelMetaData.getProperty(DefaultEffectopediaObjects.DEFAULT_GM_SYS_REQUIREMENTS).getValueAndUnit().getSubProperties();
				sysReq.getProperty(DefaultEffectopediaObjects.DEFAULT_GM_SYS_REQ_CMD_LINE_OPT).setValue("none");
				sysReq.getProperty(DefaultEffectopediaObjects.DEFAULT_GM_SYS_REQ_EST_RUNTIME).setValue("milliseconds");
				sysReq.getProperty(DefaultEffectopediaObjects.DEFAULT_GM_SYS_REQ_LIBRARIES).setValue("rJava");
				sysReq.getProperty(DefaultEffectopediaObjects.DEFAULT_GM_SYS_REQ_OS).setValue("Windows, Linux, Mac OS");
				sysReq.getProperty(DefaultEffectopediaObjects.DEFAULT_GM_SYS_REQ_PROG_LANGUAGE).setValue("R");
				sysReq.getProperty(DefaultEffectopediaObjects.DEFAULT_GM_SYS_REQ_PROG_OPT).setValue("default");
				
				IDs<Resource> gm4resources = DefaultEffectopediaObjects.DEFAULT_R_RECOURCE_IDS.clone(gm4, gm4.getDataSource());
				gm4resources.getCachedObject(0).makeItLive();
				gm4resources.getCachedObject(1).setContent(
						"OUTPUT$Tested_Subst_Log_Conc_Response_chemical_concentration <- INPUT$Tested_Subst_Measured_Log_Conc\n"
						+ "OUTPUT$Tested_Subst_Log_Conc_Response = rep(0, length(INPUT$Tested_Subst_Measured_Log_Conc))\n"
						+ "OUTPUT$Tested_Subst_Log_Conc_Response <- MODPAR$minResp + (MODPAR$maxResp-MODPAR$minResp) /(1+10^((MODPAR$logEC50-INPUT$Tested_Subst_Measured_Log_Conc)*MODPAR$HillSlope));\n"
						+ "OUTPUT$Tested_Subst_Log_Conc_Response_stdiv_error = c();\n"
						+ "OUTPUT$Tested_Subst_Log_Conc_Response_sem_error = c();\n"
						+ "OUTPUT$Tested_Subst_Log_Conc_Response_ci95_error = c();\n"
						+ "OUTPUT$Tested_Subst_Log_Conc_Response_median = c();");
				gm4.setResources(gm4resources);
				
				subst_data1s = new SubstanceData_InSilico(mie1test4, chemical1, dataSource);
				inputProp = subst_data1s.getLocalModelInputProperties();
				chemConc = (ObjectPropertyMultivalued_Documented) inputProp.getProperty("Tested_Subst_Measured_Log_Conc");
				/*
				 * Value Min Max Unit, DEFAULT_TIME, Unit DEFAULT_LOG_MOL_NOM_CONCENTRATION,
				 * Unit DEFAULT_STDEV_ERROR, Unit DEFAULT_SEM_ERROR, Unit
				 * DEFAULT_CI95_ERROR, Unit DEFAULT_MEDIAN_VALUE, Unit DEFAULT_REPET_COUNT,
				 * Unit
				 */
				cValues = new String[][]
					{
					{ "-10", "-10.1", "-9.9", "logM", "0", "s", "-10", "logM", "", "", "0.1", "logM", "", "", "", "", "3", "", "", "" },
					{ "-9", "-9.1", "-8.9", "logM", "0", "s", "-9", "logM", "", "", "0.1", "logM", "", "", "", "", "3", "", "", "" },
					{ "-8", "-8.1", "-7.9", "logM", "0", "s", "-8", "logM", "", "", "0.1", "logM", "", "", "", "", "3", "", "", "" },
					{ "-7", "-7.1", "-6.9", "logM", "0", "s", "-7", "logM", "", "", "0.1", "logM", "", "", "", "", "3", "", "", "" },
					{ "-6", "-6.1", "-5.9", "logM", "0", "s", "-6", "logM", "", "", "0.1", "logM", "", "", "", "", "3", "", "", "" },
					{ "-5", "-5.1", "-4.9", "logM", "0", "s", "-5", "logM", "", "", "0.1", "logM", "", "", "", "", "3", "", "", "" },
					{ "-4", "-4.1", "-3.9", "logM", "0", "s", "-4", "logM", "", "", "0.1", "logM", "", "", "", "", "3", "", "", "" },
					{ "-3", "-3.1", "-2.9", "logM", "0", "s", "-3", "logM", "", "", "0.1", "logM", "", "", "", "", "3", "", "", "" },
					{ "-2", "-2.1", "-1.9", "logM", "0", "s", "-2", "logM", "", "", "0.1", "logM", "", "", "", "", "3", "", "", "" },
					{ "-1", "-1.1", "-0.9", "logM", "0", "s", "-1", "logM", "", "", "0.1", "logM", "", "", "", "", "3", "", "", "" } };
				chemConc.assign(cValues);
				
				ObjectProperties summary = DefaultEffectopediaObjects.DEFAULT_D_RESP_DATA.clone(chemical1, dataSource);
				DataTemplates templates = DefaultDataTemplates.DTS_DR_SINGLE_CHEM_MEAN_MIN_MAX.clone();
				templates.setChartTitle(mie1test4.getTitle());
				subst_data1s.setTemplates(templates);
				subst_data1s.setObjectProperties(summary);
				ObjectPropertyMultivalued_Documented testedSubst = (ObjectPropertyMultivalued_Documented) summary.getProperty("Tested_Subst_Log_Conc_Response");
				// mean min max unit chem conc. unit notes references
				String[][] drValues = new String[][]
					{
					{ "0.009999000099990002", "", "", "%", "", "", "-10", "logM", "", "", "0", "%", "", "", "", "", "1", "", "", "" },
					{ "0.06305594883398934", "", "", "%", "", "", "-9", "logM", "", "", "0", "%", "", "", "", "", "1", "", "", "" },
					{ "0.39652856191521973", "", "", "%", "", "", "-8", "logM", "", "", "0", "%", "", "", "", "", "1", "", "", "" },
					{ "2.4503367550335984", "", "", "%", "", "", "-7", "logM", "", "", "0", "%", "", "", "", "", "1", "", "", "" },
					{ "13.680688860320998", "", "", "%", "", "", "-6", "logM", "", "", "0", "%", "", "", "", "", "1", "", "", "" },
					{ "50.0", "", "", "%", "", "", "-5", "logM", "", "", "0", "%", "", "", "", "", "1", "", "", "" },
					{ "86.31931113967902", "", "", "%", "", "", "-4", "logM", "", "", "0", "%", "", "", "", "", "1", "", "", "" },
					{ "97.54966324496641", "", "", "%", "", "", "-3", "logM", "", "", "0", "%", "", "", "", "", "1", "", "", "" },
					{ "99.60347143808477", "", "", "%", "", "", "-2", "logM", "", "", "0", "%", "", "", "", "", "1", "", "", "" },
					{ "99.93694405116601	", "", "", "%", "", "", "-1", "logM", "", "", "0", "%", "", "", "", "", "1", "", "", "" } };
				testedSubst.assign(drValues);
				mie1test4.getSubstanceDataIDs().add(subst_data1s);
				
			}
			
	}
