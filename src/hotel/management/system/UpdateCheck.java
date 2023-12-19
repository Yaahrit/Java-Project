package hotel.management.system;

import java.awt.*;

import java.sql.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class UpdateCheck extends JFrame implements ActionListener {
	Choice ccustomer;
	JTextField tfroom,tfname,tfcheckin,tfpaid,tfpending;
	JButton check,Update,Back;
	UpdateCheck()
	{
		getContentPane().setBackground(Color.white);
		setLayout(null);

		JLabel text = new JLabel("Update status");
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
		lblroom.setBounds(30,120,100,20);
		add(lblroom);

		tfroom = new JTextField();
		tfroom.setBounds(200,120,150,25);
		add(tfroom);

		JLabel lblname = new JLabel("Name : ");
		lblname.setBounds(30,160,100,20);
		add(lblname);

		tfname = new JTextField();
		tfname.setBounds(200,160,150,25);
		add(tfname);

		JLabel lblcheckin = new JLabel("checkin Time: ");
		lblcheckin.setBounds(30,200,100,20);
		add(lblcheckin);

		tfcheckin = new JTextField();
		tfcheckin.setBounds(200,200,150,25);
		add(tfcheckin);

		JLabel lblpaid = new JLabel("Amount Paid (Rs) : ");
		lblpaid.setBounds(30,240,150,25);  // Adjusted the bounds
		add(lblpaid);


		tfpaid = new JTextField();
		tfpaid.setBounds(200,240,150,25);
		add(tfpaid);

		JLabel lblpending = new JLabel("Pending Amount (Rs) : ");
		lblpending.setBounds(30,280,150,25);  // Adjusted the bounds
		add(lblpending);

		tfpending = new JTextField();
		tfpending.setBounds(200,280,150,25);
		add(tfpending);

		 check = new JButton("Check");
		 check.setBackground(Color.black);
		 check.setForeground(Color.white);
		 check.setBounds(30,340,100,30);
		 check.addActionListener(this);
		 add(check);

		Update = new JButton("Update");
		Update.setBackground(Color.black);
		Update.setForeground(Color.white);
		Update.setBounds(150,340,100,30);
		Update.addActionListener(this);
		add(Update);

		Back = new JButton("Back");
		Back.setBackground(Color.black);
		Back.setForeground(Color.white);
		Back.setBounds(270,340,100,30);
		Back.addActionListener(this);
		add(Back);

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/nine.jpg"));
		JLabel l1 = new JLabel(i1);
		l1.setBounds(400, 50, 500, 300);
		add(l1);



		setBounds(300,200,900,500);
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
					tfname.setText(rs.getString("name"));
					tfcheckin.setText(rs.getString("checked_in"));
					tfpaid.setText(rs.getString("deposit"));
				}
				ResultSet rs2 = c.s.executeQuery("select * from room where roomnumber='"+tfroom.getText()+"'");
				while (rs2.next()){
					String price = rs2.getString("price");
					int amountpaid = Integer.parseInt(price)-Integer.parseInt(tfpaid.getText());
					tfpending.setText(""+amountpaid);
				}
			}catch (Exception e)
			{
				e.printStackTrace();
			}

		}else if(ae.getSource()==Update)
		{
			String number = ccustomer.getSelectedItem();
			String room = tfroom.getText();
			String name = tfname.getText();
			String checkin = tfcheckin.getText();
			String deposit = tfpaid.getText();
			try{
				conn c = new conn();
				c.s.executeUpdate("update customer set room='"+room+"', name='"+name+"', checked_in='"+checkin+"', deposit='"+deposit+"' where number='"+number+"'");
				JOptionPane.showMessageDialog(null,"Data Updated successfully");
				setVisible(true);
				new Reception();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}

		}else{
			setVisible(false);
			new Reception();

		}
	}

	public static void main(String[] args) {
		new UpdateCheck();
	}
}