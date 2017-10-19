package org.qsari.effectopedia.core.object.elemets;

import org.qsari.effectopedia.base.io.BaseIO;
import org.qsari.effectopedia.base.io.BaseIOAttribute;
import org.qsari.effectopedia.base.io.BaseIOElement;
import org.qsari.effectopedia.core.objects.ContextDimension;
import org.qsari.effectopedia.core.objects.DocumentedKnowledge_Located;

public class Coordinate_Hierararchical extends Coordinate
	{

		public Coordinate_Hierararchical clone(DocumentedKnowledge_Located owner)
			{
				Coordinate_Hierararchical clone = new Coordinate_Hierararchical(owner, dimension);
				clone.value = (value != null) ? this.value.clone() : null;
				clone.unit = (unit != null) ? this.unit.clone() : null;
				clone.categoryIndex = this.categoryIndex;
				return clone;
			}
		
		public Coordinate_Hierararchical(DocumentedKnowledge_Located owner, ContextDimension dimension)
			{
				super(owner, dimension);
			}
		
		
		@Override
		public void load(BaseIOElement element,BaseIO io)
			{
				if (element == null)
					return;
				super.load(element,io);
				BaseIOAttribute category = element.getAttribute("category");
				categoryIndex = category.getIntValue();
			}
		
		@Override
		public BaseIOElement store(BaseIOElement element, BaseIO io)
			{
				if (element == null)
					return null;
				super.store(element, io);
				element.setAttribute("category", categoryIndex);
				return element;
			}

		
		public int getCategoryIndex()
			{
				return categoryIndex;
			}
		
		public void setCategoryIndex(int categoryIndex)
			{
				this.categoryIndex = categoryIndex;
			}
		
		protected int	categoryIndex	= -1;
		
	}
