package hotel.management.system;
import java.awt.*;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.sql.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NewCustomer extends JFrame implements ActionListener{
	JComboBox<String>comboid;
	JTextField tfnumber,tfname,tfcountry,tfdeposit;
	JRadioButton rmale,rfemale;
	JButton add,back;
	Choice croom;
	JLabel checkintime;
	NewCustomer()
	{
		getContentPane().setBackground(Color.white);
		setLayout(null);

		JLabel text = new JLabel("NEW CUSTOMER FORM");
		text.setFont(new Font("Yu Mincho", Font.PLAIN, 20));
		text.setBounds(100, 20, 300, 30);
		add(text);

		JLabel lblId = new JLabel("ID :");
		lblId.setBounds(35, 80, 100, 20);
		text.setFont(new Font("Yu Mincho", Font.PLAIN, 20));
		add(lblId);

		 String []options = { "Passport", "Aadhar Card", "Voter Id", "Driving license","Pan card" };
		 comboid = new JComboBox<>(options);
		comboid.setBounds(200, 80, 150, 25);
		comboid.setBackground(Color.white);
		add(comboid);

		JLabel lblnumber = new JLabel("Number :");
		lblnumber.setBounds(35, 120, 100, 20);
		add(lblnumber);

		tfnumber = new JTextField();
		tfnumber.setBounds(200, 120, 150, 25);
		add(tfnumber);

		JLabel lblname = new JLabel("Name :");
		lblname.setBounds(35, 169, 100, 20);
		add(lblname);

		tfname = new JTextField();
		tfname.setBounds(200, 160, 150, 25);
		add(tfname);

		JLabel lblGender = new JLabel("Gender :");
		lblGender.setBounds(35, 200, 100, 20);
		add(lblGender);

		rmale = new JRadioButton("Male");
		rmale.setBackground(Color.WHITE);
		rmale.setBounds(200, 200, 60, 25);
		rmale.setFont(new Font("Raleway", Font.BOLD, 14));
		add(rmale);

		rfemale = new JRadioButton("Female");
		rfemale.setBackground(Color.WHITE);
		rfemale.setBounds(270, 200, 100, 25);
		rfemale.setFont(new Font("Raleway", Font.BOLD, 20));
		add(rfemale);

		JLabel lblCountry = new JLabel("Country :");
		lblCountry.setBounds(35, 240, 100, 20);
		lblCountry.setFont(new Font("Raleway", Font.BOLD, 20));
		add(lblCountry);

		tfcountry = new JTextField();
		tfcountry.setBounds(200,240,150,25);
		add(tfcountry);

		JLabel lblroom = new JLabel("Room Number :");
		lblroom.setBounds(35, 290, 150, 20);  // Adjusted y-coordinate
		lblroom.setFont(new Font("Raleway", Font.PLAIN, 20));
		add(lblroom);

		croom = new Choice();

		try {
			conn c = new conn();
			String query = "select * from room";
			ResultSet rs =  c.s.executeQuery(query);
			while (rs.next()) {
				croom.add(rs.getString("roomnumber"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		croom.setBounds(200, 290, 150, 25);  // Adjusted y-coordinate
		add(croom);

		JLabel lbltime = new JLabel("checkin time");
		lbltime.setBounds(35,320,150,20);
		lbltime.setFont(new Font("serif",Font.PLAIN,20));
		add(lbltime);

		Date dt = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String formattedDate = dateFormat.format(dt);

		checkintime = new JLabel(formattedDate);
		checkintime.setBounds(200, 320, 150, 25);
		checkintime.setFont(new Font("serif", Font.PLAIN, 18));
		add(checkintime);

		JLabel lbldeposit = new JLabel("Deposit");
		lbldeposit.setBounds(35,360,100,20);
		lbldeposit.setFont(new Font("Poppins",Font.PLAIN,20));
		add(lbldeposit);

		tfdeposit = new JTextField();
		tfdeposit.setBounds(200,360,150,25);
		add(tfdeposit);

		add = new JButton("Add");
		add.setBackground(Color.black);
		add.setForeground(Color.white);
		add.setBounds(50,410,120,30);
		add.addActionListener(this);
		add(add);

		back = new JButton("Back");
		back.setBackground(Color.black);
		back.setForeground(Color.white);
		back.setBounds(200,410,120,30);
		back.addActionListener(this);
		add(back);

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fifth.png"));
		Image i3 = i1.getImage().getScaledInstance(300, 400, Image.SCALE_DEFAULT);
		ImageIcon i2 = new ImageIcon(i3);
		JLabel l1 = new JLabel(i2);
		l1.setBounds(400, 30, 300, 400);
		add(l1);

		setBounds(350,200,800,500);
		setVisible(true);
	}
	public  void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==add)
		{
			String id = (String) comboid.getSelectedItem();
			String number = tfnumber.getText();
			String name = tfname.getText();
			String gender = null;

			if(rmale.isSelected()){
				gender="Male";
			} else if (rfemale.isSelected()) {
				gender="Female";
			}
			String country = tfcountry.getText();
			String room = croom.getSelectedItem();
			String time = checkintime.getText();
			String deposit = tfdeposit.getText();
			try{
				String query = "insert into customer values('"+id+"','"+number+"','"+name+"','"+gender+"','"+country+"','"+room+"','"+time+"','"+deposit+"')";
				String query2 = "update room set availability = 'Occupied' where roomnumber = '" + room + "'";
				conn c = new conn();
				c.s.executeUpdate(query);
				c.s.executeUpdate(query2);

				JOptionPane.showMessageDialog(null, "Data Inserted Successfully");
				setVisible(false);
				new Reception();
			}catch (Exception e)
			{
				e.printStackTrace();
			}

		}
		else if(ae.getSource()==back)
	{

		setVisible(false);
		new Reception();
	}

	}
	public static void main(String[] args) {
		new NewCustomer();
	}
}