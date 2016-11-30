package de.max.DailyCode.E293Bomb;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;

public class Bomb {
	
	List<String> doNotCut = new ArrayList<>();
	List<String> doCut = new ArrayList<>();;
	
	public boolean explode(Queue<String> seq)
	{
		Iterator<String> it = seq.iterator();
		while (it.hasNext())
		{
			String current = it.next();
			switch (current)
			{
			case "w":
				if (allowToCut(current))
				{
					doNotCut.add("w"); doNotCut.add("b");  
				} else
				{
					return true;
				}
				break;
			case "r":
				if (allowToCut(current))
				{
					doCut.add("g");  
				} else
				{
					return true;
				}
				break ;
			case "b":
				if (allowToCut(current))
				{
					doNotCut.add("w"); doNotCut.add("g"); doNotCut.add("o"); 
				} else
				{
					return true;
				}
				break ;
			case "o":
				if (allowToCut(current))
				{
					//doCut.add("r b"); 
				} else
				{
					return true;
				}
				break ;
			case "g":
				if (allowToCut(current))
				{
					doCut.add("o w"); 
				} else
				{
					return true;
				}
				break ;
			case "p":
				if (allowToCut(current))
				{
					doNotCut.add("p"); doNotCut.add("g"); doNotCut.add("o"); doNotCut.add("w"); 
				} else
				{
					return true;
				}
				break ;
			}
		System.out.println(11);
		}
		if (!doCut.isEmpty())
		{
			return true;
		}
		return false;
	}
	
	private boolean allowToCut(String wire)
	{
		if (doNotCut.contains(wire))
		{
			return false;
		} else
		{
			for(String a : doCut)
			{
				if (a.contains(wire))
				{
					doNotCut.remove(a);
				}
			}
		}
		return true;
	}
}
