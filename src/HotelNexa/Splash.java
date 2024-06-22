package HotelNexa;

import javax.swing.*;
import java.util.Objects;

public class Splash extends JFrame {
    // Constructor to initialize the splash screen
    Splash() {
        super("Hotel Nexa Splash");

        CheckDBTables checkDBTables = new CheckDBTables();
        checkDBTables.checking_tables();
        // Attempt to load the splash image
        ImageIcon imageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/icon/splash.gif")));
        // Create and set up the label with the image
        JLabel label = new JLabel(imageIcon);
        label.setBounds(-50, 0, 950, 600);
        add(label);


        // Configure the JFrame settings
        setLayout(null);
        setLocation(300, 80);
        setSize(850, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Ensure the application exits when the window is closed
        setVisible(true);
        try{
            Thread.sleep(5000);
            setVisible(false);
            new Dashboard();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Run the splash screen on the Event Dispatch Thread (EDT) for thread safety
        new Splash();
    }
}
