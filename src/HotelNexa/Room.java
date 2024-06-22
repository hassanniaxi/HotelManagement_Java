package HotelNexa;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Room extends JFrame implements ActionListener {
    JTable table;
    DefaultTableModel model;
    JButton backButton;
    DatabaseConnection conn = new DatabaseConnection();
    Room(){
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(5,5,850,480);
        panel.setBackground(new Color(3,45,48));
        add(panel);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/roomm.png"));
        Image image = imageIcon.getImage().getScaledInstance(200,200, Image.SCALE_SMOOTH);
        ImageIcon imageicon = new ImageIcon(image);
        JLabel labelImg = new JLabel(imageicon);
        labelImg.setBounds(600,150,200,200);
        panel.add(labelImg);

        table = new JTable();
        table.setBounds(10,50,500,380);
        table.setBackground(new Color(3,45,48));
        table.setForeground(Color.white);

        model = new DefaultTableModel(new String[]{"Sr No", "Room No", "Availability", "Cleaning Status","Price","Bed Type"}, 0);
        loadRooms();
        table.setModel(model);
        panel.add(table);

        JLabel srNoLabel = new JLabel("Sr No");
        srNoLabel.setForeground(Color.white);
        srNoLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        srNoLabel.setBounds(10,15,80,19);
        panel.add(srNoLabel);

        JLabel roomNoLabel = new JLabel("Room No");
        roomNoLabel.setForeground(Color.white);
        roomNoLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        roomNoLabel.setBounds(90,15,80,19);
        panel.add(roomNoLabel);

        JLabel availabilityLabel = new JLabel("Availability");
        availabilityLabel.setForeground(Color.white);
        availabilityLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        availabilityLabel.setBounds(170,15,80,19);
        panel.add(availabilityLabel);

        JLabel cleaningStatusLabel = new JLabel("Status");
        cleaningStatusLabel.setForeground(Color.white);
        cleaningStatusLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        cleaningStatusLabel.setBounds(260,15,80,19);
        panel.add(cleaningStatusLabel);

        JLabel priceLabel = new JLabel("Price");
        priceLabel.setForeground(Color.white);
        priceLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        priceLabel.setBounds(340,15,80,19);
        panel.add(priceLabel);

        JLabel bedTypeLabel = new JLabel("Bed Type");
        bedTypeLabel.setForeground(Color.white);
        bedTypeLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        bedTypeLabel.setBounds(420,15,80,19);
        panel.add(bedTypeLabel);

        backButton = new JButton("Back");
        backButton.setBounds(90,430,120,30);
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.WHITE);
        panel.add(backButton);

        backButton.addActionListener(this);

        setUndecorated(true);
        setLocation(400,80);
        setLayout(null);
        setSize(860,490);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void loadRooms() {
        model.setRowCount(0); // Clear existing data
        try {
            String query = "SELECT * FROM room";
            ResultSet resultSet = conn.statement.executeQuery(query);
            int srNo = 1;
            while (resultSet.next()) {
                model.addRow(new Object[]{srNo++, resultSet.getString("roomNumber"), resultSet.getString("availability"), resultSet.getString("cleaningStatus" ), resultSet.getString("price"), resultSet.getString("bedType")});
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error connecting to the database: " + e.getMessage());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Room();
    }
}
