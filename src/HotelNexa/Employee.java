package HotelNexa;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Employee extends JFrame {
    DefaultTableModel model;
    JTable table;
    JButton backButton;
    DatabaseConnection conn = new DatabaseConnection();
    public Employee() {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(5,5,880,480);
        panel.setBackground(new Color(3,45,48));
        add(panel);

        table = new JTable();
        table.setBounds(10,50,800,350);
        table.setBackground(new Color(3,45,48));
        table.setForeground(Color.white);
        panel.add(table);
        model = new DefaultTableModel(new String[]{"","","","","","","",""}, 0);
        loadEmployees();
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
        nameLabel.setBounds(110,15,80,19);
        panel.add(nameLabel);

        JLabel ageLabel = new JLabel("Age");
        ageLabel.setForeground(Color.white);
        ageLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        ageLabel.setBounds(210,15,80,19);
        panel.add(ageLabel);

        JLabel genderLabel = new JLabel("Gender");
        genderLabel.setForeground(Color.white);
        genderLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        genderLabel.setBounds(310,15,80,19);
        panel.add(genderLabel);

        JLabel jobLabel = new JLabel("Job");
        jobLabel.setForeground(Color.white);
        jobLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        jobLabel.setBounds(410,15,80,19);
        panel.add(jobLabel);

        JLabel salaryLabel = new JLabel("Salary");
        salaryLabel.setForeground(Color.white);
        salaryLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        salaryLabel.setBounds(510,15,80,19);
        panel.add(salaryLabel);

        JLabel phoneLabel = new JLabel("Phone");
        phoneLabel.setForeground(Color.white);
        phoneLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        phoneLabel.setBounds(610,15,80,19);
        panel.add(phoneLabel);

        JLabel cnicLabel = new JLabel("Cnic");
        cnicLabel.setForeground(Color.white);
        cnicLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        cnicLabel.setBounds(710,15,80,19);
        panel.add(cnicLabel);

        backButton = new JButton("Back");
        backButton.setBounds(90,410,120,30);
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
        setSize(890,490);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void loadEmployees() {
        model.setRowCount(0); // Clear existing data
        try {
            String query = "SELECT * FROM employee";
            ResultSet resultSet = conn.statement.executeQuery(query);
            int srNo = 1;
            while (resultSet.next()) {
                model.addRow(new Object[]{srNo++, resultSet.getString("name"), resultSet.getString("age"), resultSet.getString("gender" ), resultSet.getString("job"), resultSet.getString("salary"), resultSet.getString("phone"),resultSet.getString("cnic"),resultSet.getString("email")});
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error connecting to the database: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        new Employee();
    }
}
