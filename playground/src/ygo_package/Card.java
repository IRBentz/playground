package ygo_package;

import java.util.ArrayList;

public abstract class Card {
	private Architype[] architype;
	private final int CARD_IND;
	private int max_copies_allowed;
	private final String NAME, LORE;
	private final cardType TYPE;

	public Card() {
		this.NAME = null;
		this.TYPE = null;
		this.CARD_IND = 0;
		this.LORE = null;
		this.max_copies_allowed = 0;
	}

	public Card(String name, int index, cardType type, String lore) {
		this.NAME = name;
		this.CARD_IND = index;
		this.TYPE = type;
		this.LORE = lore;
	}

	public int getAllowedCopies() { return max_copies_allowed; }

	public Architype[] getArchitype() { return architype; }

	public int getIndex() { return CARD_IND; }

	public String getLore() { return LORE; }

	public String getName() { return NAME; }

	public cardType getType() { return TYPE; }

	public void setAllowedCopies(int newAmount) { max_copies_allowed = newAmount; }

	public void setArchitype(ArrayList<Architype> architype) {
		this.architype = architype.toArray(new Architype[architype.size()]);
	}

	@Override
	public String toString() {
		return String.format("%08d", CARD_IND) + " | " + max_copies_allowed + " | " + NAME + " | " + TYPE + " | " + LORE;
	}
}


class monCard extends Card {
	private final int LEVEL_RANK, ATTACK, DEFENSE;
	private final monAttribute MON_ATTRI;
	private final monType MON_TYPE;
	private final Type[] TYPES;

	public monCard() {
		super();
		this.MON_ATTRI = null;
		this.MON_TYPE = null;
		this.TYPES = null;
		this.LEVEL_RANK = 0;
		this.ATTACK = 0;
		this.DEFENSE = 0;
	}

	public monCard(String name, int index, monAttribute mon_attri, monType mon_type, Type[] types,
			String lore, int level_rank, int attack, int defense) {
		super(name, index, cardType.MONSTER, lore);
		this.MON_ATTRI = mon_attri;
		this.MON_TYPE = mon_type;
		this.TYPES = types;
		this.LEVEL_RANK = level_rank;
		this.ATTACK = attack;
		this.DEFENSE = defense;
	}

	public int getAttack() { return ATTACK; }

	public monAttribute getAttribute() { return MON_ATTRI; }

	public int getDefense() { return DEFENSE; }

	public int getLevelOrRank() { return LEVEL_RANK; }

	public monType getMonType() { return MON_TYPE; }

	public Type[] getTypes() { return TYPES; }

	@Override
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

	public penMonCard(String name, int index, monAttribute mon_attri, monType mon_type, Type[] types,
			String pend_lore, String lore, int level_rank, int pend_level, int attack, int defense) {
		super(name, index, mon_attri, mon_type, types, lore, level_rank, attack, defense);
		this.PEND_LEVEL = pend_level;
		this.PEND_LORE = pend_lore;
	}

	public int getPendLevel() { return PEND_LEVEL; }

	@Override
	public String toString() { return super.toString() + " | " + PEND_LEVEL + " | " + PEND_LORE; }
}

class extraMonCard extends monCard {
	final String SUMMON_REQ;

	public extraMonCard() {
		super();
		this.SUMMON_REQ = null;
	}

	public extraMonCard(String name, int index, monAttribute mon_attri, monType mon_type,
			Type[] types, String summon_req, String lore, int level_rank, int attack, int defense) {
		super(name, index, mon_attri, mon_type, types, lore, level_rank, attack, defense);
		this.SUMMON_REQ = summon_req;
	}

	public String getSummonReq() { return SUMMON_REQ; }

	@Override
	public String toString() { return super.toString() + " | " + SUMMON_REQ; }
}

class xyzMonCard extends extraMonCard {
	private ArrayList<Card> xyzMaterials = new ArrayList<Card>();

	public xyzMonCard() { super(); }

	public xyzMonCard(String name, int index, monAttribute mon_attri, monType mon_type, 
			Type[] types, String summon_req, String lore, int rank, int attack, int defense) {
		super(name, index, mon_attri, mon_type, types, summon_req, lore, rank, attack, defense);
	}

	public ArrayList<Card> getXyzMats() { return xyzMaterials; }
	
	@Override
	public String toString() {
		String xyzMats = "";
		for(Card mat : xyzMaterials)
			xyzMats += mat.toString() + " ";
		if(xyzMats.length() > 0)
			xyzMats = xyzMats.substring(0, xyzMats.length() - 1);
		return super.toString() + " | " + xyzMats;
	}
}

class linkMonCard extends extraMonCard {
	final linkArrow[] LINK_ARROWS;

	public linkMonCard() {
		super();
		this.LINK_ARROWS = null;
	}

	public linkMonCard(String name, int index, monAttribute mon_attri, monType mon_type,
			Type[] types, String summon_req, String lore, int link_rating, int attack, linkArrow[] link_arrows) {
		super(name, index, mon_attri, mon_type, types, summon_req, lore, link_rating, attack, link_rating);
		this.LINK_ARROWS = link_arrows;
	}

	public linkArrow[] getLinkArrows() { return LINK_ARROWS; }

	@Override
	public String toString() {
		String link_arrows = "";
		for (linkArrow link_arrow : LINK_ARROWS) {
			link_arrows += link_arrow.toString() + " ";
		}
		link_arrows = link_arrows.substring(0, link_arrows.length() - 1);
		return super.toString() + " | " + link_arrows;
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

	public Icon returnIcon() { return ICON; }
	
	@Override
	public String toString() { return super.toString() + " | " + ICON; }
}

class spellCard extends stCard {
	public spellCard() { super(); }

	public spellCard(String name, int index, String lore, Icon st_icon) { super(name, index, cardType.SPELL, lore, st_icon); }
}

class trapCard extends stCard {
	public trapCard() { super(); }

	public trapCard(String name, int index, String lore, Icon st_icon) { super(name, index, cardType.TRAP, lore, st_icon); }
}