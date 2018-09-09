package io.github.minetrinity.clickerbot.windowcomponents;

import javax.swing.*;

import java.awt.event.ActionListener;

public abstract class Button extends JButton implements ActionListener {

	public Button(String text, int x, int y, int width, int height) {
		setBounds(x,y,width,height);
		setText(text);
	}
}
