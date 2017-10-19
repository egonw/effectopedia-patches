package org.qsari.effectopedia.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.EventListener;
import java.util.EventObject;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;
import javax.swing.event.EventListenerList;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import org.qsari.effectopedia.data.objects.ObjectProperties;
import org.qsari.effectopedia.gui.core.LoadableEditorUI;
import org.qsari.effectopedia.gui.help.ContextSensitivePanel;
import org.qsari.effectopedia.gui.help.RootHelpContext;


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
 * @version 1.0 @(#)ChemicalInfoUI.java 1.0
 * @author Hristo Aladjov
 * 
 */

public class ChemicalInfoUI extends ContextSensitivePanel implements AdjustableUI, LoadableEditorUI
	{
		/**
	 * 
	 */
		private static final long	serialVersionUID	= 1L;
		
		private JScrollPane							jspChemicalInfo;
		private JTable												jtChemicalInfo;
		
		/**
		 * Auto-generated main method to display this JPanel inside a new JFrame.
		 */
		public static void main(String[] args)
			{
				JFrame frame = new JFrame();
				frame.getContentPane().add(new ChemicalInfoUI(null));
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				frame.pack();
				frame.setVisible(true);
			}

		public ChemicalInfoUI(RootHelpContext rootHelpContext)
			{
				super(rootHelpContext);
				setName("chemical_info");
				eventListeners = new EventListenerList();
				initGUI("Chemical Info");
			}
		
		public ChemicalInfoUI(String title,RootHelpContext rootHelpContext)
			{
				super(rootHelpContext);
				setName("chemical_info");
				eventListeners = new EventListenerList();
				initGUI(title);
			}
		
		/**
		 * Inits the GUI and creates all the contained components.
		 */
		private void initGUI(String title)
			{
				try
					{
						BorderLayout thisLayout = new BorderLayout();
						this.setLayout(thisLayout);
						setPreferredSize(new Dimension(240, 120));
						this.setBorder(BorderFactory.createTitledBorder(null, title, TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12)));
						this.setBackground(Color.white);
							{
								jspChemicalInfo = new JScrollPane();
								this.add(jspChemicalInfo, BorderLayout.CENTER);
								jspChemicalInfo.setPreferredSize(new java.awt.Dimension(60, 40));
								jspChemicalInfo.setBackground(Color.white);
								jspChemicalInfo.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
									{
										TableModel jtChemicalInfoModel = new ChemInfoTableModel(false);
										jtChemicalInfo = new JTable();
										jspChemicalInfo.setViewportView(jtChemicalInfo);
										jspChemicalInfo.getViewport().setBackground(Color.WHITE);
										jtChemicalInfo.setModel(jtChemicalInfoModel);
										jtChemicalInfo.getTableHeader().setBounds(0, 0, 150, 32);
										jtChemicalInfo.setName("chemical_info");
										jtChemicalInfo.addMouseMotionListener(this);
									}
							}
					}
				catch (Exception e)
					{
						e.printStackTrace();
					}
			}
		
		class ChemInfoTableModel extends AbstractTableModel
			{
				/**
			 * 
			 */
			private static final long	serialVersionUID	= 1L;

				public ChemInfoTableModel(boolean readonly)
					{
						super();
						this.readonly = readonly;
					}
				
				public int getColumnCount()
					{
						return 2;
					}
				
				public int getRowCount()
					{
						if (chemInfo == null)
							return 0;
						else
							return chemInfo.getCount();
					}
				
				public Object getValueAt(int row, int column)
					{
						if (chemInfo != null)
							{
								if (column == 0)
									return chemInfo.getPropertyName(row);
								if (column == 1)
									return chemInfo.getPropertyValue(row);
								else
									return null;
							}
						return null;
					}
				
				public boolean isCellEditable(int row, int column)
					{
						return !readonly;
					}
				
				public Class<?> getColumnClass(int col)
					{
						return String.class;
					}
				
				public void setValueAt(Object value, int row, int col)
					{
						if (chemInfo != null)
							if (col == 1)
								{
								chemInfo.setPropertyValue(row, value.toString().trim());
								fireChemicalInfoChanged(new EventObject(this));
								}
					}
				
				
				public String getColumnName(int c)
					{
						return columnNames[c];
					}
				
				public String[]	columnNames	= new String[]
																																	{ "Descriptor", "Value" };
				public final boolean readonly;
			}
		
		public void loadChemInfo(boolean readonly)
			{
				if (chemInfo == null)
					return;
				ChemInfoTableModel tableModel = new ChemInfoTableModel(readonly);
				jtChemicalInfo.setModel(tableModel);
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
				setVisible((visualOptions & CHEMINFO) != 0);
			}
		
		public void load(Object o, boolean readonly)
			{
				if (!(o instanceof ObjectProperties))
					return;
				chemInfo = (ObjectProperties) o;
				loadChemInfo(readonly);
			}
		
	public interface ChemicalInfoChangeListener extends EventListener
		{
			public void infoChanged(EventObject evt);
		}
	
	public void addChemicalInfoChangeListener(ChemicalInfoChangeListener listener)
		{
			eventListeners.add(ChemicalInfoChangeListener.class, listener);
		}
	
	public void removeChemicalInfoListener(ChemicalInfoChangeListener listener)
		{
			eventListeners.remove(ChemicalInfoChangeListener.class, listener);
		}
	
	protected void fireChemicalInfoChanged(EventObject evt)
		{
			ChemicalInfoChangeListener[] listeners = eventListeners.getListeners(ChemicalInfoChangeListener.class);
			for (int i = 0; i < listeners.length; i++)
				listeners[i].infoChanged(evt);
		}
	
 	protected EventListenerList					eventListeners;
		private ObjectProperties	chemInfo;
	}
