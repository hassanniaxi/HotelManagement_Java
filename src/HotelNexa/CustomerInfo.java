package HotelNexa;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerInfo extends JFrame {
    JButton backButton;
    DefaultTableModel model;
    JTable table;
    DatabaseConnection conn = new DatabaseConnection();
    public CustomerInfo() {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(5,5,890,450);
        panel.setBackground(new Color(3,45,48));
        add(panel);

        table = new JTable();
        table.setBounds(10,50,900,350);
        table.setBackground(new Color(3,45,48));
        table.setForeground(Color.white);
        panel.add(table);
        model = new DefaultTableModel(new String[]{"","","","","","",""}, 0);
        loadManager();
        table.setModel(model);
        panel.add(table);

        JLabel srNoLabel = new JLabel("Sr No");
        srNoLabel.setForeground(Color.white);
        srNoLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        srNoLabel.setBounds(10,15,80,19);
        panel.add(srNoLabel);

        JLabel nameLabel = new JLabel("Name");
        nameLabel.setForeground(Color.white);
        nameLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        nameLabel.setBounds(140,15,80,19);
        panel.add(nameLabel);

        JLabel ageLabel = new JLabel("Gender");
        ageLabel.setForeground(Color.white);
        ageLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        ageLabel.setBounds(270,15,80,19);
        panel.add(ageLabel);

        JLabel genderLabel = new JLabel("Country");
        genderLabel.setForeground(Color.white);
        genderLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        genderLabel.setBounds(400,15,80,19);
        panel.add(genderLabel);

        JLabel jobLabel = new JLabel("Room No");
        jobLabel.setForeground(Color.white);
        jobLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        jobLabel.setBounds(530,15,80,19);
        panel.add(jobLabel);

        JLabel salaryLabel = new JLabel("Checked In");
        salaryLabel.setForeground(Color.white);
        salaryLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        salaryLabel.setBounds(660,15,80,19);
        panel.add(salaryLabel);

        JLabel phoneLabel = new JLabel("Deposit");
        phoneLabel.setForeground(Color.white);
        phoneLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        phoneLabel.setBounds(790,15,80,19);
        panel.add(phoneLabel);


        backButton = new JButton("Back");
        backButton.setBounds(360,400,120,30);
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.WHITE);
        panel.add(backButton);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        setUndecorated(true);
        setLocation(360,80);
        setLayout(null);
        setSize(900,460);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void loadManager() {
        model.setRowCount(0); // Clear existing data
        try {
            String query = "SELECT * FROM customer";
            ResultSet resultSet = conn.statement.executeQuery(query);
            int srNo = 1;
            while (resultSet.next()) {
                model.addRow(new Object[]{srNo++, resultSet.getString("name"), resultSet.getString("gender"), resultSet.getString("country" ), resultSet.getString("roomNumber"), resultSet.getString("checkedIn"), resultSet.getString("deposit")});
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error connecting to the database: " + e.getMessage());
        }
    }
    public static void main(String[] args) {
        new CustomerInfo();
    }
}
