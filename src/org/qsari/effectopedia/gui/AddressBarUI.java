package org.qsari.effectopedia.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventObject;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ComboBoxEditor;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;
import javax.swing.WindowConstants;

import org.qsari.effectopedia.core.Effectopedia;
import org.qsari.effectopedia.core.Effectopedia.DataSourceChange;
import org.qsari.effectopedia.core.Effectopedia.DataSourceChangeListener;
import org.qsari.effectopedia.data.DataSource;
import org.qsari.effectopedia.data.DataSourceItem;
import org.qsari.effectopedia.data.FileDS;
import org.qsari.effectopedia.data.HistoricalDS;
import org.qsari.effectopedia.data.MemoryDS;
import org.qsari.effectopedia.data.RevisionBasedDS;
import org.qsari.effectopedia.data.RevisionBasedDS.LocationChangeListener;
import org.qsari.effectopedia.defaults.DefaultGUISettings;
import org.qsari.effectopedia.gui.help.ContextSensitivePanel;
import org.qsari.effectopedia.gui.help.RootHelpContext;
import org.qsari.effectopedia.gui.ref_ids_table.DataSourceListModel;
import org.qsari.effectopedia.gui.toolbars.CommandToolbarUI;
import org.qsari.effectopedia.gui.toolbars.LocationEditor;
import org.qsari.effectopedia.gui.toolbars.RevisionNavigationToolbarUI;

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
public class AddressBarUI extends ContextSensitivePanel implements AdjustableUI, DataSourceChangeListener, LocationChangeListener, RootHelpContext
	{
		/**
	 * 
	 */
		public int																										MAX_LOCATION_VISIBLE_CHARACTER_COUNT	= 100;
		private static final long											serialVersionUID																					= 1L;
		// private JButton jbLoading;
		private JComboBox<DataSourceItem>			jcbLoaction;
		private DataSourceListModel									dslmLoactionModel;
		private DataSourceItemRenderer						dsirItemRenderer;
		private RevisionNavigationToolbarUI	rntbuiRevisionNavigationToolbar;
		private CommandToolbarUI												ctuiCommandToolbar;
		private GradientPanel															gradient;
		
		public static void main(String[] args)
			{
				JFrame frame = new JFrame();
				frame.getContentPane().add(new AddressBarUI());
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				frame.pack();
				frame.setVisible(true);
			}
		
		public AddressBarUI()
			{
				super(null);
				setName("address_bar");
				initGUI();
				Effectopedia.EFFECTOPEDIA.addDataSourceChangeListener(this);
			}
		
		private void initGUI()
			{
				try
					{
							{
								BoxLayout thisLayout = new BoxLayout(this, javax.swing.BoxLayout.X_AXIS);
								this.setLayout(thisLayout);
								this.setPreferredSize(new java.awt.Dimension(462, 25));
								this.setBackground(Color.white);
									{
										rntbuiRevisionNavigationToolbar = new RevisionNavigationToolbarUI(RevisionNavigationToolbarUI.ALL);
										rntbuiRevisionNavigationToolbar.setMaximumSize(CommandToolbarUI.optmalSize);
										// ctuiCommandToolbar.setBackground(java.awt.Color.white);
										rntbuiRevisionNavigationToolbar.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
										rntbuiRevisionNavigationToolbar.addMouseMotionListener(this);
										this.add(rntbuiRevisionNavigationToolbar);
									}
									{
										dslmLoactionModel = new DataSourceListModel(Effectopedia.EFFECTOPEDIA.getAvailableDataSources(), false);
										jcbLoaction = new JComboBox<DataSourceItem>();
										this.add(jcbLoaction);
										jcbLoaction.setModel(dslmLoactionModel);
									}
									{
										dsirItemRenderer = new DataSourceItemRenderer();
										dsirItemRenderer.setPreferredSize(new Dimension(260, 24));
										jcbLoaction.setRenderer(dsirItemRenderer);
										jcbLoaction.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
										jcbLoaction.setFocusable(false);
										jcbLoaction.addActionListener(new ActionListener()
											{
												public void actionPerformed(ActionEvent evt)
													{
														jcbLoactionActionPerformed(evt);
													}
											});
										LocationEditor leEditor = new LocationEditor();
										jcbLoaction.setEditor(leEditor);
										leEditor.setName("location");
										leEditor.addMouseMotionListener(this);
										jcbLoaction.setEditable(true);
									}
									{
										ctuiCommandToolbar = new CommandToolbarUI(CommandToolbarUI.ALL);
										ctuiCommandToolbar.setMaximumSize(CommandToolbarUI.optmalSize);
										ctuiCommandToolbar.setMinimumSize(CommandToolbarUI.optmalSize);
										// ctuiCommandToolbar.setBackground(java.awt.Color.white);
										ctuiCommandToolbar.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
										this.add(ctuiCommandToolbar);
									 ctuiCommandToolbar.addMouseMotionListener(this);
									}
									{
										gradient = new GradientPanel();
										gradient.setName("toolbars");
										this.setPreferredSize(new Dimension(260, 28));
										this.add(gradient);
										gradient.addMouseMotionListener(this);
									}
								
							}
					}
				catch (Exception e)
					{
						e.printStackTrace();
					}
			}
		
		public class GradientPanel extends JPanel
			{
				
				/**
			 * 
			 */
				private static final long	serialVersionUID	= 1L;
				
				@Override
				protected void paintComponent(Graphics g)
					{
						super.paintComponent(g);
						int heigth = getHeight();
						int width = getWidth();
						GradientPaint gradientPaint = new GradientPaint(0, 0, DefaultGUISettings.formColor, width, heigth, Color.WHITE);
						if (g instanceof Graphics2D)
							{
								Graphics2D graphics2D = (Graphics2D) g;
								graphics2D.setPaint(gradientPaint);
								graphics2D.fillRect(0, 0, width, heigth);
							}
					}
				
			}
		
		class CurrentLocationEditor extends JPanel implements ComboBoxEditor
			{
				public CurrentLocationEditor()
					{
						BorderLayout thisLayout = new BorderLayout();
						this.setLayout(thisLayout);
						caption = new JLabel();
						this.add(caption, BorderLayout.CENTER);
					}
				
				@Override
				public Component getEditorComponent()
					{
						return this;
					}
				
				@Override
				public void setItem(Object anObject)
					{
						if (anObject instanceof DataSourceItem)
							{
								dataSourceItem = (DataSourceItem) anObject;
								if (dataSourceItem instanceof MemoryDS)
									caption.setIcon(UIResources.imageLocalMemory);
								else if (dataSourceItem instanceof FileDS)
									caption.setIcon(((FileDS) dataSourceItem).isRemoteFile() ? UIResources.imageDBServer : UIResources.imageLocalFile);
								String location = dataSourceItem.toString();
								if (location != null)
									{
										int cnt = location.length();
										caption.setText(cnt <= MAX_LOCATION_VISIBLE_CHARACTER_COUNT ? location : "..." + location.substring(cnt - MAX_LOCATION_VISIBLE_CHARACTER_COUNT));
									}
								else
									caption.setText("");
								
							}
					}
				
				@Override
				public Object getItem()
					{
						return dataSourceItem;
					}
				
				@Override
				public void selectAll()
					{
					}
				
				@Override
				public void addActionListener(ActionListener l)
					{
						
					}
				
				@Override
				public void removeActionListener(ActionListener l)
					{
						
					}
				
				/**
			 * 
			 */
				private static final long	serialVersionUID	= 1L;
				private JLabel												caption;
				private DataSourceItem				dataSourceItem;
			}
		
		class DataSourceItemRenderer extends JLabel implements ListCellRenderer<DataSourceItem>
			{
				
				/**
			 * 
			 */
				private static final long	serialVersionUID	= 1L;
				
				public DataSourceItemRenderer()
					{
						setOpaque(true);
						setVerticalAlignment(CENTER);
					}
				
				@Override
				public Component getListCellRendererComponent(JList<? extends DataSourceItem> list, DataSourceItem source, int index, boolean isSelected, boolean cellHasFocus)
					{
						if (source == null)
							return this;
						if (isSelected)
							{
								setBackground(list.getSelectionBackground());
								setForeground(list.getSelectionForeground());
							}
						else
							{
								setBackground(list.getBackground());
								setForeground(list.getForeground());
							}
						ImageIcon icon = null;
						if ((source instanceof MemoryDS) || (source instanceof HistoricalDS))
							icon = UIResources.imageLocalMemory;
						else if (source instanceof FileDS)
							icon = ((FileDS) source).isRemoteFile() ? UIResources.imageDBServer : UIResources.imageLocalFile;
						if (icon != null)
							setIcon(icon);
						String display = source.toString();
						if (display != null)
							{
								int cnt = display.length();
								setText(cnt <= MAX_LOCATION_VISIBLE_CHARACTER_COUNT ? display : "..." + display.substring(cnt - MAX_LOCATION_VISIBLE_CHARACTER_COUNT));
							}
						else
							setText("");
						setFont(list.getFont());
						
						list.setToolTipText(source.toString());
						return this;
					}
			}
		
		@Override
		public void dataSourceChanged(DataSourceChange evt)
			{
				dslmLoactionModel.setSources(Effectopedia.EFFECTOPEDIA.getAvailableDataSources());
				DataSource data;
				if (evt == null)
					data = Effectopedia.EFFECTOPEDIA.getAvailableDataSources().getLast();
				else
					data = Effectopedia.EFFECTOPEDIA.getData();
				if (data != null)
					{
						dslmLoactionModel.setSelectedItem(data);
						// if ((data instanceof XMLFileDS) && (((XMLFileDS) data).isRemoteFile()))
						// jbLoading.setVisible(((XMLFileDS) data).isInternalLoad());
						jcbLoaction.invalidate();
					}
			}
		
		@Override
		public void locationChanged(EventObject evt)
			{
				RevisionBasedDS data = (RevisionBasedDS) evt.getSource();
				dslmLoactionModel.setSelectedItem(data);
				jcbLoaction.invalidate();
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
		
		private void jcbLoactionActionPerformed(ActionEvent evt)
			{
				Effectopedia.EFFECTOPEDIA.setData(dslmLoactionModel.getSelectedItem());
			}
		
	}
