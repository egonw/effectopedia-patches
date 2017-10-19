package org.qsari.effectopedia.history;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.qsari.effectopedia.base.IndexedObject;
import org.qsari.effectopedia.base.io.BaseIO;
import org.qsari.effectopedia.base.io.BaseIOElement;
import org.qsari.effectopedia.base.io.BaseIOValue;
import org.qsari.effectopedia.base.io.Exportable;
import org.qsari.effectopedia.base.io.Importable;

public class Stamp extends IndexedObject implements Importable, Exportable
	{
		
		public Stamp()
			{
				super();
				autoSetId();
			}
		
		public Stamp(long actionId, long userId, long teamId)
			{
				this();
				this.actionId = actionId;
				this.teamId = teamId;
				this.userId = userId;
				this.location = "local";
				if (DEFAULT_DATE != null)
					this.date = DEFAULT_DATE;
				else
					this.date = new Date();
			}
		
		public Stamp(long actionId, long userId, long teamId, String location)
			{
				super();
				autoSetId();
				this.actionId = actionId;
				this.userId = userId;
				this.teamId = teamId;
				this.location = location;
				if (DEFAULT_DATE != null)
					this.date = DEFAULT_DATE;
				else
					this.date = new Date();
			}
		
		public long autoId()
			{
				return stampIDs++;
			}
		
		public void load(BaseIOElement element, BaseIO io)
			{
				if (element != null)
					{
						super.load(element, io);
						actionId = element.getValueElement("action_id").getLongValue();
						userId = element.getValueElement("user_id").getLongValue();
						BaseIOValue tID = element.getValueElement("team_id");
						if (tID != null)
							teamId = tID.getLongValue();
						location = element.getValueElement("location").getValue();
						try
							{
								date = sdf.parse(element.getChildValue("date"));
							}
						catch (ParseException e)
							{
								if (DEFAULT_DATE != null)
									this.date = DEFAULT_DATE;
								else
									date = new Date(0);
								e.printStackTrace();
							}
					}
			}
		
		public BaseIOElement store(BaseIOElement element, BaseIO io)
			{
				updateExternalID();
				element.setAttribute("id", Long.toString(EditHistory.actionsCnt));
				element.addValueElement(io.newValue("action_id").setValue(actionId));
				element.addValueElement(io.newValue("user_id").setValue(userId));
				if (teamId > 0)
					element.addValueElement(io.newValue("team_id").setValue(teamId));
				element.addValueElement(io.newValue("location").setValue(location));
				element.addValueElement(io.newValue("date").setValue(sdf.format(date)));
				return element;
			}
		
		public long getActionId()
			{
				return actionId;
			}
		
		public void setActionId(long actionId)
			{
				this.actionId = actionId;
			}
		
		public long getUserId()
			{
				return userId;
			}
		
		public void setUserId(long userId)
			{
				this.userId = userId;
			}
		
		public long getTeamId()
			{
				return teamId;
			}
		
		public void setTeamId(long teamId)
			{
				this.teamId = teamId;
			}
		
		public String getLocation()
			{
				return location;
			}
		
		public void setLocation(String location)
			{
				this.location = location;
			}
		
		public Date getDate()
			{
				return date;
			}
		
		public String getFormattedDate()
			{
				return sdf.format(date);
			}
		
		public void setDate(Date date)
			{
				this.date = date;
			}
		
		public boolean equals(Object obj)
			{
				if (this == obj)
					return true;
				if ((obj == null) || (obj.getClass() != this.getClass()))
					return false;
				Stamp s = (Stamp) obj;
				return (actionId == s.actionId) && (userId == s.userId) && (teamId == s.teamId) && (location.compareTo(s.location) == 0) && (date.getTime() == s.date.getTime());
			}
		
		public static final long getStampIDs()
			{
				return stampIDs;
			}
		
		public static final void setDefaultDate(int year, int month, int day, int hour, int minute, int second, int milisecond)
			{
				Calendar calendar = Calendar.getInstance();
				calendar.set(year, month, day, hour, minute, second);
				calendar.set(Calendar.MILLISECOND, milisecond);
				DEFAULT_DATE = calendar.getTime();
			}
		
		public static final void resetDefaultDate()
			{
				DEFAULT_DATE = null;
			}
		
		private long																									actionId;
		private long																									userId;
		private long																									teamId = -1;
		private String																							location;
		private Date																									date;
		
		protected static long																stampIDs					= 0;
		public static Date																			DEFAULT_DATE	= null;
		public static final String											DATE_FORMAT		= "yyyy-MM-dd HH:mm:ss";
		public static final SimpleDateFormat	sdf										= new SimpleDateFormat(DATE_FORMAT, Locale.US);
	}
