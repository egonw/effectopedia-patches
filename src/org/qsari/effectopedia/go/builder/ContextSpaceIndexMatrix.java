package org.qsari.effectopedia.go.builder;

import org.qsari.effectopedia.core.object.elemets.Coordinates;
import org.qsari.effectopedia.core.objects.ContextDimension;
import org.qsari.effectopedia.core.objects.DocumentedKnowledge_Located;
import org.qsari.effectopedia.core.objects.PathwayElement;
import org.qsari.effectopedia.data.objects.DataValue;
import org.qsari.effectopedia.data.objects.DataValue_IntRef;
import org.qsari.effectopedia.go.Layout.LayoutObject;
import org.qsari.effectopedia.go.Layout.LayoutObjectsContainer;

public class ContextSpaceIndexMatrix
	{
		public ContextSpaceIndexMatrix(LayoutObjectsContainer container, ContextDimension horizontal, ContextDimension vertical)
			{
				super();
				this.container = container;
			}
		
		public int getXIndex(DataValue<?> x)
			{
				if ((x != null) && (x instanceof DataValue_IntRef))
					return 2 * ((DataValue_IntRef) x).getValue();
				else
					return 0;
			}
		
		public int getYIndex(DataValue<?> y)
			{
				if ((y != null) && (y instanceof DataValue_IntRef))
					return 2 * ((DataValue_IntRef) y).getValue();
				else
					return 0;
			}
		
		public int getXIndex(PathwayElement element, int xCoordinateIndex)
			{
				if (element instanceof DocumentedKnowledge_Located)
					{
						Coordinates c = ((DocumentedKnowledge_Located) element).getCoordinates();
						DataValue<?> x = c.getValue(xCoordinateIndex);
						if ((x != null) && (x instanceof DataValue_IntRef))
							return 2 * ((DataValue_IntRef) x).getValue();
					}
				return 0;
			}
		
		public void setCoordinate(PathwayElement element, int dimensionIndex, int valueIndex)
			{
				if (element instanceof DocumentedKnowledge_Located)
					{
						Coordinates c = ((DocumentedKnowledge_Located) element).getCoordinates();
						ContextDimension dimension = c.getDimension(dimensionIndex);
						if (DataValue_IntRef.class.isAssignableFrom(dimension.getBaseDataType()))
	 					c.setValue(dimensionIndex,String.valueOf(valueIndex/2));
					}
			}
				
		public int getAverageXIndex(PathwayElement[] elements, int xCoordinateIndex)
			{
				int count = elements.length;
				int averageXIndex = 0;
				if ((elements != null) && (elements.length > 0) && (elements[0] instanceof DocumentedKnowledge_Located))
					{
						for (int i = count - 1; i >= 0; i--)
							{
								Coordinates c = ((DocumentedKnowledge_Located) elements[i]).getCoordinates();
								DataValue<?> x = c.getValue(xCoordinateIndex);
								if ((x != null) && (x instanceof DataValue_IntRef))
									averageXIndex += 2 * ((DataValue_IntRef) x).getValue();
								else
									count--;
							}
						averageXIndex = (count == 0) ? 0 : averageXIndex / count;
					}
				return averageXIndex;
			}
		
		public int getYIndex(PathwayElement element, int yCoordinateIndex)
			{
				if (element instanceof DocumentedKnowledge_Located)
					{
						Coordinates c = ((DocumentedKnowledge_Located) element).getCoordinates();
						DataValue<?> y = c.getValue(yCoordinateIndex);
						if ((y != null) && (y instanceof DataValue_IntRef))
							return 2 * ((DataValue_IntRef) y).getValue();
					}
				return 0;
			}
		
		public int getAverageYIndex(PathwayElement[] elements, int yCoordinateIndex)
			{
				int averageYIndex = 0;
				if ((elements != null) && (elements.length > 0))
					{
						int count = elements.length;
						for (int i = count - 1; i >= 0; i--)
						if  (elements[i] instanceof DocumentedKnowledge_Located)
							{
								Coordinates c = ((DocumentedKnowledge_Located) elements[i]).getCoordinates();
								DataValue<?> y = c.getValue(yCoordinateIndex);
								if ((y != null) && (y instanceof DataValue_IntRef))
									averageYIndex += 2 * ((DataValue_IntRef) y).getValue();
								else
									count--;
							}
						else 
							count--;
						averageYIndex = (count == 0) ? 0 : averageYIndex / count;
					}
				return averageYIndex;
			}
		
		public LayoutObject getLayoutObject(DataValue<?> x, DataValue<?> y)
			{
				int xIndex = getXIndex(x);
				int yIndex = getYIndex(y);
				if (container != null)
					return container.getComponent(xIndex, yIndex);
				else
					return null;
			}
		
		public LayoutObject getLayoutObject(PathwayElement element, int xCoordinateIndex, int yCoordinateIndex)
			{
				if (element instanceof DocumentedKnowledge_Located)
					{
						Coordinates c = ((DocumentedKnowledge_Located) element).getCoordinates();
						DataValue<?> x = c.getValue(xCoordinateIndex);
						DataValue<?> y = c.getValue(yCoordinateIndex);
						int xIndex = getXIndex(x);
						int yIndex = getYIndex(y);
						if (container != null)
							return container.getComponent(xIndex, yIndex);
					}
				return null;
			}
		
		private LayoutObjectsContainer	container;
	}
