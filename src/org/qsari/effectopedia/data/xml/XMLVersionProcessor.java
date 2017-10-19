package org.qsari.effectopedia.data.xml;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.qsari.effectopedia.core.ui.UserInterface;

public class XMLVersionProcessor
	{
		public static String preprocess(final String source)
			{
				int i = source.indexOf("<xml:format xml:version=");
				if (i == -1)
					return source;
				else
					{
						i += "<xml:format xml:version=".length();
						String ver = source.substring(i + 1, source.indexOf("\"", i + 1));
						double version = Double.parseDouble(ver);
						if (version < 0.961)
							{
								UserInterface.showWarning("The data source you are trying to load was generated from older version " + ver
										+ " of Effectopedia.\nSome elements might not load correctly.  Please check the content and save your data in the current format (" + XMLFileDS.VERSION + ").");
								if (version < 0.95)
									return pre_v945(source);
								else if (version < 0.96)
									return pre_v96(source);
								else
									return pre_v961(source);
							}
					}
				return source;
			}
		
		public static String pre_v945(final String source)
			{
				return substitute(pre_v96(source), substitutions_v945);
			}
		
		public static String pre_v96(final String source)
			{
				return substitute(pre_v961(source), substitutions_v96);
			}
		
		public static String pre_v961(final String source)
			{
				return substitute(source, substitutions_v961);
			}
		
		private static String substitute(final String source, Map<String, String> rules)
			{
				if (source == null || "".equals(source))
					return source;
				StringBuilder regexBuilder = new StringBuilder();
				Iterator<String> it = rules.keySet().iterator();
				regexBuilder.append(Pattern.quote(it.next()));
				while (it.hasNext())
					regexBuilder.append('|').append(Pattern.quote(it.next()));
				Matcher matcher = Pattern.compile(regexBuilder.toString()).matcher(source);
				StringBuffer result = new StringBuffer(source.length() + (source.length() / 10));
				while (matcher.find())
					matcher.appendReplacement(result, rules.get(matcher.group()));
				matcher.appendTail(result);
				return result.toString();
			}
		
		public static final Map<String, String>	substitutions_v945	= new HashMap<String, String>();
		static
			{
				substitutions_v945.put("org.qsari.effectopedia.core.objects.Substance_Chemical", "org.qsari.effectopedia.core.objects.Initiator_ChemicalStructure");
				substitutions_v945.put("org.qsari.effectopedia.core.objects.Substance_ReactiveChemical", "org.qsari.effectopedia.core.objects.Initiator_ChemicalStructure");
				substitutions_v945.put("org.qsari.effectopedia.core.objects.Link_SubstanceToMIE", "org.qsari.effectopedia.core.objects.Link_ChemStructToMIE");
				substitutions_v945.put("org.qsari.effectopedia.core.objects.Link_SubstanceToReactiveSubstance", "org.qsari.effectopedia.core.objects.Link_ChemStructToChemStruct");
				substitutions_v945.put("org.qsari.effectopedia.core.objects.Substance_StructuralAlerts", "org.qsari.effectopedia.core.objects.Initiator_StructuralAlerts");
				substitutions_v945.put("org.qsari.effectopedia.core.objects.Substance<", "org.qsari.effectopedia.core.objects.Initiator<");
				substitutions_v945.put("xml:Substance_StructuralAlerts", "xml:Initiator_StructuralAlerts");
				substitutions_v945.put("xml:Substance_BiologcalPerturbation", "xml:Initiator_BiologcalPerturbation");
				substitutions_v945.put("xml:Link_SubstanceToReactiveSubstance", "xml:Link_ChemStructToChemStruct");
				substitutions_v945.put("xml:Link_SubstanceToMIE", "xml:Link_ChemStructToMIE");
				substitutions_v945.put("xml:substance", "xml:structure");
				substitutions_v945.put("xml:reactive_substance", "xml:child_structure");
				substitutions_v945.put("xml:Substance_Chemical", "xml:Initiator_ChemicalStructure");
				substitutions_v945.put("xml:Substance_ReactiveChemical", "xml:Initiator_ChemicalStructure");
			}
		
		public static final Map<String, String>	substitutions_v96		= new HashMap<String, String>();
		static
			{
				substitutions_v96.put("xml:type=\"HYPOTHETICAL\"", "xml:nature=\"HYPOTHETICAL\"");
				substitutions_v96.put("xml:type=\"HARDWIRE\"", "xml:nature=\"HARDWIRE\"");
				substitutions_v96.put("xml:type=\"LINEAR\"", "xml:nature=\"LINEAR\"");
				substitutions_v96.put("xml:type=\"TRESHOLD\"", "xml:nature=\"THRESHOLD\"");
				substitutions_v96.put("xml:type=\"DOSE_RESPONSE\"", "xml:nature=\"DOSE_RESPONSE\"");
				substitutions_v96.put("xml:type=\"RESPONSE_RESPONSE\"", "xml:nature=\"RESPONSE_RESPONSE\"");
				substitutions_v96.put("xml:type=\"METABOLIC\"", "xml:nature=\"METABOLIC\"");
			}
		
		public static final Map<String, String>	substitutions_v961	= new HashMap<String, String>();
		static
			{
				substitutions_v961.put("defaultID=\"", "defaultID=\"-");
			}
	}
