package HotelNexa;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class PickupService extends JFrame{
    DefaultTableModel model;
    Choice carName;
    JButton backButton;
    JTable table;
    DatabaseConnection conn = new DatabaseConnection();
    public PickupService() {

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(5,5,840,540);
        panel.setBackground(new Color(3,45,48));
        add(panel);


        JLabel title = new JLabel("PICK-UP SERVICE");
        title.setFont(new Font("Tahoma", Font.BOLD, 30));
        title.setBounds(240,11,300,53);
        title.setForeground(Color.WHITE);
        panel.add(title);

        JLabel labelID = new JLabel("Car Type : ");
        labelID.setFont(new Font("Serif", Font.PLAIN, 20));
        labelID.setBounds(35,100,90,25);
        labelID.setForeground(Color.WHITE);
        panel.add(labelID);
        carName = new Choice();
        try{
            ResultSet resultSet = conn.statement.executeQuery("SELECT * FROM driver");
            while(resultSet.next()){
                carName.add(resultSet.getString("carName"));
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        carName.setBounds(150,100,150,20);
        carName.setFont(new Font("Tahoma", Font.BOLD, 14));
        carName.setForeground(Color.WHITE);
        carName.setBackground(new Color(3,45,48));
        panel.add(carName);

        table = new JTable();
        table.setBounds(10,190,800,240);
        table.setBackground(new Color(3,45,48));
        table.setForeground(Color.white);
        panel.add(table);
        model = new DefaultTableModel(new String[]{"", "", "", "", "", "", "",""}, 0);
        loadDriver("SELECT * FROM driver");
        table.setModel(model);
        panel.add(table);

        JLabel srNoLabel = new JLabel("Sr No");
        srNoLabel.setForeground(Color.white);
        srNoLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        srNoLabel.setBounds(10,160,80,19);
        panel.add(srNoLabel);

        JLabel nameLabel = new JLabel("Name");
        nameLabel.setForeground(Color.white);
        nameLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        nameLabel.setBounds(110,160,80,19);
        panel.add(nameLabel);

        JLabel ageLabel = new JLabel("Age");
        ageLabel.setForeground(Color.white);
        ageLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        ageLabel.setBounds(210,160,80,19);
        panel.add(ageLabel);

        JLabel genderLabel = new JLabel("Gender");
        genderLabel.setForeground(Color.white);
        genderLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        genderLabel.setBounds(310,160,80,19);
        panel.add(genderLabel);

        JLabel companyLabel = new JLabel("Car Company");
        companyLabel.setForeground(Color.white);
        companyLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        companyLabel.setBounds(410,160,110,19);
        panel.add(companyLabel);

        JLabel carNameLabel = new JLabel("Car Name");
        carNameLabel.setForeground(Color.white);
        carNameLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        carNameLabel.setBounds(510,160,80,19);
        panel.add(carNameLabel);

        JLabel availabilityLabel = new JLabel("Availability");
        availabilityLabel.setForeground(Color.white);
        availabilityLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        availabilityLabel.setBounds(610,160,80,19);
        panel.add(availabilityLabel);

        JLabel locationLabel = new JLabel("Location");
        locationLabel.setForeground(Color.white);
        locationLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        locationLabel.setBounds(710,160,80,19);
        panel.add(locationLabel);

        backButton = new JButton("Back");
        backButton.setBounds(330,480,120,30);
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.WHITE);
        panel.add(backButton);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        carName.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try{
                    String query = "SELECT * FROM driver WHERE carName = '"+carName.getSelectedItem()+"'";
                    loadDriver(query);
                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        });

        setUndecorated(true);
        setLocation(400,90);
        setLayout(null);
        setSize(850,550);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void loadDriver(String query) {
        model.setRowCount(0); // Clear existing data
        try {
            ResultSet resultSet = conn.statement.executeQuery(query);
            int srNo = 1;
            while (resultSet.next()) {
                model.addRow(new Object[]{srNo++, resultSet.getString("name"),resultSet.getString("age"), resultSet.getString("gender"), resultSet.getString("carCompany" ), resultSet.getString("carName"), resultSet.getString("availability"), resultSet.getString("carLocation")});
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error connecting to the database: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        new PickupService();
    }
}
