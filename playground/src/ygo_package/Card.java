package ygo_package;

public class Card {
	private final String NAME, LORE;
	private final int CARD_IND;
	
	public Card() {
		this.NAME = null;
		this.CARD_IND = 0;
		this.LORE = null;
	}
	
	public Card(String name, int index, String lore) {
		this.NAME = name;
		this.CARD_IND = index;
		this.LORE = lore;
	}
	
	public String getName() {
		return NAME;
	}
	
	public String getLore() {
		return LORE;
	}
	
	public int getIndex() {
		return CARD_IND;
	}
}

class monCard extends Card {
	private final monATTRIBUTE MON_ATTRI;
	private final monTYPE MON_TYPE;
	private final TYPE[] TYPES;
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
	
	monCard(String name, int index, monATTRIBUTE mon_attri, monTYPE mon_type, TYPE[] types, String lore, int level_rank, int attack, int defense) {
		super(name, index, lore);
		this.MON_ATTRI = mon_attri;
		this.MON_TYPE = mon_type;
		this.TYPES = types;
		this.LEVEL_RANK = level_rank;
		this.ATTACK = attack;
		this.DEFENSE = defense;
	}
	
	public monATTRIBUTE getAttribute() {
		return MON_ATTRI;
	}
	
	public monTYPE getMonType() {
		return MON_TYPE;
	}
	
	public TYPE[] getTypes() {
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
	
	penMonCard(String name, int index, monATTRIBUTE mon_attri, monTYPE mon_type, TYPE[] types, String lore, int level_rank, int pend_level, int attack, int defense) {
		super(name, index, mon_attri, mon_type, types, lore, level_rank, attack, defense);
		this.PEND_LEVEL = pend_level;
	}
	
	public int getPendLevel() {
		return PEND_LEVEL;
	}
}

class linkMonCard extends monCard {
	final int LINK_RATING;
	final LINK_ARROW[] LINK_ARROWS;
	
	public linkMonCard() {
		super();
		this.LINK_RATING = 0;
		this.LINK_ARROWS = null;
	}
	
	public linkMonCard(String name, int index, monATTRIBUTE mon_attri, monTYPE mon_type, TYPE[] types, String lore, int link_rating, int attack, int defense, LINK_ARROW[] link_arrows) {
		super(name, index, mon_attri, mon_type, types, lore, 0, attack, defense);
		this.LINK_RATING = link_rating;
		this.LINK_ARROWS = link_arrows;
	}
	
	public int getLinkRating() {
		return LINK_RATING;
	}
	
	public LINK_ARROW[] getLinkArrows() {
		return LINK_ARROWS;
	}
}

class stCard extends Card {
	private final boolean IS_SPELL, IS_TRAP;
	private final ICON ST_ICON;
	
	stCard() {
		super();
		this.IS_SPELL = false;
		this.IS_TRAP = false;
		this.ST_ICON = null;
	}
	
	stCard(String name, int index, String lore, boolean is_spell, ICON st_icon) {
		super(name, index, lore);
		this.IS_SPELL = is_spell;
		this.IS_TRAP = !IS_SPELL;
		this.ST_ICON = st_icon;
	}
	
	public boolean returnIsSpell() {
		return IS_SPELL;
	}
	
	public boolean returnIsTrap() {
		return IS_TRAP;
	}
	
	public ICON returnIcon() {
		return ST_ICON;
	}
}