package de.max.DailyCode.I291ReversePolish;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Calculator {
	public double calculate(String in)
	{
		ArrayList<String> op = new ArrayList<>(Arrays.asList(in.split("[ ]")));
		Stack<String> stack = new Stack<>();
		
		for (String i : op)
		{
			stack.add(i);
			switch (i)
			{
			case "!":
			{
				stack.pop();
				double a = factorial(Double.parseDouble(stack.pop()));
				stack.add(a + "");
				break;
			}
			case "+":
			{
				stack.pop();
				double a = Double.parseDouble(stack.pop());
				double b = Double.parseDouble(stack.pop());
				stack.add((a + b) + "");
				break;
			}
			case "-":
			{
				stack.pop();
				double a = Double.parseDouble(stack.pop());
				double b = Double.parseDouble(stack.pop());
				stack.add((b - a) + "");
				break;

			}
			case "*":
			{
				stack.pop();
				double a = Double.parseDouble(stack.pop());
				double b = Double.parseDouble(stack.pop());
				stack.add((a * b) + "");
				break;

			}
			case "X":
			{
				stack.pop();
				double a = Double.parseDouble(stack.pop());
				double b = Double.parseDouble(stack.pop());
				stack.add((a * b) + "");
				break;

			}
			case "/":
			{
				stack.pop();
				double a = Double.parseDouble(stack.pop());
				double b = Double.parseDouble(stack.pop());
				stack.add((b / a) + "");
				break;

			}
			case "//":
			{
				stack.pop();
				double a = Double.parseDouble(stack.pop());
				double b = Double.parseDouble(stack.pop());
				stack.add(((int) b / (int) a) + "");
				break;

			}

			case "^":
			{
				stack.pop();
				double a = Double.parseDouble(stack.pop());
				double b = Double.parseDouble(stack.pop());
				stack.add(Math.pow(b, a) + "");
				break;

			}
			}
		}
		if (stack.size() != 1)
		{
			
			System.err.print("Invalid input seqence");
			return -1;
		} else
		{
			System.out.print(op.toString() + " = ");
			System.out.println(stack);
			return Double.parseDouble(stack.pop());
			
		}
	}

	private double factorial(double a)
	{
		for (int i = (int) a - 1; i >= 1; i--)
		{
			a *= i;
		}
		return a;
	}

}
