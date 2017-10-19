package org.qsari.effectopedia.data.generated;

import org.qsari.effectopedia.base.ids.ReferenceIDW;
import org.qsari.effectopedia.core.object.elemets.EssetialityDescription;
import org.qsari.effectopedia.core.objects.DescriptionSection;
import org.qsari.effectopedia.core.objects.DescriptionSection.ContentFormat;
import org.qsari.effectopedia.core.objects.DescriptionSection_Structured;
import org.qsari.effectopedia.core.objects.Effect_AdverseOutcome;
import org.qsari.effectopedia.core.objects.Effect_DownstreamEffect;
import org.qsari.effectopedia.core.objects.Effect_MolecularInitiatingEvent;
import org.qsari.effectopedia.core.objects.Link.LinkType;
import org.qsari.effectopedia.core.objects.Link_EffectToEffect;
import org.qsari.effectopedia.data.DataSource;
import org.qsari.effectopedia.data.RevisionBasedDS;
import org.qsari.effectopedia.defaults.DefaultEffectopediaObjects;

public class AOP51 extends SourceGeneratedPathway
	{
		
		public AOP51(DataSource dataSource)
			{
				super("PPARα activation leading to impaired fertility in adult male rodents ", "", dataSource,
						"D://Java//org.qsari.effectopedia//test//PPARα activation leading to impaired fertility in adult male rodents ");
			}
			
		public AOP51(DataSource dataSource, boolean autoSave)
			{
				super("PPARα activation leading to impaired fertility in adult male rodents ", "", dataSource,
						"D://Java//org.qsari.effectopedia//test//PPARα activation leading to impaired fertility in adult male rodents ", autoSave);
			}
			
		protected Effect_MolecularInitiatingEvent	effect_molecularinitiatingevent1;// 7771
		protected Effect_AdverseOutcome											effect_adverseoutcome2;										// 7779
		protected Effect_DownstreamEffect									effect_downstreameffect3;								// 7788
		protected Effect_DownstreamEffect									effect_downstreameffect4;								// 7795
		protected Link_EffectToEffect													link_effecttoeffect5;												// 7802
		protected Effect_DownstreamEffect									effect_downstreameffect6;								// 7819
		protected Effect_DownstreamEffect									effect_downstreameffect7;								// 7826
		protected Link_EffectToEffect													link_effecttoeffect8;												// 7833
		protected Effect_DownstreamEffect									effect_downstreameffect9;								// 7848
		protected Link_EffectToEffect													link_effecttoeffect10;											// 7855
		protected Effect_DownstreamEffect									effect_downstreameffect11;							// 7870
		protected Link_EffectToEffect													link_effecttoeffect12;											// 7877
		protected Link_EffectToEffect													link_effecttoeffect13;											// 7892
		protected Link_EffectToEffect													link_effecttoeffect14;											// 7907
		
		@Override
		public void generateContent()
			{
				genreateRevision1();
				storeRevision();
				if (dataSource instanceof RevisionBasedDS)
					((RevisionBasedDS) dataSource).setLocation(pathway);
			}
			
		public void genreateRevision1()
			{
				
				effect_molecularinitiatingevent1 = dataSource.get(Effect_MolecularInitiatingEvent.class, 2);
				pathway.add(effect_molecularinitiatingevent1);
				
				effect_adverseoutcome2 = dataSource.get(Effect_AdverseOutcome.class, 7);
				pathway.add(effect_adverseoutcome2);
				
				effect_downstreameffect3 = new Effect_DownstreamEffect(pathway, dataSource);
				effect_downstreameffect3.setTitle("Increase proliferation, Leydig cell ");
				effect_downstreameffect3.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "cellular");
				effect_downstreameffect3.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_TAXONOMY.DIMENSION_INDEX, "Rattus norvegicus");
				effect_downstreameffect3.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "male");
				effect_downstreameffect3.getDescriptionIDs().set(new DescriptionSection(effect_downstreameffect3, dataSource, "Description", "").setFormat(ContentFormat.HTML).<DescriptionSection> makeItLive(),
						0);
				
				effect_downstreameffect4 = new Effect_DownstreamEffect(pathway, dataSource);
				effect_downstreameffect4.setTitle("Hyperplasia, Leydig cell");
				effect_downstreameffect4.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "organ");
				effect_downstreameffect4.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_TAXONOMY.DIMENSION_INDEX, "Rattus norvegicus");
				effect_downstreameffect4.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "male");
				effect_downstreameffect4.getDescriptionIDs().set(new DescriptionSection(effect_downstreameffect4, dataSource, "Description", "").setFormat(ContentFormat.HTML).<DescriptionSection> makeItLive(),
						0);
				
				effect_downstreameffect6 = dataSource.get(Effect_DownstreamEffect.class, 19);
				pathway.add(effect_downstreameffect6);
				
				effect_downstreameffect7 = dataSource.get(Effect_DownstreamEffect.class, 23);
				pathway.add(effect_downstreameffect7);
						
				effect_downstreameffect9 = dataSource.get(Effect_DownstreamEffect.class, 15);
				pathway.add(effect_downstreameffect9);
				
				effect_downstreameffect11 = new Effect_DownstreamEffect(pathway, dataSource);
				effect_downstreameffect11.setTitle("Increase, Luteinizing hormone (LH) ");
				effect_downstreameffect11.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "cellular");
				effect_downstreameffect11.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_TAXONOMY.DIMENSION_INDEX, "Rattus norvegicus");
				effect_downstreameffect11.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "male");
				effect_downstreameffect11.getDescriptionIDs().set(new DescriptionSection(effect_downstreameffect11, dataSource, "Description", "").setFormat(ContentFormat.HTML).<DescriptionSection> makeItLive(),
						0);
				
				link_effecttoeffect5 = new Link_EffectToEffect(pathway, dataSource, effect_downstreameffect3, effect_downstreameffect4);
				link_effecttoeffect5.setLinkType(LinkType.DIRECT);
				link_effecttoeffect5.getDescriptionIDs().set(new DescriptionSection(link_effecttoeffect5, dataSource, "Description", "").setFormat(ContentFormat.HTML).<DescriptionSection> makeItLive(), 0);
				ReferenceIDW<Link_EffectToEffect> link_effecttoeffect5_weigth1 = new ReferenceIDW<Link_EffectToEffect>(link_effecttoeffect5, dataSource, Link_EffectToEffect.class, 2.0);
				link_effecttoeffect5.getDescriptionIDs().set(new DescriptionSection_Structured(link_effecttoeffect5, dataSource, "(Key) Event Relationship Weight of Evidence", "", link_effecttoeffect5_weigth1)
						.setFormat(ContentFormat.HTML).<DescriptionSection_Structured> makeItLive(), 1);
				link_effecttoeffect5.getDescriptionIDs()
						.set(new DescriptionSection(link_effecttoeffect5, dataSource, "Evidence Supporting Taxonomic Applicability", "").setFormat(ContentFormat.HTML).<DescriptionSection> makeItLive(), 2);
				link_effecttoeffect5.getDescriptionIDs().set(new DescriptionSection(link_effecttoeffect5, dataSource, "Quantitative Understanding", "<p>Evidence support: Unspecified</p><p></p>")
						.setFormat(ContentFormat.HTML).<DescriptionSection> makeItLive(), 3);
				
				link_effecttoeffect8 = dataSource.get(Link_EffectToEffect.class, 46);
				pathway.add(link_effecttoeffect8);
				
				link_effecttoeffect10 =dataSource.get(Link_EffectToEffect.class, 57);
				pathway.add(link_effecttoeffect10);
				
				link_effecttoeffect12 = new Link_EffectToEffect(pathway, dataSource, effect_downstreameffect7, effect_downstreameffect11);
				link_effecttoeffect12.setLinkType(LinkType.INDIRECT);
				link_effecttoeffect12.getDescriptionIDs().set(new DescriptionSection(link_effecttoeffect12, dataSource, "Description", "").setFormat(ContentFormat.HTML).<DescriptionSection> makeItLive(), 0);
				ReferenceIDW<Link_EffectToEffect> link_effecttoeffect12_weigth1 = new ReferenceIDW<Link_EffectToEffect>(link_effecttoeffect12, dataSource, Link_EffectToEffect.class, 2.0);
				link_effecttoeffect12.getDescriptionIDs().set(new DescriptionSection_Structured(link_effecttoeffect12, dataSource, "(Key) Event Relationship Weight of Evidence", "", link_effecttoeffect12_weigth1)
						.setFormat(ContentFormat.HTML).<DescriptionSection_Structured> makeItLive(), 1);
				link_effecttoeffect12.getDescriptionIDs()
						.set(new DescriptionSection(link_effecttoeffect12, dataSource, "Evidence Supporting Taxonomic Applicability", "").setFormat(ContentFormat.HTML).<DescriptionSection> makeItLive(), 2);
				link_effecttoeffect12.getDescriptionIDs().set(new DescriptionSection(link_effecttoeffect12, dataSource, "Quantitative Understanding", "<p>Evidence support: Unspecified</p><p></p>")
						.setFormat(ContentFormat.HTML).<DescriptionSection> makeItLive(), 3);
				
				link_effecttoeffect13 = new Link_EffectToEffect(pathway, dataSource, effect_downstreameffect11, effect_downstreameffect3);
				link_effecttoeffect13.setLinkType(LinkType.INDIRECT);
				link_effecttoeffect13.getDescriptionIDs().set(new DescriptionSection(link_effecttoeffect13, dataSource, "Description", "").setFormat(ContentFormat.HTML).<DescriptionSection> makeItLive(), 0);
				ReferenceIDW<Link_EffectToEffect> link_effecttoeffect13_weigth1 = new ReferenceIDW<Link_EffectToEffect>(link_effecttoeffect13, dataSource, Link_EffectToEffect.class, 2.0);
				link_effecttoeffect13.getDescriptionIDs().set(new DescriptionSection_Structured(link_effecttoeffect13, dataSource, "(Key) Event Relationship Weight of Evidence", "", link_effecttoeffect13_weigth1)
						.setFormat(ContentFormat.HTML).<DescriptionSection_Structured> makeItLive(), 1);
				link_effecttoeffect13.getDescriptionIDs()
						.set(new DescriptionSection(link_effecttoeffect13, dataSource, "Evidence Supporting Taxonomic Applicability", "").setFormat(ContentFormat.HTML).<DescriptionSection> makeItLive(), 2);
				link_effecttoeffect13.getDescriptionIDs().set(new DescriptionSection(link_effecttoeffect13, dataSource, "Quantitative Understanding", "<p>Evidence support: Unspecified</p><p></p>")
						.setFormat(ContentFormat.HTML).<DescriptionSection> makeItLive(), 3);
				
				link_effecttoeffect14 = new Link_EffectToEffect(pathway, dataSource, effect_downstreameffect4, effect_adverseoutcome2);
				link_effecttoeffect14.setLinkType(LinkType.INDIRECT);
				link_effecttoeffect14.getDescriptionIDs().set(new DescriptionSection(link_effecttoeffect14, dataSource, "Description", "").setFormat(ContentFormat.HTML).<DescriptionSection> makeItLive(), 0);
				ReferenceIDW<Link_EffectToEffect> link_effecttoeffect14_weigth1 = new ReferenceIDW<Link_EffectToEffect>(link_effecttoeffect14, dataSource, Link_EffectToEffect.class, 2.0);
				link_effecttoeffect14.getDescriptionIDs().set(new DescriptionSection_Structured(link_effecttoeffect14, dataSource, "(Key) Event Relationship Weight of Evidence", "", link_effecttoeffect14_weigth1)
						.setFormat(ContentFormat.HTML).<DescriptionSection_Structured> makeItLive(), 1);
				link_effecttoeffect14.getDescriptionIDs()
						.set(new DescriptionSection(link_effecttoeffect14, dataSource, "Evidence Supporting Taxonomic Applicability", "").setFormat(ContentFormat.HTML).<DescriptionSection> makeItLive(), 2);
				link_effecttoeffect14.getDescriptionIDs().set(new DescriptionSection(link_effecttoeffect14, dataSource, "Quantitative Understanding", "<p>Evidence support: Unspecified</p><p></p>")
						.setFormat(ContentFormat.HTML).<DescriptionSection> makeItLive(), 3);
				
				pathway.getGroups().parseString("");
				pathway.getUids().parseString("SHORTNAME:PPAR and reproductive toxicity,");
				pathway.getStatus().parseString("OECD:Under Development,SAAOP:Included in OECD Work Plan,AOPWIKI:Under development: Not open for comment. Do not cite,");
				
				pathway.updateEssentiality();
				EssetialityDescription essentiality = pathway.getEssentiality();
				DescriptionSection_Structured dss;
				pathway.getDescriptionIDs().set(new DescriptionSection(pathway, dataSource, "Abstract", "").setFormat(ContentFormat.HTML).<DescriptionSection> makeItLive(), 0);
				pathway.getDescriptionIDs().set(new DescriptionSection(pathway, dataSource, "Quantitative Considerations", "").setFormat(ContentFormat.HTML).<DescriptionSection> makeItLive(), 3);
				pathway.getDescriptionIDs()
						.set(new DescriptionSection(pathway, dataSource, "Applicability of the AOP",
								"<ul><li><strong>Sexes</strong>:Male</li><li><strong>Life Stages</strong>:Adult, reproductively mature, Juvenile</li><li><strong>Taxonomies</strong>:Rattus norvegicus</li></ul>")
										.setFormat(ContentFormat.HTML).<DescriptionSection> makeItLive(),
								4);
				pathway.getDescriptionIDs().set(new DescriptionSection(pathway, dataSource, "Potential Applications of the AOP", "").setFormat(ContentFormat.HTML).<DescriptionSection> makeItLive(), 5);
				dss = essentiality.getEssentialityDescription(effect_molecularinitiatingevent1);
				dss.setContent("Section content");
				dss.setFormat(ContentFormat.TEXT);
				((ReferenceIDW<Link_EffectToEffect>) dss.getStructuredContent()).setWeight(1.0);
				dss = essentiality.getEssentialityDescription(effect_adverseoutcome2);
				dss.setContent("Section content");
				dss.setFormat(ContentFormat.TEXT);
				((ReferenceIDW<Link_EffectToEffect>) dss.getStructuredContent()).setWeight(0.0);
				dss = essentiality.getEssentialityDescription(effect_downstreameffect3);
				dss.setContent("Section content");
				dss.setFormat(ContentFormat.TEXT);
				((ReferenceIDW<Link_EffectToEffect>) dss.getStructuredContent()).setWeight(2.0);
				dss = essentiality.getEssentialityDescription(effect_downstreameffect4);
				dss.setContent("Section content");
				dss.setFormat(ContentFormat.TEXT);
				((ReferenceIDW<Link_EffectToEffect>) dss.getStructuredContent()).setWeight(2.0);
				dss = essentiality.getEssentialityDescription(effect_downstreameffect6);
				dss.setContent("Section content");
				dss.setFormat(ContentFormat.TEXT);
				((ReferenceIDW<Link_EffectToEffect>) dss.getStructuredContent()).setWeight(2.0);
				dss = essentiality.getEssentialityDescription(effect_downstreameffect7);
				dss.setContent("Section content");
				dss.setFormat(ContentFormat.TEXT);
				((ReferenceIDW<Link_EffectToEffect>) dss.getStructuredContent()).setWeight(2.0);
				dss = essentiality.getEssentialityDescription(effect_downstreameffect9);
				dss.setContent("Section content");
				dss.setFormat(ContentFormat.TEXT);
				((ReferenceIDW<Link_EffectToEffect>) dss.getStructuredContent()).setWeight(1.0);
				dss = essentiality.getEssentialityDescription(effect_downstreameffect11);
				dss.setContent("Section content");
				dss.setFormat(ContentFormat.TEXT);
				((ReferenceIDW<Link_EffectToEffect>) dss.getStructuredContent()).setWeight(2.0);
			}
	}
