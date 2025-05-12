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
			FileScanners = new Scanner[] {new Scanner(new File("src//ygo_package//data//fusion_monster_new.data"))};
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.exit(1);
		}
		
		Scanner input = FileScanners[0];
		ArrayList<Card> cards = new ArrayList<Card>();
		while(input.hasNextLine()) {
			cards.add(new extraMonCard(
					input.nextLine(), (int) Integer.parseInt(input.nextLine()),
					(monAttribute) Utils.stringConvert(input.nextLine()),
					(monType) Utils.stringConvert(input.nextLine()),
					(Type[]) Utils.pullNextTypeBlock(input), input.nextLine(),
					input.nextLine(), input.nextInt(), input.nextInt(), input.nextInt()));
			input.nextLine();
			input.nextLine();
		}
		for (Card card : cards) {
			System.out.println(card);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DataLoadTester DLT = new DataLoadTester();
	}

}
