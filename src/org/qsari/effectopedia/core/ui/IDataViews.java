package org.qsari.effectopedia.core.ui;

import org.qsari.effectopedia.base.io.Exportable;
import org.qsari.effectopedia.base.io.Importable;

public interface IDataViews extends Importable, Exportable
	{
		public void setDefaultViewAxis();
		
		public IDataView get(Object key);
		
		public IDataView put(String key,IDataView value);

		public void putAll(IDataViews views);
	}
