package org.qsari.effectopedia.data.filter;

import java.util.ArrayList;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.core.objects.DocumentedKnowledge_Located;
import org.qsari.effectopedia.data.objects.DataValue;

public class ContextDimensionFilter extends BasicFilter
	{
		public static enum Criterion
			{
				LOWER, LOWER_OR_EQUAL, EQUAL, GREATER_OR_EQUAL, GREATER
			}
		
		public ContextDimensionFilter(String caption, int dimensionIndex, DataValue<?> value, Criterion criterion)
			{
				super(caption);
				this.dimensionIndex = dimensionIndex;
				this.value = value;
				this.criterion = criterion;
			}
		
		public EffectopediaObject[] filter(EffectopediaObject elements[])
			{
				if (value == null)
					return elements;
				ArrayList<EffectopediaObject> filtered = new ArrayList<EffectopediaObject>();
				if (elements != null)
					{
						switch (criterion)
							{
								case LOWER:
									leaveL(elements, filtered);
									break;
								case LOWER_OR_EQUAL:
									leaveLE(elements, filtered);
									break;
								case GREATER_OR_EQUAL:
									leaveGE(elements, filtered);
									break;
								case GREATER:
									leaveG(elements, filtered);
									break;
								default:
									leaveE(elements, filtered);
									break;
							}
					}
				return filtered.toArray(new EffectopediaObject[filtered.size()]);
			}

		public boolean filter(EffectopediaObject element)
			{
				if (element != null)
					{
						DataValue<?> elementValue = ((DocumentedKnowledge_Located) element).getCoordinates().getValue(dimensionIndex);
						if (elementValue == null)
						 return true;
						else 
							switch (criterion)
							{
								case LOWER:
									return (elementValue.compareTo(value.getValue())<0);
								case LOWER_OR_EQUAL:
									return (elementValue.compareTo(value.getValue())<=0);
								case GREATER_OR_EQUAL:
									return (elementValue.compareTo(value.getValue())==0);
								case GREATER:
									return (elementValue.compareTo(value.getValue())>=0);
								default:
									return (elementValue.compareTo(value.getValue())>0);
							}
					}
				else 
					return false;
			}
		
		public int getDimensionIndex()
			{
				return dimensionIndex;
			}
		
		public void setDimensionIndex(int dimensionIndex)
			{
				this.dimensionIndex = dimensionIndex;
			}
		
		public DataValue<?> getValue()
			{
				return value;
			}
		
		public void setValue(DataValue<?> value)
			{
				this.value = value;
			}
		
		private void leaveL(EffectopediaObject elements[], ArrayList<EffectopediaObject> filtered)
			{
				for (int i = elements.length - 1; i >= 0; i--)
					{
						DataValue<?> elementValue = ((DocumentedKnowledge_Located) elements[i]).getCoordinates().getValue(dimensionIndex);
						if (elementValue == null)
							filtered.add(elements[i]);
						else if (elementValue.compareTo(value.getValue())<0)
							filtered.add(elements[i]);
					}
			}
		
		private void leaveLE(EffectopediaObject elements[], ArrayList<EffectopediaObject> filtered)
			{
				for (int i = elements.length - 1; i >= 0; i--)
					{
						DataValue<?> elementValue = ((DocumentedKnowledge_Located) elements[i]).getCoordinates().getValue(dimensionIndex);
						if (elementValue == null)
							filtered.add(elements[i]);
						else if (elementValue.compareTo(value.getValue())<=0)
							filtered.add(elements[i]);
					}
			}
		
		private void leaveE(EffectopediaObject elements[], ArrayList<EffectopediaObject> filtered)
			{
				for (int i = elements.length - 1; i >= 0; i--)
					{
						DataValue<?> elementValue = ((DocumentedKnowledge_Located) elements[i]).getCoordinates().getValue(dimensionIndex);
						if (elementValue == null)
							filtered.add(elements[i]);
						else if (elementValue.compareTo(value.getValue())==0)
							filtered.add(elements[i]);
					}
			}
		
		private void leaveGE(EffectopediaObject elements[], ArrayList<EffectopediaObject> filtered)
			{
				for (int i = elements.length - 1; i >= 0; i--)
					{
						DataValue<?> elementValue = ((DocumentedKnowledge_Located) elements[i]).getCoordinates().getValue(dimensionIndex);
						if (elementValue == null)
							filtered.add(elements[i]);
						else if (elementValue.compareTo(value.getValue())>=0)
							filtered.add(elements[i]);
					}
			}
		
		private void leaveG(EffectopediaObject elements[], ArrayList<EffectopediaObject> filtered)
			{
				for (int i = elements.length - 1; i >= 0; i--)
					{
						DataValue<?> elementValue = ((DocumentedKnowledge_Located) elements[i]).getCoordinates().getValue(dimensionIndex);
						if (elementValue == null)
							filtered.add(elements[i]);
						else if (elementValue.compareTo(value.getValue())>0)
							filtered.add(elements[i]);
					}
			}
		
		protected int										dimensionIndex;
		protected DataValue<?>	value;
		protected Criterion				criterion;
	}
