package org.qsari.effectopedia.gui.obj_prop;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.EventObject;

import javax.swing.JFrame;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.core.objects.Method_InSilicoGlobalModel;
import org.qsari.effectopedia.data.objects.ObjectProperties;
import org.qsari.effectopedia.data.objects.ObjectProperty;
import org.qsari.effectopedia.data.objects.ObjectPropertyMultivalued_Documented;
import org.qsari.effectopedia.data.objects.ObjectPropertyType;
import org.qsari.effectopedia.gui.AdjustableUI;
import org.qsari.effectopedia.gui.AdjustbleUserInterfaceTools;
import org.qsari.effectopedia.gui.InitializableUI;
import org.qsari.effectopedia.gui.SizeOptimizableUI;
import org.qsari.effectopedia.gui.comp.CollapsableListTitledBorder;
import org.qsari.effectopedia.gui.comp.CollapsableListTitledBorder.CollapsableStatusChangeListener;
import org.qsari.effectopedia.gui.comp.CollapsableTitledPanel;
import org.qsari.effectopedia.gui.core.LoadableEditorUI;
import org.qsari.effectopedia.gui.default_ui.ObjectPropertyValueUI;
import org.qsari.effectopedia.gui.default_ui.ObjectPropertyValuesUI;
import org.qsari.effectopedia.gui.help.ContextSensitivePanel;
import org.qsari.effectopedia.gui.help.RootHelpContext;
import org.qsari.effectopedia.gui.obj_prop.ObjectPropertyTableModel.ObjectPropertyChangeListener;
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

public class ObjectPropertiesListUI extends ContextSensitivePanel implements AdjustableUI, LoadableEditorUI, InitializableUI, CollapsableStatusChangeListener, ComponentListener
	{
		public static class ObjectPropertyUI extends CollapsableTitledPanel implements ObjectPropertyChangeListener
			{
				
				/**
				* 
				*/
				private static final long						serialVersionUID		= 1L;
				private ObjectPropertyEditorUI	modelParameterUI;
				private static final int							defaultItemHeight	= 120;
				
				public ObjectPropertyUI(RootHelpContext rootHelpContext)
					{
						super(null, new ObjectPropertyValuesUI(rootHelpContext), true, rootHelpContext);
						modelParameterUI = new ObjectPropertyEditorUI(rootHelpContext);
						modelParameterUI.addObjectPropertyChangeListener(this);
						setBodyPanel(modelParameterUI);
						setAllowRedirecting(false);
						setPreferredHeight(defaultItemHeight);
					}
					
				public ObjectPropertyValueUI getTitleUI(int index)
					{
						ObjectPropertyValuesUI valuesUI = (ObjectPropertyValuesUI) getTitlePanel();
						return valuesUI.getValueUI(index);
					}
					
				@Override
				public void load(Object o, boolean readonly)
					{
						if (!(o instanceof ObjectProperty))
							return;
						this.eo = (ObjectPropertyType) ((ObjectProperty) o).getType();
						this.defaultObject = eo.isDefaultID();
						boolean multivalued = ((ObjectPropertyType) eo).isAcceptingMultipleValues();
						setExpanded(((ObjectPropertyType) eo).hasSubProperties());
						loadTitle(o, readonly);
						loadContent(o, readonly);
						updatePrefferedHeight();
						setCollapsable(multivalued || ((ObjectProperty) o).getValueAndUnit().getSubProperties() != null);
					}
					
				protected void updatePrefferedHeight()
					{
						setPreferredHeight(modelParameterUI.getPreferredSize().height);
						modelParameterUI.updateOptimalSize();
					}
					
				@Override
				public void propertyChanged(EventObject evt)
					{
						loadTitle(evt.getSource(), false);
					}
					
				public void setNameWidth(int maxNameWidth)
					{
						ObjectPropertyValuesUI valuesUI = (ObjectPropertyValuesUI) getTitlePanel();
						for (int i = 0; i < valuesUI.getValueUICount(); i++)
							valuesUI.getValueUI(i).setNameWidth(maxNameWidth);
						if (collapsable)
							modelParameterUI.setNameWidth(maxNameWidth + 2 + jbExpand.getPreferredSize().width);
						else
							modelParameterUI.setNameWidth(maxNameWidth + 2);
					}
					
			}
			
		/**
		 * 
		 */
		public class ObjectPropertiesListManagerUI extends ObjectPropertiesUI<ObjectPropertyUI>
			{
				/**
				* 
				*/
				private static final long serialVersionUID = 1L;
				
				public ObjectPropertiesListManagerUI(RootHelpContext rootHelpContext)
					{
						super(rootHelpContext);
					}
					
				public ObjectPropertyUI add(boolean enableSelectionDialog)
					{
						if (objectProperties == null)
							return null;
						ObjectPropertyUI newObjectProperty = null;
						if (enableSelectionDialog)
							{
								ObjectPropertyTypeDialog.DIALOG.getOwnerClasses().clear();
								ObjectPropertyTypeDialog.DIALOG.getOwnerClasses().add(ownerClass);
								ObjectPropertyTypeDialog.DIALOG.load(objectProperties.getTypes().getAll(), false);
								for (ObjectPropertyType objectPropertyType : ObjectPropertyTypeDialog.DIALOG.selectedObjectPropertyType)
									{
										if (objectProperties.getTypes().contains(objectPropertyType))
											continue;
										newObjectProperty = new ObjectPropertyUI(rootHelpContext);
										ObjectPropertyMultivalued_Documented op = new ObjectPropertyMultivalued_Documented(objectProperties.getOwner(), objectPropertyType);
										oplmuiObjectPropertiesList.add(newObjectProperty, op);
									}
								if (newObjectProperty == null)
									newObjectProperty = new ObjectPropertyUI(rootHelpContext);
							}
						else
							{
								newObjectProperty = new ObjectPropertyUI(rootHelpContext);
								oplmuiObjectPropertiesList.add(newObjectProperty);
							}
						oplmuiObjectPropertiesList.synchronizeNameWidths();
						return newObjectProperty;
					}
					
				public void chagneAll(boolean expanded)
					{
						for (ObjectPropertyUI parameter : oplmuiObjectPropertiesList.list)
							{
								parameter.setExpanded(expanded);
								parameter.updatePrefferedHeight();
							}
						super.updateOptimalSize();
					}
					
				protected void synchronizeNameWidths()
					{
						if (isLoading())
							return;
						int maxNameWidth = -1;
						for (ObjectPropertyUI parameter : oplmuiObjectPropertiesList.list)
							{
								ObjectPropertyValueUI valueUI = parameter.getTitleUI(0);
								int nameWidth = valueUI.getNameWidth();
								if (maxNameWidth < nameWidth)
									maxNameWidth = nameWidth;
							}
						maxNameWidth += 4;
						for (ObjectPropertyUI parameter : oplmuiObjectPropertiesList.list)
							parameter.setNameWidth(maxNameWidth);
					}
					
			}
			
		/**
		 * Auto-generated main method to display this JPanel inside a new JFrame.
		 */
		public static void main(String[] args)
			{
				JFrame frame = new JFrame();
				frame.getContentPane().add(new ObjectPropertiesListUI("Model parameters", "model parameter", "V.1.", null));
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				frame.pack();
				frame.setVisible(true);
			}
			
		public ObjectPropertiesListUI(String title, String elementType, String category, RootHelpContext rootHelpContext)
			{
				super(rootHelpContext);
				initGUI(title, elementType);
				adjustUI(EDIT);
				addComponentListener(this);
			}
			
		private void initGUI(String title, String elementType)
			{
				try
					{
						setPreferredSize(optimalSize);
						BorderLayout thisLayout = new BorderLayout();
						this.setLayout(thisLayout);
						titleBorder = CollapsableListTitledBorder.createCollapsableListTitledBorder(this, null, title, TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 2, 12));
						this.setBorder(titleBorder);
						titleBorder.setExpanded(false);
						titleBorder.addCollapsableStatusChangeListener(this);
						this.setBackground(Color.WHITE);
							{
								oplmuiObjectPropertiesList = new ObjectPropertiesListManagerUI(rootHelpContext);
								this.add(oplmuiObjectPropertiesList, BorderLayout.CENTER);
								oplmuiObjectPropertiesList.setBackground(Color.WHITE);
								oplmuiObjectPropertiesList.add(false);
							}
							{
								letuiObjectPropertiesListEditor = new ListEditorToolbarUI(oplmuiObjectPropertiesList, elementType, ListEditorToolbarUI.DEFAULT, FlowLayout.RIGHT);
								this.add(letuiObjectPropertiesListEditor, BorderLayout.SOUTH);
								letuiObjectPropertiesListEditor.setVisible(true);
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
				if (!(o instanceof ObjectProperties))
					return;
				objectProperties = (ObjectProperties) o;
				oplmuiObjectPropertiesList.setObjectProperties(objectProperties, readonly);
				oplmuiObjectPropertiesList.synchronizeNameWidths();
				letuiObjectPropertiesListEditor.updateEditButtons(readonly);
				updateOptimalSize();
			}
			
		public void updateOptimalSize()
			{
				optimalSize.width = availableWidth;
				optimalSize.height = oplmuiObjectPropertiesList.getPreferredSize().height + 32;
				if ((letuiObjectPropertiesListEditor != null) && editable)
					optimalSize.height += letuiObjectPropertiesListEditor.getPreferredSize().height;
				// oplmuiObjectPropertiesList.setPreferredSize(new Dimension(availableWidth,
				// oplmuiObjectPropertiesList.getPreferredSize().height));
				// setSize(optimalSize);
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
				oplmuiObjectPropertiesList.initializeUI();
			}
			
		public ListEditorToolbarUI getListEditorToolbar()
			{
				return letuiObjectPropertiesListEditor;
			}
			
		public void collapse()
			{
				titleBorder.setExpanded(false);
				statusChanged(null);
			}
			
		public void expand()
			{
				titleBorder.setExpanded(true);
				statusChanged(null);
			}
			
		@Override
		public void statusChanged(EventObject evt)
			{
				oplmuiObjectPropertiesList.chagneAll(titleBorder.isExpanded());
				updateOptimalSize();
				invalidate();
			}
			
		@Override
		public void componentResized(ComponentEvent e)
			{
				// availableWidth = this.getParent().getWidth();
				// updateOptimalSize();
			}
			
		@Override
		public void componentMoved(ComponentEvent e)
			{
			}
			
		@Override
		public void componentShown(ComponentEvent e)
			{
			}
			
		@Override
		public void componentHidden(ComponentEvent e)
			{
			}
			
		public boolean isEditable()
			{
				return editable;
			}
			
		public void setEditable(boolean editable)
			{
				this.editable = editable;
				letuiObjectPropertiesListEditor.setVisible(editable);
				updateOptimalSize();
			}
			
		public Class<? extends EffectopediaObject> getOwnerClass()
			{
				return ownerClass;
			}
			
		public void setOwnerClass(Class<? extends EffectopediaObject> ownerClass)
			{
				this.ownerClass = ownerClass;
			}
			
		/**
		 * 
		 */
		private static final long																			serialVersionUID	= 1L;
		
		private ListEditorToolbarUI																	letuiObjectPropertiesListEditor;
		private Class<? extends EffectopediaObject>	ownerClass							= Method_InSilicoGlobalModel.class;
		private ObjectPropertiesListManagerUI							oplmuiObjectPropertiesList;
		private CollapsableListTitledBorder									titleBorder;
		private int																																	availableWidth			= 1900;
		private Dimension																											optimalSize						= new Dimension(400, 400);
		private ObjectProperties																				objectProperties	= null;
		private boolean																													editable									= true;
	}