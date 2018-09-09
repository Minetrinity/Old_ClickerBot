package io.github.minetrinity.clickerbot;

import io.github.minetrinity.clickerbot.windowcomponents.Runbutton;
import io.github.minetrinity.clickerbot.windowcomponents.Text;

import java.awt.*;
import java.awt.event.InputEvent;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

public class Bot implements Runnable {
	
	private Robot robot;
	
	private Thread trd = new Thread(this);
	private STATE state = STATE.STOPED;
	
	private CopyOnWriteArrayList<ClickingPoint> points = new CopyOnWriteArrayList<>();
	private int timesClicked = 0;
	
	public Bot() throws AWTException {
		robot = new Robot();
	}
	
	public synchronized void start() throws IllegalThreadStateException {
		this.state = STATE.PAUSED;
		if (!trd.isAlive())
			trd.start();
	}
	
	public void pause() {
		setSTATE(STATE.PAUSED);
		(( Text ) Main.dispMain.cManager.getComponent(ComponentManager.Type.TEXT_BOT_STATE)).setText("Botstate: paused");
		(( Runbutton ) Main.dispMain.cManager.getComponent(ComponentManager.Type.BUTTON_RUN)).setSelected(false);
	}
	
	public void resume() {
		setSTATE(STATE.RUNNING);
		(( Text ) Main.dispMain.cManager.getComponent(ComponentManager.Type.TEXT_BOT_STATE)).setText("Botstate: running");
		(( Runbutton ) Main.dispMain.cManager.getComponent(ComponentManager.Type.BUTTON_RUN)).setSelected(true);
	}
	
	public void run() {
		while (state != STATE.STOPED) {
			for (ClickingPoint point : points) {
				if (this.state == STATE.RUNNING)
					point.handle(robot);
				
			}
		}
	}
	
	public STATE getSTATE() {
		return state;
	}
	
	public void setSTATE(STATE state) {
		this.state = state;
	}
	
	public int getTimesClicked() {
		return timesClicked;
	}
	
	public void addPoint(ClickingPoint point) {
		points.add(point);
	}
	
	public void clearPoints() {
		points.clear();
	}
	
	public enum STATE {
		RUNNING, PAUSED, STOPED;
	}
	
	public static class ClickingPoint {
		private int delayInSeconds = 0;
		private int x;
		private int y;
		
		public int getDelayInSeconds() {
			return delayInSeconds;
		}
		
		public void setDelayInSeconds(int delayInSeconds) {
			this.delayInSeconds = delayInSeconds;
		}
		
		public int getX() {
			return x;
		}
		
		public void setX(int x) {
			this.x = x;
		}
		
		public int getY() {
			return y;
		}
		
		public void setY(int y) {
			this.y = y;
		}
		
		public void move(Robot bot) {
			bot.mouseMove(x, y);
		}
		
		public void handle(Robot bot) {
			bot.mouseMove(x, y);
			bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
			bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
			for (int i = 0; i < delayInSeconds; i++) {
				bot.delay(1000);
			}
		}
		
		
	}
	
	
}
