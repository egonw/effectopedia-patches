package org.qsari.effectopedia.gui.default_ui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.base.Titleable;
import org.qsari.effectopedia.gui.comp.EventsManager;
import org.qsari.effectopedia.gui.core.LoadableEditorUI;
import org.qsari.effectopedia.gui.help.ContextSensitivePanel;
import org.qsari.effectopedia.gui.help.RootHelpContext;

public class EffectopediaObjectTitleUI extends ContextSensitivePanel implements LoadableEditorUI
	{
		/**
		* 
		*/
		private static final long	serialVersionUID	= 1L;
		protected JTextField						jtfID;
		protected JLabel										jlID;
		protected JTextField						jtfTitle;
		
		public static void main(String[] args)
			{
				JFrame frame = new JFrame();
				frame.getContentPane().add(new EffectopediaObjectTitleUI(null));
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				frame.pack();
				frame.setVisible(true);
			}
			
		public EffectopediaObjectTitleUI(RootHelpContext rootHelpContext)
			{
				super(rootHelpContext);
				listeners = new EventsManager();
				initGUI();
			}
			
		protected void initGUI()
			{
				try
					{
						this.setPreferredSize(optimalSize);
						GridBagLayout jpDefaultTitlePanelLayout = new GridBagLayout();
						this.setBackground(Color.WHITE);
						jpDefaultTitlePanelLayout.rowWeights = new double[]
							{ 0.1 };
						jpDefaultTitlePanelLayout.rowHeights = new int[]
							{ 7 };
						jpDefaultTitlePanelLayout.columnWeights = new double[]
							{ 1.0, 0.0, 0.0, 0.0, 0.1 };
						jpDefaultTitlePanelLayout.columnWidths = new int[]
							{ 481, 2, 2, 20, 20 };
						this.setLayout(jpDefaultTitlePanelLayout);
							{
								jtfTitle = new JTextField();
								this.add(jtfTitle, new GridBagConstraints(0, 0, 1, 1, 8.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 4, 0, 0), 0, 0));
								jtfTitle.setText("Title");
								jtfTitle.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
								jtfTitle.setFont(new java.awt.Font("Tahoma", 1, 12));
							}
							
							{
								jlID = new JLabel();
								this.add(jlID, new GridBagConstraints(3, 0, 1, 1, 0.5, 0.0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
								jlID.setText("ID: ");
							}
							{
								jtfID = new JTextField();
								this.add(jtfID, new GridBagConstraints(4, 0, 1, 1, 1.0, 0.0, GridBagConstraints.EAST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
								jtfID.setText("0");
								jtfID.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
							}
						RootHelpContext.addMouseMotionListeners(this, rootHelpContext,false);
					}
				catch (Exception e)
					{
						e.printStackTrace();
					}
			}
			
		@Override
		public void load(Object o, boolean readonly)
			{
				if (!(o instanceof Titleable))
					return;
				listeners.unbondDocumntListener(jtfTitle.getDocument(), "Title");
				jtfTitle.setText(((Titleable) o).getTitle());
				jtfTitle.setEditable(!readonly);
				if (o instanceof EffectopediaObject)
					{
						jlID.setText(((EffectopediaObject) o).isDefaultID() ? "DefaultID: " : "ID: ");
						jtfID.setText(((EffectopediaObject) o).getIDandExternalID());
					}
				listeners.bondDocumntListener(jtfTitle.getDocument(), o, "Title");
			}
			
		protected Dimension					optimalSize	= new java.awt.Dimension(600, 28);
		protected EventsManager	listeners;
	}
