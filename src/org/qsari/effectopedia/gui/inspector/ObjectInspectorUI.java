package org.qsari.effectopedia.gui.inspector;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;

import org.qsari.effectopedia.base.io.BaseIO;
import org.qsari.effectopedia.base.io.BaseIOElement;
import org.qsari.effectopedia.gui.comp.JTreeTable;

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
public class ObjectInspectorUI extends javax.swing.JPanel
	{
		/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;
		private JTreeTable	jtPropertyTree;

		/**
		 * Auto-generated main method to display this JPanel inside a new JFrame.
		 */
		public static void main(String[] args)
			{
				JFrame frame = new JFrame();
				frame.getContentPane().add(new ObjectInspectorUI());
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				frame.pack();
				frame.setVisible(true);
				frame.getContentPane().setBackground(Color.WHITE);
			}
		
		public ObjectInspectorUI()
			{
				super();
				initGUI();
			}
		
		private void initGUI()
			{
				try
					{
						BorderLayout thisLayout = new BorderLayout();
						this.setLayout(thisLayout);
						setPreferredSize(new Dimension(400, 300));
						this.setBackground(Color.WHITE);
							{
								jspObjectInspector = new JScrollPane();
								this.add(jspObjectInspector, BorderLayout.CENTER);
								jspObjectInspector.setPreferredSize(new java.awt.Dimension(400, 300));
									{
										jtPropertyTree = createTreeTable();
										jspObjectInspector.setViewportView(jtPropertyTree);
										jspObjectInspector.getViewport().setBackground(Color.white);
									}
							}
					}
				catch (Exception e)
					{
						e.printStackTrace();
					}
			}
		
		protected JTreeTable createTreeTable()
			{
				model = new XMLDataTreeTableModelAdapter();
				JTreeTable treeTable = new JTreeTable(model);
				/*
				treeTable.getColumnModel().getColumn(1).setCellRenderer(new IndicatorRenderer());

				 * Reloader rl = new Reloader();
				 * 
				 * timer = new Timer(700, rl); timer.setRepeats(true);
				 * treeTable.getTree().addTreeExpansionListener(rl);
				 */
				return treeTable;
			}
		
		public void load(BaseIOElement element, BaseIO io)
			{
				model = new XMLDataTreeTableModelAdapter(element,io);
				jtPropertyTree.getTree().setModel(model);
				repaint();
			}
		
		private XMLDataTreeTableModelAdapter	model;
		private JScrollPane jspObjectInspector;
	}