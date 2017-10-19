package org.qsari.effectopedia.gui.im;

import java.awt.Cursor;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.util.EventObject;

import javax.swing.Timer;
import javax.swing.event.DocumentListener;
import javax.swing.text.PlainDocument;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.core.objects.Effect;
import org.qsari.effectopedia.core.objects.Initiator;
import org.qsari.effectopedia.core.objects.Pathway;
import org.qsari.effectopedia.core.objects.PathwayElement;
import org.qsari.effectopedia.core.objects.Test;
import org.qsari.effectopedia.core.ui.UserInterface;
import org.qsari.effectopedia.core.ui.nav.UILocation;
import org.qsari.effectopedia.core.ui.nav.UILocations;
import org.qsari.effectopedia.go.GraphicObject;
import org.qsari.effectopedia.go.Layout.GlobalLayoutContainer;
import org.qsari.effectopedia.go.Layout.LayoutObject;
import org.qsari.effectopedia.go.Layout.LayoutObjectSelection;
import org.qsari.effectopedia.go.Layout.LayoutObjectsContainer;
import org.qsari.effectopedia.go.gui.PathwaysView;
import org.qsari.effectopedia.go.pathway_elements.PathwayElementGO;
import org.qsari.effectopedia.gui.ContextPopupMenusFactoryUI;
import org.qsari.effectopedia.gui.ElementEditorUI;
import org.qsari.effectopedia.gui.ExistingChemicalDialog;
import org.qsari.effectopedia.gui.ExistingEffectDialog;
import org.qsari.effectopedia.gui.ExistingEffectPanel;
import org.qsari.effectopedia.gui.ExistingTestDialog;
import org.qsari.effectopedia.gui.PathwaysViewUI;
import org.qsari.effectopedia.gui.comp.GlobalDocumentListener;
import org.qsari.effectopedia.gui.comp.GlobalUpdateTracker;
import org.qsari.effectopedia.gui.comp.GlobalUpdateTracker.ObjectUpdateListener;
import org.qsari.effectopedia.gui.core.DataView;
import org.qsari.effectopedia.system.Configuration;
import org.qsari.effectopedia.system.TraceableClasses;

public abstract class InterfaceMode
		implements java.awt.event.MouseListener, java.awt.event.MouseWheelListener, java.awt.event.MouseMotionListener, java.awt.event.KeyListener, InterfaceModeConstants, ObjectUpdateListener
	{
		public static int DEAFAULT = 0;
		
		public InterfaceMode(PathwaysViewUI pathwayUI, InterfaceModes owner)
			{
				this.pathwaysViewUI = pathwayUI;
				if (pathwayUI != null)
					{
						this.pathwayDataView = pathwayUI.getDataView();
						this.pathwaysView = pathwayDataView.getPathwaysView();
						this.viewLayout = pathwaysView.getViewLayout().getGlobalLOC();
					}
				else
					{
						this.pathwayDataView = null;
						this.pathwaysView = null;
					}
				this.owner = owner;
				owner.add(this);
				this.currentElement = owner.getPathwayElementTypeCycler();
				selection = new LayoutObjectSelection();
				pathwaysView.getViewLayout().setArcsSelectable(true);
			}
			
		public void update()
			{
				this.pathwayDataView = pathwaysViewUI.getDataView();
				this.pathwaysView = pathwayDataView.getPathwaysView();
				this.viewLayout = pathwaysView.getViewLayout().getGlobalLOC();
			}
			
		public static Cursor[] make5StateCursors(Cursor defaultCursor, Cursor compatibleContainer, Cursor incompatibleSegment, Cursor compatibleObject, Cursor incompatibleObject)
			{
				Cursor[] cursors = new Cursor[5];
				cursors[0] = defaultCursor;
				cursors[1] = compatibleContainer;
				cursors[2] = incompatibleSegment;
				cursors[3] = compatibleObject;
				cursors[4] = incompatibleObject;
				return cursors;
			}
			
		public static Cursor[] make4StateCursors(Cursor defaultCursor, Cursor compatibleContainer, Cursor compatibleLinkContainer, Cursor incompatibleSegment)
			{
				Cursor[] cursors = new Cursor[4];
				cursors[0] = defaultCursor;
				cursors[1] = compatibleContainer;
				cursors[2] = compatibleLinkContainer;
				cursors[3] = incompatibleSegment;
				return cursors;
			}
			
		public static Cursor[] make3StateCursors(Cursor defaultCursor, Cursor compatibleContainer, Cursor incompatibleContainer)
			{
				Cursor[] cursors = new Cursor[3];
				cursors[0] = defaultCursor;
				cursors[1] = compatibleContainer;
				cursors[2] = incompatibleContainer;
				return cursors;
			}
			
		/*
		 * Gets <code>alternativeMode<code>. Alternative model is activated when user
		 * press Alt key and is active until Alt key is released. This allows dragging
		 * while editing zooming in while in zoom out mode and so on
		 */
		public InterfaceMode getAlternativeMode()
			{
				return alternativeMode;
			}
			
		public void setAlternativeMode(InterfaceMode alternativeMode)
			{
				this.alternativeMode = alternativeMode;
			}
			
		public void setCursors(Cursor[] cursors)
			{
				if (cursors == null)
					{
						Cursor c = Cursor.getDefaultCursor();
						this.cursors = make5StateCursors(c, c, c, c, c);
					}
				else
					{
						this.cursors = cursors;
					}
			}
			
		public Cursor[] getCursors()
			{
				return this.cursors;
			}
			
		public void setCursor()
			{
				if ((state >= 0) && (state < cursors.length))
					pathwaysViewUI.setCursor(cursors[state]);
				else
					pathwaysViewUI.setCursor(Cursor.getDefaultCursor());
			}
			
		public class MouseActionListener implements ActionListener
			{
				public MouseActionListener(MouseEvent e)
					{
						mouseEvent = e;
					}
					
				public void actionPerformed(ActionEvent evt)
					{
						mouseSingleClicked(mouseEvent);
					}
					
				private MouseEvent mouseEvent;
			}
			
		protected void associateWithExistingPathways(PathwayElement element)
			{
				Pathway pathway = pathwayDataView.getCurrentPathway();
				if ((pathway == null) || pathway.getElements().size() > 0)
					return;
				element.setParent(pathway);
				pathway.add(element);
			}
			
		public void mouseClicked(MouseEvent e)
			{
				updateKeyModifiers(e);
				if (e.getClickCount() == 2)
					{
						if (timer != null)
							timer.stop();
						mouseDoubleClicked(e);
					}
				else
					{
						timer = new Timer(multiClickInterval.intValue(), new MouseActionListener(e));
						timer.setRepeats(false);
						timer.start();
					}
				// pathwaysViewUI.getViewUI().updateHelpContext(e);
			}
			
		public void mouseSingleClicked(MouseEvent e)
			{
				lastX = e.getX();
				lastY = e.getY();
				setCurrentLO(viewLayout.isOver(lastX, lastY));
				setLastLO(viewLayout.getLastLO());
				currentContainer = viewLayout.getCurrentContainer();
				// if (this.currentGO instanceof PathwayElementGO)
				// pathwayDataView.loadInObjectInspector((PathwayElementGO) this.currentGO);
				updateElementEditor(getCurrentActivePathwayElement());
				if (currentLO != null)
					{
						PathwayElement o = ((PathwayElementGO) currentLO.getGo()).getO();
						if (o.isGeneric())
							ExistingEffectPanel.PANEL.setInterfaceMode(this);
					}
				determineState();
			}
			
		protected void updateElementEditor(PathwayElement pe)
			{
				if (pe != null)
					loadElementEditor(pe);
				else
					loadElementEditor(getCurrentPathway());
			}
			
		public void loadElementEditor(EffectopediaObject eo)
			{
				ElementEditorUI elementEditor = owner.getPathwayUI().getElementEditor(this);
				if (elementEditor != null)
					elementEditor.load(eo, false);
			}
			
		public void replaceCurrentPathwayElement(GraphicObject go, LayoutObjectsContainer container, PathwayElement newPE)
			{
				PathwayElement oldPE = ((PathwayElementGO) go).getO();
				if ((oldPE instanceof Effect) && (newPE instanceof Effect))
					Pathway.replace((Effect) oldPE, (Effect) newPE, pathwayDataView.getPathways());
				else if ((oldPE instanceof Initiator) && (newPE instanceof Initiator))
					Pathway.replace((Initiator) oldPE, (Initiator) newPE, pathwayDataView.getPathways());
				else if ((oldPE instanceof Test) && (newPE instanceof Test))
					Pathway.replace((Test) oldPE, (Test) newPE, pathwayDataView.getPathways());
				pathwayDataView.setInView(container.getActiveIndex(lastX, lastY), container, newPE);
				((PathwayElementGO) go).setO(newPE);
				pathwaysView.update();
				pathwaysViewUI.repaint();
			}
			
		public void mouseDoubleClicked(MouseEvent e)
			{
				lastX = e.getX();
				lastY = e.getY();
				setCurrentLO(viewLayout.isOver(lastX, lastY));
				setLastLO(viewLayout.getLastLO());
				currentContainer = viewLayout.getCurrentContainer();
				if (currentLO != null)
					{
						PathwayElement o = ((PathwayElementGO) currentLO.getGo()).getO();
						if (o.isGeneric())
							{
								if (o instanceof Effect)
									{
										ExistingEffectDialog.DIALOG.load(o, pathwayDataView.isReadOnly() || o.isReadonly());
										o = ExistingEffectDialog.DIALOG.getSelectedEffect();
									}
								else if (o instanceof Initiator)
									{
										ExistingChemicalDialog.DIALOG.load(o, pathwayDataView.isReadOnly() || o.isReadonly());
										o = ExistingChemicalDialog.DIALOG.getSelectedInitiator();
									}
								else if (o instanceof Test)
									{
										ExistingTestDialog.DIALOG.load(o, pathwayDataView.isReadOnly() || o.isReadonly());
										o = ExistingTestDialog.DIALOG.getSelectedTest();
									}
								else
									{
										UILocation location = UILocations.getProperEditor(o);
										location.setReadOnly(pathwayDataView.isReadOnly() || o.isReadonly());
										UserInterface.getDefaultNavigator().navigate(location, o);
										return;
									}
								if (o != null)
									{
										if (pathwayDataView.isVisible(o))
											{
												UserInterface.showError("The " + TraceableClasses.REGISTERED.getDescription(o.getClass()) + " is already added to the current view");
												return;
											}
										replaceCurrentPathwayElement(currentGO, currentContainer, o);
									}
							}
						else
							{
								UILocation location = UILocations.getProperEditor(o);
								location.setReadOnly(pathwayDataView.isReadOnly() || o.isReadonly());
								UserInterface.getDefaultNavigator().navigate(location, o);
							}
					}
				else
					mouseSingleClicked(e);
			}
			
		public void mousePressed(MouseEvent e)
			{
				if (e.isPopupTrigger())
					ContextPopupMenusFactoryUI.getPopupMenu(pathwaysViewUI, getCurrentEO(), selection).show(pathwaysViewUI, e.getX(), e.getY());
				else
					{
						lastX = e.getX();
						lastY = e.getY();
						mouseIsDragged = (e.getButton() == MouseEvent.BUTTON2);
						setCurrentLO(viewLayout.isOver(lastX, lastY));
						setLastLO(viewLayout.getLastLO());
						currentContainer = viewLayout.getCurrentContainer();
						determineState();
					}
			}
			
		public void mouseReleased(MouseEvent e)
			{
				if (e.isPopupTrigger())
					ContextPopupMenusFactoryUI.getPopupMenu(pathwaysViewUI, getCurrentEO(), selection).show(pathwaysViewUI, e.getX(), e.getY());
				mouseIsDragged = false;
			}
			
		public void mouseEntered(MouseEvent e)
			{
				
			}
			
		public void mouseExited(MouseEvent e)
			{
				pathwaysView.synchronizeActiveRegions(false);
				pathwaysViewUI.rootRepaint();
			}
			
		public void mouseWheelMoved(MouseWheelEvent e)
			{
				if (keyCtrlPressed)
					{
						if (e.getWheelRotation() < 0)
							pathwayDataView.zoom(true);
						else if (e.getWheelRotation() > 0)
							pathwayDataView.zoom(false);
					}
				else if (keyShiftPressed)
					pathwaysViewUI.scroll(-e.getWheelRotation() * 8, 0);
				else
					pathwaysViewUI.scroll(0, -e.getWheelRotation() * 8);
			}
			
		public void mouseDragged(MouseEvent e)
			{
				int x = e.getX();
				int y = e.getY();
				updateKeyModifiers(e);
				if (mouseIsDragged)
					pathwaysViewUI.scroll(x - lastX, y - lastY);
			}
			
		public void mouseMoved(MouseEvent e)
			{
				currentX = e.getX();
				currentY = e.getY();
				updateKeyModifiers(e);
				setCurrentLO(viewLayout.isOver(currentX, currentY));
				setLastLO(viewLayout.getLastLO());
				pathwaysView.synchronizeActiveRegions(true);
				currentContainer = viewLayout.getCurrentContainer();
				determineState();
				if (this.lastGO != null)
					this.lastGO.setActive(this.lastGO == this.currentGO);
				/*
				 * LayoutObjectsContainer lastContainer = viewLayout.getLastContainer();
				 * 
				 * if ((lastContainer != currentContainer) && (lastContainer != null))
				 * pathwaysViewUI.repaint(lastContainer.getX()-5, lastContainer.getY()-5,
				 * lastContainer.getActualWidth()+10, lastContainer.getActualHeight()+10);
				 * if (this.currentContainer != null)
				 * pathwaysViewUI.repaint(this.currentContainer.getX() - 5,
				 * this.currentContainer.getY() - 5, this.currentContainer.getActualWidth()
				 * + 10, this.currentContainer.getActualHeight() + 10);
				 */
				pathwaysViewUI.rootRepaint();
				if (!pathwaysViewUI.hasFocus())
					pathwaysViewUI.requestFocusInWindow();
				determineState();
			}
			
		public void keyPressed(KeyEvent e)
			{
				int keyCode = e.getKeyCode();
				int keyModifiers = e.getModifiers();
				keyAltPressed = (keyModifiers & KeyEvent.ALT_MASK) != 0;
				keyCtrlPressed = (keyModifiers & KeyEvent.CTRL_MASK) != 0;
				keyShiftPressed = (keyModifiers & KeyEvent.SHIFT_MASK) != 0;
				if (keyShiftPressed)
					System.out.println("Shift pressed");
				if ((keyCode == 65) && keyCtrlPressed)
					{
						selection.select(viewLayout);
						pathwaysViewUI.repaint();
					}
				owner.keyPressed(e);
				determineState();
			}
			
		public void trueDeleteSelected()
			{
				pathwayDataView.deleteSelection(selection, true);
				selection.clear();
				viewLayout.cleanup();
				pathwaysView.update();
				pathwaysViewUI.repaint();
			}
			
		public void viewDeleteSelected()
			{
				pathwayDataView.deleteGenericSelection(selection, true);
				selection.clear();
				viewLayout.cleanup();
				pathwaysView.update();
				pathwaysViewUI.repaint();
			}
			
		public void keyReleased(KeyEvent e)
			{
				int keyCode = e.getKeyCode();
				int keyModifiers = e.getModifiers();
				keyAltPressed = (keyModifiers & KeyEvent.ALT_MASK) != 0;
				keyCtrlPressed = (keyModifiers & KeyEvent.CTRL_MASK) != 0;
				keyShiftPressed = (keyModifiers & KeyEvent.SHIFT_MASK) != 0;
				if (!keyShiftPressed)
					System.out.println("Shift released");
				if (keyCode == DELETE)
					if (keyCtrlPressed)
						trueDeleteSelected();
					else
						viewDeleteSelected();
				owner.keyReleased(e);
				determineState();
			}
			
		protected void updateKeyModifiers(MouseEvent e)
			{
				int modifiers = e.getModifiersEx();
				keyShiftPressed = (modifiers & MouseEvent.SHIFT_DOWN_MASK) != 0;
				keyCtrlPressed = (modifiers & MouseEvent.CTRL_DOWN_MASK) != 0;
				keyAltPressed = (modifiers & MouseEvent.ALT_DOWN_MASK) != 0;
			}
			
		public void keyTyped(KeyEvent e)
			{
				owner.keyTyped(e);
			}
			
		public void setState(int state)
			{
				if (state != this.state)
					{
						this.state = state;
						setCursor();
					}
			}
			
		public void setActive(boolean active)
			{
				reset();
				if (this.active != active)
					{
						this.active = active;
						if (this.active)
							{
								install();
								determineState();
								setCursor();
							}
						else
							uninstall();
					}
			}
			
		public void defaultAction()
			{
				
			}
			
		protected void reset()
			{
				pathwaysView.getViewLayout().setArcsSelectable(true);
			}
			
		protected void determineState()
			{
				int state = (currentContainer != null) ? ((currentContainer.isCompatible(currentElement.getCurrent().getClass())) ? 1 : 0) : 0;
				if (currentLO != null)
					state += 2;
				setState(state + 1);
			}
			
		private void install()
			{
				pathwaysViewUI.addMouseListener(this);
				pathwaysViewUI.addMouseMotionListener(this);
				pathwaysViewUI.addMouseWheelListener(this);
				pathwaysViewUI.addKeyListener(this);
				GlobalUpdateTracker.GUT.addObjectUpdateListener(this);
			}
			
		protected void uninstall()
			{
				pathwaysViewUI.removeMouseListener(this);
				pathwaysViewUI.removeMouseMotionListener(this);
				pathwaysViewUI.removeMouseWheelListener(this);
				pathwaysViewUI.removeKeyListener(this);
				GlobalUpdateTracker.GUT.removeObjectUpdateListener(this);
			}
			
		@Override
		public void objectUpdated(EventObject evt)
			{
				Object source = evt.getSource();
				if ((source instanceof PlainDocument) && (pathwaysViewUI.isShowing()))
					{
						DocumentListener[] list = ((PlainDocument) source).getDocumentListeners();
						for (DocumentListener listener : list)
							if (listener instanceof GlobalDocumentListener)
								{
									Object object = ((GlobalDocumentListener) listener).getO();
									if (object instanceof PathwayElement)
										{
											LayoutObject lo = pathwayDataView.getLayoutObjectForElement((PathwayElement) object);
											if ((lo != null) && (lo.getGo() != null))
												{
													lo.getGo().draw((Graphics2D) pathwaysViewUI.getGraphics());
													// pathwaysViewUI.repaint(lo.getGo().getBounds());
												}
											else
												pathwaysViewUI.repaint();
										}
									else
										pathwaysViewUI.repaint();
									break;
								}
					}
			}
			
		public boolean isPrimary()
			{
				return primary;
			}
			
		public void setPrimary(boolean primary)
			{
				this.primary = primary;
			}
			
		public LayoutObject getCurrentLO()
			{
				return currentLO;
			}
			
		public void setCurrentLO(LayoutObject currentLO)
			{
				this.currentLO = currentLO;
				if (currentLO == null)
					this.currentGO = null;
				else if (viewLayout.getActiveRegion().isOverGO())
					this.currentGO = currentLO.getGo();
				else
					this.currentGO = null;
			}
			
		public LayoutObject getLastLO()
			{
				return lastLO;
			}
			
		public void setLastLO(LayoutObject lastLO)
			{
				this.lastLO = lastLO;
				this.lastGO = (lastLO == null) ? null : lastLO.getGo();
			}
			
		public PathwayElement getCurrentActivePathwayElement()
			{
				if (currentGO == null)
					return null;
				if (currentGO instanceof PathwayElementGO)
					return ((PathwayElementGO) currentGO).getO();
				else
					return null;
			}
			
		public PathwayElement getLastActivePathwayElement()
			{
				if (lastGO == null)
					return null;
				if (lastGO instanceof PathwayElementGO)
					return ((PathwayElementGO) lastGO).getO();
				else
					return null;
			}
			
		/*
		 * public PathwayElement defaultPathwayAssociation(PathwayElement element) {
		 * Pathway pathway = getCurrentPathway(); if
		 * ((pathway!=null)&&(pathwayDataView.getPathways().size()==1)) {
		 * pathway.add(element); element.getPathwayIDs().addIfDifferent(pathway); }
		 * return element; }
		 */
		
		public Pathway getCurrentPathway()
			{
				return pathwayDataView.getCurrentPathway();
			}
			
		public void setCyclerElementIndex(int cyclerElementIndex)
			{
				currentElement.setElementIndex(cyclerElementIndex);
			}
			
		public EffectopediaObject getCurrentEO()
			{
				if (currentGO instanceof PathwayElementGO)
					return ((PathwayElementGO) currentGO).getO();
				else
					return pathwayDataView.getCurrentPathway();
			}
			
		public GraphicObject getCurrentGO()
			{
				return currentGO;
			}
			
		public LayoutObjectsContainer getCurrentContainer()
			{
				return currentContainer;
			}
			
		public String getContext()
			{
				return "-" + state;
			}
			
		protected InterfaceModes											owner;
		protected boolean																		primary;
		protected boolean																		keyAltPressed;
		protected boolean																		keyCtrlPressed;
		protected boolean																		keyShiftPressed;
		protected int																						lastX;
		protected int																						lastY;
		protected boolean																		mouseIsDragged;
		
		protected int																						currentX;
		protected int																						currentY;
		protected LayoutObject													lastLO;
		protected GraphicObject												lastGO;
		protected LayoutObject													currentLO;
		protected GraphicObject												currentGO;
		protected boolean																		active;
		protected LayoutObjectsContainer			currentContainer;
		protected PathwaysView													pathwaysView;
		protected DataView																	pathwayDataView;
		protected GlobalLayoutContainer				viewLayout;
		protected final PathwaysViewUI					pathwaysViewUI;
		protected PathwayElementTypeCycler	currentElement;
		protected int																						state														= DEAFAULT;
		private Cursor[]																			cursors;
		private InterfaceMode														alternativeMode;
		protected int																						alternativeModeType;
		protected LayoutObjectSelection				selection;
		protected static Integer											multiClickInterval	= (Integer) Toolkit.getDefaultToolkit().getDesktopProperty("awt.multiClickInterval");
		protected static int															DELETE													= KeyEvent.VK_DELETE;
		
		static
			{
				if (multiClickInterval == null)
					multiClickInterval = new Integer(500);
				if (Configuration.isMacOS())
					DELETE = KeyEvent.VK_BACK_SPACE;
			}
		protected int			DEFAULT_SCROLL_STEP	= 50;
		protected Timer	timer;
		
	}