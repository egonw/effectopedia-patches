package org.qsari.effectopedia.utils;

import java.math.BigDecimal;

public interface IExpressionEvaluator
	{
		public void setExpression(String expression);
		
		public void setVariable(String variableName, String variableValue);
		
		public void setVariable(String variableName, BigDecimal variableValue);
		
		public void setVariable(String variableName, double variableValue);
		
		public BigDecimal eval();
		
		public boolean canEval();
		
	}
