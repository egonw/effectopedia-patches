package org.qsari.effectopedia.gui.default_ui;

import javax.swing.DefaultComboBoxModel;

import org.qsari.effectopedia.base.ids.ReferenceIDW;
import org.qsari.effectopedia.core.objects.DescriptionSection_Structured;
import org.qsari.effectopedia.defaults.DefaultEffectopediaObjects;
import org.qsari.effectopedia.gui.core.LoadableEditorUI;

public class EssentialityWeightsLM extends DefaultComboBoxModel<String> implements LoadableEditorUI
	{
		/**
	 * 
	 */
		private static final long	serialVersionUID	= 1L;
		
		public EssentialityWeightsLM()
			{
				super(DefaultEffectopediaObjects.DEFAULT_ESSENTIALITY_WEIGHTS);
			}
		
		@Override
		public Object getSelectedItem()
			{
				return super.getSelectedItem();
			}
		
		@Override
		public void setSelectedItem(Object anItem)
			{
				if (!readonly)
					{
						super.setSelectedItem(anItem);
						if (ds != null)
							setEssentialityWeight(ds, getIndexOf(anItem));
					}
			}
		
		@Override
		public void load(Object o, boolean readonly)
			{
				if (o instanceof DescriptionSection_Structured)
					ds = (DescriptionSection_Structured) o;
				else
					ds = null;
				if (ds != null)
					super.setSelectedItem(DefaultEffectopediaObjects.DEFAULT_ESSENTIALITY_WEIGHTS[getEssentialityWeight(ds)]);
			}
		
		private int getEssentialityWeight(DescriptionSection_Structured ds)
			{
				Object structuredContent = ds.getStructuredContent();
				if (structuredContent instanceof Double)
					{
						int index = ((Double) structuredContent).intValue();
						if ((index < 0) || (index > DefaultEffectopediaObjects.DEFAULT_ESSENTIALITY_WEIGHTS.length))
							return 0;
						else
							return index;
					}
				else if (structuredContent instanceof ReferenceIDW)
					{
						int index = (int) ((ReferenceIDW<?>) structuredContent).getWeight();
						if ((index < 0) || (index > DefaultEffectopediaObjects.DEFAULT_ESSENTIALITY_WEIGHTS.length))
							return 0;
						else
							return index;
					}
				else
					return 0;
			}
		
		private void setEssentialityWeight(DescriptionSection_Structured ds, int weight)
			{
				if (ds == null)
					return;
				if ((weight >= 0) && (weight < DefaultEffectopediaObjects.DEFAULT_ESSENTIALITY_WEIGHTS.length))
					{
						Object structuredContent = ds.getStructuredContent();
						if (structuredContent instanceof Double)
							ds.setStructuredContent(new Double(weight));
						else if (structuredContent instanceof ReferenceIDW)
							((ReferenceIDW<?>) ds.getStructuredContent()).setWeight(weight);
					}
			}
		
		protected DescriptionSection_Structured	ds							= null;
		protected boolean																							readonly	= false;
	}
