package org.qsari.effectopedia.core.ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.qsari.effectopedia.core.ui.nav.UINavigator;
import org.qsari.effectopedia.core.ui.nav.UINavigatorless;

//import org.qsari.effectopedia.go.GUIFactory;
//import org.qsari.effectopedia.go.GUIFactory;

public class UserInterface
	{
		public static void showFeedback(String message, String caption)
			{
				JOptionPane.showMessageDialog(null, message, caption, JOptionPane.INFORMATION_MESSAGE);
			}
			
		public static void showError(String message)
			{
				JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
			}
			
		public static void showWarning(String message)
			{
				JOptionPane.showMessageDialog(null, message, "Warning", JOptionPane.WARNING_MESSAGE);
			}
			
		public static boolean getUserConfirmation(String message)
			{
				return JOptionPane.showConfirmDialog(null, message, "Confirmation", JOptionPane.YES_NO_CANCEL_OPTION) == JOptionPane.YES_OPTION;
			}

		public static boolean getUserYesNoConfirmation(String message)
			{
				return JOptionPane.showConfirmDialog(null, message, "Confirmation", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
			}

		public static boolean getUserConfirmationWithOptions(String message)
			{
				return JOptionPane.showConfirmDialog(null, ConfirmationDialog.DIALOG.setMessage(message), "Confirmation", JOptionPane.YES_NO_CANCEL_OPTION) == JOptionPane.YES_OPTION;
			}
			
			
		public static class ConfirmationDialog extends JPanel implements ActionListener
			{
				public static final ConfirmationDialog	DIALOG											= new ConfirmationDialog();
				private static final long														serialVersionUID	= 1L;
				private JLabel																									message;
				private JCheckBox																						jcbDontAskForConfirmation;
				
				private ConfirmationDialog()
					{
						setLayout(new BorderLayout());
						message = new JLabel("Confirmation message");
						this.add(message, BorderLayout.CENTER);
						jcbDontAskForConfirmation = new JCheckBox("Don't ask me again");
						add(jcbDontAskForConfirmation, BorderLayout.SOUTH);
						jcbDontAskForConfirmation.addActionListener(this);
					}
					
				public ConfirmationDialog setMessage(String message)
					{
						this.message.setText(message);
						return this;
					}
					
				@Override
				public void actionPerformed(ActionEvent e)
					{
						askingConfirmation = !jcbDontAskForConfirmation.isSelected();
					}
			}
			
		public static UINavigator getDefaultNavigator()
			{
				return defaultNavigator;
			}
			
		public static void setDefaultNavigator(UINavigator defaultNavigator)
			{
				UserInterface.defaultNavigator = defaultNavigator;
			}
			
		public static UIFactory getDefaultUIFactory()
			{
				return defaultUIFactory;
			}
			
		public static void setDefaultUIFactory(UIFactory defaultUIFactory)
			{
				UserInterface.defaultUIFactory = defaultUIFactory;
			}
			
		public static boolean isAskingConfirmation()
			{
				return askingConfirmation;
			}
			
  public static void setBusyStatus(boolean isBusy)
  {
  	defaultUIFactory.setBusyStatus(isBusy);
  }
		
  
		private static boolean														askingConfirmation	= true;
		private static volatile UINavigator	defaultNavigator			= UINavigatorless.NAVIGATOR;
		private static volatile UIFactory			defaultUIFactory			= NoUIFactory.FACTORY;
	}
