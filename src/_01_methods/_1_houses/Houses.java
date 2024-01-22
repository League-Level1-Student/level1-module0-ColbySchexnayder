package _01_methods._1_houses;

import java.awt.Color;
import java.util.Random;

import org.jointheleague.graphical.robot.Robot;

/*
 *    Copyright (c) The League of Amazing Programmers 2013-2021
 *    Level 1
 */
public class Houses {
		
	Robot rob = new Robot();
	Random ran = new Random();
	public void run() {
		// Check the recipe to find out what code to put here
		rob.setX(50);
		rob.setY(500);
		rob.penDown();
		rob.setSpeed(100);
		rob.setPenWidth(10);
		
		for (int i = 0; i < 10; i++) {
			int random = ran.nextInt(3);
			Color color = new Color(ran.nextInt(256), ran.nextInt(256), ran.nextInt(256));
			if (random == 0) {
				drawHouse("small", color);
			}
			else if (random == 1) {
				drawHouse("medium", color);
			}
			else {
				drawHouse("large", color);
			}
		}
	}
	
	public void drawHouse(String sheight, Color c) {
		
		rob.setPenColor(c);
		
		int height = 0;
		
		if (sheight.equals("small")) {
			height = 60;
		}
		else if (sheight.equals("medium")) {
			height = 120;
		}
		else {
			height = 250;
		}
		
		rob.move(height);
		if (sheight.equals("large")) {
			drawPointyRoof();
		}
		else {
			drawFlatRoof();
		}
		rob.move(height);
		rob.turn(-90);
		rob.setPenColor(Color.green);
		rob.move(50);
		rob.turn(-90);
	}
	
	
	public void drawPointyRoof() {
		rob.turn(60);
		rob.move(25);
		rob.turn(60);
		rob.move(25);
		rob.turn(60);
	}
	
	public void drawFlatRoof() {
		rob.turn(90);
		rob.move(50);
		rob.turn(90);
	}
	
	
	
	
	
	
}
