package org.qsari.effectopedia.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.EventObject;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import org.qsari.effectopedia.core.objects.Initiator_ChemicalStructure;
import org.qsari.effectopedia.data.interfaces.IdentifiableStructure;
import org.qsari.effectopedia.data.objects.ObjectProperty;
import org.qsari.effectopedia.defaults.DefaultEffectopediaObjects;
import org.qsari.effectopedia.gui.ChemicalInfoUI.ChemicalInfoChangeListener;
import org.qsari.effectopedia.gui.core.LoadableEditorUI;
import org.qsari.effectopedia.gui.help.ContextSensitivePanel;
import org.qsari.effectopedia.gui.help.RootHelpContext;
import org.qsari.effectopedia.gui.obj_prop.ObjectPropertiesListUI;
import org.qsari.effectopedia.gui.toolbars.ListEditorToolbarUI.ListEditorActionListener;

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
public class IdentifiableStructureUI extends ContextSensitivePanel implements AdjustableUI, LoadableEditorUI, ChemicalInfoChangeListener, ListEditorActionListener
	{
		
		/**
	 * 
	 */
		private static final long	serialVersionUID	= 1L;
		
		/**
		 * Auto-generated main method to display this JPanel inside a new JFrame.
		 */
		public static void main(String[] args)
			{
				JFrame frame = new JFrame();
				frame.getContentPane().add(new IdentifiableStructureUI(null));
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				frame.pack();
				frame.setVisible(true);
			}
		
		/** The 2D image of the structure. */
		protected StructureImageUI							siui2DImage;
		/** The table with basic chemical information. */
		protected ChemicalInfoUI									ciuiChemInfo;
		/** The table with basic chemical properties (experimental and calculated). */
		protected ObjectPropertiesListUI	opluiChemProperties;
		
		/** The list of known synonyms. */
		protected SynonymsUI													suiSynonyms;
		private JPanel																			jpBasicInfo;
		
		/**
		 * Instantiates a new chemical ui.
		 */
		public IdentifiableStructureUI(RootHelpContext rootHelpContext)
			{
				super(rootHelpContext);
				setName("strucuture");
				basicLayout = false;
				initGUI();
			}
		
		public IdentifiableStructureUI(boolean basicLayout,RootHelpContext rootHelpContext)
			{
				super(rootHelpContext);
				this.basicLayout = basicLayout;
				initGUI();
			}
		
		private void initGUI()
			{
				try
					{
						int visible = (basicLayout) ? 0 : 1;
						// this.setMinimumSize(optimalSize);
						jChemicalInfoLayout = new GridBagLayout();
						jChemicalInfoLayout.rowWeights = new double[]
							{ 1 };
						jChemicalInfoLayout.rowHeights = new int[]
							{ (basicLayout) ? 300 : 150 };
						jChemicalInfoLayout.columnWeights = new double[]
							{ 0.1, 0.1, 0.12 * visible, 0.08 * visible };
						jChemicalInfoLayout.columnWidths = new int[]
							{ 10, 10, 12 * visible, 8 * visible };
						this.setLayout(jChemicalInfoLayout);
							
							{
								jpBasicInfo = new JPanel();
								this.add(jpBasicInfo, new GridBagConstraints(0, 0, 2, 1, 0.2, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
								BoxLayout jpBasicInfoLayout = new BoxLayout(jpBasicInfo, (basicLayout) ? javax.swing.BoxLayout.Y_AXIS : javax.swing.BoxLayout.X_AXIS);
								jpBasicInfo.setLayout(jpBasicInfoLayout);
								jpBasicInfo.setBackground(Color.WHITE);
									{
										siui2DImage = new StructureImageUI(rootHelpContext);
										jpBasicInfo.add(siui2DImage);
										siui2DImage.setPreferredSize(new java.awt.Dimension(198, 107));
									}
									{
										ciuiChemInfo = new ChemicalInfoUI("Chemical Info",rootHelpContext);
										jpBasicInfo.add(ciuiChemInfo);
										ciuiChemInfo.addChemicalInfoChangeListener(this);
									}
							}
							
							{
								opluiChemProperties = new ObjectPropertiesListUI("Chemical Structure Properties", "structure property", "",rootHelpContext);
								opluiChemProperties.setOwnerClass(Initiator_ChemicalStructure.class);
								this.add(opluiChemProperties, new GridBagConstraints(2, 0, 1, 1, 0.12, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
								opluiChemProperties.getListEditorToolbar().addListEditorActionListener(this);
								opluiChemProperties.setVisible(!basicLayout);
							}
							/*
							 * { cpuiChemProperties = new
							 * ChemicalPropertiesUI("Chemical Structure Properties");
							 * this.add(cpuiChemProperties, new GridBagConstraints(2, 0, 1, 1, 0.12,
							 * 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0,
							 * 0, 0, 0), 0, 0)); cpuiChemProperties.setVisible(!basicLayout); }
							 */
							{
								suiSynonyms = new SynonymsUI(rootHelpContext);
								this.add(suiSynonyms, new GridBagConstraints(3, 0, 1, 1, 0.08, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
								suiSynonyms.setMinimumSize(new Dimension(0, 0));
								suiSynonyms.setVisible(!basicLayout);
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
				if (visualOptions == AdjustableUI.SUBST_VIEW)
					{
						jChemicalInfoLayout.rowWeights[0] = 0;
						jChemicalInfoLayout.rowHeights[0] = 0;
					}
				else
					{
						jChemicalInfoLayout.rowWeights[0] = 0.3;
						jChemicalInfoLayout.rowHeights[0] = 21;
					}
				
				// System.out.println("options:"+visualOptions);
				// if jChemicalInfoLayout.rowWeights = new double[]
				// { 0.3, 0.1, 0.1, 0.1, 0.1 };
				AdjustbleUserInterfaceTools.adjustChildren(this, visualOptions);
			}
		
		public void updateLayout()
			{
				int visible = (basicLayout) ? 0 : 1;
				// this.setPreferredSize(optimalSize);
				jChemicalInfoLayout.rowWeights = new double[]
					{ 1 };
				jChemicalInfoLayout.rowHeights = new int[]
					{ (basicLayout) ? 240 : 150 };
				jChemicalInfoLayout.columnWeights = new double[]
					{ 0.1, 0.1, 0.12 * visible, 0.08 * visible };
				jChemicalInfoLayout.columnWidths = new int[]
					{ 100, 100, 102 * visible, 80 * visible };
				this.setLayout(jChemicalInfoLayout);
				this.revalidate();
			}
		
		@Override
		public void infoChanged(EventObject evt)
			{
				if (structure != null)
					{
						ObjectProperty property = structure.getIdentification().getProperty(DefaultEffectopediaObjects.CHEMICAL_INFO_SMILES.getName());
						if (property != null)
							{
								String smiles = property.getDisplayValue();
								if (smiles != null)
									{
										try
											{
												String url = "https://apps.ideaconsult.net/ambit2/depict/cdk?search=" + URLEncoder.encode(smiles, "UTF-8") + "&w=200&h=200&media=image/png";
												property = (ObjectProperty) structure.getStructure2DImage();
												property.setValue(url);
												siui2DImage.load(property, true);
											}
										catch (UnsupportedEncodingException e)
											{
												e.printStackTrace();
											}
									}
							}
					}
			}
		
		public void load(Object o, boolean readonly)
			{
				if (!(o instanceof IdentifiableStructure))
					return;
				updateLayout();
				structure = (IdentifiableStructure) o;
				ciuiChemInfo.load(structure.getIdentification(), readonly);
				opluiChemProperties.load(structure.getProperties(), readonly);
				siui2DImage.load(structure.getStructure2DImage(), readonly);
				suiSynonyms.load(structure, readonly);
			}
		
		public void setBasicInfoOrientation(boolean horizontal)
			{
				BoxLayout jpBasicInfoLayout = new BoxLayout(jpBasicInfo, (horizontal) ? javax.swing.BoxLayout.X_AXIS : javax.swing.BoxLayout.Y_AXIS);
				jpBasicInfo.setLayout(jpBasicInfoLayout);
			}
		
		public void addChemicalInfoChangeListener(ChemicalInfoChangeListener listener)
			{
				ciuiChemInfo.addChemicalInfoChangeListener(listener);
			}
		
		public void removeChemicalInfoListener(ChemicalInfoChangeListener listener)
			{
				ciuiChemInfo.removeChemicalInfoListener(listener);
			}
		
		@Override
		public int listEditorActionPerformed(int actionCode)
			{
				return actionCode;
			}
		
		private boolean															basicLayout;
		private GridBagLayout									jChemicalInfoLayout;
		private IdentifiableStructure	structure;
		private Dimension													optimalSize	= new Dimension(600, 300);
		
	}
