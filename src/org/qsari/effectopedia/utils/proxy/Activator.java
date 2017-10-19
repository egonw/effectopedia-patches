package org.qsari.effectopedia.utils.proxy;

import org.apache.felix.dm.Component;
import org.apache.felix.dm.DependencyActivatorBase;
import org.apache.felix.dm.DependencyManager;
import org.osgi.framework.BundleContext;
import org.qsari.effectopedia.utils.IProxyDetector;

public class Activator extends DependencyActivatorBase
	{
		@Override
		public void init(BundleContext context, DependencyManager manager)
				throws Exception
			{
				Component componentDataView = createComponent();
				componentDataView.setInterface(IProxyDetector.class.getName(), null);
				componentDataView.setImplementation(ProxyDetector.class);
				manager.add(componentDataView);
			}
		
		@Override
		public void destroy(BundleContext context, DependencyManager manager)
				throws Exception
			{
				// TODO Auto-generated method stub
				super.destroy(context, manager);
			}
		
	}

