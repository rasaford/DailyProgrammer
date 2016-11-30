package de.max.DailyCode.E293Bomb;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Exploder9000 {
	public static void main(String[] args)
	{
		String[] in1 = { "w", "r", "g", "w" };
		String[] in2 = { "w", "o", "g", "w" };
		String[] in3 = { "w", "r", "g", "o"};

		Bomb boom = new Bomb();

		Queue<String> moves = new LinkedList<>();
		moves.addAll(Arrays.asList(in3));

		if (boom.explode(moves))
		{
			System.out.println("BOOM");
		} else
		{
			System.out.println("Bomb Defused");
		}

	}
}
