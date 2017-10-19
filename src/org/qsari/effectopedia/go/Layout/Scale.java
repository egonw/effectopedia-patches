package org.qsari.effectopedia.go.Layout;


public class Scale
	{
		public static final int	ZOOM_MIN_LEVEL		= 1;
		public static final int	ZOOM_BASE_LEVEL	= 36;
		public static final int	ZOOM_MAX_LEVEL		= 180;

		public int getLevel()
			{
				return level;
			}
		
		public int setLevel(int level)
			{
				this.level = (level < ZOOM_MIN_LEVEL) ? ZOOM_MIN_LEVEL : ((level > ZOOM_MAX_LEVEL) ? ZOOM_MAX_LEVEL : level);
				return this.level;
			}
		
		public int getZoomStep()
			{
				return zoomStep;
			}

		public void setZoomStep(int zoomStep)
			{
				this.zoomStep = zoomStep;
			}

		public void zoom(boolean in)
			{
				setLevel(getLevel() + ((in) ? +zoomStep : -zoomStep));
			}
		
		public float getObjectHeightScale()
			{
				if (this.level > 36)
					return ( 4.0F * ((float)level)/((float)ZOOM_BASE_LEVEL)) - (3.0F * (float) 36 / (float) ZOOM_BASE_LEVEL);
				else
					return (1.0F * (float) this.level / (float) ZOOM_BASE_LEVEL);
			}
		
		public float getObjectWidthScale()
			{
				if (this.level > 36)
					return ((0.4F * (float) 36 / (float) ZOOM_BASE_LEVEL)) + (0.6F * (float) this.level / (float) ZOOM_BASE_LEVEL);
				else
					return (1.0F * (float) this.level / (float) ZOOM_BASE_LEVEL);
			}
		
		public float getVerticalInsetScale()
			{
				return 0.5F + (0.5F * (float) this.level / (float) ZOOM_BASE_LEVEL);
			}
		
		public float getHorizontalInsetScale()
			{
				return 0.5F + (0.5F * (float) this.level / (float) ZOOM_BASE_LEVEL);
			}
		
		public void reset()
			{
				level = ZOOM_BASE_LEVEL;
				zoomStep = 4;
			}
		
		private int	level			= ZOOM_BASE_LEVEL;
		private int zoomStep = 4; 
	}
