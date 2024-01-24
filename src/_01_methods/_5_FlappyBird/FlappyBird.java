package _01_methods._5_FlappyBird;

import processing.core.PApplet;
import processing.core.PImage;

public class FlappyBird extends PApplet {
	static final int WIDTH = 800;
	static final int HEIGHT = 600;

	PImage back;
	PImage pipeBottom;
	PImage pipeTop;
	PImage bird;

	int x = 250;
	int y = 300;

	int birdYVelocity = -10;
	int gravity = 1;

	int pipeX = WIDTH;
	int upperPipeHeight;
	int pipeGap = 150;
	int lowerY;
	
	int score = 0;
	
	boolean gameOver = false;

	@Override
	public void settings() {
		size(WIDTH, HEIGHT);
	}

	@Override
	public void setup() {
		back = loadImage("flappyBackground.jpg");
		pipeBottom = loadImage("bottomPipe.png");
		pipeTop = loadImage("topPipe.png");
		bird = loadImage("bird.png");
		back.resize(WIDTH, HEIGHT);
		bird.resize(50, 50);
		teleportPipes();

	}

	@Override
	public void draw() {
		if (gameOver) {
			background(0, 0, 0);
			textSize(32);
			text("Game Over!", WIDTH/2-75, HEIGHT/2);
			text("Score: " + score, WIDTH/2 - 75, HEIGHT/2+50);
			return;
		}
		
		background(back);
		image(pipeBottom, pipeX, lowerY);
		image(pipeTop, pipeX, upperPipeHeight);
		image(bird, x, y);
		
		textSize(24);
		text("Score: " + score, 25, 25);

		y += birdYVelocity;
		birdYVelocity += gravity;

		pipeX -= 5;
		if (pipeX < 0) {
			teleportPipes();
			score += 100;
		}
		
		if (intersectsPipes()) {
			gameOver = true;
		}
	}

	public void teleportPipes() {

		pipeX = WIDTH;
		upperPipeHeight = (int) random(-300, 0);
		lowerY = upperPipeHeight + pipeTop.height + pipeGap;

	}

	public boolean intersectsPipes() {
		if (y < upperPipeHeight + pipeTop.height && x > pipeX && x < pipeX + pipeTop.width) {
			return true;
		}
		else if (y > lowerY && x > pipeX && x < pipeX + pipeBottom.width) {
			return true;
		}
		else {
			return false;
		}
	}
	
	@Override
	public void mousePressed() {
		if (gameOver) {
			gameOver = false;
			score = 0;
			x = 250;
			y = 300;
			teleportPipes();
		}
		
		birdYVelocity = -10;
	}

	static public void main(String[] args) {
		PApplet.main(FlappyBird.class.getName());
	}
}
