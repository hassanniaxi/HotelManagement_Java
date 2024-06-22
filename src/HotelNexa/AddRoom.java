package HotelNexa;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class AddRoom extends JFrame implements ActionListener {
    JTextField t2,t4;
    JComboBox t3,t5,t6; 
    JButton addButton,backButton;
    DatabaseConnection conn = new DatabaseConnection();
    AddRoom(){ 
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(5,5,850,480);
        panel.setBackground(new Color(3,45,48));
        add(panel);

        JLabel label = new JLabel("Add Room");
        label.setFont(new Font("Tahoma", Font.BOLD, 22));
        label.setBounds(194,10,160,22);
        label.setForeground(Color.WHITE);
        panel.add(label);

        JLabel label2 = new JLabel("Room Number: ");
        label2.setFont(new Font("Tahoma", Font.BOLD, 14));
        label2.setBounds(64,70,152,22);
        label2.setForeground(Color.WHITE);
        panel.add(label2);
        t2 = new JTextField();
        t2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        t2.setBounds(200,70,156,20);
        t2.setForeground(Color.WHITE);
        t2.setBackground(new Color(16,108,115));
        panel.add(t2);

        JLabel label3 = new JLabel("Availability: ");
        label3.setFont(new Font("Tahoma", Font.BOLD, 14));
        label3.setBounds(64,110,152,22);
        label3.setForeground(Color.WHITE);
        panel.add(label3);
        t3 = new JComboBox(new String[] {"Available","Occupied"});
        t3.setFont(new Font("Tahoma", Font.PLAIN, 14));
        t3.setBounds(200,110,156,20);
        t3.setForeground(Color.WHITE);
        t3.setBackground(new Color(16,108,115));
        panel.add(t3);

        JLabel label4 = new JLabel("Price: ");
        label4.setFont(new Font("Tahoma", Font.BOLD, 14));
        label4.setBounds(64,150,152,22);
        label4.setForeground(Color.WHITE);
        panel.add(label4);
        t4 = new JTextField();
        t4.setFont(new Font("Tahoma", Font.PLAIN, 14));
        t4.setBounds(200,150,156,20);
        t4.setForeground(Color.WHITE);
        t4.setBackground(new Color(16,108,115));
        panel.add(t4);

        JLabel label5 = new JLabel("Cleaning Status: ");
        label5.setFont(new Font("Tahoma", Font.BOLD, 14));
        label5.setBounds(64,190,190,22);
        label5.setForeground(Color.WHITE);
        panel.add(label5);
        t5 = new JComboBox(new String[]{"Cleaned","Dirty"});
        t5.setFont(new Font("Tahoma", Font.PLAIN, 14));
        t5.setBounds(200,190,156,20);
        t5.setForeground(Color.WHITE);
        t5.setBackground(new Color(16,108,115));
        panel.add(t5);

        JLabel label6 = new JLabel("Bed Type: ");
        label6.setFont(new Font("Tahoma", Font.BOLD, 14));
        label6.setBounds(64,230,190,22);
        label6.setForeground(Color.WHITE);
        panel.add(label6);
        t6 = new JComboBox(new String[]{"Single Bed","Double Bed"});
        t6.setFont(new Font("Tahoma", Font.PLAIN, 14));
        t6.setBounds(200,230,156,20);
        t6.setForeground(Color.WHITE);
        t6.setBackground(new Color(16,108,115));
        panel.add(t6);


        addButton = new JButton("Add");
        addButton.setBounds(64,321,111,33);
        addButton.setBackground(Color.BLACK);
        addButton.setForeground(Color.WHITE);
        panel.add(addButton);


        backButton = new JButton("Back");
        backButton.setBounds(198,321,111,33);
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.WHITE);
        panel.add(backButton);

        ImageIcon imageIcon4 = new ImageIcon(ClassLoader.getSystemResource("icon/roomser.png"));
        Image image4 = imageIcon4.getImage().getScaledInstance(300,300, Image.SCALE_SMOOTH);
        ImageIcon imageicon4 = new ImageIcon(image4);
        JLabel label44 = new JLabel(imageicon4);
        label44.setBounds(500,60,300,300);
        panel.add(label44);

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
            String roomNo = t2.getText();
            String availability = (String) t3.getSelectedItem();
            String price = t4.getText();
            String cleanStatus = (String) t5.getSelectedItem();
            String bedType= (String) t6.getSelectedItem();

// Perform validation
            if (roomNo.isEmpty() || availability.isEmpty() || price.isEmpty() || cleanStatus.isEmpty() || bedType.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill in all fields", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            try{
                String query = "INSERT INTO room VALUES('" + roomNo + "', '" + availability + "', '" + cleanStatus + "','" + price + "','" + bedType + "')";
                conn.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(this, "Congratulations, Room Added Successfully!");
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
        new AddRoom();
    }
}
