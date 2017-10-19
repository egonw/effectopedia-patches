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

public class AOP64 extends SourceGeneratedPathway
	{
		
		public AOP64(DataSource dataSource)
			{
				super("Glucocorticoid Receptor (GR) Mediated Adult Leydig Cell Dysfunction Leading to Decreased Male Fertility", "", dataSource,
						"D://Java//org.qsari.effectopedia//test//Glucocorticoid Receptor (GR) Mediated Adult Leydig Cell Dysfunction Leading to Decreased Male Fertility");
			}
			
		public AOP64(DataSource dataSource, boolean autoSave)
			{
				super("Glucocorticoid Receptor (GR) Mediated Adult Leydig Cell Dysfunction Leading to Decreased Male Fertility", "", dataSource,
						"D://Java//org.qsari.effectopedia//test//Glucocorticoid Receptor (GR) Mediated Adult Leydig Cell Dysfunction Leading to Decreased Male Fertility", autoSave);
			}
			
		protected Effect_MolecularInitiatingEvent	effect_molecularinitiatingevent1;// 9962
		protected Effect_AdverseOutcome											effect_adverseoutcome2;										// 9970
		protected Effect_DownstreamEffect									effect_downstreameffect3;								// 9979
		protected Link_EffectToEffect													link_effecttoeffect4;												// 9986
		protected Effect_DownstreamEffect									effect_downstreameffect5;								// 10003
		protected Link_EffectToEffect													link_effecttoeffect6;												// 10010
		protected Effect_DownstreamEffect									effect_downstreameffect7;								// 10024
		protected Link_EffectToEffect													link_effecttoeffect8;												// 10031
		protected Effect_DownstreamEffect									effect_downstreameffect9;								// 10046
		protected Link_EffectToEffect													link_effecttoeffect10;											// 10053
		protected Effect_DownstreamEffect									effect_downstreameffect11;							// 10068
		protected Link_EffectToEffect													link_effecttoeffect12;											// 10075
		protected Link_EffectToEffect													link_effecttoeffect13;											// 10090
		
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
				
				effect_molecularinitiatingevent1 = new Effect_MolecularInitiatingEvent(pathway, dataSource);
				effect_molecularinitiatingevent1.setTitle("Glucocorticoid Receptor Agonist, Activation");
				effect_molecularinitiatingevent1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				effect_molecularinitiatingevent1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_TAXONOMY.DIMENSION_INDEX, "Rattus norvegicus");
				effect_molecularinitiatingevent1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "male");
				effect_molecularinitiatingevent1.getDescriptionIDs()
						.set(new DescriptionSection(effect_molecularinitiatingevent1, dataSource, "Description", "").setFormat(ContentFormat.HTML).<DescriptionSection> makeItLive(), 0);
				ReferenceIDW<Effect_MolecularInitiatingEvent> effect_molecularinitiatingevent1_weigth1 = new ReferenceIDW<Effect_MolecularInitiatingEvent>(effect_molecularinitiatingevent1, dataSource,
						Effect_MolecularInitiatingEvent.class, 0.0);
				
				effect_adverseoutcome2 = dataSource.get(Effect_AdverseOutcome.class, 7);
				pathway.add(effect_adverseoutcome2); 
						
				effect_downstreameffect3 = new Effect_DownstreamEffect(pathway, dataSource);
				effect_downstreameffect3.setTitle("Increased apoptosis, decreased number of adult Leydig Cells ");
				effect_downstreameffect3.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "cellular");
				effect_downstreameffect3.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_TAXONOMY.DIMENSION_INDEX, "Rattus norvegicus");
				effect_downstreameffect3.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "male");
				effect_downstreameffect3.getDescriptionIDs().set(new DescriptionSection(effect_downstreameffect3, dataSource, "Description", "").setFormat(ContentFormat.HTML).<DescriptionSection> makeItLive(),
						0);
				
				effect_downstreameffect5 = new Effect_DownstreamEffect(pathway, dataSource);
				effect_downstreameffect5.setTitle("Repressed expression of steroidogenic enzymes ");
				effect_downstreameffect5.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "cellular");
				effect_downstreameffect5.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_TAXONOMY.DIMENSION_INDEX, "Rattus norvegicus");
				effect_downstreameffect5.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "male");
				effect_downstreameffect5.getDescriptionIDs().set(new DescriptionSection(effect_downstreameffect5, dataSource, "Description", "").setFormat(ContentFormat.HTML).<DescriptionSection> makeItLive(),
						0);
				
				effect_downstreameffect7 = dataSource.get(Effect_DownstreamEffect.class, 19);
				pathway.add(effect_downstreameffect7);
				
				effect_downstreameffect9 =  dataSource.get(Effect_DownstreamEffect.class, 23);
				pathway.add(effect_downstreameffect9);
				
				effect_downstreameffect11 = new Effect_DownstreamEffect(pathway, dataSource);
				effect_downstreameffect11.setTitle("Decreased sperm quantity or quality in the adult, Decreased fertility ");
				effect_downstreameffect11.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "individual");
				effect_downstreameffect11.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_TAXONOMY.DIMENSION_INDEX, "Rattus norvegicus");
				effect_downstreameffect11.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "male");
				effect_downstreameffect11.getDescriptionIDs().set(new DescriptionSection(effect_downstreameffect11, dataSource, "Description", "").setFormat(ContentFormat.HTML).<DescriptionSection> makeItLive(),
						0);
				
				link_effecttoeffect4 = new Link_EffectToEffect(pathway, dataSource, effect_molecularinitiatingevent1, effect_downstreameffect3);
				link_effecttoeffect4.setLinkType(LinkType.DIRECT);
				link_effecttoeffect4.getDescriptionIDs().set(new DescriptionSection(link_effecttoeffect4, dataSource, "Description", "").setFormat(ContentFormat.HTML).<DescriptionSection> makeItLive(), 0);
				ReferenceIDW<Link_EffectToEffect> link_effecttoeffect4_weigth1 = new ReferenceIDW<Link_EffectToEffect>(link_effecttoeffect4, dataSource, Link_EffectToEffect.class, 0.0);
				link_effecttoeffect4.getDescriptionIDs().set(new DescriptionSection_Structured(link_effecttoeffect4, dataSource, "(Key) Event Relationship Weight of Evidence", "", link_effecttoeffect4_weigth1)
						.setFormat(ContentFormat.HTML).<DescriptionSection_Structured> makeItLive(), 1);
				link_effecttoeffect4.getDescriptionIDs()
						.set(new DescriptionSection(link_effecttoeffect4, dataSource, "Evidence Supporting Taxonomic Applicability", "").setFormat(ContentFormat.HTML).<DescriptionSection> makeItLive(), 2);
				link_effecttoeffect4.getDescriptionIDs().set(new DescriptionSection(link_effecttoeffect4, dataSource, "Quantitative Understanding", "<p>Evidence support: Unspecified</p><p></p>")
						.setFormat(ContentFormat.HTML).<DescriptionSection> makeItLive(), 3);
				
				link_effecttoeffect6 = new Link_EffectToEffect(pathway, dataSource, effect_molecularinitiatingevent1, effect_downstreameffect5);
				link_effecttoeffect6.setLinkType(LinkType.DIRECT);
				link_effecttoeffect6.getDescriptionIDs().set(new DescriptionSection(link_effecttoeffect6, dataSource, "Description", "").setFormat(ContentFormat.HTML).<DescriptionSection> makeItLive(), 0);
				ReferenceIDW<Link_EffectToEffect> link_effecttoeffect6_weigth1 = new ReferenceIDW<Link_EffectToEffect>(link_effecttoeffect6, dataSource, Link_EffectToEffect.class, 0.0);
				link_effecttoeffect6.getDescriptionIDs().set(new DescriptionSection_Structured(link_effecttoeffect6, dataSource, "(Key) Event Relationship Weight of Evidence", "", link_effecttoeffect6_weigth1)
						.setFormat(ContentFormat.HTML).<DescriptionSection_Structured> makeItLive(), 1);
				link_effecttoeffect6.getDescriptionIDs()
						.set(new DescriptionSection(link_effecttoeffect6, dataSource, "Evidence Supporting Taxonomic Applicability", "").setFormat(ContentFormat.HTML).<DescriptionSection> makeItLive(), 2);
				link_effecttoeffect6.getDescriptionIDs().set(new DescriptionSection(link_effecttoeffect6, dataSource, "Quantitative Understanding", "<p>Evidence support: Unspecified</p><p></p>")
						.setFormat(ContentFormat.HTML).<DescriptionSection> makeItLive(), 3);
				
				link_effecttoeffect8 = new Link_EffectToEffect(pathway, dataSource, effect_downstreameffect3, effect_downstreameffect7);
				link_effecttoeffect8.setLinkType(LinkType.DIRECT);
				link_effecttoeffect8.getDescriptionIDs().set(new DescriptionSection(link_effecttoeffect8, dataSource, "Description", "").setFormat(ContentFormat.HTML).<DescriptionSection> makeItLive(), 0);
				ReferenceIDW<Link_EffectToEffect> link_effecttoeffect8_weigth1 = new ReferenceIDW<Link_EffectToEffect>(link_effecttoeffect8, dataSource, Link_EffectToEffect.class, 0.0);
				link_effecttoeffect8.getDescriptionIDs().set(new DescriptionSection_Structured(link_effecttoeffect8, dataSource, "(Key) Event Relationship Weight of Evidence", "", link_effecttoeffect8_weigth1)
						.setFormat(ContentFormat.HTML).<DescriptionSection_Structured> makeItLive(), 1);
				link_effecttoeffect8.getDescriptionIDs()
						.set(new DescriptionSection(link_effecttoeffect8, dataSource, "Evidence Supporting Taxonomic Applicability", "").setFormat(ContentFormat.HTML).<DescriptionSection> makeItLive(), 2);
				link_effecttoeffect8.getDescriptionIDs().set(new DescriptionSection(link_effecttoeffect8, dataSource, "Quantitative Understanding", "<p>Evidence support: Unspecified</p><p></p>")
						.setFormat(ContentFormat.HTML).<DescriptionSection> makeItLive(), 3);
				
				link_effecttoeffect10 = dataSource.get(Link_EffectToEffect.class, 57);
				pathway.add(link_effecttoeffect10);
				
				link_effecttoeffect12 = new Link_EffectToEffect(pathway, dataSource, effect_downstreameffect9, effect_downstreameffect11);
				link_effecttoeffect12.setLinkType(LinkType.DIRECT);
				link_effecttoeffect12.getDescriptionIDs().set(new DescriptionSection(link_effecttoeffect12, dataSource, "Description", "").setFormat(ContentFormat.HTML).<DescriptionSection> makeItLive(), 0);
				ReferenceIDW<Link_EffectToEffect> link_effecttoeffect12_weigth1 = new ReferenceIDW<Link_EffectToEffect>(link_effecttoeffect12, dataSource, Link_EffectToEffect.class, 0.0);
				link_effecttoeffect12.getDescriptionIDs().set(new DescriptionSection_Structured(link_effecttoeffect12, dataSource, "(Key) Event Relationship Weight of Evidence", "", link_effecttoeffect12_weigth1)
						.setFormat(ContentFormat.HTML).<DescriptionSection_Structured> makeItLive(), 1);
				link_effecttoeffect12.getDescriptionIDs()
						.set(new DescriptionSection(link_effecttoeffect12, dataSource, "Evidence Supporting Taxonomic Applicability", "").setFormat(ContentFormat.HTML).<DescriptionSection> makeItLive(), 2);
				link_effecttoeffect12.getDescriptionIDs().set(new DescriptionSection(link_effecttoeffect12, dataSource, "Quantitative Understanding", "<p>Evidence support: Unspecified</p><p></p>")
						.setFormat(ContentFormat.HTML).<DescriptionSection> makeItLive(), 3);
				
				link_effecttoeffect13 = new Link_EffectToEffect(pathway, dataSource, effect_downstreameffect11, effect_adverseoutcome2);
				link_effecttoeffect13.setLinkType(LinkType.DIRECT);
				link_effecttoeffect13.getDescriptionIDs().set(new DescriptionSection(link_effecttoeffect13, dataSource, "Description", "").setFormat(ContentFormat.HTML).<DescriptionSection> makeItLive(), 0);
				ReferenceIDW<Link_EffectToEffect> link_effecttoeffect13_weigth1 = new ReferenceIDW<Link_EffectToEffect>(link_effecttoeffect13, dataSource, Link_EffectToEffect.class, 0.0);
				link_effecttoeffect13.getDescriptionIDs().set(new DescriptionSection_Structured(link_effecttoeffect13, dataSource, "(Key) Event Relationship Weight of Evidence", "", link_effecttoeffect13_weigth1)
						.setFormat(ContentFormat.HTML).<DescriptionSection_Structured> makeItLive(), 1);
				link_effecttoeffect13.getDescriptionIDs()
						.set(new DescriptionSection(link_effecttoeffect13, dataSource, "Evidence Supporting Taxonomic Applicability", "").setFormat(ContentFormat.HTML).<DescriptionSection> makeItLive(), 2);
				link_effecttoeffect13.getDescriptionIDs().set(new DescriptionSection(link_effecttoeffect13, dataSource, "Quantitative Understanding", "<p>Evidence support: Unspecified</p><p></p>")
						.setFormat(ContentFormat.HTML).<DescriptionSection> makeItLive(), 3);
				
				pathway.getGroups().parseString("");
				pathway.getUids().parseString("SHORTNAME:Adult Leydig Cell Dysfunction,");
				pathway.getStatus().parseString("OECD:Under Development,SAAOP:Included in OECD Work Plan,AOPWIKI:Under development: Not open for comment. Do not cite,");
				
				pathway.updateEssentiality();
				EssetialityDescription essentiality = pathway.getEssentiality();
				DescriptionSection_Structured dss;
				pathway.getDescriptionIDs().set(new DescriptionSection(pathway, dataSource, "Abstract", "").setFormat(ContentFormat.HTML).<DescriptionSection> makeItLive(), 0);
				pathway.getDescriptionIDs().set(new DescriptionSection(pathway, dataSource, "Quantitative Considerations", "").setFormat(ContentFormat.HTML).<DescriptionSection> makeItLive(), 3);
				pathway.getDescriptionIDs()
						.set(new DescriptionSection(pathway, dataSource, "Applicability of the AOP",
								"<ul><li><strong>Sexes</strong>:Male</li><li><strong>Life Stages</strong>:Adult, reproductively mature</li><li><strong>Taxonomies</strong>:Rattus norvegicus</li></ul>")
										.setFormat(ContentFormat.HTML).<DescriptionSection> makeItLive(),
								4);
				pathway.getDescriptionIDs().set(new DescriptionSection(pathway, dataSource, "Potential Applications of the AOP", "").setFormat(ContentFormat.HTML).<DescriptionSection> makeItLive(), 5);
				dss = essentiality.getEssentialityDescription(effect_molecularinitiatingevent1);
				dss.setContent("Section content");
				dss.setFormat(ContentFormat.TEXT);
				((ReferenceIDW<Link_EffectToEffect>) dss.getStructuredContent()).setWeight(0.0);
				dss = essentiality.getEssentialityDescription(effect_adverseoutcome2);
				dss.setContent("Section content");
				dss.setFormat(ContentFormat.TEXT);
				((ReferenceIDW<Link_EffectToEffect>) dss.getStructuredContent()).setWeight(0.0);
				dss = essentiality.getEssentialityDescription(effect_downstreameffect3);
				dss.setContent("Section content");
				dss.setFormat(ContentFormat.TEXT);
				((ReferenceIDW<Link_EffectToEffect>) dss.getStructuredContent()).setWeight(0.0);
				dss = essentiality.getEssentialityDescription(effect_downstreameffect5);
				dss.setContent("Section content");
				dss.setFormat(ContentFormat.TEXT);
				((ReferenceIDW<Link_EffectToEffect>) dss.getStructuredContent()).setWeight(0.0);
				dss = essentiality.getEssentialityDescription(effect_downstreameffect7);
				dss.setContent("Section content");
				dss.setFormat(ContentFormat.TEXT);
				((ReferenceIDW<Link_EffectToEffect>) dss.getStructuredContent()).setWeight(0.0);
				dss = essentiality.getEssentialityDescription(effect_downstreameffect9);
				dss.setContent("Section content");
				dss.setFormat(ContentFormat.TEXT);
				((ReferenceIDW<Link_EffectToEffect>) dss.getStructuredContent()).setWeight(0.0);
				dss = essentiality.getEssentialityDescription(effect_downstreameffect11);
				dss.setContent("Section content");
				dss.setFormat(ContentFormat.TEXT);
				((ReferenceIDW<Link_EffectToEffect>) dss.getStructuredContent()).setWeight(0.0);
			}
	}
