package org.qsari.effectopedia.go;

import org.qsari.effectopedia.defaults.DefaultGOSettings;
import org.qsari.effectopedia.go.Layout.Scale;

public class StandardGOSize
	{
		public StandardGOSize(int height, int width)
			{
				this.horizontalVisualWeight = 1.0F;
				this.verticalVisualWeight = 1.0F;
				this.height = height;
				this.width = width;
			}
			
		public StandardGOSize(float horizontalVisualWeight, float verticalVisualWeight)
			{
				this.horizontalVisualWeight = horizontalVisualWeight;
				this.verticalVisualWeight = verticalVisualWeight;
				height = Math.round(DefaultGOSettings.defaultHeight * verticalVisualWeight);
				width = Math.round(DefaultGOSettings.defaultWidth * horizontalVisualWeight);
			}
			
		public StandardGOSize(float horizontalVisualWeight, float verticalVisualWeight, int inset, int fixedGap)
			{
				this.horizontalVisualWeight = horizontalVisualWeight;
				this.verticalVisualWeight = verticalVisualWeight;
				this.nInset = inset;
				this.sInset = inset;
				this.eInset = inset;
				this.wInset = inset;
				this.fixedGap = fixedGap;
				height = Math.round(DefaultGOSettings.defaultHeight * verticalVisualWeight);
				width = Math.round(DefaultGOSettings.defaultWidth * horizontalVisualWeight);
			}
			
		public void resizeGO(GraphicObject o)
			{
				o.setWidth(this.width);
				o.setHeight(this.height);
			}
			
		public int getWidth()
			{
				return Math.round(DefaultGOSettings.defaultWidth * horizontalVisualWeight);
			}
			
		public int getHeight()
			{
				return Math.round(DefaultGOSettings.defaultHeight * verticalVisualWeight);
			}
			
		public int getFixedGap()
			{
				return fixedGap;
			}
			
		public int getTotlaWidth()
			{
				return fixedGap + sInset + width + nInset + fixedGap;
			}
			
		public int getTotlaHeight()
			{
				return fixedGap + eInset + height + wInset + fixedGap;
			}
			
		public boolean getLimitedScalability()
			{
				return limitedScalability;
			}
			
		public void setFixedGap(int fixedGap)
			{
				this.fixedGap = fixedGap;
			}
			
		public void setLimitedScalability(boolean limitedScalability)
			{
				this.limitedScalability = limitedScalability;
			}
			
		public int getNInset()
			{
				return nInset;
			}
			
		public void setNInset(int nInset)
			{
				this.nInset = nInset;
			}
			
		public int getEInset()
			{
				return eInset;
			}
			
		public void setEInset(int eInset)
			{
				this.eInset = eInset;
			}
			
		public int getSInset()
			{
				return sInset;
			}
			
		public void setSInset(int sInset)
			{
				this.sInset = sInset;
			}
			
		public int getWInset()
			{
				return wInset;
			}
			
		public void setWInset(int wInset)
			{
				this.wInset = wInset;
			}
			
		public void scale(Scale scale)
			{
				height = Math.round(DefaultGOSettings.defaultHeight * verticalVisualWeight * scale.getObjectHeightScale());
				width = Math.round(DefaultGOSettings.defaultWidth * horizontalVisualWeight * scale.getObjectWidthScale());
				if (horizontalVisualWeight == 0F)
					{
						eInset = 0;
						wInset = 0;
					}
				else
					{
						eInset = Math.round(DefaultGOSettings.defaultEInset * scale.getHorizontalInsetScale());
						wInset = Math.round(DefaultGOSettings.defaultWInset * scale.getHorizontalInsetScale());
						
					}
				if (verticalVisualWeight == 0F)
					{
						nInset = 0;
						sInset = 0;
					}
				else
					{
						nInset = Math.round(DefaultGOSettings.defaultNInset * scale.getVerticalInsetScale());
						sInset = Math.round(DefaultGOSettings.defaultSInset * scale.getVerticalInsetScale());
					}
			}
			
		protected int											height													= DefaultGOSettings.defaultHeight;
		protected int											width														= DefaultGOSettings.defaultWidth;
		protected int											nInset													= DefaultGOSettings.defaultNInset;
		protected int											eInset													= DefaultGOSettings.defaultEInset;
		protected int											sInset													= DefaultGOSettings.defaultSInset;
		protected int											wInset													= DefaultGOSettings.defaultWInset;
		protected int											fixedGap											= DefaultGOSettings.defaultFixedGap;
		
		protected boolean							limitedScalability	= false;
		
		public final float						horizontalVisualWeight;
		public final float						verticalVisualWeight;
		
		public static final int	ZERO_INSET									= 0;
		public static final int	ZERO_GAP											= 0;
	}
