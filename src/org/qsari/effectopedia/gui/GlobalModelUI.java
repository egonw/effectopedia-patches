package org.qsari.effectopedia.gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import org.qsari.effectopedia.core.objects.Method_InSilicoGlobalModel;
import org.qsari.effectopedia.defaults.DefaultEffectopediaObjects;
import org.qsari.effectopedia.defaults.DefaultGOSettings;
import org.qsari.effectopedia.gui.core.LoadableEditorUI;
import org.qsari.effectopedia.gui.help.ContextSensitivePanel;
import org.qsari.effectopedia.gui.help.RootHelpContext;
import org.qsari.effectopedia.gui.obj_prop.ObjectPropertiesListUI;
import org.qsari.effectopedia.gui.obj_prop.QualityAssuranceUI;
import org.qsari.effectopedia.gui.obj_prop.ResourcesUI;
import org.qsari.effectopedia.gui.toolbars.ListEditorToolbarUI;
import org.qsari.effectopedia.gui.toolbars.ListEditorToolbarUI.ListEditorActionListener;
import org.qsari.effectopedia.system.TraceableClasses;
import org.qsari.effectopedia.utils.StringCaseUtil;

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
public class GlobalModelUI extends javax.swing.JScrollPane implements AdjustableUI, LoadableEditorUI, ComponentListener, InitializableUI, ListEditorActionListener
	{
		/**
	 * 
	 */
		
		private static final long						serialVersionUID	= 1207971105123532796L;
		private MethodHeaderUI									mhuiHeader;
		private QualityAssuranceUI					qauiQualityAssurance;
		private ReferencesUI											ruiReferences;
		private PathwaysListUI									pluiAssociatedPathways;
		private DescriptionUI										duiDescription;
		private ObjectPropertiesListUI	opluiModelParameters;
		private ObjectPropertiesListUI	opluiMetaData;
		private ContextSensitivePanel		cspEditPanel;
		private RelatedTestsListUI					rtluiRelatedTests;
		private String																	globalModelCaption;
		private TitledBorder											titledBorder;
		private ResourcesUI												modelResources;
		
		/**
		 * Auto-generated main method to display this JPanel inside a new JFrame.
		 */
		public static void main(String[] args)
			{
				JFrame frame = new JFrame();
				frame.getContentPane().add(new GlobalModelUI(null));
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				frame.pack();
				frame.setVisible(true);
			}
		
		public GlobalModelUI(RootHelpContext rootHelpContext)
			{
				super();
				this.rootHelpContext = rootHelpContext;
				setName("global_model");
				this.globalModelCaption = "Global In Silico Model";
				initGUI();
				adjustUI(EDIT);
			}
		
		public GlobalModelUI(String InvestigationCaption,RootHelpContext rootHelpContext)
			{
				super();
				this.rootHelpContext = rootHelpContext;
				setName("global_model");
				this.globalModelCaption = InvestigationCaption;
				initGUI();
				adjustUI(VIEW);
			}
		
		private void initGUI()
			{
				try
					{
						setPreferredSize(optimalSize);
						this.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
						this.setBackground(Color.WHITE);
						cspEditPanel = new ContextSensitivePanel(rootHelpContext);
						cspEditPanel .setName("global_model");
						
						cspEditPanel.setPreferredSize(new java.awt.Dimension(400, 1000));
						this.setViewportView(cspEditPanel);
						BoxLayout thisLayout = new BoxLayout(cspEditPanel, javax.swing.BoxLayout.Y_AXIS);
						titledBorder = BorderFactory.createTitledBorder(new LineBorder(DefaultGOSettings.inVivoTestColor, 2, true), globalModelCaption, TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION,
								new java.awt.Font("Segoe UI", 1, 12), DefaultGOSettings.inVivoTestColor);
						cspEditPanel.setBorder(titledBorder);
						cspEditPanel.setLayout(thisLayout);
						cspEditPanel.setBackground(new java.awt.Color(255, 255, 255));
							{
								mhuiHeader = new MethodHeaderUI(rootHelpContext);
								cspEditPanel.add(mhuiHeader);
								mhuiHeader.setPreferredSize(new java.awt.Dimension(388, 49));
								mhuiHeader.setBackground(new java.awt.Color(255, 255, 255));
							}
							{
								qauiQualityAssurance = new QualityAssuranceUI(rootHelpContext);
								cspEditPanel.add(qauiQualityAssurance);
							}
							{
								duiDescription = new DescriptionUI(rootHelpContext);
								cspEditPanel.add(duiDescription);
								duiDescription.setPreferredSize(new java.awt.Dimension(388, 93));
							}
							{
								opluiModelParameters = new ObjectPropertiesListUI("Model parameters", "model parameter", "",rootHelpContext);
								cspEditPanel.add(opluiModelParameters);
								duiDescription.setPreferredSize(new java.awt.Dimension(388, 93));
								opluiModelParameters.getListEditorToolbar().addListEditorActionListener(this);
							}
							{
								opluiMetaData = new ObjectPropertiesListUI("Model meta data", "meta data", "",rootHelpContext);
								cspEditPanel.add(opluiMetaData);
							}
							{
								modelResources = new ResourcesUI(rootHelpContext);
								cspEditPanel.add(modelResources);
							}
							
							{
								rtluiRelatedTests = new RelatedTestsListUI(rootHelpContext);
								rtluiRelatedTests.setBorder(BorderFactory.createTitledBorder(null, "Associated in-silico models", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 2, 12)));
								cspEditPanel.add(rtluiRelatedTests);
							}
							{
								pluiAssociatedPathways = new PathwaysListUI(rootHelpContext);
								cspEditPanel.add(pluiAssociatedPathways);
							}
							{
								ruiReferences = new ReferencesUI(rootHelpContext);
								cspEditPanel.add(ruiReferences);
								ruiReferences.setPreferredSize(new java.awt.Dimension(388, 90));
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
				if (!(o instanceof Method_InSilicoGlobalModel))
					return;
				globalModel = (Method_InSilicoGlobalModel) o;
				readonly = readonly || globalModel.isReadonly();
				mhuiHeader.load(globalModel, readonly);
				qauiQualityAssurance.load(globalModel.getQA(), readonly);
				ruiReferences.load(globalModel.getReferenceIDs(), readonly);
				rtluiRelatedTests.load(globalModel.getModelCallers(), readonly);
				duiDescription.load(globalModel.getDescriptionIDs(), readonly);
				opluiModelParameters.load(globalModel.getModelParamaters(), readonly);
				opluiMetaData.load(globalModel.getModelMetadata(), readonly);
				pluiAssociatedPathways.load(globalModel.getPathwayIDs(), readonly);
				globalModel.getModelExecutor().setGlobalModel(globalModel, null);
				globalModel.getModelExecutor().updateResources();
				modelResources.load(globalModel.getResources(), readonly);
				globalModelCaption = StringCaseUtil.TitleCase(TraceableClasses.REGISTERED.getDescription(globalModel.getClass()));
				titledBorder.setTitle((readonly) ? globalModelCaption + " - read only " : globalModelCaption);
				updateOptimalSize();
				initializeUI();
			}
		
		@Override
		public void componentHidden(ComponentEvent e)
			{
				
			}
		
		@Override
		public void componentMoved(ComponentEvent e)
			{
				
			}
		
		@Override
		public void componentResized(ComponentEvent e)
			{
				cspEditPanel.setPreferredSize(new Dimension((int) this.getVisibleRect().getWidth(), 800));
			}
		
		@Override
		public void componentShown(ComponentEvent e)
			{
				
			}
		
		public void updateOptimalSize()
			{
				Insets insets = getBorder().getBorderInsets(this);
				optimalSize.width = getWidth() + insets.left + insets.right;
				optimalSize.height = mhuiHeader.getPreferredSize().height + qauiQualityAssurance.getPreferredSize().height + ruiReferences.getPreferredSize().height + rtluiRelatedTests.getPreferredSize().height
						+ pluiAssociatedPathways.getPreferredSize().height + duiDescription.getPreferredSize().height + opluiModelParameters.getPreferredSize().height + opluiMetaData.getPreferredSize().height
						+ modelResources.getPreferredSize().height;
				optimalSize.height += insets.top + insets.bottom;
				cspEditPanel.setPreferredSize(optimalSize);
				this.getViewport().revalidate();
				Container parent = getParent();
				if ((parent != null) && (parent instanceof SizeOptimizableUI))
					((SizeOptimizableUI) parent).updateOptimalSize();
				else
					invalidate();
			}
		
		public void initializeUI()
			{
				qauiQualityAssurance.initializeUI();
				duiDescription.initializeUI();
				opluiModelParameters.initializeUI();
				opluiMetaData.initializeUI();
				ruiReferences.initializeUI();
				mhuiHeader.initializeUI();
			}
		
		@Override
		public int listEditorActionPerformed(int actionCode)
			{
				if (globalModel != null)
					{
						globalModel.getModelPersets().clear();
						if ((actionCode == ListEditorToolbarUI.ADD) && (globalModel.getModelParamaters() == null))
							{
								globalModel.setModelParamaters(DefaultEffectopediaObjects.DEFAULT_MODEL_PARAMETERS.clone(globalModel, globalModel.getDataSource()));
								opluiModelParameters.load(globalModel.getModelParamaters(), globalModel.isReadonly());
								// mpluiModelParameters.getListEditorToolbar().removeListEditorActionListener(this);
							}
					}
				return actionCode;
			}
		
		private Dimension																		optimalSize	= new Dimension(400, 1000);
		private Method_InSilicoGlobalModel	globalModel;
	 protected RootHelpContext rootHelpContext;	
	}
