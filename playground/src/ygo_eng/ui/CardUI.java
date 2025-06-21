package ygo_eng.ui;

import java.awt.Image;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CardUI extends JFrame{
	
	private static final long serialVersionUID = 8856255655978002135L;
	private static ArrayList<ImageIcon> cardBG_II = new ArrayList<>();
	private JPanel cardPanel;
	private int factor;
	
	public CardUI() {
		factor = 4;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//ImageIcon ii = new ImageIcon("src//ygo_eng//card//card_png//effect.png");
		cardPanel = new JPanel();
		add(cardPanel);
		//JLabel jl = new JLabel(ii);
		//cardPanel.add(jl);
		pack();
		setVisible(true);
	}
	
	public void setCardBG(ImageIcon image) {
		cardPanel.add(new JLabel(new ImageIcon(image.getImage().getScaledInstance(59 * factor, 86 * factor, Image.SCALE_SMOOTH))));
		pack();
	}
	
	public static void buildCardBG_II(String pointerFileName) {
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
		while (pointerFileScanner.hasNext()) {
			cardBG_II.add(new ImageIcon(filePath + pointerFileScanner.nextLine()));
		}
		
		pointerFileScanner.close();
	}
	
	public static void main (String args[]) {
		//new CardUI();
		CardUI.buildCardBG_II("src//ygo_eng//ui//png_pointers.txt");
		Arrays.stream(cardBG_II.toArray()).forEach(image -> new CardUI().setCardBG((ImageIcon) image));
	}

}
