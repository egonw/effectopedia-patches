package org.qsari.effectopedia.go;

public class StandardFixedGOSize extends StandardGOSize
	{
		public StandardFixedGOSize(int height, int width)
			{
				super(height, width);
				limitedScalability = true;
			}
		
		public StandardFixedGOSize(int height, int width, int inset, int fixedGap)
			{
				super(height, width);
				this.nInset = inset;
				this.sInset = inset;
				this.eInset = inset;
				this.wInset = inset;
				this.fixedGap = fixedGap;
				limitedScalability = true;
			}
		
		public int getWidth()
			{
				return this.width;
			}
		
		public int getHeight()
			{
				return this.height;
			}
		
		public void setWidth(int width)
			{
				this.width = width;
			}
		
		public void setHeight(int height)
			{
				this.height = height;
			}
	}
