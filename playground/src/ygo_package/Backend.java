package ygo_package;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class Backend {
	public static ArrayList<Card> database = new ArrayList<Card>();
	
	public static void start(String fileName) {
		buildDB(fileName);
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
		
		while(input_file.hasNext()) {
			String type = input_file.next();
			
			Object[] returnedList = null;
			
			switch (type) {
				case "mon":
				case "fus":
				case "syn":
				case "xyz":
					returnedList = pullMonBaseStats(input_file, ";");
					
					database.add(
							new monCard((String) ((Object[]) returnedList[0])[0], 
									(Integer) ((Object[]) returnedList[0])[1], 
									cardType.MONSTER, 
									(monAttribute) returnedList[1], 
									(monType) returnedList[2], 
									(Type[]) returnedList[3], 
									(String) ((Object[]) returnedList[0])[2], 
									(Integer) returnedList[4], 
									(Integer) returnedList[5], 
									(Integer) returnedList[6]));
					break;
				case "pen":
					returnedList = pullMonBaseStats(input_file, ";");
					
					database.add(
							new penMonCard(
									(String) ((Object[]) returnedList[0])[0], 
									(Integer) ((Object[]) returnedList[0])[1], 
									cardType.MONSTER, 
									(monAttribute) returnedList[1], 
									(monType) returnedList[2], 
									(Type[]) returnedList[3], 
									pullNextTextBlock(input_file, ";"), 
									(String) ((Object[]) returnedList[0])[2], 
									(Integer) returnedList[4], 
									input_file.nextInt(), 
									(Integer) returnedList[5], 
									(Integer) returnedList[6]));
					break;				
				case "lnk":
					returnedList = pullMonBaseStats(input_file, ";");
					
					database.add(
							new linkMonCard(
									(String) ((Object[]) returnedList[0])[0],
									(Integer) ((Object[]) returnedList[0])[1], 
									cardType.MONSTER, 
									(monAttribute) returnedList[1], 
									(monType) returnedList[2], 
									(Type[]) returnedList[3],
									(String) ((Object[]) returnedList[0])[2],
									(Integer) returnedList[5], 
									(Integer) returnedList[6],
									input_file.nextInt(),
									pullNextLinkArrowBlock(input_file, ";")
									));
					break;
				case "spl":
					returnedList = pullSTBaseStats(input_file, ";");
					
					database.add(
							new spellCard(
									(String) ((Object[]) returnedList[0])[0], 
									(Integer) ((Object[]) returnedList[0])[1], 
									cardType.SPELL,
									(String) ((Object[]) returnedList[0])[2],
									(Icon) returnedList[1]));
					break;
				case "trp":
					returnedList = pullSTBaseStats(input_file, ";");
					
					database.add(
							new trapCard(
									(String) ((Object[]) returnedList[0])[0], 
									(Integer) ((Object[]) returnedList[0])[1], 
									cardType.TRAP,
									(String) ((Object[]) returnedList[0])[2],
									(Icon) returnedList[1]));
					break;
				default:
					new Error("Type: " + type + " not found.").printStackTrace();
					break;
			}
		}
		input_file.close();
		
		for(int i = 0; i < database.size(); i++) {
			System.out.println(database.get(i));
		}
	}
	
	private static Object[] pullBaseStats(Scanner target_scanner, String delimiter) {
		return new Object[] {pullNextTextBlock(target_scanner, delimiter), target_scanner.nextInt(), pullNextTextBlock(target_scanner, delimiter)};
	}
	
	private static Object[] pullMonBaseStats(Scanner target_scanner, String delimiter) {
		return new Object[] {pullBaseStats(target_scanner, delimiter), stringConvert(target_scanner.next()), stringConvert(target_scanner.next()), pullNextTypeBlock(target_scanner, ";"), target_scanner.nextInt(), target_scanner.nextInt(), target_scanner.nextInt()};
	}
	
	private static Object[] pullSTBaseStats(Scanner target_scanner, String delimiter) {
		return new Object[] {pullBaseStats(target_scanner, delimiter), stringConvert(target_scanner.next())};
	}
	
	private static String pullNextTextBlock(Scanner target_scanner, String delimiter) {
		String nextString = target_scanner.next();
		String return_string = "";
		while(!nextString.equals(delimiter)) {
			return_string += nextString + " ";
			nextString = target_scanner.next();
		}
		
		return return_string.substring(0, return_string.length() - 1);
	}
	
	private static Type[] pullNextTypeBlock(Scanner target_scanner, String delimiter) {
		ArrayList<Type> types_list = new ArrayList<Type>();
		String nextString = target_scanner.next();
		while(!nextString.equals(delimiter)) {
			types_list.add((Type) stringConvert(nextString));
			nextString = target_scanner.next();
		}
		
		return types_list.toArray(new Type[types_list.size()]);
	}
	
	private static linkArrow[] pullNextLinkArrowBlock(Scanner target_scanner, String delimiter) {
		ArrayList<linkArrow> linkArrow_list = new ArrayList<linkArrow>();
		String nextString = target_scanner.next();
		while(!nextString.equals(delimiter)) {
			linkArrow_list.add((linkArrow) stringConvert(nextString));
			nextString = target_scanner.next();
		}
		
		return linkArrow_list.toArray(new linkArrow[linkArrow_list.size()]);
	}
	
	private static Object stringConvert(String inputString) {
		for (monAttribute target_enum : monAttribute.class.getEnumConstants())
			if(target_enum.toString().equals(inputString))
				return target_enum;
		
		for (monType target_enum : monType.class.getEnumConstants())
			if(target_enum.toString().equals(inputString))
				return target_enum;
		
		for (Type target_enum : Type.class.getEnumConstants())
			if(target_enum.toString().equals(inputString))
				return target_enum;
		
		for (cardType target_enum : cardType.class.getEnumConstants())
			if(target_enum.toString().equals(inputString))
				return target_enum;
		
		for (Icon target_enum : Icon.class.getEnumConstants())
			if(target_enum.toString().equals(inputString))
				return target_enum;
		
		for (linkArrow target_enum : linkArrow.class.getEnumConstants())
			if(target_enum.toString().equals(inputString))
				return target_enum;
		
		
		new Error("Target Enum: " + inputString + " not found.").printStackTrace();
		return null;
	}
}
