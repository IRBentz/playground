package ygo_package;

public class ygo_runner {

	public static void main(String[] args) {
		new ygo_runner();
	}

	public ygo_runner() {
		String db_fileName = "src//ygo_package//card.data";
		String fal_fileName = "src//ygo_package//fal.data";
		Backend.start(db_fileName, fal_fileName);
	}

}
