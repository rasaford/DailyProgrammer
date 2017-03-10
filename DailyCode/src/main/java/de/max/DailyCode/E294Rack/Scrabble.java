package de.max.DailyCode.E294Rack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Scrabble {

	public static void main(String[] args) {
		
		String[][] a = { {"ladilmy", "daily"}, 
							{"eerriin", "eerie"},
							{"orrpgma", "program"},
							{"orppgma", "program"},
							{"ladilmy", "daily"}};
		for (String[] i : a) {
			System.out.println(i[0] + " " + i[1] + " -> ");
		}
	}

}
