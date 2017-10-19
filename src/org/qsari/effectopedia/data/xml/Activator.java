package org.qsari.effectopedia.data.xml;

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
			Component componentDataView = createComponent();
			componentDataView.setInterface(DataSourceFormat.class.getName(), null);
			componentDataView.setImplementation(XMLFileFormat.class);
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
