package io.github.minetrinity.clickerbot.windowcomponents;

import java.awt.event.ActionEvent;

import io.github.minetrinity.clickerbot.Bot;
import io.github.minetrinity.clickerbot.ComponentManager;
import io.github.minetrinity.clickerbot.Main;
import io.github.minetrinity.clickerbot.Bot.ClickingPoint;

public class Addbutton extends Button{

	public Addbutton(String text, int x, int y, int width, int height) {
		super(text, x, y, width, height);
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this) {
			String X = ((TextField) Main.dispList.cManager.getComponent(ComponentManager.Type.TEXTFIELD_ADD_X)).getText();
			String Y = ((TextField) Main.dispList.cManager.getComponent(ComponentManager.Type.TEXTFIELD_ADD_Y)).getText();
			String DELAY = ((TextField) Main.dispList.cManager.getComponent(ComponentManager.Type.TEXTFIELD_ADD_DELAY)).getText();
			try {
				int x = Integer.parseInt(X);
				int y = Integer.parseInt(Y);
				int delay = Integer.parseInt(DELAY);
				((TextField) Main.dispList.cManager.getComponent(ComponentManager.Type.TEXTFIELD_LIST)).setText(((TextField) Main.dispList.cManager.getComponent(ComponentManager.Type.TEXTFIELD_LIST)).getText() + x + " | " + y + " | " + delay + "\n");
				ClickingPoint point = new Bot.ClickingPoint();
				point.setDelayInSeconds(delay);
				point.setX(x);
				point.setY(y);
				Main.bot.addPoint(point);
			}catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		
	}

}
