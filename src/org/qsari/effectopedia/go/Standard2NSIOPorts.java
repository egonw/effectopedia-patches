package org.qsari.effectopedia.go;

public class Standard2NSIOPorts extends IOPorts
	{
		public Standard2NSIOPorts(GraphicObject owner)
			{
				super(owner);
				int hW = owner.getWidth() / 2;
				int xC = owner.getX() + hW;
				int hH = owner.getHeight() / 2;
				int yC = owner.getY() + hH;
				add(new IOPort(owner, xC, yC - hH));
				add(new IOPort(owner, xC, yC + hH));
			}
		
		public void updatePortLocations()
			{
				int hW = owner.getWidth() / 2;
				int xC = owner.getX() + hW;
				int hH = owner.getHeight() / 2;
				int yC = owner.getY() + hH;
				ports.get(N).setXY(xC, yC - hH);
				ports.get(S).setXY(xC, yC + hH);
			}

		public void updatePortLocations(int x, int y, int width, int height)
			{
				int hW = width / 2;
				int xC = x + hW;
				int hH = height / 2;
				int yC = y + hH;
				ports.get(N).setXY(xC, yC - hH);
				ports.get(S).setXY(xC, yC + hH);
			}
	
		public int getOriginPortIndex(int xOrigin,int yOrigin, int xEnd, int yEnd)
			{
    return yOrigin<yEnd?S:N;	
			}

		public int getEndPortIndex(int xOrigin,int yOrigin, int xEnd, int yEnd)
			{
				return yOrigin<yEnd?N:S;
			}

// Port locations with respect of the owner object
		public static final int	N		= 0;
		public static final int	W		= 0;
		public static final int	E		= 1;
		public static final int	S		= 1;
		public static final int	NE	= 0;
		public static final int	NW	= 0;
		public static final int	SE	= 1;
		public static final int	SW	= 1;
	}

