package io.github.minetrinity.clickerbot.windowcomponents;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JToggleButton;

import io.github.minetrinity.clickerbot.Main;

public class Runbutton extends JToggleButton implements ItemListener {

	public Runbutton(){
		setText("Start");
		addItemListener(this);
		setBounds(0,0,110,250);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if(e.getSource() == this){
			if(e.getStateChange() == ItemEvent.SELECTED){
				setText("Stop");
				Main.bot.resume();
			}else if(e.getStateChange() == ItemEvent.DESELECTED){
				setText("Start");
				Main.bot.pause();
			}
		}
	}
}
