package ygo_package;

public abstract class Card {
	private final String NAME, LORE;
	private final cardType TYPE;
	private final int CARD_IND;
	private int copies_allowed;
	
	public Card() {
		this.NAME = null;
		this.TYPE = null;
		this.CARD_IND = 0;
		this.LORE = null;
		this.copies_allowed = 0;
	}
	
	public Card(String name, int index, cardType type, String lore) {
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
	
	public cardType getType() {
		return TYPE;
	}
	
	public int getIndex() {
		return CARD_IND;
	}
	
	public int getAllowedCopies() {
		return copies_allowed;
	}
	
	public void setAllowedCopies(int newAmount) {
		copies_allowed = newAmount;
	}
	
	public String toString() {
		return String.format("%08d", CARD_IND) + " | " + copies_allowed + " | " + NAME + " | " + TYPE + " | " + LORE;
	}
}

class monCard extends Card {
	private final monAttribute MON_ATTRI;
	private final monType MON_TYPE;
	private final Type[] TYPES;
	private final int LEVEL_RANK, ATTACK, DEFENSE;
	
	public monCard() {
		super();
		this.MON_ATTRI = null;
		this.MON_TYPE = null;
		this.TYPES = null;
		this.LEVEL_RANK = 0;
		this.ATTACK = 0;
		this.DEFENSE = 0;
	}
	
	public monCard(String name, int index, cardType cardType, monAttribute mon_attri, monType mon_type, Type[] types, String lore, int level_rank, int attack, int defense) {
		super(name, index, cardType, lore);
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
	
	public String toString() {
		String types = "";
		for(Type type : TYPES) {
			types += type.toString() + " ";
		}
		types = types.substring(0, types.length() - 1);
		
		return super.toString() + " | " + MON_ATTRI + " | " + MON_TYPE + " | " + types + " | " + LEVEL_RANK + " | " + ATTACK + " | " + DEFENSE;
	}
}

class extraMonCard extends monCard {
	final String SUMMON_REQ;
	
	public extraMonCard() {
		super();
		this.SUMMON_REQ = null;
	}
	
	public extraMonCard(String name, int index, cardType cardType, monAttribute mon_attri, monType mon_type, Type[] types, String summon_req, String lore, int level_rank, int attack, int defense) {
		super(name, index, cardType, mon_attri, mon_type, types, lore, level_rank, attack, defense);
		this.SUMMON_REQ = summon_req;
	}
	
	public String getSummonReq() {
		return SUMMON_REQ;
	}
	
	public String toString() {
		return super.toString() + " | " + SUMMON_REQ;
	}
}

class penMonCard extends monCard {
	final int PEND_LEVEL;
	final String PEND_LORE;
	
	public penMonCard() {
		super();
		this.PEND_LEVEL = 0;
		this.PEND_LORE = null;
	}
	
	public penMonCard(String name, int index, cardType cardType, monAttribute mon_attri, monType mon_type, Type[] types, String pend_lore, String lore, int level_rank, int pend_level, int attack, int defense) {
		super(name, index, cardType, mon_attri, mon_type, types, lore, level_rank, attack, defense);
		this.PEND_LEVEL = pend_level;
		this.PEND_LORE = pend_lore;
	}
	
	public int getPendLevel() {
		return PEND_LEVEL;
	}
	
	public String toString() {
		return super.toString() + " | " + PEND_LEVEL + " | " + PEND_LORE;
	}
}

class linkMonCard extends extraMonCard {
	final int LINK_RATING;
	final linkArrow[] LINK_ARROWS;
	
	public linkMonCard() {
		super();
		this.LINK_RATING = 0;
		this.LINK_ARROWS = null;
	}
	
	public linkMonCard(String name, int index, cardType cardType, monAttribute mon_attri, monType mon_type, Type[] types, String summon_req, String lore, int link_rating, int attack, linkArrow[] link_arrows) {
		super(name, index, cardType, mon_attri, mon_type, types, summon_req, lore, link_rating, attack, link_rating);
		this.LINK_RATING = link_rating;
		this.LINK_ARROWS = link_arrows;
	}
	
	public int getLinkRating() {
		return LINK_RATING;
	}
	
	public linkArrow[] getLinkArrows() {
		return LINK_ARROWS;
	}
	
	public String toString() {
		String link_arrows = "";
		for(linkArrow link_arrow : LINK_ARROWS) {
			link_arrows += link_arrow.toString() + " ";
		}
		link_arrows = link_arrows.substring(0, link_arrows.length() - 1);
		return super.toString() + " | " + LINK_RATING + " | " + link_arrows;
	}
}

abstract class stCard extends Card {
	private final Icon ICON;
	
	public stCard() {
		super();
		this.ICON = null;
	}
	
	public stCard(String name, int index, cardType cardType, String lore, Icon st_icon) {
		super(name, index, cardType, lore);
		this.ICON = st_icon;
	}
	
	public Icon returnIcon() {
		return ICON;
	}
	
	public String toString() {
		return super.toString() + " | " + ICON;
	}
}

class spellCard extends stCard {
	public spellCard() {
		super();
	}
	
	public spellCard(String name, int index, cardType cardType, String lore, Icon st_icon) {
		super(name, index, cardType, lore, st_icon);
	}
}

class trapCard extends stCard {
	public trapCard() {
		super();
	}
	
	public trapCard(String name, int index, cardType cardType, String lore, Icon st_icon) {
		super(name, index, cardType, lore, st_icon);
	}
}