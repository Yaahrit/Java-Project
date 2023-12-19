package hotel.management.system;

import java.awt.*;

import java.sql.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class UpdateRoom extends JFrame implements ActionListener {
	Choice ccustomer;
	JTextField tfroom,tfavailable,tfstatus,tfpaid,tfpending;
	JButton check,Update,Back;
	UpdateRoom()
	{
		getContentPane().setBackground(Color.white);
		setLayout(null);

		JLabel text = new JLabel("Update Room status");
		text.setFont(new Font("Tahoma",Font.PLAIN,20));
		text.setBounds(90,20,200,30);
		text.setForeground(Color.blue);
		add(text);


		JLabel lblid = new JLabel("Customer id");
		lblid.setBounds(20,80,100,20);
		add(lblid);

		ccustomer = new Choice();
		ccustomer.setBounds(200,80,150,25);
		add(ccustomer);

		try{
			conn c = new conn();
			ResultSet rs = c.s.executeQuery("select * from customer");
			while (rs.next())
			{
				ccustomer.add(rs.getString("number"));
			}

		}catch (Exception e)
		{
			e.printStackTrace();
		}

		JLabel lblroom = new JLabel("Room Number");
		lblroom.setBounds(30,130,100,20);
		add(lblroom);

		tfroom = new JTextField();
		tfroom.setBounds(200,130,150,25);
		add(tfroom);

		JLabel lblavailable = new JLabel("Availability : ");
		lblavailable.setBounds(30,180,100,20);
		add(lblavailable);

		tfavailable = new JTextField();
		tfavailable.setBounds(200,180,150,25);
		add(tfavailable);

		JLabel lblcheckin = new JLabel("Cleaning Status: ");
		lblcheckin.setBounds(30,230,100,20);
		add(lblcheckin);

		tfstatus = new JTextField();
		tfstatus.setBounds(200,230,150,25);
		add(tfstatus);



		check = new JButton("Check");
		check.setBackground(Color.black);
		check.setForeground(Color.white);
		check.setBounds(30,300,100,30);
		check.addActionListener(this);
		add(check);

		Update = new JButton("Update");
		Update.setBackground(Color.black);
		Update.setForeground(Color.white);
		Update.setBounds(150,300,100,30);
		Update.addActionListener(this);
		add(Update);

		Back = new JButton("Back");
		Back.setBackground(Color.black);
		Back.setForeground(Color.white);
		Back.setBounds(270,300,100,30);
		Back.addActionListener(this);
		add(Back);

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/seventh.jpg"));
		Image i2 = i1.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel l1 = new JLabel(i3);
		l1.setBounds(400, 50, 500, 300);
		add(l1);



		setBounds(300,200,980,450);
		setVisible(true);
	}
	public  void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==check){
			String id = ccustomer.getSelectedItem();
			String query = "select * from customer where number='"+id+"'";
			try{
				conn c = new conn();
				ResultSet rs = c.s.executeQuery(query);
				while (rs.next()){
					tfroom.setText(rs.getString("room"));
				}
				ResultSet rs2 = c.s.executeQuery("select * from room where roomnumber='"+tfroom.getText()+"'");
				while (rs2.next()){
					tfavailable.setText(rs2.getString("availability"));
					tfstatus.setText(rs2.getString("cleaning_status"));
				}
			}catch (Exception e)
			{
				e.printStackTrace();
			}

		}else if(ae.getSource()==Update)
		{
			String number = ccustomer.getSelectedItem();
			String room = tfroom.getText();
			String available = tfavailable.getText();
			String status = tfstatus.getText();
			try{
				conn c = new conn();
				c.s.executeUpdate("update room set availability='"+available+"', cleaning_status='"+status+"' where roomnumber='"+room+"'");
				JOptionPane.showMessageDialog(null,"Data Updated successfully");
				setVisible(false);
				new Reception();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}

		}else{
			setVisible(true);
			new Reception();

		}
	}

	public static void main(String[] args) {
		new UpdateRoom();
	}
}