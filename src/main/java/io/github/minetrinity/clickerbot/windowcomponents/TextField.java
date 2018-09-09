package io.github.minetrinity.clickerbot.windowcomponents;

import javax.swing.*;

public class TextField  extends JTextArea {

	public TextField(String text, int x, int y, int width, int height) {
		setBounds(x,y,width,height);
		setText(text);
		setEditable(true);
	}
	
	public TextField(String text, int x, int y, int width, int height, boolean editable) {
		setBounds(x,y,width,height);
		setText(text);
		setEditable(editable);
	}

}
