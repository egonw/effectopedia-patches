package org.qsari.effectopedia.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.ListModel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.qsari.effectopedia.core.Effectopedia;
import org.qsari.effectopedia.core.objects.Effect;
import org.qsari.effectopedia.data.DataSource;
import org.qsari.effectopedia.data.filter.ContextDimensionFilter.Criterion;
import org.qsari.effectopedia.data.filter.FilteredIndex;
import org.qsari.effectopedia.go.GraphicObject;
import org.qsari.effectopedia.go.Layout.LayoutObjectsContainer;
import org.qsari.effectopedia.gui.comp.CollapsableTitledPanel;
import org.qsari.effectopedia.gui.core.LoadableEditorUI;
import org.qsari.effectopedia.gui.help.ContextSensitivePanel;
import org.qsari.effectopedia.gui.help.RootHelpContext;
import org.qsari.effectopedia.gui.im.InterfaceMode;

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
public class ExistingEffectPanel extends ContextSensitivePanel implements LoadableEditorUI, SizeOptimizableUI, ActionListener, RootHelpContext
	{
		/**
		* 
		*/
		private static final long															serialVersionUID	= -8069795493814727028L;
		private JTextPane																							jtpMessage;
		private JButton																									jbCancel;
		private JButton																									jbDefineNew;
		private JScrollPane																					jspExistingElements;
		private JButton																									jbUseSelected;
		private JLabel																										jlQuestionIcon;
		private JList<String>																			jlExistingElements;
		private EffectUI																								euiSelectedEffect;
		private CollapsableTitledPanel										ctpPreviewSelected;
		private JPanel																										jpMessage;
		private JPanel																										jpButtons;
		
		public static final ExistingEffectPanel	PANEL												= new ExistingEffectPanel(null);
		
		/**
		 * Auto-generated main method to display this JDialog
		 */
		public static void main(String[] args)
			{
				SwingUtilities.invokeLater(new Runnable()
					{
						public void run()
							{
								PANEL.setVisible(true);
							}
					});
			}
			
		private ExistingEffectPanel(RootHelpContext rootHelpContext)
			{
				super(rootHelpContext);
				DataSource data = Effectopedia.EFFECTOPEDIA.getData();
				suggestedEffects = new FilteredIndex(data == null ? null : data.getLiveIndices().getEffects());
				initGUI();
			}
			
		private void initGUI()
			{
				try
					{
						setName("existing_effect");
						setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
						setPreferredSize(optimalSize);
							{
								jpMessage = new JPanel();
								jpMessage.setLayout(new BorderLayout(0, 0));
									{
										jtpMessage = new JTextPane();
										jtpMessage.setText("Please take a moment to verify that the effect you are trying to define is not already present in Effectopedia.");
										jtpMessage.setEditable(false);
										jtpMessage.setOpaque(false);
										jtpMessage.setFont(new java.awt.Font("Segoe UI", 0, 18));
										jpMessage.add(jtpMessage, BorderLayout.CENTER);
									}
									{
										jlQuestionIcon = new JLabel();
										jlQuestionIcon.setIcon(new ImageIcon(getClass().getClassLoader().getResource("org/qsari/effectopedia/gui/res/dialog_question.png")));
										jlQuestionIcon.setHorizontalTextPosition(SwingConstants.RIGHT);
										jpMessage.add(jlQuestionIcon, BorderLayout.WEST);
									}
								jpMessage.setPreferredSize(new Dimension(400, 100));
								jpMessage.setMaximumSize(new Dimension(1400, 100));
								add(jpMessage);
							}
							
							{
								jspExistingElements = new JScrollPane();
								jspExistingElements.setBorder(new EmptyBorder(0, 8, 8, 16));
								jspExistingElements.setPreferredSize(new Dimension(400, 300));
									{
										ListModel<String> jlExistingElementsModel = suggestedEffects.getListModel();
										jlExistingElements = new JList<String>();
										jspExistingElements.setViewportView(jlExistingElements);
										jlExistingElements.setModel(jlExistingElementsModel);
										jlExistingElements.addMouseListener(listSelector);
										jlExistingElements.addListSelectionListener(listSelector);
									}
								add(jspExistingElements);
							}
							
							{
								euiSelectedEffect = new EffectUI("Selected Effect");
								ctpPreviewSelected = new CollapsableTitledPanel(euiSelectedEffect, new JLabel("Preview selected:"), false, rootHelpContext);
								ctpPreviewSelected.setPreferredSize(new Dimension(400, 32));
								ctpPreviewSelected.setBorder(new EmptyBorder(0, 8, 0, 16));
								ctpPreviewSelected.setBackground(this.getBackground());
								this.add(ctpPreviewSelected);
							}
							{
								jpButtons = new JPanel();
								jpButtons.setPreferredSize(new Dimension(400, 32));
								jpButtons.setLayout(new BoxLayout(jpButtons, BoxLayout.X_AXIS));
									{
										jbCancel = new JButton();
										jpButtons.add(jbCancel);
										jbCancel.setText("Cancel");
										jbCancel.setIcon(new ImageIcon(getClass().getClassLoader().getResource("org/qsari/effectopedia/gui/res/button_cancel.png")));
										jbCancel.addActionListener(this);
										jbCancel.setVisible(showCancelButton);
									}
									{
										jbDefineNew = new JButton();
										jpButtons.add(jbDefineNew);
										jbDefineNew.setText("Define New");
										jbDefineNew.setIcon(new ImageIcon(getClass().getClassLoader().getResource("org/qsari/effectopedia/gui/res/button_add.png")));
										jbDefineNew.setIconTextGap(8);
										jbDefineNew.addActionListener(this);
									}
									{
										jbUseSelected = new JButton();
										jpButtons.add(jbUseSelected);
										jbUseSelected.setText("Use selected");
										jbUseSelected.setIcon(new ImageIcon(getClass().getClassLoader().getResource("org/qsari/effectopedia/gui/res/button_ok.png")));
										jbUseSelected.addActionListener(this);
									}
								add(jpButtons);
							}
							
					}
				catch (Exception e)
					{
						e.printStackTrace();
					}
			}
			
		public class ListSelector extends MouseAdapter implements ListSelectionListener
			{
				public void mouseClicked(MouseEvent e)
					{
						if (e.getClickCount() == 1)
							{
								int index = jlExistingElements.locationToIndex(e.getPoint());
								ctpPreviewSelected.load((Effect) suggestedEffects.getElement(index), true);
							}
						if (e.getClickCount() == 2)
							{
								int index = jlExistingElements.locationToIndex(e.getPoint());
								selectedEffect = (Effect) suggestedEffects.getElement(index);
								actionPerformed(new ActionEvent(jbUseSelected, 0, ""));
							}
					}
					
				@Override
				public void valueChanged(ListSelectionEvent e)
					{
						int index = e.getFirstIndex();
						ctpPreviewSelected.load((Effect) suggestedEffects.getElement(index), true);
					}
					
			}
			
		public boolean hasSuggestions(Object o)
			{
				if (!(o instanceof Effect) || elementEditor == null)
					return false;
				effect = (Effect) o;
				selectedEffect = null;
				suggestedEffects.clearFilters();
				suggestedEffects.addGenericFilter();
				suggestedEffects.buidContextFilters(effect, Criterion.EQUAL);
				suggestedEffects.addClassFilter(effect.getClass());
				suggestedEffects.sort();
				return suggestedEffects.count() > 0;
			}
			
		public void load(Object o, boolean readonly)
			{
				if (!(o instanceof Effect))
					return;
				effect = (Effect) o;
				selectedEffect = null;
				suggestedEffects.clearFilters();
				suggestedEffects.addGenericFilter();
				suggestedEffects.buidContextFilters(effect, Criterion.EQUAL);
				suggestedEffects.addClassFilter(effect.getClass());
				suggestedEffects.sort();
				boolean hasSuggestions = suggestedEffects.count() > 0;
				if (suggestedEffects.count() > 0)
					jlExistingElements.setSelectedIndex(0);
				if ((hasSuggestions) && (!readonly))
					{
						jlExistingElements.setModel(suggestedEffects.getListModel());
						PANEL.setVisible(true);
					}
			}
			
		public void actionPerformed(ActionEvent e)
			{
				if (e.getSource() == jbUseSelected)
					{
						selectedEffect = (Effect) suggestedEffects.getElement(jlExistingElements.getSelectedIndex());
						interfaceMode.replaceCurrentPathwayElement(currentGO, currentContainer, selectedEffect);
						elementEditor.load(selectedEffect, selectedEffect.isReadonly());
					}
				else
					elementEditor.defineNew(effect, effect.isReadonly());
			}
			
		public Effect getSelectedEffect()
			{
				return selectedEffect;
			}
			
		public boolean isShowCancelButton()
			{
				return showCancelButton;
			}
			
		public void setShowCancelButton(boolean showCancelButton)
			{
				this.showCancelButton = showCancelButton;
			}
			
		public ElementEditorUI getElementEditor()
			{
				return elementEditor;
			}
			
		public void setElementEditor(ElementEditorUI elementEditor)
			{
				this.elementEditor = elementEditor;
			}
			
		public void setInterfaceMode(InterfaceMode interfaceMode)
			{
				this.interfaceMode = interfaceMode;
				this.currentGO = ((interfaceMode.getCurrentLO() != null)) ? interfaceMode.getCurrentLO().getGo() : null;
				this.currentContainer = interfaceMode.getCurrentContainer();
			}
			
		public void updateOptimalSize()
			{
				optimalSize.width = getWidth();
				optimalSize.height = jpMessage.getPreferredSize().height + jspExistingElements.getPreferredSize().height + ctpPreviewSelected.getPreferredSize().height + jpButtons.getPreferredSize().height;
				setPreferredSize(optimalSize);
				Container parent = getParent();
				if ((parent != null) && (parent instanceof SizeOptimizableUI))
					((SizeOptimizableUI) parent).updateOptimalSize();
				else
					invalidate();
			}
			
		private Dimension														optimalSize						= new Dimension(400, 600);
		private InterfaceMode										interfaceMode				= null;
		private GraphicObject										currentGO								= null;
		private LayoutObjectsContainer	currentContainer	= null;
		private boolean																showCancelButton	= false;
		private ElementEditorUI								elementEditor				= null;
		private ListSelector											listSelector					= new ListSelector();
		private Effect																	effect;
		protected Effect															selectedEffect;
		private FilteredIndex										suggestedEffects;
	}
