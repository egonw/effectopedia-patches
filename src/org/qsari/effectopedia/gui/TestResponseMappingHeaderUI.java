package org.qsari.effectopedia.gui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.text.Document;

import org.qsari.effectopedia.core.objects.TestResponseMapping;
import org.qsari.effectopedia.gui.comp.EventsManager;
import org.qsari.effectopedia.gui.core.LoadableEditorUI;
import org.qsari.effectopedia.gui.help.RootHelpContext;
import org.qsari.effectopedia.gui.toolbars.FeedbackToolbarUI;
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
public class TestResponseMappingHeaderUI extends EffectopediaObjectHeaderUI<TestResponseMapping> implements AdjustableUI, LoadableEditorUI, SizeOptimizableUI, MouseListener
	{
		private JLabel												jlTRMTitle;
		private JTextField								jtfTRMID;
		private JLabel												jlTRMID;
		private FeedbackToolbarUI	ftbuiTRM;
		
		/**
		 * Auto-generated main method to display this JPanel inside a new JFrame.
		 */
		public static void main(String[] args)
			{
				JFrame frame = new JFrame();
				frame.getContentPane().add(new TestResponseMappingHeaderUI(null));
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				frame.pack();
				frame.setVisible(true);
			}
		
		public TestResponseMappingHeaderUI(RootHelpContext rootHelpContext)
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
						GridBagLayout thisLayout = new GridBagLayout();
						thisLayout.rowWeights = new double[]
							{ 0.0 };
						thisLayout.rowHeights = new int[]
							{ 24 };
						thisLayout.columnWeights = new double[]
							{ 0.0, 0.7, 0.0, 0.2, 0.1 };
						// thisLayout.columnWidths = new int[] {24,230, 24, 80, 42};
						this.setLayout(thisLayout);
						this.setFont(new java.awt.Font("Tahoma", 1, 12));
							{
								jlTRMTitle = new JLabel("Title");
								this.add(jlTRMTitle, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.NORTHWEST, GridBagConstraints.NONE, new Insets(2, 4, 0, 2), 0, 0));
								jlTRMTitle.setDisplayedMnemonicIndex(0);
								jlTRMTitle.setFont(new java.awt.Font("Dialog", 0, 12));
								jlTRMTitle.addMouseListener(this);
							}
							{
								jlTRMID = new JLabel();
								this.add(jlTRMID, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0, GridBagConstraints.NORTHEAST, GridBagConstraints.NONE, new Insets(2, 2, 0, 2), 0, 0));
								jlTRMID.setText("ID");
								jlTRMID.setDisplayedMnemonicIndex(0);
								jlTRMID.setFont(new java.awt.Font("Dialog", 0, 12));
								jlTRMID.addMouseListener(this);
							}
							{
								ftbuiTRM = new FeedbackToolbarUI("test response mapping", FeedbackToolbarUI.INTERACT, FlowLayout.RIGHT);
								this.add(ftbuiTRM, new GridBagConstraints(4, 0, 1, 1, 0.0, 0.0, GridBagConstraints.NORTHEAST, GridBagConstraints.NONE, new Insets(0, 0, 0, 2), 0, 0));
							}
							{
								htfTitle = new HintedTextField();
								this.add(htfTitle, new GridBagConstraints(1, 0, 1, 1, 0.7, 0.0, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
								htfTitle.setFont(new java.awt.Font("Dialog", 1, 12));
								//htfTitle.setHorizontalAlignment(SwingConstants.CENTER);
								htfTitle.setText("Type Concise Title ");
								htfTitle.addMouseListener(this);
							}
							{
								jtfTRMID = new JTextField();
								this.add(jtfTRMID, new GridBagConstraints(3, 0, 1, 1, 0.0, 0.0, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(0, 2, 0, 0), 0, 0));
								jtfTRMID.setHorizontalAlignment(SwingConstants.CENTER);
								jtfTRMID.setText("auto");
								jtfTRMID.setEditable(false);
							}
						updateOptimalSize();
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
				// allowRedirecting = (visualOptions & VIEW) != 0;
				if ((visualOptions & HEADER) != 0)
					{
						setVisible(true);
						jlTRMID.setVisible((visualOptions & LABELS) == LABELS);
						jlTRMTitle.setVisible((visualOptions & LABELS) == LABELS);
						jtfTRMID.setVisible((visualOptions & AUTOIDS) == AUTOIDS);
						// int gridx = (jlEffectTitle.isVisible()) ? 1 : 0;
						// int gridwidth = 2 - gridx + 2 * ((jtfEffectID.isVisible()) ? 0 : 1);
					}
				else
					{
						setVisible(false);
					}
			}
		
		public void load(Object o, boolean readonly)
			{
				if (!(o instanceof TestResponseMapping))
					return;
				Document doc = htfTitle.getDocument();
				listeners.unbondDocumntListener(doc, "Title");
				eo = (TestResponseMapping) o;
				jtfTRMID.setText(eo.getIDandExternalID());
				htfTitle.setText(eo.getTitle());
				htfTitle.setEditable(!readonly);
				listeners.bondDocumntListener(doc, eo, "Title");
				ftbuiTRM.load(eo, readonly);
			}
		
		public void updateOptimalSize()
			{
				optimalSize.height = jlTRMTitle.getPreferredSize().height + 8;
				setSize(optimalSize);
				setPreferredSize(optimalSize);
				setMinimumSize(optimalSize);
				setMaximumSize(maximumSize);
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
		
		public HintedTextField getTitleUI()
			{
				return htfTitle;
			}
		
		/**
	 * 
	 */
		private static final long	serialVersionUID	= 1L;
		
		private Dimension									optimalSize						= new Dimension(400, 24);
		private Dimension									maximumSize						= new Dimension(Integer.MAX_VALUE, 24);
		private EventsManager					listeners;
	}
