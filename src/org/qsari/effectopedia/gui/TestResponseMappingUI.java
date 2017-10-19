package org.qsari.effectopedia.gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import org.qsari.effectopedia.core.objects.TestResponseMapping;
import org.qsari.effectopedia.defaults.DefaultGOSettings;
import org.qsari.effectopedia.gui.core.GUIFactory;
import org.qsari.effectopedia.gui.core.LoadableEditorUI;
import org.qsari.effectopedia.gui.help.ContextSensitivePanel;
import org.qsari.effectopedia.gui.help.RootHelpContext;
import org.qsari.effectopedia.gui.help.RootHelpContextScrollPane;
import org.qsari.effectopedia.gui.obj_prop.QualityAssuranceUI;
import org.qsari.effectopedia.system.TraceableClasses;
import org.qsari.effectopedia.utils.StringCaseUtil;

public class TestResponseMappingUI extends RootHelpContextScrollPane implements AdjustableUI, LoadableEditorUI, ComponentListener, InitializableUI
	{
		
		private TestResponseMappingHeaderUI	trmhuiHeader;
		private QualityAssuranceUI										qauiQualityAssurance;
		private TransformationSetListUI					tsluiTransformationSets;
		private ReferencesUI																ruiReferences;
		private PathwaysListUI														pluiAssociatedPathways;
		private DescriptionUI															duiDescription;
		private String																						trmCaption;
		private TitledBorder																titledBorder;
		
		/**
		 * Auto-generated main method to display this JPanel inside a new JFrame.
		 */
		public static void main(String[] args)
			{
				JFrame frame = new JFrame();
				frame.getContentPane().add(new EffectUI());
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				frame.pack();
				frame.setVisible(true);
			}
			
		public TestResponseMappingUI()
			{
				super();
				this.trmCaption = "Test Response Mapping";
				initGUI();
				adjustUI(EDIT);
			}
			
		public TestResponseMappingUI(String trmCaption)
			{
				super();
				setName("test_response_mapping");
				this.trmCaption = trmCaption;
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
						cspEditPanel.setPreferredSize(new java.awt.Dimension(400, 1000));
						this.setViewportView(cspEditPanel);
						BoxLayout thisLayout = new BoxLayout(cspEditPanel, javax.swing.BoxLayout.Y_AXIS);
						titledBorder = BorderFactory.createTitledBorder(new LineBorder(DefaultGOSettings.inVivoTestColor, 2, true), trmCaption, TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION,
								new java.awt.Font("Segoe UI", 1, 12), DefaultGOSettings.inVivoTestColor);
						cspEditPanel.setBorder(titledBorder);
						cspEditPanel.setLayout(thisLayout);
						cspEditPanel.setBackground(Color.WHITE);
							{
								trmhuiHeader = new TestResponseMappingHeaderUI(rootHelpContext);
								cspEditPanel.add(trmhuiHeader);
								trmhuiHeader.setPreferredSize(new java.awt.Dimension(388, 49));
								trmhuiHeader.setBackground(Color.WHITE);
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
								tsluiTransformationSets = new TransformationSetListUI(rootHelpContext);
								cspEditPanel.add(tsluiTransformationSets);
							}
							{
								pluiAssociatedPathways = new PathwaysListUI(rootHelpContext);
								cspEditPanel.add(pluiAssociatedPathways);
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
				if (!(o instanceof TestResponseMapping))
					return;
				trm = (TestResponseMapping) o;
				readonly = readonly || trm.isReadonly();
				this.readonly = readonly;
				trmhuiHeader.load(trm, readonly);
				qauiQualityAssurance.load(trm.getQA(), readonly);
				ruiReferences.load(trm.getReferenceIDs(), readonly);
				duiDescription.load(trm.getDescriptionIDs(), readonly);
				tsluiTransformationSets.load(trm.getTransformationSets(), readonly);
				pluiAssociatedPathways.load(trm.getPathwayIDs(), readonly);
				trmCaption = StringCaseUtil.TitleCase(TraceableClasses.REGISTERED.getDescription(trm.getClass()));
				titledBorder.setTitle((readonly) ? trmCaption + " - read only " : trmCaption);
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
				Component focused = GUIFactory.GUI.getFrame().getFocusOwner();
				Insets insets = getBorder().getBorderInsets(this);
				optimalSize.width = getWidth();
				optimalSize.width -= this.getVerticalScrollBar().isVisible() ? this.getVerticalScrollBar().getPreferredSize().width + 2 : 2;
				optimalSize.height = trmhuiHeader.getPreferredSize().height + qauiQualityAssurance.getPreferredSize().height + ruiReferences.getPreferredSize().height
						+ pluiAssociatedPathways.getPreferredSize().height + duiDescription.getPreferredSize().height;
				optimalSize.height += tsluiTransformationSets.getPreferredSize().height;
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
			}
			
		public void initializeUI()
			{
				qauiQualityAssurance.initializeUI();
				duiDescription.initializeUI();
				ruiReferences.initializeUI();
				trmhuiHeader.initializeUI();
			}
			
		public TestResponseMappingUI setHeaderAllowRedirecting(boolean allow)
			{
				trmhuiHeader.setAllowRedirecting(allow);
				return this;
			}
			
		/**
		* 
		*/
		private static final long							serialVersionUID	= 1L;
		protected Dimension													optimalSize						= new Dimension(400, 1000);
		protected boolean															readonly									= false;
		protected TestResponseMapping			trm;
	}
