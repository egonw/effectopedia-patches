package org.qsari.effectopedia.go;

import java.util.ArrayList;

public class IOPorts
	{
		public IOPorts(GraphicObject owner)
			{
				this.owner = owner;
				this.ports = new ArrayList<IOPort>();
			}
		
		public ArrayList<IOPort> getPorts()
			{
				return ports;
			}
		
		public GraphicObject getOwner()
			{
				return owner;
			}
		
		public void add(IOPort port)
			{
				ports.add(port);
			}
		
		public void clearPorts()
			{
				ports.clear();
			}
		
		public IOPort port(int index)
			{
				return ports.get(index);
			}

		public IOPort use(int index)
			{
				IOPort port = ports.get(index);
				port.setUsed(true);
				return port;
			}
   
		public IOPort getFirstUsed()
			{
				IOPort port = null;
				for (int i=0;i<ports.size();i++)
				 if (ports.get(i).isUsed())
				 	return ports.get(i);
				return port;
			}

		public IOPort getLastUsed()
			{
				IOPort port = null;
				for (int i=ports.size()-1;i>=0;i--)
				 if (ports.get(i).isUsed())
				 	return ports.get(i);
				return port;
			}

		public void updatePortLocations()
			{
			}
		
		public void updatePortLocations(int x, int y, int width, int height)
			{
			}
		
		public int getOriginPortIndex(int xOrigin, int yOrigin, int xEnd, int yEnd)
			{
				return -1;
			}
		
		public int getEndPortIndex(int xOrigin, int yOrigin, int xEnd, int yEnd)
			{
				return -1;
			}
		
		public boolean contains(IOPort port)
			{
				return ports.indexOf(port) != -1;
			}

		public int getPortIndex(IOPort port)
			{
				return ports.indexOf(port);
			}
		
		protected ArrayList<IOPort>	ports;
		protected GraphicObject					owner;
	}
