package org.qsari.effectopedia.gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import org.qsari.effectopedia.core.objects.Pathway;
import org.qsari.effectopedia.defaults.DefaultGOSettings;
import org.qsari.effectopedia.gui.core.GUIFactory;
import org.qsari.effectopedia.gui.core.LoadableEditorUI;
import org.qsari.effectopedia.gui.help.ContextSensitivePanel;
import org.qsari.effectopedia.gui.help.RootHelpContext;
import org.qsari.effectopedia.gui.help.RootHelpContextScrollPane;
import org.qsari.effectopedia.gui.obj_prop.QualityAssuranceUI;

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
public class EditPathwayUI extends RootHelpContextScrollPane implements AdjustableUI, LoadableEditorUI, SizeOptimizableUI, InitializableUI, Runnable
	{
		/**
		 * 
		 */
		private static final long					serialVersionUID	= 1207971105123532796L;
		private PathwayHeaderUI							phuiHeader;
		private QualityAssuranceUI				qauiQualityAssurance;
		private ReferencesUI										ruiReferences;
		private DescriptionUI									duiDescription;
		private TitledBorder										titledBorder;
		
		/**
		 * Auto-generated main method to display this JPanel inside a new JFrame.
		 */
		public static void main(String[] args)
			{
				JFrame frame = new JFrame();
				frame.getContentPane().add(new EditPathwayUI());
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				frame.pack();
				frame.setVisible(true);
			}
		
		public EditPathwayUI()
			{
				super();
				this.rootHelpContext = this;
				initGUI();
				adjustUI(EDIT);
			}
		
		private void initGUI()
			{
				try
					{
							{
								this.setBackground(Color.WHITE);
							}
						cspEditPanel = new ContextSensitivePanel(rootHelpContext);
						cspEditPanel.setPreferredSize(optimalSize);
						cspEditPanel.setName("pathway");
						this.setViewportView(cspEditPanel);
						BoxLayout thisLayout = new BoxLayout(cspEditPanel, javax.swing.BoxLayout.Y_AXIS);
						titledBorder = BorderFactory.createTitledBorder(new LineBorder(DefaultGOSettings.pathwayColor, 2, true), "Pathway", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new java.awt.Font(
								"Segoe UI", 1, 12), DefaultGOSettings.pathwayColor);
						cspEditPanel.setBorder(titledBorder);
						cspEditPanel.setLayout(thisLayout);
						cspEditPanel.setBackground(Color.WHITE);
							{
								phuiHeader = new PathwayHeaderUI(rootHelpContext);
								cspEditPanel.add(phuiHeader);
							}
							{
								qauiQualityAssurance = new QualityAssuranceUI(rootHelpContext);
								cspEditPanel.add(qauiQualityAssurance);
							}
							{
								duiDescription = new DescriptionUI(rootHelpContext);
								cspEditPanel.add(duiDescription);
							}
							{
								ruiReferences = new ReferencesUI(rootHelpContext);
								cspEditPanel.add(ruiReferences);
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
				if (!(o instanceof Pathway))
					return;
				pathway = (Pathway) o;
				readonly = readonly || pathway.isReadonly();
				pathway.updateEssentiality();
				phuiHeader.load(pathway, readonly);
				qauiQualityAssurance.load(pathway.getQA(), readonly);
				ruiReferences.load(pathway.getReferenceIDs(), readonly);
				duiDescription.load(pathway.getDescriptionIDs(), readonly);
				titledBorder.setTitle((readonly) ? "Pathway - read only " : "Pathway");
				updateOptimalSize();
				initializeUI();
			}
		
		public void initializeUI()
			{
				qauiQualityAssurance.initializeUI();
				duiDescription.initializeUI();
				ruiReferences.initializeUI();
				phuiHeader.initializeUI();
			}
		
		public void updateOptimalSize()
			{
				Component focused = GUIFactory.GUI.getFrame().getFocusOwner();
				Insets insets = getBorder().getBorderInsets(this);
				optimalSize.width = getWidth();
				optimalSize.width -= this.getVerticalScrollBar().isVisible() ? this.getVerticalScrollBar().getPreferredSize().width + 2 : 2;
				// System.out.println("phuiHeader.getPreferredSize().height: "+phuiHeader.getPreferredSize().height);
				// System.out.println("qauiQualityAssurance.getPreferredSize().height: "+qauiQualityAssurance.getPreferredSize().height);
				// System.out.println("duiDescription.getPreferredSize().height: "+duiDescription.getPreferredSize().height);
				// System.out.println("ruiReferences.getPreferredSize().height: "+ruiReferences.getPreferredSize().height);
				optimalSize.height = phuiHeader.getPreferredSize().height + qauiQualityAssurance.getPreferredSize().height + ruiReferences.getPreferredSize().height + duiDescription.getPreferredSize().height
						+ 64;
				optimalSize.height += insets.top + insets.bottom;
				cspEditPanel.setPreferredSize(optimalSize);
				this.getViewport().revalidate();
				if (focused != null)
					this.getViewport().scrollRectToVisible(focused.getBounds());
				Container parent = getParent();
				if ((parent != null) && (parent instanceof SizeOptimizableUI))
					((SizeOptimizableUI) parent).updateOptimalSize();
				else
					invalidate();
				// SwingUtilities.invokeLater(this);
			}
		
		@Override
		public void run()
			{
			//	System.out.println("phuiHeader.getHeight(): " + phuiHeader.getHeight());
			//	System.out.println("qauiQualityAssurance.getHeight(): " + qauiQualityAssurance.getHeight());
			//	System.out.println("duiDescription.getHeight(): " + duiDescription.getHeight());
			//	System.out.println("ruiReferences.getHeight(): " + ruiReferences.getHeight());
			}
		
		public EditPathwayUI setHeaderAllowRedirecting(boolean allow)
			{
				phuiHeader.allowRedirecting = allow;
				return this;
			}
		
		private Dimension	optimalSize	= new Dimension(400, 1000);
		private Pathway			pathway;
		protected RootHelpContext rootHelpContext;
	}
