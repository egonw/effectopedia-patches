package org.qsari.effectopedia.defaults;

import java.util.HashMap;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.base.io.BaseIO;
import org.qsari.effectopedia.base.io.BaseIOAttribute;
import org.qsari.effectopedia.base.io.BaseIOElement;
import org.qsari.effectopedia.core.Effectopedia;
import org.qsari.effectopedia.data.DataSource;

public class DefaultObjectIOFactory
	{
		public static DefaultObjectIOFactory	FACTORY	= new DefaultObjectIOFactory();
		
		private DefaultObjectIOFactory()
			{
				supportedClasses = new HashMap<Class<?>, DefaultObjectIO>();
			}
		
		public static abstract class DefaultObjectIO
			{
				protected DefaultObjectIO(Class<?> objectClass)
					{
						super();
						FACTORY.supportedClasses.put(objectClass, this);
					}
				
				public abstract Object load(Object o, BaseIOAttribute attribute, BaseIO io);
				
				public abstract BaseIOAttribute store(Object o, BaseIOAttribute attribute, BaseIO io);
				
				public abstract Object load(Class<?> objectClass, Object o, BaseIOElement element, BaseIO io);
				
				public abstract BaseIOElement store(Object o, BaseIOElement element, BaseIO io);
				
				public abstract Object cloneObject(Class<?> objectClass, Object o);
				
				public abstract Object cloneObject(Class<?> objectClass, Object o, EffectopediaObject parent, DataSource dataSource);
				
			}
		
		public static class DefaultLongIO extends DefaultObjectIO
			{
				public DefaultLongIO()
					{
						super(Long.class);
					}
				
				public Object load(Object o, BaseIOAttribute attribute, BaseIO io)
					{
						return (attribute != null) ? Long.valueOf(attribute.getLongValue()) : null;
					}
				
				public BaseIOAttribute store(Object o, BaseIOAttribute attribute, BaseIO io)
					{
						if ((attribute != null) && (o != null) && (o instanceof Long))
							attribute.setValue((Long) o);
						return attribute;
					}
				
				public Object load(Class<?> objectClass, Object o, BaseIOElement element, BaseIO io)
					{
						return (element != null) ? Long.valueOf(element.getLongValue()) : null;
					}
				
				public BaseIOElement store(Object o, BaseIOElement element, BaseIO io)
					{
						if ((element != null) && (o != null) && (o instanceof Long))
							element.setValue(o.toString());
						return element;
					}
				
				public Object cloneObject(Class<?> objectClass, Object o)
					{
						return new Long((Long) o);
					}
				
				public Object cloneObject(Class<?> objectClass, Object o, EffectopediaObject parent, DataSource dataSource)
					{
						return new Long((Long) o);
					}
				
			}
		
		public static class DefaultDoubleIO extends DefaultObjectIO
			{
				public DefaultDoubleIO()
					{
						super(Double.class);
					}
				
				public Object load(Object o, BaseIOAttribute attribute, BaseIO io)
					{
						return (attribute != null) ? Double.valueOf(attribute.getDoubleValue()) : null;
					}
				
				public BaseIOAttribute store(Object o, BaseIOAttribute attribute, BaseIO io)
					{
						if ((attribute != null) && (o != null) && (o instanceof Long))
							attribute.setValue((Double) o);
						return attribute;
					}
				
				public Object load(Class<?> objectClass, Object o, BaseIOElement element, BaseIO io)
					{
						return (element != null) ? Double.valueOf(element.getDoubleValue()) : null;
					}
				
				public BaseIOElement store(Object o, BaseIOElement element, BaseIO io)
					{
						if ((element != null) && (o != null) && (o instanceof Double))
							element.setValue(o.toString());
						return element;
					}
				
				public Object cloneObject(Class<?> objectClass, Object o)
					{
						return new Double((Double) o);
					}
				
				public Object cloneObject(Class<?> objectClass, Object o, EffectopediaObject parent, DataSource dataSource)
					{
						return new Double((Double) o);
					}
				
			}
		
		public static class DefaultEffectopediaObjectIO extends DefaultObjectIO
			{
				protected DefaultEffectopediaObjectIO()
					{
						super(EffectopediaObject.class);
					}
				
				public Object load(Object o, BaseIOAttribute attribute, BaseIO io)
					{
						return (attribute != null) ? Long.valueOf(attribute.getLongValue()) : null;
					}
				
				public BaseIOAttribute store(Object o, BaseIOAttribute attribute, BaseIO io)
					{
						if ((attribute != null) && (o != null) && (o instanceof EffectopediaObject))
							{
								EffectopediaObject eo = (EffectopediaObject) o;
								attribute.setValue(Effectopedia.EFFECTOPEDIA.getData().autoExternalID(eo.getClass(), eo.getID()));
							}
						return attribute;
					}
				
				@Override
				public Object load(Class<?> objectClass, Object o, BaseIOElement element, BaseIO io)
					{
						return io.load(objectClass, (EffectopediaObject) o, element);
					}
				
				@Override
				public BaseIOElement store(Object o, BaseIOElement element, BaseIO io)
					{
						return ((EffectopediaObject) o).store(element, io);
					}
				
				@Override
				public Object cloneObject(Class<?> objectClass, Object o)
					{
						return ((EffectopediaObject) o).clone();
					}
				
				public Object cloneObject(Class<?> objectClass, Object o, EffectopediaObject parent, DataSource dataSource)
					{
						return ((EffectopediaObject) o).clone(parent, dataSource);
					}
				
			}
		
		public DefaultObjectIO getDefaultIO(Class<?> forClass)
			{
				if (EffectopediaObject.class.isAssignableFrom(forClass))
					return EFFECTOPEDIA_OBJECT_IO;
				else
					return supportedClasses.get(forClass);
			}
		
		private HashMap<Class<?>, DefaultObjectIO>	supportedClasses;
		public static DefaultLongIO																LONG_IO																= new DefaultLongIO();
		public static DefaultDoubleIO														DOUBLE_IO														= new DefaultDoubleIO();
		public static DefaultEffectopediaObjectIO		EFFECTOPEDIA_OBJECT_IO	= new DefaultEffectopediaObjectIO();
	}
