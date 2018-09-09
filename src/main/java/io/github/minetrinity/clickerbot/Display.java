package io.github.minetrinity.clickerbot;

import io.github.minetrinity.clickerbot.windowcomponents.TextField;

import javax.swing.*;
import java.awt.KeyboardFocusManager;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Display extends JFrame {

	public ComponentManager cManager = new ComponentManager();

	public Display() {
		cManager.initializeComponentsMain();
	}
	
	public void mainDisplay() {
		KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyManager());
		getContentPane().add(cManager.getComponent(ComponentManager.Type.BUTTON_RUN));
		getContentPane().add(cManager.getComponent(ComponentManager.Type.TEXT_TIMES_CLICKED));
		getContentPane().add(cManager.getComponent(ComponentManager.Type.TEXT_BOT_STATE));
		getContentPane().add(cManager.getComponent(ComponentManager.Type.TEXTFIELD_TIMES_TO_CLICK));
		setLayout(null);
		setTitle("Clicker Bot");
		setSize(new Dimension(500, 400));
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setResizable(false);
		setAlwaysOnTop(true);
		setFocusable(true);
		setLocationRelativeTo(null);
	}
	
	public void pointListDisplay() {
		getContentPane().add(cManager.getComponent(ComponentManager.Type.TEXTFIELD_ADD_X));
		getContentPane().add(cManager.getComponent(ComponentManager.Type.TEXTFIELD_ADD_Y));
		getContentPane().add(cManager.getComponent(ComponentManager.Type.TEXTFIELD_ADD_DELAY));
		getContentPane().add(cManager.getComponent(ComponentManager.Type.TEXTFIELD_LIST));
		getContentPane().add(cManager.getComponent(ComponentManager.Type.BUTTON_ADD));
		JMenuBar bar = new JMenuBar();
		JMenu menu = new JMenu("Edit");
		JMenuItem clearItem = new JMenuItem("Clear");
		clearItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == clearItem) {
					(( TextField ) cManager.getComponent(ComponentManager.Type.TEXTFIELD_LIST)).setText("");
					getContentPane().add(cManager.getComponent(ComponentManager.Type.TEXTFIELD_LIST));
					Main.bot.clearPoints();
				}
			}
		});
		menu.add(clearItem);
		bar.add(menu);
		setJMenuBar(bar);
		setLayout(null);
		setTitle("Points to click");
		setSize(new Dimension(430, 600));
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setResizable(false);
		setAlwaysOnTop(true);
		setFocusable(true);
		setLocationRelativeTo(null);
	}

	public void create() {
		setVisible(true);
	}


}
