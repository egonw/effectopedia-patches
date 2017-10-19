package org.qsari.effectopedia.gui.obj_prop;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.qsari.effectopedia.gui.chart.ChartDataSeries;
import org.qsari.effectopedia.gui.chart.ChartDataSeries.Marker;
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
public class ColorChooserWithMarkerPreview extends JDialog implements LoadableEditorUI, ChangeListener, ActionListener
	{
		public static ColorChooserWithMarkerPreview	DIALOG;
		private JColorChooser																							jccChooser;
		private JLabel																														jlMarker;
		private JButton																													jbCancel;
		private JButton																													jbOk;
		private JPanel																														jpControl;
		private JPanel																														jpMarkerPreview;
		private JRadioButton																								jrbSelectOutlineColor;
		private JRadioButton																								jrbSelectFillColor;
		
		private ColorChooserWithMarkerPreview()
			{
				super(GUIFactory.GUI.getFrame(), true);
				initGUI();
			}
		
		public static void main(String[] args)
			{
				System.out.println("result "+selectColor(DEFAULT_MARKER));
			}
		
		private void initGUI()
			{
				try
					{
						BorderLayout borderLayout = new BorderLayout();
						this.setLayout(borderLayout);
						this.setPreferredSize(new java.awt.Dimension(600, 420));
							// Set up color chooser for setting text color
							{
								jccChooser = new JColorChooser();
								jccChooser.getSelectionModel().addChangeListener(this);
								jccChooser.setBorder(BorderFactory.createTitledBorder("Choose Marker Fill/Outline Color"));
								this.add(jccChooser, BorderLayout.PAGE_START);
							}
							{
								
								jpMarkerPreview = new JPanel();
								BoxLayout jpMarkerPreviewLayout = new BoxLayout(jpMarkerPreview, javax.swing.BoxLayout.Y_AXIS);
								jpMarkerPreview.setLayout(jpMarkerPreviewLayout);
							}
							{
									{
										jlMarker = new JLabel();
										jlMarker.setText("Marker");
										jlMarker.setAlignmentX(Component.CENTER_ALIGNMENT);
										jlMarker.setIcon(DEFAULT_MARKER);
										jlMarker.setBackground(Color.white);
										jpMarkerPreview.add(jlMarker);
									}
								
								jccChooser.setPreviewPanel(jpMarkerPreview);
									{
										jpControl = new JPanel();
										GridBagLayout jpControlLayout = new GridBagLayout();
										this.add(jpControl, BorderLayout.CENTER);
										jpControl.setBorder(BorderFactory.createTitledBorder("Select"));
										jpControl.setPreferredSize(new java.awt.Dimension(600, 91));
										jpControlLayout.rowWeights = new double[]
											{ 0.1, 0.1, 0.0 };
										jpControlLayout.rowHeights = new int[]
											{ 7, 7, 7 };
										jpControlLayout.columnWeights = new double[]
											{ 0.0, 0.0, 0.0, 0.1, 0.1 };
										jpControlLayout.columnWidths = new int[]
											{ 47, 67, 83, 7, 7 };
										jpControl.setLayout(jpControlLayout);
									}
									{
											{
												jrbSelectFillColor = new JRadioButton("Select marker fill color", false);
												jrbSelectFillColor.setAlignmentX(Component.LEFT_ALIGNMENT);
												jpControl.add(jrbSelectFillColor, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
											}
											{
												jrbSelectOutlineColor = new JRadioButton("Select outline and chart series color", true);
												jrbSelectOutlineColor.setAlignmentX(Component.LEFT_ALIGNMENT);
												jpControl.add(jrbSelectOutlineColor, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
											}
										ButtonGroup group = new ButtonGroup();
										group.add(jrbSelectFillColor);
										group.add(jrbSelectOutlineColor);
											{
												jbOk = new JButton();
												jpControl.add(jbOk, new GridBagConstraints(3, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
												jbOk.setText("Ok");
												jbOk.addActionListener(this);
											}
											{
												jbCancel = new JButton();
												jpControl.add(jbCancel, new GridBagConstraints(4, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
												jbCancel.setText("Cancel");
												jbCancel.addActionListener(this);
											}
										
									}
							}
					}
				catch (Exception e)
					{
						e.printStackTrace();
					}
			}
		
		@Override
		public void stateChanged(ChangeEvent evt)
			{
				if (jrbSelectFillColor.isSelected())
					marker.fillColor = jccChooser.getSelectionModel().getSelectedColor();
				else
					marker.outlineColor = jccChooser.getSelectionModel().getSelectedColor();
			}
		
		@Override
		public void load(Object o, boolean readonly)
			{
				if (o instanceof Marker)
					marker = (Marker) o;
				else
					marker = DEFAULT_MARKER;
				originalMarkerSize = marker.getSize();
				marker.setSize(previewMarkerSize);
				jlMarker.setIcon(marker);
			}
		
		@Override
		public void actionPerformed(ActionEvent evt)
			{
				selectionOK = evt.getSource() == jbOk;
				marker.setSize(originalMarkerSize);
				setVisible(false);
			}
		
		public static boolean selectColor(Marker marker)
			{
				if (DIALOG == null)
					DIALOG = new ColorChooserWithMarkerPreview();
				DIALOG.load(marker, false);
				DIALOG.pack();
				DIALOG.setVisible(true);
				return DIALOG.selectionOK;
			}
		
		private static Marker	DEFAULT_MARKER					= ChartDataSeries.newMarker(ChartDataSeries.MARKER_X, Color.white, Color.black);
		private Marker	marker													= DEFAULT_MARKER;
		private int				previewMarkerSize		= 12;
		private int				originalMarkerSize	= 7;
		public boolean	selectionOK;
	}
