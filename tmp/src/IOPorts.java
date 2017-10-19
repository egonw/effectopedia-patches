package org.qsari.effectopedia.go;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

public class IOPorts
	{
		public enum Skew
			{
				UP, DOWN
			};
		
		public IOPorts()
			{
				this.ports = new ArrayList<IOPort>();
			}
		
		private ArrayList<IOPort>	ports;
		
		public ArrayList<IOPort> getPorts()
			{
				return ports;
			}
		
		public IOPort[] getConnectedPortsArray()
			{
				IOPort[] ports = new IOPort[this.ports.size()];
				return this.ports.toArray(ports);
			}
		
		public int getVerticalTension(int y)
			{
				int cnt = ports.size();
				if (cnt != 0)
					{
						int tension = 0;
						for (IOPort p : ports)
							tension += y - p.getY();
						return tension / cnt;
					}
				else
					return 0;
			}
		
		public LinkedList<PathwayElementGO> getConnectedIGO()
			{
				LinkedList<PathwayElementGO> list = new LinkedList<PathwayElementGO>();
				for (ListIterator<IOPort> iterator = ports.listIterator(); iterator.hasNext();)
					list.add(iterator.next().getOwner());
				return list;
			}
		
		public void addConnection(IOPort port)
			{
				ports.add(port);
			}
		
		public boolean isConnection(IOPort port)
			{
				return ports.indexOf(port) != -1;
			}
		
		public void clearConnections()
			{
				ports.clear();
			}
		
		/*
		 * offset - y coordinate of the first available position
		 * 
		 * skew - the direction in which objects will be shifted if not enough space
		 * is available
		 * 
		 * optimalY - desired midpoint of all connectedPorts y coordinate
		 */

		public int distribute(int offset, Skew skew, int optimalY,int vGapHeight)
			{
				int totalHeight = getTotalHeight(vGapHeight);
				int halfTotalHeight = totalHeight / 2;
				if (skew == Skew.UP)
					{
						int deltaY = optimalY - offset;
						if (deltaY >= halfTotalHeight)
							{
								setPortsYLocation(optimalY,vGapHeight);
								return optimalY - halfTotalHeight;
							}
						else
							{// skew
								setPortsYLocation(optimalY - (halfTotalHeight - deltaY),vGapHeight);
								return offset - totalHeight - (halfTotalHeight - deltaY);
							}
					}
				else
					// skew==Skew.DOWN
					{
						int deltaY = offset - optimalY;
						if (deltaY >= halfTotalHeight)
							{
								setPortsYLocation(optimalY,vGapHeight);
								return optimalY + halfTotalHeight;
							}
						else
							{// skew
								setPortsYLocation(optimalY + (halfTotalHeight - deltaY),vGapHeight);
								return offset + totalHeight + (halfTotalHeight - deltaY);
							}
					}
			}
		
		public int distribute(int optimalY,int vGapHeight)
			{
				setPortsYLocation(optimalY,vGapHeight);
				return getTotalHeight(vGapHeight) / 2;
			}
		
		public int getTotalHeight(int vGapHeight)
			{
				int totalHeight = 0;
				for (IOPort p : ports)
					{
						totalHeight += p.getOwner().getTotalHeight(vGapHeight);
					}
				return totalHeight;
			}
		
		public void setPortsYLocation(int yLocation,int vGapHeight)
			{
				int offset = yLocation - (getTotalHeight(vGapHeight) / 2);
				for (IOPort p : ports)
					{
						PathwayElementGO o = p.getOwner();
						int oHeight = o.getTotalHeight(vGapHeight);
						o.setPortsYLocation(offset + oHeight / 2);
						offset += oHeight;
					}
			}
		
	}
