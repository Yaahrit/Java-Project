import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener {
    JButton login, Back;
    JTextField tfname, tlname;
    JPasswordField tfpass;

    Login() {
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setTitle("Login");

        JLabel lblusername = new JLabel("First Name");
        lblusername.setBounds(40, 20, 100, 30);
        add(lblusername);

        tfname = new JTextField();
        tfname.setBounds(150, 20, 150, 30);
        add(tfname);

        JLabel lbllname = new JLabel("Last Name");
        lbllname.setBounds(40, 60, 100, 30);
        add(lbllname);

        tlname = new JTextField();
        tlname.setBounds(150, 60, 150, 30);
        add(tlname);

        JLabel lblpass = new JLabel("Password");
        lblpass.setBounds(40, 100, 100, 30);
        add(lblpass);

        tfpass = new JPasswordField(); // Change to JPasswordField for password input
        tfpass.setBounds(150, 100, 150, 30);
        add(tfpass);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("./second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(350, 10, 150, 150);
        add(l3);

        login = new JButton("Login");
        login.setBounds(40, 140, 120, 30);
        login.setFont(new Font("serif", Font.BOLD, 15));
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        add(login);

        Back = new JButton("Back");
        Back.setBounds(180, 140, 120, 30);
        Back.setFont(new Font("serif", Font.BOLD, 15));
        Back.setBackground(Color.BLACK);
        Back.setForeground(Color.WHITE);
        add(Back);

        login.addActionListener(this);
        Back.addActionListener(this);
        Back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new welcome().setVisible(true);
                setVisible(false);
            }
        });

        setVisible(true);
        setSize(600, 300);
        setLocation(600, 350);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == login) {
            try {
                Conn c = new Conn();
                String first_name = tfname.getText();
                String last_name = tlname.getText();
                String password = new String(tfpass.getPassword());

                // Use PreparedStatement to avoid SQL injection
                String q = "SELECT * FROM signup WHERE first_name = ? AND last_name = ? AND password = ?";
                PreparedStatement pst = c.c.prepareStatement(q);
                pst.setString(1, first_name);
                pst.setString(2, last_name);
                pst.setString(3, password);

                ResultSet rs = pst.executeQuery();

                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "Login successful");
                    setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Login failed. Invalid username or password.");
                }

                pst.close();
                rs.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
