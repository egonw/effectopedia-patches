package org.qsari.effectopedia.utils;

import java.util.AbstractMap;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/**
 * @author Hristo Aladjov
 **/

public class TrieMap<K, V> extends AbstractMap<K[], Collection<V>> implements Iterable<V>
	{
		private final Node<V>	root;
		
		public TrieMap()
			{
				root = new Node<V>();
			}
		
		public Collection<V> put(K[] keys, Collection<V> values)
			{
				Node<V> node = root;
				Node<V> lastExistingNode = root;
				int i = 0;
				while (i < keys.length)
					{
						lastExistingNode = node;
						node = node.getChildNode(keys[i]);
						if (node == null)
							break;
						i++;
					}
				if (i < keys.length)
					{
						node = lastExistingNode;
						while (i < keys.length)
							{
								node = node.addNode(keys[i++]);
							}
					}
				node.setValues(values);
				return node.getValues();
			}
		
		public Collection<V> remove(K[] keys)
			{
				Node<V> node = getNode(keys);
				if (node != null)
					{
						Collection<V> oldValues = node.getValues();
						node.setValues(null);
						return oldValues;
					}
				return null;
			}
		
		public void put(K[] keys, V value)
			{
				Node<V> node = root;
				Node<V> lastExistingNode = root;
				int i = 0;
				while (i < keys.length)
					{
						lastExistingNode = node;
						node = node.getChildNode(keys[i]);
						if (node == null)
							break;
						i++;
					}
				if (i < keys.length)
					{
						node = lastExistingNode;
						while (i < keys.length)
							node = node.addNode(keys[i++]);
					}
				node.getValues().add(value);
			}
		
		public boolean remove(K[] keys, V value)
			{
				Node<V> node = getNode(keys);
				if (node != null)
					return node.getValues().remove(value);
				return false;
			}
		
		public Node<V> getNode(K[] keys)
			{
				Node<V> node = root;
				int i = 0;
				while (i < keys.length && node != null)
					{
						node = node.getChildNode(keys[i]);
						i++;
					}
				return node;
			}
		
		public Collection<V> get(K[] keys)
			{
				Node<V> node = root;
				int i = 0;
				while (i < keys.length && node != null)
					{
						node = node.getChildNode(keys[i]);
						i++;
					}
				if (node != null)
					{
						return node.getValues();
					}
				return null;
			}
		
		public Iterator<V> iterator()
			{
				return new TrieIterator(root);
			}
		
		private class TrieCollectionIterator implements Iterator<Collection<V>>
			{
				Stack<Node<V>>	trieStack		= new Stack<Node<V>>();
				Node<V>								curentNode	= null;
				
				TrieCollectionIterator(Node<V> startNode)
					{
						trieStack.push(startNode);
					}
				
				private void walkToNextFullNode()
					{
						curentNode = null;
						Collection<V> values = null;
						while (!trieStack.empty())
							{
								Node<V> node = trieStack.pop();
								values = node.getValues();
								if (values != null)
									curentNode = node;
							}
					}
				
				public boolean hasNext()
					{
						walkToNextFullNode();
						return (curentNode != null);
					}
				
				public Collection<V> next()
					{
						return curentNode.getValues();
					}
				
				public void remove()
					{
						curentNode.values = null;
					}
				
			}
		
		private class TrieIterator implements Iterator<V>
			{
				Iterator<V>												currentNodeIterator	= null;
				TrieCollectionIterator	iterator;
				
				TrieIterator(Node<V> startNode)
					{
						iterator = new TrieCollectionIterator(startNode);
					}
				
				public boolean hasNext()
					{
						if ((currentNodeIterator == null) && (iterator.hasNext()))
							currentNodeIterator = iterator.next().iterator();
						return (currentNodeIterator != null) && (currentNodeIterator.hasNext());
					}
				
				public V next()
					{
						return currentNodeIterator.next();
					}
				
				public void remove()
					{
						if (currentNodeIterator != null)
							currentNodeIterator.remove();
					}
				
			}
		
		private class Node<N>
			{
				Collection<N>			values;
				Map<K, Node<N>>	children;
				
				public Node<N> addNode(K key)
					{
						if (children == null)
							{
								children = new HashMap<K, Node<N>>();
							}
						Node<N> emptyNode = new Node<N>();
						children.put(key, emptyNode);
						return emptyNode;
					}
				
				Node<N> getChildNode(K key)
					{
						if (children == null)
							return null;
						return children.get(key);
					}
				
				Collection<N> getValues()
					{
						return values;
					}
				
				public void setValues(Collection<N> values)
					{
						this.values = values;
					}
			}
		
		@Override
		public Set<java.util.Map.Entry<K[], Collection<V>>> entrySet()
			{
				TrieCollectionIterator it = new TrieCollectionIterator(root);
				while (it.hasNext())
					{
						
					}
				return null;
			}
		
		@Override
		public Collection<Collection<V>> values()
			{
				TrieCollectionIterator it = new TrieCollectionIterator(root);
				while (it.hasNext())
					{
						
					}
				
				return super.values();
			}
	}
