package org.qsari.effectopedia.gui.toolbars;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseMotionListener;
import java.io.File;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.KeyStroke;
import javax.swing.WindowConstants;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.qsari.effectopedia.core.Effectopedia;
import org.qsari.effectopedia.core.Effectopedia.DataSourceChange;
import org.qsari.effectopedia.core.Effectopedia.DataSourceChangeListener;
import org.qsari.effectopedia.data.DataSource;
import org.qsari.effectopedia.data.RevisionBasedDS;
import org.qsari.effectopedia.defaults.DefaultGOSettings;
import org.qsari.effectopedia.gui.AdjustableUI;
import org.qsari.effectopedia.gui.UIResources;
import org.qsari.effectopedia.gui.core.GUIFactory;

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
public class CommandToolbarUI extends javax.swing.JToolBar implements AdjustableUI, DataSourceChangeListener
	{
		/**
	 * 
	 */
		private static final long	serialVersionUID	= 1L;
		
		public static final int			FILE_OPEN								= 0x0001;
		public static final int			FILE_SAVE								= 0x0002;
		public static final int			PUBLISH										= 0x0004;
		
		public static final int			ALL														= 0xFFFF;
		
		public static void main(String[] args)
			{
				JFrame frame = new JFrame();
				frame.getContentPane().add(new CommandToolbarUI(CommandToolbarUI.ALL));
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				frame.pack();
				frame.setVisible(true);
			}
		
		public CommandToolbarUI()
			{
				super();
				initGUI();
				setName("cmd_toolbar");
			}
		
		private void initGUI()
			{
				try
					{
						this.setPreferredSize(optmalSize);
						this.setMinimumSize(optmalSize);
						this.setMaximumSize(optmalSize);
					}
				catch (Exception e)
					{
						e.printStackTrace();
					}
			}
		
		public CommandToolbarUI(int buttons)
			{
				super();
				this.setMinimumSize(new java.awt.Dimension(72, 36));
				imap = getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
				CommandKeys keyListener = new CommandKeys();
				createButton(createAction("open XML file", UIResources.imageFileOpen, "Open XML File", "C", FILE_OPEN), FILE_OPEN, buttons, "open");
				createButton(createAction("save XML file", UIResources.imageFileSave, "Save XML File", "L", FILE_SAVE), FILE_SAVE, buttons, "save");
				createButton(createAction("publish changes", UIResources.imagePublish, "Publish", "P", PUBLISH), PUBLISH, buttons, "publish");
				addKeyListener(keyListener);
				setName("cmd_toolbar");
			}
		
		public void dataSourceChanged(DataSourceChange evt)
			{
				
			}
		
		@Override
		public void addMouseMotionListener(MouseMotionListener listener)
			{
				super.addMouseMotionListener(listener);
				for (Component c : getComponents())
					if (c instanceof JButton)
						c.addMouseMotionListener(listener);
			}
		
		public class CommandAction extends AbstractAction
			{
				/**
		 * 
		 */
				private static final long	serialVersionUID	= 1L;
				
				public CommandAction(String actionName, Icon icon, int actionCode, String description)
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
								case FILE_OPEN:
									{
										if (useFileDialog)
											{
												FileDialog f = new FileDialog(GUIFactory.GUI.getFrame(), "Open Effectopedia Adverse Outcome Pathway AOPZ (zipped) files", FileDialog.LOAD);
												f.setVisible(true);
												Effectopedia.EFFECTOPEDIA.loadFromLocalXMLFile(f.getDirectory() + f.getFile());
												f.dispose();
											}
										else
											{
												JFileChooser chooser = new JFileChooser();
												chooser.setCurrentDirectory(new File("."));
												chooser.setFileFilter(new FileNameExtensionFilter("Effectopedia Adverse Outcom Pathway AOP, AOPZ (zipped) and XML files", "xml", "aop", "aopz"));
												chooser.addChoosableFileFilter(new FileNameExtensionFilter("AOP-XML export (AOPX)", "aopx"));
												int returnVal = chooser.showOpenDialog(GUIFactory.GUI.getFrame());
												if (returnVal == JFileChooser.APPROVE_OPTION)
													Effectopedia.EFFECTOPEDIA.loadFromLocalXMLFile(chooser.getSelectedFile().getAbsolutePath());
											}
										DataSource data = Effectopedia.EFFECTOPEDIA.getData();
										if (data instanceof RevisionBasedDS)
											((RevisionBasedDS) data).addLocaionChangeListener(GUIFactory.GUI.getAbuiAddressBar());
										break;
									}
								case FILE_SAVE:
									{
										if (useFileDialog)
											{
												FileDialog f = new FileDialog(GUIFactory.GUI.getFrame(), "Save Effectopedia Adverse Outcome Pathway in file(s)", FileDialog.SAVE);
												f.setVisible(true);
												Effectopedia.EFFECTOPEDIA.saveAsXMLFile(f.getDirectory() + f.getFile(), true);
												f.dispose();
											}
										else
											{
												JFileChooser chooser = new JFileChooser();
												chooser.setCurrentDirectory(new File("."));
												chooser.addChoosableFileFilter(xmlFilter);
												chooser.addChoosableFileFilter(aopFilter);
												chooser.addChoosableFileFilter(aopzFilter);
												chooser.addChoosableFileFilter(aopxFilter);
												chooser.addChoosableFileFilter(htmlFilter);
												chooser.addChoosableFileFilter(svgFilter);
												chooser.addChoosableFileFilter(pngFilter);
												if (keyCtrlPressed)
													chooser.addChoosableFileFilter(javaFilter);
												int returnVal = chooser.showSaveDialog(GUIFactory.GUI.getFrame());
												File selectedFile = chooser.getSelectedFile();
												if ((returnVal == JFileChooser.APPROVE_OPTION) && (selectedFile != null))
													{
														String fileName = selectedFile.getAbsolutePath();
														int hasExtension = fileName.lastIndexOf(".");
														FileFilter selectedFilter = (FileFilter) chooser.getFileFilter();
														if ((hasExtension == -1) || (fileName.lastIndexOf("\\") > hasExtension) || (fileName.lastIndexOf("/") > hasExtension))
															if (pngFilter == selectedFilter)
																fileName = fileName + ".png";
															else if (svgFilter == selectedFilter)
																fileName = fileName + ".svg";
															else if (selectedFilter == xmlFilter)
																fileName = fileName + ".xml";
															else if (selectedFilter == aopxFilter)
																fileName = fileName + ".aopx";
															else if (selectedFilter == htmlFilter)
																fileName = fileName + ".html";
															else if (selectedFilter == aopFilter)
																fileName = fileName + ".aop";
															else if (selectedFilter == javaFilter)
																fileName = fileName + ".java";
															else
																fileName = fileName + ".aopz";
														if ((chooser.getFileFilter() == pngFilter) || (((hasExtension != -1)) && (fileName.substring(hasExtension).equalsIgnoreCase(".png"))))
															GUIFactory.GUI.getPathwaySpaceUI().exportAsPNGImageFile(fileName);
														else if ((chooser.getFileFilter() == svgFilter) || (((hasExtension != -1)) && (fileName.substring(hasExtension).equalsIgnoreCase(".svg"))))
															GUIFactory.GUI.getPathwaySpaceUI().exportAsSVGImageFile(fileName);
														else
															Effectopedia.EFFECTOPEDIA.saveAsXMLFile(fileName, true);
													}
											}
										break;
									}
								case PUBLISH:
									{
										Effectopedia.EFFECTOPEDIA.publish();
										break;
									}
							}
					}
			}
		
		public class CommandKeys implements java.awt.event.KeyListener
			{
				public void keyPressed(KeyEvent e)
					{
						int keyModifiers = e.getModifiers();
						keyCtrlPressed = (keyModifiers & KeyEvent.CTRL_MASK) != 0;
					}
				
				public void keyReleased(KeyEvent e)
					{
						int keyModifiers = e.getModifiers();
						keyCtrlPressed = (keyModifiers & KeyEvent.CTRL_MASK) != 0;
					}
				
				public void keyTyped(KeyEvent e)
					{
						
					}
			}
		
		private CommandAction createAction(String actionName, ImageIcon icon, String hint, String key, int actionCode)
			{
				CommandAction action = new CommandAction(actionName, icon, actionCode, hint);
				imap.put(KeyStroke.getKeyStroke(key), actionName);
				getActionMap().put(actionName, action);
				return action;
			}
		
		private JButton createButton(CommandAction action, int buttonType, int buttons, String name)
			{
				if ((buttons & buttonType) != 0)
					{
						JButton button = new JButton(action);
						add(button);
						button.setHideActionText(DefaultGOSettings.hideActionText);
						button.setFocusPainted(false);
						button.setPreferredSize(optmalButtonSize);
						button.setName(name);
						// button.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
						// button.setBackground(Color.white);
						return button;
					}
				return null;
			}
		
		public void updatePrefferedSize()
			{
				Dimension d = new Dimension(0, 0);
				d.setSize(108, 28);
				if (getOrientation() == HORIZONTAL)
					for (Component c : getComponents())
						{
							Dimension componentDimension = c.getPreferredSize();
							d.width += componentDimension.width;
							if (d.height < componentDimension.height)
								d.height = componentDimension.height;
						}
				else
					for (Component c : getComponents())
						{
							Dimension componentDimension = c.getPreferredSize();
							d.height += componentDimension.height;
							if (d.width < componentDimension.width)
								d.width = componentDimension.width;
						}
				setPreferredSize(d);
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
				this.setVisible((visualOptions & LIST_TOOLBARS) != 0);
			}
		
		public boolean																														useFileDialog				= false;
		private InputMap																												imap;
		public static final Dimension															optmalSize							= new java.awt.Dimension(108, 28);
		public static final Dimension															optmalButtonSize	= new java.awt.Dimension(36, 28);
		public static final FileNameExtensionFilter	svgFilter								= new FileNameExtensionFilter("Export to Scalable Vector Graphics (SVG) Image file", "svg");
		public static final FileNameExtensionFilter	pngFilter								= new FileNameExtensionFilter("Export to Portable Network Graphics (PNG) Image file", "png");
		public static final FileNameExtensionFilter aopxFilter							= new FileNameExtensionFilter("Export to AOP-XML", "aopx");
		public static final FileNameExtensionFilter	htmlFilter							= new FileNameExtensionFilter("Export to HTML", "html");
		public static final FileNameExtensionFilter	xmlFilter								= new FileNameExtensionFilter("Effectopedia Adverse Outcome Pathway multiple xml files", "xml");
		public static final FileNameExtensionFilter	aopFilter								= new FileNameExtensionFilter("Effectopedia Adverse Outcome Pathway AOP files", "aop");
		public static final FileNameExtensionFilter	aopzFilter							= new FileNameExtensionFilter("Effectopedia Adverse Outcome Pathway AOPZ (zipped) files", "aopz");
		public static final FileNameExtensionFilter	javaFilter							= new FileNameExtensionFilter("Effectopedia AOP generation code", "java");

		
		private boolean																													keyCtrlPressed;
		
	}
