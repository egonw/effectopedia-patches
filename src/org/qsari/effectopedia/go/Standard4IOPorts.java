package org.qsari.effectopedia.go;

public class Standard4IOPorts extends IOPorts
	{
		public Standard4IOPorts(GraphicObject owner)
			{
				super(owner);
				int hW = owner.getWidth() / 2;
				int xC = owner.getX() + hW;
				int hH = owner.getHeight() / 2;
				int yC = owner.getY() + hH;
				add(new IOPort(owner, xC, yC - hH));
				add(new IOPort(owner, xC - hW, yC));
				add(new IOPort(owner, xC + hW, yC));
				add(new IOPort(owner, xC, yC + hH));
			}
		
		public void updatePortLocations()
			{
				int hW = owner.getWidth() / 2;
				int xC = owner.getX() + hW;
				int hH = owner.getHeight() / 2;
				int yC = owner.getY() + hH;
				ports.get(N).setXY(xC, yC - hH);
				ports.get(W).setXY(xC - hW, yC);
				ports.get(E).setXY(xC + hW, yC);
				ports.get(S).setXY(xC, yC + hH);
			}

		public void updatePortLocations(int x, int y, int width, int height)
			{
				int hW = width / 2;
				int xC = x + hW;
				int hH = height / 2;
				int yC = y + hH;
				ports.get(N).setXY(xC, yC - hH);
				ports.get(W).setXY(xC - hW, yC);
				ports.get(E).setXY(xC + hW, yC);
				ports.get(S).setXY(xC, yC + hH);
			}
	
		public int getOriginPortIndex(int xOrigin,int yOrigin, int xEnd, int yEnd)
			{
				if (xOrigin==xEnd)
					{
					if (yOrigin==yEnd)
						return -1;
					else 
						return (yOrigin>yEnd)?N:S;
					}
				else 
					return (xOrigin<xEnd)?E:W;
			}

		public int getEndPortIndex(int xOrigin,int yOrigin, int xEnd, int yEnd)
			{
				if (xOrigin==xEnd)
					{
					if (yOrigin==yEnd)
						return -1;
					else 
						return (yOrigin<yEnd)?N:S;
					}
				else 
					return (xOrigin>xEnd)?E:W;
			}

// Port locations with respect of the owner object
		public static final int	N		= 0;
		public static final int	W		= 1;
		public static final int	E		= 2;
		public static final int	S		= 3;
		public static final int	NE	= 0;
		public static final int	NW	= 1;
		public static final int	SE	= 2;
		public static final int	SW	= 3;
	}
