package org.qsari.effectopedia.gui.toolbars;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.WindowConstants;

import org.openide.awt.DropDownToggleButton;
import org.qsari.effectopedia.defaults.DefaultGOSettings;
import org.qsari.effectopedia.gui.AdjustableUI;
import org.qsari.effectopedia.gui.UIResources;
import org.qsari.effectopedia.gui.im.InterfaceMode;
import org.qsari.effectopedia.gui.im.InterfaceModeConstants;
import org.qsari.effectopedia.gui.im.InterfaceModes;
import org.qsari.effectopedia.gui.im.InterfaceModes.InterfaceModeUpdate;
import org.qsari.effectopedia.gui.im.InterfaceModes.InterfaceModeUpdateListener;
import org.qsari.effectopedia.gui.im.PathwayElementTypeCycler;

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
public class PathwaySpaceToolbarUI extends javax.swing.JToolBar implements AdjustableUI, InterfaceModeUpdateListener
	{
		/**
		* 
		*/
		private static final long				serialVersionUID										= 1L;
		private JPopupMenu											jpmSubstance;
		private JPopupMenu											jpmEffect;
		private JPopupMenu											jpmTest;
		private JPopupMenu											jpmLinearSegment;
		
		private DropDownToggleButton	ddtbChemical;
		private JToggleButton								jtbLink;
		private DropDownToggleButton	ddtbEffect;
		private DropDownToggleButton	ddtbTest;
		private DropDownToggleButton	ddtbLinearSegment;
		private JToggleButton								jtbCLET;
		private JToggleButton								jtbPathwayWizard;
		private JToggleButton								jtbChemicalWizard;
		private JToggleButton								jtbUpstreamEffectWizard;
		private JToggleButton								jtbDownstreamEffectWizard;
		private JToggleButton								jtbZoomIn;
		private JToggleButton								jtbZoomOut;
		private JToggleButton								jtbDrag;
		private JToggleButton								jtbEdit;
		private ButtonGroup										buttonGroup;
		private JToolBar.Separator			jtbsSeparator1;
		private JToolBar.Separator			jtbsSeparator2;
		private static String[] WIZARD_CONTEXT = {"pw","cw","uew","dew"};
		
		public static final int						CHEMICAL																		= 0x0001;
		public static final int						LINK																						= 0x0002;
		public static final int						EFFECT																				= 0x0004;
		public static final int						TEST																						= 0x0008;
		public static final int						CHEMICAL_LINK_EFFECT_TEST	= 0x0010;
		public static final int						PATHWAY_WIZARD												= 0x0020;
		public static final int						CHEMICAL_WIZARD											= 0x0040;
		public static final int						UPSTREAM_CAUSE_WIZARD					= 0x0080;
		public static final int						DOWNSTREAM_EFFECT_WIZARD		= 0x0100;
		public static final int						ZOOM_IN																			= 0x0200;
		public static final int						ZOOM_OUT																		= 0x0400;
		public static final int						DRAG																						= 0x0800;
		public static final int						EDIT																						= 0x1000;
		
		public static final int						SINGLE																				= 0x001F;
		public static final int						WIZARD																				= 0x01E0;
		public static final int						ALL																							= 0xFFFF;
		
		public static void main(String[] args)
			{
				JFrame frame = new JFrame();
				frame.getContentPane().add(new PathwaySpaceToolbarUI(PathwaySpaceToolbarUI.ALL));
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				frame.pack();
				frame.setVisible(true);
			}
			
		public PathwaySpaceToolbarUI()
			{
				super();
				this.visibleButtons = ALL;
				modes = new ArrayList<InterfaceModes>();
				initGUI();
			}
			
		public PathwaySpaceToolbarUI(int buttons)
			{
				super();
				modes = new ArrayList<InterfaceModes>();
				this.visibleButtons = buttons;
				initGUI();
			}
			
		private void initGUI()
			{
				try
					{
						this.setPreferredSize(new java.awt.Dimension(540, 36));
						this.setMinimumSize(new java.awt.Dimension(36, 36));
						buttonGroup = new ButtonGroup();
						imap = getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
						Action defaultAction;

						jtbCLET = createButton("clet",
								assignKey(new ModeAction("new chemical, link, event or test", UIResources.imageNewElementWizard, "Create new chemical, link, event or test", InterfaceModeConstants.NEW_CHEM_LNK_EFEECT_TEST, 0), "T"),
								CHEMICAL_LINK_EFFECT_TEST);
						
						jpmSubstance = new JPopupMenu();
						jpmSubstance.add(defaultAction = new ModeAction("New chemical", UIResources.imageNewChemical, "Create new parent chemical", InterfaceModeConstants.NEW_CHEMICAL, 0));
						jpmSubstance.add(new ModeAction("New structural alert", UIResources.imageNewStructuralAlert, "Create new structural alert", InterfaceModeConstants.NEW_CHEMICAL, 1));
						jpmSubstance.add(new ModeAction("New biological perturbation", UIResources.imageNewBiologicalPerturbation, "Create new biological perturbation", InterfaceModeConstants.NEW_CHEMICAL, 2));
						
						ddtbChemical = createDropDownButton("chemical", UIResources.imageNewChemical, jpmSubstance, CHEMICAL, defaultAction);
						
						jtbLink = createButton("link", assignKey(new ModeAction("new link", UIResources.imageNewLink, "Create new link between existing elements", InterfaceModeConstants.NEW_LINK, 0), "L"), LINK);
						
						jpmEffect = new JPopupMenu();
						jpmEffect.add(new ModeAction("New molecular initiating event", UIResources.imageNewMIE, "Create new molecular initiating event", InterfaceModeConstants.NEW_EFFECT, 0));
						jpmEffect.add(defaultAction = new ModeAction("New (key) event", UIResources.imageNewEffect, "Create new (key) event", InterfaceModeConstants.NEW_EFFECT, 1));
						jpmEffect.add(new ModeAction("New endpoint", UIResources.imageNewEndpoint, "Create new endpoint", InterfaceModeConstants.NEW_EFFECT, 2));
						jpmEffect.add(new ModeAction("New adverse outcome", UIResources.imageNewAdverseOutcome, "Create new adverse outcome", InterfaceModeConstants.NEW_EFFECT, 3));
						ddtbEffect = createDropDownButton("event", UIResources.imageNewEffect, jpmEffect, EFFECT, defaultAction);
						
						jpmTest = new JPopupMenu();
						jpmTest.add(defaultAction = new ModeAction("New in-chemico/in-vitro test", UIResources.imageNewTest, "Create in-chemico/in-vitro new test", InterfaceModeConstants.NEW_TEST, 0));
						jpmTest.add(new ModeAction("New in-vivo/ex-vivo test", UIResources.imageNewInvivoTest, "Create new in-vivo/ex-vivo test", InterfaceModeConstants.NEW_TEST, 2));
						jpmTest.add(new ModeAction("New in-silico model", UIResources.imageNewModel, "Create new in-silico model", InterfaceModeConstants.NEW_TEST, 4));
						jpmTest.add(new ModeAction("New test response mapping", UIResources.imageNewTestResponseMapping, "Create new test response mapping", InterfaceModeConstants.NEW_TEST, 5));
						
						ddtbTest = createDropDownButton("test", UIResources.imageNewTest, jpmTest, TEST, defaultAction);
						if ((visibleButtons & SINGLE) != 0)
							add(jtbsSeparator1 = new Separator());
						
						
						jpmLinearSegment = new JPopupMenu();
						jpmLinearSegment.add(
								defaultAction = new ModeAction("new pathway wizard", UIResources.imagePathwayWizard, "Create new pathway between a chemical and selected outcome", InterfaceModeConstants.PATHWAY_WIZARD, 0));
						jpmLinearSegment.add(new ModeAction("new chemical wizard", UIResources.imageChemicalWizard, "Create new segment starting with a chemical", InterfaceModeConstants.CHEMICAL_WIZARD, 0));
						jpmLinearSegment.add(new ModeAction("new upstream cause wizard", UIResources.imageUpstreamEffectWizard, "Link new upstream cause to the currently selected effect",
								InterfaceModeConstants.UPSTREAM_CAUSE_WIZARD, 0));
						jpmLinearSegment.add(new ModeAction("new downstream effect wizard", UIResources.imageDownstreamEffectWizard, "Link new downstream effect to the currently selected",
								InterfaceModeConstants.DOWNSTREAM_EFFECT_WIZARD, 0));
						
						ddtbLinearSegment = createDropDownButton("pw", UIResources.imagePathwayWizard, jpmLinearSegment, PATHWAY_WIZARD, defaultAction);
						/*
						 * 
						 * jtbPathwayWizard = createButton("pw", assignKey(new
						 * ModeAction("new pathway wizard", UIResources.imagePathwayWizard,
						 * "Create new pathway between a chemical and selected outcome",
						 * InterfaceModeConstants.PATHWAY_WIZARD, 0), "ctrl P"), PATHWAY_WIZARD);
						 * 
						 * jtbChemicalWizard = createButton("cw", assignKey(new
						 * ModeAction("new chemical wizard", UIResources.imageChemicalWizard,
						 * "Add new chemical related to the selected effect",
						 * InterfaceModeConstants.CHEMICAL_WIZARD, 0), "ctrl S"),
						 * CHEMICAL_WIZARD);
						 * 
						 * jtbUpstreamEffectWizard = createButton("uew", assignKey( new
						 * ModeAction("new upstream cause wizard",
						 * UIResources.imageUpstreamEffectWizard,
						 * "Link new upstream cause to the currently selected effect",
						 * InterfaceModeConstants.UPSTREAM_CAUSE_WIZARD, 0), "ctrl U"),
						 * UPSTREAM_CAUSE_WIZARD);
						 * 
						 * jtbDownstreamEffectWizard = createButton("dew", assignKey(new
						 * ModeAction("new downstream effect wizard",
						 * UIResources.imageDownstreamEffectWizard,
						 * "Link new downstream effect to the currently selected",
						 * InterfaceModeConstants.DOWNSTREAM_EFFECT_WIZARD, 0), "ctrl E"),
						 * DOWNSTREAM_EFFECT_WIZARD);
						 */
						if ((visibleButtons & WIZARD) != 0)
							add(jtbsSeparator2 = new Separator());
						
						jtbZoomIn = createButton("zoom_in", assignKey(new ModeAction("zoom in", UIResources.imageZoomIn, "Zoom in", InterfaceModeConstants.ZOOM_IN, 0), "+"), ZOOM_IN);
						jtbZoomOut = createButton("zoom_out", assignKey(new ModeAction("zoom out", UIResources.imageZoomOut, "Zoom out", InterfaceModeConstants.ZOOM_OUT, 0), "-"), ZOOM_OUT);
						jtbDrag = createButton("drag", assignKey(new ModeAction("drag", UIResources.imageDrag, "Drag canvas or object", InterfaceModeConstants.DRAG, 0), "ctrl D"), DRAG);
						jtbEdit = createButton("edit", assignKey(new ModeAction("edit", UIResources.imageEdit, "Edit", InterfaceModeConstants.EDIT, 0), "ctrl E"), EDIT);
					}
				catch (Exception e)
					{
						e.printStackTrace();
					}
			}
			
		public class ModeAction extends AbstractAction
			{
				/**
				* 
				*/
				private static final long serialVersionUID = 1L;
				
				public ModeAction(String actionName, Icon icon, String hint, int modeIndex, int cyclerIndex)
					{
						putValue(Action.NAME, actionName);
						putValue(Action.SMALL_ICON, icon);
						putValue("modeIndex", modeIndex);
						putValue("cyclerIndex", cyclerIndex);
						putValue(Action.SHORT_DESCRIPTION, hint);
					}
					
				public void actionPerformed(ActionEvent event)
					{
						modeIndex = (Integer) getValue("modeIndex");
						for (InterfaceModes m : modes)
							{
								if (m != null)
									{
										m.setActiveMode(modeIndex);
										m.getActiveMode().setCyclerElementIndex((Integer) getValue("cyclerIndex"));
									}
								if (modeIndex == InterfaceModeConstants.NEW_CHEMICAL)
									{
										ddtbChemical.setIcon((Icon) getValue(Action.SMALL_ICON));
										ddtbChemical.setPressedIcon((Icon) getValue(Action.SMALL_ICON));
										ddtbChemical.setToolTipText((String) getValue(Action.SHORT_DESCRIPTION));
										ddtbChemical.setAction(this);
										buttonGroup.setSelected(ddtbChemical.getModel(), true);
									}
								else if (modeIndex == InterfaceModeConstants.NEW_EFFECT)
									{
										ddtbEffect.setIcon((Icon) getValue(Action.SMALL_ICON));
										ddtbEffect.setPressedIcon((Icon) getValue(Action.SMALL_ICON));
										ddtbEffect.setToolTipText((String) getValue(Action.SHORT_DESCRIPTION));
										ddtbEffect.setAction(this);
										buttonGroup.setSelected(ddtbEffect.getModel(), true);
									}
								else if (modeIndex == InterfaceModeConstants.NEW_TEST)
									{
										ddtbTest.setIcon((Icon) getValue(Action.SMALL_ICON));
										ddtbTest.setPressedIcon((Icon) getValue(Action.SMALL_ICON));
										ddtbTest.setToolTipText((String) getValue(Action.SHORT_DESCRIPTION));
										ddtbTest.setAction(this);
										buttonGroup.setSelected(ddtbTest.getModel(), true);
									}
								else if ((modeIndex >= InterfaceModeConstants.PATHWAY_WIZARD) && (modeIndex <= InterfaceModeConstants.DOWNSTREAM_EFFECT_WIZARD))
									{
										ddtbLinearSegment.setIcon((Icon) getValue(Action.SMALL_ICON));
										ddtbLinearSegment.setPressedIcon((Icon) getValue(Action.SMALL_ICON));
										ddtbLinearSegment.setName(WIZARD_CONTEXT[modeIndex-InterfaceModeConstants.PATHWAY_WIZARD]);
										ddtbLinearSegment.setToolTipText((String) getValue(Action.SHORT_DESCRIPTION));
										ddtbLinearSegment.setAction(this);
										buttonGroup.setSelected(ddtbLinearSegment.getModel(), true);
									}
							}
					}
					
			}
			
		public void interfaceModeUpdated(InterfaceModeUpdate evt)
			{
				if (modes == null)
					return;
				for (InterfaceModes m : modes)
					{
						int seqenceIndex = m.getPathwayElementTypeCycler().getSequenceIndex();
						int elementIndex = m.getPathwayElementTypeCycler().getElementIndex();
						try
							{
								JMenuItem item;
								if (seqenceIndex == PathwayElementTypeCycler.SEQUENCE_SUBSTANCE_CYCLE)
									{
										item = (JMenuItem) jpmSubstance.getComponent(elementIndex);
										ddtbChemical.setIcon(item.getIcon());
										ddtbChemical.setToolTipText(item.getToolTipText());
									}
								else if (seqenceIndex == PathwayElementTypeCycler.SEQUENCE_EFFECT_CYCLE)
									{
										item = (JMenuItem) jpmEffect.getComponent(elementIndex);
										ddtbEffect.setIcon(item.getIcon());
										ddtbEffect.setToolTipText(item.getToolTipText());
									}
							}
						catch (Exception e)
							{
								;
							}
					}
			}
			
		private Action assignKey(Action action, String key)
			{
				String actionName = (String) action.getValue(Action.NAME);
				imap.put(KeyStroke.getKeyStroke(key), actionName);
				getActionMap().put(actionName, action);
				return action;
			}
			
		private JToggleButton createButton(String name, Action action, int buttonType)
			{
				if ((visibleButtons & buttonType) != 0)
					{
						JToggleButton button = new JToggleButton(action);
						add(button);
						button.setHideActionText(DefaultGOSettings.hideActionText);
						button.setFocusPainted(false);
						button.setName(name);
						buttonGroup.add(button);
						return button;
					}
				return null;
			}
			
		private DropDownToggleButton createDropDownButton(String name, Icon icon, JPopupMenu popup, int buttonType, Action action)
			{
				if ((visibleButtons & buttonType) != 0)
					{
						DropDownToggleButton button = new DropDownToggleButton(icon, popup);
						add(button);
						button.setAction(action);
						button.setHideActionText(DefaultGOSettings.hideActionText);
						button.setFocusPainted(false);
						button.setName(name);
						buttonGroup.add(button);
						return button;
					}
				return null;
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
			
		public void setDefaultMode()
			{
				if ((jtbDrag != null) && (modes != null))
					jtbDrag.doClick();
				for (InterfaceModes m : modes)
					m.update();
			}
			
		public JToggleButton getButton(int button)
			{
				switch (button)
					{
						case CHEMICAL:
							return ddtbChemical;
						case LINK:
							return jtbLink;
						case EFFECT:
							return ddtbEffect;
						case TEST:
							return ddtbTest;
						case CHEMICAL_LINK_EFFECT_TEST:
							return jtbCLET;
						case PATHWAY_WIZARD:
							return jtbPathwayWizard;
						case CHEMICAL_WIZARD:
							return jtbChemicalWizard;
						case UPSTREAM_CAUSE_WIZARD:
							return jtbUpstreamEffectWizard;
						case DOWNSTREAM_EFFECT_WIZARD:
							return jtbDownstreamEffectWizard;
						case ZOOM_IN:
							return jtbZoomIn;
						case ZOOM_OUT:
							return jtbZoomOut;
						case DRAG:
							return jtbDrag;
						case EDIT:
							return jtbEdit;
					}
				return null;
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
			
		public InterfaceModes getDefaultModes()
			{
				if (modes.size() > 0)
					return modes.get(0);
				else
					return null;
			}
			
		public void addModes(InterfaceModes modes)
			{
				this.modes.add(modes);
				addKeyListener(modes);
				modes.addInterfaceModeUpdateListener(this);
			}
			
		public void addMouseMotionListener(MouseMotionListener l)
			{
				super.addMouseMotionListener(l);
				for (Component c : getComponents())
					if ((c != null) && (c instanceof JToggleButton))
						((JToggleButton) c).addMouseMotionListener(l);
			}
			
		public int getModeIndex()
			{
				return modeIndex;
			}
			
		public InterfaceMode getActiveMode()
			{
				return modes.get(0).getActiveMode();
			}
			
		public void setReadOnly(boolean readonly)
			{
				boolean visible = !readonly;
				ddtbChemical.setVisible(visible);
				jtbLink.setVisible(visible);
				ddtbEffect.setVisible(visible);
				ddtbTest.setVisible(visible);
				jtbsSeparator1.setVisible(visible);
				jtbCLET.setVisible(visible);
				/*
				 * jtbPathwayWizard.setVisible(visible);
				 * jtbChemicalWizard.setVisible(visible);
				 * jtbUpstreamEffectWizard.setVisible(visible);
				 * jtbDownstreamEffectWizard.setVisible(visible);
				 */
				ddtbLinearSegment.setVisible(visible);
				jtbsSeparator2.setVisible(visible);
			}
			
		private ArrayList<InterfaceModes>	modes;
		private InputMap																		imap;
		private int																							modeIndex	= -1;
		private int																							visibleButtons;
		
	}
