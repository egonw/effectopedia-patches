package org.qsari.effectopedia.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;

import org.qsari.effectopedia.core.containers.Initiators;
import org.qsari.effectopedia.core.objects.Initiator_ChemicalStructure;
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
 *
 */
public class EditChemicalsUI extends ContextSensitivePanel implements AdjustableUI, LoadableEditorUI, SizeOptimizableUI
	{
		/**
	 * 
	 */
		private static final long			serialVersionUID	= 1L;
		
		private ListEditorToolbarUI	letuiToolbar;
		private JScrollPane									jspChemicals;
		
		private ChemicalsUI									cuiChemicals;
		
		/**
		 * 
		 */
		public class ChemicalsUI extends IndexedObjectListUI<ChemicalUI>
			{
				/**
			 * 
			 */
				private static final long	serialVersionUID	= 1L;
				private boolean											basicLayout;
				
				public ChemicalsUI(boolean basicLayout,RootHelpContext rootHelpContext)
					{
						super(rootHelpContext);
						setName("chemicals");
						this.basicLayout = basicLayout;
					}
				
				public ChemicalUI add(boolean enableSelectionDialog)
					{
						ChemicalUI chemical = new ChemicalUI(basicLayout);
						chemical.setPreferredSize(new java.awt.Dimension(400, 300));
						cuiChemicals.add(chemical);
						return chemical;
					}
				
				@Override
				public Object getList()
					{
						return getIndexedList();
					}
				
				public void setAllowRedirecting(boolean allow)
					{
						for (ChemicalUI cui : list)
							cui.setHeaderAllowRedirecting(allow);
					}
			}
		
		/**
		 * Auto-generated main method to display this JPanel inside a new JFrame.
		 */
		public static void main(String[] args)
			{
				JFrame frame = new JFrame();
				frame.getContentPane().add(new EditChemicalsUI(false,null));
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				frame.pack();
				frame.setVisible(true);
			}
		
		public EditChemicalsUI(boolean basicLayout,RootHelpContext rootHelpContext)
			{
				super(rootHelpContext);
				initGUI(basicLayout);
			}
		
		private void initGUI(boolean basicLayout)
			{
				try
					{
						BorderLayout thisLayout = new BorderLayout();
						this.setLayout(thisLayout);
						this.setPreferredSize(new java.awt.Dimension(600, 400));
						this.setSize(600, 400);
						this.setForeground(new java.awt.Color(64, 0, 128));
						this.setBorder(BorderFactory.createEmptyBorder());
						this.setBackground(Color.white);
							{
								jspChemicals = new JScrollPane();
								this.add(jspChemicals, BorderLayout.CENTER);
								jspChemicals.setPreferredSize(new java.awt.Dimension(800, 600));
									{
										cuiChemicals = new ChemicalsUI(basicLayout,rootHelpContext);
										jspChemicals.setViewportView(cuiChemicals);
										cuiChemicals.add(false);
									}
							}
							{
								letuiToolbar = new ListEditorToolbarUI(cuiChemicals, "chemical", ListEditorToolbarUI.DEFAULT, FlowLayout.RIGHT);
								this.add(letuiToolbar, BorderLayout.SOUTH);
								letuiToolbar.setPreferredSize(new java.awt.Dimension(400, 17));
								letuiToolbar.setVisible(false);
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
				if (o instanceof Initiators)
					letuiToolbar.updateEditButtons(readonly);
				else if (o instanceof Initiator_ChemicalStructure)
					{
						cuiChemicals.get(0).load(o, readonly);
						letuiToolbar.updateEditButtons(false);
					}
				else
					return;
				updateOptimalSize();
			}
		
		public void updateOptimalSize()
			{
				Container parent = getParent();
				if (parent != null)
					optimalSize.width = parent.getWidth();
				optimalSize.height = cuiChemicals.getPreferredSize().height;
				jspChemicals.getViewport().revalidate();
				this.setSize(optimalSize);
				this.setPreferredSize(optimalSize);
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
		
		public EditChemicalsUI setHeaderAllowRedirecting(boolean allow)
			{
				cuiChemicals.setAllowRedirecting(allow);
				return this;
			}
		
		private Dimension	optimalSize	= new Dimension(800, 600);
		
	}
