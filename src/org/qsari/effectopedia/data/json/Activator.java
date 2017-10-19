package org.qsari.effectopedia.data.json;

import org.apache.felix.dm.Component;
import org.apache.felix.dm.DependencyActivatorBase;
import org.apache.felix.dm.DependencyManager;
import org.osgi.framework.BundleContext;
import org.qsari.effectopedia.data.formats.DataSourceFormat;

public class Activator extends DependencyActivatorBase
{
	@Override
	public void init(BundleContext context, DependencyManager manager)
			throws Exception
		{
			Component dsf = createComponent();
			dsf.setInterface(DataSourceFormat.class.getName(), null);
			dsf.setImplementation(JSONDataSourceFormat.class);
			manager.add(dsf);
		}
	
	@Override
	public void destroy(BundleContext context, DependencyManager manager)
			throws Exception
		{
			// TODO Auto-generated method stub
			super.destroy(context, manager);
		}
	
}
