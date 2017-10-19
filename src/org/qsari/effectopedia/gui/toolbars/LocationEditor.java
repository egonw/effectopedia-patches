package org.qsari.effectopedia.gui.toolbars;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ComboBoxEditor;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import org.qsari.effectopedia.core.Effectopedia;
import org.qsari.effectopedia.data.DataSource;
import org.qsari.effectopedia.data.FileDS;
import org.qsari.effectopedia.data.HistoricalDS;
import org.qsari.effectopedia.data.MemoryDS;
import org.qsari.effectopedia.data.RevisionBasedDS;
//import org.qsari.effectopedia.data.xml.XMLFileDS;
import org.qsari.effectopedia.defaults.DefaultGOSettings;
import org.qsari.effectopedia.defaults.DefaultGUISettings;
import org.qsari.effectopedia.defaults.DefaultServerSettings;
import org.qsari.effectopedia.gui.UIResources;

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
public class LocationEditor extends javax.swing.JPanel implements ComboBoxEditor, MouseListener
	{
		
		public static final int			LOCATION_COPY																								= 0x0001;
		public static final int			LOCATION_PASTE																							= 0x0002;
		private JToolBar										jtCopyPaste;
		public int																MAX_LOCATION_VISIBLE_CHARACTER_COUNT	= 100;
		
		private static final long	serialVersionUID																					= 1L;
		private JLabel												jlLocation;
		private JTextField								jtfRevision;
		private JButton											jbPaste;
		private JButton											jbCopy;
		private JTextField								jtfID;
		private JLabel												jlID;
		
		/**
		 * Auto-generated main method to display this JPanel inside a new JFrame.
		 */
		public static void main(String[] args)
			{
				JFrame frame = new JFrame();
				frame.getContentPane().add(new LocationEditor());
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				frame.pack();
				frame.setVisible(true);
			}
		
		public LocationEditor()
			{
				super();
				imap = getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
				initGUI();
			}
		
		private void initGUI()
			{
				try
					{
						BoxLayout thisLayout = new BoxLayout(this, javax.swing.BoxLayout.X_AXIS);
						this.setLayout(thisLayout);
						this.setBackground(DefaultGUISettings.formColor);
						this.addMouseListener(this);
						ComponentFocusListener componentFocusListener = new ComponentFocusListener();
							
							{
								jlLocation = new JLabel(UIResources.imageDBServer);
								jlLocation.setText("Initializing...");
								jlLocation.setMaximumSize(new Dimension(400, 24));
								this.add(jlLocation);
								jlLocation.setLabelFor(jtfRevision);
							}
							{
								jtfRevision = new JTextField();
								jtfRevision.setText("");
								jtfRevision.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
								jtfRevision.setBackground(DefaultGUISettings.formColor);
								jtfRevision.setMaximumSize(DEFAULT_BUTTON_SIZE);
								jtfRevision.setPreferredSize(DEFAULT_TEXTFIELD_SIZE);
								// jtfRevision.setForeground(DefaultGOSettings.effectColor);
								jtfRevision.addMouseListener(componentFocusListener);
								jtfRevision.getDocument().addDocumentListener(new RevisionListener());
								this.add(jtfRevision);
								jtfRevision.setName("revision");
							}
							{
								jlID = new JLabel();
								jlID.setText("");
								this.add(jlID);
								jlID.setName("id");
							}
							{
								jtfID = new JTextField();
								jlID.setLabelFor(jtfID);
								jtfID.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
								jtfID.setBackground(DefaultGUISettings.formColor);
								jtfID.setMaximumSize(DEFAULT_BUTTON_SIZE);
								jtfID.setPreferredSize(DEFAULT_TEXTFIELD_SIZE);
								jtfID.addMouseListener(componentFocusListener);
								jtfID.getDocument().addDocumentListener(new LocationListener());
								jtfID.setName("id");
								// jtfID.setForeground(DefaultGOSettings.effectColor);
								jtfID.setText("");
								this.add(jtfID);
							}
						this.add(Box.createRigidArea(new Dimension(6, 0)));
							{
								jtCopyPaste = new JToolBar();
								jtCopyPaste.setOpaque(false);
								jtCopyPaste.addMouseListener(componentFocusListener);
								jtCopyPaste.setVisible(false);
								this.add(jtCopyPaste);
								jtCopyPaste.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
									{
										jbCopy = new JButton(createLocationAction("copy location", UIResources.imageIconMCopy, "copy location", "C", LOCATION_COPY));
										jtCopyPaste.add(jbCopy);
										jbCopy.setHideActionText(DefaultGOSettings.hideActionText);
										// jbCopy.setPreferredSize(DEFAULT_BUTTON_SIZE);
										jbCopy.setBorderPainted(false);
										jbCopy.setVisible(false);
										jbCopy.addMouseListener(componentFocusListener);
										jbCopy.setName("copy");
									}
									{
										jbPaste = new JButton(createLocationAction("paste location", UIResources.imageIconMPaste, "paste location", "C", LOCATION_PASTE));
										jtCopyPaste.add(jbPaste);
										jbPaste.setHideActionText(DefaultGOSettings.hideActionText);
										// jbPaste.setPreferredSize(DEFAULT_BUTTON_SIZE);
										jbPaste.setBorderPainted(false);
										jbPaste.setVisible(false);
										jbPaste.addMouseListener(componentFocusListener);
										jbPaste.setName("paste");
									}
							}
						this.add(Box.createGlue());
					}
				catch (Exception e)
					{
						e.printStackTrace();
					}
			}

		@Override
		public void addMouseMotionListener(MouseMotionListener listener)
			{
				super.addMouseMotionListener(listener);
				for (Component c : getComponents())
					c.addMouseMotionListener(listener);
				jbCopy.addMouseMotionListener(listener);
				jbPaste.addMouseMotionListener(listener);
			}

		@Override
		public void addActionListener(ActionListener listener)
			{
				eventListeners.add(listener);
			}
		
		@Override
		public Component getEditorComponent()
			{
				return this;
			}
		
		@Override
		public Object getItem()
			{
				return dataSource;
			}
		
		@Override
		public void removeActionListener(ActionListener listener)
			{
				eventListeners.remove(listener);
			}
		
		@Override
		public void selectAll()
			{
			}
		
		@Override
		public void setItem(Object dataSource)
			{
				//System.out.println(dataSource);
				if (!(dataSource instanceof DataSource))
					return;
				this.dataSource = (DataSource) dataSource;
				boolean revisionBased = this.dataSource instanceof RevisionBasedDS;
				String location = ""; 
				if (dataSource instanceof FileDS)
					{
						internalUpdate = true;
						String customTitle = ((FileDS) dataSource).getCustomTitle();
						if (((FileDS) dataSource).isRemoteFile())
							jlLocation.setIcon(UIResources.imageDBServer);
						else
							jlLocation.setIcon(UIResources.imageLocalFile);
						if (customTitle != null)
							{
								location = extractSourceName(customTitle);
								revisionBased = false;
							}
						else
							location = extractSourceName(((RevisionBasedDS) dataSource).getSourceName()) + "?revision=";
					}
				else
					{
						if (dataSource instanceof RevisionBasedDS)
							location = extractSourceName(dataSource.toString()) + "?revision=";
						else
							location = dataSource.toString();
						jlLocation.setIcon((dataSource instanceof MemoryDS) || (dataSource instanceof HistoricalDS) ? UIResources.imageLocalMemory : null);
					}
				if (location != null)
					{
						int cnt = location.length();
						jlLocation.setText(cnt <= MAX_LOCATION_VISIBLE_CHARACTER_COUNT ? location : "..." + location.substring(cnt - MAX_LOCATION_VISIBLE_CHARACTER_COUNT));
					}
				else
					jlLocation.setText("");

				jtfRevision.setVisible(revisionBased);
				if (revisionBased)
					{
						String revision = (String.valueOf(((RevisionBasedDS) dataSource).getRevision()));
						tfRevSize.setSize(revision.length() * 7, 24);
						jtfRevision.setPreferredSize(tfRevSize);
						jtfRevision.setText(revision);
					}
				boolean hasLocation = revisionBased ? ((RevisionBasedDS) this.dataSource).getLocation() != 0 : false;
				jlID.setVisible(hasLocation);
				jtfID.setVisible(hasLocation);
				if (hasLocation)
					{
						String locationID = String.valueOf(((RevisionBasedDS) dataSource).getLocation());
						if (((RevisionBasedDS) dataSource).isInternalLocation())
							jlID.setText("&ID=");
						else
							jlID.setText("&extID=");
						tfIDSize.setSize(locationID.length() * 7, 24);
						jtfID.setPreferredSize(tfIDSize);
						jtfID.setText(locationID);
					}
				jbCopy.setVisible(revisionBased);
				jbPaste.setVisible(revisionBased);
				internalUpdate = false;
			}
		
		private String extractSourceName(String location)
			{
				int parPos = location.indexOf("?");
				if (parPos == -1)
					return location;
				else
					return location.substring(0, parPos);
			}
		
		public class LocationAction extends AbstractAction
			{
				/**
	 * 
	 */
				private static final long	serialVersionUID	= 1L;
				
				public LocationAction(String actionName, Icon icon, int actionCode, String description)
					{
						putValue(Action.NAME, actionName);
						putValue(Action.SMALL_ICON, icon);
						putValue("actionCode", actionCode);
						putValue(Action.SHORT_DESCRIPTION, description);
					}
				
				public void actionPerformed(ActionEvent event)
					{
						int actionCode = (Integer) getValue("actionCode");
						switch (actionCode)
							{
								case LOCATION_COPY:
									{
										if (dataSource != null)
											setClipboard(dataSource.toString());
										break;
									}
								case LOCATION_PASTE:
									{
										if (dataSource != null)
											parseLocation(getClipboard());
										break;
									}
							}
					}
			}
		
		public static void setClipboard(String text)
			{
				StringSelection stringSelection = new StringSelection(text);
				Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
			}
		
		public static String getClipboard()
			{
				Transferable t = Toolkit.getDefaultToolkit().getSystemClipboard().getContents(null);
				try
					{
						if (t != null && t.isDataFlavorSupported(DataFlavor.stringFlavor))
							{
								String text = (String) t.getTransferData(DataFlavor.stringFlavor);
								return text;
							}
					}
				catch (UnsupportedFlavorException e)
					{
					}
				catch (IOException e)
					{
					}
				return null;
			}
		
		private String clean(String location)
			{
				int EDB = location.indexOf(DefaultServerSettings.defaultSourceName);
				if (EDB != -1)
					location = location.substring(EDB);
				if (location.trim().startsWith(LOCAL_FILE))
					location = location.substring(LOCAL_FILE.length());
				return location.trim();
			}
		
		private void parseLocation(String location)
			{
				location = clean(location);
				int locationSep = location.indexOf("?");
				int parameterSep = location.indexOf("&", locationSep);
				if (locationSep == -1)
					dataSource = loadLocation(location);
				else
					{
						int revSep = location.indexOf("=", locationSep);
						if (revSep != -1)
							{
								String rev = location.substring(revSep + 1, (parameterSep == -1 ? location.length() : parameterSep));
								long revision = Long.parseLong(rev);
								String sourceName = location.substring(0, locationSep);
								dataSource = Effectopedia.EFFECTOPEDIA.getDataSourceByName(sourceName, true);
								if (dataSource == null)
									dataSource = loadLocation(sourceName);
								if (dataSource instanceof RevisionBasedDS)
									{
										int idSep = location.indexOf("=", parameterSep);
										RevisionBasedDS rbDS = Effectopedia.EFFECTOPEDIA.loadRevision(revision);
										boolean internalLocation;
										if ((parameterSep != -1) && (idSep != -1) && (rbDS != null))
											{
												internalLocation = "ID".equalsIgnoreCase(location.substring(parameterSep + 1, idSep - 1));
												long id = Long.parseLong(location.substring(idSep + 1));
												rbDS.setLocation(id, internalLocation);
												Effectopedia.EFFECTOPEDIA.loadCurrentLocation();
											}
									}
							}
					}
			}
		
		private DataSource loadLocation(String location)
			{
				if (location.equalsIgnoreCase(DEFAULT_EFFECTOPEDIA_SERVER))
					Effectopedia.EFFECTOPEDIA.reloadCentralizedDB();
				File f = new File(location);
				if (f.exists() && !f.isDirectory())
					Effectopedia.EFFECTOPEDIA.loadFromLocalXMLFile(location);
				return Effectopedia.EFFECTOPEDIA.getData();
			}
		
		private LocationAction createLocationAction(String actionName, ImageIcon icon, String hint, String key, int actionCode)
			{
				LocationAction action = new LocationAction(actionName, icon, actionCode, hint);
				imap.put(KeyStroke.getKeyStroke(key), actionName);
				getActionMap().put(actionName, action);
				return action;
			}
		
		private void activateEditing()
			{
				jtCopyPaste.setVisible(true);
				jtfRevision.setForeground(Color.blue);
				jtfID.setForeground(Color.blue);
				jtfRevision.invalidate();
				SwingUtilities.invokeLater(painter);
			}
		
		private void deactivateEditing()
			{
				jtCopyPaste.setVisible(false);
				jtfRevision.setForeground(Color.black);
				jtfRevision.invalidate();
				jtfID.setForeground(Color.black);
				SwingUtilities.invokeLater(painter);
			}
		
		class RepaintTextFields implements Runnable
			{
				public void run()
					{
						jtfRevision.repaint();
						jtfID.repaint();
					}
			}
		
		class UpdateRevision implements Runnable
			{
				public UpdateRevision(long revision)
					{
						this.revision = revision;
					}
				
				public void run()
					{
						Effectopedia.EFFECTOPEDIA.setData(dataSource);
						dataSource = Effectopedia.EFFECTOPEDIA.loadRevision(revision);
					}
				
				private long	revision;
			}
		
		class UpdateLocation implements Runnable
			{
				public UpdateLocation(long location)
					{
						this.location = location;
					}
				
				public void run()
					{
						//System.out.println("Updating location");
						((RevisionBasedDS) dataSource).setLocation(location, false);
						Effectopedia.EFFECTOPEDIA.loadCurrentLocation();
					}
				
				private long	location;
			}
		
		class ComponentFocusListener extends MouseAdapter
			{
				
				public void mouseExited(MouseEvent evt)
					{
						int vPos = evt.getY();
						if (vPos > 0 && vPos < getHeight())
							activateEditing();
						else
							deactivateEditing();
					}
				
				public void mouseEntered(MouseEvent evt)
					{
						activateEditing();
					}
			}
		
		@SuppressWarnings("unchecked")
		@Override
		public void mouseClicked(MouseEvent e)
			{
				Component parent = getParent();
				if (parent instanceof JComboBox)
					((JComboBox<DataSource>) parent).showPopup();
			}
		
		@Override
		public void mouseEntered(MouseEvent e)
			{
				activateEditing();
			}
		
		@Override
		public void mouseExited(MouseEvent e)
			{
				deactivateEditing();
			}
		
		@Override
		public void mousePressed(MouseEvent e)
			{
			}
		
		@Override
		public void mouseReleased(MouseEvent e)
			{
			}
		
		class RevisionListener implements DocumentListener
			{
				public void changedUpdate(DocumentEvent e)
					{
						updateRevision();
					}
				
				public void removeUpdate(DocumentEvent e)
					{
						updateRevision();
					}
				
				public void insertUpdate(DocumentEvent e)
					{
						updateRevision();
					}
				
				public void updateRevision()
					{
						if (internalUpdate)
							return;
						String rev = jtfRevision.getText();
						executor.getQueue().clear();
						if ((rev == null) || (rev.length() == 0))
							return;
						long revision = Long.parseLong(rev);
						//System.out.println("Revision=" + rev + " DataSource Revision=" + ((RevisionBasedDS) dataSource).getRevision());
						if ((revision <= ((RevisionBasedDS) dataSource).getMaxRevision()) && (revision != ((RevisionBasedDS) dataSource).getRevision()))
							{
								UpdateRevision revisionUpdater = new UpdateRevision(revision);
								executor.schedule(revisionUpdater, 280, TimeUnit.MILLISECONDS);
							}
					}
			}
		
		class LocationListener implements DocumentListener
			{
				public void changedUpdate(DocumentEvent e)
					{
						updateLocation();
					}
				
				public void removeUpdate(DocumentEvent e)
					{
						updateLocation();
					}
				
				public void insertUpdate(DocumentEvent e)
					{
						updateLocation();
					}
				
				public void updateLocation()
					{
						if (internalUpdate)
							return;
						String location = jtfID.getText();
						executor.getQueue().clear();
						if ((location == null) || (location.length() == 0))
							return;
						long loc = Long.parseLong(location);
						//System.out.println("Location=" + location + " DataSource Location=" + ((RevisionBasedDS) dataSource).getLocation());
						if ((loc <= ((RevisionBasedDS) dataSource).getMaxExternalID()) && (loc != ((RevisionBasedDS) dataSource).getLocation()))
							{
								UpdateLocation locationUpdater = new UpdateLocation(loc);
								executor.schedule(locationUpdater, 280, TimeUnit.MILLISECONDS);
							}
					}
			}
		
		private boolean																											internalUpdate														= true;
		private final ScheduledThreadPoolExecutor	executor																				= new ScheduledThreadPoolExecutor(1);
		private ArrayList<ActionListener>									eventListeners														= new ArrayList<ActionListener>();
		private RepaintTextFields																	painter																					= new RepaintTextFields();
		private String																												LOCAL_FILE																		= "local file: ";
		private String																												DEFAULT_EFFECTOPEDIA_SERVER	= DefaultServerSettings.defaultSourceName;
		private DataSource																								dataSource																		= null;
		private Dimension																									DEFAULT_TEXTFIELD_SIZE						= new Dimension(48, 24);
		private Dimension																									DEFAULT_BUTTON_SIZE									= new Dimension(24, 24);
		private Dimension																									tfRevSize																			= new Dimension(0, 0);
		private Dimension																									tfIDSize																				= new Dimension(0, 0);
		private InputMap																										imap;
	}
