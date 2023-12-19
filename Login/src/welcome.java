import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.*;

public class welcome extends JFrame implements ActionListener {
    JButton login, signup;

    welcome() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setTitle("Welcome Page");

        JPanel panel = new JPanel();
        panel.setLayout(null);
        JLabel welcomeLabel = new JLabel("Welcome to Our Application");
        welcomeLabel.setBounds(50, 100, 400, 50);
        welcomeLabel.setForeground(Color.BLACK);
        welcomeLabel.setFont(new Font("serif", Font.PLAIN, 30));


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("boy_img.png"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(400, 100, 150, 150);
        add(l3);

        login = new JButton("Login");
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.setBounds(100, 200, 100, 30);
        login.addActionListener(this);

        signup = new JButton("Signup");
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.setBounds(220, 200, 100, 30);
        signup.addActionListener(this);

        panel.add(welcomeLabel);
        panel.add(login);
        panel.add(signup);
        add(panel);

        setBounds(100, 100, 600, 400);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == login) {
            setVisible(false);
            new Login();
        } else if (ae.getSource() == signup) {
            setVisible(false);
            new Signup();
        }

    }

    public static void main(String[] args) {
        new welcome();
    }
}
