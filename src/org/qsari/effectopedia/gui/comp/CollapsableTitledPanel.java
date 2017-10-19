package org.qsari.effectopedia.gui.comp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.EventListener;
import java.util.EventObject;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JToggleButton;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.EventListenerList;
import javax.swing.plaf.metal.MetalToggleButtonUI;
import javax.swing.text.DefaultCaret;
import javax.swing.text.Document;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.base.Titleable;
import org.qsari.effectopedia.core.objects.DescriptionSection;
import org.qsari.effectopedia.core.objects.DescriptionSection.ContentFormat;
import org.qsari.effectopedia.core.objects.DescriptionSection_Structured;
import org.qsari.effectopedia.core.objects.Pathway;
import org.qsari.effectopedia.core.objects.PathwayElement;
import org.qsari.effectopedia.core.ui.UserInterface;
import org.qsari.effectopedia.core.ui.WebViewPanel;
import org.qsari.effectopedia.core.ui.nav.UILocation;
import org.qsari.effectopedia.core.ui.nav.UILocations;
import org.qsari.effectopedia.gui.InitializableUI;
import org.qsari.effectopedia.gui.SizeOptimizableUI;
import org.qsari.effectopedia.gui.UIResources;
import org.qsari.effectopedia.gui.core.LoadableEditorUI;
import org.qsari.effectopedia.gui.help.ContextSensitivePanel;
import org.qsari.effectopedia.gui.help.RootHelpContext;
import org.qsari.effectopedia.gui.util.WhiteToggleButton;

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

public class CollapsableTitledPanel extends ContextSensitivePanel implements LoadableEditorUI, DocumentListener, InitializableUI, Runnable, MouseListener, ItemListener, ActionListener,
		ComponentListener
	{
		protected JButton							jbExpand;
		protected JTextField				jtfID;
		protected JLabel								jlID;
		protected JTextField				jtfTitle;
		protected JCheckBox					jcbUseHTML;
		protected JToggleButton	jtbViewHTMLCode;
		protected JPanel								jpDefaultTitlePanel;
		protected JScrollPane			jspDefaultContentEditor;
		protected JTextPane					jtpContent;
		protected WebViewPanel		webViewPanel;
		protected JPanel								jpTitlePanel;
		protected BorderLayout		layout;
		
		/**
		 * Auto-generated main method to display this JPanel inside a new JFrame.
		 */
		
		public static void main(String[] args)
			{
				JFrame frame = new JFrame();
				frame.getContentPane().add(new CollapsableTitledPanel(null, null, true,null));
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				frame.pack();
				frame.setVisible(true);
			}
		
		public CollapsableTitledPanel(JComponent bodyPanel, JComponent titlePanel, boolean expandedByDefault,RootHelpContext rootHelpContext)
			{
				super(rootHelpContext);
				eventListeners = new EventListenerList();
				this.bodyPanel = bodyPanel;
				this.titlePanel = titlePanel;
				useDefaultTitlePanel = titlePanel == null;
				useDefaultBodyPanel = bodyPanel == null;
				this.expanded = expandedByDefault;
				listeners = new EventsManager();
				initGUI();
			}
		
		private void initGUI()
			{
				try
					{
							{
								this.setPreferredSize(optimalSize);
								this.setBackground(Color.WHITE);
								layout = new BorderLayout();
								this.setLayout(layout);
								this.setOpaque(false);
									{
										jpTitlePanel = new JPanel();
										BorderLayout jpTitlePanelLayout = new BorderLayout();
										jpTitlePanel.setLayout(jpTitlePanelLayout);
										jpTitlePanel.setBackground(Color.white);
										jpTitlePanel.setPreferredSize(new java.awt.Dimension(600, 16));
											{
												jbExpand = new JButton(expanded ? collapseAction : expandAction);
												jpTitlePanel.add(jbExpand, BorderLayout.WEST);
												jbExpand.setMaximumSize(buttonSize);
												jbExpand.setMinimumSize(buttonSize);
												jbExpand.setPreferredSize(buttonSize);
												jbExpand.setBackground(Color.white);
												jbExpand.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
												jbExpand.setRolloverIcon(expanded ? UIResources.imageIconCollapseAct : UIResources.imageIconExpandAct);
											}
											{
												if (useDefaultTitlePanel)
													{
														createDefaultTitlePanel();
														titlePanel = jpDefaultTitlePanel;
													}
												jpTitlePanel.add(titlePanel, BorderLayout.CENTER);
												this.add(jpTitlePanel, BorderLayout.NORTH);
												if (useDefaultBodyPanel)
													{
														createDefaultContentPane();
														createDefaultRemoteViewer();
														bodyPanel = jspDefaultContentEditor;
													}
												this.add(bodyPanel, BorderLayout.CENTER);
											}
										
									}
							}
					}
				catch (Exception e)
					{
						e.printStackTrace();
					}
			}
		
		public void loadTitle(Object o, boolean readonly)
			{
				if (!(o instanceof Titleable))
					return;
				if (useDefaultTitlePanel)
					{
						listeners.unbondDocumntListener(jtfTitle.getDocument(), "Title");
						jtfTitle.getDocument().addDocumentListener(this);
						jtfTitle.setText(((Titleable) o).getTitle());
						jtfTitle.setCaretPosition(0);
						jtfTitle.setEditable(!readonly);
						if (o instanceof EffectopediaObject)
							{
								jlID.setText(((EffectopediaObject) o).isDefaultID() ? "DefaultID: " : "ID: ");
								jtfID.setText(((EffectopediaObject) o).getIDandExternalID());
							}
						updateOptimalSize();
						listeners.bondDocumntListener(jtfTitle.getDocument(), o, "Title");
					}
				else if ((titlePanel != null) && (titlePanel instanceof LoadableEditorUI))
					((LoadableEditorUI) titlePanel).load(o, readonly);
			}
		
		public void loadContent()
			{
				loadContent(descriptionSection, descriptionSection.isReadonly());
			}
		
		public void loadContent(Object o, boolean readonly)
			{
				if ((o instanceof DescriptionSection_Structured) && (bodyPanel != null) && (bodyPanel instanceof LoadableEditorUI))
					((LoadableEditorUI) bodyPanel).load(((DescriptionSection_Structured) o).getStructuredContent(), readonly);
				else if (o instanceof DescriptionSection)
					{
						if (descriptionSection == null)
							setShowCode(false);
						descriptionSection = ((DescriptionSection) o);
						setHTML(descriptionSection.isHTML());
						if (jtpContent != null)
							jtpContent.setContentType(isHTML && !showCode ? "text/html" : "text");
						updateHTMLFortmat();
						if (bodyPanel == jspDefaultContentEditor)
							{
								listeners.unbondDocumntListener(jtpContent.getDocument(), "Content");
								jtpContent.getDocument().addDocumentListener(this);
								jtpContent.setText(descriptionSection.getContent());
								jtpContent.setEditable(!readonly && (showCode || !isHTML));
								updateOptimalSize();
								if (!isHTML || showCode)
									listeners.bondDocumntListener(jtpContent.getDocument(), o, "Content");
							}
						else if (bodyPanel == webViewPanel)
							webViewPanel.load(descriptionSection.getContent());
						else if ((bodyPanel != null) && (bodyPanel instanceof LoadableEditorUI))
							((LoadableEditorUI) bodyPanel).load(o, readonly);
					}
				else if ((bodyPanel != null) && (bodyPanel instanceof LoadableEditorUI))
					((LoadableEditorUI) bodyPanel).load(o, readonly);
			}
		
		public void refreshID()
			{
				if ((eo != null) && (useDefaultTitlePanel))
					{
						jtfID.setText(((EffectopediaObject) eo).getIDandExternalID());
						if (!eo.isDefaultID())
							{
								jtfTitle.getDocument().removeDocumentListener(this);
								jlID.setText("ID: ");
								fireDefaultObjectChanged(new EventObject(this));
								defaultObject = false;
							}
					}
			}
		
		public void load(Object o, boolean readonly)
			{
				readonly = readonly || ((EffectopediaObject) o).isReadonly();
				this.eo = (EffectopediaObject) o;
				defaultObject = eo.isDefaultID();
				loadTitle(o, readonly);
				loadContent(o, readonly);
				updateOptimalSize();
			}
		
		public void createDefaultTitlePanel()
			{
				jpDefaultTitlePanel = new JPanel();
				GridBagLayout jpDefaultTitlePanelLayout = new GridBagLayout();
				jpDefaultTitlePanel.setBackground(Color.white);
				jpDefaultTitlePanel.addMouseMotionListener(this);
				jpDefaultTitlePanel.setName("title_panel");
				jpDefaultTitlePanelLayout.rowWeights = new double[]
					{ 0.1 };
				jpDefaultTitlePanelLayout.rowHeights = new int[]
					{ 7 };
				jpDefaultTitlePanelLayout.columnWeights = new double[]
					{ 1.0, 0.0, 0.0, 0.0, 0.1 };
				jpDefaultTitlePanelLayout.columnWidths = new int[]
					{ 481, 2, 2, 20, 20 };
				jpDefaultTitlePanel.setLayout(jpDefaultTitlePanelLayout);
					{
						jtfTitle = new JTextField();
						jpDefaultTitlePanel.add(jtfTitle, new GridBagConstraints(0, 0, 1, 1, 8.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 4, 0, 0), 0, 0));
						jtfTitle.setText("Title");
						jtfTitle.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
						jtfTitle.setFont(new java.awt.Font("Tahoma", 1, 12));
						jtfTitle.setName("title");
					}
					{
						jcbUseHTML = new JCheckBox();
						jpDefaultTitlePanel.add(jcbUseHTML, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jcbUseHTML.setText("use");
						jcbUseHTML.setBackground(Color.white);
						jcbUseHTML.addItemListener(this);
						jcbUseHTML.setName("use_html");
						
					}
					{
						jtbViewHTMLCode = new JToggleButton();
						jpDefaultTitlePanel.add(jtbViewHTMLCode, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(2, 0, 0, 0), 0, 0));
						jtbViewHTMLCode.setIcon(UIResources.imageHTML);
						jtbViewHTMLCode.setRolloverIcon(UIResources.imageHTMLAct);
						jtbViewHTMLCode.setRolloverSelectedIcon(UIResources.imageHTMLAct);
						jtbViewHTMLCode.setSelectedIcon(UIResources.imageHTMLAct);
						jtbViewHTMLCode.setBackground(Color.white);
						jtbViewHTMLCode.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
						jtbViewHTMLCode.setUI(WHITE_TB);
						jtbViewHTMLCode.addActionListener(this);
						jtbViewHTMLCode.setName("view_html");
						
					}
					{
						jlID = new JLabel();
						jpDefaultTitlePanel.add(jlID, new GridBagConstraints(3, 0, 1, 1, 0.5, 0.0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jlID.setText("ID: ");
						jlID.setName("id");
					}
					{
						jtfID = new JTextField();
						jpDefaultTitlePanel.add(jtfID, new GridBagConstraints(4, 0, 1, 1, 1.0, 0.0, GridBagConstraints.EAST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
						jtfID.setText("0");
						jtfID.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
						jtfID.setName("id");
					}
					RootHelpContext.addMouseMotionListeners(jpDefaultTitlePanel, rootHelpContext,true);
			}
		
		public void setContext(String context)
			{
				if (jtfTitle != null)
					jtfTitle.setName("title" + context);
				if (jtpContent != null)
					jtpContent.setName("content" + context);
				if ((!useDefaultBodyPanel)&&(context!=null)&&(context.length()>0))
					bodyPanel.setName(bodyPanel.getName()+context);
			}
		
		public void createDefaultContentPane()
			{
				jspDefaultContentEditor = new JScrollPane();
				jspDefaultContentEditor.setBackground(Color.white);
				jspDefaultContentEditor.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
					{
						jtpContent = new JTextPane();
						jtpContent.setText("");
						jtpContent.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.LIGHT_GRAY));
						jtpContent.addMouseMotionListener(this);
						jtpContent.setName("content");
						sectionDoc = jtpContent.getDocument();
						jspDefaultContentEditor.setViewportView(jtpContent);
						DefaultCaret caret = (DefaultCaret) jtpContent.getCaret();
						caret.setUpdatePolicy(DefaultCaret.OUT_TOP);
					}
			}
		
		public void createDefaultRemoteViewer()
			{
				SwingUtilities.invokeLater(new Runnable()
					{
						@Override
						public void run()
							{
								webViewPanel = UserInterface.getDefaultUIFactory().createWebViewPanel();
								SwingUtilities.invokeLater(new Runnable()
									{
										@Override
										public void run()
											{
												if (descriptionSection != null)
													loadContent(descriptionSection, descriptionSection.isReadonly());
											}
									});
							}
					});
			}
		
		public void updateOptimalSize()
			{
				// TODO Proper estimation of text height need to be performed
				// preferredHeight = sectionDoc != null ? (sectionDoc.getLength() *
				// DEFAULT_HEIGHT_FACTOR / optimalSize.width) : 64;
				// if (titlePanel != null)
				// preferredHeight += titlePanel.getPreferredSize().height;
				if (useDefaultTitlePanel)
					{
						jcbUseHTML.setVisible(expanded && allowHTMLContent);
						jtbViewHTMLCode.setVisible(expanded && allowHTMLContent);
					}
				else
					{
						collapsedHeight = titlePanel.getPreferredSize().height;
						jpTitlePanel.setPreferredSize(new Dimension(optimalSize.width, collapsedHeight));
					}
				if (bodyPanel != null)
					bodyPanel.setVisible(expanded);
				if (!useDefaultBodyPanel)
					optimalSize.height = expanded ? bodyPanel.getPreferredSize().height + collapsedHeight : collapsedHeight;
				else
					optimalSize.height = expanded ? Math.max(preferredHeight, bodyPanel.getPreferredSize().height) + collapsedHeight : collapsedHeight;
				if (getBorder() != null)
					{
						Insets insets = getBorder().getBorderInsets(this);
						optimalSize.height += insets.top + insets.bottom;
					}
				maximalSize.height = optimalSize.height;
				minimalSize.height = optimalSize.height;
				setSize(optimalSize);
				// setMaximumSize(maximalSize);
				// setMinimumSize(minimalSize);
				setPreferredSize(optimalSize);
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
		
		public JComponent getBodyPanel()
			{
				return bodyPanel;
			}
		
		public void setBodyPanel(JComponent bodyPanel)
			{
				this.bodyPanel = bodyPanel;
				if (bodyPanel != null)
					this.add(bodyPanel, BorderLayout.CENTER);
			}
		
		public JComponent getTitlePanel()
			{
				return titlePanel;
			}
		
		public void setTitlePanel(JComponent titlePanel)
			{
				this.useDefaultTitlePanel = titlePanel == null;
				if (this.titlePanel != null)
					jpTitlePanel.remove(this.titlePanel);
				if ((useDefaultTitlePanel) && (jpDefaultTitlePanel == null))
					{
						createDefaultTitlePanel();
						titlePanel = jpDefaultTitlePanel;
					}
				jpTitlePanel.add(titlePanel, BorderLayout.CENTER);
				jpTitlePanel.revalidate();
				this.titlePanel = titlePanel;
			}
		
		public boolean isExpanded()
			{
				return expanded;
			}
		
		public void setExpanded(boolean expanded)
			{
				this.expanded = expanded;
				if (expanded)
					jbExpand.setAction(collapseAction);
				else
					jbExpand.setAction(expandAction);
				jbExpand.setRolloverIcon(expanded ? UIResources.imageIconCollapseAct : UIResources.imageIconExpandAct);
				updateOptimalSize();
			}
		
		public class TitleAction extends AbstractAction
			{
				
				/**
			 * 
			 */
				private static final long	serialVersionUID	= 1L;
				
				public TitleAction(ImageIcon icon)
					{
						super("", icon);
					}
				
				public void actionPerformed(ActionEvent arg0)
					{
						jbExpand.setVisible(collapsable);
						if (collapsable)
							{
								expanded = !expanded;
								if (expanded)
									jbExpand.setAction(collapseAction);
								else
									jbExpand.setAction(expandAction);
								jbExpand.setRolloverIcon(expanded ? UIResources.imageIconCollapseAct : UIResources.imageIconExpandAct);
								updateOptimalSize();
								revalidate();
								repaint();
							}
					}
			}
		
		@Override
		public void changedUpdate(DocumentEvent arg0)
			{
				if (defaultObject)
					refreshID();
				SwingUtilities.invokeLater(this);
			}
		
		@Override
		public void insertUpdate(DocumentEvent arg0)
			{
				if (defaultObject)
					refreshID();
				SwingUtilities.invokeLater(this);
			}
		
		@Override
		public void removeUpdate(DocumentEvent arg0)
			{
				if (defaultObject)
					refreshID();
				SwingUtilities.invokeLater(this);
			}
		
		public void run()
			{
				if ((sectionDoc != null) && (Math.abs(sectionCharLength - sectionDoc.getLength()) > SIGNIFICANT_LENGHT_CHANCE))
					sectionCharLength = sectionDoc.getLength();
				if (bodyPanel == jspDefaultContentEditor)
					{
						int minH = jtpContent.getMinimumSize().height + 18;
						preferredHeight = jtpContent.getPreferredSize().height + 18;
						if (preferredHeight < minH)
							;
						preferredHeight = minH;
						if (preferredHeight < minimumHeight)
							preferredHeight = minimumHeight;
					}
				else if (bodyPanel == webViewPanel)
					preferredHeight = defaultBrowserHeight;
				updateOptimalSize();
			}
		
		public void initializeUI()
			{
				if (bodyPanel == jspDefaultContentEditor)
					{
						javax.swing.SwingUtilities.invokeLater(new Runnable()
							{
								public void run()
									{
										jspDefaultContentEditor.getViewport().setViewPosition(TOPLEFT);
									}
							});
						SwingUtilities.invokeLater(this);
					}
			}
		
		public void updateHTMLFortmat()
			{
				if (!useDefaultBodyPanel || (descriptionSection == null) || (!isHTML))
					return;
				boolean remote = WhiteList.isWhiteListed(descriptionSection.getContent());
				if (remote)
					descriptionSection.setFormat(ContentFormat.REMOTE_HTML);
				else
					descriptionSection.setFormat(ContentFormat.HTML);
				if (remote && !showCode)
					{
						if (webViewPanel == null)
							{
								createDefaultRemoteViewer();
								return;
							}
						else
							bodyPanel = (JComponent) webViewPanel;
					}
				else
					bodyPanel = jspDefaultContentEditor;
				Component comp = layout.getLayoutComponent(BorderLayout.CENTER);
				if (comp != bodyPanel)
					{
						this.remove(comp);
						this.add(bodyPanel, BorderLayout.CENTER);
						SwingUtilities.invokeLater(this);
					}
			}
		
		@Override
		public void itemStateChanged(ItemEvent event)
			{
				if (descriptionSection != null)
					{
						setHTML(((JCheckBox) event.getSource()).isSelected());
						loadContent(descriptionSection, descriptionSection.isReadonly());
					}
				else
					isHTML = ((JCheckBox) event.getSource()).isSelected();
				if ((!useDefaultBodyPanel) && (bodyPanel != null))
					for (Component cont : bodyPanel.getComponents())
						if (cont instanceof Container)
							for (Component c : ((Container) cont).getComponents())
								if (c instanceof CollapsableTitledPanel)
									{
										CollapsableTitledPanel panel = ((CollapsableTitledPanel) c);
										if (panel.useDefaultBodyPanel)
											{
												panel.setHTML(isHTML);
												panel.loadContent();
											}
									}
			}
		
		@Override
		public void actionPerformed(ActionEvent action)
			{
				showCode = ((JToggleButton) (action.getSource())).getModel().isSelected();
				if (descriptionSection != null)
					loadContent(descriptionSection, descriptionSection.isReadonly());
				if ((!useDefaultBodyPanel) && (bodyPanel != null))
					for (Component cont : bodyPanel.getComponents())
						if (cont instanceof Container)
							for (Component c : ((Container) cont).getComponents())
								if (c instanceof CollapsableTitledPanel)
									{
										CollapsableTitledPanel panel = ((CollapsableTitledPanel) c);
										if (panel.useDefaultBodyPanel)
											panel.setShowCode(showCode);
										panel.loadContent();
									}
				
			}
		
		@Override
		public void mouseClicked(MouseEvent e)
			{
				if ((allowRedirecting) && (e.getClickCount() == 2))
					if ((eo instanceof PathwayElement) || (eo instanceof Pathway))
						{
							UILocation location = UILocations.getProperEditor(eo);
							location.setReadOnly(eo.isReadonly());
							UserInterface.getDefaultNavigator().navigate(location, eo);
						}
			}
		
		@Override
		public void mouseEntered(MouseEvent arg0)
			{
				
			}
		
		@Override
		public void mouseExited(MouseEvent arg0)
			{
				
			}
		
		@Override
		public void mousePressed(MouseEvent arg0)
			{
				
			}
		
		@Override
		public void mouseReleased(MouseEvent arg0)
			{
				
			}
		
		public boolean isAllowRedirecting()
			{
				return allowRedirecting;
			}
		
		public void setAllowRedirecting(boolean allowRedirecting)
			{
				this.allowRedirecting = allowRedirecting;
				if (useDefaultTitlePanel)
					{
						if (allowRedirecting)
							{
								jtfTitle.addMouseListener(this);
								jlID.addMouseListener(this);
								jtfID.addMouseListener(this);
							}
						else
							{
								jtfTitle.removeMouseListener(this);
								jlID.removeMouseListener(this);
								jtfID.removeMouseListener(this);
							}
					}
			}
		
		public boolean isAllowHTMLContent()
			{
				return allowHTMLContent;
			}
		
		public void setAllowHTMLContent(boolean allowHTMLContent)
			{
				this.allowHTMLContent = allowHTMLContent;
			}
		
		public interface DefaultObjectChangeListener extends EventListener
			{
				public void defaultObjectChanged(EventObject evt);
			}
		
		public void addDefaultObjectChangeListener(DefaultObjectChangeListener listener)
			{
				eventListeners.add(DefaultObjectChangeListener.class, listener);
			}
		
		public void removeDefaultObjectChangeListener(DefaultObjectChangeListener listener)
			{
				eventListeners.remove(DefaultObjectChangeListener.class, listener);
			}
		
		protected void fireDefaultObjectChanged(EventObject evt)
			{
				DefaultObjectChangeListener[] listeners = eventListeners.getListeners(DefaultObjectChangeListener.class);
				for (int i = 0; i < listeners.length; i++)
					listeners[i].defaultObjectChanged(evt);
			}
		
		public int getPreferredHeight()
			{
				return preferredHeight;
			}
		
		public void setPreferredHeight(int preferredHeight)
			{
				this.preferredHeight = preferredHeight;
				updateOptimalSize();
			}
		
		public CollapsableTitledPanel setInset(int left, int right)
			{
				this.setBorder(new EmptyBorder(0, left, 0, right));
				return this;
			}
		
		public boolean isHTML()
			{
				return isHTML;
			}
		
		public void setHTML(boolean isHTML)
			{
				this.isHTML = isHTML;
				if (isHTML)
					updateHTMLFortmat();
				else
					descriptionSection.setFormat(ContentFormat.TEXT);
			}
		
		public boolean isShowCode()
			{
				return showCode;
			}
		
		public void setShowCode(boolean showCode)
			{
				this.showCode = showCode;
				if (jtbViewHTMLCode != null)
					jtbViewHTMLCode.setSelected(showCode);
				else if (descriptionSection != null)
					loadContent(descriptionSection, descriptionSection.isReadonly());
			}
		
		public boolean isCollapsable()
			{
				return collapsable;
			}
		
		public void setCollapsable(boolean collapsable)
			{
				this.collapsable = collapsable;
				jbExpand.setVisible(collapsable);
			}
		
		@Override
		public void componentResized(ComponentEvent e)
			{
				optimalSize.width = getParent().getWidth() - 16;
				SwingUtilities.invokeLater(this);
			}
		
		@Override
		public void componentMoved(ComponentEvent e)
			{
				// TODO Auto-generated method stub
				
			}
		
		@Override
		public void componentShown(ComponentEvent e)
			{
				// TODO Auto-generated method stub
				
			}
		
		@Override
		public void componentHidden(ComponentEvent e)
			{
				// TODO Auto-generated method stub
				
			}
		
		/**
		 * 
		 */
		private static final long									serialVersionUID										= 1L;
		
		private final MetalToggleButtonUI	WHITE_TB																		= new WhiteToggleButton();
		
		protected boolean																	isHTML																				= false;
		protected boolean																	showCode																		= false;
		
		protected boolean																	useDefaultTitlePanel						= true;
		protected boolean																	useDefaultBodyPanel							= true;
		
		private final static int										SIGNIFICANT_LENGHT_CHANCE	= 50;
		// private final static int DEFAULT_HEIGHT_FACTOR = 41;
		private int																							sectionCharLength									= -1;
		private boolean																			allowRedirecting										= false;
		private boolean																			allowHTMLContent										= true;
		private DescriptionSection								descriptionSection								= null;
		private Document																		sectionDoc;
		protected boolean																	defaultObject													= false;
		protected EventListenerList							eventListeners;
		
		protected boolean																	expanded;
		protected boolean																	collapsable															= true;
		protected EffectopediaObject						eo;
		protected Action																		expandAction														= new TitleAction(UIResources.imageIconExpand);
		protected Action																		collapseAction												= new TitleAction(UIResources.imageIconCollapse);
		protected EventsManager											listeners;
		protected JComponent														bodyPanel;
		protected JComponent														titlePanel;
		protected int																					collapsedHeight											= 18;
		protected int																					minimumHeight													= 180;
		protected final int															defaultBrowserHeight						= 600;
		protected int																					preferredHeight											= minimumHeight;
		protected Dimension															optimalSize															= new java.awt.Dimension(600, preferredHeight);
		protected Dimension															maximalSize															= new java.awt.Dimension(Integer.MAX_VALUE, 18);
		protected Dimension															minimalSize															= new java.awt.Dimension(64, 18);
		protected static Dimension								buttonSize																= new java.awt.Dimension(16, 16);
		
	}
