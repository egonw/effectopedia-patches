/*
 * 
 */

package org.qsari.effectopedia.base;

import org.qsari.effectopedia.base.io.BaseIO;
import org.qsari.effectopedia.base.io.BaseIOAttribute;
import org.qsari.effectopedia.base.io.BaseIOElement;
import org.qsari.effectopedia.base.io.Exportable;
import org.qsari.effectopedia.base.io.Importable;
import org.qsari.effectopedia.core.Effectopedia;
import org.qsari.effectopedia.system.TraceableClasses;

/**
 * <code>IndexedObject</code> is the base class for all classes that require
 * unique identifier for their instances. By default the unique identifier is
 * not initialized automatically and the descendent class needs to use the value
 * of {@link IndexedObject#autoId()} or call {@link IndexedObject#autoSetId()}.
 * <code>IndexedObject</code> contains also an external file or database
 * identifier {@link #externalID} used for matching objects with ones stored in
 * external source.
 * 
 * 
 * @version $Revision: 1.0 $, $Date: 2009/08/03 22:03:00 $
 * @author Hristo Aladjov
 */

public abstract class IndexedObject implements Importable, Exportable, Cloneable, Comparable<IndexedObject>
	{
		
		public IndexedObject()
			{
				super();
				this.ID = 0;
			}
		
		public IndexedObject(long id)
			{
				super();
				this.ID = id;
			}
		
		public void autoSetId()
			{
				this.ID = autoId();
			}
		
		public void setExternalID(long value)
			{
				if (this.externalID != value)
					{
						this.externalID = value;
					}
			}
		
		public long getExternalID()
			{
				return this.externalID;
			}
		
		protected String getExternalIDAsString()
			{
				return new Long(this.externalID).toString();
			}
		
		public long getID()
			{
				return this.ID;
			}
		
		protected void setID(long id)
			{
				this.ID = id;
			}
		
		public void setIDandExternalIDtoZero()
			{
				this.ID = 0;
				this.externalID = 0;
			}
		
		public void setIDandExternalIDFrom(IndexedObject io)
			{
				this.ID = io.ID;
				this.externalID = io.externalID;
			}
		
		protected String getIDAsString()
			{
				return new Long(this.ID).toString();
			}
		
		protected static void setIDs(long value)
			{
				IndexedObject.IDs = value;
			}
		
		protected static long getIDs()
			{
				return IndexedObject.IDs;
			}
		
		public String toString()
			{
				return new Long(this.ID).toString();
			}
		
		public String getIDandExternalID()
			{
				return new Long(this.ID).toString() + "/" + new Long(this.externalID).toString();
			}
		
		public String getIDsDescription()
			{
				return "ID:" + this.getID() + " ExternalID:" + this.getExternalID();
			}
		
		public boolean equals(Object obj)
			{
				if (this == obj)
					return true;
				if ((obj == null) || (obj.getClass() != this.getClass()))
					return false;
				return (this.ID == ((IndexedObject) obj).ID) && (this.externalID == ((IndexedObject) obj).externalID);
			}
		
		/**
		 * Returns the hash code for this <code>IndexedObject</code> item.
		 * 
		 * @return <code>int</code> - hash code.
		 */
		public int hashCode()
			{
				return super.hashCode();
			}
		
		public void cloneFieldsTo(IndexedObject clone)
			{
				if (this.ID < 0)
					{
						clone.ID = this.ID;
						clone.externalID = this.externalID;
					}
				else
					{
						clone.ID = this.ID+ID_OFFSET;
						if (ID_OFFSET == 0)
							clone.externalID = this.externalID;
						else
							clone.externalID = 0;
					}
			}
		
		public IndexedObject clone()
			{
				IndexedObject clone = null;
				try
					{
						clone = this.getClass().newInstance();
						cloneFieldsTo(clone);
					}
				catch (InstantiationException e)
					{
						e.printStackTrace();
					}
				catch (IllegalAccessException e)
					{
						e.printStackTrace();
					}
				return clone;
			}
		
		public int compareTo(IndexedObject o)
			{
				return (int) (this.ID - o.ID);
			}
		
		public long autoId()
			{
				return IDs++;
			}
		
		public void load(BaseIOElement element, BaseIO io)
			{
				BaseIOAttribute a = element.getAttribute("id");
				if (a != null)
					{
						externalID = Long.parseLong(a.getValue());
					}
				else
					externalID = 0;
			}
		
		public BaseIOElement store(BaseIOElement element, BaseIO io)
			{
				updateExternalID();
				element.setAttribute("id", Long.toString(this.externalID));
				return element;
			}
		
		public void updateExternalID()
			{
				if (this.externalID == 0)
					this.externalID = Effectopedia.EFFECTOPEDIA.getData().autoExternalID(this);
			}
		
		public ObjectIdentity getObjectIdentity()
			{
				return new ObjectIdentity(ID, TraceableClasses.REGISTERED.getClassID(this.getClass()));
			}
		
		/** The internal (memory) identifier of the <code>IndexedObject</code> */
		private long										ID;
		/**
		 * The external source (XML file or DB) identifier of the
		 * <code>IndexedObject</code>
		 */
		protected long								externalID	= 0;
		/**
		 * Global counter used for assigning ID's of all <code>IndexedObject</code>
		 * that does not override {@link AutoId()}
		 */
		protected static long	IDs								= 0;
		/*
		 * Can be used to create new object IDs with an offset It can be used to merge
		 * information from two dataSources and keeping the internal object id
		 * references
		 */
		public static long				ID_OFFSET		= 0;
	}
