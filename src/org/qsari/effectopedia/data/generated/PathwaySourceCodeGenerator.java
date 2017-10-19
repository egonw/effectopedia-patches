package org.qsari.effectopedia.data.generated;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.LinkedHashMap;

import org.qsari.effectopedia.base.ids.DescriptionIDs;
import org.qsari.effectopedia.base.ids.ReferenceIDW;
import org.qsari.effectopedia.base.ids.ReferenceIDs;
import org.qsari.effectopedia.core.object.elemets.Coordinate;
import org.qsari.effectopedia.core.object.elemets.EssetialityDescription;
import org.qsari.effectopedia.core.objects.ContextDimension;
import org.qsari.effectopedia.core.objects.DescriptionSection;
import org.qsari.effectopedia.core.objects.DescriptionSection_Structured;
import org.qsari.effectopedia.core.objects.DocumentedKnowledge_Located;
import org.qsari.effectopedia.core.objects.Effect;
import org.qsari.effectopedia.core.objects.Initiator_ChemicalStructure;
import org.qsari.effectopedia.core.objects.Link;
import org.qsari.effectopedia.core.objects.Link_ChemStructToChemStruct;
import org.qsari.effectopedia.core.objects.Link_ChemStructToMIE;
import org.qsari.effectopedia.core.objects.Link_EffectToEffect;
import org.qsari.effectopedia.core.objects.Pathway;
import org.qsari.effectopedia.core.objects.PathwayElement;
import org.qsari.effectopedia.core.objects.Reference;
import org.qsari.effectopedia.core.objects.Test;
import org.qsari.effectopedia.core.objects.TestResponseMapping;
import org.qsari.effectopedia.data.DataSource;
import org.qsari.effectopedia.defaults.DefaultEffectopediaObjects;
import org.qsari.effectopedia.system.TraceableClasses;

public class PathwaySourceCodeGenerator
	{
		public PathwaySourceCodeGenerator(DataSource dataSource, long pathwayID)
			{
				pathway = dataSource.getLiveIndices().getPathways().get(pathwayID);
				pathway.addMissingElements();
				if (pathway != null)
					{
						className = pathway.getTitle().replaceAll("/[^A-Za-z0-9]/", "_");
						fileName = DEFAULT_PATH + className;
					}
			}
			
		public void save(String sourceFileName)
			{
				try (PrintStream out = new PrintStream(new FileOutputStream(sourceFileName), false, "UTF-8"))
					{
						Path path = Paths.get(sourceFileName);
						className = path.getFileName().toString();
						int p = className.indexOf(".java");
						if (p != -1)
							className = className.substring(0, p);
						out.print(generate());
						out.flush();
						out.close();
					}
				catch (FileNotFoundException e)
					{
						e.printStackTrace();
					}
				catch (UnsupportedEncodingException e1)
					{
						e1.printStackTrace();
					}
			}
			
		public String generate()
			{
				sourceCode = new StringBuilder();
				sourceCode.append(SGP_PACKAGE);
				for (String imp : SGP_IMPORT)
					sourceCode.append(imp);
				sourceCode.append("\n");
				sourceCode.append("public class ");
				sourceCode.append(className);
				sourceCode.append("	extends SourceGeneratedPathway {\n");
				sourceCode.append("\n");
				generateConstructors();
				generateFields();
				generateContentMethod();
				generateRevisions(sourceCode);
				sourceCode.append("}\n");
				return sourceCode.toString();
			}
			
		private void generateConstructors()
			{
				sourceCode.append("public ");
				sourceCode.append(className);
				sourceCode.append("(DataSource dataSource) {\n");
				sourceCode.append("super(\"");
				sourceCode.append(pathway.getTitle());
				sourceCode.append("\",\"");
				sourceCode.append(pathway.getKeyWords());
				sourceCode.append("\",dataSource,\"");
				sourceCode.append(fileName);
				sourceCode.append("\");\n}\n");

				sourceCode.append("public ");
				sourceCode.append(className);
				sourceCode.append("(DataSource dataSource, boolean autoSave) {\n");
				sourceCode.append("super(\"");
				sourceCode.append(pathway.getTitle());
				sourceCode.append("\",\"");
				sourceCode.append(pathway.getKeyWords());
				sourceCode.append("\",dataSource,\"");
				sourceCode.append(fileName);
				sourceCode.append("\",autoSave);\n}\n");
}
			
		private void generateFields()
			{
				int cnt = 1;
				for (PathwayElement pe : pathway.getElements().getObjects())
					{
						String elementName = (TraceableClasses.REGISTERED.getIdentifier(pe.getClass()) + (cnt++)).toLowerCase();
						fieldNames.put(pe, elementName);
						sourceCode.append("protected ");
						sourceCode.append(pe.getClass().getSimpleName());
						sourceCode.append(" ");
						sourceCode.append(elementName);
						sourceCode.append(";//");
						sourceCode.append(pe.getID());
					 sourceCode.append("\n");
					}
			}
			
		private void generateContentMethod()
			{
				sourceCode.append(SGP_CONTENT_H);
				for (int i = 1; i <= revisionsCount; i++)
					{
						sourceCode.append("genreateRevision");
						sourceCode.append(i);
						sourceCode.append("();\nstoreRevision();\n");
					}
				sourceCode.append(SGP_CONTENT_F);
			}
			
		private void generateRevisions(StringBuilder sb)
			{
				for (int i = 1; i <= revisionsCount; i++)
					{
						sb.append("public void genreateRevision");
						sb.append(i);
						sb.append("() {\n");
						generateRevision(i, sb);
						sb.append("}\n");
					}
			}
			
		private void generateRevision(int revision, StringBuilder sb)
			{
				for (PathwayElement pe : pathway.getElements().getObjects())
					if (pe instanceof Initiator_ChemicalStructure)
						generateChemical((Initiator_ChemicalStructure) pe);
					else if (pe instanceof Effect)
						generateEffect((Effect) pe);
					else if (pe instanceof Test)
						generateTest((Test) pe);
				for (PathwayElement pe : pathway.getElements().getObjects())
					if (pe instanceof Link)
						generateLink((Link) pe);
					else if (pe instanceof TestResponseMapping)
						generateTRM((TestResponseMapping) pe);
				generatePathwayProperties();
				if (revision == 1)
					{
						sb.append("\n");
						sb.append("pathway.updateEssentiality();\n");
						sb.append("EssetialityDescription essentiality = pathway.getEssentiality();\n");
						sb.append("DescriptionSection_Structured dss;\n");
						generateDescription("pathway", pathway.getDescriptionIDs());
						generateEffectDescriptionIDsDS();
						generateReferences("pathway", pathway.getReferenceIDs());
					}
			}
			
		private static void appendMethodCall(String object, String method, String parameter, String closing, StringBuilder sb)
			{
				sb.append(object);
				sb.append(method);
				sb.append(parameter);
				sb.append(closing);
			}
			
		private void generateChemical(Initiator_ChemicalStructure structure)
			{
				String elementName = fieldNames.get(structure);
				sourceCode.append("\n");
				sourceCode.append(elementName);
				sourceCode.append(" = new Initiator_ChemicalStructure(pathway, dataSource);\n");
				appendMethodCall(elementName, ".setTitle(\"", structure.getTitle(), "\");\n", sourceCode);
				appendMethodCall(elementName, ".getStructure2DImage().setValue(\"", structure.getStructure2DImage().getDisplayValue(), "\");\n", sourceCode);
				for (int i = 0; i <= 6; i++)
					appendMethodCall(elementName, ".getIdentification().setPropertyValue(" + i + ",\"", structure.getIdentification().getPropertyValue(i), "\");\n", sourceCode);
				sourceCode.append(elementName);
				sourceCode.append(".setSynonymsList(new String[] {");
				boolean sybibymAdded = false;
				for (String synonym : structure.getSynonymsList())
					{
						if (sybibymAdded)
							sourceCode.append(", ");
						sourceCode.append("\"");
						sourceCode.append(synonym);
						sourceCode.append("\"");
						sybibymAdded = true;
					}
				sourceCode.append("});\n");
			}
			
		private void generateEffect(Effect effect)
			{
				String elementName = fieldNames.get(effect);
				sourceCode.append("\n");
				sourceCode.append(elementName);
				sourceCode.append(" = new ");
				sourceCode.append(effect.getClass().getSimpleName());
				sourceCode.append("(pathway, dataSource);\n");
				appendMethodCall(elementName, ".setTitle(\"", effect.getTitle(), "\");\n", sourceCode);
				generateLocation(elementName, effect);
				generateDescription(elementName, effect.getDescriptionIDs());
				generateReferences(elementName, effect.getReferenceIDs());
			}
			
		private void generateTest(Test test)
			{
				String elementName = fieldNames.get(test);
				sourceCode.append("\n");
				sourceCode.append(elementName);
				sourceCode.append(" = new ");
				sourceCode.append(test.getClass().getSimpleName());
				sourceCode.append("(pathway, dataSource);\n");
				appendMethodCall(elementName, ".setTitle(\"", test.getTitle(), "\");\n", sourceCode);
				generateLocation(elementName, test);
				generateDescription(elementName, test.getDescriptionIDs());
				generateReferences(elementName, test.getReferenceIDs());
			}
			
		private void generateLink(Link link)
			{
				String elementName = fieldNames.get(link);
				sourceCode.append("\n");
				sourceCode.append(elementName);
				String fromPE;
				String toPE;
				if (link instanceof Link_EffectToEffect)
					{
						fromPE = fieldNames.get(((Link_EffectToEffect) link).getFromEffect().getCachedObject());
						toPE = fieldNames.get(((Link_EffectToEffect) link).getToEffect().getCachedObject());
					}
				else if (link instanceof Link_ChemStructToMIE)
					{
						fromPE = fieldNames.get(((Link_ChemStructToMIE) link).getStructure().getCachedObject());
						toPE = fieldNames.get(((Link_ChemStructToMIE) link).getEffect().getCachedObject());
					}
				else if (link instanceof Link_ChemStructToChemStruct)
					{
						fromPE = fieldNames.get(((Link_ChemStructToChemStruct) link).getParentStructure().getCachedObject());
						toPE = fieldNames.get(((Link_ChemStructToChemStruct) link).getStructure().getCachedObject());
					}
				else
					{
						fromPE = "null";
						toPE = "null";
					}
				sourceCode.append(" = new ");
				sourceCode.append(link.getClass().getSimpleName());
				sourceCode.append("(pathway, dataSource,");
				sourceCode.append(fromPE);
				sourceCode.append(", ");
				sourceCode.append(toPE);
				sourceCode.append(");\n");
				sourceCode.append(elementName);
				sourceCode.append(".setLinkType(LinkType.");
				sourceCode.append(link.getLinkType().name());
				sourceCode.append(");");
				generateDescription(elementName, link.getDescriptionIDs());
				generateReferences(elementName, link.getReferenceIDs());
			}
			
		private void generateTRM(TestResponseMapping trm)
			{
				String elementName = fieldNames.get(trm);
				sourceCode.append("\n");
				sourceCode.append(elementName);
					{
						sourceCode.append(" = new TestResponseMapping(pathway, dataSource, ");
						sourceCode.append(fieldNames.get(trm.getTest().getCachedObject()));
						sourceCode.append(", ");
						sourceCode.append(fieldNames.get(trm.getEffect().getCachedObject()));
						sourceCode.append(");\n");
					}
				generateDescription(elementName, trm.getDescriptionIDs());
				generateReferences(elementName, trm.getReferenceIDs());
			}
			
		private void generateLocation(String elementName, DocumentedKnowledge_Located pe)
			{
				for (Coordinate coordinate : pe.getCoordinates().getCoordiantes())
					if (coordinate.getValue() != null)
						{
							sourceCode.append(elementName);
							sourceCode.append(".getCoordinates().setValue(DefaultEffectopediaObjects.");
							sourceCode.append(SGP_DIM_NAMES.get(coordinate.getDimension()));
							sourceCode.append(".DIMENSION_INDEX, \"");
							sourceCode.append(coordinate.getValue().getDisplayValue());
							sourceCode.append("\");\n");
						}
			}
			
		private void generateDescription(String elementName, DescriptionIDs description)
			{
				String elementClass = description.getParent().getClass().getSimpleName();
				DescriptionSection[] sections = description.getCachedObjects();
				for (int i = 0; i < sections.length; i++)
					{
						DescriptionSection section = sections[i];
						if (!section.isDefaultID())
							if (section instanceof DescriptionSection_Structured)
								{
									if (((DescriptionSection_Structured) section).getStructuredContent() instanceof ReferenceIDW)
										generateEssentialityDS(elementName, section, String.valueOf(i), elementClass);
								}
							else
								{
									sourceCode.append(elementName);
									sourceCode.append(".getDescriptionIDs().set(new DescriptionSection(");
									sourceCode.append(elementName);
									sourceCode.append(",dataSource,\"");
									sourceCode.append(section.getTitle());
									sourceCode.append("\",\"");
									sourceCode.append(section.getContent().replaceAll("[\\r\\n]+", NL).replaceAll("\\\"", DQ));
									sourceCode.append("\").setFormat(ContentFormat.");
									sourceCode.append(section.getFormat().name());
									sourceCode.append(").<DescriptionSection> makeItLive(), ");
									sourceCode.append(i);
									sourceCode.append(");\n");
								}
					}
			}
			
		private void generateEssentialityDS(String elementName, DescriptionSection section, String i, String elementClass)
			{
				sourceCode.append("ReferenceIDW<");
				sourceCode.append(elementClass);
				sourceCode.append("> ");
				sourceCode.append(elementName);
				sourceCode.append("_weigth");
				sourceCode.append(i);
				sourceCode.append("= new ReferenceIDW<");
				sourceCode.append(elementClass);
				sourceCode.append(">(");
				sourceCode.append(elementName);
				sourceCode.append(", dataSource, ");
				sourceCode.append(elementClass);
				sourceCode.append(".class,");
				sourceCode.append(((ReferenceIDW<?>) ((DescriptionSection_Structured) section).getStructuredContent()).getWeight());
				sourceCode.append(");\n");
				
				sourceCode.append(elementName);
				sourceCode.append(".getDescriptionIDs().set(new DescriptionSection_Structured(");
				sourceCode.append(elementName);
				sourceCode.append(",dataSource,\"");
				sourceCode.append(section.getTitle());
				sourceCode.append("\",\"");
				sourceCode.append(section.getContent().replaceAll("[\\r\\n]+", NL).replaceAll("\\\"", DQ));
				sourceCode.append("\", ");
				sourceCode.append(elementName);
				sourceCode.append("_weigth");
				sourceCode.append(i);
				sourceCode.append(").setFormat(ContentFormat.");
				sourceCode.append(section.getFormat().name());
				sourceCode.append(").<DescriptionSection_Structured> makeItLive(), ");
				sourceCode.append(i);
				sourceCode.append(");\n");
			}
			
		private void generateEffectDescriptionIDsDS()
			{
				EssetialityDescription essentiality = pathway.getEssentiality();
				if (essentiality != null)
					for (PathwayElement pe : pathway.getElements().getObjects())
						if (pe instanceof Effect)
							{
								String elementName = fieldNames.get(pe);
								DescriptionSection_Structured dss = essentiality.getEssentialityDescription(pe);
								sourceCode.append("dss = essentiality.getEssentialityDescription(");
								sourceCode.append(elementName);
								sourceCode.append(");\n");
								sourceCode.append("dss.setContent(\"");
								sourceCode.append(dss.getContent().replaceAll("[\\r\\n]+", NL).replaceAll("\\\"", DQ));
								sourceCode.append("\");\n");
								sourceCode.append("dss.setFormat(ContentFormat.");
								sourceCode.append(dss.getFormat().name());
								sourceCode.append(");\n");
								sourceCode.append("((ReferenceIDW<Link_EffectToEffect>) dss.getStructuredContent()).setWeight(");
								double weight = ((ReferenceIDW<Link_EffectToEffect>) dss.getStructuredContent()).getWeight();
								sourceCode.append(weight);
								sourceCode.append(");\n");
							}
			}
			
		private void generateReferences(String elementName, ReferenceIDs<Reference> references)
			{
				for (Reference reference : references.getCachedObjects())
					{
						if (!reference.isDefaultID())
							{
								sourceCode.append(elementName);
								sourceCode.append(".getReferenceIDs().add(new Reference(");
								sourceCode.append(elementName);
								sourceCode.append(",dataSource,\"");
								sourceCode.append(reference.getFormatedReference().replaceAll("\\\"", DQ));
								sourceCode.append("\").<Reference> makeItLive());\n");
							}
					}
			}
			
		private void generatePathwayProperties()
			{
				sourceCode.append("\n");
				if (pathway.getGroups().getDisplayValue() != null)
					{
						sourceCode.append("pathway.getGroups().parseString(\"");
						sourceCode.append(pathway.getGroups().toString());
						sourceCode.append("\");\n");
					}
					
				if (pathway.getUids().getDisplayValue() != null)
					{
						sourceCode.append("pathway.getUids().parseString(\"");
						sourceCode.append(pathway.getUids().toString());
						sourceCode.append("\");\n");
					}
					
				if (pathway.getStatus().getDisplayValue() != null)
					{
						sourceCode.append("pathway.getStatus().parseString(\"");
						sourceCode.append(pathway.getStatus().toString());
						sourceCode.append("\");\n");
					}
			}
			
		public static final String																												SGP_PACKAGE			= "package org.qsari.effectopedia.data.generated;\n";
		public static final String[]																										SGP_IMPORT				= new String[]
			{ "import org.qsari.effectopedia.core.objects.DescriptionSection;\n", "import org.qsari.effectopedia.core.objects.DescriptionSection.ContentFormat;\n",
			"import org.qsari.effectopedia.core.objects.DescriptionSection_Structured;\n", "import org.qsari.effectopedia.core.objects.Effect_AdverseOutcome;\n",
			"import org.qsari.effectopedia.core.objects.Effect_DownstreamEffect;\n", "import org.qsari.effectopedia.core.objects.Effect_Endpoint;\n",
			"import org.qsari.effectopedia.core.objects.Effect_MolecularInitiatingEvent;\n", "import org.qsari.effectopedia.core.objects.Initiator_ChemicalStructure;\n",
			"import org.qsari.effectopedia.core.objects.Link;\n", "import org.qsari.effectopedia.core.objects.Link_ChemStructToMIE;\n", "import org.qsari.effectopedia.core.objects.Link_EffectToEffect;\n",
			"import org.qsari.effectopedia.core.objects.Method_Investigation;\n", "import org.qsari.effectopedia.core.objects.Method_Study;\n", "import org.qsari.effectopedia.core.objects.Pathway;\n",
			"import org.qsari.effectopedia.core.objects.Reference;\n", "import org.qsari.effectopedia.core.objects.SubstanceData;\n", "import org.qsari.effectopedia.core.objects.TestResponseMapping;\n",
			"import org.qsari.effectopedia.core.objects.Test_InVitro;\n", "import org.qsari.effectopedia.core.objects.Test_InVivo;\n", "import org.qsari.effectopedia.core.objects.Test_ExVivo;\n",
			"import org.qsari.effectopedia.data.DataSource;\n", "import org.qsari.effectopedia.data.objects.ObjectProperties;\n",
			"import org.qsari.effectopedia.data.objects.ObjectPropertyMultivalued_Documented;\n", "import org.qsari.effectopedia.defaults.DefaultDataTemplates;\n",
			"import org.qsari.effectopedia.defaults.DefaultEffectopediaObjects;\n", "import org.qsari.effectopedia.system.User;\n", "import org.qsari.effectopedia.data.RevisionBasedDS;\n",
			"import org.qsari.effectopedia.core.objects.Link.LinkType;\n", "import org.qsari.effectopedia.base.ids.ReferenceIDW;\n",
			"import org.qsari.effectopedia.core.object.elemets.EssetialityDescription;\n" };
			
		public static final String																												SGP_CONTENT_H	= "@Override\npublic void generateContent()\n{";
		public static final String																												SGP_CONTENT_F	= "if (dataSource instanceof RevisionBasedDS)\n((RevisionBasedDS) dataSource).setLocation(pathway);\n}\n";
		public static final HashMap<ContextDimension, String>	SGP_DIM_NAMES	= new HashMap<ContextDimension, String>();
		static
			{
				SGP_DIM_NAMES.put(DefaultEffectopediaObjects.DEFAULT_LBO, "DEFAULT_LBO");
				SGP_DIM_NAMES.put(DefaultEffectopediaObjects.DEFAULT_LIFE_STAGE, "DEFAULT_LIFE_STAGE");
				SGP_DIM_NAMES.put(DefaultEffectopediaObjects.DEFAULT_BIO_COMPARTMENT, "DEFAULT_BIO_COMPARTMENT");
				SGP_DIM_NAMES.put(DefaultEffectopediaObjects.DEFAULT_TAXONOMY, "DEFAULT_TAXONOMY");
				SGP_DIM_NAMES.put(DefaultEffectopediaObjects.DEFAULT_SEX, "DEFAULT_SEX");
				SGP_DIM_NAMES.put(DefaultEffectopediaObjects.DEFAULT_TIME_TO_EFFECT, "DEFAULT_TIME_TO_EFFECT");
				SGP_DIM_NAMES.put(DefaultEffectopediaObjects.DEFAULT_EFFECT_TERM, "DEFAULT_EFFECT_TERM");
				SGP_DIM_NAMES.put(DefaultEffectopediaObjects.DEFAULT_OTHER, "DEFAULT_OTHER");
			}
			
		public final String																																			DEFAULT_PATH			= "D://Java//org.qsari.effectopedia//test//";
		public final String																																			NL													= java.util.regex.Matcher.quoteReplacement("\\n\\n");
		public final String																																			DQ													= java.util.regex.Matcher.quoteReplacement("\\\"");
		protected final LinkedHashMap<PathwayElement, String>	fieldNames					= new LinkedHashMap<PathwayElement, String>();
		protected Pathway																																					pathway;
		protected String																																						className						= "Generated";
		protected String																																						fileName							= "generated.aopz";
		protected int																																									revisionsCount	= 1;
		protected StringBuilder																															sourceCode;
	}
