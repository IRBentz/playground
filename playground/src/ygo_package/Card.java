package ygo_package;

public abstract class Card {
	private Architype architype;
	private final int CARD_IND;
	private int max_copies_allowed;
	private final String NAME, LORE;
	private final cardType TYPE;
	
	/*
	 * @author IRBentz
	 * Default constructor
	 */
	public Card() {
		this.NAME = null;
		this.TYPE = null;
		this.CARD_IND = 0;
		this.LORE = null;
		this.max_copies_allowed = 0;
	}
	
	/**
	 * @author IRBentz
	 * @param name Card name
	 * @param index Card index
	 * @param type Type of card
	 * @param lore Card Lore
	 */
	public Card(String name, int index, cardType type, String lore) {
		this.NAME = name;
		this.CARD_IND = index;
		this.TYPE = type;
		this.LORE = lore;
	}
	
	/**
	 * @author IRBentz
	 * @return max_copies_allowed
	 */
	public int getAllowedCopies() {
		return max_copies_allowed;
	}
	
	/**
	 * @author IRBentz
	 * @return Architype
	 */
	public Architype getArchitype() {
		return architype;
	}
	
	/**
	 * @author IRBentz
	 * @return Index
	 */
	public int getIndex() {
		return CARD_IND;
	}
	
	/**
	 * @author IRBentz
	 * @return Lore
	 */
	public String getLore() {
		return LORE;
	}
	
	/**
	 * @author IRBentz
	 * @return Name
	 */
	public String getName() {
		return NAME;
	}
	
	/**
	 * @author IRBentz
	 * @return Type
	 */
	public cardType getType() {
		return TYPE;
	}

	/**
	 * @author IRBentz
	 * @param newAmount Card max_copies_allowed
	 */
	public void setAllowedCopies(int newAmount) {
		max_copies_allowed = newAmount;
	}
	
	/**
	 * @author IRBentz
	 * @param architype Card architype
	 */
	public void setArchitype(Architype architype) {
		this.architype = architype;
	}

	/**
	 * @author IRBentz
	 * @return String of: 8 digit format card index, max copies allowed, name, type, and lore; Separated by a '|' character.
	 */
	public String toString() {
		return String.format("%08d", CARD_IND) + " | " + max_copies_allowed + " | " + NAME + " | " + TYPE + " | " + LORE;
	}
}

class extraMonCard extends monCard {
	final String SUMMON_REQ;

	/**
	 * @author IRBentz
	 * Default Constructor
	 */
	public extraMonCard() {
		super();
		this.SUMMON_REQ = null;
	}

	/**
	 * Separated by a '|' character.
	 * @param name Card name
	 * @param index Card index
	 * @param cardType Type of Card
	 * @param mon_attri Monster attribute
	 * @param mon_type Monster type
	 * @param types Card types
	 * @param summon_req Summon requirements
	 * @param lore Card lore
	 * @param level_rank Card level/rank
	 * @param attack Card attack
	 * @param defense Card defense
	 */
	public extraMonCard(String name, int index, cardType cardType, monAttribute mon_attri, monType mon_type,
			Type[] types, String summon_req, String lore, int level_rank, int attack, int defense) {
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

class linkMonCard extends extraMonCard {
	final linkArrow[] LINK_ARROWS;
	final int LINK_RATING;

	public linkMonCard() {
		super();
		this.LINK_RATING = 0;
		this.LINK_ARROWS = null;
	}

	public linkMonCard(String name, int index, cardType cardType, monAttribute mon_attri, monType mon_type,
			Type[] types, String summon_req, String lore, int link_rating, int attack, linkArrow[] link_arrows) {
		super(name, index, cardType, mon_attri, mon_type, types, summon_req, lore, link_rating, attack, link_rating);
		this.LINK_RATING = link_rating;
		this.LINK_ARROWS = link_arrows;
	}

	public linkArrow[] getLinkArrows() {
		return LINK_ARROWS;
	}

	public int getLinkRating() {
		return LINK_RATING;
	}

	public String toString() {
		String link_arrows = "";
		for (linkArrow link_arrow : LINK_ARROWS) {
			link_arrows += link_arrow.toString() + " ";
		}
		link_arrows = link_arrows.substring(0, link_arrows.length() - 1);
		return super.toString() + " | " + LINK_RATING + " | " + link_arrows;
	}
}

class monCard extends Card {
	private final int LEVEL_RANK, ATTACK, DEFENSE;
	private final monAttribute MON_ATTRI;
	private final monType MON_TYPE;
	private final Type[] TYPES;
	
	/**
	 * @author IRBentz
	 * Default constructor
	 */
	public monCard() {
		super();
		this.MON_ATTRI = null;
		this.MON_TYPE = null;
		this.TYPES = null;
		this.LEVEL_RANK = 0;
		this.ATTACK = 0;
		this.DEFENSE = 0;
	}
	
	/**
	 * @author IRBentz
	 * @param name Card name
	 * @param index Card index
	 * @param cardType Type of Card
	 * @param mon_attri Card monster attribute
	 * @param mon_type Card monster type
	 * @param types Card types
	 * @param lore Card lore
	 * @param level_rank Card level/Rank
	 * @param attack Card attack
	 * @param defense Card defense
	 */
	public monCard(String name, int index, cardType cardType, monAttribute mon_attri, monType mon_type, Type[] types,
			String lore, int level_rank, int attack, int defense) {
		super(name, index, cardType, lore);
		this.MON_ATTRI = mon_attri;
		this.MON_TYPE = mon_type;
		this.TYPES = types;
		this.LEVEL_RANK = level_rank;
		this.ATTACK = attack;
		this.DEFENSE = defense;
	}
	
	/**
	 * @author IRBentz
	 * @return attack
	 */
	public int getAttack() {
		return ATTACK;
	}

	/**
	 * @author IRBentz
	 * @return Monster_Attribute
	 */
	public monAttribute getAttribute() {
		return MON_ATTRI;
	}
	
	/**
	 * @author IRBentz
	 * @return defense
	 */
	public int getDefense() {
		return DEFENSE;
	}
	
	/**
	 * @author IRBentz
	 * @return level/rank
	 */
	public int getLevelOrRank() {
		return LEVEL_RANK;
	}

	/**
	 * @author IRBentz
	 * @return Monster_Type
	 */
	public monType getMonType() {
		return MON_TYPE;
	}
	
	/**
	 * @author IRBentz
	 * @return Types
	 */
	public Type[] getTypes() {
		return TYPES;
	}
	
	/**
	 * @author IRBentz
	 * @return Card.toString() return, Monster Attribute, Monster Type, types, Level/Rank, Attack, and Defense. Separated by a '|' character.
	 */
	public String toString() {
		String types = "";
		for (Type type : TYPES) {
			types += type.toString() + " ";
		}
		types = types.substring(0, types.length() - 1);

		return super.toString() + " | " + MON_ATTRI + " | " + MON_TYPE + " | " + types + " | " + LEVEL_RANK + " | "
				+ ATTACK + " | " + DEFENSE;
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

	public penMonCard(String name, int index, cardType cardType, monAttribute mon_attri, monType mon_type, Type[] types,
			String pend_lore, String lore, int level_rank, int pend_level, int attack, int defense) {
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

class spellCard extends stCard {
	public spellCard() {
		super();
	}

	public spellCard(String name, int index, cardType cardType, String lore, Icon st_icon) {
		super(name, index, cardType, lore, st_icon);
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

class trapCard extends stCard {
	public trapCard() {
		super();
	}

	public trapCard(String name, int index, cardType cardType, String lore, Icon st_icon) {
		super(name, index, cardType, lore, st_icon);
	}
}