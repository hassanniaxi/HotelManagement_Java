package HotelNexa;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

public class AddDriver extends JFrame implements ActionListener {
    JTextField nameTextField, ageTextField, carCompanyTextField,carNameTextField, carLocTextField;
    JComboBox availabilityCombo, genderCombo;
    JButton addButton,backButton;
    DatabaseConnection conn = new DatabaseConnection();
    AddDriver(){
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(5,5,850,480);
        panel.setBackground(new Color(3,45,48));
        add(panel);

        JLabel label = new JLabel("ADD DRIVERS");
        label.setFont(new Font("Tahoma", Font.BOLD, 22));
        label.setBounds(194,10,200,22);
        label.setForeground(Color.WHITE);
        panel.add(label);

        JLabel name = new JLabel("Name:");
        name.setFont(new Font("Tahoma", Font.BOLD, 14));
        name.setBounds(64,70,102,22);
        name.setForeground(Color.WHITE);
        panel.add(name);
        nameTextField  = new JTextField();
        nameTextField.setFont(new Font("Tahoma", Font.BOLD, 14));
        nameTextField.setBounds(174,70,156,20);
        nameTextField.setBackground(new Color(16,108,115));
        nameTextField.setForeground(Color.white);
        panel.add(nameTextField);

        JLabel age = new JLabel("Age:");
        age.setFont(new Font("Serif", Font.BOLD, 14));
        age.setBounds(64,110,102,22);
        age.setForeground(Color.WHITE);
        panel.add(age);
        ageTextField  = new JTextField();
        ageTextField.setFont(new Font("Tahoma", Font.BOLD, 14));
        ageTextField.setBounds(174,110,156,20);
        ageTextField.setBackground(new Color(16,108,115));
        ageTextField.setForeground(Color.white);
        panel.add(ageTextField);

        JLabel gender = new JLabel("Gender:");
        gender.setFont(new Font("", Font.BOLD, 14));
        gender.setBounds(64,150,102,22);
        gender.setForeground(Color.WHITE);
        panel.add(gender);
        genderCombo = new JComboBox(new String[]{"Male","Female"});
        genderCombo.setBounds(174,150,156,20);
        genderCombo.setBackground(new Color(16,108,115));
        genderCombo.setFont(new Font("Tahoma",Font.BOLD,14));
        genderCombo.setForeground(Color.white);
        panel.add(genderCombo);

        JLabel carCompany = new JLabel("Car Company:");
        carCompany.setFont(new Font("Tahoma", Font.BOLD, 14));
        carCompany.setBounds(64,190,102,22);
        carCompany.setForeground(Color.WHITE);
        panel.add(carCompany);
        carCompanyTextField  = new JTextField();
        carCompanyTextField.setFont(new Font("Tahoma", Font.BOLD, 14));
        carCompanyTextField.setBounds(174,190,156,20);
        carCompanyTextField.setBackground(new Color(16,108,115));
        carCompanyTextField.setForeground(Color.white);
        panel.add(carCompanyTextField);

        JLabel carName = new JLabel("Car Name:");
        carName.setFont(new Font("Tahoma", Font.BOLD, 14));
        carName.setBounds(64,230,102,22);
        carName.setForeground(Color.WHITE);
        panel.add(carName);
        carNameTextField  = new JTextField();
        carNameTextField.setFont(new Font("Tahoma", Font.BOLD, 14));
        carNameTextField.setBounds(174,230,156,20);
        carNameTextField.setBackground(new Color(16,108,115));
        carNameTextField.setForeground(Color.white);
        panel.add(carNameTextField);

        JLabel availability = new JLabel("Availability: ");
        availability.setFont(new Font("Tahoma", Font.BOLD, 14));
        availability.setBounds(64,270,102,22);
        availability.setForeground(Color.WHITE);
        panel.add(availability);
        availabilityCombo = new JComboBox(new String[] {"Yes","No"});
        availabilityCombo.setFont(new Font("Tahoma", Font.PLAIN, 14));
        availabilityCombo.setBounds(174,270,156,20);
        availabilityCombo.setForeground(Color.WHITE);
        availabilityCombo.setBackground(new Color(16,108,115));
        panel.add(availabilityCombo);

        JLabel carLoc = new JLabel("Car Location:");
        carLoc.setFont(new Font("Tahoma", Font.BOLD, 14));
        carLoc.setBounds(64,310,102,22);
        carLoc.setForeground(Color.WHITE);
        panel.add(carLoc);
        carLocTextField  = new JTextField();
        carLocTextField.setFont(new Font("Tahoma", Font.BOLD, 14));
        carLocTextField.setBounds(174,310,156,20);
        carLocTextField.setBackground(new Color(16,108,115));
        carLocTextField.setForeground(Color.white);
        panel.add(carLocTextField);

        addButton = new JButton("Add");
        addButton.setBounds(64,380,111,33);
        addButton.setBackground(Color.BLACK);
        addButton.setForeground(Color.WHITE);
        panel.add(addButton);

        backButton = new JButton("Back");
        backButton.setBounds(198,380,111,33);
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.WHITE);
        panel.add(backButton);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/license.png"));
        Image image = imageIcon.getImage().getScaledInstance(300,300, Image.SCALE_SMOOTH);
        ImageIcon imageicon = new ImageIcon(image);
        JLabel labelImg = new JLabel(imageicon);
        labelImg.setBounds(500,60,300,300);
        panel.add(labelImg);

        addButton.addActionListener(this);
        backButton.addActionListener(this);

        setUndecorated(true);
        setLocation(20,100);
        setLayout(null);
        setSize(860,490);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == addButton){
            String name = nameTextField.getText();
            String age = ageTextField.getText();
            String gender = (String) genderCombo.getSelectedItem();
            String carCompany = carCompanyTextField.getText();
            String carName = carNameTextField.getText();
            String availability = (String) availabilityCombo.getSelectedItem();
            String carLocation = carLocTextField.getText();

            // Perform validation
            if (name.isEmpty() || age.isEmpty() || gender.isEmpty() || carCompany.isEmpty() || carName.isEmpty() || availability == null || carLocation.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill in all fields", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            try {
                String query = "INSERT INTO driver VALUES('" + name + "', '" + age + "', '" + gender + "', '" + carCompany + "', '" + carName + "', '" + availability + "', '" + carLocation + "')";
                conn.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(this, "Congratulations, Driver Details Added Successfully!");
                setVisible(false);
            }catch (Exception E){
                E.printStackTrace();
                JOptionPane.showMessageDialog(this, "Request Time Out", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }else{
            new Admin();
            setVisible(false);
            dispose();
        }
    }

    public static void main(String[] args) {
        new AddDriver();
    }
}
