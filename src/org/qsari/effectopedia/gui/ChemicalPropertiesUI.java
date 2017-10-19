package org.qsari.effectopedia.gui;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;
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
 * @version 1.0 @(#)ChemicalPropertiesUI.java 1.0
 * @author Hristo Aladjov
 * 
 */

public class ChemicalPropertiesUI extends ContextSensitivePanel implements AdjustableUI, LoadableEditorUI
	{
		/**
	 * 
	 */
		private static final long	serialVersionUID	= 1L;
		private JScrollPane							jspChemicalProperties;
		private JTable												jtChemicalProperties;
		
		/**
		 * Auto-generated main method to display this JPanel inside a new JFrame.
		 */
		public static void main(String[] args)
			{
				JFrame frame = new JFrame();
				frame.getContentPane().add(new ChemicalPropertiesUI("Chemical Structure Properties",null));
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				frame.pack();
				frame.setVisible(true);
			}
		
		public ChemicalPropertiesUI(String title,RootHelpContext rootHelpContext)
			{
				super(rootHelpContext);
				setName("chemical_prop");
				initGUI(title);
			}
		
		private void initGUI(String title)
			{
				try
					{
						this.setPreferredSize(new java.awt.Dimension(480, 120));
						BorderLayout thisLayout = new BorderLayout();
						this.setLayout(thisLayout);
						this.setBorder(BorderFactory.createTitledBorder(null, title, TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12)));
						this.setBackground(Color.WHITE);
							{
								jspChemicalProperties = new JScrollPane();
								this.add(jspChemicalProperties, BorderLayout.CENTER);
								jspChemicalProperties.setPreferredSize(new java.awt.Dimension(150, 32));
								jspChemicalProperties.setBackground(Color.WHITE);
								jspChemicalProperties.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
									{
										TableModel jtChemicalPropertiesModel = new ChemPropertiesTableModel(false);
										jtChemicalProperties = new JTable();
										jspChemicalProperties.setViewportView(jtChemicalProperties);
										jspChemicalProperties.getViewport().setBackground(Color.WHITE);
										jtChemicalProperties.setModel(jtChemicalPropertiesModel);
									}
							}
					}
				catch (Exception e)
					{
						e.printStackTrace();
					}
			}
		
		class ChemPropertiesTableModel extends AbstractTableModel
			{
				/**
			 * 
			 */
				private static final long	serialVersionUID	= 1L;
				
				public ChemPropertiesTableModel(boolean readonly)
					{
						this.readonly = readonly;
					}
				
				public int getColumnCount()
					{
						return 5;
					}
				
				public int getRowCount()
					{
						if (properties == null)
							return 0;
						else
							return properties.getCount();
					}
				
				public Object getValueAt(int row, int column)
					{
						if (properties != null)
							{
								if (column == 0)
									return properties.getPropertyName(row);
								if (column == 1)
									return properties.getPropertyValue(row);
								if (column == 2)
									return properties.getPropertyUnit(row);
								if (column == 3)
									return properties.getPropertyDefaultDescriptors(row);
								if (column == 4)
									return properties.getPropertyReference(row);
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
						if (properties != null)
							if (col == 1)
								properties.setPropertyValue(row, value.toString());
							else if (col == 2)
								properties.setPropertyUnit(row, value.toString());
							else if (col == 3)
								properties.setPropertyConditions(row, value.toString());
							else if ((col == 4) && (isLong(value.toString())))
								properties.setPropertyReference(row, value.toString());
					}
				
				public boolean isLong(String s)
					{
						try
							{
								Long.parseLong(s);
							}
						catch (NumberFormatException nfe)
							{
								return false;
							}
						return true;
					}
				
				public String getColumnName(int c)
					{
						return columnNames[c];
					}
				
				public String[]						columnNames	= new String[]
																																						{ "Property", "Value", "Units", "Conditions", "Source" };
				public final boolean	readonly;
			}
		
		public void loadProperties(boolean readonly)
			{
				if (properties == null)
					return;
				ChemPropertiesTableModel tableModel = new ChemPropertiesTableModel(readonly);
				jtChemicalProperties.setModel(tableModel);
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
				setVisible((visualOptions & CHEMPROP) != 0);
			}
		
		public void load(Object o, boolean readonly)
			{
				if (!(o instanceof ObjectProperties))
					return;
				properties = (ObjectProperties) o;
				loadProperties(readonly);
			}
		
		private ObjectProperties	properties;
	}
