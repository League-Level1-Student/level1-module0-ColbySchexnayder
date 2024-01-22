package _01_methods._3_rain_game;

import java.awt.Color;

import processing.core.PApplet;
import processing.core.PImage;

/*
 * Goal: Make a game where the user has to catch rain drops in a bucket!
 * 
 * In the setup() method:
 * 1. If you are using an image for the bucket, load it and resize it here.
 *    A bucket image, bucket.png, has been provided if you want to use it.
 *    bucket = loadImage("images/bucket.png");
 *    bucket.resize(100, 100);  // you can choose values other than 100, 100
 * 
 * In the draw() method:
 * 2. Set a background color
 * 
 * 3. Draw a raindrop (ellipse) at the top of the screen
 * 
 * 4. Make the rain fall down the screen.
 *    Hint: make a variable for the raindrop's Y position and change it after
 *    you draw the raindrop.
 * 
 * 5. When the rain falls off the bottom of the canvas, start a new rain drop
 *    falling from the top.
 *    Each new drop should start at a random position (X position) at the top.
 *    Hint: This code will get a random number between 0 and the window width.
 *    int randomNumber = (int)random(width);
 * 
 * 6. Draw a bucket (rectangle or image) at the bottom of the screen.
 *    The bucket's width needs to be stored in the bucketWidth variable.
 * 
 * 7. Make the bucket move side-to-side with the mouse. Hint: use mouseX
 * 
 * 8. When the rain drop has fallen to the bucket, call the checkCatch() method
 *    to see if the rain drop is in the bucket.
 * 
 * 9. Show the current score on the screen using the code below.
 *    Change the color if it does not show up on your background.
 *    fill(0, 0, 0);
 *    textSize(16);
 *    text("Score: " + score, 20, 20);
 */
public class RainGame extends PApplet {
    static final int WIDTH = 600;
    static final int HEIGHT = 600;

    int score = 0;
    int bucketWidth = 50;
    int bucketHeight = 50;
    PImage bucket;
    int y = 0;
    int x = 300;
    int fallSpeed = 5;
    
    int bucketY = HEIGHT - bucketHeight - 50;
    // Sets the size of your canvas
    @Override
    public void settings() {
        size(WIDTH, HEIGHT);
    }

    @Override
    public void setup() {
    	bucket = loadImage("bucket.png");
    	bucket.resize(bucketWidth, bucketHeight);
    }

    @Override
    public void draw() {
    	background(50, 50, 200);
    	
    	fill(200, 200, 250);
    	ellipse(x, y, 50, 50);
    	
    	y += fallSpeed;
    	
    	    	
    	image(bucket, mouseX, bucketY);
    	if (y >= bucketY && y <= bucketY + bucketHeight) {
    		checkCatch(x);
    		y = 0;
    		x = (int) random(WIDTH);
    	}
    	
    	fill(255, 255, 255);
    	textSize(16);
    	text("Score: " + score, 20, 20);
    	
    	
    }

    static public void main(String[] args) {
        PApplet.main(RainGame.class.getName());
    }
    
    /*********************** DO NOT MODIFY THE CODE BELOW ********************/

    void checkCatch(int x) {
        if (x > mouseX && x < mouseX + bucketWidth) {
            score+=100;
            fallSpeed++;
            
        } else if (score > 0) {
            score-=100;
            fallSpeed--;
        }
        println("Your score is now: " + score);
    }
}
