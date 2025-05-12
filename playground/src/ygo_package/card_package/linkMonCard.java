package ygo_package.card_package;

public class linkMonCard extends extraMonCard {
	final linkArrow[] LINK_ARROWS;

	public linkMonCard() {
		super();
		this.LINK_ARROWS = null;
	}

	public linkMonCard(String name, int index, monAttribute mon_attri, monType mon_type, Type[] types,
			String summon_req, String lore, int link_rating, int attack, linkArrow[] link_arrows) {
		super(name, index, mon_attri, mon_type, types, summon_req, lore, link_rating, attack, link_rating);
		this.LINK_ARROWS = link_arrows;
	}

	public linkArrow[] getLinkArrows() {
		return LINK_ARROWS;
	}

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