package ygo_eng.ui;

import java.awt.Color;

public enum Card_bg {
	LINK(22, 108, 160),
	EFFECT(186, 99, 55),
	SPELL(21, 148, 141),
	XYZ(27, 27, 28),
	NORMAL(35, 35, 11),
	FUSION(119, 60, 158),
	RITUAL(17, 16, 46),
	TRAP(21, 12, 33),
	SYNCHRO(220, 215, 211),
	TOKEN(122, 116, 116);
	
	public final Color bg_c;
	Card_bg(int r, int g, int b) {
		bg_c = new Color(r, g, b);
	}
}
