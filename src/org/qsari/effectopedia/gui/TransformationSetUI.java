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
import javax.swing.border.TitledBorder;

import org.qsari.effectopedia.core.objects.TransformationSet;
import org.qsari.effectopedia.data.quantification.FunctionalRelationships;
import org.qsari.effectopedia.gui.core.LoadableEditorUI;
import org.qsari.effectopedia.gui.help.ContextSensitivePanel;
import org.qsari.effectopedia.gui.help.RootHelpContext;
import org.qsari.effectopedia.gui.obj_prop.TransformationFunctionsListUI;
import org.qsari.effectopedia.gui.toolbars.ListEditorToolbarUI;
import org.qsari.effectopedia.gui.toolbars.ListEditorToolbarUI.ListEditorActionListener;

public class TransformationSetUI extends ContextSensitivePanel implements AdjustableUI, LoadableEditorUI, ComponentListener, InitializableUI, ListEditorActionListener
	{
		
		private TransformationSetHeaderUI					trmhuiHeader;
		private ReferencesUI																		ruiReferences;
		private DescriptionUI																	duiDescription;
		private TransformationFunctionsListUI	tfluiTransformationFunctions;
		private String																								trSetCaption;
		private TitledBorder																		titledBorder;
		
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
			
		public TransformationSetUI(RootHelpContext rootHelpContext)
			{
				super(rootHelpContext);
				this.trSetCaption = "Transformation Function Set";
				initGUI();
				adjustUI(EDIT);
			}
			
		public TransformationSetUI(String trmCaption, RootHelpContext rootHelpContext)
			{
				super(rootHelpContext);
				setName("transformation_set");
				this.trSetCaption = trmCaption;
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
						this.setPreferredSize(new java.awt.Dimension(400, 600));
						BoxLayout thisLayout = new BoxLayout(this, javax.swing.BoxLayout.Y_AXIS);
						// titledBorder = BorderFactory.createTitledBorder(new
						// LineBorder(DefaultGOSettings.inVivoTestColor, 1, true), trSetCaption,
						// TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new java.awt.Font(
						// "Segoe UI", 2, 12), DefaultGOSettings.inVivoTestColor);
						// this.setBorder(titledBorder);
						this.setLayout(thisLayout);
						this.setBackground(Color.WHITE);
							{
								trmhuiHeader = new TransformationSetHeaderUI(getRootHelpContext());
								this.add(trmhuiHeader);
								trmhuiHeader.setPreferredSize(new java.awt.Dimension(388, 49));
								trmhuiHeader.setBackground(Color.WHITE);
							}
							{
								duiDescription = new DescriptionUI(rootHelpContext);
								this.add(duiDescription);
							}
							{
								tfluiTransformationFunctions = new TransformationFunctionsListUI(rootHelpContext);
								tfluiTransformationFunctions.getListEditorUI().addListEditorActionListener(this);
								
								this.add(tfluiTransformationFunctions);
							}
							{
								ruiReferences = new ReferencesUI(rootHelpContext);
								this.add(ruiReferences);
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
				if (!(o instanceof TransformationSet))
					return;
				transformationSet = (TransformationSet) o;
				readonly = readonly || transformationSet.isReadonly();
				this.readonly = readonly;
				trmhuiHeader.load(transformationSet, readonly);
				duiDescription.load(transformationSet.getDescriptionIDs(), readonly);
				tfluiTransformationFunctions.load(transformationSet.getTransformationFunctions(), readonly);
				ruiReferences.load(transformationSet.getReferenceIDs(), readonly);
				// trSetCaption =
				// StringCase.TitleCase(TraceableClasses.REGISTERED.getDescription(transformationSet.getClass()));
				// titledBorder.setTitle((readonly) ? trSetCaption + " - read only " :
				// trSetCaption);
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
				this.setPreferredSize(new Dimension((int) this.getVisibleRect().getWidth(), 800));
			}
			
		@Override
		public void componentShown(ComponentEvent e)
			{
				
			}
			
		public void updateOptimalSize()
			{
				Insets insets = getBorder().getBorderInsets(this);
				optimalSize.width = getWidth() + insets.left + insets.right;
				optimalSize.height = trmhuiHeader.getPreferredSize().height + ruiReferences.getPreferredSize().height + duiDescription.getPreferredSize().height;
				optimalSize.height += tfluiTransformationFunctions.getPreferredSize().height;
				optimalSize.height += insets.top + insets.bottom;
				this.setPreferredSize(optimalSize);
				Container parent = getParent();
				if ((parent != null) && (parent instanceof SizeOptimizableUI))
					((SizeOptimizableUI) parent).updateOptimalSize();
				else
					invalidate();
			}
			
		public void initializeUI()
			{
				duiDescription.initializeUI();
				tfluiTransformationFunctions.initializeUI();
				ruiReferences.initializeUI();
			}
			
		@Override
		public int listEditorActionPerformed(int actionCode)
			{
				if ((actionCode == ListEditorToolbarUI.ADD) && (transformationSet.getTransformationFunctions() == null))
					{
						transformationSet.setTransformationFunctions(new FunctionalRelationships(transformationSet));
						tfluiTransformationFunctions.load(transformationSet.getTransformationFunctions(), readonly);
					}
				return actionCode;
			}
			
		/**
		* 
		*/
		private static final long			serialVersionUID	= 1L;
		protected Dimension									optimalSize						= new Dimension(400, 1000);
		protected boolean											readonly									= false;
		protected TransformationSet	transformationSet;
		
	}
