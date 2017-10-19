package org.qsari.effectopedia.gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.text.Document;

import org.qsari.effectopedia.core.objects.Initiator_StructuralAlerts;
import org.qsari.effectopedia.gui.comp.EventsManager;
import org.qsari.effectopedia.gui.core.LoadableEditorUI;
import org.qsari.effectopedia.gui.help.ContextSensitivePanel;
import org.qsari.effectopedia.gui.help.RootHelpContext;

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
public class StructuralAlertHeaderUI extends ContextSensitivePanel implements AdjustableUI, LoadableEditorUI, SizeOptimizableUI
	{
		/**
	 * 
	 */
		private static final long	serialVersionUID	= 1207971105123532796L;
		private JLabel												jlStructuralAlertName;
		private JTextField								jtfStructuralAlertName;
		private JTextField								jtfStructuralAlertID;
		private JLabel												jlStructuralAlertID;
		
		/**
		 * Auto-generated main method to display this JPanel inside a new JFrame.
		 */
		public static void main(String[] args)
			{
				JFrame frame = new JFrame();
				frame.getContentPane().add(new StructuralAlertHeaderUI(null));
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				frame.pack();
				frame.setVisible(true);
			}
		
		public StructuralAlertHeaderUI(RootHelpContext rootHelpContext)
			{
				super(rootHelpContext);
				setName("header");
				listeners = new EventsManager();
				initGUI();
			}
		
		private void initGUI()
			{
				try
					{
						this.setPreferredSize(new java.awt.Dimension(400, 64));
						GridBagLayout thisLayout = new GridBagLayout();
						thisLayout.rowWeights = new double[]
							{ 0.1 };
						thisLayout.rowHeights = new int[]
							{ 23 };
						thisLayout.columnWeights = new double[]
							{ 0.1, 0.6, 0.1, 0.1 };
						thisLayout.columnWidths = new int[]
							{ 1, 6, 1, 1 };
						this.setLayout(thisLayout);
						this.setBackground(Color.WHITE);
							{
								jlStructuralAlertName = new JLabel();
								this.add(jlStructuralAlertName, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.NORTHWEST, GridBagConstraints.NONE, new Insets(2, 4, 0, 2), 0, 0));
								jlStructuralAlertName.setText("Structural Alert Name");
								jlStructuralAlertName.setDisplayedMnemonicIndex(0);
								jlStructuralAlertName.setFont(new java.awt.Font("Dialog", 0, 12));
								jlStructuralAlertName.setName("name");
							}
							{
								jlStructuralAlertID = new JLabel();
								this.add(jlStructuralAlertID, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0, GridBagConstraints.NORTHEAST, GridBagConstraints.NONE, new Insets(2, 0, 0, 2), 0, 0));
								jlStructuralAlertID.setText("ID");
								jlStructuralAlertID.setDisplayedMnemonicIndex(0);
								jlStructuralAlertID.setFont(new java.awt.Font("Dialog", 0, 12));
								jlStructuralAlertID.setName("name");
							}
							{
								jtfStructuralAlertName = new JTextField();
								this.add(jtfStructuralAlertName, new GridBagConstraints(1, 0, 1, 1, 0.7, 0.0, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
								jtfStructuralAlertName.setFont(new java.awt.Font("Dialog", 1, 12));
								jtfStructuralAlertName.setHorizontalAlignment(SwingConstants.CENTER);
								jtfStructuralAlertName.setText("Type Structural Alert Name Here");
								jtfStructuralAlertName.setName("name");
							}
							{
								jtfStructuralAlertID = new JTextField();
								this.add(jtfStructuralAlertID, new GridBagConstraints(3, 0, 1, 1, 0.3, 0.0, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
								jtfStructuralAlertID.setHorizontalAlignment(SwingConstants.CENTER);
								jtfStructuralAlertID.setText("auto");
								jtfStructuralAlertID.setEditable(false);
								jtfStructuralAlertID.setName("id");
							}
							RootHelpContext.addMouseMotionListeners(this, rootHelpContext,false);
					}
				catch (Exception e)
					{
						e.printStackTrace();
					}
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
				if ((visualOptions & HEADER) != 0)
					{
						setVisible(true);
						jlStructuralAlertID.setVisible((visualOptions & LABELS) == LABELS);
						jlStructuralAlertName.setVisible((visualOptions & LABELS) == LABELS);
						jtfStructuralAlertID.setVisible((visualOptions & AUTOIDS) == AUTOIDS);
					}
				else
					{
						setVisible(false);
					}
			}
		
		public void load(Object o, boolean readonly)
			{
				if (!(o instanceof Initiator_StructuralAlerts))
					return;
				Document doc = jtfStructuralAlertName.getDocument();
				listeners.unbondDocumntListener(doc, "Title");
				alert = (Initiator_StructuralAlerts) o;
				jtfStructuralAlertID.setText(alert.getIDandExternalID());
				jtfStructuralAlertName.setText(alert.getTitle());
				jtfStructuralAlertName.setEditable(!readonly);
				listeners.bondDocumntListener(doc, alert, "Title");
			}
		
		public void updateOptimalSize()
			{
				optimalSize.width = getParent().getWidth();
				optimalSize.height = jlStructuralAlertName.getPreferredSize().height;
				setSize(optimalSize);
				this.setPreferredSize(optimalSize);
				this.setMaximumSize(new java.awt.Dimension(4000, 23));
				Container parent = getParent();
				while (parent != null)
					{
						if (parent instanceof SizeOptimizableUI)
							{
								((SizeOptimizableUI) parent).updateOptimalSize();
								break;
							}
						parent = parent.getParent();
					}
			}
		
		private Dimension										optimalSize	= new Dimension(400, 23);
		
		private Initiator_StructuralAlerts	alert;
		private EventsManager						listeners;
	}
