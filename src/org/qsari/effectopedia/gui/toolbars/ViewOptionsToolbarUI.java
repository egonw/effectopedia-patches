package org.qsari.effectopedia.gui.toolbars;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JPopupMenu;
import javax.swing.WindowConstants;

import org.openide.awt.DropDownButton;
import org.qsari.effectopedia.defaults.DefaultGOSettings;
import org.qsari.effectopedia.go.Layout.BasicLayout;
import org.qsari.effectopedia.go.Layout.HorizontalAlignment;
import org.qsari.effectopedia.go.Layout.VerticalAlignment;
import org.qsari.effectopedia.go.pathway_elements.ChemicalSPEGO;
import org.qsari.effectopedia.go.pathway_elements.DisplaySection;
import org.qsari.effectopedia.go.pathway_elements.EffectCPEGO;
import org.qsari.effectopedia.gui.AdjustableUI;
import org.qsari.effectopedia.gui.PathwaySpaceUI;
import org.qsari.effectopedia.gui.UIResources;

public class ViewOptionsToolbarUI extends javax.swing.JToolBar implements AdjustableUI
	{
		/**
	 * 
	 */
		private static final long			serialVersionUID				= 1L;
		private JPopupMenu										jpmHAligments;
		private JPopupMenu										jpmVAligments;
		private JPopupMenu										jpmEffectDisplayOptions;
		private JPopupMenu										jpmChemicalDisplayOptions;
		private DropDownButton						jtbHAligment;
		private DropDownButton						jtbVAligment;
		private DropDownButton						jtbEffectDisplayOptions;
		private DropDownButton						jtbChemicalDisplayOptions;
		private EffectDisplayOption	edoAbbriviatedTitle;
		private EffectDisplayOption	edoFullTitle;
		private EffectDisplayOption	edoID;
		
		public static final int					HORIZONTAL_ALIGMENT	= 0x0001;
		public static final int					VERTICAL_ALIGMENT			= 0x0002;
		public static final int					EFFECT_VIS_OPT						= 0x0004;
		public static final int					CHEMICAL_VIS_OPT				= 0x0008;
		
		public static final int					ALL																	= 0xFFFF;
		
		public static void main(String[] args)
			{
				JFrame frame = new JFrame();
				frame.getContentPane().add(new ViewOptionsToolbarUI(null, ViewOptionsToolbarUI.ALL));
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				frame.pack();
				frame.setVisible(true);
			}
		
		public ViewOptionsToolbarUI(PathwaySpaceUI pathwaySpaceUI)
			{
				super();
				this.pathwaySpaceUI = pathwaySpaceUI;
				this.visibleButtons = ALL;
				initGUI();
			}
		
		public ViewOptionsToolbarUI(PathwaySpaceUI pathwaySpaceUI, int buttons)
			{
				super();
				this.pathwaySpaceUI = pathwaySpaceUI;
				this.visibleButtons = buttons;
				initGUI();
			}
		
		private void initGUI()
			{
				try
					{
						this.setPreferredSize(new java.awt.Dimension(600, 36));
						this.setMinimumSize(new java.awt.Dimension(36, 36));
						
						jpmHAligments = new JPopupMenu();
						jpmHAligments.add(new AlignHorizontally("Center Horizontally", UIResources.imageHACenter, HorizontalAlignment.CENTER, "Center pathway elements horizontally"));
						jpmHAligments.add(new AlignHorizontally("Align Elements Left", UIResources.imageHALeft, HorizontalAlignment.LEFT, "Align pathway elements to the left"));
						jpmHAligments.add(new AlignHorizontally("Align Elements Right", UIResources.imageHARight, HorizontalAlignment.RIGHT, "Align pathway elements to the right"));
						jpmHAligments.add(new AlignHorizontally("Fill Horizontally", UIResources.imageHAFill, HorizontalAlignment.FILL, "Strech pathway elements to fill the available space horizontally"));
						
						jtbHAligment = createButton("h_layout",UIResources.imageHACenter, jpmHAligments, HORIZONTAL_ALIGMENT);
						
						jpmVAligments = new JPopupMenu();
						jpmVAligments.add(new AlignVertically("Middle Aligin", UIResources.imageVAMiddle, VerticalAlignment.MIDDLE, "Center pathway elements vertically"));
						jpmVAligments.add(new AlignVertically("Top Aligin", UIResources.imageVATop, VerticalAlignment.TOP, "Align pathway elements to the top"));
						jpmVAligments.add(new AlignVertically("Bottom Aligin", UIResources.imageVABottom, VerticalAlignment.BOTTOM, "Align pathway elements to the bottom"));
						jpmVAligments.add(new AlignVertically("Fill Vertically", UIResources.imageVAFill, VerticalAlignment.FILL, "Strech pathway elements to fill the available space vertically"));
						
						jtbVAligment = createButton("v_layout",UIResources.imageVAMiddle, jpmVAligments, VERTICAL_ALIGMENT);
						
						jpmChemicalDisplayOptions = new JPopupMenu();
						jpmChemicalDisplayOptions.add(new ChemicalDisplayOption("Abbriviated title", DisplaySection.ABBRIVIATED_TITLE, true, "Show truncated chemical name on a single line").getCheckBox());
						jpmChemicalDisplayOptions.add(new ChemicalDisplayOption("Quality assurance", DisplaySection.QUALITY_ASSURANCE, false, "Show Chemical quality assurance fields").getCheckBox());
						jpmChemicalDisplayOptions.add(new ChemicalDisplayOption("2D Structure", DisplaySection.CHEMICAL_2D_STRUCTURE, true, "Show 2D depiction of the chemical structure").getCheckBox());
						jpmChemicalDisplayOptions.add(new ChemicalDisplayOption("Chemical information", DisplaySection.CHEMICAL_INFO, true, "Show chemical information").getCheckBox());
						jpmChemicalDisplayOptions.add(new ChemicalDisplayOption("Chemical properties", DisplaySection.CHEMICAL_PROPERTIES, true, "Show list of measured and calculated chemical properties")
								.getCheckBox());
						jpmChemicalDisplayOptions.add(new ChemicalDisplayOption("Associated pathways", DisplaySection.PATHWAY_ASSOCIATIONS, false, "Show list of pathway associations").getCheckBox());
						jpmChemicalDisplayOptions.add(new ChemicalDisplayOption("References", DisplaySection.REFERENCES, false, "Show chemical property and information references").getCheckBox());
						
						jtbChemicalDisplayOptions = createButton("chem_vis_opt",UIResources.imageChemicalDispOpt, jpmChemicalDisplayOptions, CHEMICAL_VIS_OPT);
						jtbChemicalDisplayOptions.setToolTipText("Customize the Chemical display options");
						
						jpmEffectDisplayOptions = new JPopupMenu();
						edoAbbriviatedTitle = new EffectDisplayOption("Abbriviated title", DisplaySection.ABBRIVIATED_TITLE, false, "Show truncated effect title on a single line");
						jpmEffectDisplayOptions.add(edoAbbriviatedTitle.getCheckBox());
						edoFullTitle = new EffectDisplayOption("Full title", DisplaySection.FULL_TITLE, true, "Show the complete effect title");
						jpmEffectDisplayOptions.add(edoFullTitle.getCheckBox());
						edoID = new EffectDisplayOption("Identifier", DisplaySection.EXTERNAL_ID, true, "Show the external identification numner (ID) in the effect title");
						jpmEffectDisplayOptions.add(edoID.getCheckBox());
						jpmEffectDisplayOptions.add(new EffectDisplayOption("Groups & Keywords", DisplaySection.GROUPS_AND_KEYWORDS, false, "Show groups and kewords if any").getCheckBox());
						jpmEffectDisplayOptions.add(new EffectDisplayOption("Quality Assurance", DisplaySection.QUALITY_ASSURANCE, false, "Show effect quality assurance fields").getCheckBox());
						jpmEffectDisplayOptions.add(new EffectDisplayOption("Description", DisplaySection.DESCRIPTION_SECTION, true, "Show first description section").getCheckBox());
						jpmEffectDisplayOptions.add(new EffectDisplayOption("Context", DisplaySection.CONTEXT, true, "Show effect context").getCheckBox());
						jpmEffectDisplayOptions.add(new EffectDisplayOption("Associated Pathways", DisplaySection.PATHWAY_ASSOCIATIONS, false, "Show list of pathway associations").getCheckBox());
						jpmEffectDisplayOptions.add(new EffectDisplayOption("References", DisplaySection.REFERENCES, true, "Show description references").getCheckBox());
						
						jtbEffectDisplayOptions = createButton("eff_vis_opt",UIResources.imageEffectDispOpt, jpmEffectDisplayOptions, EFFECT_VIS_OPT);
						jtbEffectDisplayOptions.setToolTipText("Customize the effect display options");
					}
				catch (Exception e)
					{
						e.printStackTrace();
					}
			}
		
		@SuppressWarnings("serial")
		public class AlignHorizontally extends AbstractAction
			{
				
				public AlignHorizontally(String actionName, Icon icon, HorizontalAlignment aligment, String description)
					{
						putValue(Action.NAME, actionName);
						putValue(Action.SMALL_ICON, icon);
						this.aligment = aligment;
						putValue(Action.SHORT_DESCRIPTION, description);
					}
				
				public void actionPerformed(ActionEvent event)
					{
						if (view != null)
							{
								view.setHorizontalElementAlignment(aligment);
								view.update();
								pathwaySpaceUI.getPahwayScrollPaneUI().repaint();
							}
						jtbHAligment.setIcon((Icon) getValue(Action.SMALL_ICON));
					}
				
				private HorizontalAlignment	aligment;
			}
		
		@SuppressWarnings("serial")
		public class AlignVertically extends AbstractAction
			{
				
				public AlignVertically(String actionName, Icon icon, VerticalAlignment aligment, String description)
					{
						putValue(Action.NAME, actionName);
						putValue(Action.SMALL_ICON, icon);
						this.aligment = aligment;
						putValue(Action.SHORT_DESCRIPTION, description);
					}
				
				public void actionPerformed(ActionEvent event)
					{
						if (view != null)
							{
								view.setVerticalElementAlignment(aligment);
								view.update();
								pathwaySpaceUI.getPahwayScrollPaneUI().repaint();
							}
						jtbVAligment.setIcon((Icon) getValue(Action.SMALL_ICON));
					}
				
				private VerticalAlignment	aligment;
			}
		
		@SuppressWarnings("serial")
		public class PathwayElementDisplayOption extends AbstractAction
			{
				
				public PathwayElementDisplayOption(String actionName, int option, boolean enabled, String description)
					{
						putValue(Action.NAME, actionName);
						this.option = option;
						this.enabled = enabled;
						putValue(Action.SHORT_DESCRIPTION, description);
					}
				
				public JCheckBoxMenuItem getCheckBox()
					{
						if (checkBox == null)
							checkBox = new JCheckBoxMenuItem(this);
						checkBox.setState(enabled);
						return checkBox;
					}
				
				public void actionPerformed(ActionEvent event)
					{
						if (view != null)
							{
								enabled = !enabled;
								view.getGlobalGOC().update();
								pathwaySpaceUI.getPahwayScrollPaneUI().repaint();
							}
					}
				
				protected void setOptionEnabled(boolean enabled)
					{
						this.enabled = enabled;
						getCheckBox().setState(enabled);
					}
				
				protected int															option;
				protected boolean											enabled;
				protected JCheckBoxMenuItem	checkBox;
			}
		
		@SuppressWarnings("serial")
		public class EffectDisplayOption extends ViewOptionsToolbarUI.PathwayElementDisplayOption
			{
				
				public EffectDisplayOption(String actionName, int option, boolean enabled, String description)
					{
						super(actionName, option, enabled, description);
					}
				
				public void actionPerformed(ActionEvent event)
					{
						if (view != null)
							{
								enabled = !enabled;
								if (enabled)
									EffectCPEGO.displayOptions = EffectCPEGO.displayOptions | option;
								else
									EffectCPEGO.displayOptions = EffectCPEGO.displayOptions & (0xFFFF ^ option);
								if ((this == edoAbbriviatedTitle) && (enabled))
									edoFullTitle.disableOption();
								if ((this == edoFullTitle) && (enabled))
									edoAbbriviatedTitle.disableOption();
								view.getGlobalGOC().update();
								pathwaySpaceUI.getPahwayScrollPaneUI().repaint();
							}
					}
				
				protected void disableOption()
					{
						this.enabled = false;
						getCheckBox().setState(false);
						EffectCPEGO.displayOptions = EffectCPEGO.displayOptions & (0xFFFF ^ this.option);
					}
			}
		
		@SuppressWarnings("serial")
		public class ChemicalDisplayOption extends ViewOptionsToolbarUI.PathwayElementDisplayOption
			{
				
				public ChemicalDisplayOption(String actionName, int option, boolean enabled, String description)
					{
						super(actionName, option, enabled, description);
					}
				
				public void actionPerformed(ActionEvent event)
					{
						if (view != null)
							{
								enabled = !enabled;
								if (enabled)
									ChemicalSPEGO.displayOptions = ChemicalSPEGO.displayOptions | option;
								else
									ChemicalSPEGO.displayOptions = ChemicalSPEGO.displayOptions & (0xFFFF ^ option);
								view.getGlobalGOC().update();
								pathwaySpaceUI.getPahwayScrollPaneUI().repaint();
							}
					}
			}
		
		private DropDownButton createButton(String name,Icon icon, JPopupMenu popup, int buttonType)
			{
				if ((visibleButtons & buttonType) != 0)
					{
						DropDownButton button = new DropDownButton(icon, popup);
						add(button);
						button.setHideActionText(DefaultGOSettings.hideActionText);
						button.setFocusPainted(false);
						button.setName(name);
						return button;
					}
				return null;
			}

		public void addMouseMotionListener(MouseMotionListener l)
			{
				super.addMouseMotionListener(l);
				for (Component c : getComponents())
					if ((c != null) && (c instanceof DropDownButton))
						((DropDownButton) c).addMouseMotionListener(l);
			}

		public void updatePrefferedSize()
			{
				Dimension d = new Dimension(0, 0);
				if (getOrientation() == HORIZONTAL)
					for (Component c : getComponents())
						{
							Dimension componentDimension = c.getPreferredSize();
							d.width += componentDimension.width;
							if (d.height < componentDimension.height)
								d.height = componentDimension.height;
						}
				else
					for (Component c : getComponents())
						{
							Dimension componentDimension = c.getPreferredSize();
							d.height += componentDimension.height;
							if (d.width < componentDimension.width)
								d.width = componentDimension.width;
						}
				setPreferredSize(d);
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
				this.setVisible((visualOptions & LIST_TOOLBARS) != 0);
			}
		
		public DropDownButton getJtbHAligment()
			{
				return jtbHAligment;
			}
		
		public DropDownButton getJtbVAligment()
			{
				return jtbVAligment;
			}
		
		public BasicLayout getView()
			{
				return view;
			}
		
		public void setView(BasicLayout view)
			{
				this.view = view;
			}
		
		private int												visibleButtons;
		private BasicLayout				view;
		private PathwaySpaceUI	pathwaySpaceUI;
		
	}
