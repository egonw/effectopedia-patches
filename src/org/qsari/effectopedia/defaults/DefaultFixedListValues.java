package org.qsari.effectopedia.defaults;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.qsari.effectopedia.base.io.BaseIO;
import org.qsari.effectopedia.base.io.BaseIOElement;
import org.qsari.effectopedia.base.io.Exportable;
import org.qsari.effectopedia.base.io.Importable;
import org.qsari.effectopedia.data.objects.FixedValuesList;
import org.qsari.effectopedia.data.objects.FixedValuesLists;
import org.qsari.effectopedia.data.objects.ValuesList;

public class DefaultFixedListValues extends HashMap<String, ValuesList> implements Importable, Exportable
	{
		/**
	 * 
	 */
		private static final long																		serialVersionUID	= 1L;
		public static final DefaultFixedListValues	INSTANCE									= new DefaultFixedListValues();
		
		private DefaultFixedListValues()
			{
				FixedValuesList taxonomy = newDefaultFixedValueList("DEFAULT_TAXONOMY_LIST", "Species,Genus,Family,Order,Class,Phylum,Kingdom,Domain,Life");
				newDefaultFixedValueLists("DEFAULT_TAXONOMY_LISTS", taxonomy);
				newDefaultFixedValueList("DEFAULT_LBO_LIST", "molecular,organelle,cellular,tissue,organ,organ system,individual,population,species,communities,ecosystem,biosphere");
				newDefaultFixedValueList("DEFAULT_LBO_LIST", "molecular,organelle,cellular,tissue,organ,organ system,individual,population,species,communities,ecosystem,biosphere");
				newDefaultFixedValueList("DEFAULT_SEX_LIST", "asexual,male,mixed,female,third gender,hermaphrodite,unspecified");
				newDefaultFixedValueList("DEFAULT_LIFE_STAGE_LIST", "zygote,cleavage,blastula,gastrula,segmentation,phyaryngula,hatching,adult, unknown");
				newDefaultFixedValueList("DEFAULT_EFFECT_TERM_LIST", "unknown,mixed,long-term,mid-term,short-term");
				newDefaultFixedValueList("DEFAULT_GENERATION_LIST", "unknown,(F3) third generation, (F2) second generation, (F1) first generation, (F0) parent generation, all");
				
				newDefaultFixedValueList("DEFAULT_SEARCHABLE_OBJECTS.Captions", "Chemical and Case Studies, Adverse Outcome Pathways, Molecular Initiating Events, Adverse Effects/(Key) Events, Hazard Assessment Endpoints");
				newDefaultFixedValueList("DEFAULT_SEARCHABLE_OBJECTS.SearchNames", "none, none, none, none, none");
				newDefaultFixedValueList("DEFAULT_SEARCHABLE_SUBSTANCE_FIELDS.Captions", "CAS, IUPAC Name, Smiles, Mol. Formula");
				newDefaultFixedValueList("DEFAULT_SEARCHABLE_SUBSTANCE_FIELDS.SearchNames", "cas, iupac_name, smiles, molecular_formula");
				newDefaultFixedValueList("DEFAULT_SEARCHABLE_DOCUMENTEDKNOWLDEGE_FIELDS.Captions", "Title, Keywords, Groups, Context");
				newDefaultFixedValueList("DEFAULT_SEARCHABLE_DOCUMENTEDKNOWLDEGE_FIELDS.SearchNames", "title, keywords, groups, none");
				newDefaultFixedValueList("DEFAULT_SEARCHABLE_PATHWAY_FIELDS.Captions", "Title, Keywords");
				newDefaultFixedValueList("DEFAULT_SEARCHABLE_PATHWAY_FIELDS.SearchNames", "title, keywords");
			 newDefaultFixedValueList("DEFAULT_SEARCHABLE_CATEGORY_Context.Captions", "Level of Biological Organization, Life Stage, Location, Taxonomy,Sex, Time to Effect Term,Time to Effect");
				newDefaultFixedValueList("DEFAULT_SEARCHABLE_CATEGORY_Context.SearchNames", "Level of Biological Organization, Life Stage, Location, Taxonomy,Gender, Time to Effect Term,Time to Effect");
				
			 newDefaultFixedValueList("DEFAULT_SEARCHABLE_CATEGORY_Taxonomy.Captions", "Species,Genus,Family,Order,Class,Phylum,Kingdom,Domain,Life");
			 newDefaultFixedValueList("DEFAULT_SEARCHABLE_CATEGORY_Taxonomy.SearchNames", "Species,Genus,Family,Order,Class,Phylum,Kingdom,Domain,Life");

				newDefaultFixedValueList("LBO_AXIS",
						"molecular,-,molecular,-,molecular,-,organelles,-,cells,-,tissues,-,organs,-,organ systems,-,organisms,-,population of species,-,species,-,communities,-,ecosystem,-,biosphere");
				
				newDefaultFixedValueList("EST_RUNTIME",
						"nanoseconds,milliseconds,seconds,minutes,hours,days,weeks");

				newDefaultFixedValueList("PROG_LANG",
						"Java, Matlab, R");

			}
		
		public FixedValuesList newDefaultFixedValueList(String name, String commaSepatratedString)
			{
				FixedValuesList f = new FixedValuesList(name, commaSepatratedString);
				put(name, f);
				return f;
			}
		
		public void newDefaultFixedValueLists(String name, FixedValuesList categories)
			{
				FixedValuesLists f = new FixedValuesLists(name, categories);
				put(name, f);
			}

		public void load(BaseIOElement element, BaseIO io)
			{
				if (element != null)
					{
						BaseIOElement e = element.getChild("DefaultFixedListValues");
						if (e != null)
							{
								int count = Integer.parseInt(e.getAttributeValue("count"));
								List<BaseIOElement> children = e.getChildren();
								if ((count != 0) && (children != null) && (children.size() == count))
									{
										clear();
										Iterator<BaseIOElement> iterator = children.iterator();
										while (iterator.hasNext())
											{
												BaseIOElement child = iterator.next();
												FixedValuesList f = new FixedValuesList();
												f.load(child, io);
												put(f.getName(), f);
											}
									}
							}
					}
			}
		
		public BaseIOElement store(BaseIOElement element, BaseIO io)
			{
				int count = size();
				BaseIOElement e = io.newElement("DefaultListValues");
				e.setAttribute("count", Integer.toString(count));
				if (count != 0)
					{
						Iterator<Map.Entry<String, ValuesList>> it = entrySet().iterator();
						while (it.hasNext())
							{
								BaseIOElement s = io.newElement("ValuesList");
								it.next().getValue().store(s, io);
								element.addChild(s);
							}
					}
				element.addChild(e);
				return element;
			}
		
		
		public String getCommaSeparatedList(String name)
			{
				ValuesList f = get(name);
				if (f != null)
					return f.toString();
				else
					return " ";
			}
		
		public ValuesList getList(String name)
			{
				ValuesList f = get(name);
				return f;
			}
		
		public long getListID(String name)
			{
				ValuesList f = get(name);
				if (f != null)
					return f.getID();
				else
					return -1L;
			}
		
		public long getListExternalID(String name)
			{
				ValuesList f = get(name);
				if (f != null)
					return f.getExternalID();
				else
					return -1L;
			}
		
	}
