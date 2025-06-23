package ygo_eng.ui;

import java.awt.Color;

public enum Card_bg {
	EFFECT(186, 99, 55), FUSION(119, 60, 158), LINK(22, 108, 160), NORMAL(35, 35, 11), RITUAL(17, 16, 46),
	SPELL(21, 148, 141), SYNCHRO(220, 215, 211), TOKEN(122, 116, 116), TRAP(21, 12, 33), XYZ(27, 27, 28);

	public final Color bg_c;

	Card_bg(int r, int g, int b) {
		bg_c = new Color(r, g, b);
	}
}
