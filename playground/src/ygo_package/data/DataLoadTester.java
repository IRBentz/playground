package ygo_package.data;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import ygo_package.Utils;
import ygo_package.card_package.*;


public class DataLoadTester {
	private Scanner[] FileScanners;
	public DataLoadTester() {
		try {
			FileScanners = new Scanner[] {new Scanner(new File("src//ygo_package//data//link_monster_new.data"))};
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.exit(1);
		}
		
		Scanner input = FileScanners[0];
		ArrayList<Card> cards = new ArrayList<Card>();
		/* Monster
		while (input.hasNext()) {
			cards.add(new monCard(
					input.nextLine(),
					(int) Integer.parseInt(input.nextLine()),
					(monAttribute) Utils.stringConvert(input.nextLine()),
					(monType) Utils.stringConvert(input.nextLine()),
					(Type[]) Utils.pullNextTypeBlock(input),
					input.nextLine(),
					(int) Integer.parseInt(input.nextLine()),
					(int) Integer.parseInt(input.nextLine()),
					(int) Integer.parseInt(input.nextLine())
					));
			input.nextLine();
		}
		*/
		/* Pendulum
		while (input.hasNext()) {
			cards.add(new penMonCard(
					input.nextLine(),
					(int) Integer.parseInt(input.nextLine()),
					(monAttribute) Utils.stringConvert(input.nextLine()),
					(monType) Utils.stringConvert(input.nextLine()),
					(Type[]) Utils.pullNextTypeBlock(input),
					input.nextLine(),
					input.nextLine(),
					(int) Integer.parseInt(input.nextLine()),
					(int) Integer.parseInt(input.nextLine()),
					(int) Integer.parseInt(input.nextLine()),
					(int) Integer.parseInt(input.nextLine())
					));
			input.nextLine();
		}
		*/
		/*Fusion and Synchro Monster
		while(input.hasNextLine()) {
			cards.add(new extraMonCard(
					input.nextLine(), (int) Integer.parseInt(input.nextLine()),
					(monAttribute) Utils.stringConvert(input.nextLine()),
					(monType) Utils.stringConvert(input.nextLine()),
					(Type[]) Utils.pullNextTypeBlock(input),
					input.nextLine(),
					input.nextLine(),
					(int) Integer.parseInt(input.nextLine()),
					(int) Integer.parseInt(input.nextLine()),
					(int) Integer.parseInt(input.nextLine())
					));
			input.nextLine();
		}
		*/
		/* XYZ
		while (input.hasNext()) {
			cards.add(new xyzMonCard(
					input.nextLine(), (int) Integer.parseInt(input.nextLine()),
					(monAttribute) Utils.stringConvert(input.nextLine()),
					(monType) Utils.stringConvert(input.nextLine()),
					(Type[]) Utils.pullNextTypeBlock(input),
					input.nextLine(),
					input.nextLine(),
					(int) Integer.parseInt(input.nextLine()),
					(int) Integer.parseInt(input.nextLine()),
					(int) Integer.parseInt(input.nextLine())
					));
			input.nextLine();
		}
		*/
		/* Link
		while (input.hasNextLine()) {
			cards.add(new linkMonCard(
					input.nextLine(), (int) Integer.parseInt(input.nextLine()),
					(monAttribute) Utils.stringConvert(input.nextLine()),
					(monType) Utils.stringConvert(input.nextLine()),
					(Type[]) Utils.pullNextTypeBlock(input),
					input.nextLine(),
					input.nextLine(),
					(int) Integer.parseInt(input.nextLine()),
					(int) Integer.parseInt(input.nextLine()),
					(linkArrow[]) Utils.pullNextLinkArrowBlock(input)
					));
			input.nextLine();
		}
		*/
		/* Spell
		while(input.hasNextLine()) {
			cards.add(new spellCard(
					input.nextLine(),
					(int) Integer.parseInt(input.nextLine()),
					input.nextLine(),
					(Icon) Utils.stringConvert(input.nextLine())
					));
			input.nextLine();
		}
		*/
		/* Trap
		while(input.hasNextLine()) {
			cards.add(new trapCard(
					input.nextLine(),
					(int) Integer.parseInt(input.nextLine()),
					input.nextLine(),
					(Icon) Utils.stringConvert(input.nextLine())
					));
			input.nextLine();
		}
		*/
		for (Card card : cards) {
			System.out.println(card);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DataLoadTester DLT = new DataLoadTester();
	}

}
