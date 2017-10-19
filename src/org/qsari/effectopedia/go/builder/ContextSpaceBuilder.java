package org.qsari.effectopedia.go.builder;

import java.util.ArrayList;
import java.util.Arrays;

import org.qsari.effectopedia.core.objects.ContextDimension;
import org.qsari.effectopedia.core.objects.Initiator_BiologcalPerturbation;
import org.qsari.effectopedia.core.objects.Initiator_ChemicalStructure;
import org.qsari.effectopedia.core.objects.Initiator_StructuralAlerts;
import org.qsari.effectopedia.core.objects.Link_ChemStructToChemStruct;
import org.qsari.effectopedia.core.objects.Link_ChemStructToMIE;
import org.qsari.effectopedia.core.objects.Link_EffectToEffect;
import org.qsari.effectopedia.data.objects.FixedValuesList;
import org.qsari.effectopedia.data.objects.FixedValuesLists;
import org.qsari.effectopedia.data.objects.ValuesList;
import org.qsari.effectopedia.defaults.DefaultGOSettings;
import org.qsari.effectopedia.go.GraphicObject;
import org.qsari.effectopedia.go.Layout.LayoutObject;
import org.qsari.effectopedia.go.Layout.LayoutObjectsContainer;
import org.qsari.effectopedia.go.containers.GraphicObjectsContainer;
import org.qsari.effectopedia.go.gui.ColumnFooterGO;
import org.qsari.effectopedia.go.gui.ColumnFootersGOC;
import org.qsari.effectopedia.go.gui.ColumnHeaderGO;
import org.qsari.effectopedia.go.gui.ColumnHeadersGOC;
import org.qsari.effectopedia.go.gui.RowHeaderGO;
import org.qsari.effectopedia.go.gui.RowHeadersGOC;
import org.qsari.effectopedia.go.pathway_elements.EffectEGOC;
import org.qsari.effectopedia.go.pathway_elements.LinkEGOC;
import org.qsari.effectopedia.go.pathway_elements.SubstanceEGOC;
import org.qsari.effectopedia.gui.core.DataView;

public class ContextSpaceBuilder
	{
		public static final String	NO_CAPTION	= "-";
		
		public ContextSpaceBuilder(DataView view)
			{
				super();
				this.horizontal = view.getHorizontalDimension();
				this.vertical = view.getVerticalDimension();
				this.view = view;
				initilizeDefaultDimensions();
			}
		
		public void buildSpace()
			{
				initilizeDefaultDimensions();
				defineView();
 			defineAxes();
			}
		
		public ArrayList<Integer> getDefaultWidths()
			{
				return defaultWidths;
			}
		
		public void setDefaultWidths(ArrayList<Integer> defaultWidths)
			{
				this.defaultWidths = defaultWidths;
			}
		
		public ArrayList<Integer> getDefaultHeights()
			{
				return defaultHeights;
			}
		
		public void setDefaultHeights(ArrayList<Integer> defaultHeights)
			{
				this.defaultHeights = defaultHeights;
			}
		
		public int getColumnCount()
			{
				return columnCount;
			}
		
		public int getRowCoutnt()
			{
				return rowCount;
			}
		
		private void initilizeDefaultDimensions()
			{
		  //TODO temporary implementation. Does not handle ContextDimension_Hierarchical if selected is not set
				columnCount = (int) horizontal.getCardinality();
				columnCount = columnCount < 0 ? 1 : (2 * columnCount - 1);
				defaultWidths = new ArrayList<Integer>(Arrays.asList(new Integer[columnCount]));
				rowCount = (int) vertical.getCardinality();
				rowCount = rowCount < 0 ? 1 : (2 * rowCount - 1);
				defaultHeights = new ArrayList<Integer>(Arrays.asList(new Integer[rowCount]));
				if (columnCount > 1)
					defaultWidths.set(0, SubstanceEGOC.defaultSubstanceEGOCUnscalledSize.getTotlaWidth());
				else
					defaultHeights.set(0, view.getViewWidth());
				for (int i = 1; i < columnCount; i++)
					if (i % 2 == 0)
						defaultWidths.set(i, EffectEGOC.defaultEffectEGOCUnscalledSize.getTotlaWidth());
					else
						defaultWidths.set(i, LinkEGOC.defaultLinkEGOCUnscalledSize.getTotlaWidth());
				if (rowCount > 1)
					defaultHeights.set(0, SubstanceEGOC.defaultSubstanceEGOCUnscalledSize.getTotlaHeight());
				else
					defaultHeights.set(0, view.getViewHeight());
				for (int i = 1; i < rowCount; i++)
					if (i % 2 == 0)
						defaultHeights.set(i, EffectEGOC.defaultEffectEGOCUnscalledSize.getTotlaHeight());
					else
						defaultHeights.set(i, LinkEGOC.defaultLinkEGOCUnscalledSize.getTotlaHeight());
			}
		
		private void defineView()
			{
				GraphicObjectsContainer goc = view.getPathwaysView().getViewLayout().getGlobalGOC();
				LayoutObjectsContainer loc = view.getPathwaysView().getViewLayout().getGlobalLOC();
				goc.clear();
				loc.clear();
				loc.init(columnCount, rowCount);
				for (int i = 0; i < rowCount; i++)
					{
						GraphicObjectsContainer goConainer;
						LayoutObjectsContainer loConainer = new LayoutObjectsContainer(loc);
						if (i % 2 == 0)
							goConainer = new SubstanceEGOC(goc);
						else
							{
							goConainer = new LinkEGOC(goc);
						 loConainer.makeItAccept(Link_ChemStructToChemStruct.class);
						 loConainer.makeItAccept(Link_EffectToEffect.class);
						 loConainer.makeItAccept(Link_ChemStructToMIE.class);
							}
						loConainer.setGo(goConainer);
						goc.add(goConainer);
						loc.setComponent(0, i, loConainer);
						for (int j = 1; j < columnCount; j++)
							{
								loConainer = new LayoutObjectsContainer(loc);
								if ((j % 2 == 0) && (i % 2 == 0))
									{
 									goConainer = new EffectEGOC(goc);
	 							 loConainer.makeItReject(Initiator_ChemicalStructure.class);
			 					 loConainer.makeItReject(Initiator_StructuralAlerts.class);
			 					 loConainer.makeItReject(Initiator_BiologcalPerturbation.class);
									}
								else
									{
									 goConainer = new LinkEGOC(goc);
									 loConainer.makeItAccept(Link_ChemStructToChemStruct.class);
									 loConainer.makeItAccept(Link_EffectToEffect.class);
									 loConainer.makeItAccept(Link_ChemStructToMIE.class);
									} 
								loConainer.setGo(goConainer);
								goc.add(goConainer);
								loc.setComponent(j, i, loConainer);
							}
					}
				loc.setMaxWidths(defaultWidths);
				loc.setMaxHeights(defaultHeights);
				loc.update();
			}
		
		private ArrayList<String> extractCaptions(ValuesList list)
			{
				ArrayList<String> captions = new ArrayList<String>();
				ArrayList<String> theList;
				if (list instanceof FixedValuesList)
					theList = ((FixedValuesList) list).getList();
				else if (list instanceof FixedValuesLists)
					theList = ((FixedValuesLists) list).getList("").getList();//TODO temporary implementation 
				else
					return null;
				for (int i = 0; i < theList.size() - 1; i++)
					{
						captions.add(theList.get(i));
						captions.add(NO_CAPTION);
					}
				captions.add(theList.get(theList.size() - 1));
				return captions;
			}
		
		private void defineAxes()
			{
				LayoutObjectsContainer columnFooters = view.getPathwaysView().getColumnFooters();
				LayoutObjectsContainer rowHeaders = view.getPathwaysView().getRowHeaders();
				

				columnFooters.clear();
				columnFooters.init(columnCount, 1);
				columnFooters.setMaxHeights(DefaultGOSettings.footerHeight);
				rowHeaders.clear();
				rowHeaders.init(1, rowCount);
				rowHeaders.setMaxWidths(DefaultGOSettings.rowHeaderWidth);
				
				ColumnFootersGOC cfGOC = new ColumnFootersGOC();
				columnFooters.setGo(cfGOC);
				RowHeadersGOC rhGOC = new RowHeadersGOC();
				rowHeaders.setGo(rhGOC);
				
				for (int i = 0; i < rowCount; i++)
					{
						LayoutObject lo = new LayoutObject(rowHeaders);
						GraphicObject go = new RowHeaderGO(rhGOC);
						lo.setGo(go);
						rowHeaders.setComponent(i, lo);
					}
				
				for (int i = 0; i < columnCount; i++)
					{
						LayoutObject lo = new LayoutObject(columnFooters);
						GraphicObject go = new ColumnFooterGO(cfGOC);
						lo.setGo(go);
						columnFooters.setComponent(i, lo);
					}
				
				if (rowCount > 1)
					rhGOC.setCaptions(extractCaptions(this.vertical.getDefaultValues()));
				else
					rhGOC.setCaptions(this.vertical.getName());
				if (columnCount > 1)
					cfGOC.setCaptions(extractCaptions(this.horizontal.getDefaultValues()));
				
				view.getPathwaysView().getSynchronizer().synchronize();
			}
		
		protected ArrayList<Integer>		defaultWidths;
		protected ArrayList<Integer>		defaultHeights;
		protected int																	columnCount;
		protected int																	rowCount;
		private final ContextDimension	horizontal;
		private final ContextDimension	vertical;
		protected final DataView									view;
	}
