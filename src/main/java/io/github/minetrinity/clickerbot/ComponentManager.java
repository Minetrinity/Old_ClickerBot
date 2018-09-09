package io.github.minetrinity.clickerbot;

import java.awt.Component;
import java.util.HashMap;

import io.github.minetrinity.clickerbot.windowcomponents.Addbutton;
import io.github.minetrinity.clickerbot.windowcomponents.Runbutton;
import io.github.minetrinity.clickerbot.windowcomponents.Text;
import io.github.minetrinity.clickerbot.windowcomponents.TextField;

public class ComponentManager {

	private HashMap<Type, Component> components = new HashMap<>();

	public void initializeComponentsMain(){
		components.put(Type.TEXT_TIMES_CLICKED, new Text("-Times Clicked: 0",125, 0, 200, 20));
		components.put(Type.TEXT_BOT_STATE, new Text("-Botstate: paused",125, 40-2, 200, 20));

		components.put(Type.TEXTFIELD_TIMES_TO_CLICK, new TextField("Times to repeat", 125, 200, 200, 20));

		components.put(Type.BUTTON_RUN, new Runbutton());
		
		components.put(Type.TEXTFIELD_ADD_X, new TextField("X", 5, 0, 133, 20));
		components.put(Type.TEXTFIELD_ADD_Y, new TextField("Y", 145, 0, 133, 20));
		components.put(Type.TEXTFIELD_ADD_DELAY, new TextField("Delay", 285, 0, 133, 20));
		components.put(Type.TEXTFIELD_LIST, new TextField("", 5, 70, 415, 495, false));
		components.put(Type.BUTTON_ADD, new Addbutton("Add", 10, 30, 400, 30));
	}

	public Component getComponent(Type type){
		return components.get(type);
	}
	
	public void setComponent(Type type, Component component) {
		this.components.put(type, component);
	}
	
	public enum Type{
		BUTTON_RUN,

		TEXTFIELD_TIMES_TO_CLICK,

		TEXTFIELD_ADD_X,
		TEXTFIELD_ADD_Y,
		TEXTFIELD_ADD_DELAY,
		BUTTON_ADD,
		TEXTFIELD_LIST,

		TEXT_TIMES_CLICKED,
		TEXT_BOT_STATE,

	}
}
