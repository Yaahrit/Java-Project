import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Signup extends JFrame implements ActionListener {
    JButton signup, cancel;
    JLabel lblfname, lbllname, lblemail, lblpass;
    JTextField tfname,tlname,temail;
    JPasswordField tfpass;
    JCheckBox desc;

    Signup() {
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setTitle("Signup");
        setVisible(true);

        lblfname = new JLabel("First Name ");
        lblfname.setBounds(70, 20, 100, 40);
        lblfname.setFont(new Font("serif", Font.BOLD, 15));
        add(lblfname);

        tfname = new JTextField();
        tfname.setBounds(160, 30, 150, 30);
        add(tfname);

        lbllname = new JLabel("Last Name ");
        lbllname.setBounds(70, 70, 100, 40);
        lbllname.setFont(new Font("serif", Font.BOLD, 15));
        add(lbllname);

        tlname = new JTextField();
        tlname.setBounds(160, 80, 150, 30);
        add(tlname);

        lblemail = new JLabel("Email Id ");
        lblemail.setBounds(70, 120, 100, 40);
        lblemail.setFont(new Font("serif", Font.BOLD, 15));
        add(lblemail);

        temail = new JTextField();
        temail.setBounds(160, 130, 150, 30);
        add(temail);

        lblpass = new JLabel("Password");
        lblpass.setBounds(70, 170, 100, 40);
        lblpass.setFont(new Font("serif", Font.BOLD, 15));
        add(lblpass);

        tfpass = new JPasswordField();
        tfpass.setBounds(160, 180, 150, 30);
        add(tfpass);

        desc = new JCheckBox("Already have an account? Log in");
        desc.setBounds(160, 220, 250, 40);
        desc.setFont(new Font("serif", Font.BOLD, 15));
        add(desc);

        signup = new JButton("Sign up");
        signup.setBounds(150, 260, 100, 30);
        signup.setFont(new Font("serif", Font.BOLD, 15));
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        add(signup);

        cancel = new JButton("Cancel");
        cancel.setBounds(270, 260, 100, 30);
        cancel.setFont(new Font("serif", Font.BOLD, 15));
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        add(cancel);

        signup.addActionListener(this);
        cancel.addActionListener(this);
        cancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new welcome().setVisible(true);
                setVisible(false);
            }
        });

        setSize(600, 400);
        setLocation(600, 350);
        setResizable(false);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == signup) {
            try {
                Conn c = new Conn();
                String first_name = tfname.getText();
                String last_name = tlname.getText();
                String email = temail.getText();
                String password = new String(tfpass.getPassword());

                // Use PreparedStatement to avoid SQL injection
                String q = "INSERT INTO signup VALUES (?, ?, ?, ?)";
                PreparedStatement pst = c.c.prepareStatement(q);
                pst.setString(1, first_name);
                pst.setString(2, last_name);
                pst.setString(3, email);
                pst.setString(4, password);

                int rowsAffected = pst.executeUpdate();
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null, "Signup successful");
                    setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Signup failed");
                }

                pst.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Signup();
    }
}
