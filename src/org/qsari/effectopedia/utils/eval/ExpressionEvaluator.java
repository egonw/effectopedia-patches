package org.qsari.effectopedia.utils.eval;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.List;

import org.qsari.effectopedia.utils.IExpressionEvaluator;

import com.udojava.evalex.Expression;

public class ExpressionEvaluator implements IExpressionEvaluator
	{
		public void setExpression(String expression)
			{
				this.expression = new Expression(expression, mathContext);
				defineExtraFn();
			}
		
		public void setVariable(String variableName, String variableValue)
			{
				this.expression.setVariable(variableName, variableValue);
			}
		
		public void setVariable(String variableName, BigDecimal variableValue)
			{
				this.expression.setVariable(variableName, variableValue);
			}
		
		public void setVariable(String variableName, double variableValue)
			{
				this.expression.setVariable(variableName, BigDecimal.valueOf(variableValue));
			}
		
		public BigDecimal eval()
			{
				return this.expression.eval();
			}
		
		public void defineExtraFn()
			{
				expression.addFunction(expression.new Function("EXP", 1)
					{
						@Override
						public BigDecimal eval(List<BigDecimal> parameters)
							{
								double d = Math.exp(parameters.get(0).doubleValue());
								return new BigDecimal(d, mathContext);
							}
					});
				
			}
		@Override
		public boolean canEval()
			{
				return expression!=null;
			}
		
		protected MathContext	mathContext	= MathContext.DECIMAL64;
		protected Expression		expression		= null;
	}
