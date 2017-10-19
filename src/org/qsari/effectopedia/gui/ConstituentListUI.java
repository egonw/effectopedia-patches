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

import org.qsari.effectopedia.base.ids.IDs;
import org.qsari.effectopedia.core.objects.Constituent;
import org.qsari.effectopedia.core.objects.Initiator_ChemicalStructure;
import org.qsari.effectopedia.core.objects.Substance;
import org.qsari.effectopedia.defaults.DefaultEffectopediaObjects;
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

public class ConstituentListUI extends ContextSensitivePanel implements AdjustableUI, LoadableEditorUI, InitializableUI
	{
		/**
		 * 
		 */
		private static final long			serialVersionUID	= 1L;
		
		private ListEditorToolbarUI	jletuiConstituents;
		
		private ConstituentsUI						cuiConstituents;
		
		/**
		 * 
		 */
		public class ConstituentsUI extends IndexedObjectListUI<ConstituentUI>
			{
				/**
			 * 
			 */
				private static final long	serialVersionUID	= 1L;
				
				public ConstituentsUI(RootHelpContext rootHelpContext)
					{
						super(javax.swing.BoxLayout.X_AXIS,rootHelpContext);
					}
				
				public ConstituentUI add(boolean enableSelectionDialog)
					{
						ConstituentUI newConstituentUI = new ConstituentUI(basicLayout,ConstituentListUI.this.rootHelpContext);
						if (enableSelectionDialog)
							{
								ExistingChemicalDialog.DIALOG.load(DefaultEffectopediaObjects.DEFAULT_CHEM_STRUCTURE, false);
								Initiator_ChemicalStructure structure = (Initiator_ChemicalStructure) ExistingChemicalDialog.DIALOG.getSelectedInitiator();
								if (structure != null)
									{
										Substance substance = (Substance) composition.getParent();
										Constituent newConstituent = substance.createConstituent(structure);
										cuiConstituents.add(newConstituentUI, newConstituent);
									}
								else
									cuiConstituents.add(newConstituentUI);
							}
						else
							cuiConstituents.add(newConstituentUI);
						return newConstituentUI;
					}
				
				@Override
				public Object getList()
					{
						return super.getIndexedList();
					}
			}
		
		/**
		 * Auto-generated main method to display this JPanel inside a new JFrame.
		 */
		public static void main(String[] args)
			{
				JFrame frame = new JFrame();
				frame.getContentPane().add(new ConstituentListUI(false,null));
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				frame.pack();
				frame.setVisible(true);
			}
		
		public ConstituentListUI(boolean basicLayout,RootHelpContext rootHelpContext)
			{
				super(rootHelpContext);
				setName("constituent_list");
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
						this.setBorder(BorderFactory.createTitledBorder(null, "Substance constitunets", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 2, 12)));
						this.setBackground(Color.WHITE);
							{
								cuiConstituents = new ConstituentsUI(rootHelpContext);
								this.add(cuiConstituents, BorderLayout.CENTER);
								cuiConstituents.setBackground(Color.WHITE);
							}
						if (!basicLayout)
							{
								jletuiConstituents = new ListEditorToolbarUI(cuiConstituents, "substance", ListEditorToolbarUI.DEFAULT, FlowLayout.RIGHT);
								this.add(jletuiConstituents, BorderLayout.WEST);
								jletuiConstituents.setPreferredSize(new java.awt.Dimension(20, 182));
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
				if (!(o instanceof IDs))
					return;
				composition = (IDs<Constituent>) o;
				readonly = readonly || composition.isReadonly();
				cuiConstituents.setIndexedList(composition, readonly);
				if (!basicLayout)
					jletuiConstituents.updateEditButtons(readonly);
				updateOptimalSize();
			}
		
		public void updateOptimalSize()
			{
				optimalSize.width = cuiConstituents.getPreferredSize().width;
				optimalSize.height = cuiConstituents.getPreferredSize().height + ((!basicLayout) ? jletuiConstituents.getPreferredSize().height : 0);
				this.setSize(optimalSize);
				this.setPreferredSize(optimalSize);
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
				cuiConstituents.initializeUI();
			}
		
		private boolean										basicLayout;
		private Dimension								optimalSize	= new Dimension(300, 64);
		private IDs<Constituent>	composition	= null;
	}