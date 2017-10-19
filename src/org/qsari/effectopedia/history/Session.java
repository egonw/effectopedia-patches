package org.qsari.effectopedia.history;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.data.DataSource;

public class Session
	{
		public static final class DataSourceIDs
			{
				
				public DataSourceIDs(long stampID, long effectopediaObjectID)
					{
						this.stampID = stampID;
						this.effectopediaObjectID = effectopediaObjectID;
					}
				
				public final long	stampID;
				public final long	effectopediaObjectID;
			}
		
		public Session(DataSource parent)
			{
				this.parent = parent;
				start = new DataSourceIDs(Stamp.stampIDs, EffectopediaObject.effectopediaObjectIDs);
			}
		
		public void compactHistory()
			{
				
			}
		
		public DataSourceIDs getStart()
			{
				return start;
			}
		
		public void setStart(DataSourceIDs start)
			{
				this.start = start;
			}
		
		public DataSourceIDs getEnd()
			{
				return end;
			}
		
		public void setEnd(DataSourceIDs end)
			{
				this.end = end;
			}
		
		protected DataSource				parent;
		protected DataSourceIDs	start;
		protected DataSourceIDs	end;
	}
