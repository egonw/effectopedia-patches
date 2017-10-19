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
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import org.qsari.effectopedia.core.objects.Method_Investigation;
import org.qsari.effectopedia.core.objects.Method_Study;
import org.qsari.effectopedia.defaults.DefaultEffectopediaObjects;
import org.qsari.effectopedia.defaults.DefaultGOSettings;
import org.qsari.effectopedia.gui.core.GUIFactory;
import org.qsari.effectopedia.gui.core.LoadableEditorUI;
import org.qsari.effectopedia.gui.help.ContextSensitivePanel;
import org.qsari.effectopedia.gui.help.RootHelpContext;
import org.qsari.effectopedia.gui.obj_prop.QualityAssuranceUI;
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
public class InvestigationUI extends javax.swing.JScrollPane implements AdjustableUI, LoadableEditorUI, ComponentListener, InitializableUI
	{
		/**
	 * 
	 */
		
		private static final long										serialVersionUID	= 1207971105123532796L;
		private MethodHeaderUI													mhuiHeader;
		private QualityAssuranceUI									qauiQualityAssurance;
		private ReferencesUI															ruiReferences;
		private PathwaysListUI													pluiAssociatedPathways;
		private DescriptionUI														duiDescription;
		private ContextSensitivePanel						cspEditPanel;
		private MethodListUI<Method_Study>	mluiAssociatedStudies;
		private String																					InvestigationCaption;
		private TitledBorder															titledBorder;
		
		/**
		 * Auto-generated main method to display this JPanel inside a new JFrame.
		 */
		public static void main(String[] args)
			{
				JFrame frame = new JFrame();
				frame.getContentPane().add(new InvestigationUI(null));
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				frame.pack();
				frame.setVisible(true);
			}
		
		public InvestigationUI(RootHelpContext rootHelpContext)
			{
				super();
				this.rootHelpContext = rootHelpContext;
				setName("investigation");
				this.InvestigationCaption = "Investigation";
				initGUI();
				adjustUI(EDIT);
			}
		
		public InvestigationUI(String InvestigationCaption,RootHelpContext rootHelpContext)
			{
				super();
				this.rootHelpContext = rootHelpContext;
				setName("investigation");
				this.InvestigationCaption = InvestigationCaption;
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
						cspEditPanel.setName("investigation");
						
						cspEditPanel.setPreferredSize(new java.awt.Dimension(400, 1000));
						this.setViewportView(cspEditPanel);
						BoxLayout thisLayout = new BoxLayout(cspEditPanel, javax.swing.BoxLayout.Y_AXIS);
						titledBorder = BorderFactory.createTitledBorder(new LineBorder(DefaultGOSettings.inVivoTestColor, 2, true), InvestigationCaption, TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION,
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
								mluiAssociatedStudies = new MethodListUI<Method_Study>("Associated studies", "study", DefaultEffectopediaObjects.DEFAULT_STUDY,rootHelpContext);
								cspEditPanel.add(mluiAssociatedStudies);
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
				if (!(o instanceof Method_Investigation))
					return;
				investigation = (Method_Investigation) o;
				readonly = readonly || investigation.isReadonly();
				mhuiHeader.load(investigation, readonly);
				qauiQualityAssurance.load(investigation.getQA(), readonly);
				ruiReferences.load(investigation.getReferenceIDs(), readonly);
				mluiAssociatedStudies.load(investigation.getRelatedStudies(), readonly);
				duiDescription.load(investigation.getDescriptionIDs(), readonly);
				pluiAssociatedPathways.load(investigation.getPathwayIDs(), readonly);
				InvestigationCaption = StringCaseUtil.TitleCase(TraceableClasses.REGISTERED.getDescription(investigation.getClass()));
				titledBorder.setTitle((readonly) ? InvestigationCaption + " - read only " : InvestigationCaption);
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
				optimalSize.width = getWidth() + insets.left + insets.right;
				optimalSize.height = mhuiHeader.getPreferredSize().height + qauiQualityAssurance.getPreferredSize().height + ruiReferences.getPreferredSize().height
						+ mluiAssociatedStudies.getPreferredSize().height + pluiAssociatedPathways.getPreferredSize().height + duiDescription.getPreferredSize().height;
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
				javax.swing.SwingUtilities.invokeLater(new Runnable()
					{
						public void run()
							{
								getViewport().setViewPosition(TOPLEFT);
							}
					});
				qauiQualityAssurance.initializeUI();
				duiDescription.initializeUI();
				ruiReferences.initializeUI();
			}
		
		private Dimension												optimalSize	= new Dimension(400, 1000);
		private Method_Investigation	investigation;
		protected RootHelpContext rootHelpContext;
	}
