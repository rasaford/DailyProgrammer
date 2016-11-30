package de.max.DailyCode.E292Range;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Seperator {
	public static void main(String[] args)
	{
		String[] in = {"1,3,7,2,4,1", "1-3,1-2", "1:5:2", "104-2", "104..02", "545,64:11"};
		String t = "1,3,7,2,4,1";
		System.out.println();
		for (String i : in)
		{
			System.out.println(valueOf(i));

		}
	}
	

	public static List<Integer> valueOf(String seq)
	{
		List<String> strs =  new ArrayList<>();
		List<Integer> parsed =  new ArrayList<>();	
		strs.addAll(Arrays.asList(seq.split("[,]")));
		int prev = 0;
		// detect range 
		for (String a : strs)
		{
			String[] range = a.split("(\\.\\.)|[.,:-]");
			if (range.length > 1)
			{
				// check for step
				int step = (range.length > 2) ? Integer.valueOf(range[2]) : 1;
				int start = Integer.parseInt(range[0]),
					end = fixNotation(range[0], range[1]);
				addList(parsed, prev ,start, end, step);
				prev = end;
			} else 
			{
				int end = Integer.parseInt(a);
				addList(parsed, prev ,end, end, 1);
				prev = end;
			}
			
		}
		return parsed;
	}
	// look for string length differences if there are any offset the first different char by +1 
	private static int fixNotation(String digit1, String digit2) 
	{
		String offsetNum = "";
		String first;
		
		if (Integer.parseInt(digit1) > Integer.parseInt(digit2)) 
		{
			int lenDiff = digit1.length() - digit2.length();
			if (lenDiff > 0) 
			{
				first = digit1.substring(0, lenDiff - 1) 
						 + (char)(digit1.charAt(lenDiff - 1) + 1);
			} else
			{
				first = "1";
			}
			offsetNum = first + digit2;
		} else 
		{
			return Integer.parseInt(digit2);
		}
		return Integer.parseInt(offsetNum);
	}
	
	private static void addList(List<Integer> l,int prev, int rangeStart, int rangeEnd, int step)
	{
	
		for (int i = rangeStart; i <= rangeEnd; i += step)
		{
			l.add(fixNotation(prev + "", i + ""));
		}
	}
}
