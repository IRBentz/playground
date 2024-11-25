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
}

class monCard extends Card {
	private final monATTRIBUTE MON_ATTRI;
	private final monTYPE MON_TYPE;
	private final boolean IS_EFFECT;
	private final int LEVEL, ATTACK, DEFENSE;
	
	monCard() {
		super();
		this.MON_ATTRI = null;
		this.MON_TYPE = null;
		this.IS_EFFECT = false;
		this.LEVEL = 0;
		this.ATTACK = 0;
		this.DEFENSE = 0;
	}
	
	monCard(String name, int index, monATTRIBUTE mon_attri, monTYPE mon_type, boolean is_effect, String lore, int level, int attack, int defense) {
		super(name, index, lore);
		this.MON_ATTRI = mon_attri;
		this.MON_TYPE = mon_type;
		this.IS_EFFECT = is_effect;
		this.LEVEL = level;
		this.ATTACK = attack;
		this.DEFENSE = defense;
	}
}

class stCard extends Card {
	private final boolean IS_SPELL, IS_TRAP;
	
	stCard() {
		super();
		this.IS_SPELL = false;
		this.IS_TRAP = false;
	}
	
	stCard(String name, int index, String lore, boolean is_spell) {
		super(name, index, lore);
		this.IS_SPELL = is_spell;
		this.IS_TRAP = !IS_SPELL;
	}
}