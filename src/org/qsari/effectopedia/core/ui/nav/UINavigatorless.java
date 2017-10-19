package org.qsari.effectopedia.core.ui.nav;

public class UINavigatorless implements UINavigator
	{
		public static final UINavigatorless	NAVIGATOR = new UINavigatorless();
		private UINavigatorless()
			{
				super();
			}
		
		@Override
		public Object navigate(UILocation location, Object o)
			{
				return null;
			}
		
		@Override
		public void navigate(UILocation location, Object o, UIInitializer[] initialization)
			{
			}
		
	}
