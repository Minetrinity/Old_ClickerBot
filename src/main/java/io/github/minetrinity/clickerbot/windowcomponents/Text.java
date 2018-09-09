package io.github.minetrinity.clickerbot.windowcomponents;

import javax.swing.*;


public class Text extends JTextArea {

	public Text(String text, int x, int y, int width, int height){
		setBounds(x,y,width,height);
		setText(text);
		setEditable(false);
	}

	public Text(int x, int y, int width, int height){
		setBounds(x,y,width,height);
	}

}
