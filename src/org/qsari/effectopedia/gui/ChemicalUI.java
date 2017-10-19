package org.qsari.effectopedia.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.EventObject;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import org.qsari.effectopedia.core.objects.Initiator_ChemicalStructure;
import org.qsari.effectopedia.data.objects.ObjectProperty;
import org.qsari.effectopedia.defaults.DefaultEffectopediaObjects;
import org.qsari.effectopedia.defaults.DefaultGOSettings;
import org.qsari.effectopedia.gui.ChemicalHeaderUI.TitleChangeListener;
import org.qsari.effectopedia.gui.ChemicalInfoUI.ChemicalInfoChangeListener;
import org.qsari.effectopedia.gui.core.LoadableEditorUI;
import org.qsari.effectopedia.gui.help.ContextSensitivePanel;
import org.qsari.effectopedia.gui.help.RootHelpContext;
import org.qsari.effectopedia.gui.obj_prop.QualityAssuranceUI;

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
 * @version 1.0 @(#)ChemicalUI.java 1.0
 * @author Hristo Aladjov
 * 
 */

public class ChemicalUI extends ContextSensitivePanel implements AdjustableUI, LoadableEditorUI, ChemicalInfoChangeListener, TitleChangeListener, SizeOptimizableUI, RootHelpContext
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
				frame.getContentPane().add(new ChemicalUI());
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				frame.pack();
				frame.setVisible(true);
			}
		
		private ReferencesUI												ruiReferences;
		private ChemicalHeaderUI								chuiChemicalHeader;
		private JPanel																		jpChemical;
		private QualityAssuranceUI						qauiQualityAssurance;
		private PathwaysListUI										pluiAssociatedPathways;
		private JPanel																		jChemicalInfo;
		private IdentifiableStructureUI	isuiStructureID;
		private SubstanceListUI									sluiSubstances;
		private LinkedEffectsListUI					leluiLinkedMIEs;
		private TitledBorder												titledBorder;
		
		/**
		 * Instantiates a new chemical ui.
		 */
		public ChemicalUI()
			{
				super(null);
				setName("chemical");
				initGUI(false);
			}
		
		public ChemicalUI(boolean basicLayout)
			{
				super(null);
				setName("chemical");
				initGUI(basicLayout);
			}
		
		private void initGUI(boolean basicLayout)
			{
				try
					{
						this.basicLayout = basicLayout;
						this.setPreferredSize(new java.awt.Dimension(800, 373));
						BorderLayout thisLayout = new BorderLayout();
						this.setLayout(thisLayout);
						this.setBackground(Color.WHITE);
						titledBorder = BorderFactory.createTitledBorder(new LineBorder(DefaultGOSettings.chemicalColor, 2, false), "Chemical", TitledBorder.LEADING, TitledBorder.TOP,
								new java.awt.Font("Tahoma", 1, 11), DefaultGOSettings.chemicalColor);
						this.setBorder(titledBorder);
							
							{
								jpChemical = new JPanel();
								BorderLayout jpChemicalLayout = new BorderLayout();
								jpChemical.setLayout(jpChemicalLayout);
								this.add(jpChemical, BorderLayout.NORTH);
								jpChemical.setPreferredSize(new java.awt.Dimension(800, 80));
								jpChemical.setBackground(Color.white);
									{
										chuiChemicalHeader = new ChemicalHeaderUI(rootHelpContext);
										jpChemical.add(chuiChemicalHeader, BorderLayout.NORTH);
										chuiChemicalHeader.setPreferredSize(new java.awt.Dimension(800, 32));
										chuiChemicalHeader.addTitleChangeChangeListener(this);
									}
									{
										qauiQualityAssurance = new QualityAssuranceUI(rootHelpContext);
										jpChemical.add(qauiQualityAssurance, BorderLayout.CENTER);
										qauiQualityAssurance.setPreferredSize(new java.awt.Dimension(800, 38));
									}
							}
							{
								jChemicalInfo = new JPanel();
								jChemicalInfoLayout = new GridBagLayout();
								this.add(jChemicalInfo, BorderLayout.CENTER);
								jChemicalInfoLayout.rowWeights = new double[]
									{ 0.2, 0.1, 0.1, 0.1, 0.1 };
								jChemicalInfoLayout.rowHeights = new int[]
									{ 14, basicLayout ? 7 : 14, 7, 7, 7 };
								jChemicalInfoLayout.columnWeights = new double[]
									{ 1 };
								jChemicalInfoLayout.columnWidths = new int[]
									{ 1 };
								jChemicalInfo.setLayout(jChemicalInfoLayout);
								jChemicalInfo.setPreferredSize(new java.awt.Dimension(800, 150));
									{
										isuiStructureID = new IdentifiableStructureUI(basicLayout,rootHelpContext);
										jChemicalInfo.add(isuiStructureID, new GridBagConstraints(0, 0, 1, 1, 0.2, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
										isuiStructureID.setBackground(Color.WHITE);
										isuiStructureID.addChemicalInfoChangeListener(this);
									}
									{
										sluiSubstances = new SubstanceListUI(basicLayout,rootHelpContext);
										jChemicalInfo.add(sluiSubstances, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
									}
									{
										leluiLinkedMIEs = new LinkedEffectsListUI(false,rootHelpContext);
										leluiLinkedMIEs.setBorder(BorderFactory.createTitledBorder(null, "Associated Molecular Initiating Events", TitledBorder.LEADING, TitledBorder.TOP, new java.awt.Font("Tahoma", 2, 11)));
										leluiLinkedMIEs.setHorizontalPlacement(false);
										jChemicalInfo.add(leluiLinkedMIEs, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
									}
									{
										pluiAssociatedPathways = new PathwaysListUI(rootHelpContext);
										jChemicalInfo.add(pluiAssociatedPathways, new GridBagConstraints(0, 3, 1, 1, 0.4, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
									}
									
									{
										ruiReferences = new ReferencesUI(rootHelpContext);
										jChemicalInfo.add(ruiReferences, new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
										ruiReferences.setVisible(true);
									}
							}
						RootHelpContext.addMouseMotionListeners(this, rootHelpContext,false);
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
			/*	if (visualOptions == AdjustableUI.SUBST_VIEW)
					{
						jChemicalInfoLayout.rowWeights[0] = 0;
						jChemicalInfoLayout.rowHeights[0] = 0;
					}
				else
					{
						jChemicalInfoLayout.rowWeights[0] = 0.3;
						jChemicalInfoLayout.rowHeights[0] = 21;
					}
				*/
				// System.out.println("options:"+visualOptions);
				// if jChemicalInfoLayout.rowWeights = new double[]
				// { 0.3, 0.1, 0.1, 0.1, 0.1 };
				//AdjustbleUserInterfaceTools.adjustChildren(this, visualOptions);
			}
		
		@Override
		public void infoChanged(EventObject evt)
			{
				if (chemical != null)
					{
						ObjectProperty property = chemical.getIdentification().getProperty(DefaultEffectopediaObjects.CHEMICAL_INFO_SMILES.getName());
						if (property != null)
							{
								String smiles = property.getDisplayValue();
								if (smiles != null)
									{
										try
											{
												String url = "https://apps.ideaconsult.net/ambit2/depict/cdk?search=" + URLEncoder.encode(smiles, "UTF-8") + "&w=200&h=200&media=image/png";
												property = chemical.getStructure2DImage();
												property.setValue(url);
												isuiStructureID.siui2DImage.load(property, chemical.isReadonly());
												sluiSubstances.reload();
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
				if (!(o instanceof Initiator_ChemicalStructure))
					return;
				chemical = (Initiator_ChemicalStructure) o;
				readonly = readonly || chemical.isReadonly();
				qauiQualityAssurance.load(chemical.getQA(), readonly);
				pluiAssociatedPathways.load(chemical.getPathwayIDs(), readonly);
				leluiLinkedMIEs.load(chemical.getDownstreamLinkIDs(), readonly);
				ruiReferences.load(chemical.getReferenceIDs(), readonly);
				sluiSubstances.load(chemical.getSubstanceIDs(), readonly);
				isuiStructureID.load(chemical, readonly);
				titledBorder.setTitle((readonly) ? "Chemical Structure - read only " : "Chemical Structure");
				chuiChemicalHeader.load(chemical, readonly);
				updateOptimalSize();
			}
		
		public void updateOptimalSize()
			{
				Container parent = getParent();
				if (parent != null)
					optimalSize.width = getParent().getWidth() - 16;
				optimalSize.height = chuiChemicalHeader.getPreferredSize().height + qauiQualityAssurance.getPreferredSize().height + pluiAssociatedPathways.getPreferredSize().height
						+ leluiLinkedMIEs.getPreferredSize().height + isuiStructureID.getPreferredSize().height + ruiReferences.getPreferredSize().height + 8;
					optimalSize.height += sluiSubstances.getPreferredSize().height;
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
		
		@Override
		public void onTitleChanged(EventObject evt)
			{
				if (chemical != null)
					sluiSubstances.reload();
			}
		
		public ChemicalUI setHeaderAllowRedirecting(boolean allow)
			{
				chuiChemicalHeader.setAllowRedirecting(allow);
				return this;
			}
		
		private boolean																					basicLayout;
		private GridBagLayout															jChemicalInfoLayout;
		private Initiator_ChemicalStructure	chemical;
		private Dimension																			optimalSize	= new Dimension(800, 600);
		
	}
