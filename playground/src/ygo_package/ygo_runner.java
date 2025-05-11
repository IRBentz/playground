package ygo_package;

public class ygo_runner {

	public static void main(String[] args) {
		new ygo_runner();
	}

	public ygo_runner() {
		String fileName = "src//ygo_package//file_pointers.txt";
		Backend.start(fileName);
	}

}
