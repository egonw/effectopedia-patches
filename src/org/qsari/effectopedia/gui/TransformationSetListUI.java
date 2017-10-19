package org.qsari.effectopedia.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.base.Titleable;
import org.qsari.effectopedia.base.ids.IDs;
import org.qsari.effectopedia.core.objects.TransformationSet;
import org.qsari.effectopedia.defaults.DefaultGOSettings;
import org.qsari.effectopedia.gui.comp.CollapsableTitledPanel;
import org.qsari.effectopedia.gui.core.LoadableEditorUI;
import org.qsari.effectopedia.gui.help.ContextSensitivePanel;
import org.qsari.effectopedia.gui.help.RootHelpContext;
import org.qsari.effectopedia.gui.toolbars.ListEditorToolbarUI;

public class TransformationSetListUI extends ContextSensitivePanel implements AdjustableUI, LoadableEditorUI, InitializableUI
	{
		protected ListEditorToolbarUI	jletuiTransformationSets;
		
		protected TransformationSetsUI								suiTransformationSets;
		
		public static final int				defaultItemHeight	= 300;
		
		public static class TrSetUI extends CollapsableTitledPanel
			{
				
				/**
			 * 
			 */
				private static final long							serialVersionUID	= 1L;
				private TransformationSetUI	trSetUI;
				
				public TrSetUI(RootHelpContext rootHelpContext)
					{
						super(new TransformationSetUI(null), null, true,rootHelpContext);
						trSetUI = (TransformationSetUI)getBodyPanel();
						trSetUI.setRootHelpContext(getRootHelpContext());
						jtfTitle.setForeground(DefaultGOSettings.inVivoTestColor);
						setAllowRedirecting(false);
						setAllowHTMLContent(false);
						setPreferredHeight(defaultItemHeight);
					}
				
				public void load(Object o, boolean readonly)
					{
						if (!(o instanceof Titleable) || !(o instanceof EffectopediaObject))
							return;
						readonly = readonly || ((EffectopediaObject) o).isReadonly();
						this.eo = (EffectopediaObject) o;
						this.defaultObject = eo.isDefaultID();
						loadTitle(o, readonly);
						trSetUI.load(o, readonly);
						updateOptimalSize();
					}
				
			}
		
		/**
		 * 
		 */
		public class TransformationSetsUI extends IndexedObjectListUI<TrSetUI>
			{
				
				public TransformationSetsUI(RootHelpContext rootHelpContext)
				{
					super(rootHelpContext);
				}

				/**
			 * 
			 */
				private static final long	serialVersionUID	= 1L;
				
				public TrSetUI add(boolean enableSelectionDialog)
					{
						// if (compoundsIDs == null)
						// return null;
						// ExistingMethodDialog.DIALOG.load(DefaultEffectopediaObjects.DEFAULT_INVESTIGATION,
						// false);
						// Substance_Chemical compund = (Substance_Chemical)
						// ExistingChemicalDialog.DIALOG.getSelectedSubstance();
						// if (compund == null)
						// compund =
						// DefaultEffectopediaObjects.DEFAULT_SUBSTANCE_CHEM.clone(compoundsIDs.getParent(),
						// compoundsIDs.getDataSource());
						TrSetUI newSubstanceUI = new TrSetUI(TransformationSetListUI.this.rootHelpContext);
						// cuiCompounds.add(newCompoundUI, compund);
						suiTransformationSets.add(newSubstanceUI);
						return newSubstanceUI;
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
				frame.getContentPane().add(new TransformationSetListUI(null));
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				frame.pack();
				frame.setVisible(true);
			}
		
		public TransformationSetListUI(RootHelpContext rootHelpContext)
			{
				super(rootHelpContext);
				setName("tr_set_list");
				initGUI();
				adjustUI(EDIT);
			}
		
		private void initGUI()
			{
				try
					{
						setPreferredSize(optimalSize);
						BorderLayout thisLayout = new BorderLayout();
						this.setLayout(thisLayout);
						this.setBorder(BorderFactory.createTitledBorder(new LineBorder(DefaultGOSettings.inVivoTestColor, 1, true), "Transformation sets", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new java.awt.Font(
								"Segoe UI", 2, 12), DefaultGOSettings.inVivoTestColor));
						this.setBackground(Color.WHITE);
							{
								suiTransformationSets = new TransformationSetsUI(rootHelpContext);
								this.add(suiTransformationSets, BorderLayout.CENTER);
								suiTransformationSets.setBackground(Color.WHITE);
							}
							{
								jletuiTransformationSets = new ListEditorToolbarUI(suiTransformationSets, "substance", ListEditorToolbarUI.DEFAULT, FlowLayout.RIGHT);
								this.add(jletuiTransformationSets, BorderLayout.SOUTH);
								jletuiTransformationSets.setVisible(true);
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
		
		public void load(Object o, boolean readonly)
			{
				if (!(o instanceof IDs))
					return;
				substanceIDs = (IDs<TransformationSet>) o;
				readonly = readonly || substanceIDs.isReadonly();
				suiTransformationSets.setIndexedList(substanceIDs, readonly);
				jletuiTransformationSets.updateEditButtons(readonly);
			}
		
		public void updateOptimalSize()
			{
				optimalSize.width = suiTransformationSets.getWidth();
				optimalSize.height = suiTransformationSets.getPreferredSize().height + ((jletuiTransformationSets != null) ? jletuiTransformationSets.getPreferredSize().height : 0);
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
				suiTransformationSets.initializeUI();
			}
		
		/**
		 * 
		 */
		private static final long			serialVersionUID		= 1L;
		private Dimension															optimalSize		= new Dimension(300, 64);
		private IDs<TransformationSet>	substanceIDs	= null;
		
	}