package org.qsari.effectopedia.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.HashMap;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.KeyStroke;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.core.objects.Effect;
import org.qsari.effectopedia.core.objects.Effect_AdverseOutcome;
import org.qsari.effectopedia.core.objects.Effect_DownstreamEffect;
import org.qsari.effectopedia.core.objects.Effect_Endpoint;
import org.qsari.effectopedia.core.objects.Effect_MolecularInitiatingEvent;
import org.qsari.effectopedia.core.objects.Initiator;
import org.qsari.effectopedia.core.objects.Initiator_BiologcalPerturbation;
import org.qsari.effectopedia.core.objects.Initiator_ChemicalStructure;
import org.qsari.effectopedia.core.objects.Initiator_StructuralAlerts;
import org.qsari.effectopedia.core.objects.Link;
import org.qsari.effectopedia.core.objects.Link_ChemStructToMIE;
import org.qsari.effectopedia.core.objects.Pathway;
import org.qsari.effectopedia.core.objects.PathwayElement;
import org.qsari.effectopedia.core.objects.Test;
import org.qsari.effectopedia.core.objects.TestResponseMapping;
import org.qsari.effectopedia.core.objects.Test_ExVivo;
import org.qsari.effectopedia.core.objects.Test_InChemico;
import org.qsari.effectopedia.core.objects.Test_InSilico;
import org.qsari.effectopedia.core.objects.Test_InVitro;
import org.qsari.effectopedia.core.objects.Test_InVivo;
import org.qsari.effectopedia.core.ui.UserInterface;
import org.qsari.effectopedia.core.ui.nav.UILocation;
import org.qsari.effectopedia.core.ui.nav.UILocations;
import org.qsari.effectopedia.defaults.DefaultEffectopediaObjects;
import org.qsari.effectopedia.go.Layout.LayoutObjectSelection;
import org.qsari.effectopedia.gui.core.DataView;
import org.qsari.effectopedia.gui.util.GlobalKeyboardShortcut;

public class ContextPopupMenusFactoryUI
	{
		public static final ActionListener														invokePropEditor	= new InvokePorpertiesEditor();
		public static final ActionListener														deleteElement				= new DeleteElement();
		public static final ActionListener														hideSelection				= new HideSelection();
		public static final ActionListener														deleteSelection		= new DeleteSelection();
		
		public static PathwaysViewUI																				pathwaysViewUI;
		public static DataView																										dataView;
		public static EffectopediaObject																eo;
		public static LayoutObjectSelection													selection;
		
		public static final EffectopediaObjectPopupMenu	ESCAPE_POPUP					= createEscapePopup();
		public static final EffectopediaObjectPopupMenu	PATHWAY_POPUP				= createPathwayPopup();
		public static final EffectopediaObjectPopupMenu	EFFECT_POPUP					= createEffectPopup();
		public static final EffectopediaObjectPopupMenu	LINK_POPUP							= createLinkPopup();
		public static final EffectopediaObjectPopupMenu	INITIATOR_POPUP		= createInitiatorPopup();
		public static final EffectopediaObjectPopupMenu	TEST_POPUP							= createTestPopup();
		public static final EffectopediaObjectPopupMenu	TRM_POPUP								= createTRMPopup();
		
		public static JPopupMenu getPopupMenu(PathwaysViewUI pathwaysViewUI, EffectopediaObject eo, LayoutObjectSelection selection)
			{
				ContextPopupMenusFactoryUI.pathwaysViewUI = pathwaysViewUI;
				ContextPopupMenusFactoryUI.dataView = pathwaysViewUI.getDataView();
				ContextPopupMenusFactoryUI.eo = eo;
				ContextPopupMenusFactoryUI.selection = selection;
				if ((eo != null) && eo.isDefaultID())
					return ESCAPE_POPUP.update(eo, selection);
				if (eo instanceof Effect)
					return EFFECT_POPUP.update(eo, selection);
				if (eo instanceof Link)
					return LINK_POPUP.update(eo, selection);
				if (eo instanceof Initiator)
					return INITIATOR_POPUP.update(eo, selection);
				if (eo instanceof Test)
					return TEST_POPUP.update(eo, selection);
				if (eo instanceof TestResponseMapping)
					return TRM_POPUP.update(eo, selection);
				else
					return PATHWAY_POPUP.update(eo, selection);
			}
			
		public static class EffectopediaObjectPopupMenu extends JPopupMenu
			{
				
				public final JMenuItem																															property;
				public final JMenuItem																															deleteSelectionMenu;
				public final JMenuItem																															hideSelectionMenu;
				public final ButtonGroup																													types	= new ButtonGroup();
				public final HashMap<Class<?>, JRadioButtonMenuItem>	map			= new HashMap<Class<?>, JRadioButtonMenuItem>();
				
				public EffectopediaObjectPopupMenu(String label)
					{
						super(label);
						property = new JMenuItem("Description");
						property.addActionListener(invokePropEditor);
						hideSelectionMenu = new JMenuItem("Hide selected");
						hideSelectionMenu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0));
						hideSelectionMenu.addActionListener(hideSelection);
						deleteSelectionMenu = new JMenuItem("Delete selected");
						deleteSelectionMenu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, ActionEvent.CTRL_MASK));
						deleteSelectionMenu.addActionListener(deleteSelection);
					}
					
				public void addDefaultPathwayElementItems()
					{
						add(property);
						addSeparator();
						JMenuItem menuItem = new JMenuItem("Delete element");
						menuItem.addActionListener(deleteElement);
						add(menuItem);
						add(hideSelectionMenu);
						add(deleteSelectionMenu);
					}
					
				public EffectopediaObjectPopupMenu update()
					{
						return update(ContextPopupMenusFactoryUI.eo, ContextPopupMenusFactoryUI.selection);
					}
					
				public EffectopediaObjectPopupMenu update(EffectopediaObject eo, LayoutObjectSelection selection)
					{
						if (eo != null)
							{
								property.setVisible(true);
								property.setIcon(UIResources.getIconForClass(eo.getClass()));
								property.invalidate();
								JRadioButtonMenuItem selected = map.get(eo.getClass());
								if (selected != null)
									selected.setSelected(true);
							}
						else
							property.setVisible(false);
						boolean hasValidSelection = ((selection != null) && (selection.size() > 0));
						deleteSelectionMenu.setVisible(hasValidSelection);
						hideSelectionMenu.setVisible(hasValidSelection);
						return this;
					}
					
				public boolean replace(PathwayElement oldElement, PathwayElement newElement)
					{
						if ((oldElement != null) && (newElement != null) && (!oldElement.isGeneric()))
							return false;
						newElement.forceToLive();
						Pathway.substitute(oldElement, newElement);
						dataView.replaceInView(oldElement, newElement);
						dataView.getPathwaysView().update();
						ContextPopupMenusFactoryUI.eo = newElement;
						update();
						return true;
					}
					
				private static final long serialVersionUID = 1L;
			}
			
		private static EffectopediaObjectPopupMenu createEscapePopup()
			{
				EffectopediaObjectPopupMenu popup = new EffectopediaObjectPopupMenu("Escape");
				JMenuItem menuItem = new JMenuItem("Stop adding elements", UIResources.imageCancel);
				menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0));
				menuItem.addActionListener(new ActionListener()
					{
						@Override
						public void actionPerformed(ActionEvent e)
							{
								if (dataView != null)
									{
										dataView.rebuildView();
										pathwaysViewUI.getViewUI().getPathwaySpaceToolbarUI().setDefaultMode();
									}
							}
					});
				popup.add(menuItem);
				return popup;
			}
			
		private static EffectopediaObjectPopupMenu createPathwayPopup()
			{
				EffectopediaObjectPopupMenu popup = new EffectopediaObjectPopupMenu("Pathway");
				JMenuItem menuItem = new JMenuItem("Refresh", UIResources.imageRefresh);
				menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F5, 0));
				menuItem.addActionListener(new ActionListener()
					{
						@Override
						public void actionPerformed(ActionEvent e)
							{
								if (dataView != null)
									dataView.rebuildView();
							}
					});
				JMenu appearance = new JMenu("Appearance");
					{
						JCheckBoxMenuItem showTests = new JCheckBoxMenuItem("Show Tests");
						showTests.setSelected(true);
						showTests.addActionListener(new ActionListener()
							{
								@Override
								public void actionPerformed(ActionEvent e)
									{
										if (dataView != null)
											{
												dataView.setShowTestMethods(showTests.isSelected());
												dataView.rebuildView();
											}
									}
							});
						
						appearance.add(showTests);
						
						JCheckBoxMenuItem hideEmptySegments = new JCheckBoxMenuItem("Hide Empty Segments");
						hideEmptySegments.setSelected(false);
						hideEmptySegments.addActionListener(new ActionListener()
							{
								@Override
								public void actionPerformed(ActionEvent e)
									{
										if (dataView != null)
											{
												dataView.setHideEmptySegments(hideEmptySegments.isSelected());
												dataView.rebuildView();
											}
									}
							});
						appearance.add(hideEmptySegments);
						
						JMenu fontSize = new JMenu("Font size");
							{
								JMenuItem fontMenuItem = new JMenuItem("Increase", UIResources.imageFontSizeIncrease);
								KeyStroke keyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_PLUS, KeyEvent.CTRL_DOWN_MASK);
								fontMenuItem.setAccelerator(keyStroke);
								fontMenuItem.addActionListener(GlobalKeyboardShortcut.dispatcher().getAction(keyStroke));
								fontSize.add(fontMenuItem);
								
								fontMenuItem = new JMenuItem("Decrease", UIResources.imageFontSizeDecrease);
								keyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_MINUS, KeyEvent.CTRL_DOWN_MASK);
								fontMenuItem.setAccelerator(keyStroke);
								fontMenuItem.addActionListener(GlobalKeyboardShortcut.dispatcher().getAction(keyStroke));
								fontSize.add(fontMenuItem);
								
								fontSize.addSeparator();
								
								fontMenuItem = new JMenuItem("Default", UIResources.imageFontSizeDefault);
								keyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_0, KeyEvent.CTRL_DOWN_MASK);
								fontMenuItem.setAccelerator(keyStroke);
								fontMenuItem.addActionListener(GlobalKeyboardShortcut.dispatcher().getAction(keyStroke));
								fontSize.add(fontMenuItem);
								
							}
						appearance.add(fontSize);
					}
					
				popup.add(appearance);
				popup.add(menuItem);
				popup.addSeparator();
				popup.add(popup.property);
				popup.addSeparator();
				popup.add(popup.hideSelectionMenu);
				popup.add(popup.deleteSelectionMenu);
				return popup;
			}
			
		private static EffectopediaObjectPopupMenu createEffectPopup()
			{
				@SuppressWarnings("serial")
				EffectopediaObjectPopupMenu popup = new EffectopediaObjectPopupMenu("Effect")
					{
						@Override
						public EffectopediaObjectPopupMenu update(EffectopediaObject eo, LayoutObjectSelection selection)
							{
								super.update(eo, selection);
								enablePossibleConversions(eo);
								return this;
							}
							
						private void enablePossibleConversions(EffectopediaObject eo)
							{
								Effect effect = (Effect) eo;
								boolean isGeneric = effect.isGeneric();
								PathwayElement[] incomming = effect.incommingAssociations();
								boolean isUplinkedToInitiator = false;
								boolean hasIncommingLinks = (incomming != null) && (incomming.length > 0);
								if (hasIncommingLinks)
									for (PathwayElement upLink : incomming)
										if (upLink instanceof Link_ChemStructToMIE)
											{
												isUplinkedToInitiator = true;
												break;
											}
								PathwayElement[] outgoing = effect.outgoingAssociations();
								boolean isNotLinkedDownstream = (outgoing == null) || (outgoing.length == 0);
								boolean isLinkedOnlyToAO = true;
								if (outgoing != null)
									for (PathwayElement dnLink : outgoing)
										if (dnLink.hasOutgoingAssociations() && !(dnLink.outgoingAssociations()[0] instanceof Effect_AdverseOutcome))
											{
												isLinkedOnlyToAO = false;
												break;
											}
								map.get(Effect_MolecularInitiatingEvent.class).setEnabled(isGeneric && (!hasIncommingLinks || isUplinkedToInitiator));
								map.get(Effect_DownstreamEffect.class).setEnabled(isGeneric && !isUplinkedToInitiator);
								map.get(Effect_Endpoint.class).setEnabled(isGeneric && !isUplinkedToInitiator);
								map.get(Effect_AdverseOutcome.class).setEnabled(isGeneric && (!isUplinkedToInitiator && (isNotLinkedDownstream || isLinkedOnlyToAO)));
							}
					};
				
				JMenu typeMenu = new JMenu("Set type");
					{
						JRadioButtonMenuItem subMenuItem = new JRadioButtonMenuItem("MIE", UIResources.imageMIE);
						popup.types.add(subMenuItem);
						popup.map.put(Effect_MolecularInitiatingEvent.class, subMenuItem);
						subMenuItem.addActionListener(new ActionListener()
							{
								@Override
								public void actionPerformed(ActionEvent e)
									{
										Effect effect = (Effect) ContextPopupMenusFactoryUI.eo;
										if ((effect != null) && (effect.getClass() != Effect_MolecularInitiatingEvent.class))
											popup.replace(effect, DefaultEffectopediaObjects.DEFAULT_MIE.clone(null, effect.getDataSource()));
									}
							});
						typeMenu.add(subMenuItem);
						
						subMenuItem = new JRadioButtonMenuItem("(Key) event", UIResources.imageEffect);
						popup.types.add(subMenuItem);
						popup.map.put(Effect_DownstreamEffect.class, subMenuItem);
						subMenuItem.addActionListener(new ActionListener()
							{
								@Override
								public void actionPerformed(ActionEvent e)
									{
										Effect effect = (Effect) ContextPopupMenusFactoryUI.eo;
										if ((effect != null) && (effect.getClass() != Effect_DownstreamEffect.class))
											popup.replace(effect, DefaultEffectopediaObjects.DEFAULT_DOWNSTREAM_EFFECT.clone(null, effect.getDataSource()));
									}
							});
						typeMenu.add(subMenuItem);
						
						subMenuItem = new JRadioButtonMenuItem("Adverse endpoint", UIResources.imageEndpoint);
						popup.types.add(subMenuItem);
						popup.map.put(Effect_Endpoint.class, subMenuItem);
						subMenuItem.addActionListener(new ActionListener()
							{
								@Override
								public void actionPerformed(ActionEvent e)
									{
										Effect effect = (Effect) ContextPopupMenusFactoryUI.eo;
										if ((effect != null) && (effect.getClass() != Effect_Endpoint.class))
											popup.replace(effect, DefaultEffectopediaObjects.DEFAULT_ENDPOINT.clone(null, effect.getDataSource()));
									}
							});
						typeMenu.add(subMenuItem);
						
						subMenuItem = new JRadioButtonMenuItem("Adverse outcome", UIResources.imageEndpoint);
						popup.types.add(subMenuItem);
						popup.map.put(Effect_AdverseOutcome.class, subMenuItem);
						subMenuItem.addActionListener(new ActionListener()
							{
								@Override
								public void actionPerformed(ActionEvent e)
									{
										Effect effect = (Effect) ContextPopupMenusFactoryUI.eo;
										if ((effect != null) && (effect.getClass() != Effect_AdverseOutcome.class))
											popup.replace(effect, DefaultEffectopediaObjects.DEFAULT_ADVERSE_OUTCOME.clone(null, effect.getDataSource()));
									}
							});
						typeMenu.add(subMenuItem);
					}
				popup.add(typeMenu);
				popup.addDefaultPathwayElementItems();
				return popup;
			}
			
		private static EffectopediaObjectPopupMenu createLinkPopup()
			{
				EffectopediaObjectPopupMenu popup = new EffectopediaObjectPopupMenu("Link");
				popup.addDefaultPathwayElementItems();
				return popup;
			}
			
		private static EffectopediaObjectPopupMenu createInitiatorPopup()
			{
				EffectopediaObjectPopupMenu popup = new EffectopediaObjectPopupMenu("Initiator");
				JMenu typeMenu = new JMenu("Set type");
					{
						JRadioButtonMenuItem subMenuItem = new JRadioButtonMenuItem("Chemical", UIResources.imageChemical);
						popup.types.add(subMenuItem);
						popup.map.put(Initiator_ChemicalStructure.class, subMenuItem);
						subMenuItem.addActionListener(new ActionListener()
							{
								@Override
								public void actionPerformed(ActionEvent e)
									{
										Initiator initiator = (Initiator) ContextPopupMenusFactoryUI.eo;
										if ((initiator != null) && (initiator.getClass() != Initiator_ChemicalStructure.class))
											popup.replace(initiator, DefaultEffectopediaObjects.DEFAULT_CHEM_STRUCTURE.clone(null, initiator.getDataSource()));
									}
							});
						typeMenu.add(subMenuItem);
						
						subMenuItem = new JRadioButtonMenuItem("Structural alerts", UIResources.imageStructuralAlert);
						popup.types.add(subMenuItem);
						popup.map.put(Initiator_StructuralAlerts.class, subMenuItem);
						subMenuItem.addActionListener(new ActionListener()
							{
								@Override
								public void actionPerformed(ActionEvent e)
									{
										Initiator initiator = (Initiator) ContextPopupMenusFactoryUI.eo;
										if ((initiator != null) && (initiator.getClass() != Initiator_StructuralAlerts.class))
											popup.replace(initiator, DefaultEffectopediaObjects.DEFAULT_STRUCTURAL_ALERT.clone(null, initiator.getDataSource()));
									}
							});
						typeMenu.add(subMenuItem);
						
						subMenuItem = new JRadioButtonMenuItem("Biolgical perturbation", UIResources.imageBiologicalPerturbation);
						popup.types.add(subMenuItem);
						popup.map.put(Initiator_BiologcalPerturbation.class, subMenuItem);
						subMenuItem.addActionListener(new ActionListener()
							{
								@Override
								public void actionPerformed(ActionEvent e)
									{
										Initiator initiator = (Initiator) ContextPopupMenusFactoryUI.eo;
										if ((initiator != null) && (initiator.getClass() != Initiator_BiologcalPerturbation.class))
											popup.replace(initiator, DefaultEffectopediaObjects.DEFAULT_BIOLOGICAL_PERTURBATION.clone(null, initiator.getDataSource()));
									}
							});
						typeMenu.add(subMenuItem);
					}
				popup.add(typeMenu);
				popup.addDefaultPathwayElementItems();
				return popup;
			}
			
		private static EffectopediaObjectPopupMenu createTestPopup()
			{
				EffectopediaObjectPopupMenu popup = new EffectopediaObjectPopupMenu("Test");
				JMenu typeMenu = new JMenu("Set type");
					{
						JRadioButtonMenuItem subMenuItem = new JRadioButtonMenuItem("In-chemico", UIResources.imageTest);
						popup.types.add(subMenuItem);
						popup.map.put(Test_InChemico.class, subMenuItem);
						subMenuItem.addActionListener(new ActionListener()
							{
								@Override
								public void actionPerformed(ActionEvent e)
									{
										Test test = (Test) ContextPopupMenusFactoryUI.eo;
										if ((test != null) && (test.getClass() != Test_InChemico.class))
											popup.replace(test, DefaultEffectopediaObjects.DEFAULT_IN_CHEMICO_TEST.clone(null, test.getDataSource()));
									}
							});
						typeMenu.add(subMenuItem);
						
						subMenuItem = new JRadioButtonMenuItem("In-vitro", UIResources.imageTest);
						popup.types.add(subMenuItem);
						popup.map.put(Test_InVitro.class, subMenuItem);
						subMenuItem.addActionListener(new ActionListener()
							{
								@Override
								public void actionPerformed(ActionEvent e)
									{
										Test test = (Test) ContextPopupMenusFactoryUI.eo;
										if ((test != null) && (test.getClass() != Test_InVitro.class))
											popup.replace(test, DefaultEffectopediaObjects.DEFAULT_IN_VITRO_TEST.clone(null, test.getDataSource()));
									}
							});
						typeMenu.add(subMenuItem);
						
						subMenuItem = new JRadioButtonMenuItem("Ex-vivo", UIResources.imageInvivoTest);
						popup.types.add(subMenuItem);
						popup.map.put(Test_ExVivo.class, subMenuItem);
						subMenuItem.addActionListener(new ActionListener()
							{
								@Override
								public void actionPerformed(ActionEvent e)
									{
										Test test = (Test) ContextPopupMenusFactoryUI.eo;
										if ((test != null) && (test.getClass() != Test_ExVivo.class))
											popup.replace(test, DefaultEffectopediaObjects.DEFAULT_EX_VIVO_TEST.clone(null, test.getDataSource()));
									}
							});
						typeMenu.add(subMenuItem);
						
						subMenuItem = new JRadioButtonMenuItem("In-vivo", UIResources.imageInvivoTest);
						popup.types.add(subMenuItem);
						popup.map.put(Test_InVivo.class, subMenuItem);
						subMenuItem.addActionListener(new ActionListener()
							{
								@Override
								public void actionPerformed(ActionEvent e)
									{
										Test test = (Test) ContextPopupMenusFactoryUI.eo;
										if ((test != null) && (test.getClass() != Test_InVivo.class))
											popup.replace(test, DefaultEffectopediaObjects.DEFAULT_IN_VIVO_TEST.clone(null, test.getDataSource()));
									}
							});
						typeMenu.add(subMenuItem);
						
						subMenuItem = new JRadioButtonMenuItem("In-silico", UIResources.imageModel);
						popup.types.add(subMenuItem);
						popup.map.put(Test_InSilico.class, subMenuItem);
						subMenuItem.addActionListener(new ActionListener()
							{
								@Override
								public void actionPerformed(ActionEvent e)
									{
										Test test = (Test) ContextPopupMenusFactoryUI.eo;
										if ((test != null) && (test.getClass() != Test_InSilico.class))
											popup.replace(test, DefaultEffectopediaObjects.DEFAULT_IN_SILICO_TEST.clone(null, test.getDataSource()));
									}
							});
						typeMenu.add(subMenuItem);
					}
				popup.add(typeMenu);
				popup.addDefaultPathwayElementItems();
				return popup;
			}
			
		private static EffectopediaObjectPopupMenu createTRMPopup()
			{
				EffectopediaObjectPopupMenu popup = new EffectopediaObjectPopupMenu("Test Response Mapping");
				popup.addDefaultPathwayElementItems();
				return popup;
			}
			
		private static final class InvokePorpertiesEditor implements ActionListener
			{
				@Override
				public void actionPerformed(ActionEvent evt)
					{
						if (eo == null)
							return;
						UILocation location = UILocations.getProperEditor(eo);
						location.setReadOnly(dataView == null ? eo.isReadonly() : dataView.isReadOnly() || eo.isReadonly());
						UserInterface.getDefaultNavigator().navigate(location, eo);
					}
			}
			
		private static final class DeleteElement implements ActionListener
			{
				@Override
				public void actionPerformed(ActionEvent evt)
					{
						if ((eo == null) || (dataView == null))
							return;
						dataView.removeFromView((PathwayElement) eo);
						dataView.rebuildView();
					}
			}
			
		private static final class DeleteSelection implements ActionListener
			{
				@Override
				public void actionPerformed(ActionEvent evt)
					{
						if ((selection == null) || (dataView == null))
							return;
						dataView.deleteSelection(selection, true);
						dataView.rebuildView();
					}
			}
			
		private static final class HideSelection implements ActionListener
			{
				@Override
				public void actionPerformed(ActionEvent evt)
					{
						if ((selection == null) || (dataView == null))
							return;
						dataView.removeFromView(selection);
						dataView.getPathwaysView().update();
					}
			}
			
	}
