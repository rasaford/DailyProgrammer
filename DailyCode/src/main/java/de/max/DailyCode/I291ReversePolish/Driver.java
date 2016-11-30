package de.max.DailyCode.I291ReversePolish;

public class Driver {
	public static void main(String[] args)
	{
		String a = "0.5 1 2 ! * 2 1 ^ + 10 + *";
		String b = "1 2 3 4 ! + - / 100 *";
		String c = "100 807 3 331 * + 2 2 1 + 2 + * 5 ^ * 23 10 558 * 10 * + + *";
		String d = "1 2 3 4 + + *";
		
		Calculator calc = new Calculator();
		calc.calculate(a);
		calc.calculate(b);
		calc.calculate(c);
		calc.calculate(d);
	}
	
	
}
