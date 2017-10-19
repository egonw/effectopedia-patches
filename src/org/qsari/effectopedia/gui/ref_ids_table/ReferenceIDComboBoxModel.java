package org.qsari.effectopedia.gui.ref_ids_table;

import java.util.Arrays;
import java.util.HashSet;

import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.base.ids.ReferenceID;
import org.qsari.effectopedia.gui.core.LoadableEditorUI;

public class ReferenceIDComboBoxModel<E extends EffectopediaObject> extends AbstractListModel<E> implements ComboBoxModel<E>, LoadableEditorUI
	{
		/**
	 * 
	 */
		private static final long	serialVersionUID	= 1L;
		
		public E getSelectedItem()
			{
				return selectedItem;
			}

		@Override
		public void setSelectedItem(Object object)
			{
				if (!readonly)
					{
						@SuppressWarnings("unchecked")
						E anItem = (E) object;
						if (selectedItem == null && anItem == null)
							return;
						if (selectedItem != null && selectedItem.equals(anItem))
							return;
						if (anItem != null && getIndexOf((E) anItem) == -1)
							return;
						selectedItem = (E)anItem;
						if (referenceID != null)
							referenceID.set((E)anItem);
						fireContentsChanged(this, -1, -1);
					}
			}

		public E[] getOptions()
			{
				return options;
			}
		
		public void setOptions(E[] options)
			{
				this.options = options;
				if ((options != null) && (options.length > 0))
					{
						fireIntervalAdded(this, 0, options.length - 1);
						setSelectedItem(options[0]);
					}
				else
					fireIntervalAdded(this, 0, 0);
			}

		public void intersectOptions(E[] options)
			{
				HashSet<E> intersection = new HashSet<E>(Arrays.asList(this.options));
				intersection.retainAll(Arrays.asList(options));
				this.options = intersection.toArray(this.options);
				if ((options != null) && (options.length > 0))
					{
						fireIntervalAdded(this, 0, options.length - 1);
						setSelectedItem(options[0]);
					}
				else
					fireIntervalAdded(this, 0, 0);
			}
		
		public int getIndexOf(E element)
			{
				return Arrays.asList(options).indexOf(element);
			}
		
		public void load(Object o, E[] options, boolean readonly)
			{
				this.options = options;
				if (options.length > 0)
					fireIntervalAdded(this, 0, options.length - 1);
				load(o, readonly);
			}
		
		@SuppressWarnings("unchecked")
		@Override
		public void load(Object o, boolean readonly)
			{
				if (o instanceof ReferenceID)
					referenceID = (ReferenceID<E>) o;
				else
					referenceID = null;
				if (referenceID != null)
					setSelectedItem(referenceID.getCachedObject());
			}
		
		public E getElementAt(int index)
			{
				return options[index];
			}
		
		public int getSize()
			{
				return options == null ? 0 : options.length;
			}
		
		protected E[]												options;
		protected E														selectedItem	= null;
		protected ReferenceID<E>	referenceID;
		protected boolean								readonly					= false;

	}
