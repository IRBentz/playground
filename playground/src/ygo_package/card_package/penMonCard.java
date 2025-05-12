package ygo_package.card_package;

public class penMonCard extends monCard {
	final int PEND_LEVEL;
	final String PEND_LORE;

	public penMonCard() {
		super();
		this.PEND_LEVEL = 0;
		this.PEND_LORE = null;
	}

	public penMonCard(String name, int index, monAttribute mon_attri, monType mon_type, Type[] types, String pend_lore,
			String lore, int level_rank, int pend_level, int attack, int defense) {
		super(name, index, mon_attri, mon_type, types, lore, level_rank, attack, defense);
		this.PEND_LEVEL = pend_level;
		this.PEND_LORE = pend_lore;
	}

	public int getPendLevel() {
		return PEND_LEVEL;
	}

	@Override
	public String toString() {
		return super.toString() + " | " + PEND_LEVEL + " | " + PEND_LORE;
	}
}