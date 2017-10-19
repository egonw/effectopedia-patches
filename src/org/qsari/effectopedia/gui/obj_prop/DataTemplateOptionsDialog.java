package org.qsari.effectopedia.gui.obj_prop;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.qsari.effectopedia.data.objects.ObjectPropertyTypesContainer;
import org.qsari.effectopedia.data.quantification.DataTemplate;
import org.qsari.effectopedia.data.quantification.DataTemplateType;
import org.qsari.effectopedia.data.quantification.DataTemplates;
import org.qsari.effectopedia.defaults.DefaultEffectopediaObjects;
import org.qsari.effectopedia.gui.core.GUIFactory;
import org.qsari.effectopedia.gui.core.LoadableEditorUI;

public class DataTemplateOptionsDialog extends javax.swing.JDialog implements LoadableEditorUI, ActionListener
	{
		/**
	 * 
	 */
		private static final long																					serialVersionUID	= -8069795493814727028L;
		private JButton																															jbCancel;
		private JButton																															jbOK;
		private JScrollPane																											jspExistingDataTemplates;
		private JList<DataTemplateType>															jlDataTemplateType;
		
		public static final DataTemplateOptionsDialog	DIALOG											= new DataTemplateOptionsDialog(GUIFactory.GUI == null ? null : GUIFactory.GUI.getFrame());
		
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
		
		private DataTemplateOptionsDialog(JFrame frame)
			{
				super(frame);
				initGUI();
			}
		
		private void initGUI()
			{
				try
					{
							{
								GridBagLayout thisLayout = new GridBagLayout();
								thisLayout.rowWeights = new double[]
									{ 1, 1, 1, 1 };
								thisLayout.rowHeights = new int[]
									{ 20, 180, 80, 20 };
								thisLayout.columnWeights = new double[]
									{ 0.1, 0.1, 0.1, 0.1 };
								this.setLayout(thisLayout);
								jspExistingDataTemplates = new JScrollPane();
								this.add(jspExistingDataTemplates, new GridBagConstraints(0, 1, 4, 2, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 16, 4, 16), 0, 0));
									{
										jlDataTemplateType = new JList<DataTemplateType>();
										ComboBoxModel<DataTemplateType> jlDataTemplateTypeModel = new DefaultComboBoxModel<DataTemplateType>(DefaultEffectopediaObjects.DEFAULT_D_RESP_DTT);
										jlDataTemplateType.setModel(jlDataTemplateTypeModel);
										jlDataTemplateType.addMouseListener(listSelector);
										jlDataTemplateType.addListSelectionListener(listSelector);
										jspExistingDataTemplates.setViewportView(jlDataTemplateType);
									}
									
									{
										jbCancel = new JButton();
										this.add(jbCancel, new GridBagConstraints(2, 3, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
										jbCancel.setText("Cancel");
										jbCancel.setIcon(new ImageIcon(getClass().getClassLoader().getResource("org/qsari/Effectopedia/gui/res/button_cancel.png")));
										jbCancel.addActionListener(this);
									}
									{
										jbOK = new JButton();
										this.add(jbOK, new GridBagConstraints(3, 3, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
										jbOK.setText("OK");
										jbOK.setIcon(new ImageIcon(getClass().getClassLoader().getResource("org/qsari/Effectopedia/gui/res/button_add.png")));
										jbOK.setIconTextGap(8);
										jbOK.addActionListener(this);
									}
							}
						this.setSize(640, 300);
						setCentredLocation();
						setModal(true);
						this.setLocationByPlatform(true);
					}
				catch (Exception e)
					{
						e.printStackTrace();
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
				if (!(o instanceof DataTemplates))
					return;
				selected = false;
				setCentredLocation();
				dataTemplates = (DataTemplates) o;
				if (dataTemplates != null)
					{
						DataTemplate primary = dataTemplates.get(0);
						if (primary != null)
							{
							jlDataTemplateType.setSelectedValue(primary.getType(), true);
							loadSuitableOptions();
							}
					}
				DIALOG.setVisible(true);
			}
		
		public void loadSuitableOptions()
			{
				DataTemplateType[] options;
				ObjectPropertyTypesContainer type = dataTemplates.getTypes();
				ComboBoxModel<DataTemplateType> jlDataTemplateTypeModel = new DefaultComboBoxModel<DataTemplateType>(DefaultEffectopediaObjects.getCompatibleTemplateTypes(type));
				jlDataTemplateType.setModel(jlDataTemplateTypeModel);
			}
		
		public void actionPerformed(ActionEvent e)
			{
				selected = (e.getSource() == jbOK);
				DIALOG.setVisible(false);
			}
		
		public class ListSelector extends MouseAdapter implements ListSelectionListener
			{
				public void mouseClicked(MouseEvent e)
					{
						if (e.getClickCount() == 1)
							{
								selectedType = jlDataTemplateType.getSelectedValue();
							}
						if (e.getClickCount() == 2)
							{
								selectedType = jlDataTemplateType.getSelectedValue();
								selected = true;
								setVisible(false);
							}
					}
				
				@Override
				public void valueChanged(ListSelectionEvent e)
					{
						selectedType = jlDataTemplateType.getSelectedValue();
					}
			}
		
		protected DataTemplates getDataTemplates()
			{
				return dataTemplates;
			}
		
		protected void setDataTemplates(DataTemplates dataTemplates)
			{
				this.dataTemplates = dataTemplates;
			}
		
		protected DataTemplateType getSelectedType()
			{
				return selectedType;
			}
		
		protected boolean isSelected()
			{
				return selected;
			}
		
		private ListSelector					listSelector	= new ListSelector();
		private DataTemplates				dataTemplates;
		private DataTemplateType	selectedType;
		private boolean										selected;
	}
