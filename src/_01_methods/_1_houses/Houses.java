package _01_methods._1_houses;

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
		
		for (int i = 0; i < 10; i++) {
			int random = ran.nextInt(3);
			if (random == 0) {
				drawHouse("small");
			}
			else if (random == 1) {
				drawHouse("medium");
			}
			else {
				drawHouse("large");
			}
		}
	}
	
	public void drawHouse(String sheight) {
		
		rob.move(100);
		rob.turn(90);
		rob.move(50);
		rob.turn(90);
		rob.move(100);
		rob.turn(-90);
		rob.move(50);
		rob.turn(-90);
	}
}
