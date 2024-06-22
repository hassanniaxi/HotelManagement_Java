package HotelNexa;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.util.Date;

public class CheckInUpdate extends JFrame {
    JComboBox genderComboBox;
    JTextField nameTextField,depositTextField, pendingTextField, ciTextField, genderTextField,roomTextField,payingTextField;
    Choice room;
    JLabel date;
    JButton updateButton, backButton, checkButton;
    DatabaseConnection conn = new DatabaseConnection();
    CheckInUpdate(){

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(5,5,840,490);
        panel.setBackground(new Color(3,45,48));
        add(panel);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/updated.png"));
        Image image = imageIcon.getImage().getScaledInstance(250,250, Image.SCALE_SMOOTH);
        ImageIcon imageicon = new ImageIcon(image);
        JLabel labelImg = new JLabel(imageicon);
        labelImg.setBounds(500,90,250,250);
        panel.add(labelImg);

        JLabel label = new JLabel("CHECK IN DETAILS");
        label.setBounds(124,11,300,25);
        label.setFont(new Font("Tahoma", Font.BOLD, 25));
        label.setForeground(Color.WHITE);
        panel.add(label);

        JLabel labelID = new JLabel("ID: ");
        labelID.setBounds(35,88,46,14);
        labelID.setFont(new Font("Tahoma", Font.PLAIN, 14));
        labelID.setForeground(Color.WHITE);
        panel.add(labelID);
        Choice choice = new Choice();
        try{
            ResultSet resultSet = conn.statement.executeQuery("SELECT * FROM customer");
            while(resultSet.next()){
                choice.add(resultSet.getString("number"));
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        choice.setBounds(210,85,150,20);
        choice.setFont(new Font("Tahoma", Font.BOLD, 14));
        choice.setForeground(Color.WHITE);
        choice.setBackground(new Color(3,45,48));
        panel.add(choice);

        JLabel labelRoom = new JLabel("Room Number:");
        labelRoom.setFont(new Font("Tahoma", Font.PLAIN, 14));
        labelRoom.setBounds(35,150,200,14);
        labelRoom.setForeground(Color.WHITE);
        panel.add(labelRoom);
        roomTextField = new JFormattedTextField();
        roomTextField.setBounds(210,150,150,20);
        roomTextField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel.add(roomTextField);

        JLabel labelName = new JLabel("Name :");
        labelName.setFont(new Font("Tahoma", Font.PLAIN, 14));
        labelName.setBounds(35,190,200,14);
        labelName.setForeground(Color.WHITE);
        panel.add(labelName);
        nameTextField = new JFormattedTextField();
        nameTextField.setBounds(210,190,150,20);
        nameTextField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel.add(nameTextField);

        JLabel labelGender = new JLabel("Gender :");
        labelGender.setFont(new Font("Tahoma", Font.PLAIN, 14));
        labelGender.setBounds(35,230,200,14);
        labelGender.setForeground(Color.WHITE);
        panel.add(labelGender);
        genderTextField = new JFormattedTextField();
        genderTextField.setBounds(210,230,150,20);
        genderTextField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel.add(genderTextField);

        JLabel labelCI = new JLabel("Checked-In :");
        labelCI.setFont(new Font("Tahoma", Font.PLAIN, 14));
        labelCI.setBounds(35,270,200,14);
        labelCI.setForeground(Color.WHITE);
        panel.add(labelCI);
        ciTextField = new JFormattedTextField();
        ciTextField.setBounds(210,270,150,20);
        ciTextField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel.add(ciTextField);

        JLabel labelDeposit = new JLabel("Paid Amount (RS) :");
        labelDeposit.setFont(new Font("Tahoma", Font.PLAIN, 14));
        labelDeposit.setBounds(35,310,200,14);
        labelDeposit.setForeground(Color.WHITE);
        panel.add(labelDeposit);
        depositTextField = new JFormattedTextField();
        depositTextField.setBounds(210,310,150,20);
        depositTextField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel.add(depositTextField);

        JLabel labelPending = new JLabel("Pending Amount (RS) :");
        labelPending.setFont(new Font("Tahoma", Font.PLAIN, 14));
        labelPending.setBounds(35,350,200,14);
        labelPending.setForeground(Color.WHITE);
        panel.add(labelPending);
        pendingTextField = new JFormattedTextField();
        pendingTextField.setBounds(210,350,150,20);
        pendingTextField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel.add(pendingTextField);

        JLabel labelPaying = new JLabel("Paying Amount (RS) :");
        labelPaying.setFont(new Font("Tahoma", Font.PLAIN, 14));
        labelPaying.setBounds(35,390,200,14);
        labelPaying.setForeground(Color.WHITE);
        panel.add(labelPaying);
        payingTextField = new JFormattedTextField();
        payingTextField.setBounds(210,390,150,20);
        payingTextField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel.add(payingTextField);

        choice.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try{
                    String query = "SELECT * FROM customer WHERE number = '"+choice.getSelectedItem()+"'";
                    ResultSet resultSet = conn.statement.executeQuery(query);
                    while (resultSet.next()){
                        roomTextField.setText(resultSet.getString("roomNumber"));
                        nameTextField.setText(resultSet.getString("name"));
                        genderTextField.setText(resultSet.getString("gender"));
                        depositTextField.setText(resultSet.getString("deposit"));
                        ciTextField.setText(resultSet.getString("checkedIn"));
                        pendingTextField.setText(resultSet.getString("pending"));
                    }
                    ResultSet resultSet1 = conn.statement.executeQuery("SELECT * FROM room WHERE roomNumber = '"+roomTextField.getText()+"'");
                    while (resultSet1.next()){
                        String price = resultSet1.getString("price");
                        try {
                            int deposit = Integer.parseInt(depositTextField.getText());
                            int amountPaid = Integer.parseInt(price) - deposit;
                            pendingTextField.setText(String.valueOf(amountPaid));
                        } catch (NumberFormatException ex) {
                            System.out.println("Invalid input: " + ex.getMessage());
                        }

                    }
                }catch (Exception E){
                    E.printStackTrace();
                }

            }
        });

        backButton = new JButton("Back");
        backButton.setBounds(35,420,120,30);
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.WHITE);
        panel.add(backButton);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        updateButton = new JButton("Update");
        updateButton.setBounds(210,420,120,30);
        updateButton.setBackground(Color.BLACK);
        updateButton.setForeground(Color.WHITE);
        panel.add(updateButton);
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String c = choice.getSelectedItem();
                    String room = roomTextField.getText();
                    String name = nameTextField.getText();
                    String gender = genderTextField.getText();
                    String checkedIn = ciTextField.getText();
                    String amount = depositTextField.getText();
                    int paying = Integer.parseInt(payingTextField.getText());
                    int pending = Integer.parseInt(pendingTextField.getText());
                    pending -= paying;
                    pendingTextField.setText(String.valueOf(pending));
                    conn.statement.executeUpdate("UPDATE customer SET roomNumber = '"+room+"', name = '"+name+"', gender = '"+gender+"', checkedIn = '"+checkedIn+"', deposit = '"+amount+"',pending = '"+pending+"' WHERE number = '"+c+"'");

                    JOptionPane.showMessageDialog(null, "Customer Updated Successfully");
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        setLayout(null);
        setSize(850,500);
        setLocation(400,100);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new CheckInUpdate();
    }
}
