package io.github.minetrinity.clickerbot;

import java.awt.AWTException;

public class Main {

	public static Bot bot;
	public static Display dispMain = new Display();
	public static Display dispList = new Display();

	public static void main(String[] args) {
		dispMain.mainDisplay();
		dispList.pointListDisplay();
		dispList.create();
		dispMain.create();
		try {
			bot = new Bot();
			bot.start();
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}


}
