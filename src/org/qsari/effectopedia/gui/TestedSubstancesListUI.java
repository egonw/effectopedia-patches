package org.qsari.effectopedia.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.EventObject;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.AbstractTableModel;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.base.ids.ReferenceIDs;
import org.qsari.effectopedia.core.objects.Initiator_ChemicalStructure;
import org.qsari.effectopedia.core.objects.SubstanceData;
import org.qsari.effectopedia.core.objects.SubstanceData_InSilico;
import org.qsari.effectopedia.core.objects.Test;
import org.qsari.effectopedia.core.objects.Test_InSilico;
import org.qsari.effectopedia.defaults.DefaultEffectopediaObjects;
import org.qsari.effectopedia.gui.comp.CollapsableTitledPanel;
import org.qsari.effectopedia.gui.core.LoadableEditorUI;
import org.qsari.effectopedia.gui.default_ui.SubstanceDataTitleUI;
import org.qsari.effectopedia.gui.default_ui.SubstanceDataTitleUI.DataTemplateChangeListener;
import org.qsari.effectopedia.gui.help.ContextSensitivePanel;
import org.qsari.effectopedia.gui.help.RootHelpContext;
import org.qsari.effectopedia.gui.toolbars.ListEditorToolbarUI;

/**
 * This code was edited or generated using CloudGarden's Jigloo
 * SWT/Swing GUI Builder, which is free for non-commercial
 * use. If Jigloo is being used commercially (ie, by a corporation,
 * company or business for any purpose whatever) then you
 * should purchase a license for each developer using Jigloo.
 * Please visit www.cloudgarden.com for details.
 * Use of Jigloo implies acceptance of these licensing terms.
 * A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
 * THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
 * LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
 */
/**
 * @version 1 @(#)InvestigationListUI.java 1.0
 * @author Hristo Aladjov
 */

public class TestedSubstancesListUI extends ContextSensitivePanel implements AdjustableUI, LoadableEditorUI, InitializableUI
	{
		/**
		 * 
		 */
		private static final long			serialVersionUID	= 1L;
		
		private ListEditorToolbarUI	jletuiTestedSubstances;
		
		private TestedSubstancesUI		tsuiTestedSubstances;
		
		public static class TestedSubstanceUI extends CollapsableTitledPanel implements DataTemplateChangeListener
			{
				
				/**
			 * 
			 */
				private static final long										serialVersionUID		= 1L;
				private static final int											defaultItemHeight	= 300;
				private final SubstanceDataTitleUI	substanceDataTitleUI;
				
				public TestedSubstanceUI(RootHelpContext rootHelpContext)
					{
						super(new SubstanceDataUI(rootHelpContext), new SubstanceDataTitleUI(rootHelpContext), true,rootHelpContext);
						substanceDataTitleUI = (SubstanceDataTitleUI) getTitlePanel();
						setAllowRedirecting(true);
						setAllowHTMLContent(false);
						setPreferredHeight(defaultItemHeight);
						substanceDataTitleUI.addDataTemplateChangeListener(this);
					}
				
				public void load(Object o, boolean readonly)
					{
						if (!(o instanceof SubstanceData))
							return;
						readonly = readonly || ((EffectopediaObject) o).isReadonly();
						this.eo = (EffectopediaObject) o;
						this.defaultObject = eo.isDefaultID();
						loadTitle(o, readonly);
						loadContent((SubstanceData) o, readonly);
						setPreferredHeight(o instanceof SubstanceData_InSilico ? 2 * defaultItemHeight : defaultItemHeight);
					}
				
				@Override
				public void dataTemplateChanged(EventObject event)
					{
						loadContent(event.getSource(), ((EffectopediaObject) event.getSource()).isReadonly());
					}
				
				public void setLabTablesListener(AbstractTableModel labsTableModel)
					{
						if (labsTableModel!=null)
							labsTableModel.addTableModelListener(substanceDataTitleUI);
					}
			}
		
		/**
		 * 
		 */
		public class TestedSubstancesUI extends IndexedObjectListUI<TestedSubstanceUI>
			{
				
				public TestedSubstancesUI(RootHelpContext rootHelpContext)
				{
					super(rootHelpContext);
				}

				/**
			 * 
			 */
				private static final long	serialVersionUID	= 1L;
				
				public TestedSubstanceUI add(boolean enableSelectionDialog)
					{
						if (testDataIDs == null)
							return null;
						TestedSubstanceUI newTestedSubstance = new TestedSubstanceUI(rootHelpContext);
						newTestedSubstance.setLabTablesListener(labsTableModel);
						if (enableSelectionDialog)
							{
								ExistingChemicalDialog.DIALOG.load(DefaultEffectopediaObjects.DEFAULT_CHEM_STRUCTURE, false);
								Initiator_ChemicalStructure substance = (Initiator_ChemicalStructure) ExistingChemicalDialog.DIALOG.getSelectedInitiator();
								// if (ExistingChemicalDialog.DIALOG.wasDisplayed() &&
								// ExistingChemicalDialog.DIALOG.isCanceled())
								// return null;
								Test test = (Test) testDataIDs.getParent();
								if (substance == null)
									substance = DefaultEffectopediaObjects.DEFAULT_CHEM_STRUCTURE.clone(test, test.getDataSource());
								SubstanceData substanceData;
								if (test instanceof Test_InSilico)
									substanceData = DefaultEffectopediaObjects.DEFAULT_SUBSTANCE_DATA_INSILICO.clone(test, test.getDataSource());
								else
									substanceData = DefaultEffectopediaObjects.DEFAULT_SUBSTANCE_DATA_INLAB.clone(test, test.getDataSource());
								substanceData.getInitiator().set(substance);
								substanceData.getTest().set(test);
								tsuiTestedSubstances.add(newTestedSubstance, substanceData);
							}
						else
							tsuiTestedSubstances.add(newTestedSubstance);
						return newTestedSubstance;
					}
				
				@Override
				public Object getList()
					{
						return super.getIndexedList();
					}
				
			}
		
		/**
		 * Auto-generated main method to display this JPanel inside a new JFrame.
		 */
		public static void main(String[] args)
			{
				JFrame frame = new JFrame();
				frame.getContentPane().add(new TestedSubstancesListUI(null));
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				frame.pack();
				frame.setVisible(true);
			}
		
		public TestedSubstancesListUI(RootHelpContext rootHelpContext)
			{
				super(rootHelpContext);
				setName("substances_list");
				initGUI();
				adjustUI(EDIT);
			}
		
		private void initGUI()
			{
				try
					{
						setPreferredSize(optimalSize);
						BorderLayout thisLayout = new BorderLayout();
						this.setLayout(thisLayout);
						this.setBorder(BorderFactory.createTitledBorder(null, "Tested substances", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 2, 12)));
						this.setBackground(Color.WHITE);
							{
								tsuiTestedSubstances = new TestedSubstancesUI(rootHelpContext);
								this.add(tsuiTestedSubstances, BorderLayout.CENTER);
								tsuiTestedSubstances.setBackground(Color.WHITE);
								tsuiTestedSubstances.add(false);
							}
							{
								jletuiTestedSubstances = new ListEditorToolbarUI(tsuiTestedSubstances, "substance", ListEditorToolbarUI.DEFAULT, FlowLayout.RIGHT);
								this.add(jletuiTestedSubstances, BorderLayout.SOUTH);
								jletuiTestedSubstances.setVisible(true);
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
				if (!(o instanceof ReferenceIDs))
					return;
				testDataIDs = (ReferenceIDs<SubstanceData>) o;
				readonly = readonly || testDataIDs.isReadonly();
				tsuiTestedSubstances.setIndexedList(testDataIDs, readonly);
				jletuiTestedSubstances.updateEditButtons(readonly);
			}
		
		public void updateOptimalSize()
			{
				optimalSize.width = tsuiTestedSubstances.getWidth();
				optimalSize.height = tsuiTestedSubstances.getPreferredSize().height + ((jletuiTestedSubstances != null) ? jletuiTestedSubstances.getPreferredSize().height : 0);
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
		
		public void initializeUI()
			{
				tsuiTestedSubstances.initializeUI();
			}
		
		public AbstractTableModel getLabsTableModel()
			{
				return labsTableModel;
			}
		
		public void setLabsTableModel(AbstractTableModel labsTableModel)
			{
				this.labsTableModel = labsTableModel;
			}
		
		private AbstractTableModel										labsTableModel;
		
		private Dimension																			optimalSize	= new Dimension(400, 400);
		private ReferenceIDs<SubstanceData>	testDataIDs	= null;
	}