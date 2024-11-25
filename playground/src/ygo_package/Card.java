package ygo_package;

public class Card {
	private final String NAME;
	private final int CARD_IND;
	
	public Card() {
		this.NAME = null;
		this.CARD_IND = 0;
	}
	
	public Card(String name, int index) {
		this.NAME = name;
		this.CARD_IND = index;
	}
}

class monCard extends Card {
	private final monATTRIBUTE MON_ATTRI;
	
	monCard() {
		super();
		this.MON_ATTRI = null;
	}
	
	monCard(String name, int index, monATTRIBUTE mon_attri) {
		super(name, index);
		this.MON_ATTRI = mon_attri;
	}
}

class stCard extends Card {
	private final stATTRIBUTE ST_ATTRI;
	
	stCard() {
		super();
		ST_ATTRI = null;
	}
	
	stCard(String name, int index, stATTRIBUTE st_attri) {
		super(name, index);
		ST_ATTRI = st_attri;
	}
}