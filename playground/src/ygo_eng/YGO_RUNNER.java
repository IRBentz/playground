package ygo_eng;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class YGO_RUNNER {

	public static void main(String[] args) {
		QueDB_Builder.queUser();
	}
}

class QueDB_Builder implements KeyListener {
	private static JTextField textField;
	private static JFrame frame;

	public static void queUser() {
		frame = new JFrame("Use new backend? y/n");
		textField = new JTextField(20);
		textField.addKeyListener(new QueDB_Builder());
		frame.add(textField);
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		if (e.getKeyChar() == 'y') {
			Backend.useNew = true;
			Backend.start("src//ygo_eng//file_pointers_new.txt");
			frame.setVisible(false);
		} else if (e.getKeyChar() == 'n') {
			Backend.start("src//ygo_eng//file_pointers.txt");
			frame.setVisible(false);
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}
}
