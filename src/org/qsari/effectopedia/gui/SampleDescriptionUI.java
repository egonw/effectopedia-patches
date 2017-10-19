package org.qsari.effectopedia.gui;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.Border;

import org.qsari.effectopedia.gui.comp.GhostText;
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
public class SampleDescriptionUI extends ContextSensitivePanel
	{
		private JLabel							jlSampleLabel;
		private JTextField			jtfSampleName;
		private JTextField			jtfSampleUnit;
		private GhostText				gtSampleName;
		private GhostText				gtSampleUnit;
		private final Border	lightBorder	= BorderFactory.createMatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY);
		
		public static void main(String[] args)
			{
				JFrame frame = new JFrame();
				frame.getContentPane().add(new SampleDescriptionUI(null));
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				frame.pack();
				frame.setVisible(true);
			}
			
		public SampleDescriptionUI(RootHelpContext rootHelpContext)
			{
				super(rootHelpContext);
				setName("description");
				initGUI();
			}
			
		public SampleDescriptionUI(String label, String sampleName, String sampleUnit, RootHelpContext rootHelpContext)
			{
				super(rootHelpContext);
				this.label = label;
				this.sampleName = sampleName;
				this.sampleUnit = sampleUnit;
				initGUI();
			}
			
		public void setGhostLabels(String label, String sampleName, String sampleUnit)
			{
				this.label = label;
				this.sampleName = sampleName;
				this.sampleUnit = sampleUnit;
				jlSampleLabel.setText(label);
				gtSampleName.setGhostText(sampleName);
				gtSampleUnit.setGhostText(sampleUnit);
			}
			
		public void setLabels(String sampleName, String sampleUnit)
			{
				this.sampleName = sampleName;
				this.sampleUnit = sampleUnit;
				jtfSampleName.setText(sampleName);
				jtfSampleUnit.setText(sampleUnit);
			}
			
		private void initGUI()
			{
				try
					{
							{
								GridBagLayout thisLayout = new GridBagLayout();
								thisLayout.rowWeights = new double[]
									{ 0.1, 0.1, 0.1 };
								thisLayout.rowHeights = new int[]
									{ 7, 7, 7 };
								thisLayout.columnWeights = new double[]
									{ 0.1 };
								thisLayout.columnWidths = new int[]
									{ 7 };
								this.setLayout(thisLayout);
								this.setPreferredSize(new java.awt.Dimension(107, 85));
								this.setBackground(new java.awt.Color(255, 255, 255));
									{
										jlSampleLabel = new JLabel();
										this.add(jlSampleLabel, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 2, 0, 2), 0, 0));
										jlSampleLabel.setText(label);
										jlSampleLabel.setFont(new java.awt.Font("Segoe UI", 2, 12));
										jlSampleLabel.setName("name");
									}
									{
										jtfSampleName = new JTextField();
										this.add(jtfSampleName, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 2, 0, 2), 0, 0));
										gtSampleName = new GhostText(jtfSampleName, sampleName);
										jtfSampleName.setBorder(BorderFactory.createEmptyBorder());
										jtfSampleName.setName("name");
									}
									{
										jtfSampleUnit = new JTextField();
										this.add(jtfSampleUnit, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 2, 0, 2), 0, 0));
										gtSampleUnit = new GhostText(jtfSampleUnit, sampleUnit);
										jtfSampleUnit.setBorder(BorderFactory.createEmptyBorder());
										jtfSampleUnit.setName("unit");
									}
								RootHelpContext.addMouseMotionListeners(this, rootHelpContext,false);
							}
					}
				catch (Exception e)
					{
						e.printStackTrace();
					}
			}
			
		private String	label						= "Label";
		private String	sampleName	= "Sample Name";
		private String	sampleUnit	= "Sample unit";
	}
