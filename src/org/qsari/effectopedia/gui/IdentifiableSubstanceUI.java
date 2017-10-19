package org.qsari.effectopedia.gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.WindowConstants;

import org.qsari.effectopedia.core.objects.Substance;
import org.qsari.effectopedia.data.interfaces.IdentifiableSubstance;
import org.qsari.effectopedia.gui.core.LoadableEditorUI;
import org.qsari.effectopedia.gui.help.RootHelpContext;
import org.qsari.effectopedia.gui.obj_prop.ObjectPropertiesListUI;

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
public class IdentifiableSubstanceUI extends javax.swing.JSplitPane implements AdjustableUI, LoadableEditorUI, SizeOptimizableUI
	{
		
		/**
		* 
		*/
		private static final long serialVersionUID = 1L;
		
		/**
		 * Auto-generated main method to display this JPanel inside a new JFrame.
		 */
		public static void main(String[] args)
			{
				JFrame frame = new JFrame();
				frame.getContentPane().add(new IdentifiableSubstanceUI(null));
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				frame.pack();
				frame.setVisible(true);
			}
			
		/** The table with basic substance identification information. */
		protected ObjectPropertiesListUI	opluiChemInfo;
		
		/** The table with substance properties (experimental and calculated). */
		protected ObjectPropertiesListUI	opluiChemProperties;
		
		private JPanel																			jpBasicInfo;
		
		/**
		 * Instantiates a new chemical ui.
		 */
		public IdentifiableSubstanceUI(RootHelpContext rootHelpContext)
			{
				super();
				this.rootHelpContext = rootHelpContext;
				basicLayout = false;
				initGUI();
			}
			
		public IdentifiableSubstanceUI(boolean basicLayout, RootHelpContext rootHelpContext)
			{
				super();
				this.rootHelpContext = rootHelpContext;
				this.basicLayout = basicLayout;
				initGUI();
			}
			
		private void initGUI()
			{
				try
					{
						// this.setMinimumSize(optimalSize);
							{
								jpBasicInfo = new JPanel();
								BoxLayout jpBasicInfoLayout = new BoxLayout(jpBasicInfo, (basicLayout) ? javax.swing.BoxLayout.Y_AXIS : javax.swing.BoxLayout.X_AXIS);
								this.add(jpBasicInfo, JSplitPane.LEFT);
								jpBasicInfo.setLayout(jpBasicInfoLayout);
								jpBasicInfo.setBackground(Color.WHITE);
									{
										opluiChemInfo = new ObjectPropertiesListUI("Substance identification", "substance identifier", "", rootHelpContext);
										opluiChemInfo.setOwnerClass(Substance.class);
										jpBasicInfo.add(opluiChemInfo);
										opluiChemInfo.setPreferredSize(new java.awt.Dimension(205, 300));
										opluiChemInfo.setVisible(!basicLayout);
									}
							}
							{
								jspContent = new JSplitPane();
								jspContent.setOneTouchExpandable(true);
								jspContent.setResizeWeight(0.40);
								jspContent.setBackground(Color.white);
								jspContent.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
								this.add(jspContent, JSplitPane.RIGHT);
								this.setResizeWeight(basicLayout ? 0 : 0.20);
									{
										opluiChemProperties = new ObjectPropertiesListUI("Substance Properties", "substance property", "", rootHelpContext);
										opluiChemProperties.setOwnerClass(Substance.class);
										jspContent.add(opluiChemProperties, JSplitPane.RIGHT);
										opluiChemProperties.setVisible(!basicLayout);
									}
									{
										cluiConstituents = new ConstituentListUI(basicLayout, rootHelpContext);
										jspContent.add(cluiConstituents, JSplitPane.LEFT);
									}
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
				if (!(o instanceof IdentifiableSubstance))
					return;
				substance = (IdentifiableSubstance) o;
				opluiChemInfo.load(substance.getIdentification(), readonly);
				opluiChemProperties.load(substance.getProperties(), readonly);
				cluiConstituents.load(substance.getComposition(), readonly);
				updateOptimalSize();
			}
			
		public void updateOptimalSize()
			{
				optimalSize.width = cluiConstituents.getPreferredSize().width;
				if (basicLayout)
					optimalSize.width += opluiChemInfo.getPreferredSize().width + opluiChemProperties.getPreferredSize().width;
				optimalSize.height = cluiConstituents.getPreferredSize().height;
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
			
		public void setBasicInfoOrientation(boolean horizontal)
			{
				BoxLayout jpBasicInfoLayout = new BoxLayout(jpBasicInfo, (horizontal) ? javax.swing.BoxLayout.X_AXIS : javax.swing.BoxLayout.Y_AXIS);
				jpBasicInfo.setLayout(jpBasicInfoLayout);
			}
			
		private boolean															basicLayout;
		private IdentifiableSubstance	substance;
		private JSplitPane												jspContent;
		protected ConstituentListUI			cluiConstituents;
		private Dimension													optimalSize	= new Dimension(600, 300);
		protected RootHelpContext					rootHelpContext;
	}
