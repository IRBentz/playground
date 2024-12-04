package ygo_package;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

public abstract class Backend {
	private static ArrayList<Card> card_db = new ArrayList<Card>();
	private static ArrayList<int[]> fal_list = new ArrayList<int[]>();
	private static OutputWindow window = new OutputWindow();

	private static void assignFaL() {
		for (Card card : card_db)
			for (int[] pair : fal_list)
				if (((Card) card).getIndex() == pair[0])
					((Card) card).setAllowedCopies(pair[1]);
	}

	private static void buildDB(String fileName) {
		Scanner input_file;
		try {
			input_file = new Scanner(new File(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return;
		}
		System.out.println("Successfully found file at: " + new File(fileName).getPath());
		window.println("Succesfully found file at: " + new File(fileName).getPath());

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

	private static void debugCheck() {
		card_db.sort(Comparator.comparing(Card::getAllowedCopies));
		Arrays.stream(card_db.toArray()).forEach(card -> System.out.println(card));
		
		Arrays.stream(card_db.toArray()).forEach(card -> window.println(card.toString() + "\n"));
	}

	private static Object[] pullBaseStats(Scanner target_scanner, String delimiter) {
		return new Object[] { pullNextTextBlock(target_scanner, delimiter), target_scanner.nextInt(),
				pullNextTextBlock(target_scanner, delimiter) };
	}

	private static Object[] pullMonBaseStats(Scanner target_scanner, String delimiter) {
		return new Object[] { pullBaseStats(target_scanner, delimiter), stringConvert(target_scanner.next()),
				stringConvert(target_scanner.next()), (Type[]) pullNextTypeBlock(target_scanner, ";"), target_scanner.nextInt(),
				target_scanner.nextInt(), target_scanner.nextInt() };
	}
	

	private static linkArrow[] pullNextLinkArrowBlock(Scanner target_scanner, String delimiter) {
		ArrayList<linkArrow> linkArrow_list = new ArrayList<linkArrow>();
		String nextString = target_scanner.next();
		while (!nextString.equals(delimiter)) {
			linkArrow_list.add((linkArrow) stringConvert(nextString));
			nextString = target_scanner.next();
		}

		return linkArrow_list.toArray(new linkArrow[linkArrow_list.size()]);
	}

	private static String pullNextTextBlock(Scanner target_scanner, String delimiter) {
		String nextString = target_scanner.next();
		String return_string = "";
		while (!nextString.equals(delimiter)) {
			return_string += nextString + " ";
			nextString = target_scanner.next();
		}

		return return_string.substring(0, return_string.length() - 1);
	}

	private static Type[] pullNextTypeBlock(Scanner target_scanner, String delimiter) {
		ArrayList<Type> types_list = new ArrayList<Type>();
		String nextString = target_scanner.next();
		while (!nextString.equals(delimiter)) {
			types_list.add((Type) stringConvert(nextString));
			nextString = target_scanner.next();
		}

		return types_list.toArray(new Type[types_list.size()]);
	}

	private static Object[] pullSTBaseStats(Scanner target_scanner, String delimiter) {
		return new Object[] { pullBaseStats(target_scanner, delimiter), stringConvert(target_scanner.next()) };
	}

	public static void start(String db_fileName, String fal_fileName) {
		buildDB(db_fileName);
		buildFaL(fal_fileName);
		assignFaL();
		debugCheck();
	}

	private static Object stringConvert(String inputString) {
		for (monAttribute target_enum : monAttribute.class.getEnumConstants())
			if (target_enum.toString().equals(inputString))
				return target_enum;

		for (monType target_enum : monType.class.getEnumConstants())
			if (target_enum.toString().equals(inputString))
				return target_enum;

		for (Type target_enum : Type.class.getEnumConstants())
			if (target_enum.toString().equals(inputString))
				return target_enum;

		for (cardType target_enum : cardType.class.getEnumConstants())
			if (target_enum.toString().equals(inputString))
				return target_enum;

		for (Icon target_enum : Icon.class.getEnumConstants())
			if (target_enum.toString().equals(inputString))
				return target_enum;

		for (linkArrow target_enum : linkArrow.class.getEnumConstants())
			if (target_enum.toString().equals(inputString))
				return target_enum;

		new Error("Target Enum: " + inputString + " not found.").printStackTrace();
		return null;
	}
}


class OutputWindow extends JFrame {

	private static final long serialVersionUID = 6720686700487402244L;
	
	private JPanel mainPanel = new JPanel(new GridLayout());
	private JTextArea mainTextArea = new JTextArea(1, 1);
	private JScrollPane mainScroll = new JScrollPane(mainPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	private String mainText = "";
	private final String printIden = "%PLN%";
	
	public OutputWindow() {
		setTitle("Output Window");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		final int width = 1200;
		final int height = 800;
		Dimension windowDim = new Dimension(width, height);
		setPreferredSize(windowDim);
		setMinimumSize(windowDim);
		setMaximumSize(windowDim);
		

		mainTextArea.setLineWrap(true);
		mainTextArea.setWrapStyleWord(true);
		mainTextArea.setFont(new Font("Consolas", 0, 12));
		mainTextArea.setForeground(new Color(200, 200, 200));
		
		mainPanel.add(mainTextArea);
		mainTextArea.setBackground(new Color(50, 50, 50));
		mainPanel.setBackground(mainTextArea.getBackground());
		add(mainScroll);
		pack();
		
		setVisible(true);
		
		/*
		for(Card card: Backend.card_db) {
			mainText += card.toString() + "\n\n";
			mainTextArea.setText(mainText);
		}
		mainText = mainText.substring(0, mainText.length() - 4);
		
		mainTextArea.setText(mainText);
		*/
	}
	
	public void println(String newText, boolean print_to_system) {
		print(printIden + newText + "\n", print_to_system);
	}
	
	public void println(String text) {
		println(text, false);
	}
	
	public void print(String newText, boolean print_to_system) {
		if(newText.substring(0, printIden.length()).equals(printIden))
			newText = newText.substring(printIden.length());
		if(print_to_system)
			System.out.print(newText);

		mainText += newText;
		mainTextArea.setText(mainText);
	}
	
	public void print(String text) {
		print(text, false);
	}
}
