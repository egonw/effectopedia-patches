package org.qsari.effectopedia.gui;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import org.qsari.effectopedia.core.Effectopedia;
import org.qsari.effectopedia.core.ui.NoDataView.DataViewChange;
import org.qsari.effectopedia.core.ui.NoDataView.DataViewChangeListener;
import org.qsari.effectopedia.data.DataSource;
import org.qsari.effectopedia.go.SVGExportable;
import org.qsari.effectopedia.gui.core.DataView;
import org.qsari.effectopedia.gui.help.ContextSensitivePanel;
import org.qsari.effectopedia.gui.help.RootHelpContext;
import org.qsari.effectopedia.gui.im.InterfaceMode;
import org.qsari.effectopedia.gui.im.InterfaceModes;
import org.qsari.effectopedia.gui.inspector.ObjectInspectorUI;

/**
 * This code was edited or generated using CloudGarden's Jigloo SWT/Swing GUI
 * Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose
 * whatever) then you should purchase a license for each developer using Jigloo.
 * Please visit www.cloudgarden.com for details. Use of Jigloo implies
 * acceptance of these licensing terms. A COMMERCIAL LICENSE HAS NOT BEEN
 * PURCHASED FOR THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED LEGALLY FOR
 * ANY CORPORATE OR COMMERCIAL PURPOSE.
 */
public class PathwaysViewUI extends ContextSensitivePanel implements AdjustableUI, DataViewChangeListener, SVGExportable
	{
		/**
		* 
		*/
		private static final long serialVersionUID = 1L;
		
		/**
		 * Auto-generated main method to display this JPanel inside a new JFrame.
		 */
		public static void main(String[] args)
			{
				JFrame frame = new JFrame();
				frame.getContentPane().add(new PathwaysViewUI(null, null, null));
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				frame.pack();
				frame.setVisible(true);
			}
			
		public PathwaysViewUI(ObjectInspectorUI objectInspector, ElementEditorUI elementEditor, RootHelpContext rootHelpContext)
			{
				super(rootHelpContext);
				this.objectInspector = objectInspector;
				this.elementEditor = elementEditor;
				DataSource data = Effectopedia.EFFECTOPEDIA.getData();
				if (data != null)
					{
						dataView = (DataView) data.getCurrentView();
						if (dataView != null)
							{
								dataView.setObjectInspector(objectInspector);
								dataView.setElementEditor(elementEditor);
								dataView.addDataViewChangeListener(this);
							}
					}
				modes = new InterfaceModes(this);
				initGUI();
			}
			
		public PathwaysViewUI(ObjectInspectorUI objectInspector, ElementEditorUI elementEditor, DataView dataView, RootHelpContext rootHelpContext)
			{
				super(rootHelpContext);
				this.dataView = dataView;
				if (dataView != null)
					{
						dataView.setObjectInspector(objectInspector);
						dataView.setElementEditor(elementEditor);
						dataView.addDataViewChangeListener(this);
					}
				this.objectInspector = objectInspector;
				modes = new InterfaceModes(this);
				initGUI();
			}
			
		private void initGUI()
			{
				try
					{
						if (dataView != null)
							setPreferredSize(new Dimension(dataView.getViewWidth(), dataView.getViewHeight()));
						setFocusable(true);
					}
				catch (Exception e)
					{
						e.printStackTrace();
					}
			}
			
		public void dataViewChanged(DataViewChange evt)
			{
				Dimension prefferedSize = new Dimension(dataView.getPathwaysView().getWidth(), dataView.getPathwaysView().getHeight());
				setPreferredSize(prefferedSize);
				if (synchronizedView != null)
					{
						synchronizedView.setPreferredSize(new Dimension(synchronizedView.dataView.getPathwaysView().getWidth(), synchronizedView.dataView.getPathwaysView().getHeight()));
						synchronizedView.repaint();
					}
				revalidate();
				repaint();
			}
			
		public void paintComponent(Graphics g)
			{
				super.paintComponent(g);
				Graphics2D canvas = (Graphics2D) g;
				if (dataView != null)
					dataView.getPathwaysView().draw(canvas);
			}
			
		public void exportToSVG(StringBuilder base, StringBuilder pathwayElementsGroup)
			{
				if (dataView != null)
					dataView.getPathwaysView().getViewLayout().exportToSVG(base, pathwayElementsGroup);
			}
			
		/**
		 * Adjust <code>visible</code> properties to the current and the contained
		 * components
		 * 
		 * @see AdjustableUI
		 * 
		 * @param visualOptions
		 *         an long that specifies which of the contained components are
		 *         visible
		 */
		public void adjustUI(long visualOptions)
			
			{
				AdjustbleUserInterfaceTools.adjustChildren(this, visualOptions);
			}
			
		public DataView getPathwaySpace()
			{
				return this.dataView;
			}
			
		public interface ScrollablePathwaySpace
			{
				public void scroll(int x, int y);
			}
			
		public void setScrollListener(ScrollablePathwaySpace space)
			{
				this.space = space;
			}
			
		public void scroll(int x, int y)
			{
				if (space != null)
					{
						space.scroll(x, y);
						if (synchronizedView != null)
							synchronizedView.space.scroll(x, y);
					}
			}
			
		public InterfaceModes getModes()
			{
				return this.modes;
			}
			
		public DataView getDataView()
			{
				return dataView;
			}
			
		public void setDataView(DataView dataView)
			{
				if (this.dataView != null)
					dataView.removeDataViewChangeListener(this);
				this.dataView = dataView;
				this.dataView.addDataViewChangeListener(this);
			}
			
		public PathwaysViewUI getSynchronizedView()
			{
				return synchronizedView;
			}
			
		public void setSynchronizedView(PathwaysViewUI synchronizedView)
			{
				this.synchronizedView = synchronizedView;
			}
			
		public void updateDataSource(DataSource dataSource)
			{
				modes.updateDataSource(dataSource);
			}
			
		public ElementEditorUI getElementEditor()
			{
				return elementEditor;
			}
			
		public ElementEditorUI getElementEditor(InterfaceMode mode)
			{
				if (elementEditor==null)
					return null;
				elementEditor.setInterfaceMode(mode);
				return elementEditor;
			}
			
		public void setElementEditor(ElementEditorUI elementEditor)
			{
				this.elementEditor = elementEditor;
			}
			
		public DataSource getDataSource()
			{
				return dataSource;
			}
			
		public void setDataSource(DataSource dataSource)
			{
				this.dataSource = dataSource;
				if (modes != null)
					modes.updateDataSource(dataSource);
			}
			
		public ViewUI getViewUI()
			{
				if (viewUI == null)
					{
						Container c = this.getParent();
						while (!(c instanceof ViewUI) && (c != null))
							c = c.getParent();
						viewUI = (ViewUI) c;
					}
				return viewUI;
			}

		public void rootRepaint()
			{
				((Component)rootHelpContext).repaint();
			}
			
		public int getRightmostVisibleLocation()
			{
				return getLocation().x + getParent().getWidth();
			}
			
		protected ObjectInspectorUI				objectInspector;
		protected ElementEditorUI						elementEditor;
		private InterfaceModes									modes;
		private DataSource													dataSource;
		private DataView															dataView;
		private ScrollablePathwaySpace	space;
		private PathwaysViewUI									synchronizedView;
		private ViewUI																	viewUI;

		
	}
