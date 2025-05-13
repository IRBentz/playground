package ygo_package.data;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import ygo_package.Utils;
import ygo_package.card_package.*;


public class DataLoadTester {
	public DataLoadTester() {
		Scanner pointerFileScanner;
		try {
			pointerFileScanner = new Scanner(new File("src//ygo_package//file_pointers_new.txt"));
			System.out.println("Found file at: " + new File("src//ygo_package//file_pointers_new.txt").getPath());
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
		Scanner input = fileScanners.get(0);
		ArrayList<Card> cards = new ArrayList<Card>();
		Object[] baseStats;
		//* Monster
		while (input.hasNext()) {
			baseStats = Utils.pullMonBaseStats(input);
			cards.add(new monCard(
					(String) ((Object[]) baseStats[0])[0],
					(int) ((Object[]) baseStats[0])[1],
					(monAttribute) baseStats[1],
					(monType) baseStats[2],
					(Type[]) baseStats[3],
					input.nextLine(),
					(int) Integer.parseInt(input.nextLine()),
					(int) Integer.parseInt(input.nextLine()),
					(int) Integer.parseInt(input.nextLine())
					));
			input.nextLine();
			baseStats = null;
		}
		//*/
		//* Pendulum
		input = fileScanners.get(1);
		while (input.hasNext()) {
			baseStats = Utils.pullMonBaseStats(input);
			cards.add(new penMonCard(
					(String) ((Object[]) baseStats[0])[0],
					(int) ((Object[]) baseStats[0])[1],
					(monAttribute) baseStats[1],
					(monType) baseStats[2],
					(Type[]) baseStats[3],
					input.nextLine(),
					input.nextLine(),
					(int) Integer.parseInt(input.nextLine()),
					(int) Integer.parseInt(input.nextLine()),
					(int) Integer.parseInt(input.nextLine()),
					(int) Integer.parseInt(input.nextLine())
					));
			input.nextLine();
			baseStats = null;
		}
		//*/
		//*Fusion and Synchro Monster
		for(int i = 2; i < 4; i++) {
			input = fileScanners.get(i);
			while(input.hasNextLine()) {
				baseStats = Utils.pullMonBaseStats(input);
				cards.add(new extraMonCard(
						(String) ((Object[]) baseStats[0])[0],
						(int) ((Object[]) baseStats[0])[1],
						(monAttribute) baseStats[1],
						(monType) baseStats[2],
						(Type[]) baseStats[3],
						input.nextLine(),
						input.nextLine(),
						(int) Integer.parseInt(input.nextLine()),
						(int) Integer.parseInt(input.nextLine()),
						(int) Integer.parseInt(input.nextLine())
						));
				input.nextLine();
				baseStats = null;
			}
		}
		//*/
		//* XYZ
		input = fileScanners.get(4);
		while (input.hasNext()) {
			baseStats = Utils.pullMonBaseStats(input);
			cards.add(new xyzMonCard(
					(String) ((Object[]) baseStats[0])[0],
					(int) ((Object[]) baseStats[0])[1],
					(monAttribute) baseStats[1],
					(monType) baseStats[2],
					(Type[]) baseStats[3],
					input.nextLine(),
					input.nextLine(),
					(int) Integer.parseInt(input.nextLine()),
					(int) Integer.parseInt(input.nextLine()),
					(int) Integer.parseInt(input.nextLine())
					));
			input.nextLine();
			baseStats = null;
		}
		//*/
		//* Link
		input = fileScanners.get(5);
		while (input.hasNextLine()) {
			baseStats = Utils.pullMonBaseStats(input);
			cards.add(new linkMonCard(
					(String) ((Object[]) baseStats[0])[0],
					(int) ((Object[]) baseStats[0])[1],
					(monAttribute) baseStats[1],
					(monType) baseStats[2],
					(Type[]) baseStats[3],
					input.nextLine(),
					input.nextLine(),
					(int) Integer.parseInt(input.nextLine()),
					(int) Integer.parseInt(input.nextLine()),
					(linkArrow[]) Utils.pullNextLinkArrowBlock(input)
					));
			input.nextLine();
			baseStats = null;
		}
		//*/
		//* Spell
		input = fileScanners.get(6);
		while(input.hasNextLine()) {
			baseStats = Utils.pullSTBaseStats(input);
			cards.add(new spellCard(
					(String) ((Object[]) baseStats[0])[0],
					(int) ((Object[]) baseStats[0])[1],
					(String) baseStats[1],
					(Icon) baseStats[2]
					));
			input.nextLine();
			baseStats = null;
		}
		//*/
		//* Trap
		input = fileScanners.get(7);
		while(input.hasNextLine()) {
			baseStats = Utils.pullSTBaseStats(input);
			cards.add(new trapCard(
					(String) ((Object[]) baseStats[0])[0],
					(int) ((Object[]) baseStats[0])[1],
					(String) baseStats[1],
					(Icon) baseStats[2]
					));
			input.nextLine();
			baseStats = null;
		}
		//*/
		for (Card card : cards) {
			System.out.println(card);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DataLoadTester DLT = new DataLoadTester();
	}

}
