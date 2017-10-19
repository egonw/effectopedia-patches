package org.qsari.effectopedia.gui.util;

import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.HashMap;

import javax.swing.Action;
import javax.swing.KeyStroke;

public class GlobalKeyboardShortcut
	{
		private HashMap<KeyStroke, Action>									actionMap;
		
		public final static GlobalKeyboardShortcut	INSTANCE	= new GlobalKeyboardShortcut();
		
		private GlobalKeyboardShortcut()
			{
				actionMap = new HashMap<KeyStroke, Action>();
				KeyboardFocusManager kfm = KeyboardFocusManager.getCurrentKeyboardFocusManager();
				kfm.addKeyEventDispatcher(new KeyEventDispatcher()
					{
						@Override
						public boolean dispatchKeyEvent(KeyEvent e)
							{
								KeyStroke keyStroke = KeyStroke.getKeyStrokeForEvent(e);
								if (actionMap.containsKey(keyStroke))
									{
										final Action a = actionMap.get(keyStroke);
										a.actionPerformed(new ActionEvent(e.getSource(), e.getID(), null));
										return true;
									}
								return false;
							}
					});
			}
			
		public static GlobalKeyboardShortcut dispatcher()
			{
				return INSTANCE;
			}
			
		public Action getAction(KeyStroke keyStroke)
			{
				return actionMap.get(keyStroke);
			}
			
		public void register(int keyCode, int modifiers, Action action)
			{
				KeyStroke keyStroke = KeyStroke.getKeyStroke(keyCode, modifiers);
				actionMap.put(keyStroke, action);
			}
			
	}
