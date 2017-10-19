package org.qsari.effectopedia.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.util.EventListener;
import java.util.EventObject;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;
import javax.swing.event.EventListenerList;

import org.qsari.effectopedia.base.ids.ReferenceIDs;
import org.qsari.effectopedia.core.Effectopedia;
import org.qsari.effectopedia.core.objects.Pathway;
import org.qsari.effectopedia.core.objects.PathwayElement;
import org.qsari.effectopedia.data.DataSource;
import org.qsari.effectopedia.gui.core.LoadableEditorUI;
import org.qsari.effectopedia.gui.help.ContextSensitivePanel;
import org.qsari.effectopedia.gui.help.RootHelpContext;
import org.qsari.effectopedia.gui.ref_ids_table.PathwayRIDTM;
import org.qsari.effectopedia.gui.ref_ids_table.ReferenceIDsTableUI;
import org.qsari.effectopedia.gui.toolbars.ListEditorToolbarUI;

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
public class PathwaysListUI extends ContextSensitivePanel implements AdjustableUI, LoadableEditorUI, SizeOptimizableUI
	{
		/**
	 * 
	 */
		private static final long			serialVersionUID	= 1L;
		private ListEditorToolbarUI	letuiPathwaysListToolbar;
		private PathwayTableUI						ptuiPathways;
		
		class PathwayTableUI extends ReferenceIDsTableUI<Pathway>
			{
				
				/**
			 * 
			 */
				private static final long	serialVersionUID	= 1L;
				
				public PathwayTableUI(boolean readonly)
					{
						super(new PathwayRIDTM(null, readonly),false);
						eventListeners = new EventListenerList();
						setName("list");
					}
				
				@Override
				public Pathway add(boolean enableSelectionDialog)
					{
						Pathway pathway = null;
						ExistingPathwayDialog.DIALOG.load(pathway, PathwaysListUI.this.readonly);
						pathway = ExistingPathwayDialog.DIALOG.getSelectedPathway();
						if (pathway != null)
							{
								if (ExistingPathwayDialog.DIALOG.isUpdateUpstreamElementsSelected())
									pathway.associateUpstream(element);
								pathway.add(element);
								if (ExistingPathwayDialog.DIALOG.isUpdateDownstreamElementsSelected())
									pathway.associateDownstream(element);
								pathway.sortElements();
								firePathwayListChanged(new EventObject(pathway));
								DataSource ds = Effectopedia.EFFECTOPEDIA.getData();
								if (ds != null)
									ds.getCurrentView().addNewPathway(pathway);
								ptuiPathways.refresh();
							}
						return pathway;
					}
				
				protected void removeRow(int index)
					{
						if (element != null)
							{
								Pathway pathway = element.getPathwayIDs().getCachedObject(index);
								if (pathway != null)
									{
										DisassociatePathwayDialog.DIALOG.load(pathway, true);
										if (DisassociatePathwayDialog.DIALOG.isCanceled())
											return;
										if (DisassociatePathwayDialog.DIALOG.isUpdateUpstreamElementsSelected())
											pathway.disassociateUpstream(element);
										if (DisassociatePathwayDialog.DIALOG.isUpdateDownstreamElementsSelected())
											pathway.disassociateDownstream(element);
										pathway.disassociate(element);
										tableModel.fireTableRowsDeleted(index, index);
									}
							}
					}
				
			}
		
		/**
		 * Auto-generated main method to display this JPanel inside a new JFrame.
		 */
		public static void main(String[] args)
			{
				JFrame frame = new JFrame();
				frame.getContentPane().add(new PathwaysListUI(null));
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				frame.pack();
				frame.setVisible(true);
			}
		
		public PathwaysListUI(RootHelpContext rootHelpContext)
			{
				super(rootHelpContext);
				setName("pathways_list");
				initGUI();
			}
		
		private void initGUI()
			{
				try
					{
						BorderLayout thisLayout = new BorderLayout();
						this.setLayout(thisLayout);
						setPreferredSize(new Dimension(200, 120));
						this.setBorder(BorderFactory.createTitledBorder(null, "Associated Pathways", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 2, 12)));
						this.setBackground(Color.WHITE);
							{
								ptuiPathways = new PathwayTableUI(false);
								this.add(ptuiPathways, BorderLayout.CENTER);
								ptuiPathways.addMouseMotionListener(this);
							}
							
							{
								letuiPathwaysListToolbar = new ListEditorToolbarUI(ptuiPathways, "pathway", ListEditorToolbarUI.DEFAULT, FlowLayout.RIGHT);
								this.add(letuiPathwaysListToolbar, BorderLayout.SOUTH);
								letuiPathwaysListToolbar.setPreferredSize(new java.awt.Dimension(390, 16));
								letuiPathwaysListToolbar.addMouseMotionListener(this);
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
				this.setVisible((visualOptions & RELATEDLNK) != 0);
				letuiPathwaysListToolbar.adjustUI(visualOptions);
			}
		
		@SuppressWarnings("unchecked")
		public void load(Object o, boolean readonly)
			{
				if (!(o instanceof ReferenceIDs))
					return;
				readonly = readonly || ((ReferenceIDs<Pathway>) o).isReadonly();
				this.readonly = readonly;
				ReferenceIDs<Pathway> reference = (ReferenceIDs<Pathway>) o;
				element = (PathwayElement) reference.getParent();
				ptuiPathways.setReferenceIDs(reference, readonly);
				ptuiPathways.setAllowInplaceEditing(false);
				letuiPathwaysListToolbar.updateEditButtons(readonly);
				ptuiPathways.updateOptimalSize();
			}
		
		public void updateOptimalSize()
			{
				Insets insets = this.getBorder().getBorderInsets(this);
				optimalSize.width = ptuiPathways.getWidth() + insets.left + insets.right;
				optimalSize.height = letuiPathwaysListToolbar.getPreferredSize().height + ptuiPathways.getPreferredSize().height + insets.top + insets.bottom;
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
		
		public interface PathwayListChangeListener extends EventListener
			{
				public void listChanged(EventObject evt);
			}
		
		public void addPathwayListChangeListener(PathwayListChangeListener listener)
			{
				eventListeners.add(PathwayListChangeListener.class, listener);
			}
		
		public void removePathwayListListener(PathwayListChangeListener listener)
			{
				eventListeners.remove(PathwayListChangeListener.class, listener);
			}
		
		protected void firePathwayListChanged(EventObject evt)
			{
				PathwayListChangeListener[] listeners = eventListeners.getListeners(PathwayListChangeListener.class);
				for (int i = 0; i < listeners.length; i++)
					listeners[i].listChanged(evt);
			}
		
		protected EventListenerList	eventListeners;
		private Dimension											optimalSize	= new Dimension(400, 100);
		private PathwayElement						element					= null;
		private boolean													readonly				= false;
	}
