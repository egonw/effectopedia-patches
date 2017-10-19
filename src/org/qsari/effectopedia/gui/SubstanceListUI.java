package org.qsari.effectopedia.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.base.Titleable;
import org.qsari.effectopedia.base.ids.ReferenceIDs;
import org.qsari.effectopedia.core.objects.Substance;
import org.qsari.effectopedia.gui.comp.CollapsableTitledPanel;
import org.qsari.effectopedia.gui.core.LoadableEditorUI;
import org.qsari.effectopedia.gui.help.ContextSensitivePanel;
import org.qsari.effectopedia.gui.help.RootHelpContext;
import org.qsari.effectopedia.gui.toolbars.ListEditorToolbarUI;

/**
 * This code was edited or generated using CloudGarden's Jigloo
 * SWT/Swing GUI Builder, which is free for non-commercial
 * use. If Jigloo is being used commercially (ie, by a corporation,
 * company or business for any purpose whatever) then you
 * should purchase a license for each developer using Jigloo.
 * Please visit www.cloudgarden.com for details.
 * Use of Jigloo implies acceptance of these licensing terms.
 * A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
 * THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
 * LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
 */
/**
 * @version 1 @(#)InvestigationListUI.java 1.0
 * @author Hristo Aladjov
 */

public class SubstanceListUI extends ContextSensitivePanel implements AdjustableUI, LoadableEditorUI, InitializableUI
	{
		/**
		 * 
		 */
		private static final long			serialVersionUID		= 1L;
		
		private ListEditorToolbarUI	jletuiSubstances;
		
		private SubstancesUI								suiSubstances;
		
		private static final int				defaultItemHeight	= 300;
		
		public static class SubstanceUI extends CollapsableTitledPanel
			{
				
				/**
				* 
				*/
				private static final long							serialVersionUID	= 1L;
				private IdentifiableSubstanceUI	substanceUI;
				
				public SubstanceUI(boolean basicLayout, RootHelpContext rootHelpContext)
					{
						super(null, null, false, rootHelpContext);
						substanceUI = new IdentifiableSubstanceUI(basicLayout, rootHelpContext);
						setBodyPanel(substanceUI);
						setAllowRedirecting(true);
						setAllowHTMLContent(false);
						setPreferredHeight(basicLayout ? (int) (defaultItemHeight * 0.6) : defaultItemHeight);
					}
					
				public void load(Object o, boolean readonly)
					{
						if (!(o instanceof Titleable) || !(o instanceof EffectopediaObject))
							return;
						readonly = readonly || ((EffectopediaObject) o).isReadonly();
						this.eo = (EffectopediaObject) o;
						this.defaultObject = eo.isDefaultID();
						loadTitle(o, readonly);
						substanceUI.load(o, readonly);
					}
					
			}
			
		/**
		 * 
		 */
		public class SubstancesUI extends IndexedObjectListUI<SubstanceUI>
			{
				
				public SubstancesUI(RootHelpContext rootHelpContext)
					{
						super(rootHelpContext);
					}
					
				/**
				* 
				*/
				private static final long serialVersionUID = 1L;
				
				public SubstanceUI add(boolean enableSelectionDialog)
					{
						SubstanceUI newSubstanceUI = new SubstanceUI(basicLayout, SubstanceListUI.this.rootHelpContext);
						Substance pure = substanceIDs.getCachedObject(0);
						if (pure != null)
							{
								Substance substance = Substance.createDefaultSubstance(pure.getParentStructure(), substanceIDs.getDataSource());
								suiSubstances.add(newSubstanceUI, substance);
							}
						else
							suiSubstances.add(newSubstanceUI);
						return newSubstanceUI;
					}
					
				@Override
				public Object getList()
					{
						return super.getIndexedList();
					}
					
				public void reloadIndexedList()
					{
						if (indexedList != null)
							for (int index = 0; index < indexedList.size(); index++)
								list.get(index).load(indexedList.getCachedObject(index), false);
						updateOptimalSize();
					}
					
			}
			
		/**
		 * Auto-generated main method to display this JPanel inside a new JFrame.
		 */
		public static void main(String[] args)
			{
				JFrame frame = new JFrame();
				frame.getContentPane().add(new SubstanceListUI(false, null));
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				frame.pack();
				frame.setVisible(true);
			}
			
		public SubstanceListUI(boolean basicLayout, RootHelpContext rootHelpContext)
			{
				super(rootHelpContext);
				setName("substance_list");
				initGUI(basicLayout);
				adjustUI(EDIT);
			}
			
		private void initGUI(boolean basicLayout)
			{
				this.basicLayout = basicLayout;
				try
					{
						setPreferredSize(optimalSize);
						BorderLayout thisLayout = new BorderLayout();
						this.setLayout(thisLayout);
						this.setBorder(BorderFactory.createTitledBorder(null, "Associated substances", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 2, 12)));
						this.setBackground(Color.WHITE);
							{
								suiSubstances = new SubstancesUI(rootHelpContext);
								this.add(suiSubstances, BorderLayout.CENTER);
								suiSubstances.setBackground(Color.WHITE);
							}
						if (!basicLayout)
							{
								jletuiSubstances = new ListEditorToolbarUI(suiSubstances, "substance", ListEditorToolbarUI.DEFAULT, FlowLayout.RIGHT);
								this.add(jletuiSubstances, BorderLayout.SOUTH);
							}
					}
				catch (Exception e)
					{
						e.printStackTrace();
					}
			}
			
		/**
		 * Adjust <code>visible</code> properties to the current and the contained
		 * components
		 * 
		 * @see AdjustableUI
		 * 
		 * @param visualOptions
		 *         an long that specifies which of the contained components are
		 *         visible
		 */
		public void adjustUI(long visualOptions)
			{
				AdjustbleUserInterfaceTools.adjustChildren(this, visualOptions);
			}
			
		public void load(Object o, boolean readonly)
			{
				if (!(o instanceof ReferenceIDs))
					return;
				substanceIDs = (ReferenceIDs<Substance>) o;
				readonly = readonly || substanceIDs.isReadonly();
				suiSubstances.setIndexedList(substanceIDs, readonly);
				if (!basicLayout)
					jletuiSubstances.updateEditButtons(readonly);
				updateOptimalSize();
			}
			
		public void reload()
			{
				suiSubstances.reloadIndexedList();
				if (!basicLayout)
					jletuiSubstances.updateEditButtons(substanceIDs.isReadonly());
				updateOptimalSize();
			}
			
		public void updateOptimalSize()
			{
				optimalSize.width = suiSubstances.getWidth();
				optimalSize.height = suiSubstances.getPreferredSize().height + ((!basicLayout) ? jletuiSubstances.getPreferredSize().height : 0);
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
			
		public void initializeUI()
			{
				suiSubstances.initializeUI();
			}
			
		private boolean																	basicLayout;
		private Dimension															optimalSize		= new Dimension(300, 64);
		private ReferenceIDs<Substance>	substanceIDs	= null;
		
	}