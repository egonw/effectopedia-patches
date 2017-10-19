package org.qsari.effectopedia.gui.obj_prop;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.DefaultListCellRenderer;
import javax.swing.Icon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;

import org.qsari.effectopedia.gui.chart.ChartDataSeries;
import org.qsari.effectopedia.gui.chart.ChartDataSeries.Marker;

public class MarkersListRenderer extends DefaultListCellRenderer
	{
		
		public final Marker[]	markers;
		private Color									fillColor										= Color.white;
		private Color									outlineColor							= Color.white;
		private int											prefCollapsedWidth	= 32;
		private int											prefExpandedWidth		= 32;
		private Dimension					preferredSize						= new Dimension(prefCollapsedWidth, 24);
		
		public MarkersListRenderer(Color fillColor, Color outlineColor)
			{
				this.fillColor = fillColor;
				this.outlineColor = outlineColor;
				this.markers = new Marker[ChartDataSeries.MARKER_MAX];
				for (int i = markers.length - 1; i >= 0; i--)
					markers[i] = (ChartDataSeries.newMarker(i, fillColor, outlineColor));
			}
		
		@Override
		public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus)
			{
				JLabel label = (JLabel) super.getListCellRendererComponent(list, value.toString(), index, isSelected, cellHasFocus);
				preferredSize.width = (index == -1) ? prefCollapsedWidth : prefExpandedWidth;
				label.setPreferredSize(preferredSize);
				label.setMaximumSize(preferredSize);
				Icon icon = (Icon) value;
				label.setIcon(icon);
				return label;
			}
		
		public final Color getFillColor()
			{
				return fillColor;
			}
		
		public final void setFillColor(Color fillColor)
			{
				this.fillColor = fillColor;
				for (Marker m : markers)
					m.fillColor = fillColor;
			}
		
		public final Color getOutlineColor()
			{
				return outlineColor;
			}
		
		public final void setOutlineColor(Color outlineColor)
			{
				this.outlineColor = outlineColor;
				for (Marker m : markers)
					m.outlineColor = outlineColor;
			}
		
		public final void updateColors(Color fillColor, Color outlineColor)
			{
				this.outlineColor = outlineColor;
				this.fillColor = fillColor;
				for (Marker m : markers)
					{
						m.fillColor = fillColor;
						m.outlineColor = outlineColor;
					}
			}
		
		public final Marker[] getMarkers()
			{
				return markers;
			}
		
		public static void main(String[] args)
			{
				JFrame frame = new JFrame("Icon List");
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				
				MarkersListRenderer renderer = new MarkersListRenderer(Color.white, Color.darkGray);
				JComboBox<Marker> combo = new JComboBox<Marker>(renderer.markers);
				renderer.setFillColor(Color.orange);
				combo.setRenderer(renderer);
				frame.add(combo);
				frame.pack();
				frame.setVisible(true);
			}
		
	}
