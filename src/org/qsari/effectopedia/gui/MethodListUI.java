package org.qsari.effectopedia.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.base.ids.ReferenceIDs;
import org.qsari.effectopedia.core.objects.Method;
import org.qsari.effectopedia.core.objects.Method_InSilicoGlobalModel;
import org.qsari.effectopedia.core.objects.Method_Study;
import org.qsari.effectopedia.defaults.DefaultEffectopediaObjects;
import org.qsari.effectopedia.gui.comp.CollapsableTitledPanel;
import org.qsari.effectopedia.gui.core.LoadableEditorUI;
import org.qsari.effectopedia.gui.help.ContextSensitivePanel;
import org.qsari.effectopedia.gui.help.RootHelpContext;
import org.qsari.effectopedia.gui.toolbars.ListEditorToolbarUI;

/**
 * This code was edited or generated using CloudGarden's Jigloo
 * SWT/Swing GUI Builder, which is free for non-commercial
 * use. If Jigloo is being used commercially (ie, by a corporation,
 * company or business for any purpose whatever) then you
 * should purchase a license for each developer using Jigloo.
 * Please visit www.cloudgarden.com for details.
 * Use of Jigloo implies acceptance of these licensing terms.
 * A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
 * THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
 * LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
 */
/**
 * @version 1 @(#)InvestigationListUI.java 1.0
 * @author Hristo Aladjov
 */

public class MethodListUI<M extends Method> extends ContextSensitivePanel implements AdjustableUI, LoadableEditorUI, InitializableUI
	{
		/**
		 * 
		 */
		private static final long			serialVersionUID	= 1L;
		
		private ListEditorToolbarUI	jletuiStudies;
		
		private MethodsUI											suiMehtods;
		
		public static class MethodUI extends CollapsableTitledPanel implements RootHelpContext
			{
				
				/**
				* 
				*/
				private static final long serialVersionUID = 1L;
				
				public MethodUI()
					{
						super(null, null, true, null);
						setAllowRedirecting(true);
					}
					
				public void load(Object o, boolean readonly)
					{
						if (!(o instanceof Method))
							return;
						readonly = readonly || ((EffectopediaObject) o).isReadonly();
						this.eo = (EffectopediaObject) o;
						this.defaultObject = eo.isDefaultID();
						loadTitle(o, readonly);
						loadContent(((Method) o).getSummaryDescription(), readonly);
					}
					
			}
			
		/**
		 * 
		 */
		public class MethodsUI extends IndexedObjectListUI<MethodUI>
			{
				public MethodsUI(RootHelpContext rootHelpContext)
					{
						super(rootHelpContext);
					}
					
				/**
				* 
				*/
				private static final long serialVersionUID = 1L;
				
				@SuppressWarnings("unchecked")
				public MethodUI add(boolean enableSelectionDialog)
					{
						if (methodIDs == null)
							return null;
						MethodUI newMethodUI = new MethodUI();
						if (enableSelectionDialog)
							{
								ExistingMethodDialog.DIALOG.load(defaultObject, false);
								M method = (M) ExistingMethodDialog.DIALOG.getSelectedMethod();
								if (method == null)
									method = (M) defaultObject.clone(methodIDs.getParent(), methodIDs.getDataSource());
								if ((method instanceof Method_Study) && (methodIDs.getParent() != null))
									((Method_Study) method).getRelatedTests().add(methodIDs.getParent());
								if ((method instanceof Method_InSilicoGlobalModel) && (methodIDs.getParent() != null))
									((Method_InSilicoGlobalModel) method).getModelCallers().add(methodIDs.getParent());
								suiMehtods.add(newMethodUI, method);
							}
						else
							suiMehtods.add(newMethodUI);
						newMethodUI.scrollRectToVisible(newMethodUI.getBounds());
						return newMethodUI;
					}
					
				@Override
				public Object getList()
					{
						return super.getIndexedList();
					}
			}
			
		/**
		 * Auto-generated main method to display this JPanel inside a new JFrame.
		 */
		public static void main(String[] args)
			{
				JFrame frame = new JFrame();
				frame.getContentPane().add(new MethodListUI<Method_Study>("Associated studies", "study", DefaultEffectopediaObjects.DEFAULT_STUDY, null));
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				frame.pack();
				frame.setVisible(true);
			}
			
		public MethodListUI(String title, String itemsType, M defaultObject, RootHelpContext rootHelpContext)
			{
				super(rootHelpContext);
				setName("method_list");
				this.title = title;
				this.itemsType = itemsType;
				this.defaultObject = defaultObject;
				initGUI();
				adjustUI(EDIT);
			}
			
		private void initGUI()
			{
				try
					{
						setPreferredSize(new Dimension(400, 300));
						BorderLayout thisLayout = new BorderLayout();
						this.setLayout(thisLayout);
						this.setBorder(BorderFactory.createTitledBorder(null, title, TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 2, 12)));
						this.setBackground(Color.WHITE);
							{
								suiMehtods = new MethodsUI(rootHelpContext);
								this.add(suiMehtods, BorderLayout.CENTER);
								suiMehtods.setBackground(Color.WHITE);
								suiMehtods.add(false);
							}
							{
								jletuiStudies = new ListEditorToolbarUI(suiMehtods, itemsType, ListEditorToolbarUI.DEFAULT, FlowLayout.RIGHT);
								this.add(jletuiStudies, BorderLayout.SOUTH);
								jletuiStudies.setVisible(true);
							}
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
				AdjustbleUserInterfaceTools.adjustChildren(this, visualOptions);
			}
			
		@SuppressWarnings("unchecked")
		public void load(Object o, boolean readonly)
			{
				if (!(o instanceof ReferenceIDs))
					return;
				methodIDs = (ReferenceIDs<M>) o;
				readonly = readonly || methodIDs.isReadonly();
				suiMehtods.setIndexedList(methodIDs, readonly);
				jletuiStudies.updateEditButtons(readonly);
			}
			
		public void updateOptimalSize()
			{
				optimalSize.width = suiMehtods.getWidth();
				optimalSize.height = suiMehtods.getPreferredSize().height + ((jletuiStudies != null) ? jletuiStudies.getPreferredSize().height : 0);
				setSize(optimalSize);
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
			
		public void initializeUI()
			{
				suiMehtods.initializeUI();
			}
			
		private String										title;
		private String										itemsType;
		private M															defaultObject;
		private Dimension							optimalSize	= new Dimension(400, 100);
		private ReferenceIDs<M>	methodIDs			= null;
	}