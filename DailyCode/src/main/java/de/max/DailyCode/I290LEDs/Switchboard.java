package de.max.DailyCode.I290LEDs;

import java.util.Arrays;

public class Switchboard {
	public static void main(String[] args)
	{
		LEDs led = new LEDs();
		String i1 = "  ld a,14    out (0),a    ld a,12    out (0),a    ld a,8    out (0),a    out (0),a    ld a,12    out (0),a    ld a,14    out (0),a";
		String i2 = "  ld b,3    triple:    ld a,126    out (0),a    ld a,60    out (0),a    ld a,24    out (0),a    djnz triple";
		String i3 = "  ld a,1    ld b,90    loop:    out (0),a    rlca    djnz loop";
		String i4 = "  ld a,2    ld b,90   loop:    out (0),a    rrca    djnz loop";
		led.parse(i4);
	}

}
