package org.qsari.effectopedia.gui.obj_prop;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import org.qsari.effectopedia.data.objects.Resource;
import org.qsari.effectopedia.data.objects.Resource.ResourceType;
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
public class ResourceUI extends ContextSensitivePanel implements LoadableEditorUI, ActionListener, DocumentListener
	{
		/**
		 * 
	 * 
	 */
		private static final long	serialVersionUID	= 1L;
		
		public ResourceUI(JTabbedPane ownerPane,RootHelpContext rootHelpContext)
			{
				super(rootHelpContext);
				this.ownerPane = ownerPane;
				this.listeners = new EventsManager();
				initGUI();
			}
		
		private void initGUI()
			{
				try
					{
							{
								this.setPreferredSize(new java.awt.Dimension(600, 440));
								GridBagLayout thisLayout = new GridBagLayout();
								this.setBackground(Color.white);
								thisLayout.rowWeights = new double[]
									{ 0.0, 0.1 };
								thisLayout.rowHeights = new int[]
									{ 26, 7 };
								thisLayout.columnWeights = new double[]
									{ 0.0, 0.1, 0.0, 0.1 };
								thisLayout.columnWidths = new int[]
									{ 121, 7, 26, 20 };
								this.setLayout(thisLayout);
									{
										jlResourceType = new JLabel();
										this.add(jlResourceType, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 4, 0, 4), 0, 0));
										jlResourceType.setText("Resource type:");
									}
									{
										jspResource = new JScrollPane();
										this.add(jspResource, new GridBagConstraints(-1, 1, 5, 1, 0.0, 0.0, GridBagConstraints.EAST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
										jspResource.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
											{
												jepResource = new JEditorPane();
												jepResource.getDocument().addDocumentListener(this);
												jspResource.setViewportView(jepResource);
											}
									}
									{
										ComboBoxModel<ResourceType> jComboBox1Model = new DefaultComboBoxModel<ResourceType>(DEFAULT_RESOURCE_TYPES);
										jcbResourceType = new JComboBox<ResourceType>();
										this.add(jcbResourceType, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
										jcbResourceType.setModel(jComboBox1Model);
										jcbResourceType.setBackground(Color.white);
										jcbResourceType.addActionListener(this);
									}
									{
										jlID = new JLabel();
										this.add(jlID, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
										jlID.setText("ID:");
									}
									{
										jtfID = new JTextField();
										this.add(jtfID, new GridBagConstraints(3, 0, 1, 1, 0.0, 0.0, GridBagConstraints.EAST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
										jtfID.setText("0/0");
										jtfID.setEditable(false);
									}
							}
					}
				catch (Exception e)
					{
						e.printStackTrace();
					}
			}
		
		@Override
		public void load(Object o, boolean readonly)
			{
				if (o instanceof Resource)
					{
						resource = (Resource) o;
						loading = true;
						listeners.unbondDocumntListener(jepResource.getDocument(), "Content");
						
						jtfID.setText(resource.getIDandExternalID());
						jcbResourceType.setSelectedItem(resource.getResourceType());
						
						jcbResourceType.setEditable(!readonly);
						jepResource.setText(resource.getContent());
						
						listeners.bondDocumntListener(jepResource.getDocument(), resource, "Content");
						loading = false;
					}
				
			}
		
		@Override
		public void actionPerformed(ActionEvent evt)
			{
				if (loading || resource == null)
					return;
				resource.setResourceType((ResourceType) jcbResourceType.getSelectedItem());
			}
		
		public void resouceUpdate(String title)
			{
				if ((resource != null) && (!loading))
					{
						resource.setName(title);
						if (!resource.getIDandExternalID().equals(jtfID.getText()))
							jtfID.setText(resource.getIDandExternalID());
					}
			}
		
		@Override
		public void changedUpdate(DocumentEvent arg0)
			{
				contentUpdate();
			}
		
		@Override
		public void insertUpdate(DocumentEvent arg0)
			{
				contentUpdate();
			}
		
		@Override
		public void removeUpdate(DocumentEvent arg0)
			{
				contentUpdate();
			}
		
		public void contentUpdate()
			{
				if ((resource != null) && (!resource.getIDandExternalID().equals(jtfID.getText())))
					jtfID.setText(resource.getIDandExternalID());
			}
		
		protected boolean																		loading																= false;
		protected EventsManager												listeners;
		protected Resource																	resource;
		private JComboBox<ResourceType>				jcbResourceType;
		private JLabel																					jlID;
		private JEditorPane																jepResource;
		private JTextField																	jtfID;
		private JScrollPane																jspResource;
		private JLabel																					jlResourceType;
		protected final JTabbedPane								ownerPane;
		public static final ResourceType[]	DEFAULT_RESOURCE_TYPES	= new ResourceType[]
																																																													{ ResourceType.JAVA_SOURCE_CODE, ResourceType.MATLAB_SOURCE_CODE, ResourceType.R_SOURCE_CODE, ResourceType.DATA };
	}
