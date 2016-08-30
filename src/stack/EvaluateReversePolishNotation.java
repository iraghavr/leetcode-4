package stack;

import java.util.Stack;

/*
Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Some examples:
  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 * */
//TO_TEST
public class EvaluateReversePolishNotation 
{
    public int evalRPN( String[] tokens ) 
    {
    	Stack<Integer> operandStack = new Stack<>();
    	for ( String token : tokens )
    	{
    		if ( token.equals( "+" )
    				|| token.equals( "-" )
    				|| token.equals( "*" ) 
    				|| token.equals( "/" ) )
    		{
    			int operand2 = operandStack.pop( );
    			int operand1 = operandStack.pop( );
    			if ( token.equals( "+" ) )
    			{
    				operandStack.push( operand1 + operand2 );
    			}
    			else if ( token.equals( "-" ) )
    			{
    				operandStack.push( operand1 - operand2 );
    			}
    			else if ( token.equals( "*" ) )
    			{
    				operandStack.push( operand1 * operand2 );
    			}
    			else
    			{
    				operandStack.push( operand1 / operand2 );
    			}
    		}
    		else
    		{
    			operandStack.push( Integer.valueOf( token ) );
    		}
    	}
    	
    	return operandStack.pop( );
    }
}