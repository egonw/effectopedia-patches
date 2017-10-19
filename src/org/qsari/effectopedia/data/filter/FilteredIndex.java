package org.qsari.effectopedia.data.filter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.swing.AbstractListModel;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.base.EffectopediaObjects;
import org.qsari.effectopedia.base.Titleable;
import org.qsari.effectopedia.core.object.elemets.Coordinate;
import org.qsari.effectopedia.core.object.elemets.Coordinates;
import org.qsari.effectopedia.core.objects.ContextDimension;
import org.qsari.effectopedia.core.objects.DocumentedKnowledge_Located;
import org.qsari.effectopedia.data.filter.ContextDimensionFilter.Criterion;
import org.qsari.effectopedia.data.objects.DescriptorType;
import org.qsari.effectopedia.defaults.DefaultEffectopediaObjects;

public class FilteredIndex
	{
		public FilteredIndex(EffectopediaObjects<?> index)
			{
				this.index = index;
				this.filters = new HashMap<String, BasicFilter>();
			}
		
		public void addClassFilter(Class<? extends EffectopediaObject> isClass)
			{
				filters.put("Is " + isClass.getName(), new ClassFilter("Is " + isClass.getName(), isClass));
			}
		
		public void addNotClassFilter(Class<? extends EffectopediaObject> isClass)
			{
				filters.put("Is not " + isClass.getName(), new NotClassFilter("Is not" + isClass.getName(), isClass));
			}
		
		public void addOwnerClassesFilter(ArrayList<Class<? extends EffectopediaObject>> isClass)
			{
				StringBuilder sb = new StringBuilder();
				for (int i = 0; i < isClass.size() - 2; i++)
					{
						sb.append(isClass.get(i));
						sb.append(" or ");
					}
				if (isClass.size() > 0)
					sb.append(isClass.get(isClass.size() - 1));
				String classes = sb.toString();
				filters.put("Owner is " + classes, new OwnerClassFilter("Owner is " + classes, isClass));
			}
		
		public void addFilter(BasicFilter filter)
			{
				if (filter != null)
					filters.put(filter.caption, filter);
			}
		
		public void addGenericFilter()
			{
				filters.put("Not generic", new BasicFilter());
			}
		
		public void addDefaultObjectFilter()
			{
				filters.put("Not default", new DeafultObjectsFilter("Not default"));
				filtredElements = null;
			}
		
		public void addDefaultContextFilters()
			{
				List<ContextDimension> dimensions = DefaultEffectopediaObjects.DEFAULT_CONTEXT.getDimensions();
				for (ContextDimension d : dimensions)
					filters.put(d.getName(), new ContextDimensionFilter(d.getName(), d.DIMENSION_INDEX, null, Criterion.EQUAL));
				filtredElements = null;
			}
		
		public void addPathwaysFilter(DocumentedKnowledge_Located element, PathwayFilter.Criterion criterion)
			{
				if (element != null)
					{
						Long[] pathwayIDs = element.getPathwayIDs().getCachedIDs();
						for (int i = pathwayIDs.length - 1; i >= 0; i--)
							{
								String caption = "PathwayID " + criterion + " " + pathwayIDs[i];
								filters.put(caption, new PathwayFilter(caption, pathwayIDs[i], criterion));
							}
						
						filtredElements = null;
					}
			}
		
		public void buidContextFilters(DocumentedKnowledge_Located element, ContextDimensionFilter.Criterion criterion)
			{
				if (element != null)
					{
						Coordinates coordinates = element.getCoordinates();
						for (Coordinate c : coordinates.getCoordiantes())
							if (c.getValue() != null)
								{
									ContextDimension dimension = c.getDimension();
									ContextDimensionFilter filter = (ContextDimensionFilter) filters.get(dimension.getName());
									if (filter != null)
										filter.setValue(c.getValue());
									else
										filters.put(dimension.getName(), new ContextDimensionFilter(dimension.getName(), dimension.DIMENSION_INDEX, c.getValue(), criterion));
								}
						filtredElements = null;
					}
			}
		
		public void buildDisjunctiveContextFilter(DocumentedKnowledge_Located element, ContextDimensionFilter.Criterion criterion)
			{
				if (element != null)
					{
						Coordinates coordinates = element.getCoordinates();
						DisjunctionFilter disjunction = new DisjunctionFilter(null);
						for (Coordinate c : coordinates.getCoordiantes())
							if (c.getValue() != null)
								{
									ContextDimension dimension = c.getDimension();
									if (dimension.isOrdered())
										disjunction.add(new ContextDimensionFilter(dimension.getName(), dimension.DIMENSION_INDEX, c.getValue(), criterion));
								}
						disjunction.generateCaption();
						filters.put(disjunction.getCaption(), disjunction);
						filtredElements = null;
					}
			}
		
		public EffectopediaObject[] filter()
			{
				if (index == null)
					filtredElements = null;
				else
					{
						filtredElements = (EffectopediaObject[]) index.get();
						Iterator<BasicFilter> it = filters.values().iterator();
						while (it.hasNext())
							filtredElements = it.next().filter(filtredElements);
					}
				return filtredElements;
			}
		
		public EffectopediaObject[] getFiltredElements()
			{
				if (filtredElements == null)
					filter();
				return filtredElements;
			}
		
		public int count()
			{
				if (filtredElements == null)
					if (filter() == null)
						return 0;
				return filtredElements.length;
			}
		
		public void clearFilters()
			{
				filters.clear();
				filtredElements = null;
			}
		
		public FilteredEOListModel getListModel()
			{
				return new FilteredEOListModel();
			}
		
		public EffectopediaObject getElement(int index)
			{
				if ((getFiltredElements() != null) && (index >= 0) && (index < filtredElements.length))
					return filtredElements[index];
				return null;
			}
		
		class FilteredEOListModel extends AbstractListModel<String>
			{
				
				/**
			 * 
			 */
				private static final long	serialVersionUID	= 1L;
				
				@Override
				public String getElementAt(int index)
					{
						String element = null;
						if ((index >= 0) && (getFiltredElements() != null) && (index < filtredElements.length))
							if (filtredElements[index] instanceof Titleable)
								element = ((Titleable) filtredElements[index]).getTitle();
							else if (filtredElements[index] instanceof DescriptorType)
								element = ((DescriptorType) filtredElements[index]).getName();
						return (element == null) ? " " : element;
					}
				
				@Override
				public int getSize()
					{
						if (getFiltredElements() != null)
							return filtredElements.length;
						else
							return 0;
					}
				
			}
		
		public EffectopediaObjects<?> getIndex()
			{
				return index;
			}
		
		public void setIndex(EffectopediaObjects<?> index)
			{
				this.index = index;
				filtredElements = null;
			}
		
		public void clear()
			{
				// TODO Auto-generated method stub
				
			}
		
		public void sort()
			{
				if (getFiltredElements() != null)
					{
						ArrayList<EffectopediaObject> elements = new ArrayList<EffectopediaObject>();
						elements.addAll(Arrays.asList(filtredElements));
						Collections.sort(elements, TITLE_COMPARATOR);
						filtredElements = elements.toArray(filtredElements);
					}
			}
		
		public void sort(Comparator<EffectopediaObject> comparator)
			{
				if (getFiltredElements() != null)
					{
						ArrayList<EffectopediaObject> elements = new ArrayList<EffectopediaObject>();
						elements.addAll(Arrays.asList(filtredElements));
						Collections.sort(elements, comparator);
						filtredElements = elements.toArray(filtredElements);
					}
			}
		
		public static class TitleComparator implements Comparator<EffectopediaObject>
			{
				public int compare(EffectopediaObject o1, EffectopediaObject o2)
					{
						if ((o1 instanceof Titleable) && (o2 instanceof Titleable))
							return ((Titleable) o1).getTitle().compareTo(((Titleable) o2).getTitle());
						return 0;
					}
			}
		
		public static class NameComparator implements Comparator<EffectopediaObject>
			{
				public int compare(EffectopediaObject o1, EffectopediaObject o2)
					{
						if ((o1 instanceof DescriptorType) && (o2 instanceof DescriptorType))
							{
								String o1name = ((DescriptorType) o1).getName();
								String o2name = ((DescriptorType) o2).getName();
								return (o1name == null) || (o2name == null) ? 0 : o1name.compareTo(o2name);
							}
						return 0;
					}
			}
		
		public BasicFilter getFilterByName(String name)
			{
				return filters.get(name);
			}
		
		public static TitleComparator										TITLE_COMPARATOR	= new TitleComparator();
		public static NameComparator											NAME_COMPARATOR		= new NameComparator();
		protected EffectopediaObject[]									filtredElements		= null;
		protected HashMap<String, BasicFilter>	filters;
		protected EffectopediaObjects<?>							index;
		
	}
