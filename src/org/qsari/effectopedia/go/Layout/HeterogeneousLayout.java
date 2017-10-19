package org.qsari.effectopedia.go.Layout;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.qsari.effectopedia.go.GraphicObject;
import org.qsari.effectopedia.go.StandardGOSize;

public class HeterogeneousLayout extends BasicLayout
	{
		public HeterogeneousLayout()
			{
				super();
			}
		
		public void fixGraphicObject(Class<? extends GraphicObject> c, StandardGOSize fixedGOSize)
			{
				Method method;
				try
					{
						if (c != null)
							{
								method = c.getMethod("setStandardSize", StandardGOSize.class);
								method.invoke(null, fixedGOSize);
							}
					}
				catch (SecurityException e)
					{
						e.printStackTrace();
					}
				catch (NoSuchMethodException e)
					{
						e.printStackTrace();
					}
				catch (IllegalArgumentException e)
					{
						e.printStackTrace();
					}
				catch (IllegalAccessException e)
					{
						e.printStackTrace();
					}
				catch (InvocationTargetException e)
					{
						e.printStackTrace();
					}
			}
	
		@Override	
		public void update()
			{
				globalLOC.updateProperties();
				super.update();
			}

	}
