package ygo_eng.ui;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class CardUI extends JFrame{
	
	private static final long serialVersionUID = 8856255655978002135L;
	
	private JPanel cardPanel;
	
	public CardUI() {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		final int width = 59 * 5;
		final int height = 86 * 5;
		Dimension windowDim = new Dimension(width, height);
		setPreferredSize(windowDim);
		setMinimumSize(windowDim);
		setMaximumSize(windowDim);
		
		cardPanel = new JPanel();
		cardPanel.setPreferredSize(windowDim);
		cardPanel.setMinimumSize(windowDim);
		cardPanel.setMaximumSize(windowDim);
		add(cardPanel);
		cardPanel.setBackground(Card_bg.EFFECT.bg_c);
		
		setVisible(true);
	}
	
	public static void main (String args[]) {
		new CardUI();
	}

}
