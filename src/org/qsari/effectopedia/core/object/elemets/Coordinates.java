package org.qsari.effectopedia.core.object.elemets;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.qsari.effectopedia.base.Traceable;
import org.qsari.effectopedia.base.io.BaseIO;
import org.qsari.effectopedia.base.io.BaseIOArray;
import org.qsari.effectopedia.base.io.BaseIOAttribute;
import org.qsari.effectopedia.base.io.BaseIOElement;
import org.qsari.effectopedia.base.io.Exportable;
import org.qsari.effectopedia.base.io.Importable;
import org.qsari.effectopedia.core.objects.ContextDimension;
import org.qsari.effectopedia.core.objects.ContextDimension_Hierarchical;
import org.qsari.effectopedia.core.objects.DocumentedKnowledge_Located;
import org.qsari.effectopedia.data.objects.DataUnit;
import org.qsari.effectopedia.data.objects.DataValue;
import org.qsari.effectopedia.system.TraceableProperties;

public class Coordinates implements Importable, Exportable, Cloneable, Traceable
	{
		public Coordinates(DocumentedKnowledge_Located owner, List<ContextDimension> dimensions)
			{
				super();
				this.coordinates = new ArrayList<Coordinate>(dimensions.size());
				for (int i = 0; i <= dimensions.size() - 1; i++)
					coordinates.add(newCoordinate(owner, dimensions.get(i)));
				this.dimensions = dimensions;
				this.owner = owner;
			}
			
		public void setAll(List<Coordinate> coordiantes)
			{
				if (coordiantes.size() == this.coordinates.size())
					{
						this.coordinates.clear();
						this.coordinates.addAll(coordiantes);
					}
			}
			
		public List<Coordinate> getCoordiantes()
			{
				return coordinates;
			}
			
		public Coordinate getCoordiante(int index)
			{
				return coordinates.get(index);
			}
			
		public ContextDimension getDimension(int index)
			{
				return dimensions.get(index);
			}
			
		public String getName(int index)
			{
				return dimensions.get(index).getName();
			}
			
		public DataValue<?> getValue(int index)
			{
				return coordinates.get(index).getValue();
			}
			
		public String getDisplayValue(int index)
			{
				DataValue<?> value = coordinates.get(index).getValue();
				return (value != null) ? value.getDisplayValue() : "";
			}
			
		public int getCategory(int index)
			{
				if ((index >= 0) && (index < coordinates.size()))
					{
						Coordinate coordinate = coordinates.get(index);
						if (coordinate instanceof Coordinate_Hierararchical)
							return ((Coordinate_Hierararchical) coordinate).getCategoryIndex();
					}
				return -1;
			}
			
		public DataUnit getUnit(int index)
			{
				return coordinates.get(index).getUnit();
			}
			
		public void setValue(int index, DataValue<?> value)
			{
				Coordinate coordinate = coordinates.get(index);
				if (coordinate == null)
					coordinate = newCoordinate(owner, dimensions.get(index));
				coordinate.setValue(value);
			}
			
		public void setValue(int index, String value)
			{
				if ((index >= 0) && (index < coordinates.size()))
					coordinates.get(index).setValue(value);
			}
			
		public void setCategory(int index, int category)
			{
				if ((index >= 0) && (index < coordinates.size()))
					{
						Coordinate coordinate = coordinates.get(index);
						if (coordinate instanceof Coordinate_Hierararchical)
							((Coordinate_Hierararchical) coordinate).setCategoryIndex(category);
					}
			}
			
		public void setUnit(int index, DataUnit unit)
			{
				Coordinate coordinate = coordinates.get(index);
				if (coordinate == null)
					coordinate = newCoordinate(owner, dimensions.get(index));
				coordinate.setUnit(unit);
			}
			
		public void setUnit(int index, String value)
			{
				Coordinate coordinate = coordinates.get(index);
				if (coordinate == null)
					coordinate = newCoordinate(owner, dimensions.get(index));
				DataUnit unit = coordinate.getUnit();
				if (unit == null)
					coordinate.setUnit(new DataUnit(value));
				else
					unit.setCaption(value);
			}
			
		public int count()
			{
				return coordinates.size();
			}
			
		public void cloneFieldsTo(Coordinates clone)
			{
				clone.coordinates.clear();
				Iterator<Coordinate> iterator = coordinates.iterator();
				while (iterator.hasNext())
					clone.coordinates.add(iterator.next().clone(clone.owner));
			}
			
		public Coordinates clone(DocumentedKnowledge_Located owner)
			{
				Coordinates clone = new Coordinates(owner, dimensions);
				cloneFieldsTo(clone);
				return clone;
			}
			
		private Coordinate newCoordinate(DocumentedKnowledge_Located owner, ContextDimension dimension)
			{
				if (dimension instanceof ContextDimension_Hierarchical)
					return new Coordinate_Hierararchical(owner, dimension);
				else
					return new Coordinate(owner, dimension);
			}
			
		public final DocumentedKnowledge_Located getOwner()
			{
				return owner;
			}
			
		public void load(BaseIOElement element, BaseIO io)
			{
				if (element != null)
					{
						BaseIOArray e = element.getArray("coordinates");
						int count = e.getCount();
						List<BaseIOElement> children = (List<BaseIOElement>) e.getChildren();
						if (e.isValidArray())
							{
								for (int i = 0; i < count; i++)
									{
										BaseIOElement coordinate = children.get(i);
										BaseIOAttribute dimension = coordinate.getAttribute("dimension");
										ContextDimension dim = ContextDimension.NAME_INDEX.get(dimension.getValue());
										if ((dimension != null) && (dim != null))
											coordinates.get(dim.DIMENSION_INDEX).load(coordinate, io);
									}
							}
					}
			}
			
		public BaseIOElement store(BaseIOElement element, BaseIO io)
			{
				int count = coordinates.size();
				BaseIOArray e = io.newArray("coordinates", count);
				for (int i = 0; i < count; i++)
					{
						BaseIOElement c = io.newElement("coordiante");
						c.setAttribute("dimension", dimensions.get(i).getName());
						e.addChild((coordinates.get(i).store(c, io)));
					}
				element.addChild(e);
				return element;
			}
			
		public static final long																				C_VALUE_PID	= TraceableProperties.REGISTERED.add("coordiante.value", "", Coordinates.class);
		public static final long																				C_UNIT_PID		= TraceableProperties.REGISTERED.add("coordiante.unit", "", Coordinates.class);
		
		protected final List<ContextDimension>						dimensions;
		protected final ArrayList<Coordinate>							coordinates;
		protected final DocumentedKnowledge_Located	owner;
	}
