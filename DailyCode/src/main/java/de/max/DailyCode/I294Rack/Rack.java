package de.max.DailyCode.I294Rack;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Rack {
	public static void main(String[] args) {
		List<String> l = new ArrayList<>();
		Path p = Paths.get("/home/max/Downloads/enable1.txt");
		try(BufferedReader fr = Files.newBufferedReader(p)) {
//			while(true) {
//				l.add(fr.readLine());
//			}
			while (true)
			System.out.println(fr.readLine());
		} catch (IOException e) {
			
		}
//		for (String i : l) {
//			System.out.println(i);
//		}

	}
	
	private static int getScore(String c) {
		int score = 0;
		for (int i = 0; i < c.length(); i++) {
			String ch = c.substring(i, i+1);
			if ("eaotinrslu".toUpperCase().contains(ch.toUpperCase())) {
				score += 1;
			} else if ("dg".toUpperCase().contains(ch.toUpperCase())) {
				score += 2;
			} else if ("cmbp".toUpperCase().contains(ch.toUpperCase())) {
				score += 3;
			} else if ("hfwyv".toUpperCase().contains(ch.toUpperCase())) {
				score += 4;
			} else if ("k".toUpperCase().contains(ch.toUpperCase())) {
				score += 5;
			} else if ("jx".toUpperCase().contains(ch.toUpperCase())) {
				score += 8;
			} else if ("qz".toUpperCase().contains(ch.toUpperCase())) {
				score += 10;
			}
		}
		return score;
	}
}
