package org.qsari.effectopedia.gui.obj_prop;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.core.objects.Link;
import org.qsari.effectopedia.core.objects.Link.LinkNature;
import org.qsari.effectopedia.core.objects.Link_EffectToEffect;
import org.qsari.effectopedia.core.objects.TransformationSet;
import org.qsari.effectopedia.data.quantification.FunctionalRelationship;
import org.qsari.effectopedia.data.quantification.FunctionalRelationship_Analytic;
import org.qsari.effectopedia.data.quantification.FunctionalRelationships;
import org.qsari.effectopedia.data.quantification.TransformationFunctionType;
import org.qsari.effectopedia.gui.AdjustableUI;
import org.qsari.effectopedia.gui.AdjustbleUserInterfaceTools;
import org.qsari.effectopedia.gui.InitializableUI;
import org.qsari.effectopedia.gui.SizeOptimizableUI;
import org.qsari.effectopedia.gui.core.LoadableEditorUI;
import org.qsari.effectopedia.gui.core.ManageableIndexedListUI;
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
public abstract class FunctionalRelationshipsUI<P extends javax.swing.JPanel & LoadableEditorUI> extends ContextSensitivePanel implements AdjustableUI, ManageableIndexedListUI<P>, InitializableUI
	{
		
		/**
	 * 
	 */
		private static final long	serialVersionUID	= 1L;
		
		public FunctionalRelationshipsUI(RootHelpContext rootHelpContext)
			{
				super(rootHelpContext);
				list = new ArrayList<P>();
				activeObject = new ActiveObject();
				initGUI();
			}
		
		public class ActiveObject implements FocusListener
			{
				public void focusGained(FocusEvent e)
					{
						// System.out.println("Focus gained" + e);
					}
				
				public void focusLost(FocusEvent e)
					{
						// System.out.println("Focus lost" + e);
					}
			}
		
		private void initGUI()
			{
				try
					{
						BoxLayout thisLayout = new BoxLayout(this, javax.swing.BoxLayout.Y_AXIS);
						this.setLayout(thisLayout);
					}
				catch (Exception e)
					{
						e.printStackTrace();
					}
			}
		
		public abstract P add(boolean enableSelectionDialog);
		
		public void add(P panel)
			{
				list.add(panel);
				activeListIndex = list.size() - 1;
				super.add(panel);
				panel.addFocusListener(activeObject);
				if (functionalRelationships != null)
					{
						EffectopediaObject owner = functionalRelationships.getOwner();
						FunctionalRelationship fnRel;
						if (owner instanceof Link_EffectToEffect)
							{
								fnRel = updateFnRel(owner, ((Link) owner).getLinkNature(), null);
								fnRel = generateDefaultTitlesIfNeeded(((Link_EffectToEffect) owner), fnRel);
								functionalRelationships.add(fnRel);
								panel.load(fnRel, false);
							}
						else if (owner instanceof TransformationSet)
							{
								fnRel = new FunctionalRelationship_Analytic(owner);
								fnRel.setTransformationType(TransformationFunctionType.TYPES[defaultTransfIndex++]);
								if (defaultTransfIndex>=TransformationFunctionType.TYPES.length)
									defaultTransfIndex = 0;
								fnRel = generateDefaultTitlesIfNeeded(fnRel);
								functionalRelationships.add(fnRel);
								panel.load(fnRel, false);
							}
					}
				updateOptimalSize();
				this.revalidate();
			}
		
		public FunctionalRelationship updateFnRel(EffectopediaObject owner, LinkNature linkNature, FunctionalRelationship fnRel)
			{
				return fnRel;
			}
		
		public FunctionalRelationship generateDefaultTitlesIfNeeded(Link_EffectToEffect link, FunctionalRelationship fnRel)
			{
				return fnRel;
			}
		
		public FunctionalRelationship generateDefaultTitlesIfNeeded(FunctionalRelationship fnRel)
			{
				return fnRel;
			}
		
		public void add(P panel, FunctionalRelationship fn)
			{
				list.add(panel);
				activeListIndex = list.size() - 1;
				super.add(panel);
				panel.addFocusListener(activeObject);
				if (functionalRelationships != null)
					{
						functionalRelationships.add(fn);
						panel.load(fn, false);
					}
				updateOptimalSize();
				this.revalidate();
			}
		
		public void remove()
			{
				if ((activeListIndex >= 0) && (activeListIndex < list.size()))
					{
						P panel = list.get(activeListIndex);
						panel.removeFocusListener(activeObject);
						list.remove(activeListIndex);
						this.remove(activeListIndex);
						if (functionalRelationships != null)
							functionalRelationships.remove(activeListIndex);
						activeListIndex--;
						updateOptimalSize();
						revalidate();
					}
			}
		
		public int itemsCount()
			{
				return list.size();
			}
		
		public void reset()
			{
				list.clear();
				this.removeAll();
				activeListIndex = -1;
				if (functionalRelationships != null)
					functionalRelationships.clear();
				updateOptimalSize();
				revalidate();
			}
		
		public int getActiveListIndex()
			{
				return this.activeListIndex;
			}
		
		public FunctionalRelationships getFunctionalRelationships()
			{
				return functionalRelationships;
			}
		
		/**
		 * Set <code>this.functionalRelationships</code> to a new list and updates the
		 * user interface to reflect the content of the new list. All panels P
		 * implement <code>LoadableEditorUI</code> and are loaded form the elements of
		 * the new indexedList
		 * 
		 * @see LoadableEditorUI
		 * 
		 * @param functionalRelationships
		 *         an <code>FunctionalRelatiionships<?></code> that specifies the list
		 *         of objects to be edited in the FunctionalRelationshipsUI
		 */
		public void setFunctionalRelationships(FunctionalRelationships functionalRelationships, boolean readonly)
			{
				this.functionalRelationships = null;
				list.clear();
				this.removeAll();
				if (functionalRelationships != null)
					for (int index = 0; index < functionalRelationships.size(); index++)
						add(false).load(functionalRelationships.get(index), readonly);
				this.functionalRelationships = functionalRelationships;
				updateOptimalSize();
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
				AdjustbleUserInterfaceTools.adjustChildren(this, visualOptions);
			}
		
		public void updateOptimalSize()
			{
				optimalSize.width = this.getWidth();
				optimalSize.height = 18;
				if ((list != null) && (list.size() > 0))
					for (JPanel panel : list)
						optimalSize.height += panel.getPreferredSize().height;
				this.setPreferredSize(optimalSize);
				setSize(optimalSize);
				setPreferredSize(optimalSize);
				this.setBackground(Color.white);
				this.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
				// JScrollBar scrollbar = this.getVerticalScrollBar();
				// if (scrollbar != null)
				// scrollbar.setValue(scrollbar.getMaximum());
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
		
		@Override
		public Object getList()
			{
				return functionalRelationships;
			}
		
		public void initializeUI()
			{
				if ((list != null) && (list.size() > 0))
					for (P panel : list)
						if (panel instanceof InitializableUI)
							((InitializableUI) panel).initializeUI();
			}
		
		private int																					defaultTransfIndex	= 0;
		private Dimension															optimalSize								= new Dimension(400, 120);
		private FunctionalRelationships	functionalRelationships;
		private int																					activeListIndex;
		private ActiveObject												activeObject;
		protected ArrayList<P>										list;
	}
