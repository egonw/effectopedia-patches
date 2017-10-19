package org.qsari.effectopedia.gui.util;

import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class HintedTextField extends JTextField implements DocumentListener, Runnable
	{
		/**
		* 
		*/
		private static final long serialVersionUID = 1L;
		
		public HintedTextField()
			{
				super();
				setComponentPopupMenu(DefaultTextContextMenu.POPUP);
				getDocument().addDocumentListener(this);
			}
			
		@Override
		public void changedUpdate(DocumentEvent e)
			{
				SwingUtilities.invokeLater(this);
			}
			
		@Override
		public void insertUpdate(DocumentEvent e)
			{
				SwingUtilities.invokeLater(this);
			}
			
		@Override
		public void removeUpdate(DocumentEvent e)
			{
				SwingUtilities.invokeLater(this);
			}
			
		public void run()
			{
				setToolTipText(this.getText());
			}
			
		@Override
		public void setText(String text)
			{
				super.setText(text);
				setCaretPosition(0);
			}
	}
