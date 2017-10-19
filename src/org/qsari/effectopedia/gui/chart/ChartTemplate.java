package org.qsari.effectopedia.gui.chart;

public class ChartTemplate
	{
		public ChartTemplate(String xAxisTitle, String yAxisTitle, String chartTitle)
			{
				this.xAxisTitle = xAxisTitle;
				this.yPrimaryAxisTitle = yAxisTitle;
				this.chartTitle = chartTitle;
			}

		public ChartTemplate(String xAxisTitle, String yPrimaryAxisTitle,String ySecondaryAxisTitle, String chartTitle)
			{
				this.xAxisTitle = xAxisTitle;
				this.yPrimaryAxisTitle = yPrimaryAxisTitle;
				this.ySecondaryAxisTitle = ySecondaryAxisTitle;
				this.chartTitle = chartTitle;
			}
		
		public String	xAxisTitle;
		public String	yPrimaryAxisTitle;
		public String	ySecondaryAxisTitle;
		public String	chartTitle;
	}
