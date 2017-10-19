package org.qsari.effectopedia.core.objects;

import java.util.LinkedHashMap;

import org.qsari.effectopedia.base.Describable;
import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.base.Titleable;
import org.qsari.effectopedia.base.Traceable;
import org.qsari.effectopedia.base.io.BaseIO;
import org.qsari.effectopedia.base.io.BaseIOAttribute;
import org.qsari.effectopedia.base.io.BaseIOElement;
import org.qsari.effectopedia.base.io.Exportable;
import org.qsari.effectopedia.base.io.Importable;
import org.qsari.effectopedia.data.DataSource;
import org.qsari.effectopedia.data.objects.ObjectProperty;
import org.qsari.effectopedia.data.quantification.Factor;
import org.qsari.effectopedia.data.quantification.FunctionalRelationship;
import org.qsari.effectopedia.data.quantification.FunctionalRelationships;
import org.qsari.effectopedia.data.quantification.ModifyingFactors;
import org.qsari.effectopedia.defaults.DefaultEffectopediaObjects;
import org.qsari.effectopedia.system.ActionTypes;

public abstract class Link extends DocumentedKnowledge implements Importable, Exportable, Cloneable, Traceable, Describable, Titleable, Factor
	{
		public static enum LinkNature
			{
				HYPOTHETICAL(0, "Hypothetical"), HARDWIRE(1, "One to One"), LINEAR(2, "Proportional"), THRESHOLD(3, "Threshold"), DOSE_RESPONSE(4, "Dose-response"), RESPONSE_RESPONSE(5, "Response-Response"), METABOLIC(
						5, "Metabolic activation");
				
				LinkNature(int code, String caption)
					{
						this.code = code;
						this.caption = caption;
					}
				
				public String toString()
					{
						return caption;
					}
				
				public int getCode()
					{
						return code;
					}
				
				private final int				code;
				private final String	caption;
			}
		
		public static enum LinkType
			{
				UNKNOWN(0, "Unknown"), DIRECT(1, "Direct"), INDIRECT(2, "Indirect");
				
				LinkType(int code, String caption)
					{
						this.code = code;
						this.caption = caption;
					}
				
				public String toString()
					{
						return caption;
					}
				
				public int getCode()
					{
						return code;
					}
				
				private final int				code;
				private final String	caption;
			}
		
		public Link()
			{
				super();
				modifyingFactors = new ModifyingFactors(this, dataSource);
			}
		
		public Link(EffectopediaObject parent, DataSource dataSource)
			{
				super(parent, dataSource);
				modifyingFactors = new ModifyingFactors(this, dataSource);
			}
		
		public void getContainedIDs(LinkedHashMap<Long, EffectopediaObject> containedIDs, boolean includeOwned)
			{
				super.getContainedIDs(containedIDs, includeOwned);
				if (quantitativeRelationships != null)
					quantitativeRelationships.getContainedIDs(containedIDs);
				modifyingFactors.getContainedIDs(containedIDs);
			}
		
		public void getContainedExternalIDs(LinkedHashMap<Long, EffectopediaObject> containedIDs)
			{
				super.getContainedExternalIDs(containedIDs);
				if (quantitativeRelationships != null)
					quantitativeRelationships.getContainedExternalIDs(containedIDs);
				modifyingFactors.getContainedExternalIDs(containedIDs);
			}
		
		public void process(BatchProcessor batch)
			{
				super.process(batch);
				if (quantitativeRelationships != null)
					quantitativeRelationships.process(batch);
				modifyingFactors.process(batch);
			}
		
		public void updateParenthood()
			{
				super.updateParenthood();
				if (quantitativeRelationships != null)
					quantitativeRelationships.updateParenthood();
				modifyingFactors.updateParenthood();
			}
		
		@SuppressWarnings("unchecked")
		public void reloadReferredObjectsFromID()
			{
				super.reloadReferredObjectsFromID();
				if (quantitativeRelationships != null)
					{
						quantitativeRelationships.setOwner(dataSource.get(this.getClass(), this.getID()));
						quantitativeRelationships.reloadReferredObjectsFromID();
					}
				if (temporalConcordances != null)
					temporalConcordances.setOwner(dataSource.get(this.getClass(), this.getID()));
				modifyingFactors.reloadReferredObjectsFromID();
			}
		
		
		@Override
				public void assignFieldsTo(EffectopediaObject eoDestintation, boolean assignContainedEO)
			{
				super.assignFieldsTo(eoDestintation, assignContainedEO);
				if (eoDestintation instanceof Link)
					{
						((Link) eoDestintation).linkNature = this.linkNature;
						((Link) eoDestintation).linkType = this.linkType;
						if (this.quantitativeRelationships != null)
							((Link) eoDestintation).quantitativeRelationships = this.quantitativeRelationships.clone(eoDestintation, dataSource);
						else
							((Link) eoDestintation).quantitativeRelationships = null;
						if (this.temporalConcordances != null)
							((Link) eoDestintation).temporalConcordances = this.temporalConcordances.clone(eoDestintation, dataSource);
						else
							((Link) eoDestintation).temporalConcordances = null;
						((Link) eoDestintation).modifyingFactors = this.modifyingFactors.clone(eoDestintation, dataSource);
					}
			}
	

		public void cloneFieldsTo(Link clone, DataSource dataSource)
			{
				super.cloneFieldsTo(clone, dataSource);
				clone.linkNature = this.linkNature;
				clone.linkType = this.linkType;
				if (this.quantitativeRelationships != null)
					clone.quantitativeRelationships = this.quantitativeRelationships.clone(clone, dataSource);
				else
					clone.quantitativeRelationships = null;
				if (this.temporalConcordances != null)
					clone.temporalConcordances = this.temporalConcordances.clone(clone, dataSource);
				else
					clone.temporalConcordances = null;
				clone.modifyingFactors = this.modifyingFactors.clone(clone, dataSource);
			}
		
		public Link clone()
			{
				Link clone = null;
				try
					{
						clone = this.getClass().newInstance();
						clone.parent = parent;
						cloneFieldsTo(clone, dataSource);
					}
				catch (InstantiationException e)
					{
						e.printStackTrace();
					}
				catch (IllegalAccessException e)
					{
						e.printStackTrace();
					}
				return clone;
			}
		
		public Link clone(EffectopediaObject parent)
			{
				Link clone = null;
				try
					{
						clone = this.getClass().newInstance();
						clone.parent = parent;
						cloneFieldsTo(clone, dataSource);
					}
				catch (InstantiationException e)
					{
						e.printStackTrace();
					}
				catch (IllegalAccessException e)
					{
						e.printStackTrace();
					}
				return clone;
			}
		
		public void load(BaseIOElement element, BaseIO io)
			{
				if (element != null)
					{
						super.load(element, io);
						BaseIOAttribute linkNature = element.getAttribute("nature");
						if (linkNature != null)
							{
								String nature = linkNature.getValue();
								if (nature == "TRESHOLD")
									this.linkNature = LinkNature.THRESHOLD;
								else
									this.linkNature = LinkNature.valueOf(nature);
							}
						BaseIOElement qr = element.getChild("qunatitative_relationships");
						if (qr != null)
							{
								quantitativeRelationships = new FunctionalRelationships(this);
								quantitativeRelationships.load(qr, io);
							}
						
						BaseIOElement tc = element.getChild("temporal_concordances");
						if (tc != null)
							{
								temporalConcordances = new FunctionalRelationships(this);
								temporalConcordances.load(tc, io);
							}
						
						BaseIOAttribute linkType = element.getAttribute("type");
						if (linkType != null)
							this.linkType = LinkType.valueOf(linkType.getValue());
						
						BaseIOElement mf = element.getChild("modifying_factors");
						if (mf != null)
							modifyingFactors.load(mf, io);
					}
			}
		
		public BaseIOElement store(BaseIOElement element, BaseIO io)
			{
				super.store(element, io);
				element.setAttribute("nature", linkNature.name());
				element.setAttribute("type", linkType.name());
				if (quantitativeRelationships != null)
					element.addChild(quantitativeRelationships.store(io.newElement("qunatitative_relationships"), io));
				if (temporalConcordances != null)
					element.addChild(temporalConcordances.store(io.newElement("temporal_concordances"), io));
				if (modifyingFactors.getCount() > 0)
					element.addChild(modifyingFactors.store(io.newElement("modifying_factors"), io));
				return element;
			}
		
		public static Link newLink(EffectopediaObject parent, DataSource dataSource, PathwayElement upstreamElement, PathwayElement downstreamElement)
			{
				if (upstreamElement instanceof Initiator_ChemicalStructure)
					{
						if (downstreamElement instanceof Initiator_ChemicalStructure)
							return new Link_ChemStructToChemStruct(parent, dataSource, (Initiator) upstreamElement, (Initiator) downstreamElement);
						else if (downstreamElement instanceof Effect)
							return new Link_ChemStructToMIE(parent, dataSource, (Initiator) upstreamElement, (Effect) downstreamElement);
					}
				else if (((upstreamElement instanceof Initiator_StructuralAlerts) || (upstreamElement instanceof Initiator_BiologcalPerturbation)) && (downstreamElement instanceof Effect))
					return new Link_ChemStructToMIE(parent, dataSource, (Initiator) upstreamElement, (Effect) downstreamElement);
				else if ((upstreamElement instanceof Effect) && (downstreamElement instanceof Effect))
					return new Link_EffectToEffect(parent, dataSource, (Effect) upstreamElement, (Effect) downstreamElement);
				return null;
			}

		public static Link getDefaultLink(PathwayElement upstreamElement, PathwayElement downstreamElement)
			{
				if (upstreamElement instanceof Initiator_ChemicalStructure)
					{
						if (downstreamElement instanceof Initiator_ChemicalStructure)
							return DefaultEffectopediaObjects.DEFAULT_LINK_CSTCS;
						else if (downstreamElement instanceof Effect)
							return DefaultEffectopediaObjects.DEFAULT_LINK_CSTMIE;
					}
				else if (((upstreamElement instanceof Initiator_StructuralAlerts) || (upstreamElement instanceof Initiator_BiologcalPerturbation)) && (downstreamElement instanceof Effect))
					return DefaultEffectopediaObjects.DEFAULT_LINK_CSTMIE;
				else if ((upstreamElement instanceof Effect) && (downstreamElement instanceof Effect))
					return DefaultEffectopediaObjects.DEFAULT_LINK_ETE;
				return null;
			}
		
		public LinkNature getLinkNature()
			{
				return linkNature;
			}
		
		public void setLinkNature(LinkNature linkNature)
			{
				this.linkNature = linkNature;
			}
		
		public LinkType getLinkType()
			{
				return linkType;
			}
		
		public void setLinkType(LinkType linkType)
			{
				this.linkType = linkType;
			}
		
		public FunctionalRelationship getQuantitativeRelationship()
			{
				return (quantitativeRelationships != null) ? quantitativeRelationships.getDefault() : null;
			}
		
		public void setQuantitativeRelationship(FunctionalRelationship quantitativeRelationship)
			{
				if (quantitativeRelationships == null)
					quantitativeRelationships = new FunctionalRelationships(this);
				if (((quantitativeRelationship == null) && (this.quantitativeRelationships != null)) || (!quantitativeRelationship.equals(this.quantitativeRelationships.getDefault())))
					{
						beforeUpdate(true, ActionTypes.L_QUANTITATIVE_REL);
						this.quantitativeRelationships.setDefault(quantitativeRelationship);
					}
			}
		
		public String getDescriptiveTitle()
			{
				return getGenericDescription();
			}
		
		public String getGenericDescription()
			{
				return linkNature + " link";
			}
		
		public FunctionalRelationships getQuantitativeRelationships()
			{
				return quantitativeRelationships;
			}
		
		public void setQuantitativeRelationships(FunctionalRelationships quantitativeRelationships)
			{
				this.quantitativeRelationships = quantitativeRelationships;
			}
		
		public FunctionalRelationships getTemporalConcordances()
			{
				return temporalConcordances;
			}
		
		public void setTemporalConcordances(FunctionalRelationships temporalConcordances)
			{
				this.temporalConcordances = temporalConcordances;
			}
		
		public ModifyingFactors getModifyingFactors()
			{
				return modifyingFactors;
			}
		
		public void setModifyingFactors(ModifyingFactors modifyingFactors)
			{
				this.modifyingFactors = modifyingFactors;
			}
		
		@Override
		public ObjectProperty getCurrentState()
			{
				if (quantitativeRelationships != null)
					return quantitativeRelationships.get(0).getProperties().getProperty(0);
				else
					return null;
			}
		
		protected LinkType																linkType																		= LinkType.UNKNOWN;
		protected LinkNature														linkNature																= LinkNature.HYPOTHETICAL;
		protected FunctionalRelationships	quantitativeRelationships	= null;
		protected FunctionalRelationships	temporalConcordances						= null;
		protected ModifyingFactors								modifyingFactors										= null;
	}
