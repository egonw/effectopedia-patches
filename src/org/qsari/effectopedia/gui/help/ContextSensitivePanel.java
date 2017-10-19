package org.qsari.effectopedia.gui.help;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class ContextSensitivePanel extends JPanel implements MouseMotionListener, ContextSensitiveUI
	{
		
		/**
		* 
		*/
		private static final long serialVersionUID = 1L;
		
		public static void main(String[] args)
			{
				JFrame frame = new JFrame();
				frame.getContentPane().add(new ContextSensitivePanel(null));
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				frame.pack();
				frame.setVisible(true);
			}
			
		public ContextSensitivePanel(RootHelpContext rootHelpContext)
			{
				super();
				if (this instanceof RootHelpContext)
					{
						this.rootHelpContext = (RootHelpContext) this;
						addMouseMotionListener(this);
					}
				else
					{
						this.rootHelpContext = rootHelpContext;
						if (rootHelpContext != null)
							addMouseMotionListener(rootHelpContext.getRootMotionListener());
					}
			}
			
		@Override
		public void mouseDragged(MouseEvent e)
			{
				
			}
			
		@Override
		public void mouseMoved(MouseEvent e)
			{
				try
					{
						// System.out.println("context sensitive helpID:" +
						// getComponetHelpContext(e));
						ContextSensitiveHelpUI.setCurrentID(getComponetHelpContext(e));
					}
				catch (Exception e2)
					{
						System.err.println("context sensitive helpID:" + getComponetHelpContext(e));
					}
			}
			
		public String getComponetHelpContext(MouseEvent e)
			{
				StringBuilder componentName = new StringBuilder();
				Component component = this;
				Component subComponent = (Component) e.getSource();
				if ((subComponent != component) && (subComponent instanceof ContextSensitiveUI))
					return ((ContextSensitiveUI) subComponent).getComponetHelpContext(e);
				while ((subComponent != null) && (subComponent != component))
					{
						String name = subComponent.getName();
						if (name != null)
							{
								componentName.insert(0, name);
								componentName.insert(0, ".");
							}
						subComponent = subComponent.getParent();
					}
				componentName.insert(0, getHelpID());
				return componentName.toString();
			}
			
		public String getHelpID()
			{
				if (helpID == null)
					initHelpID();
				return helpID;
			}
			
		protected void initHelpID()
			{
				StringBuilder componentName = new StringBuilder();
				Component component = this;
				componentName.append(component.getName());
				while (!(component instanceof RootHelpContext))
					{
						component = component.getParent();
						if (component == null)
							{
								helpID = componentName.toString();
								return;
							}
						String name = component.getName();
						if (name != null)
							{
								componentName.insert(0, ".");
								componentName.insert(0, component.getName());
							}
					}
				helpID = componentName.toString();
			}
			
		public RootHelpContext getRootHelpContext()
			{
				return rootHelpContext;
			}
			
		public ContextSensitivePanel getRootMotionListener()
			{
				return this;
			}
			
		public void setRootHelpContext(RootHelpContext rootHelpContext)
			{
				if (this.rootHelpContext != null)
					removeMouseMotionListener(this.rootHelpContext.getRootMotionListener());
				this.rootHelpContext = rootHelpContext;
				if (rootHelpContext == null)
					return;
				addMouseMotionListener(rootHelpContext.getRootMotionListener());
			}
			
		protected String										helpID	= null;
		protected RootHelpContext	rootHelpContext;
		
	}
