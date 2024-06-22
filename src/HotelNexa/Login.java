package HotelNexa;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {

    JButton loginButton,backButton;
    JTextField usernameField, passwordField;
    DatabaseConnection con = new DatabaseConnection();
    Login() {
        // Create and configure the username JLabel
        JLabel jLabel1 = new JLabel("Enter Username:");
        jLabel1.setFont(new Font("Tahoma", Font.BOLD, 16));
        jLabel1.setForeground(Color.BLACK);

        // Create and configure the password JLabel
        JLabel jLabel2 = new JLabel("Enter Password:");
        jLabel2.setFont(new Font("Tahoma", Font.BOLD, 16));
        jLabel2.setForeground(Color.BLACK);

        // Create text fields for user input
        usernameField = new JTextField(20);
        passwordField = new JPasswordField(20);

        // Create buttons
        loginButton = new JButton("Login");
        backButton = new JButton("Back");


        // Create a panel to hold the labels, text fields, and buttons
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Add padding

        // Add the username label and text field to the panel
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(jLabel1, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(usernameField, gbc);

        // Add the password label and text field to the panel
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(jLabel2, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(passwordField, gbc);

        // Add the login button to the panel
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(loginButton, gbc);

        // Add the back button to the panel
        gbc.gridx = 1;
        panel.add(backButton, gbc);

        loginButton.addActionListener(this);
        backButton.addActionListener(this);

        // Add the panel to the frame
        add(panel);
        setTitle("LOgin");
        setSize(600, 300);
        setVisible(true);
        setLocation(400, 270);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(3,45,48)); 
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == loginButton) {
            try{
                String id = usernameField.getText();
                String pass = passwordField.getText();
                String query;
                query = "SELECT * FROM login WHERE userId = '"+id+"' and Password = '"+pass+"'";
                ResultSet resultSet = con.statement.executeQuery(query);
                if(resultSet.next()){
                    JOptionPane.showMessageDialog(null, "Login Successful");
                    new Admin();
                    dispose();
                }else{
                    JOptionPane.showMessageDialog(null, "Invalid username or password");
                }
            }catch (Exception ex){
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }else{
            new Splash();
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
