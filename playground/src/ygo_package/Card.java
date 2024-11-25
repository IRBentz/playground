package ygo_package;

public class Card {
	private final String NAME, LORE;
	private final Type TYPE;
	private final int CARD_IND;
	
	public Card() {
		this.NAME = null;
		this.TYPE = null;
		this.CARD_IND = 0;
		this.LORE = null;
	}
	
	public Card(String name, int index, Type type, String lore) {
		this.NAME = name;
		this.CARD_IND = index;
		this.TYPE = type;
		this.LORE = lore;
	}
	
	public String getName() {
		return NAME;
	}
	
	public String getLore() {
		return LORE;
	}
	
	public Type getType() {
		return TYPE;
	}
	
	public int getIndex() {
		return CARD_IND;
	}
}

class monCard extends Card {
	private final monAttribute MON_ATTRI;
	private final monType MON_TYPE;
	private final Type[] TYPES;
	private final int LEVEL_RANK, ATTACK, DEFENSE;
	
	monCard() {
		super();
		this.MON_ATTRI = null;
		this.MON_TYPE = null;
		this.TYPES = null;
		this.LEVEL_RANK = 0;
		this.ATTACK = 0;
		this.DEFENSE = 0;
	}
	
	monCard(String name, int index, monAttribute mon_attri, monType mon_type, Type[] types, String lore, int level_rank, int attack, int defense) {
		super(name, index, types[0], lore);
		this.MON_ATTRI = mon_attri;
		this.MON_TYPE = mon_type;
		this.TYPES = types;
		this.LEVEL_RANK = level_rank;
		this.ATTACK = attack;
		this.DEFENSE = defense;
	}
	
	public monAttribute getAttribute() {
		return MON_ATTRI;
	}
	
	public monType getMonType() {
		return MON_TYPE;
	}
	
	public Type[] getTypes() {
		return TYPES;
	}
	
	public int getLevelOrRank() {
		return LEVEL_RANK;
	}
	
	public int getAttack() {
		return ATTACK;
	}
	
	public int getDefense() {
		return DEFENSE;
	}
}

class penMonCard extends monCard {
	final int PEND_LEVEL;
	
	penMonCard() {
		super();
		this.PEND_LEVEL = 0;
	}
	
	penMonCard(String name, int index, monAttribute mon_attri, monType mon_type, Type[] types, String lore, int level_rank, int pend_level, int attack, int defense) {
		super(name, index, mon_attri, mon_type, types, lore, level_rank, attack, defense);
		this.PEND_LEVEL = pend_level;
	}
	
	public int getPendLevel() {
		return PEND_LEVEL;
	}
}

class linkMonCard extends monCard {
	final int LINK_RATING;
	final link_arrow[] LINK_ARROWS;
	
	public linkMonCard() {
		super();
		this.LINK_RATING = 0;
		this.LINK_ARROWS = null;
	}
	
	public linkMonCard(String name, int index, monAttribute mon_attri, monType mon_type, Type[] types, String lore, int link_rating, int attack, int defense, link_arrow[] link_arrows) {
		super(name, index, mon_attri, mon_type, types, lore, 0, attack, defense);
		this.LINK_RATING = link_rating;
		this.LINK_ARROWS = link_arrows;
	}
	
	public int getLinkRating() {
		return LINK_RATING;
	}
	
	public link_arrow[] getLinkArrows() {
		return LINK_ARROWS;
	}
}

class stCard extends Card {
	private final Icon ICON;
	
	public stCard() {
		super();
		this.ICON = null;
	}
	
	public stCard(String name, int index, String lore, Type type, Icon st_icon) {
		super(name, index, type, lore);
		this.ICON = st_icon;
	}
	
	public Icon returnIcon() {
		return ICON;
	}
}

class spellCard extends stCard {
	public spellCard() {
		super();
	}
}

class trapCard extends stCard {
	public trapCard() {
		super();
	}
}