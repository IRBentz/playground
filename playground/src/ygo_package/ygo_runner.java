package ygo_package;


public class ygo_runner {

	public ygo_runner() {
		String db_fileName = "src//ygo_package//database.data";
		String fal_fileName = "src//ygo_package//forbidden&limited_list.data";
		Backend.start(db_fileName, fal_fileName);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ygo_runner();
	}

}
