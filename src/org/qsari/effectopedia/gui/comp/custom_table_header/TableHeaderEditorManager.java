package org.qsari.effectopedia.gui.comp.custom_table_header;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

import org.qsari.effectopedia.gui.comp.custom_table_header.DefaultTableHeaderEditor.EditorActionListener;
import org.qsari.effectopedia.gui.comp.custom_table_header.DefaultTableHeaderEditor.OptionsListener;

public class TableHeaderEditorManager implements FocusListener, EditorActionListener
	{
		protected JTextField																																					defaultEditor;
		protected HashMap<ColumnGroup, DefaultTableHeaderEditor>	groupEditors;
		protected HashMap<TableColumn, DefaultTableHeaderEditor>	columnEditors;
		
		public TableHeaderEditorManager(JTable table)
			{
				this.table = table;
				this.header = table.getTableHeader();
				groupEditors = new HashMap<ColumnGroup, DefaultTableHeaderEditor>();
				columnEditors = new HashMap<TableColumn, DefaultTableHeaderEditor>();
				parentFrame = getFrame(table);
				install();
				initGUI();
			}
		
		private JFrame getFrame(Component component)
			{
				while (component != null)
					{
						component = component.getParent();
						if (component instanceof JFrame)
							return (JFrame) component;
					}
				return null;
			}
		
		public void setEditor(ColumnGroup group, DefaultTableHeaderEditor editor)
			{
				groupEditors.put(group, editor);
				editor.addEditorActionListener(this);
			}
		
		public void setEditor(TableColumn column, DefaultTableHeaderEditor editor)
			{
				columnEditors.put(column, editor);
				editor.addEditorActionListener(this);
			}
		
		public Component getEditor(ColumnGroup group)
			{
				return groupEditors.get(group);
			}
		
		public Component getEditor(TableColumn column)
			{
				return columnEditors.get(group);
			}
		
		public void clearEditors()
			{
				columnEditors.clear();
				groupEditors.clear();
			}
		
		private void install()
			{
				if (header instanceof GroupableTableHeader)
					mouseAdapter = new MouseAdapter()
						{
							@Override
							public void mouseClicked(MouseEvent event)
								{
									if (event.getClickCount() == 2)
										{
											if (timer != null)
												timer.stop();
											editGroupHeader(event.getPoint());
										}
									else
										{
											timer = new Timer(multiClickInterval.intValue(), new MouseActionListener(event.getPoint()));
											timer.setRepeats(false);
											timer.start();
										}
								}
						};
				else
					mouseAdapter = new MouseAdapter()
						{
							@Override
							public void mouseClicked(MouseEvent event)
								{
									if (event.getClickCount() == 2)
										editBasicColumnHeader(event.getPoint());
								}
						};
				header.addMouseListener(mouseAdapter);
			}
		
		public class MouseActionListener implements ActionListener
			{
				
				MouseActionListener(Point p)
					{
						this.p = p;
					}
				
				@Override
				public void actionPerformed(ActionEvent event)
					{
						showOptions(p);
					}
				
				Point	p;
				
			}
		
		public void uninstall()
			{
				clearEditors();
				if (mouseAdapter != null)
					header.removeMouseListener(mouseAdapter);
				mouseAdapter = null;
				finalize();
			}
		
		private void initGUI()
			{
				defaultEditor = new JTextField();
				defaultEditor.setBorder(null);
				defaultEditor.addActionListener(new ActionListener()
					{
						public void actionPerformed(ActionEvent e)
							{
								setValue();
							}
					});
				
				inplaceDialog = new JDialog(parentFrame);
				inplaceDialog.setUndecorated(true);
				inplaceDialog.setLocationRelativeTo(null);
				inplaceDialog.getContentPane().setLayout(new BorderLayout());
				inplaceDialog.getContentPane().add(defaultEditor, BorderLayout.CENTER);
				inplaceDialog.addFocusListener(this);
			}

		protected void showOptions(Point p)
			{
				int columnIndex = header.columnAtPoint(p);
				if (columnIndex == -1)
					return;
				column = header.getColumnModel().getColumn(columnIndex);
				Rectangle groupRect = header.getHeaderRect(columnIndex);
				List<ColumnGroup> groups = ((GroupableTableHeader) header).getColumnGroups(column);
				Map<ColumnGroup, Rectangle> groupSizeMap = ((GroupableTableHeaderUI) ((GroupableTableHeader) header).getUI()).getGroupSizeMap();
				int groupHeight = 0;
				this.group = null;
				for (ColumnGroup grp : groups)
					{
						groupRect = groupSizeMap.get(grp);
						groupHeight += groupRect.height;
						if (groupHeight > p.y)
							{
								this.group = grp;
								break;
							}
					}
				inplaceDialog.getContentPane().removeAll();
				DefaultTableHeaderEditor editor = groupEditors.get(group);
				if (editor == null)
					editor = columnEditors.get(column);
				if (editor != null)
					editor.fireShowOptions();
			}
		
		private void editGroupHeader(Point p)
			{
				int columnIndex = header.columnAtPoint(p);
				if (columnIndex == -1)
					return;
				column = header.getColumnModel().getColumn(columnIndex);
				Rectangle groupRect = header.getHeaderRect(columnIndex);
				Rectangle cellRect = new Rectangle(groupRect);
				// System.out.println("Column rect x " + groupRect.x + " y " + groupRect.y
				// + " width " + groupRect.width + " height " + groupRect.height);
				List<ColumnGroup> groups = ((GroupableTableHeader) header).getColumnGroups(column);
				Map<ColumnGroup, Rectangle> groupSizeMap = ((GroupableTableHeaderUI) ((GroupableTableHeader) header).getUI()).getGroupSizeMap();
				int groupHeight = 0;
				this.group = null;
				for (ColumnGroup grp : groups)
					{
						groupRect = groupSizeMap.get(grp);
						groupHeight += groupRect.height;
						if (groupHeight > p.y)
							{
								this.group = grp;
								break;
							}
					}
				// System.out.println("Group rect x " + groupRect.x + " y " + groupRect.y
				// + " width " + groupRect.width + " height " + groupRect.height);
				Point location;
				inplaceDialog.getContentPane().removeAll();
				DefaultTableHeaderEditor editor = groupEditors.get(group);
				if (editor == null)
					editor = columnEditors.get(column);
				if (group != null)
					{
						if (editor != null)
							editor.load(group.getHeaderValue(), false);
						else
							defaultEditor.setText(group.getHeaderValue().toString());
						inplaceDialog.setSize(groupRect.width - 1, groupRect.height - 1);
						location = groupRect.getLocation();
					}
				else
					{
						if (editor != null)
							editor.load(column.getHeaderValue(), false);
						else
							defaultEditor.setText(column.getHeaderValue().toString());
						inplaceDialog.setSize(cellRect.width - 1, cellRect.height - groupHeight - 1);
						location = new Point(cellRect.x, groupHeight);
					}
				
				if (editor != null)
					{
						inplaceDialog.getContentPane().add(editor, BorderLayout.CENTER);
						defaultEditor.setVisible(false);
					}
				else
					{
						inplaceDialog.getContentPane().add(defaultEditor, BorderLayout.CENTER);
						defaultEditor.setVisible(true);
					}
				SwingUtilities.convertPointToScreen(location, table.getTableHeader());
				inplaceDialog.setLocation(location);
				inplaceDialog.setVisible(true);
			}
		
		private void editBasicColumnHeader(Point p)
			{
				int columnIndex = header.columnAtPoint(p);
				if (columnIndex != -1)
					{
						column = header.getColumnModel().getColumn(columnIndex);
						Rectangle columnRectangle = header.getHeaderRect(columnIndex);
						
						defaultEditor.setText(column.getHeaderValue().toString());
						inplaceDialog.setSize(columnRectangle.width, columnRectangle.height - 1);
						inplaceDialog.setLocation(columnRectangle.x, 0);
						inplaceDialog.setVisible(true);
						defaultEditor.requestFocusInWindow();
						defaultEditor.selectAll();
						defaultEditor.setCaretPosition(0);
					}
			}
		
		@Override
		public void listEditorActionPerformed(int actionCode)
			{
				if (actionCode == DefaultTableHeaderEditor.acOK)
					setValue();
				else
					{
						inplaceDialog.setVisible(false);
						header.repaint();
					}
			}
		
		private void setValue()
			{
				DefaultTableHeaderEditor editor = groupEditors.get(group);
				if (group != null)
					if (editor != null)
						group.setHeaderValue(editor.getObject());
					else
						group.setHeaderValue(defaultEditor.getText());
				else if (editor != null)
					column.setHeaderValue(editor.getObject());
				else
					column.setHeaderValue(defaultEditor.getText());
				inplaceDialog.setVisible(false);
				header.invalidate();
				header.repaint();
			}
		
		@Override
		public void focusGained(FocusEvent e)
			{
			}
		
		@Override
		public void focusLost(FocusEvent e)
			{
				inplaceDialog.setVisible(false);
			}
		
		protected void finalize()
			{
				inplaceDialog.dispose();
			}
		
		protected static Integer			multiClickInterval	= (Integer) Toolkit.getDefaultToolkit().getDesktopProperty("awt.multiClickInterval");
		protected static int							DELETE													= KeyEvent.VK_DELETE;
		static
			{
				if (multiClickInterval == null)
					multiClickInterval = new Integer(500);
			}
		protected Timer												timer;
		
		protected OptionsListener		optionsLister;
		private MouseAdapter							mouseAdapter;
		private final JTableHeader	header;
		private final JTable							table;
		private JDialog												inplaceDialog;
		private TableColumn								column;
		private ColumnGroup								group;
		private JFrame													parentFrame;
		
	}