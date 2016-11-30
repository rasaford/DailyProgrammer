package de.max.DailyCode.I290LEDs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class LEDs {

	private Map<String, byte[]> register = new HashMap<>();
	private Stack<Integer> label = new Stack<>();

	public void parse(String in)
	{
		List<String> cmd = new ArrayList<>(Arrays.asList(in.split("(\\s{2,})|\\n")));

		cmd.removeAll(Collections.singleton(""));
		for (int i = 0; i < cmd.size(); i++)
		{
			String[] command = cmd.get(i).split("(.\\(+)|(\\).)|(\\s+)|(,)");
			String arg = command[0];
			if (command.length > 1 && !register.containsKey(command[1]))
				register.put(command[1], new byte[8]);
			switch (arg)
			{
			case "ld":
				setLED(command[1], command[2]);
				break;
			case "out":
				print(command[2], Integer.parseInt(command[1]));
				break;
			case "rrca":
				rrca("a");
				break;
			case "rlca":
				rlca("a");
				break;
			case "djnz":
				if (djnz("b"))
					i = label.pop();
				break;
			default:
				if (arg.endsWith(":"))
					label.push(i-1);
				break;
			}
		}
	}

	public void print(String key, int start)
	{
		byte[] brightness = register.get(key);
		for (int i = 0; i < brightness.length - start; i++)
		{
			if (brightness[i] > 0)
				System.out.print("*");
			else
				System.out.print(".");
		}
		System.out.println();
	}

	private void setLED(String key, String num)
	{
		byte[] brightness = new byte[8];
		String bin = Integer.toBinaryString(Integer.parseInt(num));
		int i = brightness.length - 1;
		int j = bin.length() - 1;
		while (i >= 0 && j >= 0)
		{
			brightness[i] = (byte) Integer.parseInt(bin.substring(j, j + 1));
			i--;
			j--;
		}
		register.replace(key, brightness);
	}

	// right shift
	private void rrca(String... keys)
	{
		for (String key : keys)
		{
			byte[] a = register.get(key);
			byte[] out = new byte[8];
			// register.remove(key);
			for (int i = 1; i < out.length; i++)
			{
				out[i] = a[i - 1];
			}
			out[0] = a[7];
			register.replace(key, out);
		}
	}

	// left shift
	private void rlca(String... keys)
	{
		for (String key : keys)
		{
			byte[] a = register.get(key);
			byte[] out = new byte[8];
			// register.remove(key);
			for (int i = 0; i < out.length - 1; i++)
			{
				out[i] = a[i + 1];
			}
			out[7] = a[0];
			register.replace(key, out);
		}

	}

	private boolean djnz(String... keys)
	{
		for (String key : keys)
		{
			byte[] leds = register.get(key);
			byte[] out = Arrays.copyOf(leds, leds.length);
			int sum = 0;
			for (int i = leds.length - 1; i >= 0; i--)
			{
				if (leds[i] == 1)
				{
					out[i] = (byte) (1 - leds[i]);
					break;
				} else
				{
					out[i] = (byte) (1 - leds[i]);
				}
			}
			for (byte i : out)
			{
				sum += i;
			}
			if (sum == 0)
				return false;
			register.replace(key, out);
		}
		return true;
	}
}
