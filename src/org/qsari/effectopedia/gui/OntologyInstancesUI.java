package org.qsari.effectopedia.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;

import org.qsari.effectopedia.gui.comp.autocomplete.AutoCompletion;
import org.qsari.effectopedia.gui.core.LoadableEditorUI;
import org.qsari.effectopedia.gui.help.ContextSensitivePanel;
import org.qsari.effectopedia.gui.help.RootHelpContext;
import org.qsari.effectopedia.gui.ref_ids_table.OntologyInstancesComboBoxModel;
import org.qsari.effectopedia.gui.ref_ids_table.OntologyInstancesTableUI;
import org.qsari.effectopedia.gui.toolbars.ListEditorToolbarUI;
import org.qsari.effectopedia.ontologies.OntologyInstances;

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
public class OntologyInstancesUI extends ContextSensitivePanel implements AdjustableUI, LoadableEditorUI, InitializableUI, ActionListener
	{
		/**
	 * 
	 */
		private static final long								serialVersionUID	= 1L;
		private ListEditorToolbarUI						letuiReferences;
		private OntologyInstancesTableUI	oituiOntologyInstances;
		
		/**
		 * Auto-generated main method to display this JPanel inside a new JFrame.
		 */
		public static void main(String[] args)
			{
				JFrame frame = new JFrame();
				frame.getContentPane().add(new OntologyInstancesUI(null));
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				frame.pack();
				frame.setVisible(true);
			}
		
		public OntologyInstancesUI(RootHelpContext rootHelpContext)
			{
				super(rootHelpContext);
				setName("ontology_instances");
				initGUI("Ontology Instances");
			}
		
		public OntologyInstancesUI(String title,RootHelpContext rootHelpContext)
			{
				super(rootHelpContext);
				initGUI(title);
			}
		
		private void initGUI(String title)
			{
				try
					{
						setPreferredSize(optimalSize);
						BorderLayout thisLayout = new BorderLayout();
						this.setLayout(thisLayout);
						this.setBorder(BorderFactory.createTitledBorder(null, title, TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 2, 12)));
						this.setBackground(Color.WHITE);
							{
								oituiOntologyInstances = new OntologyInstancesTableUI();
								this.add(oituiOntologyInstances, BorderLayout.CENTER);
							}
							{
								letuiReferences = new ListEditorToolbarUI(oituiOntologyInstances, "referece", ListEditorToolbarUI.DEFAULT, FlowLayout.RIGHT);
								this.add(letuiReferences, BorderLayout.SOUTH);
									{
										jpEnzymeSystem = new JPanel();
										BorderLayout jpEnzymeSystemLayout = new BorderLayout();
										this.add(jpEnzymeSystem, BorderLayout.NORTH);
										jpEnzymeSystem.setLayout(jpEnzymeSystemLayout);
										jpEnzymeSystem.setPreferredSize(new java.awt.Dimension(390, 20));
										jpEnzymeSystem.setBackground(Color.WHITE);
											{
												jlEnzymeSystem = new JLabel();
												jpEnzymeSystem.add(jlEnzymeSystem, BorderLayout.WEST);
												jlEnzymeSystem.setText("Enzyme System: ");
											}
											{
												comboBoxModel = new OntologyInstancesComboBoxModel(null);
												jcbEnzymeSystem = new JComboBox<OntologyInstances>();
												jcbEnzymeSystem.setEditable(true);
												autoCompletion = new AutoCompletion(jcbEnzymeSystem, true);
												jpEnzymeSystem.add(jcbEnzymeSystem, BorderLayout.CENTER);
												jcbEnzymeSystem.setModel(comboBoxModel);
												autoCompletion.setModel(comboBoxModel);
												jcbEnzymeSystem.setPreferredSize(new java.awt.Dimension(215, 15));
												jcbEnzymeSystem.addActionListener(this);
											}
									}
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
				this.setVisible((visualOptions & REFERENCES) != 0);
				letuiReferences.adjustUI(visualOptions);
			}
		
		public void load(Object o, boolean readonly)
			{
				if (!(o instanceof OntologyInstances))
					return;
				this.readonly = readonly;
				ontologyInstances = (OntologyInstances) o;
				oituiOntologyInstances.setOntologyInstances(ontologyInstances, readonly);
				comboBoxModel.setOntologyClass(ontologyInstances.getType());
				comboBoxModel.select(ontologyInstances);
				letuiReferences.updateEditButtons(readonly);
				oituiOntologyInstances.updateOptimalSize();
			}
		
		public void actionPerformed(ActionEvent arg0)
			{
				if (ontologyInstances != null)
					oituiOntologyInstances.setOntologyInstances((OntologyInstances) comboBoxModel.getSelectedItem(), readonly);
			}
		
		public void updateOptimalSize()
			{
				Insets insets = this.getBorder().getBorderInsets(this);
				optimalSize.width = oituiOntologyInstances.getWidth() + insets.left + insets.right;
				optimalSize.height = letuiReferences.getPreferredSize().height + oituiOntologyInstances.getPreferredSize().height + insets.top + insets.bottom;
				setSize(optimalSize);
				setPreferredSize(optimalSize);
				Container parent = getParent();
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
		
		private Dimension																				optimalSize	= new Dimension(400, 100);
		private JComboBox<OntologyInstances>	jcbEnzymeSystem;
		private JLabel																							jlEnzymeSystem;
		private JPanel																							jpEnzymeSystem;
		
		public void initializeUI()
			{
				oituiOntologyInstances.initializeUI();
			}
		
		private OntologyInstancesComboBoxModel	comboBoxModel;
		private OntologyInstances														ontologyInstances;
		private AutoCompletion																	autoCompletion;
		private boolean																								readonly	= false;
	}
