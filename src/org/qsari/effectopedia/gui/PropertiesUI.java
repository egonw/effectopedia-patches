package org.qsari.effectopedia.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JViewport;
import javax.swing.ListCellRenderer;
import javax.swing.ListModel;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;

import org.qsari.effectopedia.data.objects.DataValues;
import org.qsari.effectopedia.gui.core.LoadableEditorUI;
import org.qsari.effectopedia.gui.help.ContextSensitivePanel;
import org.qsari.effectopedia.gui.help.RootHelpContext;
import org.qsari.effectopedia.search.SearchIndices;

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
public class PropertiesUI extends ContextSensitivePanel implements LoadableEditorUI, SizeOptimizableUI
	{
		/**
	 * 
	 */
		private static final long	serialVersionUID	= 1L;
		private JScrollPane							jspProperties;
		private JTable												jtProperties;
		
		/**
		 * Auto-generated main method to display this JPanel inside a new JFrame.
		 */
		public static void main(String[] args)
			{
				JFrame frame = new JFrame();
				frame.getContentPane().add(new PropertiesUI(null));
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				frame.pack();
				frame.setVisible(true);
			}
		
		public PropertiesUI(RootHelpContext rootHelpContext)
			{
				super(rootHelpContext);
				setName("properties");
				initGUI();
			}
		
		private void initGUI()
			{
				try
					{
						BorderLayout thisLayout = new BorderLayout();
						this.setLayout(thisLayout);
						this.setPreferredSize(optimalSize);
						this.setSize(optimalSize);
							{
								jspProperties = new JScrollPane();
								this.add(jspProperties, BorderLayout.CENTER);
									{
										jtDefaultPropertiesModel = new DefaultTableModel(new String[][]
											{
												{ "" }, {""}, {""}, {""} }, new String[]
											{ "","","","" });
										jtProperties = new JTable()
											{
												/**
												 * 
												 */
												private static final long	serialVersionUID	= 1L;
												
												protected void configureEnclosingScrollPane()
													{
														Container p = getParent();
														if (p instanceof JViewport)
															{
																Container gp = p.getParent();
																if (gp instanceof JScrollPane)
																	{
																		JScrollPane scrollPane = (JScrollPane) gp;
																		JViewport viewport = scrollPane.getViewport();
																		viewport.setBackground(Color.WHITE);
																		if (viewport == null || viewport.getView() != this)
																			return;
																		scrollPane.setBorder(UIManager.getBorder("Table.scrollPaneBorder"));
																	}
															}
													}
											};
										jspProperties.setViewportView(jtProperties);
										jspProperties.setColumnHeader(null);
										jspProperties.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
										jtProperties.setPreferredSize(new java.awt.Dimension(400, 68));
										jtProperties.setModel(jtDefaultPropertiesModel);
										jtProperties.getTableHeader().setReorderingAllowed(false);
										jtProperties.getTableHeader().setResizingAllowed(false);
										// jtProperties.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
										//jspProperties.getViewport().setPreferredSize(new java.awt.Dimension(400, 68));
										jspProperties.setBackground(Color.WHITE);
										jspProperties.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
										jtProperties.setPreferredSize(jspProperties.getViewport().getPreferredSize());
										RootHelpContext.addMouseMotionListeners(this, rootHelpContext,false);
									}
							}
					}
				catch (Exception e)
					{
						e.printStackTrace();
					}
			}
		
		private class RowHeaderRenderer extends JLabel implements ListCellRenderer<String>
			{
				/**
			 * 
			 */
				private static final long	serialVersionUID	= 1L;
				
				RowHeaderRenderer(JTable table)
					{
						JTableHeader header = table.getTableHeader();
						setOpaque(true);
						setBorder(UIManager.getBorder("TableHeader.cellBorder"));
						setHorizontalAlignment(CENTER);
						setForeground(header.getForeground());
						setBackground(header.getBackground());
						setFont(header.getFont());
					}
				
				@Override
				public Component getListCellRendererComponent(JList<? extends String> list, String value, int index, boolean isSelected, boolean cellHasFocus)
					{
						setText((value == null) ? "" : value.toString());
						return this;
					}
				
			}
		
		public void update()
			{
				if (searchableProperties == null)
					{
						jtProperties.setModel(jtDefaultPropertiesModel);
					}
				else
					{
						TableModel jtPropertiesModel = searchableProperties.getTableModel(readonly);
						jlPropertiesModel = searchableProperties.getCaptionsModel(readonly);
						jtProperties.setModel(jtPropertiesModel);
						JList<String> rowHeader = new JList<String>(jlPropertiesModel);
						rowHeader.setFixedCellWidth(100);
						rowHeader.setFixedCellHeight(jtProperties.getRowHeight());
						rowHeader.setCellRenderer(new RowHeaderRenderer(jtProperties));
						jspProperties.setRowHeaderView(rowHeader);
					}
				updateOptimalSize();
			}
		
		public void load(Object o, boolean readonly)
			{
				if (!(o instanceof DataValues))
					return;
				this.readonly = readonly;
				searchableProperties = (DataValues) o;
				searchableProperties.removeBySearhIndexName(SearchIndices.TITLE_INDEX);
				update();
			}
		
		public void updateOptimalSize()
			{
				optimalSize.width = jtProperties.getWidth();
				if (optimalSize.width == 0)
					optimalSize.width = 400;
				optimalSize.height = (jtProperties.getRowCount()) * (jtProperties.getRowHeight() + 1);
				setMinimumSize(optimalSize);
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
		
		private Dimension									optimalSize										= new Dimension(400, 64);
		
		private DataValues								searchableProperties	= null;
		private TableModel								jtDefaultPropertiesModel;
		private ListModel<String>	jlPropertiesModel;
		private boolean											readonly;
	}
