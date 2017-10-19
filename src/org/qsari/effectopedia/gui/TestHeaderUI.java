package org.qsari.effectopedia.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import org.qsari.effectopedia.core.objects.Test;
import org.qsari.effectopedia.gui.comp.EventsManager;
import org.qsari.effectopedia.gui.core.LoadableEditorUI;
import org.qsari.effectopedia.gui.help.RootHelpContext;
import org.qsari.effectopedia.gui.util.HintedTextField;

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
public class TestHeaderUI extends EffectopediaObjectHeaderUI<Test> implements AdjustableUI, LoadableEditorUI
	{
		/**
	 * 
	 */
		private static final long	serialVersionUID	= 1207971105123532796L;
		private JLabel												jlTestTitle;
		private JTextField								jtfTestID;
		private JLabel												jlTestID;
		private GridBagLayout					thisLayout;
		
		/**
		 * Auto-generated main method to display this JPanel inside a new JFrame.
		 */
		public static void main(String[] args)
			{
				JFrame frame = new JFrame();
				frame.getContentPane().add(new TestHeaderUI(null));
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				frame.pack();
				frame.setVisible(true);
			}
		
		public TestHeaderUI(RootHelpContext rootHelpContext)
			{
				super(rootHelpContext);
				listeners = new EventsManager();
				initGUI();
			}
		
		private void initGUI()
			{
				try
					{
						this.setPreferredSize(new java.awt.Dimension(400, 26));
						thisLayout = new GridBagLayout();
						thisLayout.rowWeights = new double[]
							{ 0.0, 0.1, 0.1, 0.1 };
						thisLayout.rowHeights = new int[]
							{ 23 };
						thisLayout.columnWeights = new double[]
							{ 0.1, 0.6, 0.1, 0.1 };
						thisLayout.columnWidths = new int[]
							{ 1, 6, 1, 1 };
						this.setLayout(thisLayout);
							{
								jlTestTitle = new JLabel();
								this.add(jlTestTitle, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.NORTHWEST, GridBagConstraints.NONE, new Insets(2, 4, 0, 2), 0, 0));
								jlTestTitle.setText("Test Title");
								jlTestTitle.setDisplayedMnemonicIndex(0);
								jlTestTitle.setFont(new java.awt.Font("Dialog", 0, 12));
							}
							{
								jlTestID = new JLabel();
								this.add(jlTestID, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0, GridBagConstraints.NORTHEAST, GridBagConstraints.NONE, new Insets(2, 0, 0, 2), 0, 0));
								jlTestID.setText("ID");
								jlTestID.setDisplayedMnemonicIndex(0);
								jlTestID.setFont(new java.awt.Font("Dialog", 0, 12));
							}
							{
								htfTitle = new HintedTextField();
								this.add(htfTitle, new GridBagConstraints(1, 0, 1, 1, 0.7, 0.0, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
								htfTitle.setFont(new java.awt.Font("Dialog", 1, 12));
								//htfTitle.setHorizontalAlignment(SwingConstants.CENTER);
								htfTitle.setText("Type Concise Test Title ");
							}
							{
								jtfTestID = new JTextField();
								this.add(jtfTestID, new GridBagConstraints(3, 0, 1, 1, 0.3, 0.0, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
								jtfTestID.setHorizontalAlignment(SwingConstants.CENTER);
								jtfTestID.setText("auto");
							}
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
						jlTestID.setVisible((visualOptions & LABELS) == LABELS);
						jlTestTitle.setVisible((visualOptions & LABELS) == LABELS);
						jtfTestID.setVisible((visualOptions & AUTOIDS) == AUTOIDS);
						int gridx = (jlTestTitle.isVisible()) ? 1 : 0;
						int gridwidth = 2 - gridx + 2 * ((jtfTestID.isVisible()) ? 0 : 1);
						thisLayout.setConstraints(htfTitle, new GridBagConstraints(gridx, 0, gridwidth, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
					}
				else
					{
						setVisible(false);
					}
			}
		
		public void load(Object o, boolean readonly)
			{
				if (!(o instanceof Test))
					return;
				listeners.unbondDocumntListener(htfTitle.getDocument(), "Title");
				eo = (Test) o;
				jtfTestID.setText(eo.getIDandExternalID());
				htfTitle.setText(eo.getTitle());
				htfTitle.setEditable(!readonly);
				listeners.bondDocumntListener(htfTitle.getDocument(), eo, "Title");
			}
		
		private EventsManager	listeners;
	}
