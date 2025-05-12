package ygo_package.card_package;

public class extraMonCard extends monCard {
	final String SUMMON_REQ;

	public extraMonCard() {
		super();
		this.SUMMON_REQ = null;
	}

	public extraMonCard(String name, int index, monAttribute mon_attri, monType mon_type, Type[] types,
			String summon_req, String lore, int level_rank, int attack, int defense) {
		super(name, index, mon_attri, mon_type, types, lore, level_rank, attack, defense);
		this.SUMMON_REQ = summon_req;
	}

	public String getSummonReq() {
		return SUMMON_REQ;
	}

	@Override
	public String toString() {
		return super.toString() + " | " + SUMMON_REQ;
	}
}