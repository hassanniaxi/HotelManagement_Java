package HotelNexa;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Admin extends JFrame implements ActionListener {
    JButton add_Employee,add_Room, add_Driver, back, logOut;
    Admin(){
        super("Admin Panel");

        add_Employee = new JButton("Add Employee");
        add_Employee.setBounds(250,140,200,30);
        add_Employee.setFont(new Font("Tahoma",Font.BOLD, 20));
        add_Employee.setBackground(Color.WHITE);
        add_Employee.setForeground(Color.BLACK);
        add(add_Employee);

        add_Room = new JButton("Add Room");
        add_Room.setBounds(250,310,200,30);
        add_Room.setFont(new Font("Tahoma",Font.BOLD, 20));
        add_Room.setBackground(Color.WHITE);
        add_Room.setForeground(Color.BLACK);
        add(add_Room);

        add_Driver = new JButton("Add Driver");
        add_Driver.setBounds(250,470,200,30);
        add_Driver.setFont(new Font("Tahoma",Font.BOLD, 20));
        add_Driver.setBackground(Color.WHITE);
        add_Driver.setForeground(Color.BLACK);
        add(add_Driver);

        logOut = new JButton("Logout");
        logOut.setBounds(20,630,95,25);
        logOut.setFont(new Font("Tahoma",Font.BOLD, 15));
        logOut.setBackground(Color.BLACK);
        logOut.setForeground(Color.WHITE);
        add(logOut);

        back = new JButton("Back");
        back.setBounds(120,630,95,25);
        back.setFont(new Font("Tahoma",Font.BOLD, 15));
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        add(back);

        ImageIcon imageIcon1 = new ImageIcon(ClassLoader.getSystemResource("icon/employees.png"));
        Image image1 = imageIcon1.getImage().getScaledInstance(120,120, Image.SCALE_SMOOTH);
        ImageIcon imageicon1 = new ImageIcon(image1);
        JLabel label1 = new JLabel(imageicon1);
        label1.setBounds(70,100,120,120);
        add(label1);

        ImageIcon imageIcon2 = new ImageIcon(ClassLoader.getSystemResource("icon/room.png"));
        Image image2 = imageIcon2.getImage().getScaledInstance(120,120, Image.SCALE_SMOOTH);
        ImageIcon imageicon2 = new ImageIcon(image2);
        JLabel label2 = new JLabel(imageicon2);
        label2.setBounds(70,260,120,120);
        add(label2);

        ImageIcon imageIcon3 = new ImageIcon(ClassLoader.getSystemResource("icon/driver.png"));
        Image image3 = imageIcon3.getImage().getScaledInstance(120,120, Image.SCALE_SMOOTH);
        ImageIcon imageicon3 = new ImageIcon(image3);
        JLabel label3 = new JLabel(imageicon3);
        label3.setBounds(70,420,120,120);
        add(label3);

        ImageIcon imageIcon4 = new ImageIcon(ClassLoader.getSystemResource("icon/hotelnexalogoo.png"));
        Image image4 = imageIcon4.getImage().getScaledInstance(400,400, Image.SCALE_SMOOTH);
        ImageIcon imageicon4 = new ImageIcon(image4);
        JLabel label4 = new JLabel(imageicon4);
        label4.setBounds(800,150,400,400);
        add(label4);

        add_Employee.addActionListener(this);
        add_Room.addActionListener(this);
        add_Driver.addActionListener(this);
        logOut.addActionListener(this);
        back.addActionListener(this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(new Color(3, 45, 48));
        setSize(1350, 720);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == add_Employee){
            new AddEmployee();
        }else if(e.getSource() == add_Room){
            new AddRoom();
        }else if(e.getSource() == add_Driver){
            new AddDriver();
        }else if(e.getSource() == logOut){
            System.exit(200);
        }else{
            new Dashboard();
            dispose();
        }
    }

    public static void main(String[] args) {
        new Admin();
    }
}
