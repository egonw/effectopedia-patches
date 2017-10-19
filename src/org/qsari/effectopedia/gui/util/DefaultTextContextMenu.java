package org.qsari.effectopedia.gui.util;

import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;

import javax.swing.Action;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPopupMenu;
import javax.swing.KeyStroke;
import javax.swing.LookAndFeel;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.text.DefaultEditorKit;
import javax.swing.text.JTextComponent;
import javax.swing.text.TextAction;

public class DefaultTextContextMenu extends JPopupMenu
	{
		/**
	 * 
	 */
		private static final long						serialVersionUID	= 1L;
		public static DefaultTextContextMenu	POPUP												= new DefaultTextContextMenu();
		
		private DefaultTextContextMenu()
			{
				super();
				Action cut = new DefaultEditorKit.CutAction();
				cut.putValue(Action.NAME, "Cut");
				cut.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke("control X"));
				this.add(cut);
				
				Action copy = new DefaultEditorKit.CopyAction();
				copy.putValue(Action.NAME, "Copy");
				copy.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke("control C"));
				this.add(copy);
				
				Action paste = new DefaultEditorKit.PasteAction();
				paste.putValue(Action.NAME, "Paste");
				paste.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke("control V"));
				this.add(paste);
				
				Action selectAll = new SelectAll();
				this.add(selectAll);
			}
		
		static class SelectAll extends TextAction
			{
				public SelectAll()
					{
						super("Select All");
						putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke("control A"));
					}
				
				public void actionPerformed(ActionEvent e)
					{
						JTextComponent component = getFocusedComponent();
						component.selectAll();
						component.requestFocusInWindow();
					}
			}
		
		public static void installDefaultPopupMenu(Container inContainer)
			{
				if (inContainer != null)
					{
						//System.out.println(inContainer.getClass().getCanonicalName());
						if (inContainer instanceof JFrame)
							inContainer = ((JFrame) inContainer).getContentPane();
						else if (inContainer instanceof JDialog)
							inContainer = ((JDialog) inContainer).getContentPane();
						Component[] components = inContainer.getComponents();
						for (int i = 0; i < components.length; ++i)
							{
								components[i].getClass();
								if (components[i] instanceof Container)
									installDefaultPopupMenu((Container) components[i]);
								else if (components[i] instanceof JTextComponent)
									((JTextComponent) components[i]).setComponentPopupMenu(POPUP);
								else if (components[i] instanceof JComboBox)
									{
										Component lEditorComp = ((JComboBox<?>) components[i]).getEditor().getEditorComponent();
										if (lEditorComp instanceof JTextComponent)
											((JTextComponent) lEditorComp).setComponentPopupMenu(POPUP);
									}
							}
					}
			}
		
		public static void updateUIManager()
			{
				
				UIManager.addAuxiliaryLookAndFeel(new LookAndFeel()
					{
						private final UIDefaults	defaults	= new UIDefaults()
																																									{
																																										@Override
																																										public javax.swing.plaf.ComponentUI getUI(JComponent c)
																																											{
																																												if (c instanceof javax.swing.text.JTextComponent)
																																													{
																																														if (c.getClientProperty(this) == null)
																																															{
																																																c.setComponentPopupMenu(POPUP);
																																																c.putClientProperty(this, Boolean.TRUE);
																																															}
																																													}
																																												return null;
																																											}
																																									};
						
						@Override
						public UIDefaults getDefaults()
							{
								return defaults;
							};
						
						@Override
						public String getID()
							{
								return "DefaultTextContextMenu";
							}
						
						@Override
						public String getName()
							{
								return getID();
							}
						
						@Override
						public String getDescription()
							{
								return getID();
							}
						
						@Override
						public boolean isNativeLookAndFeel()
							{
								return false;
							}
						
						@Override
						public boolean isSupportedLookAndFeel()
							{
								return true;
							}
					});
			}
	}