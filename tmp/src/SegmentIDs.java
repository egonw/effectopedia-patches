package org.qsari.effectopedia.base.ids;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.base.Traceable;
import org.qsari.effectopedia.base.XMLExportable;
import org.qsari.effectopedia.base.XMLImportable;
import org.qsari.effectopedia.core.objects.PathwaySegment;

public class SegmentIDs extends IDs<PathwaySegment> implements XMLImportable, XMLExportable, Cloneable, Traceable
	{
		
		public SegmentIDs(EffectopediaObject parent, Class<PathwaySegment> objectClass)
			{
				super(parent, objectClass);
			}
  
		public static SegmentIDs createDefaultSegmentIDs(Class<PathwaySegment> objectClass)
			{
				SegmentIDs result = new SegmentIDs(null,objectClass);
				result.bringToLive();
				result.generateDefaultSegments();
				result.setDefaultID(true);
				return result;
			}
  
		public SegmentIDs(EffectopediaObject parent, Class<PathwaySegment> objectClass,boolean generateDefaultSegments)
			{
				super(parent, objectClass);
				if (generateDefaultSegments)
				 generateDefaultSegments();
			}
		
		public void add(Long id)
			{
			}
		
		public boolean remove(Long id)
			{
				return false;
			}
		
		public void clear()
			{
			}
		
		public int size()
			{
				return items.size();
			}
		
		public void cloneFieldsTo(DescriptionIDs clone)
			{
				super.cloneFieldsTo(clone);
			}
		
		public SegmentIDs clone()
			{
				SegmentIDs clone = new SegmentIDs(getParent(), objectClass,false);
				cloneFieldsTo(clone);
				return clone;
			}
		
		public SegmentIDs clone(EffectopediaObject parent)
			{
				SegmentIDs clone = new SegmentIDs(parent, objectClass,false);
				cloneFieldsTo(clone);
				return clone;
			}
		
  public PathwaySegment getSegment(int byIndex)
  	{
  		if ((byIndex<objects.size())&&(byIndex>=0))
  			return objects.get(byIndex);
  		return null;
  	}
  
		private void generateDefaultSegments()
			{
				for (int i = 0; i < DEFAULT_SEGMENTS; i++)
					{
						PathwaySegment ps = new PathwaySegment(this);
						ps.setSegmentIndex(i);
						ps.setDefaultID(true);
				  add(ps);
						//System.out.println("Default segment "+ps.getID()+" have index:"+i);
					}
			}
		
		/**
		 * Corresponds to the Levels of Biological Organization (Atoms, Small
		 * Molecules,Macro Molecules, Molecular assemblies, Organelles, Cells,
		 * Tissues, Organs, Organ Systems, Organisms, Population of Species, Species,
		 * Communities, Ecosystem,Biosphere) without sub-atomic particles Contain
		 * PathwayElement descendants (like Effects, Links, Tests, Substances) plus
		 * the Substances and links between all of them
		 * 
		 */
		
		public static final int	DEFAULT_SEGMENTS	= 1 + 13 + 13;
	}
