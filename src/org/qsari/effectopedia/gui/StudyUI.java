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

import org.qsari.effectopedia.core.objects.Method_Study;
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
public class StudyUI extends javax.swing.JScrollPane implements AdjustableUI, LoadableEditorUI, ComponentListener, InitializableUI
	{
		/**
		* 
		*/
		
		private static final long					serialVersionUID	= 1207971105123532796L;
		private MethodHeaderUI								mhuiHeader;
		private QualityAssuranceUI				qauiQualityAssurance;
		private ReferencesUI										ruiReferences;
		private PathwaysListUI								pluiAssociatedPathways;
		private DescriptionUI									duiDescription;
		private ContextSensitivePanel	cspEditPanel;
		private RelatedTestsListUI				rtluiRelatedTests;
		private String																StudyCaption;
		private TitledBorder										titledBorder;
		
		/**
		 * Auto-generated main method to display this JPanel inside a new JFrame.
		 */
		public static void main(String[] args)
			{
				JFrame frame = new JFrame();
				frame.getContentPane().add(new StudyUI(null));
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				frame.pack();
				frame.setVisible(true);
			}
			
		public StudyUI(RootHelpContext rootHelpContext)
			{
				super();
				this.rootHelpContext = rootHelpContext;
				setName("study");
				this.StudyCaption = "Study";
				initGUI();
				adjustUI(EDIT);
			}
			
		public StudyUI(String InvestigationCaption,RootHelpContext rootHelpContext)
			{
				super();
				this.rootHelpContext = rootHelpContext;
				setName("study");
				this.StudyCaption = InvestigationCaption;
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
						titledBorder = BorderFactory.createTitledBorder(new LineBorder(DefaultGOSettings.inVivoTestColor, 2, true), StudyCaption, TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION,
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
								rtluiRelatedTests = new RelatedTestsListUI(rootHelpContext);
								rtluiRelatedTests.setBorder(BorderFactory.createTitledBorder(null, "Associated tests", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 2, 12)));
								cspEditPanel.add(rtluiRelatedTests);
							}
							{
								pluiAssociatedPathways = new PathwaysListUI(rootHelpContext);
								cspEditPanel.add(pluiAssociatedPathways);
							}
							{
								ruiReferences = new ReferencesUI(rootHelpContext);
								cspEditPanel.add(ruiReferences);
								ruiReferences.setMinimumSize(new java.awt.Dimension(200, 90));
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
			
		@Override
		public void load(Object o, boolean readonly)
			{
				if (!(o instanceof Method_Study))
					return;
				study = (Method_Study) o;
				readonly = readonly || study.isReadonly();
				mhuiHeader.load(study, readonly);
				qauiQualityAssurance.load(study.getQA(), readonly);
				ruiReferences.load(study.getReferenceIDs(), readonly);
				rtluiRelatedTests.load(study.getRelatedTests(), readonly);
				duiDescription.load(study.getDescriptionIDs(), readonly);
				pluiAssociatedPathways.load(study.getPathwayIDs(), readonly);
				StudyCaption = StringCaseUtil.TitleCase(TraceableClasses.REGISTERED.getDescription(study.getClass()));
				titledBorder.setTitle((readonly) ? StudyCaption + " - read only " : StudyCaption);
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
				optimalSize.height = mhuiHeader.getPreferredSize().height + qauiQualityAssurance.getPreferredSize().height + ruiReferences.getPreferredSize().height + rtluiRelatedTests.getPreferredSize().height
						+ pluiAssociatedPathways.getPreferredSize().height + duiDescription.getPreferredSize().height;
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
			
		private Dimension				optimalSize	= new Dimension(400, 1000);
		private Method_Study	study;
		RootHelpContext rootHelpContext;
	}
