package org.qsari.effectopedia.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;

import org.qsari.effectopedia.base.ids.DescriptionIDs;
import org.qsari.effectopedia.base.ids.ReferenceIDs;
import org.qsari.effectopedia.core.objects.DescriptionSection;
import org.qsari.effectopedia.core.objects.DescriptionSection_Structured;
import org.qsari.effectopedia.defaults.DefaultEffectopediaObjects;
import org.qsari.effectopedia.gui.comp.CollapsableTitledPanel;
import org.qsari.effectopedia.gui.core.ClipboardTransferableUI;
import org.qsari.effectopedia.gui.core.LoadableEditorUI;
import org.qsari.effectopedia.gui.default_ui.DefaultUIFactory;
import org.qsari.effectopedia.gui.help.ContextSensitivePanel;
import org.qsari.effectopedia.gui.help.RootHelpContext;
import org.qsari.effectopedia.gui.toolbars.ListEditorToolbarUI;
import org.qsari.effectopedia.gui.util.ClipboardUtilities;

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
 * @version 1 @(#)DescriptionUI.java 1.0
 * @author Hristo Aladjov
 */

public class DescriptionUI extends ContextSensitivePanel implements AdjustableUI, LoadableEditorUI, InitializableUI
	{
		/**
		 * 
		 */
		private static final long serialVersionUID = -2213834317012137887L;
		
		public class DescriptionSectionUI extends CollapsableTitledPanel
			{
				/**
				* 
				*/
				private static final long serialVersionUID = 1L;
				
				public DescriptionSectionUI(RootHelpContext rootHelpContext)
					{
						super(null, null, true, rootHelpContext);
						setName("description_section");
					}
					
				public DescriptionSectionUI(JComponent bodyPanel, JComponent titlePanel, boolean expandedByDefault, RootHelpContext rootHelpContext)
					{
						super(bodyPanel, titlePanel, expandedByDefault, rootHelpContext);
						setName("description_section");
					}
					
			}
			
		/**
		 * 
		 */
		public class DescriptionSectionsUI extends IndexedObjectListUI<DescriptionSectionUI> implements ClipboardTransferableUI
			{
				public DescriptionSectionsUI(RootHelpContext rootHelpContext)
					{
						super(rootHelpContext);
					}
					
				/**
				* 
				*/
				private static final long serialVersionUID = 1L;
				
				public DescriptionSectionUI add(boolean enableSelectionDialog)
					{
						DescriptionSectionUI dsuiDefaultSection = new DescriptionSectionUI(rootHelpContext);
						dsuiDefaultSection.setPreferredSize(new java.awt.Dimension(400, 100));
						dsuiDescriptionSections.add(dsuiDefaultSection);
						return dsuiDefaultSection;
					}
					
				@Override
				public Object getList()
					{
						return super.getIndexedList();
					}
					
				@Override
				public void setIndexedList(ReferenceIDs<?> indexedList, boolean readonly)
					{
						this.indexedList = null;
						list.clear();
						this.removeAll();
						for (int index = 0; index < indexedList.size(); index++)
							{
								DescriptionSection ds = (DescriptionSection) indexedList.getCachedObject(index);
								if (ds instanceof DescriptionSection_Structured)
									{
										DescriptionSectionUI dsUI = new DescriptionSectionUI(DefaultUIFactory.CONTENT_INTERFACES.getInterface(((DescriptionSection_Structured) ds).getStructuredContentClass(), rootHelpContext),
												DefaultUIFactory.TITLE_INTERFACES.getInterface(((DescriptionSection_Structured) ds).getStructuredContentClass(), rootHelpContext), true, DescriptionUI.this.rootHelpContext);
										dsUI.addMouseMotionListener(this);
										add(dsUI, ds);
										dsUI.load(ds, readonly);
										dsUI.setContext(String.valueOf(ds.getOriginalDefaultID()));
									}
								else
									{
										DescriptionSectionUI dsUI = add(false);
										dsUI.addMouseMotionListener(this);
										dsUI.load(ds, readonly);
										dsUI.setContext(String.valueOf(ds.getOriginalDefaultID()));
									}
							}
						this.indexedList = indexedList;
						updateOptimalSize();
					}
					
				@Override
				public void copy()
					{
						if (descriptionIDs == null)
							return;
						ClipboardUtilities.clear();
						DescriptionSection[] sections = descriptionIDs.getCachedObjects();
						for (DescriptionSection section : sections)
							ClipboardUtilities.addDescriptionSection(section.getTitle(), section.getContent());
						ClipboardUtilities.setMultiFlavorClipboard();
					}
					
				@Override
				public void paste()
					{
						descriptionIDs = (DescriptionIDs) super.getIndexedList();
						if ((descriptionIDs != null) && (ClipboardUtilities.parseDescriptionSections()))
							{
								for (int i = 0; i <= ClipboardUtilities.sectionTitles.size() - 1; i++)
									{
										DescriptionSectionUI ui;
										if ((descriptionIDs.size() == 1) && (descriptionIDs.getCachedObject(0).isDefaultID()))
											ui = list.get(0);
										else
											ui = add(false);
										DescriptionSection section = DefaultEffectopediaObjects.DEFAULT_DESCRIPTION_SECTION.clone(descriptionIDs, descriptionIDs.getDataSource());
										section.setTitle(ClipboardUtilities.sectionTitles.get(i));
										section.setContent(ClipboardUtilities.sectionContents.get(i));
										descriptionIDs.set(section, descriptionIDs.size() - 1);
										ui.load(section, false);
									}
							}
					}
					
				@Override
				public void setRootHelpContext(RootHelpContext rootHelpContext)
					{
						super.setRootHelpContext(rootHelpContext);
						for (DescriptionSectionUI ds : list)
							{
								ds.setRootHelpContext(rootHelpContext);
								RootHelpContext.addMouseMotionListeners(ds, rootHelpContext,true);
							}
					}
			}
			
		/**
		 * Auto-generated main method to display this JPanel inside a new JFrame.
		 */
		public static void main(String[] args)
			{
				JFrame frame = new JFrame();
				frame.getContentPane().add(new DescriptionUI(null));
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				frame.pack();
				frame.setVisible(true);
			}
			
		public DescriptionUI(RootHelpContext rootHelpContext)
			{
				super(rootHelpContext);
				setName("description");
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
						this.setBorder(BorderFactory.createTitledBorder(null, "Description", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 2, 12)));
						this.setBackground(Color.WHITE);
							{
								dsuiDescriptionSections = new DescriptionSectionsUI(rootHelpContext);
								this.add(dsuiDescriptionSections, BorderLayout.CENTER);
								dsuiDescriptionSections.add(false);
							}
							{
								letuiDescription = new ListEditorToolbarUI(dsuiDescriptionSections, "section", ListEditorToolbarUI.ALL, FlowLayout.RIGHT);
								this.add(letuiDescription, BorderLayout.SOUTH);
								letuiDescription.setVisible(true);
								letuiDescription.addMouseMotionListener(this);
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
				if ((visualOptions & DESCRIPTION) != 0)
					{
						setVisible(true);
						AdjustbleUserInterfaceTools.adjustChildren(this, visualOptions);
					}
				else
					{
						setVisible(false);
					}
					
			}
			
		public void load(Object o, boolean readonly)
			{
				if (!(o instanceof DescriptionIDs))
					return;
				descriptionIDs = (DescriptionIDs) o;
				readonly = readonly || descriptionIDs.isReadonly();
				dsuiDescriptionSections.setIndexedList(descriptionIDs, readonly);
				letuiDescription.updateEditButtons(readonly);
			}
			
		public void updateOptimalSize()
			{
				optimalSize.width = dsuiDescriptionSections.getWidth();
				optimalSize.height = dsuiDescriptionSections.getPreferredSize().height + ((letuiDescription != null) ? letuiDescription.getPreferredSize().height : 0);
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
			
		private Dimension optimalSize = new Dimension(400, 100);
		
		public void initializeUI()
			{
				dsuiDescriptionSections.initializeUI();
			}
			
		private DescriptionIDs								descriptionIDs	= null;
		private ListEditorToolbarUI			letuiDescription;
		private DescriptionSectionsUI	dsuiDescriptionSections;
		
	}