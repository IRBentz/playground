package ygo_package.card_package;

import java.util.ArrayList;

public class xyzMonCard extends extraMonCard {
	private ArrayList<Card> xyzMaterials = new ArrayList<Card>();

	public xyzMonCard() {
		super();
	}

	public xyzMonCard(String name, int index, monAttribute mon_attri, monType mon_type, Type[] types, String summon_req,
			String lore, int rank, int attack, int defense) {
		super(name, index, mon_attri, mon_type, types, summon_req, lore, rank, attack, defense);
	}

	public ArrayList<Card> getXyzMats() {
		return xyzMaterials;
	}

	@Override
	public String toString() {
		String xyzMats = "";
		for (Card mat : xyzMaterials)
			xyzMats += mat.toString() + " ";
		if (xyzMats.length() > 0)
			xyzMats = xyzMats.substring(0, xyzMats.length() - 1);
		return super.toString() + " | " + xyzMats;
	}
}