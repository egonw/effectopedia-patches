package org.qsari.effectopedia.gui.default_ui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.BoxLayout;

import org.qsari.effectopedia.data.objects.ObjectProperty;
import org.qsari.effectopedia.gui.SizeOptimizableUI;
import org.qsari.effectopedia.gui.core.LoadableEditorUI;
import org.qsari.effectopedia.gui.help.ContextSensitivePanel;
import org.qsari.effectopedia.gui.help.RootHelpContext;

/**
 * This code was edited or generated using CloudGarden's Jigloo SWT/Swing GUI
 * Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose
 * whatever) then you should purchase a license for each developer using Jigloo.
 * Please visit www.cloudgarden.com for details. Use of Jigloo implies
 * acceptance of these licensing terms. A COMMERCIAL LICENSE HAS NOT BEEN
 * PURCHASED FOR THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED LEGALLY FOR
 * ANY CORPORATE OR COMMERCIAL PURPOSE.
 */
public class ObjectPropertyValuesUI extends ContextSensitivePanel implements LoadableEditorUI, SizeOptimizableUI
	{
		/**
	 * 
	 */
		private static final long serialVersionUID = 1L;
		
		public ObjectPropertyValuesUI(RootHelpContext rootHelpContext)
			{
				super(rootHelpContext);
				valuesUI = new ArrayList<ObjectPropertyValueUI>();
				initGUI();
			}
		
		private void initGUI()
			{
				try
					{
							{
								this.setPreferredSize(new java.awt.Dimension(522, 16));
								BoxLayout thisLayout = new BoxLayout(this, javax.swing.BoxLayout.Y_AXIS);
								this.setLayout(thisLayout);
								this.setBackground(Color.white);
									{
										defaultValueUI = new ObjectPropertyValueUI(DEFAULT_VALUE,rootHelpContext);
										valuesUI.add(defaultValueUI);
										this.add(defaultValueUI);
									}
							}
					}
				catch (Exception e)
					{
						e.printStackTrace();
					}
			}
		
		@Override
		public void load(Object o, boolean readonly)
			{
				if (o instanceof ObjectProperty)
					{
						property = (ObjectProperty) o;
						int valuesCnt = property.valuesCount();
						while (valuesUI.size() > valuesCnt)
							{
								ObjectPropertyValueUI valueUI = valuesUI.get(valuesUI.size() - 1);
								this.remove(valueUI);
								valuesUI.remove(valuesUI.size() - 1);
							}
						while (valuesUI.size() < valuesCnt)
							{
								ObjectPropertyValueUI valueUI = new ObjectPropertyValueUI(valuesUI.size(),rootHelpContext);
								this.add(valueUI);
								valuesUI.add(valueUI);
							}
						for (int i = 0; i < valuesCnt; i++)
							valuesUI.get(i).load(property, readonly);
					}
				updateOptimalSize();
			}
		
		@Override
		public void updateOptimalSize()
			{
				ObjectPropertyValueUI valueUI = valuesUI.get(DEFAULT_VALUE);
				optimalSize.width = valueUI.getPreferredSize().width;
				optimalSize.height = valueUI.getPreferredSize().height * valuesUI.size();
				setSize(optimalSize);
				setPreferredSize(optimalSize);
				Container parent = getParent();
				while (parent != null)
					{
						if (parent instanceof SizeOptimizableUI)
							{
								((SizeOptimizableUI) parent).updateOptimalSize();
								break;
							}
						parent = parent.getParent();
					}
				
			}
		
		public ObjectPropertyValueUI getValueUI(int index)
			{
				return valuesUI.get(index);
			}
		
		public int getValueUICount()
			{
				return valuesUI.size();
			}
		
		private Dimension																										optimalSize			= new Dimension(600, 18);
		protected ObjectProperty																			property						= null;
		protected ObjectPropertyValueUI												defaultValueUI;
		protected ArrayList<ObjectPropertyValueUI>	valuesUI;
		protected static final int																	DEFAULT_VALUE	= 0;
	}
