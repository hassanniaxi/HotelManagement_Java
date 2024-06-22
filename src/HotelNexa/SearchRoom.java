package HotelNexa;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SearchRoom extends JFrame implements ActionListener {
    JCheckBox checkBox;
    Choice choice;
    JTable table;
    DefaultTableModel model;
    JButton backButton, searchButton;
    DatabaseConnection conn = new DatabaseConnection();
    SearchRoom() {

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(5,5,690,490);
        panel.setBackground(new Color(3,45,48));
        add(panel);

        JLabel searchForRoom = new JLabel("Search For Room");
        searchForRoom.setFont(new Font("Tahoma", Font.BOLD, 20));
        searchForRoom.setBounds(250,11,186,31);
        searchForRoom.setForeground(Color.WHITE);
        panel.add(searchForRoom);

        JLabel rbd = new JLabel("Room Bed Type:");
        rbd.setFont(new Font("Tahoma", Font.BOLD, 15));
        rbd.setBounds(50,73,120,20);
        rbd.setForeground(Color.WHITE);
        panel.add(rbd);

        checkBox = new JCheckBox("Only Display Available Rooms");
        checkBox.setBounds(400,69,205,23);
        checkBox.setForeground(Color.WHITE);
        checkBox.setBackground(new Color(3,45,48));
        panel.add(checkBox);
        choice = new Choice();
        choice.add("All");
        choice.add("Single Bed");
        choice.add("Double Bed");
        choice.setBounds(175,70,120,30);
        choice.setForeground(Color.WHITE);
        choice.setBackground(new Color(3,45,48));
        panel.add(choice);

        table = new JTable();
        table.setBounds(0,187,650,220);
        table.setBackground(new Color(3,45,48));
        table.setForeground(Color.WHITE);
        panel.add(table);

        model = new DefaultTableModel(new String[]{"Sr No", "Room No", "Availability", "Status", "Price", "Bed Type"}, 0);
        loadRooms();
        table.setModel(model);
        panel.add(table);

        JLabel srNoLabel = new JLabel("Sr No");
        srNoLabel.setForeground(Color.white);
        srNoLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        srNoLabel.setBounds(10,160,80,19);
        panel.add(srNoLabel);

        JLabel roomNoLabel = new JLabel("Room No");
        roomNoLabel.setForeground(Color.white);
        roomNoLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        roomNoLabel.setBounds(110,160,80,19);
        panel.add(roomNoLabel);

        JLabel availabilityLabel = new JLabel("Availability");
        availabilityLabel.setForeground(Color.white);
        availabilityLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        availabilityLabel.setBounds(220,160,80,19);
        panel.add(availabilityLabel);

        JLabel cleaningStatusLabel = new JLabel("Status");
        cleaningStatusLabel.setForeground(Color.white);
        cleaningStatusLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        cleaningStatusLabel.setBounds(330,160,80,19);
        panel.add(cleaningStatusLabel);

        JLabel priceLabel = new JLabel("Price");
        priceLabel.setForeground(Color.white);
        priceLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        priceLabel.setBounds(440,160,80,19);
        panel.add(priceLabel);

        JLabel bedTypeLabel = new JLabel("Bed Type");
        bedTypeLabel.setForeground(Color.white);
        bedTypeLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        bedTypeLabel.setBounds(550,160,80,19);
        panel.add(bedTypeLabel);

        backButton = new JButton("Back");
        backButton.setBounds(150,410,120,30);
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.WHITE);
        panel.add(backButton);

        searchButton = new JButton("Search");
        searchButton.setBounds(340,410,120,30);
        searchButton.setBackground(Color.BLACK);
        searchButton.setForeground(Color.WHITE);
        panel.add(searchButton);

        backButton.addActionListener(this);
        searchButton.addActionListener(this);

        setUndecorated(true);
        setLayout(null);
        setSize(700,500);
        setLocation(450,100);
        setVisible(true);
    }

    private void loadRooms() {
        model.setRowCount(0); // Clear existing data
        try {
            String query = "SELECT * FROM room";
            ResultSet resultSet = conn.statement.executeQuery(query);
            int srNo = 1;
            while (resultSet.next()) {
                model.addRow(new Object[]{srNo++, resultSet.getString("roomNumber"), resultSet.getString("availability"), resultSet.getString("cleaningStatus"), resultSet.getString("price"), resultSet.getString("bedType")});
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error connecting to the database: " + e.getMessage());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == searchButton){
            try{
                String query = "SELECT * FROM room WHERE bedType = '" + choice.getSelectedItem() + "'";
                String query2 = "SELECT * FROM room WHERE availability = 'Available' and bedType = '" + choice.getSelectedItem() + "'";
                String query3 = "SELECT * FROM room WHERE availability = 'Available'";
                ResultSet resultSet;
                int srNo;
                if (choice.getSelectedItem() == "All" && checkBox.isSelected()){
                    resultSet = conn.statement.executeQuery(query3);
                    srNo = 1;
                    while (resultSet.next()) {
                        model.addRow(new Object[]{srNo++, resultSet.getString("roomNumber"), resultSet.getString("availability"), resultSet.getString("cleaningStatus"), resultSet.getString("price"), resultSet.getString("bedType")});
                    }
                    if (resultSet == null){
                        System.out.println("empty");
                    }
                }
                else if (choice.getSelectedItem() != "All"){
                    model.setRowCount(0);
                    resultSet = conn.statement.executeQuery(query);
                    srNo = 1;
                    while (resultSet.next()) {
                        model.addRow(new Object[]{srNo++, resultSet.getString("roomNumber"), resultSet.getString("availability"), resultSet.getString("cleaningStatus"), resultSet.getString("price"), resultSet.getString("bedType")});
                    }
                }else{
                    loadRooms();
                }
                if (checkBox.isSelected()) {
                    model.setRowCount(0);
                    resultSet = conn.statement.executeQuery(query2);
                    srNo = 1;
                    while (resultSet.next()) {
                        model.addRow(new Object[]{srNo++, resultSet.getString("roomNumber"), resultSet.getString("availability"), resultSet.getString("cleaningStatus"), resultSet.getString("price"), resultSet.getString("bedType")});
                    }
                }
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }else{
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new SearchRoom();
    }
}
