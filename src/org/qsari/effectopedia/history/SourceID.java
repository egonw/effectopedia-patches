package org.qsari.effectopedia.history;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Date;
import java.util.zip.CRC32;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.base.io.BaseIO;
import org.qsari.effectopedia.base.io.BaseIOAttribute;
import org.qsari.effectopedia.base.io.BaseIOElement;
import org.qsari.effectopedia.base.io.Exportable;
import org.qsari.effectopedia.base.io.Importable;
import org.qsari.effectopedia.core.Effectopedia;
import org.qsari.effectopedia.utils.HexCharByteConverter;

public class SourceID implements Importable, Exportable
	{
		private static byte[] getMAC()
			{
				try
					{
						InetAddress address = InetAddress.getLocalHost();
						NetworkInterface ni = NetworkInterface.getByInetAddress(address);
						if (ni != null)
							{
								byte[] mac = ni.getHardwareAddress();
								return (mac.length != 0) ? mac : DEFAULT_MAC;
							}
					}
				catch (Exception e)
					{
						return DEFAULT_MAC;
					}
				return DEFAULT_MAC;
			}
			
		private byte[] getIP()
			{
				try
					{
						byte[] ip = InetAddress.getLocalHost().getAddress();
						if ((ip != null) || (mac.length != 0))
							return ip;
					}
				catch (UnknownHostException e)
					{
						return DEFAULT_IP;
					}
				return DEFAULT_IP;
			}
			
		private long getSessionID()
			{
				if (Stamp.DEFAULT_DATE != null)
					return 1324829848126L - Stamp.DEFAULT_DATE.getTime();
				else
					return 1324829848126L - (new Date()).getTime();
			}
			
		public boolean isValid(String sourceID)
			{
				return isValid(sourceID.getBytes());
			}
			
		public boolean isValid(byte[] bytes)
			{
				ByteArrayInputStream sourceID = new ByteArrayInputStream(bytes);
				DataInputStream sourceIDStream = new DataInputStream(sourceID);
				byte[] content = new byte[bytes.length - Long.SIZE];
				long storedCRC;
				long contentCRC;
				try
					{
						sourceIDStream.read(content, Long.SIZE, bytes.length - Long.SIZE);
						CRC32 crc32 = new CRC32();
						crc32.update(content);
						storedCRC = sourceIDStream.readLong();
						contentCRC = crc32.getValue();
						sourceIDStream.close();
					}
				catch (IOException e)
					{
						return false;
					}
				return contentCRC == storedCRC;
			}
			
		public boolean setSourceIDFromByteArray(byte[] bytes)
			{
				if (bytes == null)
					return false;
				ByteArrayInputStream sourceID = new ByteArrayInputStream(bytes);
				DataInputStream sourceIDStream = new DataInputStream(sourceID);
				byte[] content = new byte[bytes.length - (Long.SIZE >> 3)];
				long storedCRC;
				long contentCRC;
				try
					{
						sourceIDStream.read(content, 0, content.length);
						CRC32 crc32 = new CRC32();
						crc32.update(content);
						storedCRC = sourceIDStream.readLong();
						contentCRC = crc32.getValue();
						sourceIDStream.close();
						if (contentCRC == storedCRC)
							{
								sourceID = new ByteArrayInputStream(content);
								sourceIDStream = new DataInputStream(sourceID);
								sourceIDStream.read(mac, 0, 6);
								sourceIDStream.read(ip, 0, 4);
								userId = sourceIDStream.readLong();
								date = new Date(sourceIDStream.readLong());
								revision = sourceIDStream.readLong();
								ID = sourceIDStream.readLong();
								sessionId = sourceIDStream.readLong();
								crc = contentCRC;
							}
					}
				catch (IOException e)
					{
						return false;
					}
				return contentCRC == storedCRC;
			}
			
		public void setSourceIDFromString(String SourceID)
			{
				setSourceIDFromByteArray(SourceID.getBytes());
			}
			
		public void setSourceIDFromHEXString(String SourceID)
			{
				setSourceIDFromByteArray(HexCharByteConverter.convert(SourceID.toCharArray()));
			}
			
		public String getSourceIDAsString()
			{
				byte[] sourceId = getSourceIDAsByteArray();
				if (sourceId == null)
					return null;
				else
					return sourceId.toString();
			}
			
		public String getSourceIDAsHEXString()
			{
				byte[] sourceId = getSourceIDAsByteArray();
				if (sourceId == null)
					return null;
				else
					{
						char[] chars = HexCharByteConverter.convert(sourceId);
						return new String(chars);
					}
			}
			
		public byte[] getSourceIDAsByteArray()
			{
				ByteArrayOutputStream sourceID = new ByteArrayOutputStream(DEFAULT_MAC.length + DEFAULT_IP.length + (Long.SIZE >> 3) * 6);
				DataOutputStream sourceIDStream = new DataOutputStream(sourceID);
				if (!updateStream(sourceIDStream))
					return null;
				crc = getCRC(sourceID.toByteArray());
				try
					{
						sourceIDStream.writeLong(crc);
						sourceIDStream.flush();
					}
				catch (IOException e)
					{
						return null;
					}
				return sourceID.toByteArray();
			}
			
		public void load(BaseIOElement element, BaseIO io)
			{
				if (element != null)
					{
						BaseIOAttribute dsID = element.getAttribute("data_source_id");
						if (dsID != null)
							dataSourceID = dsID.getLongValue();
						setSourceIDFromHEXString(element.getValue());
					}
			}
			
		public BaseIOElement store(BaseIOElement element, BaseIO io)
			{
				if (element != null)
					{
						element.setAttribute("data_source_id", dataSourceID);
						element.setValue(getSourceIDAsHEXString());
					}
				return element;
			}
			
		public SourceID setIfDefault(EffectopediaObject eo)
			{
				if (eo.isDefaultID())
					{
						mac = DEFAULT_MAC;
						ip = DEFAULT_IP;
						revision = 0L;
						date = Stamp.DEFAULT_DATE != null ? Stamp.DEFAULT_DATE : new Date();
						userId = 0L;
						sessionId = 0L;
						ID = eo.getDefaultID();
						dataSourceID = (eo.getDataSource() != null) ? eo.getDataSource().getDataSourceID() : -1;
						ByteArrayOutputStream sourceID = new ByteArrayOutputStream(DEFAULT_MAC.length + DEFAULT_IP.length + (Long.SIZE >> 3) * 6);
						DataOutputStream sourceIDStream = new DataOutputStream(sourceID);
						if (updateStream(sourceIDStream))
							crc = getCRC(sourceID.toByteArray());
					}
				return this;
			}
			
		private boolean updateStream(DataOutputStream sourceIDStream)
			{
				try
					{
						sourceIDStream.write(mac);
						sourceIDStream.write(ip);
						sourceIDStream.writeLong(userId);
						sourceIDStream.writeLong(date.getTime());
						sourceIDStream.writeLong(revision);
						sourceIDStream.writeLong(ID);
						sourceIDStream.writeLong(sessionId);
					}
				catch (IOException e)
					{
						return false;
					}
				return true;
			}
			
		public String DEBUG_getIDs()
			{
				StringBuilder sb = new StringBuilder();
				sb.append("mac\t");
				sb.append(HexCharByteConverter.convert(mac));
				sb.append("\tip\t");
				sb.append(HexCharByteConverter.convert(ip));
				sb.append("\tuserId\t");
				sb.append(userId);
				sb.append("\tdate\t");
				sb.append(date);
				sb.append("\trevision\t");
				sb.append(revision);
				sb.append("\tID\t");
				sb.append(ID);
				sb.append("\tsessionId\t");
				sb.append(sessionId);
				return sb.toString();
			}
			
		private long getCRC(byte[] bytes)
			{
				CRC32 crc32 = new CRC32();
				crc32.update(bytes);
				return crc32.getValue();
			}
			
		public int hashCode()
			{
				return (int) crc;
			}
			
		public boolean equals(Object o)
			{
				if (o instanceof SourceID)
					{
						SourceID s = (SourceID) o;
						return Arrays.equals(mac, s.mac) && Arrays.equals(ip, s.ip) && revision == s.revision && userId == s.userId && date.equals(s.date) && ID == s.ID && sessionId == s.sessionId
								&& dataSourceID == s.dataSourceID && crc == s.crc;
					}
				else
					return false;
			}
			
		public byte[] getIp()
			{
				return ip;
			}
			
		public long getRevision()
			{
				return revision;
			}
			
		public long getUserId()
			{
				return userId;
			}
			
		public Date getDate()
			{
				return date;
			}
			
		public long getSessionId()
			{
				return sessionId;
			}
			
		public long getID()
			{
				return ID;
			}
			
		public void setID(long ID)
			{
				if (this.ID == 0)
					this.ID = ID;
			}
			
		public long getDataSourceID()
			{
				return dataSourceID;
			}
			
		public void setDataSourceID(long dataSourceID)
			{
				this.dataSourceID = dataSourceID;
			}
			
		public static final byte[]							DEFAULT_MAC		= new byte[]
			{ -1, -1, -1, -1, -1, -1 };
		public static final byte[]							DEFAULT_IP			= new byte[]
			{ -1, -1, -1, -1 };
			
		public static final byte[]	MAC										= getMAC();
		private byte[]													mac										= Arrays.copyOf(MAC,MAC.length);
		private byte[]													ip											= getIP();
		private long															revision					= Effectopedia.EFFECTOPEDIA.getRevision();
		private long															userId							= Effectopedia.EFFECTOPEDIA.getCurrentUserID();
		private Date															date									= Stamp.DEFAULT_DATE != null ? Stamp.DEFAULT_DATE : new Date();
		private long															sessionId				= getSessionID();
		private long															ID											= 0;
		private long															dataSourceID	= Effectopedia.EFFECTOPEDIA.getData().getDataSourceID();
		private long															crc;
	}
