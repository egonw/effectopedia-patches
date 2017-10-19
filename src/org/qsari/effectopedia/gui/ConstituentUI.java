package org.qsari.effectopedia.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.text.Document;

import org.qsari.effectopedia.core.objects.Constituent;
import org.qsari.effectopedia.core.objects.Constituent.ConstituentType;
import org.qsari.effectopedia.core.objects.Initiator_ChemicalStructure;
import org.qsari.effectopedia.gui.comp.EventsManager;
import org.qsari.effectopedia.gui.core.LoadableEditorUI;
import org.qsari.effectopedia.gui.help.ContextSensitivePanel;
import org.qsari.effectopedia.gui.help.RootHelpContext;

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
public class ConstituentUI extends ContextSensitivePanel implements LoadableEditorUI, ActionListener
	{
		
		/** The 2D image of the structure. */
		protected StructureImageUI									siui2DImage;
		private JComboBox<ConstituentType>	jcbType;
		private JLabel																					jlTypical;
		private JLabel																					jlActual;
		private JTextField																	jtfTypical;
		private JTextField																	jtfActual;
		private JTextField																	jtfName;
		
		public ConstituentUI(boolean basicLayout,RootHelpContext rootHelpContext)
			{
				super(rootHelpContext);
				setName("constituent");
				listeners = new EventsManager();
				initGUI(basicLayout);
			}
		
		private void initGUI(boolean basicLayout)
			{
				this.basicLayout = basicLayout;
				try
					{
							{
								this.setPreferredSize(new java.awt.Dimension(200, 250));
								GridBagLayout thisLayout = new GridBagLayout();
								this.setBackground(new java.awt.Color(255, 255, 255));
								thisLayout.rowWeights = new double[]
									{ 0.0, 1.0, 0.0, 0.0, 0.0 };
								int rowHeight = basicLayout?0:24; 
								thisLayout.rowHeights = new int[]
									{ 24, 162, 24, rowHeight, rowHeight };
								thisLayout.columnWeights = new double[]
									{ 0.0, 0.1 };
								thisLayout.columnWidths = new int[]
									{ 58, 7 };
								this.setLayout(thisLayout);
									{
										siui2DImage = new StructureImageUI(rootHelpContext);
										this.add(siui2DImage, new GridBagConstraints(0, 1, 2, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
									}
									{
										jtfName = new JTextField();
										this.add(jtfName, new GridBagConstraints(0, 0, 2, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
									}
									{
										ComboBoxModel<ConstituentType> jcbTypeModel = new DefaultComboBoxModel<ConstituentType>(Constituent.ConstituentTypes);
										jcbType = new JComboBox<ConstituentType>();
										this.add(jcbType, new GridBagConstraints(0, 2, 2, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
										jcbType.setModel(jcbTypeModel);
										jcbType.setBackground(new java.awt.Color(255, 255, 255));
										jcbType.addActionListener(this);
									}
									{
										jlTypical = new JLabel();
										this.add(jlTypical, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
										jlTypical.setText("Typical:");
										jlTypical.setVisible(!basicLayout);
									}
									{
										jlActual = new JLabel();
										this.add(jlActual, new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
										jlActual.setText("Actual:");
										jlActual.setVisible(!basicLayout);
									}
									{
										jtfTypical = new JTextField();
										this.add(jtfTypical, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
										jtfTypical.setText("100%");
										jtfTypical.setVisible(!basicLayout);
									}
									{
										jtfActual = new JTextField();
										this.add(jtfActual, new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
										jtfActual.setText("[100%, 100%]");
										jtfActual.setVisible(!basicLayout);
									}
							}
					}
				catch (Exception e)
					{
						e.printStackTrace();
					}
			}
		
		@Override
		public void load(Object o, boolean readonly)
			{
				if (!(o instanceof Constituent))
					return;
				Document docTitle = jtfName.getDocument();
				Document docTypical = jtfTypical.getDocument();
				Document docActual = jtfActual.getDocument();
				listeners.unbondDocumntListener(docTitle, "Title");
				listeners.unbondDocumntListener(docTypical, "Typical");
				listeners.unbondDocumntListener(docActual, "ActualRange");
				
				constituent = (Constituent) o;
				readonly = readonly || constituent.isReadonly();
				Initiator_ChemicalStructure structure = constituent.getStructure();
				jtfName.setText(structure.getTitle());
				jtfName.setEditable(!readonly);
				jtfTypical.setText(constituent.getTypical());
				jtfActual.setText(constituent.getActualRange());
				jcbType.setSelectedItem(constituent.getConstituentType());
				listeners.bondDocumntListener(docTitle, structure, "Title");
				listeners.bondDocumntListener(docTypical, constituent, "Typical");
				listeners.bondDocumntListener(docActual, constituent, "ActualRange");
				siui2DImage.load(structure.getStructure2DImage(), readonly);
				// titledBorder.setTitle((readonly) ? "Chemical Structure - read only " :
				// "Chemical Structure");
			}
		
		@Override
		public void actionPerformed(ActionEvent e)
			{
				if (constituent != null)
					constituent.setConstituentType((ConstituentType) jcbType.getSelectedItem());
			}
		
		private boolean											basicLayout;
		private Constituent							constituent;
		private EventsManager					listeners;
		
		/**
	 * 
	 */
		private static final long	serialVersionUID	= 1L;
		
	}
