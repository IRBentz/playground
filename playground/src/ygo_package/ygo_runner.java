package ygo_package;

import java.io.File;
import java.io.FileNotFoundException;

public class ygo_runner {

	public ygo_runner() throws FileNotFoundException {
		File file = new File("database.data");
		file.setReadable(true);
		System.out.println(file.getPath() + "\n" + file.getAbsolutePath() + "\n" + file.canRead() + "\n" + file.isDirectory() + "\n" + file.exists());
		System.out.println(new File(".").getAbsolutePath());
		Backend.start(file);
	}

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		new ygo_runner();
	}

}
