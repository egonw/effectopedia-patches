package org.qsari.effectopedia.core.ui;

import java.util.ArrayList;

public class RedirectionObject
	{
		public static int									ALL				= -1;
		public static int									ITSELF	= -2;

		public RedirectionObject(Object baseObject)
			{
				super();
				base = baseObject;
				parameters = new ArrayList<Object>();
			}
		
		public Object getObject(String parameter)
			{
				if (parameter == null)
					return base;
				int index = Integer.parseInt(parameter);
				if (index == ITSELF)
					return this;
				else if (index == ALL)
					return parameters;
				else
					return getParameterObject(index);
			}
		
		public int addParameterObject(Object parameter)
			{
				parameters.add(parameter);
				return parameters.size()-1;
			}
		
		public void clearParameterObjects()
			{
				parameters.clear();
			}
		
		public int countParameterObjects()
			{
				return parameters.size();
			}
		
		public Object getParameterObject(int index)
			{
				if ((index >= 0) && (index < parameters.size()))
					return parameters.get(index);
				else
					return null;
			}
		
		public ArrayList<Object> getParameters()
			{
				return parameters;
			}
		
		public Object getBase()
			{
				return base;
			}
		
		public void setBase(Object base)
			{
				this.base = base;
			}
		
		public String getHTML()
			{
				return html;
			}
		
		public void setHTML(String html)
			{
				this.html = html;
			}
		
		private String												html;
		private ArrayList<Object>	parameters;
		private Object												base;
	}
