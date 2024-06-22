package HotelNexa;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.util.Date; 

public class NewCustomer extends JFrame implements ActionListener {
    JComboBox idComboBox, genderComboBox;
    JTextField numberTextField, nameTextField, countryTextField, depositTextField, priceTextField, pendingTextField;
    Choice room;
    JLabel date;
    JButton addButton, backButton;
    DatabaseConnection conn = new DatabaseConnection();
    public NewCustomer() {

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(5,5,840,540);
        panel.setBackground(new Color(3,45,48));
        add(panel);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/customer.png"));
        Image image = imageIcon.getImage().getScaledInstance(200,200, Image.SCALE_SMOOTH);
        ImageIcon imageicon = new ImageIcon(image);
        JLabel label = new JLabel(imageicon);
        label.setBounds(550,150,200,200);
        panel.add(label);

        JLabel title = new JLabel("NEW CUSTOMER FOAM");
        title.setFont(new Font("Tahoma", Font.BOLD, 20));
        title.setBounds(118,11,260,53);
        title.setForeground(Color.WHITE);
        panel.add(title);

        JLabel labelID = new JLabel("ID :");
        labelID.setFont(new Font("Tahoma", Font.PLAIN, 14));
        labelID.setBounds(35,76,200,14);
        labelID.setForeground(Color.WHITE);
        panel.add(labelID);
        idComboBox = new JComboBox(new String[] {"Passport","CNIC","Voter Id","Driving License"});
        idComboBox.setBounds(271,73,150,20);
        idComboBox.setForeground(Color.WHITE);
        idComboBox.setBackground(new Color(3,45,48));
        idComboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel.add(idComboBox);

        JLabel labelNumber = new JLabel("Number :");
        labelNumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
        labelNumber.setBounds(35,111,200,14);
        labelNumber.setForeground(Color.WHITE);
        panel.add(labelNumber);
        numberTextField = new JFormattedTextField();
        numberTextField.setBounds(271,111,150,20);
        numberTextField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel.add(numberTextField);

        JLabel labelName = new JLabel("Name :");
        labelName.setFont(new Font("Tahoma", Font.PLAIN, 14));
        labelName.setBounds(35,151,200,14);
        labelName.setForeground(Color.WHITE);
        panel.add(labelName);
        nameTextField = new JFormattedTextField();
        nameTextField.setBounds(271,151,150,20);
        nameTextField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel.add(nameTextField);

        JLabel labelGender = new JLabel("Gender :");
        labelGender.setFont(new Font("Tahoma", Font.PLAIN, 14));
        labelGender.setBounds(35,191,200,14);
        labelGender.setForeground(Color.WHITE);
        panel.add(labelGender);
        genderComboBox = new JComboBox(new String[] {"Male","Female"});
        genderComboBox.setBounds(271,191,150,20);
        genderComboBox.setForeground(Color.WHITE);
        genderComboBox.setBackground(new Color(3,45,48));
        genderComboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel.add(genderComboBox);

        JLabel labelCountry = new JLabel("Country :");
        labelCountry.setFont(new Font("Tahoma", Font.PLAIN, 14));
        labelCountry.setBounds(35,231,200,14);
        labelCountry.setForeground(Color.WHITE);
        panel.add(labelCountry);
        countryTextField = new JFormattedTextField();
        countryTextField.setBounds(271,231,150,20);
        countryTextField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel.add(countryTextField);

        JLabel labelRoom = new JLabel("Allocated Room Number:");
        labelRoom.setFont(new Font("Tahoma", Font.PLAIN, 14));
        labelRoom.setBounds(35,274,200,14);
        labelRoom.setForeground(Color.WHITE);
        panel.add(labelRoom);
        room = new Choice();
        try{
            ResultSet resultSet = conn.statement.executeQuery("SELECT * FROM room");
            while(resultSet.next()){
                room.add(resultSet.getString("roomnumber"));
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        room.setBounds(271,274,150,20);
        room.setFont(new Font("Tahoma", Font.BOLD, 14));
        room.setForeground(Color.WHITE);
        room.setBackground(new Color(3,45,48));
        panel.add(room);

        JLabel labelCI = new JLabel("Checked-In :");
        labelCI.setFont(new Font("Tahoma", Font.PLAIN, 14));
        labelCI.setBounds(35,316,200,14);
        labelCI.setForeground(Color.WHITE);
        panel.add(labelCI);
        Date date1 = new Date();

        date = new JLabel(""+date1);
        date.setFont(new Font("Tahoma", Font.PLAIN, 14));
        date.setBounds(271,316,200,14);
        date.setForeground(Color.WHITE);
        panel.add(date);

        JLabel labelprice = new JLabel("Room Price :");
        labelprice.setFont(new Font("Tahoma", Font.PLAIN, 14));
        labelprice.setBounds(35,359,200,14);
        labelprice.setForeground(Color.WHITE);
        panel.add(labelprice);
        priceTextField = new JFormattedTextField();
        priceTextField.setBounds(271,359,150,20);
        priceTextField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel.add(priceTextField);

        JLabel labelDeposit = new JLabel("Deposit :");
        labelDeposit.setFont(new Font("Tahoma", Font.PLAIN, 14));
        labelDeposit.setBounds(35,402,200,14);
        labelDeposit.setForeground(Color.WHITE);
        panel.add(labelDeposit);
        depositTextField = new JFormattedTextField();
        depositTextField.setBounds(271,402,150,20);
        depositTextField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel.add(depositTextField);

        JLabel labelPending = new JLabel("Pending :");
        labelPending.setFont(new Font("Tahoma", Font.PLAIN, 14));
        labelPending.setBounds(35,445,200,14);
        labelDeposit.setForeground(Color.WHITE);
        panel.add(labelPending);
        pendingTextField = new JFormattedTextField();
        pendingTextField.setBounds(271,445,150,20);
        pendingTextField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel.add(pendingTextField);

        addButton = new JButton("Add");
        addButton.setBounds(100,480,120,30);
        addButton.setBackground(Color.BLACK);
        addButton.setForeground(Color.WHITE);
        panel.add(addButton);

        backButton = new JButton("Back");
        backButton.setBounds(260,480,120,30);
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.WHITE);
        panel.add(backButton);

        addButton.addActionListener(this);
        backButton.addActionListener(this);

        setUndecorated(true);
        setLocation(400,90);
        setLayout(null);
        setSize(850,550);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            try {
                String id = (String) idComboBox.getSelectedItem();
                String number = numberTextField.getText();
                String name = nameTextField.getText();
                String gender = (String) genderComboBox.getSelectedItem();
                String country = countryTextField.getText();
                String roomNumber = room.getSelectedItem();
                int deposit = Integer.parseInt(depositTextField.getText());
                int pending = Integer.parseInt(pendingTextField.getText());

                // Perform validation
                if (id.isEmpty() || number.isEmpty() || name.isEmpty() || gender.isEmpty() || country.isEmpty() || roomNumber == null) {
                    JOptionPane.showMessageDialog(this, "Please fill in all fields", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Check if the room is already occupied
                ResultSet rs = conn.statement.executeQuery("SELECT availability FROM room WHERE roomnumber = '" + roomNumber + "'");
                if (rs.next()) {
                    String availability = rs.getString("availability");
                    if ("Occupied".equalsIgnoreCase(availability)) {
                        JOptionPane.showMessageDialog(this, "Room is already occupied", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }

                String query = "INSERT INTO customer VALUES('" + id + "', '" + number + "', '" + name + "', '" + gender + "', '" + country + "', '" + roomNumber + "', '" + date.getText() + "', '" + deposit + "', '"+pending+"')";
                String query2 = "UPDATE room SET availability = 'Occupied' WHERE roomnumber = '" + roomNumber + "'";

                conn.statement.executeUpdate(query);
                conn.statement.executeUpdate(query2);

                JOptionPane.showMessageDialog(this, "Congratulations, Customer Details Added Successfully!");
                setVisible(false);
            } catch (Exception E) {
                E.printStackTrace();
                JOptionPane.showMessageDialog(this, "Request Time Out", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }else  {
            setVisible(false);
        }

    }

    public static void main(String[] args) {
        new NewCustomer();
    }
}
