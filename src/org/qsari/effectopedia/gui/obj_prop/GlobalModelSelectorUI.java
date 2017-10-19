package org.qsari.effectopedia.gui.obj_prop;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JToolBar;
import javax.swing.WindowConstants;

import org.qsari.effectopedia.base.ids.ReferenceIDs;
import org.qsari.effectopedia.core.Effectopedia;
import org.qsari.effectopedia.core.objects.Link;
import org.qsari.effectopedia.core.objects.Method;
import org.qsari.effectopedia.core.objects.Method_InSilicoGlobalModel;
import org.qsari.effectopedia.core.objects.SubstanceData_InSilico;
import org.qsari.effectopedia.core.objects.Test_InSilico;
import org.qsari.effectopedia.core.ui.UserInterface;
import org.qsari.effectopedia.core.ui.nav.UILocation;
import org.qsari.effectopedia.core.ui.nav.UILocations;
import org.qsari.effectopedia.data.objects.Resource;
import org.qsari.effectopedia.data.quantification.FunctionalRelationship;
import org.qsari.effectopedia.defaults.DefaultEffectopediaObjects;
import org.qsari.effectopedia.gui.UIResources;
import org.qsari.effectopedia.gui.core.LoadableEditorUI;
import org.qsari.effectopedia.gui.help.ContextSensitivePanel;
import org.qsari.effectopedia.gui.help.RootHelpContext;

public class GlobalModelSelectorUI extends ContextSensitivePanel implements LoadableEditorUI, ActionListener
	{
		public static void main(String[] args)
			{
				JFrame frame = new JFrame();
				frame.setContentPane(new GlobalModelSelectorUI(null));
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				frame.pack();
				frame.setVisible(true);
			}
		
		public GlobalModelSelectorUI(RootHelpContext rootHelpContext)
			{
				super(rootHelpContext);
				initGUI();
			}
		
		private void initGUI()
			{
				try
					{
							{
								BoxLayout thisLayout = new BoxLayout(this, BoxLayout.X_AXIS);
								this.setLayout(thisLayout);
								this.setPreferredSize(new java.awt.Dimension(538, 18));
								this.setBackground(Color.white);
								this.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
								this.setSize(538, 18);
									{
										ComboBoxModel<Method_InSilicoGlobalModel> jcbModelSelectorModel = new DefaultComboBoxModel<Method_InSilicoGlobalModel>(new Method_InSilicoGlobalModel[]
											{});
										jcbModelSelector = new JComboBox<Method_InSilicoGlobalModel>();
										this.add(jcbModelSelector);
										jcbModelSelector.setModel(jcbModelSelectorModel);
										jcbModelSelector.setBackground(Color.white);
										jcbModelSelector.setPreferredSize(new java.awt.Dimension(256, 18));
										jcbModelSelector.addActionListener(this);
									}
						
									{
										ComboBoxModel<Resource> jcbMethodSelectorModel = new DefaultComboBoxModel<Resource>(new Resource[]
											{});
										jcbMethodSelector = new JComboBox<Resource>();
										this.add(jcbMethodSelector);
										jcbMethodSelector.setModel(jcbMethodSelectorModel);
										jcbMethodSelector.setBackground(Color.white);
										jcbMethodSelector.setPreferredSize(new java.awt.Dimension(256, 18));
										jcbMethodSelector.addActionListener(this);
									}
									
									{
										jtbAddGlobalModel = new JToolBar();
										this.add(jtbAddGlobalModel);
										jtbAddGlobalModel.setBackground(Color.white);
										jtbAddGlobalModel.setPreferredSize(new java.awt.Dimension(36, 16));
										jtbAddGlobalModel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
											{
												jbEdit = new JButton();
												jtbAddGlobalModel.add(jbEdit);
												jbEdit.setIcon(UIResources.imageIconOptions);
												jbEdit.setPreferredSize(new java.awt.Dimension(15, 15));
												jbEdit.addActionListener(this);
											}
											{
												jbAdd = new JButton();
												jtbAddGlobalModel.add(jbAdd);
												jbAdd.setIcon(UIResources.imageIconAdd);
												jbAdd.setPreferredSize(new java.awt.Dimension(15, 15));
												jbAdd.addActionListener(this);
											}
									}
							}
					}
				catch (Exception e)
					{
						e.printStackTrace();
					}
			}
		
		@SuppressWarnings("unchecked")
		@Override
		public void load(Object o, boolean readonly)
			{
				Method_InSilicoGlobalModel[] options = null;
				isLoading = true;
				Method_InSilicoGlobalModel selected = null;
				if (o instanceof FunctionalRelationship)
					{
						funRel = (FunctionalRelationship) o;
						Method[] availableMethods = Effectopedia.EFFECTOPEDIA.getData().getLiveIndices().getMethods().get();
						ArrayList<Method_InSilicoGlobalModel> inSilicoModes = new ArrayList<Method_InSilicoGlobalModel>();
						for (Method m : availableMethods)
							if ((m instanceof Method_InSilicoGlobalModel) && (!m.isGeneric()) && (((Method_InSilicoGlobalModel)m).compatibleWith(Link.class)))
								inSilicoModes.add((Method_InSilicoGlobalModel) m);
						if (inSilicoModes.size() > 0)
							options = inSilicoModes.toArray(new Method_InSilicoGlobalModel[inSilicoModes.size()]);
						else
							options = new Method_InSilicoGlobalModel[0];
						selected = funRel.getModel();
						updateMethod(selected, funRel.getModelMethod(),true);
					}
				if (o instanceof SubstanceData_InSilico)
					{
						substanceData = (SubstanceData_InSilico) o;
						Test_InSilico test = (Test_InSilico) substanceData.getTest().getCachedObject();
						referenceIDs = test.getGlobalModelIDs();
						options = referenceIDs.getCachedObjects();
						selected = substanceData.getModel();
						updateMethod(selected, substanceData.getModelMethod(), true);
					}
				if ((o instanceof ReferenceIDs) && ((ReferenceIDs<?>) o).getObjectClass() == Method_InSilicoGlobalModel.class)
					{
						funRel = null;
						referenceIDs = (ReferenceIDs<Method_InSilicoGlobalModel>) o;
						options = referenceIDs.getCachedObjects();
						updateMethod(null, null, false);
					}
				ComboBoxModel<Method_InSilicoGlobalModel> jcbModelSelectorModel = new DefaultComboBoxModel<Method_InSilicoGlobalModel>(options);
				jcbModelSelector.setModel(jcbModelSelectorModel);
				jcbModelSelector.setSelectedItem(selected);
				isLoading = false;
			}
		
		protected void updateMethod(Method_InSilicoGlobalModel model, Resource method, boolean showOptions)
			{
				jcbMethodSelector.setVisible(showOptions);
				if ((showOptions)&&(model!=null))
					{
						Resource[] executable = model.getExecutableResources(false);
						if (executable.length > 1)
							{
								ComboBoxModel<Resource> jcbMethodSelectorModel = new DefaultComboBoxModel<Resource>(executable);
								jcbMethodSelector.setModel(jcbMethodSelectorModel);
								jcbMethodSelector.setSelectedItem(method);
								return;
							}
					}
				jcbMethodSelector.setVisible(false);
			}
		
		public Method_InSilicoGlobalModel getSelectedItem()
			{
				return (Method_InSilicoGlobalModel) jcbModelSelector.getSelectedItem();
			}
		
		public int getSelectedIndex()
			{
				return jcbModelSelector.getSelectedIndex();
			}
		
		public void setSelectedItem(Method_InSilicoGlobalModel model)
			{
				jcbModelSelector.setSelectedItem(model);
			}
		
		public void setSelectedIndex(int index)
			{
				jcbModelSelector.setSelectedIndex(index);
			}
		
		@Override
		public void actionPerformed(ActionEvent evt)
			{
				if (isLoading)
					return;
				Object source = evt.getSource();
				if (source == jbEdit)
					{
						Method_InSilicoGlobalModel model = getSelectedItem();
						UILocation location = UILocations.getProperEditor(model);
						UserInterface.getDefaultNavigator().navigate(location, model);
					}
				else if (source == jbAdd)
					{
						Method_InSilicoGlobalModel model = DefaultEffectopediaObjects.DEFAULT_GLOBAL_MODEL.clone();
						model.getModelCallers().add(funRel.getOwner());
						UILocation location = UILocations.getProperEditor(model);
						UserInterface.getDefaultNavigator().navigate(location, model);
					}
				else if (source == jcbModelSelector)
					{
						if (funRel != null)
							funRel.setModel(getSelectedItem());
						if (substanceData != null)
							substanceData.setModel(getSelectedItem());
						fireGlobalModelSelected(evt);
					}
				else if (source == jcbMethodSelector)
					{
						if (funRel != null)
							funRel.setModelMethod((Resource)jcbMethodSelector.getSelectedItem());
						if (substanceData != null)
							substanceData.setModelMethod((Resource)jcbMethodSelector.getSelectedItem());
						fireGlobalModelSelected(evt);
					}
			}
		
		public interface GlobalModelSelectionListener
			{
				public void globalModelSelected(ActionEvent evt);
			}
		
		public void addGlobalModelSelectionListener(GlobalModelSelectionListener listener)
			{
				globalModelSelectionListeners.add(listener);
			}
		
		public void removeGlobalModelSelectionListener(GlobalModelSelectionListener listener)
			{
				globalModelSelectionListeners.remove(listener);
			}
		
		protected void fireGlobalModelSelected(ActionEvent evt)
			{
				for (GlobalModelSelectionListener listener : globalModelSelectionListeners)
					listener.globalModelSelected(evt);
			}
		
		public GlobalModelSelectorUI showToolbar(boolean show)
			{
				jtbAddGlobalModel.setVisible(show);
				return this;
			}
		
		private ArrayList<GlobalModelSelectionListener>		globalModelSelectionListeners	= new ArrayList<GlobalModelSelectionListener>();
		private ReferenceIDs<Method_InSilicoGlobalModel>	referenceIDs;
		private JComboBox<Method_InSilicoGlobalModel>				jcbModelSelector;
		private JComboBox<Resource>																						jcbMethodSelector;
		private JToolBar																																	jtbAddGlobalModel;
		private JButton																																		jbEdit;
		private JButton																																		jbAdd;
		private FunctionalRelationship																			funRel;
		private SubstanceData_InSilico																			substanceData;
		private boolean																																		isLoading																					= false;
		private static final long																								serialVersionUID														= 1L;
		
	}
