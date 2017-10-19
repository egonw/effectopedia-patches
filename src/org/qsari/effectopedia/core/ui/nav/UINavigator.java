package org.qsari.effectopedia.core.ui.nav;

public interface UINavigator
	{
		public Object navigate(UILocation location, Object o);
		
		public void navigate(UILocation location, Object o, UIInitializer[] initialization);
	}
