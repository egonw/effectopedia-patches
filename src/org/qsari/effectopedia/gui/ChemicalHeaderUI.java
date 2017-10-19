package org.qsari.effectopedia.gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.EventObject;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.text.Document;

import org.qsari.effectopedia.core.objects.Initiator_ChemicalStructure;
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
public class ChemicalHeaderUI extends EffectopediaObjectHeaderUI<Initiator_ChemicalStructure> implements AdjustableUI, LoadableEditorUI, SizeOptimizableUI, KeyListener
	{
		/**
		* 
		*/
		private static final long	serialVersionUID	= 1207971105123532796L;
		private JLabel												jlChemicalName;
		private JTextField								jtfChemicalID;
		private JLabel												jlChemicalID;
		private FeedbackToolbarUI	ftbuiChemical;
		
		/**
		 * Auto-generated main method to display this JPanel inside a new JFrame.
		 */
		public static void main(String[] args)
			{
				JFrame frame = new JFrame();
				frame.getContentPane().add(new ChemicalHeaderUI(null));
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				frame.pack();
				frame.setVisible(true);
			}
			
		public ChemicalHeaderUI(RootHelpContext rootHelpContext)
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
							{ 0.1, 0.6, 0.1, 0.1, 0.1 };
						thisLayout.columnWidths = new int[]
							{ 1, 6, 1, 1, 1 };
						this.setLayout(thisLayout);
						this.setBackground(Color.WHITE);
							{
								jlChemicalName = new JLabel();
								this.add(jlChemicalName, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.NORTHWEST, GridBagConstraints.NONE, new Insets(2, 4, 0, 2), 0, 0));
								jlChemicalName.setText("Chemical Name");
								jlChemicalName.setDisplayedMnemonicIndex(0);
								jlChemicalName.setFont(new java.awt.Font("Dialog", 0, 12));
								jlChemicalName.setName("name");
							}
							{
								jlChemicalID = new JLabel();
								this.add(jlChemicalID, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0, GridBagConstraints.NORTHEAST, GridBagConstraints.NONE, new Insets(2, 0, 0, 2), 0, 0));
								jlChemicalID.setText("ID");
								jlChemicalID.setDisplayedMnemonicIndex(0);
								jlChemicalID.setFont(new java.awt.Font("Dialog", 0, 12));
								jlChemicalID.setName("id");
							}
							{
								ftbuiChemical = new FeedbackToolbarUI("chemical", FeedbackToolbarUI.INTERACT, FlowLayout.RIGHT);
								this.add(ftbuiChemical, new GridBagConstraints(4, 0, 1, 1, 0.15, 0.0, GridBagConstraints.NORTHEAST, GridBagConstraints.NONE, new Insets(0, 0, 0, 2), 0, 0));
							}
							
							{
								htfTitle = new HintedTextField();
								this.add(htfTitle, new GridBagConstraints(1, 0, 1, 1, 0.7, 0.0, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
								htfTitle.setFont(new java.awt.Font("Dialog", 1, 12));
								//htfTitle.setHorizontalAlignment(SwingConstants.CENTER);
								htfTitle.setText("Type Chemical Name Here");
								htfTitle.addKeyListener(this);
								htfTitle.addMouseListener(this);
								htfTitle.setName("title");
							}
							{
								jtfChemicalID = new JTextField();
								this.add(jtfChemicalID, new GridBagConstraints(3, 0, 1, 1, 0.15, 0.0, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
								jtfChemicalID.setHorizontalAlignment(SwingConstants.CENTER);
								jtfChemicalID.setText("auto");
								jtfChemicalID.setEditable(false);
								jtfChemicalID.setName("id");
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
						jlChemicalID.setVisible((visualOptions & LABELS) == LABELS);
						jlChemicalName.setVisible((visualOptions & LABELS) == LABELS);
						jtfChemicalID.setVisible((visualOptions & AUTOIDS) == AUTOIDS);
						// int gridx = (jlChemicalName.isVisible()) ? 1 : 0;
						// int gridwidth = 2 - gridx + 2 * ((jtfChemicalID.isVisible()) ? 0 : 1);
					}
				else
					{
						setVisible(false);
					}
			}
			
		public void load(Object o, boolean readonly)
			{
				if (!(o instanceof Initiator_ChemicalStructure))
					return;
				Document doc = htfTitle.getDocument();
				listeners.unbondDocumntListener(doc, "Title");
				eo = (Initiator_ChemicalStructure) o;
				jtfChemicalID.setText(eo.getIDandExternalID());
				htfTitle.setText(eo.getTitle());
				htfTitle.setEditable(!readonly);
				listeners.bondDocumntListener(doc, eo, "Title");
				ftbuiChemical.load(eo, readonly);
			}
			
		public void updateOptimalSize()
			{
				optimalSize.width = getParent().getWidth();
				optimalSize.height = jlChemicalName.getPreferredSize().height;
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
			
		@Override
		public void keyTyped(KeyEvent e)
			{
			}
			
		@Override
		public void keyPressed(KeyEvent e)
			{
			}
			
		@Override
		public void keyReleased(KeyEvent e)
			{
				fireTitleChanged(e);
			}
			
		public interface TitleChangeListener
			{
				public void onTitleChanged(EventObject evt);
			}
			
		public void addTitleChangeChangeListener(TitleChangeListener listener)
			{
				changeListeners.add(listener);
			}
			
		public void removeTitleChangeChangeListener(TitleChangeListener listener)
			{
				changeListeners.remove(listener);
			}
			
		public void fireTitleChanged(EventObject evt)
			{
				for (TitleChangeListener listener : changeListeners)
					listener.onTitleChanged(evt);
			}
			
		protected ArrayList<TitleChangeListener>	changeListeners	= new ArrayList<TitleChangeListener>();
		
		private Dimension																								optimalSize					= new Dimension(400, 23);
		
		private EventsManager																				listeners;
		
	}
