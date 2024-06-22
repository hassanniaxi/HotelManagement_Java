package HotelNexa;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard extends JFrame implements ActionListener {
    JButton reception,admin;
    Dashboard(){
        super("Electronic Voting System Dashboard");

        reception = new JButton("Reception");
        reception.setBounds(380,510,190,30);
        reception.setFont(new Font("Tahoma",Font.BOLD, 15));
        reception.setBackground(new Color(255,98,0));
        reception.setForeground(Color.WHITE);
        add(reception);

        admin = new JButton("Admin");
        admin.setBounds(760,510,190,30);
        admin.setFont(new Font("Tahoma",Font.BOLD, 15));
        admin.setBackground(new Color(255,98,0));
        admin.setForeground(Color.WHITE);
        add(admin);

        ImageIcon imageIcon2 = new ImageIcon(ClassLoader.getSystemResource("icon/reception.png"));
        Image image = imageIcon2.getImage().getScaledInstance(200,195, Image.SCALE_SMOOTH);
        ImageIcon imageicon = new ImageIcon(image);
        JLabel label_1 = new JLabel(imageicon);
        label_1.setBounds(380,300,200,195);
        add(label_1);

        ImageIcon imageIcon3 = new ImageIcon(ClassLoader.getSystemResource("icon/boss.png"));
        Image image3 = imageIcon3.getImage().getScaledInstance(200,195, Image.SCALE_SMOOTH);
        ImageIcon imageicon3 = new ImageIcon(image3);
        JLabel label_3 = new JLabel(imageicon3);
        label_3.setBounds(760,300,200,195);
        add(label_3);

        admin.addActionListener(this);
        reception.addActionListener(this);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/Dashboard.gif"));
        Image imagee = imageIcon.getImage().getScaledInstance(1950, 1090, Image.SCALE_DEFAULT);
        ImageIcon imageIconn = new ImageIcon(imagee);
        JLabel label = new JLabel(imageIconn);
        label.setBounds(0, 0, 1950, 1090);
        add(label);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1950, 1090);
        setVisible(true);
        setLayout(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == reception ){
            new Reception();
            dispose();
        }else if(e.getSource() == admin){
            new Login();
            dispose();
        }else{
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Dashboard();
    }
}
