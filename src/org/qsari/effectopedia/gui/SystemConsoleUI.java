package org.qsari.effectopedia.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;

import org.qsari.effectopedia.core.Effectopedia;
import org.qsari.effectopedia.gui.help.ContextSensitivePanel;
import org.qsari.effectopedia.gui.help.RootHelpContext;
import org.qsari.effectopedia.gui.toolbars.SystemConsoleToolbarUI;
import org.qsari.effectopedia.gui.util.AWTLogger;

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
public class SystemConsoleUI extends ContextSensitivePanel implements AdjustableUI, RootHelpContext
	{
		public SystemConsoleUI()
			{
				super(null);
				setName("console");
				initGUI();
			}
		
		private void initGUI()
			{
				try
					{
							{
								BorderLayout thisLayout = new BorderLayout();
								this.setLayout(thisLayout);
								this.setPreferredSize(new java.awt.Dimension(610, 297));
									{
										jspLogs = new JSplitPane();
										this.add(jspLogs, BorderLayout.CENTER);
										jspLogs.setOrientation(JSplitPane.VERTICAL_SPLIT);
										jspLogs.setOneTouchExpandable(true);
										jspLogs.setDividerLocation(0.0);
											{
												jspConsoleOut = new JScrollPane();
												jspLogs.add(jspConsoleOut, JSplitPane.TOP);
												jspConsoleOut.setBorder(BorderFactory.createTitledBorder("Java Console"));
												jspConsoleOut.setBackground(Color.white);
													{
														jtaConsole = new JTextArea();
														jspConsoleOut.setViewportView(jtaConsole);
														jtaConsole.setEditable(false);
														EffectopediaUI.consoleStream.setTextArea(jtaConsole);
													}
											}
											{
												jspErrorOut = new JScrollPane();
												jspLogs.add(jspErrorOut, JSplitPane.BOTTOM);
												jspErrorOut.setBorder(BorderFactory.createTitledBorder("Error Log"));
												jspErrorOut.setBackground(Color.white);
													{
														jtaErrorOutput = new JTextArea();
														jspErrorOut.setViewportView(jtaErrorOutput);
														jtaErrorOutput.setForeground(new java.awt.Color(255, 0, 0));
														jtaErrorOutput.setEditable(false);
														EffectopediaUI.errorStream.setTextArea(jtaErrorOutput);
													}
											}
									}
									{
										sctbToolbar = new SystemConsoleToolbarUI(this, SystemConsoleToolbarUI.ALL, FlowLayout.RIGHT);
										this.add(sctbToolbar, BorderLayout.NORTH);
									}
							}
					}
				catch (Exception e)
					{
						e.printStackTrace();
					}
			}
		
		public String copy()
			{
				StringBuilder sb = new StringBuilder();
				sb.append("============================== System Info ==============================\n\n");
				sb.append("Effectopedia Version: ");
				sb.append(Effectopedia.VERSION);
				sb.append("\n");
				sb.append("Java Runtime Environment Version: ");
				sb.append(System.getProperty("java.version"));
				sb.append("\n");
				sb.append(System.getProperty("os.name"));
				sb.append(" Version: ");
				sb.append(System.getProperty("os.version"));
				sb.append("\n\n============================== Java Console ==============================\n\n");
				sb.append(EffectopediaUI.consoleStream.getContent());
				sb.append("\n\n============================== AWT Event Log ==============================\n\n");
				sb.append(AWTLogger.log.toString());
				sb.append("\n\n============================== Java Error Log ==============================\n\n");
				sb.append(EffectopediaUI.errorStream.getContent());
				return sb.toString();
			}
		
		public void reset()
			{
				EffectopediaUI.consoleStream.reset();
				EffectopediaUI.errorStream.reset();
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
		
		/**
		 * 
		 */
		private static final long	serialVersionUID	= 1L;
		private JSplitPane								jspLogs;
		private JScrollPane							jspConsoleOut;
		private JScrollPane							jspErrorOut;
		private JTextArea									jtaErrorOutput;
		private JPanel												sctbToolbar;
		private JTextArea									jtaConsole;
	}
