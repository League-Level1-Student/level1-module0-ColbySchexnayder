package _03_gui_with_help._3_drum_kit;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import game_tools.Sound;

public class DrumKit implements MouseListener {
    static boolean canPlaySounds = true; // Set this to false if your computer cannot play sounds
    JLabel drumLabel;
    JLabel cymbalLabel;
    
    public void run() {
        //  Make a JFrame variable and initialize it using "new JFrame()"
    	JFrame frame = new JFrame();
        //  Make the frame visible and
        // set its default close operation to JFrame.EXIT_ON_CLOSE
    	frame.setVisible(true);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //  Set the title of the frame
    	frame.setTitle("Drum kit");
        //  Make a JPanel variable and initialize it using "new JPanel().
    	JPanel panel = new JPanel();
        //  Add the panel to the frame. (The panel is invisible.)
    	frame.add(panel);
        //  Use the image of a drum provided ("snare.jpg") or
        //  download an image of a drum from the Internet and drop it into the
        //  Drum Kit recipe package.
    	drumLabel = createLabelImage("snare.jpg");
    	cymbalLabel = createLabelImage("cymbal.jpg");
        panel.add(drumLabel);
        panel.add(cymbalLabel);
        frame.pack();
        //  Call the pack() method on the frame.
        // Run your program. Do you see your drum image?
        drumLabel.addMouseListener(this);
        cymbalLabel.addMouseListener(this);
        // Add this MouseListener to drumLabel
        
        // *** Write the code in the mouseClicked() method below

        //  Set the layout of the panel to "new GridLayout()"

        //  Add a cymbal image to make a Drum Kit (one has been provided).
        //  You will need a different sound to go with this image.
        //  Remember to add this MouseListener to it. Run the program.

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // Print "mouse clicked" to the console. Run your program and watch
        // the console to see when this is printed.
    	System.out.println("clicked");
        //JLabel labelClicked = (JLabel) e.getSource(); // This line gets the label
                                                        // that the mouse
                                                        // clicked on
    	JLabel labelClicked = (JLabel) e.getSource();
        // You can use the drum sound provided ("drum.wav") or
        // download another drum sound (.wav) and drop it into the Drum Kit package.
        // You can find sounds on freesound.org, and to download from there, you must log in
        // Ask your teacher for The League's login information.
    	if (labelClicked == drumLabel) {
    		playSound("drum.wav");
    		System.out.println("SNARE");
    	}
    	else if (labelClicked == cymbalLabel) {
    		playSound("cymbal.wav");
    		System.out.println("CYMBAL");
    	}
        //  If the user clicks on the drumImage...use the playSound method to play the drum sound.
        //  Test to see if it works before moving on.

    }

    private JLabel createLabelImage(String fileName) {
        JLabel imageLabel = new JLabel();
        URL imageURL = getClass().getResource(fileName);
        if (imageURL == null) {
            imageLabel.setText("Could not find image " + fileName);
        } else {
            Icon icon = new ImageIcon(imageURL);
            imageLabel.setIcon(icon);
        }
        return imageLabel;
    }


    public static synchronized void playSound(String fileName) {
        if (canPlaySounds) {
            Sound s = new Sound("_03_gui_with_help/_3_drum_kit/" + fileName);
            s.play();
        } else {
            JOptionPane.showMessageDialog(null, "Cannot play "+fileName, "No Sound", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub

    }

}
