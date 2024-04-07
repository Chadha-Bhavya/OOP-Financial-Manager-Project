package ui;

import javax.swing.*;
import java.awt.*;

//Splash Screen to Simulate Loading
public class SplashScreen {


    // EFFECTS: displays a splash screen with an image for 6 seconds

    public SplashScreen() {
        display();
    }

    // MODIFIES: this
    // EFFECTS: creates and displays a JFrame containing a JLabel with an image,
    //          waits for 6 seconds, then disposes the frame
    private void display() {
        JFrame splashFrame = new JFrame();
        JLabel splashLabel = new JLabel(new ImageIcon("data/SplashScreenDesign.jpg"));
        splashFrame.getContentPane().add(splashLabel, BorderLayout.CENTER);
        splashFrame.setSize(300,200);
        splashFrame.setLocationRelativeTo(null);
        splashFrame.setVisible(true);

        try {
            Thread.sleep(6000);
        } catch (Exception e) {
            // pass
        }

        splashFrame.dispose();
    }

}