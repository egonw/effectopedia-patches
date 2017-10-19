package org.qsari.effectopedia.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableModel;

import org.qsari.effectopedia.core.Effectopedia;
import org.qsari.effectopedia.core.containers.Discussion;
import org.qsari.effectopedia.core.objects.DiscussionTopic;
import org.qsari.effectopedia.core.ui.UserInterface;
import org.qsari.effectopedia.core.ui.nav.UILocations;
import org.qsari.effectopedia.gui.core.LoadableEditorUI;
import org.qsari.effectopedia.gui.help.ContextSensitivePanel;
import org.qsari.effectopedia.gui.help.RootHelpContext;
import org.qsari.effectopedia.system.Users;

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
public class RelatedTopicsUI extends ContextSensitivePanel implements AdjustableUI, LoadableEditorUI, ListSelectionListener
	{
		/**
	 * 
	 */
		private static final long	serialVersionUID	= 1L;
		private JScrollPane							jspRelatedTopics;
		private JTable												jtRelatedTopics;
		
		/**
		 * Auto-generated main method to display this JPanel inside a new JFrame.
		 */
		public static void main(String[] args)
			{
				JFrame frame = new JFrame();
				frame.getContentPane().add(new RelatedTopicsUI(null));
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				frame.pack();
				frame.setVisible(true);
			}
		
		public RelatedTopicsUI(RootHelpContext rootHelpContext)
			{
				super(rootHelpContext);
				setName("related_topics");
				initGUI();
			}
		
		private void initGUI()
			{
				try
					{
						setPreferredSize(new Dimension(400, 300));
						BorderLayout thisLayout = new BorderLayout();
						this.setLayout(thisLayout);
						this.setBorder(BorderFactory.createTitledBorder(null, "Related Topics", TitledBorder.LEADING, TitledBorder.TOP, new java.awt.Font("Tahoma", 2, 11)));
							{
								jspRelatedTopics = new JScrollPane();
								this.add(jspRelatedTopics, BorderLayout.CENTER);
									{
										TableModel jtRelatedTopicsModel = new RelatedTopicsTableModel();
										jtRelatedTopics = new JTable();
										jspRelatedTopics.setViewportView(jtRelatedTopics);
										jtRelatedTopics.setModel(jtRelatedTopicsModel);
										jtRelatedTopics.getSelectionModel().addListSelectionListener(this);
										jtRelatedTopics.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
										// jtRelatedTopics.getColumnModel().getSelectionModel().addListSelectionListener(this);
										jtRelatedTopics.setPreferredSize(new java.awt.Dimension(387, 32));
									}
							}
					}
				catch (Exception e)
					{
						e.printStackTrace();
					}
			}
		
		class RelatedTopicsTableModel extends AbstractTableModel
			{
				/**
		 * 
		 */
				private static final long	serialVersionUID	= 1L;
				
				public RelatedTopicsTableModel()
					{
						super();
					}
				
				protected TableCellEditor getCellEditor(int row, int column)
					{
						return jtRelatedTopics.getDefaultEditor(jtRelatedTopics.getColumnClass(column));
					}
				
				public int getColumnCount()
					{
						return 4;
					}
				
				public int getRowCount()
					{
						if (realtedTopics != null)
							return realtedTopics.size();
						else
							return 0;
					}
				
				public Object getValueAt(int row, int column)
					{
						try
							{
								if (realtedTopics != null)
									{
										DiscussionTopic topic = realtedTopics.get(row);
										if (column == 0)
											return topic.getAboutObject();
										else if (column == 1)
											return topic.getSubject();
										else if (column == 2)
											return Users.REGISTERED.getDisplayName(topic.getStamp().getUserId());
										else if (column == 3)
											return topic.getStamp().getFormattedDate();
										else
											return null;
									}
							}
						catch (Exception e)
							{
								e.printStackTrace();
								return null;
							}
						return null;
					}
				
				public Class<?> getColumnClass(int col)
					{
						return String.class;
					}
				
				public void setValueAt(Object value, int row, int col)
					{
					}
				
				public boolean isCellEditable(int row, int column)
					{
						return false;
					}
				
				public String getColumnName(int c)
					{
						return columnNames[c];
					}
				
				public String[]	columnNames	= new String[]
																																	{ "About", "Subject", "User", "Date" };
			}
		
		@Override
		public void valueChanged(ListSelectionEvent e)
			{
				int row = jtRelatedTopics.getSelectedRow();
				//System.out.print(row);
				if ((row >= 0) && (realtedTopics != null) && (row < realtedTopics.size()))
					UserInterface.getDefaultNavigator().navigate(UILocations.discussUIL, DiscussionTopic.locateORCreateTopic(realtedTopics.get(row).getAboutObject()));
			}
		
		public void load(Object o, boolean readonly)
			{
				if (o instanceof DiscussionTopic)
					{
						DiscussionTopic topic = (DiscussionTopic) o;
						Discussion discussion = Effectopedia.EFFECTOPEDIA.getData().getLiveIndices().getDiscussion();
						realtedTopics = discussion.getRelatedTopics(topic.getAboutObject());
						jtRelatedTopics.getSelectionModel().setLeadSelectionIndex(realtedTopics.indexOf(topic));
						jtRelatedTopics.repaint();
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
		
		private ArrayList<DiscussionTopic>	realtedTopics;
		
	}
