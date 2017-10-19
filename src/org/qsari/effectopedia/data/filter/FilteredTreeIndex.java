package org.qsari.effectopedia.data.filter;

import java.util.ArrayList;

import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

import org.qsari.effectopedia.base.EffectopediaObjects;
import org.qsari.effectopedia.data.objects.DescriptorType;
import org.qsari.effectopedia.data.objects.DescriptorTypesContainer;
import org.qsari.effectopedia.data.objects.ObjectPropertyType;
import org.qsari.effectopedia.data.objects.ObjectPropertyTypesContainer;

public class FilteredTreeIndex extends FilteredIndex
	{
		
		public FilteredTreeIndex(EffectopediaObjects<?> index)
			{
				super(index);
			}
		
		public FilteredObjectPropertiesTreeModel getTreeModel()
			{
				return new FilteredObjectPropertiesTreeModel();
			}
		
		public class FilteredObjectPropertiesTreeModel implements TreeModel
			{
				
				/**
		 * 
		 */
				private static final long	serialVersionUID	= 1L;
				
				public void rebuild()
					{
						int count = filtredElements.length;
						int[] childIdx = new int[count];
						for (int i = 0; i < count; i++)
							childIdx[i] = i;
						fireTreeStructureChanged(null, new Object[]
							{ filtredElements }, childIdx, filtredElements);
					}
				
				@Override
				public void addTreeModelListener(TreeModelListener l)
					{
						listeners.add(l);
					}
				
				@Override
				public Object getChild(Object parent, int index)
					{
						if (parent == filtredElements)
							return filtredElements[index];
						if (parent instanceof ObjectPropertyTypesContainer)
							return ((ObjectPropertyTypesContainer) parent).get(index);
						if (parent instanceof DescriptorTypesContainer)
							return ((DescriptorTypesContainer) parent).get(index);
						if (parent instanceof ObjectPropertyType)
							{
								ObjectPropertyType objProp = ((ObjectPropertyType) parent);
								if (index == 0)
									return objProp.getDescriptors();
								else
									{
										if (objProp.getSubPropertyTypes() == null)
											objProp.setSubPropertyTypes(new ObjectPropertyTypesContainer());
										return objProp.getSubPropertyTypes();
									}
							}
						return null;
					}
				
				@Override
				public int getChildCount(Object parent)
					{
						if (parent == filtredElements)
							return filtredElements.length;
						if (parent instanceof ObjectPropertyTypesContainer)
							return ((ObjectPropertyTypesContainer) parent).size();
						if (parent instanceof DescriptorTypesContainer)
							return ((DescriptorTypesContainer) parent).size();
						if (parent instanceof ObjectPropertyType)
							return 2;
						return 0;
					}
				
				@Override
				public int getIndexOfChild(Object parent, Object child)
					{
						if (parent == filtredElements)
							return java.util.Arrays.asList(filtredElements).indexOf(child);
						if (parent instanceof ObjectPropertyTypesContainer)
							return ((ObjectPropertyTypesContainer) parent).indexOf(child);
						if (parent instanceof DescriptorTypesContainer)
							return ((DescriptorTypesContainer) parent).indexOf(child);
						if (parent instanceof ObjectPropertyType)
							return (child instanceof DescriptorTypesContainer) ? 0 : 1;
						return 0;
					}
				
				@Override
				public Object getRoot()
					{
						return filtredElements;
					}
				
				public int getPathRow(TreePath path)
					{
						if (path==null)
							return 0;
						Object[] pathObjects = path.getPath();
						return java.util.Arrays.asList(filtredElements).indexOf(pathObjects[1]);
					}
				
				@Override
				public boolean isLeaf(Object node)
					{
						if (node instanceof ObjectPropertyType)
							return false;
						else if (node instanceof DescriptorType)
							return true;
						if (node instanceof ObjectPropertyTypesContainer)
							return ((ObjectPropertyTypesContainer) node).size() == 0;
						if (node instanceof DescriptorTypesContainer)
							return ((DescriptorTypesContainer) node).size() == 0;
						return false;
					}
				
				@Override
				public void removeTreeModelListener(TreeModelListener l)
					{
						listeners.remove(l);
					}
				
				@Override
				public void valueForPathChanged(TreePath path, Object newValue)
					{
						// TODO Auto-generated method stub
						
					}
				
				/*
				 * Notifies all listeners that have registered interest for notification on
				 * this event type. The event instance is lazily created using the
				 * parameters passed into the fire method.
				 * 
				 * @param source the node being changed
				 * 
				 * @param path the path to the root node
				 * 
				 * @param childIndices the indices of the changed elements
				 * 
				 * @param children the changed elements
				 */
				protected void fireTreeNodesChanged(Object source, Object[] path, int[] childIndices, Object[] children)
					{
						TreeModelEvent event = new TreeModelEvent(source, path, childIndices, children);
						for (TreeModelListener listener : listeners)
							listener.treeNodesChanged(event);
					}
				
				/**
				 * fireTreeNodesInserted
				 * 
				 * @param source
				 *         the node where new nodes got inserted
				 * @param path
				 *         the path to the root node
				 * @param childIndices
				 *         the indices of the new elements
				 * @param children
				 *         the new elements
				 */
				protected void fireTreeNodesInserted(Object source, Object[] path, int[] childIndices, Object[] children)
					{
						TreeModelEvent event = new TreeModelEvent(source, path, childIndices, children);
						for (TreeModelListener listener : listeners)
							listener.treeNodesInserted(event);
					}
				
				/**
				 * fireTreeNodesRemoved
				 * 
				 * @param source
				 *         the node where nodes got removed-
				 * @param path
				 *         the path to the root node
				 * @param childIndices
				 *         the indices of the removed elements
				 * @param children
				 *         the removed elements
				 */
				protected void fireTreeNodesRemoved(Object source, Object[] path, int[] childIndices, Object[] children)
					{
						TreeModelEvent event = new TreeModelEvent(source, path, childIndices, children);
						for (TreeModelListener listener : listeners)
							listener.treeNodesRemoved(event);
					}
				
				/**
				 * fireTreeStructureChanged
				 * 
				 * @param source
				 *         the node where the model has changed
				 * @param path
				 *         the path to the root node
				 * @param childIndices
				 *         the indices of the affected elements
				 * @param children
				 *         the affected elements
				 */
				protected void fireTreeStructureChanged(Object source, Object[] path, int[] childIndices, Object[] children)
					{
						TreeModelEvent event = new TreeModelEvent(source, path, childIndices, children);
						for (TreeModelListener listener : listeners)
							listener.treeStructureChanged(event);
					}
				
				public TreePath addDescriptor(TreePath path, DescriptorType newDescriptorType)
					{
						if (path == null)
							return null;
						TreePath newElementPath;
						Object obj = path.getLastPathComponent();
						Object[] pathObjects = path.getPath();
						DescriptorTypesContainer descriptors;
						int index = 0;
						if (obj instanceof DescriptorTypesContainer)
							{
								descriptors = (DescriptorTypesContainer) obj;
								newElementPath = path.pathByAddingChild(newDescriptorType);
								index = descriptors.size();
							}
						else
							// (obj instanceof DescriptorType)
							{
								descriptors = (DescriptorTypesContainer) pathObjects[pathObjects.length - 2];
								newElementPath = path.getParentPath().pathByAddingChild(newDescriptorType);
								index = descriptors.indexOf(obj);
								if (index < 0)
									index = 0;
							}
						descriptors.add(index, newDescriptorType);
						fireTreeNodesInserted(descriptors, newElementPath.getPath(), new int[]
							{ index }, new Object[]
							{ newDescriptorType });
						return newElementPath;
					}
				
				public TreePath addObjectPropertyType(TreePath path, ObjectPropertyType newObjectPropertyType)
					{
						if (path == null)
							return null;
						TreePath newElementPath;
						Object obj = path.getLastPathComponent();
						Object[] pathObjects = path.getPath();
						ObjectPropertyTypesContainer propertyTypes;
						int index = 0;
						if (obj instanceof ObjectPropertyTypesContainer)
							{
								propertyTypes = (ObjectPropertyTypesContainer) obj;
								newElementPath = path.pathByAddingChild(newObjectPropertyType);
								index = propertyTypes.size();
								propertyTypes.add(newObjectPropertyType);
							}
						else
							// obj instanceof ObjectPropertyType
							{
								if (path.getParentPath().getLastPathComponent() != filtredElements)
									{
										propertyTypes = (ObjectPropertyTypesContainer) pathObjects[pathObjects.length - 2];
										index = propertyTypes.indexOf(obj);
										if (index < 0)
											index = 0;
										propertyTypes.add(index, newObjectPropertyType);
									}
								newElementPath = path.getParentPath().pathByAddingChild(newObjectPropertyType);
							}
						fireTreeNodesInserted(filtredElements, newElementPath.getPath(), new int[]
							{ index }, new Object[]
							{ newObjectPropertyType });
						
						DescriptorTypesContainer descriptors = newObjectPropertyType.getDescriptors();
						TreePath descrTreePath = newElementPath.pathByAddingChild(descriptors);
						fireTreeNodesInserted(newObjectPropertyType, descrTreePath.getPath(), new int[]
							{ 0 }, new Object[]
							{ descriptors });
						
						ObjectPropertyTypesContainer properies = newObjectPropertyType.getSubPropertyTypes();
						if (properies == null)
							{
								properies = new ObjectPropertyTypesContainer();
								newObjectPropertyType.setSubPropertyTypes(properies);
							}
						TreePath subPropTreePath = newElementPath.pathByAddingChild(properies);
						fireTreeNodesInserted(newObjectPropertyType, subPropTreePath.getPath(), new int[]
							{ 1 }, new Object[]
							{ properies });
						return newElementPath;
					}
				
				public void removeObjectPropertyType(TreePath path, ObjectPropertyType property)
					{
						Object obj = path.getParentPath().getLastPathComponent();
						Object[] pathObjects = path.getPath();
						if ((pathObjects.length > 2) && (property.getExternalID() == 0) && (obj instanceof ObjectPropertyTypesContainer))
							{
								int index = ((ObjectPropertyTypesContainer) obj).indexOf(property);
								((ObjectPropertyTypesContainer) obj).remove(property);
								fireTreeNodesRemoved(obj, path.getPath(), new int[]
									{ index }, new Object[]
									{ property });
							}
					}
				
				public void removeDescriptorType(TreePath path, DescriptorType descriptorType)
					{
						Object obj = path.getParentPath().getLastPathComponent();
						if ((descriptorType.getExternalID() == 0) && (obj instanceof DescriptorTypesContainer))
							{
								int index = ((DescriptorTypesContainer) obj).indexOf(descriptorType);
								((DescriptorTypesContainer) obj).remove(descriptorType);
								fireTreeNodesRemoved(obj, path.getPath(), new int[]
									{ index }, new Object[]
									{ descriptorType });
							}
					}
				
				public void resetObjectPropertyTypes(TreePath path)
					{
						Object obj = path.getLastPathComponent();
						Object[] pathObjects = path.getPath();
						if (pathObjects.length > 2)
							{
								ObjectPropertyTypesContainer container = (ObjectPropertyTypesContainer) ((obj instanceof ObjectPropertyType) ? pathObjects[pathObjects.length - 2] : obj);
								int i = 0;
								while (i < container.size())
									{
										ObjectPropertyType propertyType = container.get(i);
										if (propertyType.getExternalID() == 0)
											{
												ObjectPropertyType property = container.remove(i);
												fireTreeNodesRemoved(obj, path.getPath(), new int[]
													{ i }, new Object[]
													{ property });
											}
										else
											i++;
									}
							}
					}
				
				public void resetDescriptorType(TreePath path)
					{
						Object obj = path.getLastPathComponent();
						Object[] pathObjects = path.getPath();
						try
							{
								DescriptorTypesContainer descriptors = (DescriptorTypesContainer) ((obj instanceof DescriptorType) ? pathObjects[pathObjects.length - 2] : obj);
								int i = 0;
								while (i < descriptors.size())
									{
										DescriptorType descriptorType = (DescriptorType) descriptors.get(i);
										if (descriptorType.getExternalID() == 0)
											{
												descriptors.remove(i);
												fireTreeNodesRemoved(obj, path.getPath(), new int[]
													{ i }, new Object[]
													{ descriptorType });
											}
										else
											i++;
									}
								
							}
						catch (Exception e)
							{
							}
					}
				
				public TreePath[] getPaths(ObjectPropertyType[] types)
					{
						ArrayList<TreePath> selected = new ArrayList<TreePath>();
						for (ObjectPropertyType t : types)
							selected.add(new TreePath(new Object[]
								{ filtredElements, t }));
						return selected.toArray(new TreePath[selected.size()]);
					}
				
				private ArrayList<TreeModelListener>	listeners	= new ArrayList<TreeModelListener>();
				
			}
	}
