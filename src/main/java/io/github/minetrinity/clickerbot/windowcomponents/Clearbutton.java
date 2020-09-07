package io.github.minetrinity.clickerbot.windowcomponents;

import java.awt.event.ActionEvent;

import io.github.minetrinity.clickerbot.ComponentManager;
import io.github.minetrinity.clickerbot.Main;

public class Clearbutton extends Button {

	public Clearbutton(String text, int x, int y, int width, int height) {
		super(text, x, y, width, height);
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() ==this) {
			Main.bot.clearPoints();
			((TextField)Main.dispList.cManager.getComponent(ComponentManager.Type.TEXTFIELD_LIST)).setText("");;
		}
		
	}

}
