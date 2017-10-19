package org.qsari.effectopedia.core;

import java.util.Properties;

import org.apache.felix.dm.Component;
import org.apache.felix.dm.DependencyActivatorBase;
import org.apache.felix.dm.DependencyManager;
import org.apache.felix.service.command.CommandProcessor;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceListener;
import org.qsari.effectopedia.core.ui.IDataView;
import org.qsari.effectopedia.data.formats.DataSourceFormat;

public class Activator extends DependencyActivatorBase implements ServiceListener
	{
		@Override
		public void init(BundleContext context, DependencyManager manager) throws Exception
			{
				Properties properties = new Properties();
				 properties.put(CommandProcessor.COMMAND_SCOPE,"eff");
				 properties.put(CommandProcessor.COMMAND_FUNCTION,new String[]
				 {"DEBUG_info"});
				
				Component e = createComponent();
				e.setInterface(DataSourceFormat.class.getName(), properties);
				manager.add(e);
				
				Component ds = createComponent();
				ds.setInterface(IDataView.class.getName(), properties);
				manager.add(ds);
			}
		
		@Override
		public void destroy(BundleContext context, DependencyManager manager) throws Exception
			{
				super.destroy(context, manager);
			}
		
		public void start(BundleContext context)
			{
				System.out.println("Effectopedia Kernel Version "+Effectopedia.VERSION);
				context.addServiceListener(this);
			}
		
		public void stop(BundleContext context)
			{
				context.removeServiceListener(this);
				System.out.println("Effectopedia Kernel desactivated");
			}
		
		public void serviceChanged(ServiceEvent event)
			{
				String[] objectClass = (String[]) event.getServiceReference().getProperty("objectClass");
				
				if (event.getType() == ServiceEvent.REGISTERED)
					{
						System.out.println("Ex1: Service of type " + objectClass[0] + " registered.");
					}
				else if (event.getType() == ServiceEvent.UNREGISTERING)
					{
						System.out.println("Ex1: Service of type " + objectClass[0] + " unregistered.");
					}
				else if (event.getType() == ServiceEvent.MODIFIED)
					{
						System.out.println("Ex1: Service of type " + objectClass[0] + " modified.");
					}
			}
	}
