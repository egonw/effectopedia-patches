package org.qsari.effectopedia.gui.obj_prop;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;

import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.WindowConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.qsari.effectopedia.base.ids.IDs;
import org.qsari.effectopedia.data.objects.Resource;
import org.qsari.effectopedia.gui.UIResources;
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
public class ResourcesUI extends ContextSensitivePanel implements LoadableEditorUI, ChangeListener
	{
		public static void main(String[] args)
			{
				JFrame frame = new JFrame();
				frame.setContentPane(new ResourcesUI(null));
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				frame.pack();
				frame.setVisible(true);
			}
		
		public ResourcesUI(RootHelpContext rootHelpContext)
			{
				super(rootHelpContext);
				initGUI();
				load(null, true);
			}
		
		private void initGUI()
			{
				try
					{
							{
								this.setPreferredSize(new java.awt.Dimension(660, 440));
								BorderLayout thisLayout = new BorderLayout();
								this.setLayout(thisLayout);
								this.setBackground(Color.WHITE);
									{
										jtpResources = new JTabbedPane();
										jtpResources.setBackground(Color.WHITE);
										this.add(jtpResources, BorderLayout.CENTER);
										jtpResources.setTabPlacement(JTabbedPane.TOP);
										jtpResources.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
										this.add(jtpResources, BorderLayout.CENTER);
										jtpResources.addChangeListener(this);
										jtpResources.addMouseListener(new MouseAdapter()
											{
												@Override
												public void mouseClicked(java.awt.event.MouseEvent e)
													{
														Rectangle rect = jtpResources.getUI().getTabBounds(jtpResources, jtpResources.getSelectedIndex());
														editingIdx = jtpResources.getSelectedIndex();
														Component c = jtpResources.getTabComponentAt(editingIdx);
														if (c instanceof ResourceTab)
															if (rect.contains(e.getPoint()) && e.getClickCount() == 2)
																((ResourceTab) c).startEditing();
															else
																((ResourceTab) c).renameTabTitle();
													}
											});
									}
							}
					}
				catch (Exception e)
					{
						e.printStackTrace();
					}
			}
		
		@SuppressWarnings("unchecked")
		@Override
		public void load(Object o, boolean readonly)
			{
				if (o instanceof IDs)
					resourceIDs = (IDs<Resource>) o;
				updateTabs();
			}
		
		protected void updateTabs()
			{
				jtpResources.removeAll();
				jtpResources.addTab("", new Instructions());
				new AddResourceButton();
				if (resourceIDs != null)
					{
						Resource[] res = resourceIDs.getCachedObjects();
						for (Resource resource : res)
							{
								ResourceUI resTab = new ResourceUI(jtpResources,rootHelpContext);
								resTab.load(resource, resource.isReadonly());
								int index = jtpResources.getTabCount() - 1;
								jtpResources.insertTab(resource.getName(), null, resTab, resource.getName(), index);
								new ResourceTab(index);
							}
						jtpResources.setSelectedIndex(0);
					}
			}
		
		class AddResourceButton extends JPanel implements ActionListener
			{
				public AddResourceButton()
					{
						setOpaque(false);
						JButton jbAdd = new JButton(UIResources.imageIconAdd);
						jbAdd.setPreferredSize(buttonSize);
						add(jbAdd);
						jbAdd.addActionListener(this);
						int lastIndex = jtpResources.getTabCount() - 1;
						jtpResources.setTabComponentAt(lastIndex>=0?lastIndex:0, this);
					}
				
				public void actionPerformed(ActionEvent e)
					{
						String resourceName = "Resource Name " + jtpResources.getTabCount();
						ResourceUI resTab = new ResourceUI(jtpResources,rootHelpContext);
						int index = jtpResources.getTabCount() - 1;
						jtpResources.insertTab(resourceName, null, resTab, resourceName, index);
						jtpResources.setSelectedIndex(index);
						new ResourceTab(index);
						if (resourceIDs != null)
							{
								Resource resource = new Resource(resourceIDs.getParent(), resourceIDs.getDataSource());
								resource.setName(resourceName);
								resourceIDs.add(resource);
								resTab.load(resource, resource.isReadonly());
							}
					}
				
				private static final long	serialVersionUID	= 1L;
			}
		
		public class ResourceTab extends JPanel implements ActionListener
			{
				private int							titleLength	= -1;
				private Dimension	editorSize;
				
				public ResourceTab(int index)
					{
						this.setOpaque(false);
						jlTabTitle = new JLabel(jtpResources.getTitleAt(index), jtpResources.getIconAt(index), JLabel.LEFT);
						this.add(jlTabTitle);
						jtfTabTitle = new JTextField(jtpResources.getTitleAt(index));
						jtfTabTitle.setVisible(false);
						jtfTabTitle.setOpaque(false);
						this.add(jtfTabTitle);
						jtfTabTitle.setBorder(BorderFactory.createEmptyBorder());
						jtfTabTitle.addFocusListener(new FocusAdapter()
							{
								@Override
								public void focusLost(FocusEvent e)
									{
										if (titleLength > 0)
											renameTabTitle();
									}
							});
						jtfTabTitle.addKeyListener(new KeyAdapter()
							{
								@Override
								public void keyPressed(KeyEvent e)
									{
										if (e.getKeyCode() == KeyEvent.VK_ENTER)
											renameTabTitle();
										else if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
											cancelEditing();
										else
											{
												jtfTabTitle.setPreferredSize(jtfTabTitle.getText().length() > titleLength ? null : editorSize);
												jtpResources.revalidate();
											}
									}
							});
						jtpResources.getInputMap(JComponent.WHEN_FOCUSED).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "start-editing");
						jtpResources.getActionMap().put("start-editing", new AbstractAction()
							{
								@Override
								public void actionPerformed(ActionEvent e)
									{
										startEditing();
									}
							});
						
						JButton jbRemove = new JButton(UIResources.imageIconDelete);
						jbRemove.setPreferredSize(buttonSize);
						this.add(jbRemove);
						jbRemove.addActionListener(this);
						jtpResources.setTabComponentAt(index, this);
					}
				
				public void actionPerformed(ActionEvent e)
					{
						int i = jtpResources.indexOfTabComponent(this);
						if (i != -1)
							{
								jtpResources.remove(i);
								if (resourceIDs != null)
									resourceIDs.remove(i - 1);
							}
					}
				
				protected void startEditing()
					{
						jlTabTitle.setVisible(false);
						jtfTabTitle.setVisible(true);
						jtfTabTitle.setText(jtpResources.getTitleAt(editingIdx));
						jtfTabTitle.selectAll();
						jtfTabTitle.requestFocusInWindow();
						titleLength = jtfTabTitle.getText().length();
						editorSize = jtfTabTitle.getPreferredSize();
						jtfTabTitle.setMinimumSize(editorSize);
					}
				
				protected void cancelEditing()
					{
						if (editingIdx >= 0)
							{
								jtfTabTitle.setVisible(false);
								jlTabTitle.setVisible(true);
								editingIdx = -1;
								titleLength = -1;
								jtfTabTitle.setPreferredSize(null);
								jtpResources.requestFocusInWindow();
							}
					}
				
				protected void renameTabTitle()
					{
						String title = jtfTabTitle.getText().trim();
						if (editingIdx >= 0 && !title.isEmpty())
							{
								jlTabTitle.setText(title);
								Component c = jtpResources.getComponentAt(editingIdx);
								if (c instanceof ResourceUI)
									((ResourceUI) c).resouceUpdate(title);
							}
						cancelEditing();
					}
				
				public void setTitle(String title)
					{
						jtfTabTitle.setText(title);
						jlTabTitle.setText(title);
						Component c = jtpResources.getComponentAt(editingIdx);
						if (c instanceof ResourceUI)
							((ResourceUI) c).resouceUpdate(title);
					}
				
				private JLabel												jlTabTitle;
				private JTextField								jtfTabTitle;
				private static final long	serialVersionUID	= 1L;
			}
		
		protected class Instructions extends JPanel
			{
				public Instructions()
					{
						super();
						this.setBackground(Color.white);
						instructions = new JTextArea(
								"Add new resouce by clicking on the \"+\" button in the header of this tab.\nTo remove resource click on the \"-\" button next to the resource name in the tab header\nDouble click on the resouce name to change it");
						this.add(instructions);
					}
				protected JTextArea							instructions;
				private static final long	serialVersionUID	= 1L;
			}
		
		
		@Override
		public void stateChanged(ChangeEvent e)
			{
				editingIdx = jtpResources.getSelectedIndex();
				if (editingIdx >= 0)
					{
						Component c = jtpResources.getTabComponentAt(editingIdx);
						if (c instanceof ResourceTab)
							((ResourceTab) c).renameTabTitle();
					}
			}
		
		private int															editingIdx							= -1;
		protected IDs<Resource>			resourceIDs;
		protected JTabbedPane					jtpResources;
		private final Dimension			buttonSize							= new Dimension(19, 19);
		private static final long	serialVersionUID	= 1L;
	}
