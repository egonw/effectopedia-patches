package org.qsari.effectopedia.gui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;

import org.qsari.effectopedia.core.ui.UserInterface;
import org.qsari.effectopedia.core.ui.nav.UIInitializer;
import org.qsari.effectopedia.core.ui.nav.UILocation;
import org.qsari.effectopedia.core.ui.nav.UILocations;
import org.qsari.effectopedia.defaults.DefaultGOSettings;
import org.qsari.effectopedia.gui.help.ContextSensitivePanel;
import org.qsari.effectopedia.gui.help.RootHelpContext;
import org.qsari.effectopedia.gui.nav.GUIInitializations;

public class WelcomeLinksUI extends ContextSensitivePanel
	{
		private static Color									textColor				= new Color(0x80, 0x80, 0x80);
		private static String								searchHTML			= "<html><font size='6'>Search</font><br><font color='#606060'>Adverse Outcome Pathways<br>Key Events, Stressors</font></html>";
		private static String								newAOPHTML			= "<html><font size='6'>Create new</font><br><font color='#606060'>Adverse Outcome Pathway<br><br></font></html>";
		private static String								historyHTML		= "<html><font size='6'>Explore</font><br><font color='#606060'>The history of contributions<br><br></font></html>";
		private static String								feedbackHTML	= "<html><font size='6'>Feedback</font><br><font color='#606060'>Provide feedback and suggestions<br><br></font></html>";
		
		public static WelcomeLinksUI	INSTANCE					= new WelcomeLinksUI(null);
		
		private WelcomeLinksUI(RootHelpContext rootHelpContext)
			{
				super(rootHelpContext);
				setName("links");
				setBackground(Color.white);
				GridBagLayout gridBagLayout = new GridBagLayout();
				GridBagConstraints gbc = new GridBagConstraints();
				gridBagLayout.columnWidths = new int[]
					{ 120, 90, 110, 120 };
				gridBagLayout.rowHeights = new int[]
					{ 0, 0, 0 };
				gridBagLayout.columnWeights = new double[]
					{ 1.2, 0.9, 1.1, 1.2 };
				gridBagLayout.rowWeights = new double[]
					{ 2.0, 4.0, 4.0 };
				setLayout(gridBagLayout);
				
				JLabel jlHowToUse = new JLabel("<html><font size='4'>How would you like to use Effectopedia?</html>");
				jlHowToUse.setName("howToUse");
				jlHowToUse.setForeground(textColor);
				gbc = new GridBagConstraints();
				gbc.gridwidth = 2;
				gbc.insets = new Insets(8, 0, 16, 0);
				gbc.gridx = 1;
				gbc.gridy = 0;
				gbc.fill = GridBagConstraints.VERTICAL;
				add(jlHowToUse, gbc);
				
				JButton jbSearch = createButton(searchHTML, UIResources.imageSearch, UIResources.imageSearchAct, UILocations.searchUIL, GUIInitializations.searchForPathway);
				jbSearch.setName("search");
				gbc = new GridBagConstraints();
				gbc.insets = new Insets(0, 0, 5, 5);
				gbc.gridx = 1;
				gbc.gridy = 1;
				gbc.anchor = GridBagConstraints.EAST;
				gbc.fill = GridBagConstraints.VERTICAL;
				add(jbSearch, gbc);
				
				JButton jbNewAOP = createButton(newAOPHTML, UIResources.imageNewAOP, UIResources.imageNewAOPAct, UILocations.viewUIL, null);
				jbNewAOP.setName("newAOP");
				gbc = new GridBagConstraints();
				gbc.insets = new Insets(0, 0, 5, 0);
				gbc.gridx = 2;
				gbc.gridy = 1;
				gbc.anchor = GridBagConstraints.WEST;
				gbc.fill = GridBagConstraints.VERTICAL;
				add(jbNewAOP, gbc);
				
				JButton jbHistory = createButton(historyHTML, UIResources.imageHistory, UIResources.imageHistoryAct, UILocations.historyUIL, null);
				jbHistory.setName("history");
				gbc = new GridBagConstraints();
				gbc.insets = new Insets(0, 0, 0, 15);
				gbc.gridx = 1;
				gbc.gridy = 2;
				gbc.anchor = GridBagConstraints.EAST;
				gbc.fill = GridBagConstraints.VERTICAL;
				add(jbHistory, gbc);
				
				JButton jbFeedback = createButton(feedbackHTML, UIResources.imageFeedback, UIResources.imageFeedbackAct, UILocations.welcomeUIL, GUIInitializations.feedback);
				jbFeedback.setName("discuss");
				gbc = new GridBagConstraints();
				gbc.gridx = 2;
				gbc.gridy = 2;
				gbc.anchor = GridBagConstraints.WEST;
				gbc.fill = GridBagConstraints.VERTICAL;
				add(jbFeedback, gbc);
			}
			
		@Override
		public void setRootHelpContext(RootHelpContext rootHelpContext)
			{
				super.setRootHelpContext(rootHelpContext);
				RootHelpContext.addMouseMotionListeners(this, rootHelpContext,false);
			}
			
		public static void createWelcomeLinks(StyledDocument styledDocument)
			{
				Style def = StyleContext.getDefaultStyleContext().getStyle(StyleContext.DEFAULT_STYLE);
				Style ui = styledDocument.addStyle("centred", def);
				StyleConstants.setAlignment(ui, StyleConstants.ALIGN_CENTER);
				StyleConstants.setComponent(ui, INSTANCE);
				try
					{
						styledDocument.insertString(1, "ui", ui);
					}
				catch (BadLocationException e)
					{
						e.printStackTrace();
					}
			}
			
		private static JButton createButton(String label, ImageIcon icon, ImageIcon rollover, UILocation location, UIInitializer[] initialization)
			{
				JButton button = new JButton(label, icon);
				button.getModel().addChangeListener(new ChangeListener()
					{
						@Override
						public void stateChanged(ChangeEvent e)
							{
								ButtonModel model = (ButtonModel) e.getSource();
								if (model.isRollover())
									{
										button.setForeground(DefaultGOSettings.effectColor);
									}
								else
									{
										button.setForeground(new Color(0x80, 0x80, 0x80));
									}
							}
					});
				button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				button.setBorder(new EmptyBorder(0, 0, 0, 0));
				button.setFocusPainted(true);
				button.setRolloverIcon(rollover);
				button.setBackground(Color.white);
				button.setForeground(textColor);
				button.addActionListener(new ActionListener()
					{
						@Override
						public void actionPerformed(ActionEvent e)
							{
								UserInterface.getDefaultNavigator().navigate(location, null, initialization);
							}
					});
				return button;
			}
			
	}
