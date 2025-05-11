package ygo_package;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public abstract class Backend {
	private static ArrayList<Card> card_db = new ArrayList<Card>();
	private static ArrayList<int[]> fal_list = new ArrayList<int[]>();
	private static DebugWindow window = new DebugWindow();

	public static void start(String pointerFileName) {
		buildDB(pointerFileName);
		assignFaL();
		debugCheck();
	}
	
	private static void buildDB(String pointerFileName) {
		Scanner pointerFileScanner;
		try {
			pointerFileScanner = new Scanner(new File(pointerFileName));
			System.out.println("Found file at: " + new File(pointerFileName).getPath());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return;
		}
		
		String filePath = pointerFileScanner.nextLine();
		System.out.println("Successfully found designated file path at: " + filePath.replace("//", "\\"));
		
		ArrayList<Scanner> fileScanners = new ArrayList<Scanner>();
		int numberOfFiles = 8;
		for (int i = 0; i < numberOfFiles; i++) {
			try {
				String fileLoc = filePath + pointerFileScanner.nextLine();
				System.out.println("Successfully found Target file: " + fileLoc.replace("//", "\\"));
				fileScanners.add(new Scanner(new File(fileLoc)));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				pointerFileScanner.close();
				return;
			}
		}
		
		/*
		for(Scanner curScanner : fileScanners) {
			curScanner.useDelimiter(" ;");
			System.out.println(curScanner.toString() + curScanner.delimiter().toString());
		}
		*/
		
		Scanner currScanner = fileScanners.get(0);
		while (currScanner.hasNext()) {
			Object[] returnedList = Utils.pullMonBaseStats(currScanner, ";");

			card_db.add(new monCard((String) ((Object[]) returnedList[0])[0],
					(Integer) ((Object[]) returnedList[0])[1], (monAttribute) returnedList[1],
					(monType) returnedList[2], (Type[]) returnedList[3], (String) ((Object[]) returnedList[0])[2],
					(Integer) returnedList[4], (Integer) returnedList[5], (Integer) returnedList[6]));
		}
		
		currScanner = fileScanners.get(1);
		while (currScanner.hasNext()) {
			Object[] returnedList = Utils.pullMonBaseStats(currScanner, ";");

			card_db.add(new penMonCard((String) ((Object[]) returnedList[0])[0],
					(Integer) ((Object[]) returnedList[0])[1], (monAttribute) returnedList[1],
					(monType) returnedList[2], (Type[]) returnedList[3], Utils.pullNextTextBlock(currScanner, ";"),
					(String) ((Object[]) returnedList[0])[2], (Integer) returnedList[4], currScanner.nextInt(),
					(Integer) returnedList[5], (Integer) returnedList[6]));
		}
		
		currScanner = fileScanners.get(2);
		while (currScanner.hasNext()) {
			Object[] returnedList = Utils.pullMonBaseStats(currScanner, ";");

			card_db.add(new extraMonCard((String) ((Object[]) returnedList[0])[0],
					(Integer) ((Object[]) returnedList[0])[1], (monAttribute) returnedList[1],
					(monType) returnedList[2], (Type[]) returnedList[3], Utils.pullNextTextBlock(currScanner, ";"),
					(String) ((Object[]) returnedList[0])[2], (Integer) returnedList[4], (Integer) returnedList[5],
					(Integer) returnedList[6]));
		}
		
		currScanner = fileScanners.get(3);
		while (currScanner.hasNext()) {
			Object[] returnedList = Utils.pullMonBaseStats(currScanner, ";");

			card_db.add(new extraMonCard((String) ((Object[]) returnedList[0])[0],
					(Integer) ((Object[]) returnedList[0])[1], (monAttribute) returnedList[1],
					(monType) returnedList[2], (Type[]) returnedList[3], Utils.pullNextTextBlock(currScanner, ";"),
					(String) ((Object[]) returnedList[0])[2], (Integer) returnedList[4], (Integer) returnedList[5],
					(Integer) returnedList[6]));
		}
		
		currScanner = fileScanners.get(4);
		while (currScanner.hasNext()) {
			Object[] returnedList = Utils.pullMonBaseStats(currScanner, ";");

			card_db.add(new xyzMonCard((String) ((Object[]) returnedList[0])[0],
					(Integer) ((Object[]) returnedList[0])[1], (monAttribute) returnedList[1],
					(monType) returnedList[2], (Type[]) returnedList[3], Utils.pullNextTextBlock(currScanner, ";"),
					(String) ((Object[]) returnedList[0])[2], (Integer) returnedList[4], (Integer) returnedList[5],
					(Integer) returnedList[6]));
		}
		
		currScanner = fileScanners.get(5);
		while (currScanner.hasNext()) {
			Object[] returnedList = Utils.pullMonBaseStats(currScanner, ";");

			card_db.add(new linkMonCard((String) ((Object[]) returnedList[0])[0],
					(Integer) ((Object[]) returnedList[0])[1], (monAttribute) returnedList[1],
					(monType) returnedList[2], (Type[]) returnedList[3], Utils.pullNextTextBlock(currScanner, ";"),
					(String) ((Object[]) returnedList[0])[2], (Integer) returnedList[5], (Integer) returnedList[6],
					(linkArrow[]) Utils.pullNextLinkArrowBlock(currScanner, ";")));
		}
		
		currScanner = fileScanners.get(6);
		while (currScanner.hasNext()) {
			Object[] returnedList = Utils.pullSTBaseStats(currScanner, ";");
			
			card_db.add(new spellCard((String) ((Object[]) returnedList[0])[0],
					(Integer) ((Object[]) returnedList[0])[1], (String) ((Object[]) returnedList[0])[2],
					(Icon) returnedList[1]));
		}
		
		currScanner = fileScanners.get(7);
		while (currScanner.hasNext()) {
			Object[] returnedList = Utils.pullSTBaseStats(currScanner, ";");

			card_db.add(new trapCard((String) ((Object[]) returnedList[0])[0],
					(Integer) ((Object[]) returnedList[0])[1], (String) ((Object[]) returnedList[0])[2],
					(Icon) returnedList[1]));
		}
		
		buildFaL(filePath + pointerFileScanner.nextLine());
		
		pointerFileScanner.close();
		for (Scanner scanner : fileScanners) {
			scanner.close();
		}
		/**
		Scanner input_file;
		try {
			input_file = new Scanner(new File(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return;
		}
		System.out.println("Successfully found file at: " + new File(fileName).getPath());
		window.println("Successfully found file at: " + new File(fileName).getPath());

		while (input_file.hasNext()) {
			String type = input_file.next();

			Object[] returnedList = null;

			switch (type) {
			case "mon":
				returnedList = pullMonBaseStats(input_file, ";");

				card_db.add(new monCard((String) ((Object[]) returnedList[0])[0],
						(Integer) ((Object[]) returnedList[0])[1], (monAttribute) returnedList[1],
						(monType) returnedList[2], (Type[]) returnedList[3], (String) ((Object[]) returnedList[0])[2],
						(Integer) returnedList[4], (Integer) returnedList[5], (Integer) returnedList[6]));
				break;
			case "fus":
			case "syn":
				returnedList = pullMonBaseStats(input_file, ";");

				card_db.add(new extraMonCard((String) ((Object[]) returnedList[0])[0],
						(Integer) ((Object[]) returnedList[0])[1], (monAttribute) returnedList[1],
						(monType) returnedList[2], (Type[]) returnedList[3], pullNextTextBlock(input_file, ";"),
						(String) ((Object[]) returnedList[0])[2], (Integer) returnedList[4], (Integer) returnedList[5],
						(Integer) returnedList[6]));
				break;
			case "xyz":
				returnedList = pullMonBaseStats(input_file, ";");

				card_db.add(new xyzMonCard((String) ((Object[]) returnedList[0])[0],
						(Integer) ((Object[]) returnedList[0])[1], (monAttribute) returnedList[1],
						(monType) returnedList[2], (Type[]) returnedList[3], pullNextTextBlock(input_file, ";"),
						(String) ((Object[]) returnedList[0])[2], (Integer) returnedList[4], (Integer) returnedList[5],
						(Integer) returnedList[6]));
				break;
			case "pen":
				returnedList = pullMonBaseStats(input_file, ";");

				card_db.add(new penMonCard((String) ((Object[]) returnedList[0])[0],
						(Integer) ((Object[]) returnedList[0])[1], (monAttribute) returnedList[1],
						(monType) returnedList[2], (Type[]) returnedList[3], pullNextTextBlock(input_file, ";"),
						(String) ((Object[]) returnedList[0])[2], (Integer) returnedList[4], input_file.nextInt(),
						(Integer) returnedList[5], (Integer) returnedList[6]));
				break;
			case "lnk":
				returnedList = pullMonBaseStats(input_file, ";");

				card_db.add(new linkMonCard((String) ((Object[]) returnedList[0])[0],
						(Integer) ((Object[]) returnedList[0])[1], (monAttribute) returnedList[1],
						(monType) returnedList[2], (Type[]) returnedList[3], pullNextTextBlock(input_file, ";"),
						(String) ((Object[]) returnedList[0])[2], (Integer) returnedList[5], (Integer) returnedList[6],
						(linkArrow[]) pullNextLinkArrowBlock(input_file, ";")));
				break;
			case "spl":
				returnedList = pullSTBaseStats(input_file, ";");

				card_db.add(new spellCard((String) ((Object[]) returnedList[0])[0],
						(Integer) ((Object[]) returnedList[0])[1], (String) ((Object[]) returnedList[0])[2],
						(Icon) returnedList[1]));
				break;
			case "trp":
				returnedList = pullSTBaseStats(input_file, ";");

				card_db.add(new trapCard((String) ((Object[]) returnedList[0])[0],
						(Integer) ((Object[]) returnedList[0])[1], (String) ((Object[]) returnedList[0])[2],
						(Icon) returnedList[1]));
				break;
			default:
				new Error("Type: " + type + " not found.").printStackTrace();
				break;
			}
		}
		input_file.close();
		**/
	}

	private static void buildFaL(String fileName) {
		Scanner input_file;
		try {
			input_file = new Scanner(new File(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return;
		}
		System.out.println("Successfully found file at: " + new File(fileName).getPath());
		window.println("Successfully found file at: " + new File(fileName).getPath());
		while (input_file.hasNext()) {
			fal_list.add(new int[] { input_file.nextInt(), input_file.nextInt() });
		}
		input_file.close();
	}
	
	private static void assignFaL() {
		for (Card card : card_db)
			for (int[] pair : fal_list)
				if (((Card) card).getIndex() == pair[0])
					((Card) card).setAllowedCopies(pair[1]);
	}

	private static void debugCheck() {
		card_db.sort(Comparator.comparing(Card::getAllowedCopies));
		Arrays.stream(card_db.toArray()).forEach(card -> System.out.println(card));
		
		Arrays.stream(card_db.toArray()).forEach(card -> window.println(card.toString() + "\n"));
	}
}
