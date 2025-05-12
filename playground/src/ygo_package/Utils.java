package ygo_package;

import java.util.ArrayList;
import java.util.Scanner;

import ygo_package.card_package.*;

public abstract class Utils {
	public static Object[] pullBaseStats(Scanner target_scanner, String delimiter) {
		return new Object[] { pullNextTextBlock(target_scanner, delimiter), target_scanner.nextInt(),
				pullNextTextBlock(target_scanner, delimiter) };
	}

	public static Object[] pullMonBaseStats(Scanner target_scanner, String delimiter) {
		return new Object[] { pullBaseStats(target_scanner, delimiter), stringConvert(target_scanner.next()),
				stringConvert(target_scanner.next()), (Type[]) pullNextTypeBlock(target_scanner, ";"), target_scanner.nextInt(),
				target_scanner.nextInt(), target_scanner.nextInt() };
	}
	
	public static linkArrow[] pullNextLinkArrowBlock(Scanner target_scanner, String delimiter) {
		ArrayList<linkArrow> linkArrow_list = new ArrayList<linkArrow>();
		String nextString = target_scanner.next();
		while (!nextString.equals(delimiter)) {
			linkArrow_list.add((linkArrow) stringConvert(nextString));
			nextString = target_scanner.next();
		}

		return linkArrow_list.toArray(new linkArrow[linkArrow_list.size()]);
	}

	public static String pullNextTextBlock(Scanner target_scanner, String delimiter) {
		String nextString = target_scanner.next();
		String return_string = "";
		while (!nextString.equals(delimiter)) {
			return_string += nextString + " ";
			nextString = target_scanner.next();
		}

		return return_string.substring(0, return_string.length() - 1);
	}

	public static Type[] pullNextTypeBlock(Scanner target_scanner, String delimiter) {
		ArrayList<Type> types_list = new ArrayList<Type>();
		String nextString = target_scanner.next();
		while (!nextString.equals(delimiter)) {
			types_list.add((Type) stringConvert(nextString));
			nextString = target_scanner.next();
		}

		return types_list.toArray(new Type[types_list.size()]);
	}

	public static Object[] pullSTBaseStats(Scanner target_scanner, String delimiter) {
		return new Object[] { pullBaseStats(target_scanner, delimiter), stringConvert(target_scanner.next()) };
	}

	public static Object stringConvert(String inputString) {
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

		new Error("Enum for \"" + inputString + "\" could not be found.").printStackTrace();
		System.exit(1);
		return null;
	}
	
	/*
	 * Delimiter-less Methods
	 */
	public static Object[] pullBaseStats(Scanner target_scanner) {
		return new Object[] { pullNextTextBlock(target_scanner), target_scanner.nextInt(),
				pullNextTextBlock(target_scanner) };
	}

	public static Object[] pullMonBaseStats(Scanner target_scanner) {
		return new Object[] { pullBaseStats(target_scanner), stringConvert(target_scanner.next()),
				stringConvert(target_scanner.next()), (Type[]) pullNextTypeBlock(target_scanner, ";"), target_scanner.nextInt(),
				target_scanner.nextInt(), target_scanner.nextInt() };
	}
	
	public static linkArrow[] pullNextLinkArrowBlock(Scanner target_scanner) {
		ArrayList<linkArrow> linkArrow_list = new ArrayList<linkArrow>();
		String nextString = target_scanner.next();
		while (!nextString.equals("~")) {
			linkArrow_list.add((linkArrow) stringConvert(nextString));
			nextString = target_scanner.next();
		}

		return linkArrow_list.toArray(new linkArrow[linkArrow_list.size()]);
	}

	public static String pullNextTextBlock(Scanner target_scanner) {
		String return_string = target_scanner.nextLine();
		
		return return_string.substring(0, return_string.length() - 1);
	}

	public static Type[] pullNextTypeBlock(Scanner target_scanner) {
		String[] input = target_scanner.nextLine().split(" ");
		ArrayList<Type> types_list = new ArrayList<Type>();
		for(String in : input) {
			types_list.add((Type) stringConvert(in));
		}
		return types_list.toArray(new Type[types_list.size()]);
	}

	public static Object[] pullSTBaseStats(Scanner target_scanner) {
		return new Object[] { pullBaseStats(target_scanner), stringConvert(target_scanner.next()) };
	}
}

