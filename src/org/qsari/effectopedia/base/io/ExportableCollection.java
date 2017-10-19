package org.qsari.effectopedia.base.io;

import java.util.LinkedHashMap;

import org.qsari.effectopedia.base.EffectopediaObject;

public interface ExportableCollection extends Exportable
	{
		public BaseIOElement store(LinkedHashMap<Long, EffectopediaObject> excludeIDs, BaseIOElement element,BaseIO io);
	}
