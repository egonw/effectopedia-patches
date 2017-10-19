package org.qsari.effectopedia.data;

import java.util.ArrayList;
import java.util.EventObject;
import java.util.HashMap;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.base.IndexedObject;

public abstract class RevisionBasedDS extends DataSource
	{
		
		public RevisionBasedDS get(long revision)
			{
				if (revision >= this.revision)
					return this;
				RevisionBasedDS result = revisionCache.get(revision);
				if (result == null)
					{
						result = new HistoricalDS(this, revision);
						revisionCache.put(revision, result);
					}
				return result;
			}
		
		public boolean hasPrevous()
			{
				return (revision >= 1);
			}
		
		public boolean hasNext()
			{
				return false;
			}
		
		public RevisionBasedDS getPrevous(boolean preserveLocation)
			{
				RevisionBasedDS ds = get(revision - 1);
				if (preserveLocation)
					ds.setLocation(this);
				return ds;
			}
		
		public RevisionBasedDS getNext(boolean preserveLocation)
			{
				return this;
			}
		
		public long getRevision()
			{
				return revision;
			}
		
		public long getMaxRevision()
			{
				return revision;
			}
		
		public void setRevision(long revision)
			{
				this.revision = revision;
			}
		
		public final long getLocation()
			{
				return location;
			}
		
		public final void setLocation(long location, boolean internalLocation)
			{
				if (location == 0)
					{
						this.location = 0;
						locationObject = null;
						return;
					}
				locationObject = internalLocation ? getEffectopediaObjectByInternalID(location) : getEffectopediaObjectByExternalID(location);
				if (locationObject != null)
					{
						this.location = location;
						this.internalLocation = internalLocation;
						fireLocationChanged(new EventObject(this));
					}
			}
		
		public void setLocation()
			{
				setLocation(liveIndices.pathways.getLastID(), true);
			}
		
		public final boolean setLocation(EffectopediaObject eo)
			{
				if ((eo == null) || (eo.getDataSource() != this))
					return false;
				long eoExtID = eo.getExternalID();
				this.internalLocation = eoExtID == 0;
				this.location = internalLocation ? eo.getID() : eoExtID;
				this.locationObject = eo;
				fireLocationChanged(new EventObject(this));
				return true;
			}
		
		public final void setLocation(RevisionBasedDS ds)
			{
				EffectopediaObject eo = ds.getLocationObject();
				if (eo == null)
					return;
				this.locationObject = liveIndices.getEffectopediaObject(eo.getID());
				this.internalLocation = ds.isInternalLocation();
				if (locationObject != null)
					this.location = internalLocation ? locationObject.getID() : locationObject.getExternalID();
				else
					this.location = 0;
				fireLocationChanged(new EventObject(this));
			}
		
		public EffectopediaObject getLocationObject()
			{
				return locationObject;
			}
		
		public final String getSourcePrefix()
			{
				return sourcePrefix;
			}
		
		public final void setSourcePrefix(String sourcePrefix)
			{
				this.sourcePrefix = sourcePrefix;
			}
		
		public String getSourceName()
			{
				return sourceName;
			}
		
		public void setSourceName(String sourceName)
			{
				this.sourceName = sourceName;
			}
		
		public String toString()
			{
				if (customTitle != null)
					return customTitle;
				StringBuilder sb = new StringBuilder();
				sb.append(sourcePrefix);
				sb.append(sourceName);
				sb.append("?revision=");
				sb.append(revision);
				if (location != 0)
					{
						if (internalLocation)
							sb.append("&ID=");
						else
							sb.append("&extID=");
						sb.append(location);
					}
				return sb.toString();
			}
		
		public String getObjectURI(IndexedObject io)
			{
				if (customTitle != null)
					return customTitle;
				StringBuilder sb = new StringBuilder();
				sb.append(sourcePrefix);
				sb.append(sourceName);
				sb.append("?revision=");
				sb.append(revision);
				if (io != null)
					{
						long extID = io.getExternalID();
						if (extID == 0)
							{
								sb.append("&ID=");
								sb.append(io.getID());
							}
						else
							{
								sb.append("&extID=");
								sb.append(extID);
							}
					}
				return sb.toString();
			}
		
		public interface LocationChangeListener
			{
				public void locationChanged(EventObject evt);
			}
		
		public void addLocaionChangeListener(LocationChangeListener listener)
			{
				// TODO check if only one listener per class should be allowed
				locationChangeListeners.add(listener);
			}
		
		public void removeLocationChangeListener(LocationChangeListener listener)
			{
				locationChangeListeners.remove(listener);
			}
		
		protected void fireLocationChanged(EventObject evt)
			{
				for (LocationChangeListener listener : locationChangeListeners)
					listener.locationChanged(evt);
			}
		
		public final boolean isInternalLocation()
			{
				return internalLocation;
			}
		
		public long getMaxExternalID()
			{
				return editHistory.getLastExternalID();
			}
		
		public String getCustomTitle()
			{
				return customTitle;
			}
		
		public void setCustomTitle(String customTitle)
			{
				this.customTitle = customTitle;
			}
		
		public void resetCustomTitle()
			{
				this.customTitle = null;
			}
		
		public boolean isProvisional()
			{
				return provisional;
			}
		
		public void setProvisional(boolean provisional)
			{
				this.provisional = provisional;
				if ((provisional) &&(lastNonProvisionalID==0))
					lastNonProvisionalID = externalIDs-1;
			}
		
		protected long																														lastNonProvisionalID				= 0;
		protected boolean																											provisional													= false;
		protected ArrayList<LocationChangeListener>	locationChangeListeners	= new ArrayList<LocationChangeListener>();
		protected HashMap<Long, RevisionBasedDS>				revisionCache;
		protected String																												customTitle;
		protected String																												sourcePrefix;
		protected String																												sourceName;
		protected long																														location																= 0;
		protected EffectopediaObject																locationObject										= null;
		protected boolean																											internalLocation								= false;
		protected long																														revision;
	}
