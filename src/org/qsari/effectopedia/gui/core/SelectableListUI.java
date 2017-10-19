package org.qsari.effectopedia.gui.core;

import org.qsari.effectopedia.base.EffectopediaObject;

public interface SelectableListUI<E extends EffectopediaObject> extends LoadableEditorUI
	{
		public E[] getSelected();
	}
