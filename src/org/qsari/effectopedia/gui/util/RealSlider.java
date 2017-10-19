package org.qsari.effectopedia.gui.util;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Dictionary;
import java.util.Hashtable;

import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class RealSlider extends JSlider implements ChangeListener
	{
		public RealSlider()
			{
				super(sliderMin, sliderMax);
				setPaintLabels(true);
				setPaintTicks(true);
				setMajorTickSpacing(sliderMajorTickSpacing);
				setMinorTickSpacing(sliderMinorTickSpacing);
				setMaximum(sliderMax);
				setValue(sliderMax / 2);
			}
		
		public RealSlider(double min, double max, double value)
			{
				super(sliderMin, sliderMax);
				init(min, max, value);
				addChangeListener(this);
			}
		
		public void init(double min, double max, double value)
			{
				this.min = Double.isNaN(min) ? 0 : min;
				this.max = Double.isNaN(max) ? 0 : max;
				this.value = Double.isNaN(value) ? 0 : value;
				if (this.max == this.min)
					{
						this.min = this.min * 0.9;
						this.max = this.max * 1.1;
						scale = this.min==0?sliderMax:sliderMax / (this.max - this.min);
					}
				else
					scale = sliderMax / (this.max - this.min);
				increment = (new BigDecimal(this.max).subtract(new BigDecimal(this.min)).divide(new BigDecimal(sliderMax))).round(new MathContext(5)).doubleValue();
				setValue((int) Math.round((this.value - this.min) * scale));
				setPaintLabels(true);
				setPaintTicks(true);
				setMajorTickSpacing(sliderMajorTickSpacing);
				setMinorTickSpacing(sliderMinorTickSpacing);
				Dictionary<Integer, JLabel> labels = new Hashtable<>();
				for (int i = sliderMin; i <= sliderMax; i += sliderMajorTickSpacing)
					{
						labels.put(i, new JLabel(defaultFormat(this.min + (i / scale), 3)));
					}
				setLabelTable(labels);
			}
		
		public static String defaultFormat(double value, int precision)
			{
				String format = "%4." + precision;
				format += ((10000 > Math.abs(value)) && (Math.abs(value) > 0.1)) ? "f" : "e";
				return String.format(format, value);
			}
		
		@Override
		public void stateChanged(ChangeEvent e)
			{
				this.value = min + getValue() * increment;
			}
		
		public double getRealValue()
			{
				return min + (getValue() / scale);
			}
		
		public void setRealValue(double value)
			{
				this.value = value;
				if (value < min)
					setValue(sliderMin);
				else if (value > max)
					setValue(sliderMax);
				else
					setValue((int) Math.round((value - min) * scale));
			}
		
		public static final int			sliderMin														= 0;
		public static final int			sliderMax														= 400;
		public static final int			sliderMajorTickSpacing	= 100;
		public static final int			sliderMinorTickSpacing	= 10;
		protected double										min																				= sliderMin;
		protected double										value																		= sliderMax / 2;
		protected double										max																				= sliderMax;
		protected double										scale																		= 1.0D;
		protected double										increment														= 1D;
		private static final long	serialVersionUID							= 1L;
	}
