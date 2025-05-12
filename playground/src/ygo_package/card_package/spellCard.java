package ygo_package.card_package;

public class spellCard extends stCard {
	public spellCard() {
		super();
	}

	public spellCard(String name, int index, String lore, Icon st_icon) {
		super(name, index, cardType.SPELL, lore, st_icon);
	}
}