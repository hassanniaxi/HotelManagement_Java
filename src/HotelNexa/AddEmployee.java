package HotelNexa;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddEmployee extends JFrame implements ActionListener {
    JTextField nameTextField, ageTextField, salaryTextField, phoneTextField, cnicTextField, emailTextField;
    JRadioButton MRadioButton, FRadioButton;
    JComboBox jobCombo;
    JButton addButton,backButton;
    DatabaseConnection conn = new DatabaseConnection();
    AddEmployee(){

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(5,5,850,480);
        panel.setBackground(new Color(3,45,48));
        add(panel);

        JLabel name = new JLabel("Name:");
        name.setFont(new Font("Serif", Font.BOLD, 17));
        name.setBounds(60,30,150,27);
        name.setForeground(Color.WHITE);
        panel.add(name);
        nameTextField  = new JTextField();
        nameTextField.setFont(new Font("Tahoma", Font.BOLD, 14));
        nameTextField.setBounds(200,30,150,27);
        nameTextField.setBackground(new Color(16,108,115));
        nameTextField.setForeground(Color.white);
        panel.add(nameTextField);

        JLabel age = new JLabel("Age:");
        age.setFont(new Font("Serif", Font.BOLD, 17));
        age.setBounds(60,80,150,27);
        age.setForeground(Color.WHITE);
        panel.add(age);
        ageTextField  = new JTextField();
        ageTextField.setFont(new Font("Tahoma", Font.BOLD, 14));
        ageTextField.setBounds(200,80,150,27);
        ageTextField.setBackground(new Color(16,108,115));
        ageTextField.setForeground(Color.white);
        panel.add(ageTextField);

        JLabel gender = new JLabel("Gender:");
        gender.setFont(new Font("Serif", Font.BOLD, 17));
        gender.setBounds(60,120,150,27);
        gender.setForeground(Color.WHITE);
        panel.add(gender);
        MRadioButton = new JRadioButton("Male");
        MRadioButton.setBounds(200,120,70,27);
        MRadioButton.setBackground(new Color(3,45,48));
        MRadioButton.setFont(new Font("Tahoma",Font.BOLD,14));
        MRadioButton.setForeground(Color.white);
        panel.add(MRadioButton);
        FRadioButton = new JRadioButton("Female");
        FRadioButton.setBounds(275,120,100,27);
        FRadioButton.setBackground(new Color(3,45,48));
        FRadioButton.setFont(new Font("Tahoma",Font.BOLD,14));
        FRadioButton.setForeground(Color.white);
        panel.add(FRadioButton);

        JLabel job = new JLabel("Job:");
        job.setFont(new Font("Serif", Font.BOLD, 17));
        job.setBounds(60,170,150,27);
        job.setForeground(Color.WHITE);
        panel.add(job);
        jobCombo = new JComboBox(new String[] {"Front Desk","HouseKeeper","Manager","Accounting","Chaff"});
        jobCombo.setBackground(new Color(16,108,115));
        jobCombo.setBounds(200,170,150,30);
        jobCombo.setFont(new Font("tahoma",Font.BOLD,14));
        jobCombo.setForeground(Color.white);
        panel.add(jobCombo);

        JLabel salary = new JLabel("Salary:");
        salary.setFont(new Font("Serif", Font.BOLD, 17));
        salary.setBounds(60,220,150,27);
        salary.setForeground(Color.WHITE);
        panel.add(salary);
        salaryTextField = new JTextField();
        salaryTextField.setBackground(new Color(16,108,115));
        salaryTextField.setBounds(200,220,150,30);
        salaryTextField.setFont(new Font("tahoma",Font.BOLD,14));
        salaryTextField.setForeground(Color.white);
        panel.add(salaryTextField);

        JLabel phone = new JLabel("Phone No:");
        phone.setFont(new Font("Serif", Font.BOLD, 17));
        phone.setBounds(60,270,150,27);
        phone.setForeground(Color.WHITE);
        panel.add(phone);
        phoneTextField = new JTextField();
        phoneTextField.setBackground(new Color(16,108,115));
        phoneTextField.setBounds(200,270,150,30);
        phoneTextField.setFont(new Font("tahoma",Font.BOLD,14));
        phoneTextField.setForeground(Color.white);
        panel.add(phoneTextField);

        JLabel cnic = new JLabel("CNIC No:");
        cnic.setFont(new Font("Serif", Font.BOLD, 17));
        cnic.setBounds(60,320,150,27);
        cnic.setForeground(Color.WHITE);
        panel.add(cnic);
        cnicTextField = new JTextField();
        cnicTextField.setBackground(new Color(16,108,115));
        cnicTextField.setBounds(200,320,150,30);
        cnicTextField.setFont(new Font("tahoma",Font.BOLD,14));
        cnicTextField.setForeground(Color.white);
        panel.add(cnicTextField);

        JLabel email = new JLabel("E-mail:");
        email.setFont(new Font("Serif", Font.BOLD, 17));
        email.setBounds(60,370,150,27);
        email.setForeground(Color.WHITE);
        panel.add(email);
        emailTextField = new JTextField();
        emailTextField.setBackground(new Color(16,108,115));
        emailTextField.setBounds(200,370,150,30);
        emailTextField.setFont(new Font("tahoma",Font.BOLD,14));
        emailTextField.setForeground(Color.white);
        panel.add(emailTextField);

        JLabel AED = new JLabel("ADD EMPLOYEE DETAILS");
        AED.setFont(new Font("Tahoma", Font.BOLD, 33));
        AED.setBounds(420,24,450,32);
        AED.setForeground(Color.WHITE);
        panel.add(AED);

        addButton = new JButton("Add");
        addButton.setBounds(80,420,100,30);
        addButton.setBackground(Color.BLACK);
        addButton.setForeground(Color.WHITE);
        panel.add(addButton);

        backButton = new JButton("Back");
        backButton.setBounds(200,420,100,30);
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.WHITE);
        panel.add(backButton);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/addemp.png"));
        Image image = imageIcon.getImage().getScaledInstance(300,300, Image.SCALE_SMOOTH);
        ImageIcon imageicon = new ImageIcon(image);
        JLabel label = new JLabel(imageicon);
        label.setBounds(500,60,300,300);
        panel.add(label);

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
            String name = nameTextField.getText();
            String age = ageTextField.getText();
            String job = (String) jobCombo.getSelectedItem();
            String salary = salaryTextField.getText();
            String phone = phoneTextField.getText();
            String cnic = cnicTextField.getText();
            String email = emailTextField.getText();
            String gender = null;
            if (MRadioButton.isSelected()) {
                gender = "Male";
            } else if (FRadioButton.isSelected()) {
                gender = "Female";
            }

            // Perform validation
            if (name.isEmpty() || age.isEmpty() || job.isEmpty() || salary.isEmpty() || phone.isEmpty() || cnic.isEmpty() || email.isEmpty() || gender == null) {
                JOptionPane.showMessageDialog(this, "Please fill in all fields", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            try{
                String query = "INSERT INTO employee VALUES('" + name + "', '" + age + "', '" + gender + "', '" + job + "', '" + salary + "', '" + phone + "', '" + cnic + "', '" + email + "')";
                conn.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(this, "Congratulations, Employee Details Added Successfully!");
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
        new AddEmployee();
    }
}
