package org.qsari.effectopedia.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.StringTokenizer;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;

import org.qsari.effectopedia.base.ids.ReferenceIDs;
import org.qsari.effectopedia.core.objects.Lab;
import org.qsari.effectopedia.defaults.DefaultEffectopediaObjects;
import org.qsari.effectopedia.gui.core.ClipboardTransferableUI;
import org.qsari.effectopedia.gui.core.LoadableEditorUI;
import org.qsari.effectopedia.gui.help.ContextSensitivePanel;
import org.qsari.effectopedia.gui.help.RootHelpContext;
import org.qsari.effectopedia.gui.ref_ids_table.LabRIDTM;
import org.qsari.effectopedia.gui.ref_ids_table.ReferenceIDsTableModel;
import org.qsari.effectopedia.gui.ref_ids_table.ReferenceIDsTableUI;
import org.qsari.effectopedia.gui.toolbars.ListEditorToolbarUI;
import org.qsari.effectopedia.gui.util.ClipboardUtilities;

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
public class LabsUI extends ContextSensitivePanel implements AdjustableUI, LoadableEditorUI
	{
		/**
	 * 
	 */
		private static final long								serialVersionUID	= 1L;
		private ListEditorToolbarUI						letuiLabs;
		private LabRIDTM																	lrdidtmTableModel;
		private LabsTableUI	ltuitLabs;
		
		/**
		 * Auto-generated main method to display this JPanel inside a new JFrame.
		 */
		public static void main(String[] args)
			{
				JFrame frame = new JFrame();
				frame.getContentPane().add(new LabsUI(null));
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				frame.pack();
				frame.setVisible(true);
			}
		
		public class LabsTableUI extends ReferenceIDsTableUI<Lab> implements ClipboardTransferableUI
			{
				public LabsTableUI(ReferenceIDsTableModel<Lab> tableModel,boolean showHeader)
					{
						super(tableModel,showHeader);
					}
				
				@Override
				public Lab add(boolean enableSelectionDialog)
					{
						ReferenceIDs<Lab> ref =  getReferenceIDs();
						if (ref != null)
							{
								Lab lab = DefaultEffectopediaObjects.DEFAULT_LAB.clone(ref.getParent(),ref.getDataSource());
								tableModel.addRow(lab);
								return lab;
							}
						return null;
					}

				@Override
				public void copy()
					{
						if (labs != null)
							{
								StringBuilder sb = new StringBuilder();
								Lab[] list = labs.getCachedObjects();
								for (Lab lab : list)
									{
										sb.append(lab.getDelimitedDescription("\t"));
										sb.append("\n");
									}
								ClipboardUtilities.setClipboard(sb.toString());
							}
					}
				
				@Override
				public void paste()
					{
						if (labs != null)
							{
								StringTokenizer st = new StringTokenizer(ClipboardUtilities.getClipboard(), "\n");
								while (st.hasMoreTokens())
									{
										Lab lab = DefaultEffectopediaObjects.DEFAULT_LAB.clone();
										lab.setFromDelimitedDescription(st.nextToken(), "\t");
										add(lab);
									}
							}
					}

				
				/**
			 * 
			 */
			private static final long	serialVersionUID	= 1L;
			}
		
		public LabsUI(RootHelpContext rootHelpContext)
			{
				super(rootHelpContext);
				setName("labs");
				initGUI();
			}
		
		private void initGUI()
			{
				try
					{
						setPreferredSize(new Dimension(400, 200));
						BorderLayout thisLayout = new BorderLayout();
						this.setLayout(thisLayout);
						this.setBorder(BorderFactory.createTitledBorder(null, "Labs", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 2, 12)));
						this.setBackground(Color.white);
							{
								lrdidtmTableModel = new LabRIDTM(null, true);
								ltuitLabs = new LabsTableUI(lrdidtmTableModel,true);
								this.add(ltuitLabs,BorderLayout.CENTER);
							}
							{
								letuiLabs = new ListEditorToolbarUI(ltuitLabs, "lab", ListEditorToolbarUI.DEFAULT+ListEditorToolbarUI.CLIPBACT, FlowLayout.RIGHT);
								this.add(letuiLabs, BorderLayout.SOUTH);
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
				this.setVisible((visualOptions & LABS) != 0);
				letuiLabs.adjustUI(visualOptions);
			}
		
		public void load(Object o, boolean readonly)
			{
				if (!(o instanceof ReferenceIDs<?>))
					return;
				labs = (ReferenceIDs<Lab>) o;
				lrdidtmTableModel.setReferenceIDs(labs, readonly);
			}
		
		public LabRIDTM getLabsTableModel()
			{
				return lrdidtmTableModel;
			}


		ReferenceIDs<Lab>	labs	= null;
	}
