package org.qsari.effectopedia.gui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import org.qsari.effectopedia.core.objects.Pathway;
import org.qsari.effectopedia.gui.core.GUIFactory;
import org.qsari.effectopedia.gui.core.LoadableEditorUI;

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
public class DisassociatePathwayDialog extends javax.swing.JDialog implements LoadableEditorUI, ActionListener
	{
		/**
	 * 
	 */
		private static final long																					serialVersionUID	= 0L;
		private JTextPane																													jtpMessage;
		private JButton																															jbCancel;
		private JButton																															jbRemove;
		private JLabel																																jlQuestionIcon;
		private JCheckBox																													jcbUpstreamElements;
		
		public static final DisassociatePathwayDialog	DIALOG											= new DisassociatePathwayDialog(GUIFactory.GUI.getFrame());
		
		/**
		 * Auto-generated main method to display this JDialog
		 */
		public static void main(String[] args)
			{
				SwingUtilities.invokeLater(new Runnable()
					{
						public void run()
							{
								DIALOG.setVisible(true);
							}
					});
			}
		
		private DisassociatePathwayDialog(JFrame frame)
			{
				super(frame);
				initGUI();
			}
		
		private void initGUI()
			{
				try
					{
							{
								GridBagLayout thisLayout = new GridBagLayout();
								thisLayout.rowWeights = new double[]
									{ 0.1, 0.0, 0.0, 0.0, 0.1 };
								thisLayout.rowHeights = new int[]
									{ 7, 33, 33, 33, 7 };
								thisLayout.columnWeights = new double[]
									{ 0.1, 0.1, 0.1, 0.1 };
								thisLayout.columnWidths = new int[]
									{ 7, 7, 7, 7 };
								getContentPane().setLayout(thisLayout);
								this.setTitle("Remove pathway associations");
									{
										jtpMessage = new JTextPane();
										getContentPane().add(jtpMessage, new GridBagConstraints(1, 0, 3, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 8), 0, 0));
										jtpMessage.setText("Remove association of the current element and optionally between all linked:");
										jtpMessage.setEditable(false);
										jtpMessage.setOpaque(false);
										jtpMessage.setFont(new java.awt.Font("Segoe UI", 0, 18));
									}
									{
										jlQuestionIcon = new JLabel();
										getContentPane().add(jlQuestionIcon, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
										jlQuestionIcon.setIcon(new ImageIcon(getClass().getClassLoader().getResource("org/qsari/effectopedia/gui/res/dialog_warning.png")));
										jlQuestionIcon.setHorizontalTextPosition(SwingConstants.RIGHT);
									}
									{
										jbCancel = new JButton();
										getContentPane().add(jbCancel, new GridBagConstraints(3, 4, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
										jbCancel.setText("Cancel");
										jbCancel.setIcon(new ImageIcon(getClass().getClassLoader().getResource("org/qsari/effectopedia/gui/res/button_cancel.png")));
										jbCancel.addActionListener(this);
									}
									{
										jbRemove = new JButton();
										getContentPane().add(jbRemove, new GridBagConstraints(2, 4, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
										jbRemove.setText("Remove");
										jbRemove.setIcon(new ImageIcon(getClass().getClassLoader().getResource("org/qsari/effectopedia/gui/res/button_delete.png")));
										jbRemove.setIconTextGap(8);
										jbRemove.addActionListener(this);
									}
									{
										jcbUpstreamElements = new JCheckBox();
										getContentPane().add(jcbUpstreamElements, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
										jcbUpstreamElements.setText("upstream elements");
										jcbUpstreamElements.setSelected(true);
									}
									{
										jcbDownstreamElements = new JCheckBox();
										getContentPane().add(jcbDownstreamElements, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
										jcbDownstreamElements.setText("downstream elements");
										jcbDownstreamElements.setSelected(true);
									}
									{
										jlwith = new JLabel();
										getContentPane().add(jlwith, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
										jlwith.setText("with: ");
									}
									{
										jlPathwayName = new JLabel();
										getContentPane().add(jlPathwayName, new GridBagConstraints(1, 3, 3, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
										jlPathwayName.setText(" ");
									}
							}
						setCentredLocation();
						setModal(true);
						this.setLocationByPlatform(true);
						this.setName("Pathway Selector");
						pack();
						this.setSize(500, 335);
					}
				catch (Exception e)
					{
						e.printStackTrace();
					}
			}
		
		public void setCentredLocation()
			{
				Container parent = getParent();
				int x = parent.getLocationOnScreen().x;
				int y = parent.getLocationOnScreen().y;
				Dimension parentSize = parent.getSize();
				Dimension dialogSize = getSize();
				
				if (parentSize.width > dialogSize.width)
					x += ((parentSize.width - dialogSize.width) >> 1);
				
				if (parentSize.height > dialogSize.height)
					y += ((parentSize.height - dialogSize.height) >> 1);
				
				setLocation(x, y);
			}
		
		public void load(Object o, boolean readonly)
			{
				if ((o instanceof Pathway))
					{
						pathway = (Pathway) o;
						DIALOG.setVisible(true);
						jlPathwayName.setText(pathway.getTitle());
					}
				else
					{
						pathway = null;
						DIALOG.setVisible(false);
					}
			}
		
		public void actionPerformed(ActionEvent e)
			{
				canceled = e.getSource()==jbCancel;
				DIALOG.setVisible(false);
			}
		
		public boolean isUpdateUpstreamElementsSelected()
			{
				return jcbUpstreamElements.isSelected();
			}
		
		public boolean isUpdateDownstreamElementsSelected()
			{
				return jcbDownstreamElements.isSelected();
			}
		
		public boolean isCanceled()
			{
				return canceled;
			}

		private boolean			canceled;
		private JLabel				jlwith;
		private JLabel				jlPathwayName;
		private Pathway			pathway;
		private JCheckBox	jcbDownstreamElements;
		
	}
