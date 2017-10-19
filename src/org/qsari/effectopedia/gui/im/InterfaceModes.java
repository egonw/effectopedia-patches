package org.qsari.effectopedia.gui.im;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.EventListener;
import java.util.EventObject;

import javax.swing.event.EventListenerList;

import org.qsari.effectopedia.core.Effectopedia;
import org.qsari.effectopedia.data.DataSource;
import org.qsari.effectopedia.gui.PathwaysViewUI;

public class InterfaceModes extends ArrayList<InterfaceMode> implements InterfaceModeConstants, java.awt.event.KeyListener
	{
		
		/**
	 * 
	 */
		private static final long	serialVersionUID	= 1L;
		
		public InterfaceModes(PathwaysViewUI pathwayUI)
			{
				this.pathwaysViewUI = pathwayUI;
				modes = new InterfaceMode[NUMBER_OF_MODES];
				for (int i = 0; i < NUMBER_OF_MODES; i++)
					modes[i] = null;
				if (Effectopedia.EFFECTOPEDIA.getData() != null)
					pathwayElementTypeCycler = new PathwayElementTypeCycler(PathwayElementTypeCycler.STANDARD_SEQUENCE);
				eventListeners = new EventListenerList();
			}
		
		private InterfaceMode createMode(int index)
			{
				switch (index)
					{
						case NEW_CHEMICAL:
							return new NewSubstanceIM2(pathwaysViewUI, this);
						case NEW_LINK:
							return new NewLinkIM2(pathwaysViewUI, this);
						case NEW_EFFECT:
							return new NewEffectIM2(pathwaysViewUI, this);
						case NEW_TEST:
							return new NewTestIM2(pathwaysViewUI, this);
						case NEW_CHEM_LNK_EFEECT_TEST:
							return new NewIndexedGOIM2(pathwaysViewUI, this);
							
						case PATHWAY_WIZARD:
							return new PathwayWIM(pathwaysViewUI, this);
						case CHEMICAL_WIZARD:
							return new ChemWizardIM(pathwaysViewUI, this);
						case UPSTREAM_CAUSE_WIZARD:
							return new WizardIM(pathwaysViewUI, this);
						case DOWNSTREAM_EFFECT_WIZARD:
							return new WizardIM(pathwaysViewUI, this);
							
						case ZOOM_IN:
							return new ZoomIM(pathwaysViewUI, this, ZoomIM.ZOOM_IN);
						case ZOOM_OUT:
							return new ZoomIM(pathwaysViewUI, this, ZoomIM.ZOOM_OUT);
						case DRAG:
							return new DragIM(pathwaysViewUI, this);
						case EDIT:
							return new EditIM(pathwaysViewUI, this);
						default:
							return null;
					}
			}
		
		public void update()
			{
				for (InterfaceMode im : this)
					im.update();
			}
		
		public InterfaceMode getActiveMode()
			{
				return activeMode;
			}
		
		/*
		 * Create InterfaceMode object on first use
		 */
		public void setActiveMode(int index)
			{
				if ((index >= 0) && (index < NUMBER_OF_MODES))
					{
						if (this.modes[index] == null)
							this.modes[index] = createMode(index);
						if (this.activeMode != this.modes[index])
							{
								if (this.activeMode != null)
									this.activeMode.setActive(false);
								this.activeMode = this.modes[index];
								this.activeMode.setActive(true);
								activeMode.setPrimary(true);
								pathwaysViewUI.requestFocusInWindow();
							}
						else
							this.activeMode.defaultAction();
					}
			}
		
		public PathwaysViewUI getPathwayUI()
			{
				return pathwaysViewUI;
			}
		
		public InterfaceMode[] getModes()
			{
				return modes;
			}
		
		public void setAlternativeActivated(boolean alternativeActivated)
			{
				if (this.alternativeActivated != alternativeActivated)
					{
						if (alternativeActivated)
							{
								int alternativeModeType = this.activeMode.alternativeModeType;
								if (this.modes[alternativeModeType] == null)
									this.modes[alternativeModeType] = createMode(alternativeModeType);
								alternativeMode = this.modes[alternativeModeType];
								alternativeMode.setPrimary(false);
								activeMode.setActive(false);
								alternativeMode.setActive(true);
								alternativeMode.setCursor();
							}
						else
							{
								alternativeMode.setActive(false);
								activeMode.setActive(true);
								activeMode.setCursor();
							}
						this.alternativeActivated = alternativeActivated;
					}
			}
		
		public void keyPressed(KeyEvent e)
			{
				if (e.getKeyCode() == KeyEvent.VK_ALT)
					setAlternativeActivated(true);
			}
		
		public void keyReleased(KeyEvent e)
			{
				if (e.getKeyCode() == KeyEvent.VK_ALT)
					setAlternativeActivated(false);
			}
		
		public void keyTyped(KeyEvent e)
			{
				
			}
		
		public class InterfaceModeUpdate extends EventObject
			{
				/**
			 * 
			 */
				private static final long	serialVersionUID	= 1L;
				
				public InterfaceModeUpdate(Object source)
					{
						super(source);
					}
			}
		
		public interface InterfaceModeUpdateListener extends EventListener
			{
				public void interfaceModeUpdated(InterfaceModeUpdate evt);
			}
		
		public void addInterfaceModeUpdateListener(InterfaceModeUpdateListener listener)
			{
				eventListeners.add(InterfaceModeUpdateListener.class, listener);
			}
		
		public void removeInterfaceModeUpdate(InterfaceModeUpdateListener listener)
			{
				eventListeners.remove(InterfaceModeUpdateListener.class, listener);
			}
		
		protected void interfaceModeUpdated(InterfaceMode mode)
			{
				InterfaceModeUpdate evt = new InterfaceModeUpdate(mode);
				InterfaceModeUpdateListener[] listeners = eventListeners.getListeners(InterfaceModeUpdateListener.class);
				for (int i = 0; i < listeners.length; i++)
					listeners[i].interfaceModeUpdated(evt);
			}
		
		public PathwayElementTypeCycler getPathwayElementTypeCycler()
			{
				return pathwayElementTypeCycler;
			}
		
		public void setCurrentElement(PathwayElementTypeCycler pathwayElementTypeCycler)
			{
				this.pathwayElementTypeCycler = pathwayElementTypeCycler;
			}
		
		public void updateDataSource(DataSource dataSource)
			{
				pathwayElementTypeCycler.updateDataSource(dataSource);
			}
		
		private boolean																		alternativeActivated;
		private final PathwaysViewUI					pathwaysViewUI;
		private InterfaceMode[]										modes;
		private InterfaceMode												activeMode;
		private InterfaceMode												alternativeMode;
		private PathwayElementTypeCycler	pathwayElementTypeCycler;
		protected EventListenerList						eventListeners;
		
	}
