package org.qsari.effectopedia.core.object.elemets;

import java.util.ArrayList;
import java.util.HashMap;

import org.qsari.effectopedia.base.ids.DescriptionIDs;
import org.qsari.effectopedia.base.ids.ReferenceIDW;
import org.qsari.effectopedia.base.ids.ReferenceIDs;
import org.qsari.effectopedia.core.objects.DescriptionSection;
import org.qsari.effectopedia.core.objects.DescriptionSection_Structured;
import org.qsari.effectopedia.core.objects.Effect;
import org.qsari.effectopedia.core.objects.Link;
import org.qsari.effectopedia.core.objects.Link_EffectToEffect;
import org.qsari.effectopedia.core.objects.PathwayElement;
import org.qsari.effectopedia.defaults.DefaultEffectopediaObjects;

public class EssetialityDescription
	{
		
		public EssetialityDescription(DescriptionIDs descriptions)
			{
				this.described = new HashMap<PathwayElement, DescriptionSection_Structured>();
				DescriptionSection[] ds = descriptions.getCachedObjects();
				String defaultEffectDSTitle = DefaultEffectopediaObjects.DEFAULT_EFFECT_ESSENTIALITY_DSS.getTitle();
				String defaultLinkDSTitle = DefaultEffectopediaObjects.DEFAULT_LINK_ESSENTIALITY_DSS.getTitle();
				int effectDSIndex = -1;
				int linkDSIndex = -1;
				for (int i = 0; i < ds.length; i++)
					{
						DescriptionSection d = ds[i];
						if (!(d instanceof DescriptionSection_Structured))
							continue;
						String dsTitle = d.getTitle();
						if (dsTitle.compareTo(defaultEffectDSTitle) == 0)
							{
								effectDSIndex = i;
								if (linkDSIndex != -1)
									break;
								continue;
							}
						if (dsTitle.compareTo(defaultLinkDSTitle) == 0)
							{
								linkDSIndex = i;
								if (effectDSIndex != -1)
									break;
							}
					}
				this.effectsEssentiality = (DescriptionSection_Structured) ds[effectDSIndex];
				this.linksEssentiality = (DescriptionSection_Structured) ds[linkDSIndex];
				this.effects = (DescriptionIDs) effectsEssentiality.getStructuredContent();
				this.links = (ReferenceIDs<DescriptionSection_Structured>) linksEssentiality.getStructuredContent();
				updateDescribed();
			}
		
		public EssetialityDescription(DescriptionSection_Structured effectsEssentiality, DescriptionSection_Structured linksEssentiality)
			{
				this.described = new HashMap<PathwayElement, DescriptionSection_Structured>();
				this.effectsEssentiality = effectsEssentiality;
				this.effects = (DescriptionIDs) effectsEssentiality.getStructuredContent();
				this.linksEssentiality = linksEssentiality;
				this.links = (ReferenceIDs<DescriptionSection_Structured>) linksEssentiality.getStructuredContent();
			}
		
		public void addPathwayElements(ArrayList<PathwayElement> elements)
			{
				for (PathwayElement element : elements)
					addPathwayElement(element);
			}
		
		@SuppressWarnings("unchecked")
		public void updateDescribed()
			{
				for (DescriptionSection existingDS : effects.getCachedObjects())
					{
						ReferenceIDW<Effect> ref = (ReferenceIDW<Effect>) ((DescriptionSection_Structured) existingDS).getStructuredContent();
						this.described.put(ref.getCachedObject(), ((DescriptionSection_Structured) existingDS));
					}
				for (DescriptionSection existingDS : links.getCachedObjects())
					{
						ReferenceIDW<Link_EffectToEffect> ref = (ReferenceIDW<Link_EffectToEffect>) ((DescriptionSection_Structured) existingDS).getStructuredContent();
						this.described.put(ref.getCachedObject(), ((DescriptionSection_Structured) existingDS));
					}
			}
		
		private void addPathwayElement(PathwayElement element)
			{
				DescriptionSection_Structured dSec = described.get(element);
				if (dSec != null)
					{
						if (element instanceof Effect)
							dSec.setTitle(element.getTitle());
						// else if (element instanceof Link_EffectToEffect)
						// dSec.setTitle(((Link_EffectToEffect) element).getDescriptiveTitle());
						return;
					}
				if (element instanceof Link_EffectToEffect)
					{
						DescriptionSection descriptionSection = ((Link) element).getDescriptionIDs().getCachedObject(DefaultEffectopediaObjects.LINK_WOE_INDEX);
						if (!(descriptionSection instanceof DescriptionSection_Structured))
							{
								descriptionSection = DefaultEffectopediaObjects.DEFAULT_LINK_ESSENTIALITY_DS.clone(linksEssentiality, element.getDataSource());
								// descriptionSection.setTitle(((Link_EffectToEffect)
								// element).getDescriptiveTitle());
								
								System.out.println(((Link_EffectToEffect) element).getDescriptiveTitle());
								((Link) element).getDescriptionIDs().insert(DefaultEffectopediaObjects.LINK_WOE_INDEX, descriptionSection);
							}
						ReferenceIDW<Link_EffectToEffect> ref = (ReferenceIDW<Link_EffectToEffect>) ((DescriptionSection_Structured) descriptionSection).getStructuredContent();
						ref.set((Link_EffectToEffect) element);
						links.add(descriptionSection);
						described.put(element, (DescriptionSection_Structured) descriptionSection);
					}
				else if (element instanceof Effect)
					{
						DescriptionSection_Structured descriptionSection = DefaultEffectopediaObjects.DEFAULT_EFFECT_ESSENTIALITY_DS.clone(effectsEssentiality, element.getDataSource());
						descriptionSection.setTitle(element.getTitle());
						@SuppressWarnings("unchecked")
						ReferenceIDW<Effect> ref = (ReferenceIDW<Effect>) descriptionSection.getStructuredContent();
						ref.set((Effect) element);
						effects.add(descriptionSection);
						described.put(element, descriptionSection);
					}
			}
		
		public void removePathwayElement(PathwayElement element)
			{
				DescriptionSection_Structured descriptionSection = described.get(element);
				if (descriptionSection != null)
					{
						if (element instanceof Link)
							links.remove(descriptionSection);
						else if (element instanceof Effect)
							effects.remove(descriptionSection);
						described.remove(element);
					}
			}
		
		private boolean doesNotNeedSorting(ArrayList<PathwayElement> elements)
			{
				int eIndex = 0;
				int lIndex = 0;
				for (PathwayElement element : elements)
					{
						DescriptionSection_Structured dSec = described.get(element);
						if (dSec != null)
							{
								if (element instanceof Effect)
									{
									if (effects.getCachedObject(eIndex++)!=dSec)
										return false;
									}
								else if (element instanceof Link_EffectToEffect)
									{
									if (links.getCachedObject(lIndex++)!=dSec)
										return false;
									}
							}
					}
				return true;
			}
		
		public boolean sort(ArrayList<PathwayElement> elements)
			{
				if (doesNotNeedSorting(elements))
					return true;
				int eSize = effects.size();
				int lSize = links.size();
				effects.clear();
				links.clear();
				for (PathwayElement element : elements)
					{
						DescriptionSection_Structured dSec = described.get(element);
						if (dSec != null)
							{
								if (element instanceof Effect)
									effects.add(dSec);
								else if (element instanceof Link_EffectToEffect)
									links.add(dSec);
							}
					}
				boolean effectsEssentialityCheck = eSize == effects.size();
				if (!effectsEssentialityCheck)
					System.err.println("Effects essentiality descriptions were not sorted successfully. Descriptions before sorting:" + eSize + " descriptions after:" + effects.size());
				boolean linksEssentialityCheck = lSize == links.size();
				if (!linksEssentialityCheck)
					System.err.println("Links WoE descriptions were not sorted successfully. Descriptions before sorting:" + lSize + " descriptions after:" + links.size());
				return effectsEssentialityCheck && linksEssentialityCheck;
			}
		
		public void clear()
			{
				described.clear();
				links.clear();
				effects.clear();
			}
		
		public boolean isDesctibed(PathwayElement element)
			{
				return described.containsKey(element);
			}
		
		public DescriptionSection_Structured getEssentialityDescription(PathwayElement element)
			{
				return described.get(element);
			}
		
		public final DescriptionIDs																																										effects;
		public final ReferenceIDs<DescriptionSection_Structured>													links;
		public final DescriptionSection_Structured																											effectsEssentiality;
		public final DescriptionSection_Structured																											linksEssentiality;
		private final HashMap<PathwayElement, DescriptionSection_Structured>	described;
	}
