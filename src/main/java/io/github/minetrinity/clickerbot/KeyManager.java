package io.github.minetrinity.clickerbot;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyEventDispatcher  {
	
	public boolean dispatchKeyEvent(KeyEvent e) {
		if((e.getKeyCode() == KeyEvent.VK_P || e.getKeyChar() == 'p' || e.getKeyChar() == 'P') && e.getID() == KeyEvent.KEY_TYPED){
			switch(Main.bot.getSTATE()){
				case RUNNING:
					Main.bot.pause();
					break;

				case PAUSED:
					Main.bot.resume();
					break;

				default:
					break;
			}
		}
		return false;
	}
}
