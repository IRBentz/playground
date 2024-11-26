package ygo_package;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class Backend {
	public static ArrayList<Card> database = new ArrayList<Card>();
	
	public static void start(File inputFile) throws FileNotFoundException {
		buildDB(inputFile);
	}
	
	private static void buildDB(File inputFile) throws FileNotFoundException {
			Scanner input_file = new Scanner(new File(inputFile.getAbsolutePath()));
		
		
	}
}
