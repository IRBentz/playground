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
		System.out.println("Success");
		while(input_file.hasNext()) {
			String type = input_file.next();
			switch (type) {
				case "mon":
				case "fus":
				case "syn":
				case "xyz":
					String nextString = input_file.next();
					String name = "";
					while(!nextString.equals(";")) {
						name += nextString + " ";
						nextString = input_file.next();
					}
					name = name.substring(0, name.length() - 1);
					
					int index = input_file.nextInt();
					
					monAttribute mon_attri = (monAttribute) stringConvert(input_file.next());
					
					monType mon_type = (monType) stringConvert(input_file.next());
					
					nextString = input_file.next();
					ArrayList<Type> types_list = new ArrayList<Type>();
					while(!nextString.equals(";")) {
						types_list.add((Type) stringConvert(nextString));
						nextString = input_file.next();
					}
					
					nextString = input_file.next();
					String lore = "";
					while(!nextString.equals(";")) {
						lore += nextString + " ";
						nextString = input_file.next();
					}
					lore = lore.substring(0, lore.length() - 1);
					
					int level = input_file.nextInt();
					
					int attack = input_file.nextInt();
					
					int defense = input_file.nextInt();
					
					database.add(new monCard(name, index, mon_attri, mon_type, types_list.toArray(new Type[types_list.size()]), lore, level, attack, defense));
					break;
				case "pen":
					
					break;
				case "lnk":
					
					break;
				case "spl":
					
					break;
				case "trp":
					
					break;
				default:
					System.err.println(type + " not found.");
					break;
			}
		}
		input_file.close();
		
		for(int i = 0; i < database.size(); i++) {
			System.out.println(database.get(i));
		}
	}
	
	private static Object stringConvert(String inputString) {
		for (int i = 0; i < monAttribute.class.getEnumConstants().length; i++)
			if(monAttribute.class.getEnumConstants()[i].toString().equals(inputString))
				return monAttribute.class.getEnumConstants()[i];
		
		for (int i = 0; i < monType.class.getEnumConstants().length; i++)
			if(monType.class.getEnumConstants()[i].toString().equals(inputString))
				return monType.class.getEnumConstants()[i];
		
		for (int i = 0; i < Type.class.getEnumConstants().length; i++)
			if(Type.class.getEnumConstants()[i].toString().equals(inputString))
				return Type.class.getEnumConstants()[i];
		
		for (int i = 0; i < Icon.class.getEnumConstants().length; i++)
			if(Icon.class.getEnumConstants()[i].toString().equals(inputString))
				return Icon.class.getEnumConstants()[i];
		
		for (int i = 0; i < link_arrow.class.getEnumConstants().length; i++)
			if(link_arrow.class.getEnumConstants()[i].toString().equals(inputString))
				return link_arrow.class.getEnumConstants()[i];
		
		new Error().printStackTrace();
		return null;
	}
}
