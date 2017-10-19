		
		public class GraphicObjectsChange extends EventObject
			{
				private static final long	serialVersionUID	= 1L;
				
				public GraphicObjectsChange(GraphicObjects source)
					{
						super(source);
					}
			}
		
		public interface GraphicObjectsChangeListener extends EventListener
			{
				public void graphicObjectsChangeOccurred(GraphicObjectsChange evt);
			}
		
		public void addGraphicObjectsChangeListener(GraphicObjectsChangeListener listener)
			{
				listenerList.add(GraphicObjectsChangeListener.class, listener);
			}
		
		public void removeGraphicObjectsChangeListener(GraphicObjectsChangeListener listener)
			{
				listenerList.remove(GraphicObjectsChangeListener.class, listener);
			}
		
		void fireGraphicObjectsChange(GraphicObjectsChange evt)
			{
				Object[] listeners = listenerList.getListenerList();
				for (int i = 0; i < listeners.length; i += 2)
					if (listeners[i] == GraphicObjectsChangeListener.class)
						((GraphicObjectsChangeListener) listeners[i + 1]).graphicObjectsChangeOccurred(evt);
			}


protected javax.swing.event.EventListenerList	listenerList	= new javax.swing.event.EventListenerList();