package org.qsari.effectopedia.gui.inspector;

import org.qsari.effectopedia.base.io.BaseIO;
import org.qsari.effectopedia.base.io.BaseIOElement;

public class XMLElementAdapterNode
	{
		/**
		 * Creates a new instance of the XMLElementAdapterNode class
		 * 
		 * @param Element
		 *         element
		 */
		public XMLElementAdapterNode(BaseIOElement element, BaseIO io)
			{
				this.element = element;
				this.io = io;
			}
		
		/**
		 * Finds index of child in this noode.
		 * 
		 * @param child
		 *         The child to look for
		 * @return index of child, -1 if not present (error)
		 */
		public int index(XMLElementAdapterNode child)
			{
				
				int count = childCount();
				for (int i = 0; i < count; i++)
					{
						XMLElementAdapterNode n = this.child(i);
						if (child.element == n.element)
							{
								return i;
							}
					}
				return -1; // Should never get here.
			}
		
		/**
		 * Returns an adapter node given a valid index found through the method:
		 * public int index(XMLElementAdapterNode child)
		 * 
		 * @param searchIndex
		 *         find this by calling index(XMLElementAdapterNode)
		 * @return the desired child
		 */
		public XMLElementAdapterNode child(int searchIndex)
			{
				BaseIOElement child = (BaseIOElement) element.getChildren().get(searchIndex);
				return new XMLElementAdapterNode(child, io);
			}
		
		/**
		 * Return the number of children for this element/node
		 * 
		 * @return int number of children
		 */
		public int childCount()
			{
				return element.getChildren().size();
			}
		
		public String toString()
			{
				return element.getName();
			}
		
		/** the JDOM Element encapsulated by this node */
		public BaseIOElement	element;
		public BaseIO								io;
	}
