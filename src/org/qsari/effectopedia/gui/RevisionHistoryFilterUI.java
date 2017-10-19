package org.qsari.effectopedia.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.WindowConstants;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import org.qsari.effectopedia.core.objects.Effect_AdverseOutcome;
import org.qsari.effectopedia.core.objects.Effect_DownstreamEffect;
import org.qsari.effectopedia.core.objects.Effect_Endpoint;
import org.qsari.effectopedia.core.objects.Effect_MolecularInitiatingEvent;
import org.qsari.effectopedia.core.objects.Initiator_BiologcalPerturbation;
import org.qsari.effectopedia.core.objects.Initiator_ChemicalStructure;
import org.qsari.effectopedia.core.objects.Initiator_StructuralAlerts;
import org.qsari.effectopedia.core.objects.Link_ChemStructToChemStruct;
import org.qsari.effectopedia.core.objects.Link_ChemStructToMIE;
import org.qsari.effectopedia.core.objects.Link_EffectToEffect;
import org.qsari.effectopedia.core.objects.Pathway;
import org.qsari.effectopedia.core.objects.Test;
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
public class RevisionHistoryFilterUI extends ContextSensitivePanel implements ActionListener
	{
		/**
	 * 
	 */
		private static final long	serialVersionUID	= 2986301087860032504L;
		private JLabel												jlShow;
		private JComboBox<String>	jcbCondition;
		private JTextField								jtfCondition;
		private JCheckBox									jcbIncludeDefault;
		private JComboBox<String>	jcbFilterBy;
		private JLabel												jlFilter;
		private JCheckBox									jcbIncludeGenerics;
		private JComboBox<String>	jcbShow;
		
		/**
		 * Auto-generated main method to display this JPanel inside a new JFrame.
		 */
		public static void main(String[] args)
			{
				JFrame frame = new JFrame();
				frame.getContentPane().add(new RevisionHistoryFilterUI(null));
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				frame.pack();
				frame.setVisible(true);
			}
		
		public RevisionHistoryFilterUI(RootHelpContext rootHelpContext)
			{
				super(rootHelpContext);
				setName("filter");
				initGUI();
			}
		
		private void initGUI()
			{
				try
					{
						GridBagLayout thisLayout = new GridBagLayout();
						this.setPreferredSize(new java.awt.Dimension(782, 65));
						thisLayout.rowWeights = new double[]
							{ 0.1, 0.1 };
						thisLayout.rowHeights = new int[]
							{ 7, 7 };
						thisLayout.columnWeights = new double[]
							{ 0.0, 0.1, 0.1, 0.0, 0.1 };
						thisLayout.columnWidths = new int[]
							{ 60, 7, 7, 186, 7 };
						this.setLayout(thisLayout);
						this.setBackground(new java.awt.Color(200, 221, 242));
							{
								jlShow = new JLabel();
								this.add(jlShow, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 0, 0, 4), 0, 0));
								jlShow.setText("Show: ");
							}
							{
								ComboBoxModel<String> jcbShowModel = new DefaultComboBoxModel<String>(new String[]
									{ "Effectopedia Revisions", "Pathway Element Revisions", "Pathway Revisions", "Effect Revisions", "Substance Revisions" });
								jcbShow = new JComboBox<String>();
								this.add(jcbShow, new GridBagConstraints(1, 0, 2, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
								jcbShow.setModel(jcbShowModel);
								jcbShow.setMinimumSize(new java.awt.Dimension(24, 24));
								jcbShow.addActionListener(this);
							}
							{
								jcbIncludeGenerics = new JCheckBox();
								this.add(jcbIncludeGenerics, new GridBagConstraints(3, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 4, 0, 4), 0, 0));
								jcbIncludeGenerics.setText("Include generics");
								jcbIncludeGenerics.setOpaque(false);
							}
							{
								jlFilter = new JLabel();
								this.add(jlFilter, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
								jlFilter.setText("Filter by:");
							}
							{
								ComboBoxModel<String> jcbFilterByModel = new DefaultComboBoxModel<String>(new String[]
									{ "Username", "Date" });
								jcbFilterBy = new JComboBox<String>();
								this.add(jcbFilterBy, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 2), 0, 0));
								jcbFilterBy.setModel(jcbFilterByModel);
								jcbFilterBy.setMinimumSize(new java.awt.Dimension(24, 24));
							}
							{
								ComboBoxModel<String> jcbConditionModel = new DefaultComboBoxModel<String>(new String[]
									{ "Equal", "Not Equal" });
								jcbCondition = new JComboBox<String>();
								this.add(jcbCondition, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 2, 0, 0), 0, 0));
								jcbCondition.setModel(jcbConditionModel);
								jcbCondition.setMinimumSize(new java.awt.Dimension(24, 24));
							}
							{
								jtfCondition = new JTextField();
								this.add(jtfCondition, new GridBagConstraints(3, 1, 2, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 4, 0, 4), 0, 0));
								jtfCondition.setMinimumSize(new java.awt.Dimension(24, 24));
								jtfCondition.setPreferredSize(new java.awt.Dimension(6, 24));
							}
							{
								jcbIncludeDefault = new JCheckBox();
								this.add(jcbIncludeDefault, new GridBagConstraints(4, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
								jcbIncludeDefault.setText("Include default");
								jcbIncludeDefault.setOpaque(false);
							}
					}
				catch (Exception e)
					{
						e.printStackTrace();
					}
			}
		
		public TableRowSorter<TableModel> getSorter()
			{
				return sorter;
			}
		
		public void setSorter(TableRowSorter<TableModel> sorter)
			{
				this.sorter = sorter;
			}
		
		protected TableRowSorter<TableModel>	sorter;
		
		@Override
		public void actionPerformed(ActionEvent arg0)
			{
				switch (jcbShow.getSelectedIndex())
					{
						case 1:
							sorter.setRowFilter(RowFilter.regexFilter(PATHWAY_ELEMENTS, 8));
							break;
						case 2:
							sorter.setRowFilter(RowFilter.regexFilter(PATHWAY, 8));
							break;
						case 3:
							sorter.setRowFilter(RowFilter.regexFilter(EFFECTS, 8));
							break;
						case 4:
							sorter.setRowFilter(RowFilter.regexFilter(SUBSTANCES, 8));
							break;
						default:
							sorter.setRowFilter(null);
					}
				
			}
		
		public static String	PATHWAY										= Pathway.class.getSimpleName();
		public static String	SUBSTANCES							= Initiator_ChemicalStructure.class.getSimpleName() + "|" + Initiator_StructuralAlerts.class.getSimpleName()
																																										+ "|" + Initiator_BiologcalPerturbation.class.getSimpleName();
		public static String	EFFECTS										= Effect_MolecularInitiatingEvent.class.getSimpleName() + "|" + Effect_DownstreamEffect.class.getSimpleName() + "|" + Effect_Endpoint.class.getSimpleName()
																																										+ "|" + Effect_AdverseOutcome.class.getSimpleName();
		public static String	LINKS												= Link_EffectToEffect.class.getSimpleName() + "|" + Link_ChemStructToMIE.class.getSimpleName() + "|" + Link_ChemStructToChemStruct.class.getSimpleName();
		public static String	PATHWAY_ELEMENTS	= SUBSTANCES + "|" + EFFECTS + "|" + LINKS + "|" + Test.class.getSimpleName();
	}
