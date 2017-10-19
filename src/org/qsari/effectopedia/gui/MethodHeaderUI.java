package org.qsari.effectopedia.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.base.Titleable;
import org.qsari.effectopedia.core.objects.Method;
import org.qsari.effectopedia.gui.comp.EventsManager;
import org.qsari.effectopedia.gui.core.LoadableEditorUI;
import org.qsari.effectopedia.gui.help.RootHelpContext;

public class MethodHeaderUI extends EffectopediaObjectHeaderUI<Method> implements AdjustableUI, DocumentListener, LoadableEditorUI
	{
		/**
 * 
 */
		private static final long	serialVersionUID	= 1L;
		private JTextField								jtfID;
		private JLabel												jlID;
		private JTextField								jtfTitle;
		
		public MethodHeaderUI(RootHelpContext rootHelpContext)
			{
				super(rootHelpContext);
				setName("header");
				listeners = new EventsManager();
				initGUI();
				adjustUI(EDIT);
			}
		
		private void initGUI()
			{
				try
					{
							{
								Dimension optimalSize = new Dimension(600, 18);
								setPreferredSize(optimalSize);
								setMaximumSize(new Dimension(10000, 18));
								GridBagLayout thisLayout = new GridBagLayout();
								this.setBackground(Color.WHITE);
								thisLayout.rowWeights = new double[]
									{ 0.1 };
								thisLayout.rowHeights = new int[]
									{ 7 };
								thisLayout.columnWeights = new double[]
									{ 1.0, 0.0, 0.0, 0.0, 0.1 };
								thisLayout.columnWidths = new int[]
									{ 481, 2, 2, 20, 20 };
								this.setLayout(thisLayout);
									{
										jtfTitle = new JTextField();
										this.add(jtfTitle, new GridBagConstraints(0, 0, 1, 1, 8.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 4, 0, 0), 0, 0));
										jtfTitle.setText("Title");
										jtfTitle.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
										jtfTitle.setFont(new java.awt.Font("Tahoma", 1, 12));
										jtfTitle.setName("title");
									}
									{
										jlID = new JLabel();
										this.add(jlID, new GridBagConstraints(3, 0, 1, 1, 0.5, 0.0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
										jlID.setText("ID: ");
										jlID.setName("id");
									}
									{
										jtfID = new JTextField();
										this.add(jtfID, new GridBagConstraints(4, 0, 1, 1, 1.0, 0.0, GridBagConstraints.EAST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
										jtfID.setText("0");
										jtfID.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
										jtfID.setName("id");
									}
									RootHelpContext.addMouseMotionListeners(this, rootHelpContext,false);
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
				AdjustbleUserInterfaceTools.adjustChildren(this, visualOptions);
			}
		
		public void load(Object o, boolean readonly)
			{
				if (!(o instanceof Method))
					return;
				method = (Method) o;
				defaultObject = method.isDefaultID();
				listeners.unbondDocumntListener(jtfTitle.getDocument(), "Title");
				jtfTitle.getDocument().addDocumentListener(this);
				jtfTitle.setText(((Titleable) o).getTitle());
				jtfTitle.setEditable(!readonly);
				jlID.setText(((EffectopediaObject) o).isDefaultID() ? "DefaultID: " : "ID: ");
				jtfID.setText(((EffectopediaObject) o).getIDandExternalID());
				listeners.bondDocumntListener(jtfTitle.getDocument(), o, "Title");
			}
		
		public void refreshID()
			{
				if (method != null)
					{
						jtfID.setText(((EffectopediaObject) method).getIDandExternalID());
						if (!method.isDefaultID())
							{
								jtfTitle.getDocument().removeDocumentListener(this);
								jlID.setText("ID: ");
								defaultObject = false;
							}
					}
			}
		
		@Override
		public void changedUpdate(DocumentEvent arg0)
			{
				if (defaultObject)
					refreshID();
			}
		
		@Override
		public void insertUpdate(DocumentEvent arg0)
			{
				if (defaultObject)
					refreshID();
			}
		
		@Override
		public void removeUpdate(DocumentEvent arg0)
			{
				if (defaultObject)
					refreshID();
			}
		
		@Override
		public void initializeUI()
			{
				jtfTitle.requestFocus();
				SwingUtilities.invokeLater(new Runnable()
					{
						
						@Override
						public void run()
							{
								MethodHeaderUI.this.scrollRectToVisible(MethodHeaderUI.this.getBounds());
							}
					});
				
				if ((method != null) && (method.isDefaultID()))
					jtfTitle.selectAll();
			}
		
		private Method								method;
		private boolean							defaultObject	= true;
		private EventsManager	listeners;
		
	}
