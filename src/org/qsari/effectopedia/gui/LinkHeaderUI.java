package org.qsari.effectopedia.gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventListener;
import java.util.EventObject;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.event.EventListenerList;

import org.qsari.effectopedia.core.objects.Link;
import org.qsari.effectopedia.core.objects.Link.LinkNature;
import org.qsari.effectopedia.core.objects.Link.LinkType;
import org.qsari.effectopedia.core.objects.Link_EffectToEffect;
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
public class LinkHeaderUI extends EffectopediaObjectHeaderUI<Link> implements AdjustableUI, LoadableEditorUI, SizeOptimizableUI, ActionListener
	{
		/**
		* 
		*/
		private static final long					serialVersionUID	= 1L;
		private JLabel																jlLinkNature;
		private JLabel																jlLinkTitle;
		private JTextField												jtfLinkID;
		private JLabel																jlLinkID;
		private JComboBox<LinkNature>	jcbLinkNature;
		private FeedbackToolbarUI					ftbuiLink;
		
		/**
		 * Auto-generated main method to display this JPanel inside a new JFrame.
		 */
		public static void main(String[] args)
			{
				JFrame frame = new JFrame();
				frame.getContentPane().add(new LinkHeaderUI(null));
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				frame.pack();
				frame.setVisible(true);
			}
			
		public LinkHeaderUI(RootHelpContext rootHelpContext)
			{
				super(rootHelpContext);
				setName("header");
				listeners = new EventsManager();
				eventListeners = new EventListenerList();
				initGUI(EFFECT_TO_EFFECT);
			}
			
		public LinkHeaderUI(LinkNature[] linkTypes, RootHelpContext rootHelpContext)
			{
				super(rootHelpContext);
				setName("header");
				listeners = new EventsManager();
				eventListeners = new EventListenerList();
				initGUI(linkTypes);
			}
			
		private void initGUI(LinkNature[] linkTypes)
			{
				try
					{
						GridBagLayout thisLayout = new GridBagLayout();
						thisLayout.rowWeights = new double[]
							{ 1.0, 1.0 };
						thisLayout.rowHeights = new int[]
							{ 20, 20 };
						thisLayout.columnWeights = new double[]
							{ 0.0, 1.0, 0.0, 0.0, 0.0, 1.0 };
						thisLayout.columnWidths = new int[]
							{ 74, 140, 94, 81, 20, 80 };
						this.setPreferredSize(new java.awt.Dimension(400, 80));
						this.setLayout(thisLayout);
						this.setBackground(Color.WHITE);
							{
								htfTitle = new HintedTextField();
								this.add(htfTitle, new GridBagConstraints(1, 0, 3, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
								htfTitle.setText("Type Link Title Here");
								htfTitle.setFont(new java.awt.Font("Segoe UI", 1, 12));
								htfTitle.addMouseListener(this);
								htfTitle.setName("title");
							}
							{
								jlLinkTitle = new JLabel();
								this.add(jlLinkTitle, new GridBagConstraints(0, 0, 1, 1, 3.0, 0.0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 0, 0, 2), 0, 0));
								jlLinkTitle.setText("Title");
								jlLinkTitle.setName("title");
							}
							{
								jlLinkNature = new JLabel();
								this.add(jlLinkNature, new GridBagConstraints(0, 1, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(2, 0, 0, 2), 0, 0));
								jlLinkNature.setText("Link Nature");
								jlLinkNature.setName("nature");
							}
							{
								ComboBoxModel<LinkNature> jcbLinkTypeModel = new DefaultComboBoxModel<LinkNature>(linkTypes);
								jcbLinkNature = new JComboBox<LinkNature>();
								this.add(jcbLinkNature, new GridBagConstraints(1, 1, 1, 1, 2.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
								jcbLinkNature.setModel(jcbLinkTypeModel);
								jcbLinkNature.setMinimumSize(new java.awt.Dimension(120, 18));
								jcbLinkNature.setBackground(Color.WHITE);
								jcbLinkNature.setEditable(true);
								jcbLinkNature.addActionListener(this);
								jcbLinkNature.setName("nature");
							}
							{
								jlLinkID = new JLabel();
								this.add(jlLinkID, new GridBagConstraints(3, 0, 1, 1, 0.5, 0.0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(2, 0, 0, 2), 0, 0));
								jlLinkID.setText("ID");
								jlLinkID.setName("id");
							}
							{
								jtfLinkID = new JTextField();
								this.add(jtfLinkID, new GridBagConstraints(5, 0, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
								jtfLinkID.setText("auto");
								jtfLinkID.setEditable(false);
								jtfLinkID.setName("id");
							}
							{
								ftbuiLink = new FeedbackToolbarUI("link", FeedbackToolbarUI.INTERACT, FlowLayout.RIGHT);
								this.add(ftbuiLink, new GridBagConstraints(5, 1, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 2), 0, 0));
							}
							{
								jlLinkType = new JLabel();
								this.add(jlLinkType, new GridBagConstraints(2, 1, 1, 1, 0.5, 0.0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
								jlLinkType.setText(" Type:");
								jlLinkType.setName("type");
							}
							{
								ComboBoxModel<LinkType> jcbmLinkType = new DefaultComboBoxModel<LinkType>(LINK_TYPES);
								jcbLinkType = new JComboBox<LinkType>();
								this.add(jcbLinkType, new GridBagConstraints(3, 1, 2, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
								jcbLinkType.setModel(jcbmLinkType);
								jcbLinkType.setMinimumSize(new java.awt.Dimension(120, 18));
								jcbLinkType.setBackground(Color.WHITE);
								jcbLinkType.setEditable(true);
								jcbLinkType.addActionListener(this);
								jcbLinkType.setName("type");
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
						jlLinkNature.setVisible((visualOptions & LABELS) == LABELS);
						jlLinkType.setVisible((visualOptions & LABELS) == LABELS);
						jlLinkID.setVisible((visualOptions & LABELS) == LABELS);
						jlLinkTitle.setVisible((visualOptions & LABELS) == LABELS);
						jtfLinkID.setVisible((visualOptions & AUTOIDS) == AUTOIDS);
					}
				else
					{
						setVisible(false);
					}
			}
			
		public void load(Object o, boolean readonly)
			{
				if (!(o instanceof Link))
					return;
				loading = true;
				listeners.unbondDocumntListener(htfTitle.getDocument(), "Title");
				eo = (Link) o;
				jtfLinkID.setText(eo.getIDandExternalID());
				if (eo instanceof Link_EffectToEffect)
					htfTitle.setText(((Link_EffectToEffect) eo).getDescriptiveTitle());
				else
					htfTitle.setText(eo.getTitle());
				jcbLinkNature.setSelectedItem(eo.getLinkNature());
				jcbLinkType.setSelectedItem(eo.getLinkType());
				
				htfTitle.setEditable(!readonly);
				jcbLinkNature.setEditable(!readonly);
				jcbLinkNature.setEnabled(!readonly);
				
				updateOptimalSize();
				listeners.bondDocumntListener(htfTitle.getDocument(), eo, "Title");
				ftbuiLink.load(eo, readonly);
				loading = false;
			}
			
		public void updateOptimalSize()
			{
				Container parent = getParent();
				optimalSize.width = parent.getLayout().preferredLayoutSize(parent).width;
				optimalSize.height = jlLinkTitle.getPreferredSize().height + jcbLinkNature.getPreferredSize().height;
				this.setPreferredSize(optimalSize);
				// setMaximumSize(optimalSize);
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
			
		public class LinkTypeChange extends EventObject
			{
				/**
				* 
				*/
				private static final long serialVersionUID = 1L;
				
				public LinkTypeChange(Object source)
					{
						super(source);
					}
			}
			
		public interface LinkTypeChangeListener extends EventListener
			{
				public void LinkTypeChanged(LinkTypeChange evt);
			}
			
		public void addLinkTypeChangeListener(LinkTypeChangeListener listener)
			{
				eventListeners.add(LinkTypeChangeListener.class, listener);
			}
			
		public void removeLinkTypeChangeListener(LinkTypeChangeListener listener)
			{
				eventListeners.remove(LinkTypeChangeListener.class, listener);
			}
			
		protected void fireLinkTypeChanged(LinkTypeChange evt)
			{
				LinkTypeChangeListener[] listeners = eventListeners.getListeners(LinkTypeChangeListener.class);
				for (int i = 0; i < listeners.length; i++)
					listeners[i].LinkTypeChanged(evt);
			}
			
		public void actionPerformed(ActionEvent arg0)
			{
				if (loading)
					return;
				Object source = arg0.getSource();
				if (eo != null)
					{
						if (source == jcbLinkNature)
							eo.setLinkNature((LinkNature) jcbLinkNature.getModel().getSelectedItem());
						else if (source == jcbLinkType)
							eo.setLinkType((LinkType) jcbLinkType.getModel().getSelectedItem());
						fireLinkTypeChanged(new LinkTypeChange(this));
					}
			}
			
		public LinkNature getLinkNature()
			{
				return (LinkNature) jcbLinkNature.getModel().getSelectedItem();
			}
			
		private Dimension											optimalSize						= new Dimension(400, 80);
		private boolean													loading										= false;
		private EventsManager							listeners;
		private JComboBox<LinkType>	jcbLinkType;
		private JLabel														jlLinkType;
		public static LinkNature[]		EFFECT_TO_EFFECT	= new LinkNature[]
			{ LinkNature.HYPOTHETICAL, LinkNature.HARDWIRE, LinkNature.LINEAR, LinkNature.THRESHOLD, LinkNature.RESPONSE_RESPONSE };
		public static LinkNature[]		MIE_TO_EFFECT				= new LinkNature[]
			{ LinkNature.HYPOTHETICAL, LinkNature.DOSE_RESPONSE };
			
		public static LinkType[]				LINK_TYPES							= new LinkType[]
			{ LinkType.UNKNOWN, LinkType.DIRECT, LinkType.INDIRECT };
		protected EventListenerList	eventListeners;
		
	}
