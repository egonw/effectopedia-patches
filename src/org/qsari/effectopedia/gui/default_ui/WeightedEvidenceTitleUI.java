package org.qsari.effectopedia.gui.default_ui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.WindowConstants;
import javax.swing.plaf.basic.BasicComboBoxUI;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.base.Titleable;
import org.qsari.effectopedia.base.ids.ReferenceIDW;
import org.qsari.effectopedia.core.objects.DescriptionSection;
import org.qsari.effectopedia.core.objects.DescriptionSection_Structured;
import org.qsari.effectopedia.core.objects.Link_EffectToEffect;
import org.qsari.effectopedia.core.ui.UserInterface;
import org.qsari.effectopedia.core.ui.nav.UILocation;
import org.qsari.effectopedia.core.ui.nav.UILocations;
import org.qsari.effectopedia.defaults.DefaultGOSettings;
import org.qsari.effectopedia.gui.UIResources;
import org.qsari.effectopedia.gui.comp.CollapsableTitledPanel;
import org.qsari.effectopedia.gui.help.RootHelpContext;
import org.qsari.effectopedia.gui.util.WhiteToggleButton;

public class WeightedEvidenceTitleUI extends EffectopediaObjectTitleUI implements MouseListener
	{
		
		/**
		* 
		*/
		private static final long							serialVersionUID	= 1L;
		protected JLabel																jlStreingth;
		protected JCheckBox													jcbUseHTML;
		protected JToggleButton									jtbViewHTMLCode;
		protected JComboBox<String>					jcbStreingth;
		protected EssentialityWeightsLM	essentialityLM;
		
		public static void main(String[] args)
			{
				JFrame frame = new JFrame();
				frame.getContentPane().add(new WeightedEvidenceTitleUI(null));
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				frame.pack();
				frame.setVisible(true);
			}
			
		public WeightedEvidenceTitleUI()
			{
				super(null);
				setName("woe");
			}
			
		public WeightedEvidenceTitleUI(RootHelpContext rootHelpContext)
			{
				super(rootHelpContext);
				setName("woe");
			}
			
		@Override
		protected void initGUI()
			{
				try
					{
						this.setPreferredSize(optimalSize);
						jpDefaultTitlePanelLayout = new GridBagLayout();
						this.setBackground(Color.WHITE);
						jpDefaultTitlePanelLayout.rowWeights = new double[]
							{ 0.1 };
						jpDefaultTitlePanelLayout.rowHeights = new int[]
							{ 7 };
						jpDefaultTitlePanelLayout.columnWeights = new double[]
							{ 1.0, 0.1, 0.2, 0.0, 0.0, 0.1, 0.1 };
						jpDefaultTitlePanelLayout.columnWidths = new int[]
							{ 240, 20, 40, 30, 40, 20, 20 };
						this.setLayout(jpDefaultTitlePanelLayout);
							{
								jtfTitle = new JTextField();
								this.add(jtfTitle, new GridBagConstraints(0, 0, 1, 1, 6.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 4, 0, 0), 0, 0));
								jtfTitle.setText("Title");
								jtfTitle.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
								jtfTitle.setFont(new java.awt.Font("Tahoma", 1, 12));
								jtfTitle.setName("title");
							}
							
							{
								jlStreingth = new JLabel();
								this.add(jlStreingth, new GridBagConstraints(1, 0, 1, 1, 0.1, 0.0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
								jlStreingth.setText("");
								jlStreingth.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
								jlStreingth.setFont(new java.awt.Font("Segoe UI", 2, 12));
								jlStreingth.setVisible(false);
								jlStreingth.setName("streingth");
							}
							
							{
								essentialityLM = new EssentialityWeightsLM();
								jcbStreingth = new JComboBox<String>(essentialityLM);
								jcbStreingth.setMinimumSize(new Dimension(100, 24));
								jcbStreingth.setUI(new BasicComboBoxUI());
								jcbStreingth.setForeground(DefaultGOSettings.captionColor);
								this.add(jcbStreingth, new GridBagConstraints(2, 0, 1, 1, 1.5, 0.0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(2, 0, 0, 0), 0, 0));
								jcbStreingth.setName("streingth");
							}
							
							{
								jcbUseHTML = new JCheckBox();
								this.add(jcbUseHTML, new GridBagConstraints(3, 0, 1, 1, 0.0, 0.0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
								jcbUseHTML.setText("use");
								jcbUseHTML.setBackground(Color.white);
								jcbUseHTML.setName("use_html");
							}
							
							{
								jtbViewHTMLCode = new JToggleButton();
								this.add(jtbViewHTMLCode, new GridBagConstraints(4, 0, 1, 1, 0.0, 0.0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(2, 0, 0, 0), 0, 0));
								jtbViewHTMLCode.setIcon(UIResources.imageHTML);
								jtbViewHTMLCode.setRolloverIcon(UIResources.imageHTMLAct);
								jtbViewHTMLCode.setRolloverSelectedIcon(UIResources.imageHTMLAct);
								jtbViewHTMLCode.setSelectedIcon(UIResources.imageHTMLAct);
								jtbViewHTMLCode.setBackground(Color.white);
								jtbViewHTMLCode.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
								jtbViewHTMLCode.setUI(new WhiteToggleButton());
								jtbViewHTMLCode.setName("view_code");
							}
							{
								jlID = new JLabel();
								this.add(jlID, new GridBagConstraints(5, 0, 1, 1, 0.5, 0.0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
								jlID.setText("ID: ");
								jlID.setName("id");
							}
							{
								jtfID = new JTextField();
								this.add(jtfID, new GridBagConstraints(6, 0, 1, 1, 1.0, 0.0, GridBagConstraints.EAST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
								jtfID.setText("0");
								jtfID.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
								jtfID.setName("id");
							}
							RootHelpContext.addMouseMotionListeners(this, rootHelpContext,false);
					}
				catch (Exception e)
					{
						e.printStackTrace();
					}
			}
			
		@Override
		public void load(Object o, boolean readonly)
			{
				if (!(o instanceof Titleable))
					return;
				if ((showUseHTMLInterface) && (panel == null))
					addHTMLInterfaceListener();
				listeners.unbondDocumntListener(jtfTitle.getDocument(), "Title");
				boolean titleSet = false;
				setAllowRedirecting(true);
				dSec = null;
				if ((useReferenceObjectDescriptiveTitle) && (o instanceof DescriptionSection_Structured))
					{
						Object object = ((DescriptionSection_Structured) o).getStructuredContent();
						if (object instanceof ReferenceIDW<?>)
							{
								object = ((ReferenceIDW<?>) object).getCachedObject();
								if (object instanceof Link_EffectToEffect)
									{
										jtfTitle.setText(((Link_EffectToEffect) object).getDescriptiveTitle());
										jtfTitle.setToolTipText(jtfTitle.getText());
										jtfTitle.setCaretPosition(0);
										jtfTitle.setEditable(false);
										dSec = (DescriptionSection_Structured) o;
										titleSet = true;
									}
							}
					}
				if (!titleSet)
					{
						jtfTitle.setText(((Titleable) o).getTitle());
						jtfTitle.setToolTipText(jtfTitle.getText());
						jtfTitle.setCaretPosition(0);
						jtfTitle.setEditable(!readonly);
					}
				if (o instanceof EffectopediaObject)
					{
						jlID.setText(((EffectopediaObject) o).isDefaultID() ? "DefaultID: " : "ID: ");
						jtfID.setText(((EffectopediaObject) o).getIDandExternalID());
						if (o instanceof DescriptionSection_Structured)
							{
								essentialityLM.load((DescriptionSection_Structured) o, ((EffectopediaObject) o).isReadonly());
								dSec = (DescriptionSection_Structured) o;
							}
					}
				if (o instanceof DescriptionSection)
					{
						jlID.setText(((EffectopediaObject) o).isDefaultID() ? "DefaultID: " : "ID: ");
						jtfID.setText(((EffectopediaObject) o).getIDandExternalID());
						if (o instanceof DescriptionSection_Structured)
							{
								essentialityLM.load((DescriptionSection_Structured) o, ((EffectopediaObject) o).isReadonly());
								dSec = (DescriptionSection_Structured) o;
							}
					}
					
				if (!titleSet)
					listeners.bondDocumntListener(jtfTitle.getDocument(), o, "Title");
			}
			
		private void addHTMLInterfaceListener()
			{
				Container parent = getParent();
				while ((parent != null) && !(parent instanceof CollapsableTitledPanel))
					parent = parent.getParent();
				if (parent instanceof CollapsableTitledPanel)
					{
						panel = (CollapsableTitledPanel) parent;
						jcbUseHTML.addItemListener(panel);
						jtbViewHTMLCode.addActionListener(panel);
					}
			}
			
		public boolean isUseReferenceObjectDescriptiveTitle()
			{
				return useReferenceObjectDescriptiveTitle;
			}
			
		public void setUseReferenceObjectDescriptiveTitle(boolean useReferenceObjectDescriptiveTitle)
			{
				this.useReferenceObjectDescriptiveTitle = useReferenceObjectDescriptiveTitle;
			}
			
		@Override
		public void mouseClicked(MouseEvent e)
			{
				if ((dSec != null) && (e.getClickCount() == 2))
					{
						Object sObj = dSec.getStructuredContent();
						if ((sObj instanceof ReferenceIDW<?>))
							{
								EffectopediaObject eo = ((ReferenceIDW<?>) sObj).getCachedObject();
								UILocation location = UILocations.getProperEditor(eo);
								location.setReadOnly(eo.isReadonly());
								UserInterface.getDefaultNavigator().navigate(location, eo);
							}
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
			
		public boolean isShowUseHTMLInterface()
			{
				return showUseHTMLInterface;
			}
			
		public void setShowUseHTMLInterface(boolean showUseHTMLInterface)
			{
				if (showUseHTMLInterface)
					{
						addHTMLInterfaceListener();
						jpDefaultTitlePanelLayout.columnWidths[3] = 30;
						jpDefaultTitlePanelLayout.columnWidths[4] = 40;
					}
				else
					{
						jpDefaultTitlePanelLayout.columnWidths[3] = 0;
						jpDefaultTitlePanelLayout.columnWidths[4] = 0;
					}
				jcbUseHTML.setVisible(showUseHTMLInterface);
				jtbViewHTMLCode.setVisible(showUseHTMLInterface);
				
				this.showUseHTMLInterface = showUseHTMLInterface;
			}
			
		private GridBagLayout																			jpDefaultTitlePanelLayout;
		private CollapsableTitledPanel										panel																														= null;
		private boolean																									showUseHTMLInterface															= true;
		private boolean																									allowRedirecting;
		protected Dimension																					optimalSize																								= new java.awt.Dimension(600, 28);
		protected DescriptionSection_Structured	dSec																															= null;
		private boolean																									useReferenceObjectDescriptiveTitle	= false;
		
	}
