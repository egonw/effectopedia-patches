package org.qsari.effectopedia.gui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.ListModel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.qsari.effectopedia.core.Effectopedia;
import org.qsari.effectopedia.core.objects.Effect;
import org.qsari.effectopedia.core.ui.UserInterface;
import org.qsari.effectopedia.core.ui.nav.UILocations;
import org.qsari.effectopedia.data.DataSource;
import org.qsari.effectopedia.data.filter.ContextDimensionFilter.Criterion;
import org.qsari.effectopedia.data.filter.FilteredIndex;
import org.qsari.effectopedia.gui.core.GUIFactory;
import org.qsari.effectopedia.gui.core.LoadableEditorUI;

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
public class ExistingEffectDialog extends javax.swing.JDialog implements LoadableEditorUI, ActionListener
	{
		/**
	 * 
	 */
		private static final long																serialVersionUID	= -8069795493814727028L;
		private JTextPane																								jtpMessage;
		private JButton																										jbCancel;
		private JButton																										jbDefineNew;
		private JScrollPane																						jspExistingElements;
		private JButton																										jbUseSelected;
		private JLabel																											jlQuestionIcon;
		private JList<String>																				jlExistingElements;
		private EffectUI																									euiSelectedEffect;
		
		public static final ExistingEffectDialog	DIALOG											= new ExistingEffectDialog(GUIFactory.GUI.getFrame());
		
		/**
		 * Auto-generated main method to display this JDialog
		 */
		public static void main(String[] args)
			{
				SwingUtilities.invokeLater(new Runnable()
					{
						public void run()
							{
								DIALOG.setVisible(true);
							}
					});
			}
		
		private ExistingEffectDialog(JFrame frame)
			{
				super(frame);
				DataSource data = Effectopedia.EFFECTOPEDIA.getData();
				suggestedEffects = new FilteredIndex(data == null ? null : data.getLiveIndices().getEffects());
				initGUI();
			}
		
		private void initGUI()
			{
				try
					{
							{
								GridBagLayout thisLayout = new GridBagLayout();
								thisLayout.rowWeights = new double[]
									{ 0.0, 0.5, 1, 0.1 };
								thisLayout.rowHeights = new int[]
									{ 108, 100, 200, 100 };
								thisLayout.columnWeights = new double[]
									{ 0.1, 0.1, 0.1, 0.1 };
								getContentPane().setLayout(thisLayout);
								this.setTitle("Select existing effect or define new ");
									{
										jtpMessage = new JTextPane();
										getContentPane().add(jtpMessage, new GridBagConstraints(1, 0, 3, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 10, 0, 10), 0, 0));
										jtpMessage.setText("Please take a moment to verify that the effect you are trying to define is not already present in Effectopedia.");
										jtpMessage.setEditable(false);
										jtpMessage.setOpaque(false);
										jtpMessage.setFont(new java.awt.Font("Segoe UI", 0, 18));
									}
									{
										jspExistingElements = new JScrollPane();
										getContentPane().add(jspExistingElements, new GridBagConstraints(0, 1, 4, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 16, 4, 16), 0, 0));
											{
												ListModel<String> jlExistingElementsModel = suggestedEffects.getListModel();
												jlExistingElements = new JList<String>();
												jspExistingElements.setViewportView(jlExistingElements);
												jlExistingElements.setModel(jlExistingElementsModel);
												jlExistingElements.addMouseListener(listSelector);
												jlExistingElements.addListSelectionListener(listSelector);
											}
									}
									{
										jlQuestionIcon = new JLabel();
										getContentPane().add(jlQuestionIcon, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
										jlQuestionIcon.setIcon(new ImageIcon(getClass().getClassLoader().getResource("org/qsari/effectopedia/gui/res/dialog_question.png")));
										jlQuestionIcon.setHorizontalTextPosition(SwingConstants.RIGHT);
									}
									{
										jbCancel = new JButton();
										getContentPane().add(jbCancel, new GridBagConstraints(3, 3, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
										jbCancel.setText("Cancel");
										jbCancel.setIcon(new ImageIcon(getClass().getClassLoader().getResource("org/qsari/effectopedia/gui/res/button_cancel.png")));
										jbCancel.addActionListener(this);
									}
									{
										jbDefineNew = new JButton();
										getContentPane().add(jbDefineNew, new GridBagConstraints(2, 3, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
										jbDefineNew.setText("Define New");
										jbDefineNew.setIcon(new ImageIcon(getClass().getClassLoader().getResource("org/qsari/effectopedia/gui/res/button_add.png")));
										jbDefineNew.setIconTextGap(8);
										jbDefineNew.addActionListener(this);
									}
									{
										jbUseSelected = new JButton();
										getContentPane().add(jbUseSelected, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
										jbUseSelected.setText("Use selected");
										jbUseSelected.setIcon(new ImageIcon(getClass().getClassLoader().getResource("org/qsari/effectopedia/gui/res/button_ok.png")));
										jbUseSelected.addActionListener(this);
									}
									{
										euiSelectedEffect = new EffectUI("Selected Effect");
										getContentPane().add(euiSelectedEffect, new GridBagConstraints(0, 2, 4, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 16, 0, 16), 0, 0));
										// euiSelectedEffect.setVisible(false);
									}
							}
						this.setSize(900, 600);
						setCentredLocation();
						setModal(true);
						this.setLocationByPlatform(true);
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
								euiSelectedEffect.setVisible(true);
								int index = jlExistingElements.locationToIndex(e.getPoint());
								euiSelectedEffect.load((Effect) suggestedEffects.getElement(index), true);
							}
						if (e.getClickCount() == 2)
							{
								int index = jlExistingElements.locationToIndex(e.getPoint());
								selectedEffect = (Effect) suggestedEffects.getElement(index);
								setVisible(false);
							}
					}
				
				@Override
				public void valueChanged(ListSelectionEvent e)
					{
						euiSelectedEffect.setVisible(true);
						int index = e.getFirstIndex();
						euiSelectedEffect.load((Effect) suggestedEffects.getElement(index), true);
					}
				
			}
		
		public void setCentredLocation()
			{
				Container parent = getParent();
				int x = parent.getLocationOnScreen().x;
				int y = parent.getLocationOnScreen().y;
				Dimension parentSize = parent.getSize();
				Dimension dialogSize = getSize();
				
				if (parentSize.width > dialogSize.width)
					x += ((parentSize.width - dialogSize.width) >> 1);
				
				if (parentSize.height > dialogSize.height)
					y += ((parentSize.height - dialogSize.height) >> 1);
				
				setLocation(x, y);
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
						setCentredLocation();
						jlExistingElements.setModel(suggestedEffects.getListModel());
						DIALOG.setVisible(true);
					}
				else
					{
						DIALOG.setVisible(false);
						UserInterface.getDefaultNavigator().navigate(UILocations.getProperEditor(o), o);
					}
			}
		
		public void actionPerformed(ActionEvent e)
			{
				if (e.getSource() == jbUseSelected)
					selectedEffect = (Effect) suggestedEffects.getElement(jlExistingElements.getSelectedIndex());
				else if (e.getSource() == jbDefineNew)
					UserInterface.getDefaultNavigator().navigate(UILocations.getProperEditor(effect), effect);
				DIALOG.setVisible(false);
			}
		
		public Effect getSelectedEffect()
			{
				return selectedEffect;
			}
		
		private ListSelector		listSelector	= new ListSelector();
		private Effect								effect;
		protected Effect						selectedEffect;
		private FilteredIndex	suggestedEffects;
		
	}
