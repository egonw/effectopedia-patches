package org.qsari.effectopedia.go;


public class Standard8IOPorts extends IOPorts
	{
		public static enum Distribution
			{
				RECTANGULAR, ROUNDRECTANGULAR, CIRCULAR
			}
		
		public Standard8IOPorts(GraphicObject owner, Distribution distribution)
			{
				super(owner);
				for (int i = 0; i < 8; i++)
					add(new IOPort(owner));
				setDistribution(distribution);
			}
		
		public Distribution getDistribution()
			{
				return distribution;
			}
		
		public void setDistribution(Distribution distribution)
			{
				this.distribution = distribution;
				distributePorts(distribution,owner.getX(),owner.getY(),owner.getWidth(),owner.getHeight());
			}
		
		protected void rectangularDistribution(int x, int y, int width, int height)
			{
				int c = 0;
				for (int i = 0; i < 3; i++)
					for (int j = 0; j < 3; j++)
						if ((i!=1)||(j!=1))
							{
								IOPort port = ports.get(c++);
								port.setX(x + width * j / 2);
								port.setY(y + height * i / 2);
							}
			}

		protected void roundrectangularDistribution(int curvature,int x, int y, int width, int height)
			{
				int halfWidth = width / 2;
				int xCenter = x + halfWidth;
				int halfHeight = height / 2;
				int yCenter = y + halfHeight;
				int c = curvature-1 - (int) Math.round(curvature / Math.sqrt(2));
				ports.get(N).setXY(xCenter, yCenter - halfHeight);
				ports.get(W).setXY(xCenter - halfWidth, yCenter);
				ports.get(E).setXY(xCenter + halfWidth, yCenter);
				ports.get(S).setXY(xCenter, yCenter + halfHeight);
				ports.get(NW).setXY(x+c, y+c);
				ports.get(NE).setXY(xCenter+halfWidth-c, y+c);
				ports.get(SW).setXY(x+c, yCenter+halfHeight-c);
				ports.get(SE).setXY(xCenter+halfWidth-c, yCenter+halfHeight-c);
			}

		protected void circularDistribution(int radius,int x, int y)
			{
				int xCenter = x + radius;
				int yCenter = y + radius;
				int r = (int) Math.round(radius / Math.sqrt(2));
				ports.get(N).setXY(xCenter, yCenter - radius);
				ports.get(W).setXY(xCenter - radius, yCenter);
				ports.get(E).setXY(xCenter + radius, yCenter);
				ports.get(S).setXY(xCenter, yCenter + radius);
				ports.get(NW).setXY(xCenter-r, yCenter-r);
				ports.get(NE).setXY(xCenter+r, yCenter-r);
				ports.get(SW).setXY(xCenter-r, yCenter+r);
				ports.get(SE).setXY(xCenter+r, yCenter+r);
			}
		
		private void distributePorts(Distribution distribution,int x, int y, int width, int height)
			{
				switch (distribution)
					{
						case RECTANGULAR:
							rectangularDistribution(x, y, width, height);
							break;
						case ROUNDRECTANGULAR:
							roundrectangularDistribution(8,x, y, width, height);
							break;
						case CIRCULAR:
							circularDistribution(Math.min(owner.getWidth(),owner.getHeight())/2,x,y);
							break;
					}
			}
		
		public void updatePortLocations()
			{
				distributePorts(distribution,owner.getX(),owner.getY(),owner.getWidth(),owner.getHeight());
			}

		public void updatePortLocations(int x, int y, int width, int height)
			{
				distributePorts(distribution,x,y,width,height);
			}
		
		public int getOriginPortIndex(int xOrigin,int yOrigin, int xEnd, int yEnd)
			{
				int xDif = xEnd-xOrigin;
				int yDif = yEnd-yOrigin;
				if (xDif<0)
					if (yDif==0)
						return W;
					else
						return (yDif<0)?NW:SW;
				else if (xDif>0)
					if (yDif==0)
						return E;
					else
						return (yDif<0)?NE:SE;
				else if (xDif==0)
					if (yDif!=0)
						return (yDif<0)?N:S;
			 return -1;
			}

		public int getEndPortIndex(int xOrigin,int yOrigin, int xEnd, int yEnd)
			{
				int xDif = xOrigin-xEnd;
				int yDif = yOrigin-yEnd;
				if (xDif<0)
					if (yDif==0)
						return W;
					else
						return (yDif<0)?NW:SW;
				else if (xDif>0)
					if (yDif==0)
						return E;
					else
						return (yDif<0)?NE:SE;
				else if (xDif==0)
					if (yDif!=0)
						return (yDif<0)?N:S;
			 return -1;
			}
		
		public static final int	NW											= 0;
		public static final int	N												= 1;
		public static final int	NE											= 2;
		public static final int	W												= 3;
		public static final int	E												= 4;
		public static final int	SW											= 5;
		public static final int	S												= 6;
		public static final int	SE											= 7;
		
		private Distribution				distribution	= Distribution.RECTANGULAR;
	}
