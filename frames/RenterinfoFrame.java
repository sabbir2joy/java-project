package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import repository.*;
import entity.*;


public class RenterinfoFrame extends JFrame implements ActionListener
{
	private JLabel renterIdLabel, nameLabel, occupationLabel, AddressLabel, phonenumberLabel, NIDLabel;
	private JTextField renterIdTF, nameTF,occupationTF, AddressTF, phonenumberTF, NIDTF;
	private JButton loadBtn, insertBtn, updateBtn, deleteBtn, refreshBtn, getAllBtn, backBtn;
	private JPanel panel;
	private JTable renterinfoTable;
	private JScrollPane renterinfoTableSP;
	
	private User user;
	private RenterinfoRepo er;
	private UserRepo ur;
	
	
	public RenterinfoFrame(User user)
	{
		super("Renter Info Frame");
		this.setSize(1200,800);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.user = user;
		
		er = new RenterinfoRepo();
		ur = new UserRepo();
		
		panel = new JPanel();
		panel.setLayout(null);
		
		
		
		String data[][] = {{"", "", "", "", "", ""}};
		
		String head[] = {"Id", "Name", "occupation", "Address", "phonenumber", "NID"};
		
		renterinfoTable = new JTable(data,head);
		renterinfoTableSP = new JScrollPane(renterinfoTable);
		renterinfoTableSP.setBounds(350, 50, 700, 250);
		renterinfoTable.setEnabled(false);
		panel.add(renterinfoTableSP);
		
		renterIdLabel = new JLabel("ID :");
		renterIdLabel.setBounds(100,50,100,30);
		panel.add(renterIdLabel);
		
		renterIdTF = new JTextField();
		renterIdTF.setBounds(220,50,100,30);
		panel.add(renterIdTF);
		
		nameLabel = new JLabel("Name :");
		nameLabel.setBounds(100,100,100,30);
		panel.add(nameLabel);
		
		nameTF = new JTextField();
		nameTF.setBounds(220,100,100,30);
		panel.add(nameTF);
		
		occupationLabel = new JLabel("Occupation: ");
		occupationLabel.setBounds(100,150,100,30);
		panel.add(occupationLabel);
		
		occupationTF = new JTextField();
		occupationTF.setBounds(220,150,100,30);
		panel.add(occupationTF);
		
		AddressLabel = new JLabel("Address: ");
		AddressLabel.setBounds(100,200,100,30);
		panel.add(AddressLabel);
		
		AddressTF = new JTextField();
		AddressTF.setBounds(220,200,100,30);
		panel.add(AddressTF);
		
		phonenumberLabel = new JLabel("Phone Number: ");
		phonenumberLabel.setBounds(100,250,100,30);
		panel.add(phonenumberLabel);
		
		phonenumberTF = new JTextField();
		phonenumberTF.setBounds(220,250,100,30);
		panel.add(phonenumberTF);
		
		NIDLabel = new JLabel("NID: ");
		NIDLabel.setBounds(100,300,100,30);
		panel.add(NIDLabel);
		
		NIDTF = new JTextField();
		NIDTF.setBounds(220,300,100,30);
		panel.add(NIDTF);
		
		loadBtn = new JButton("Load");
		loadBtn.setBounds(100,350,80,30);
		loadBtn.addActionListener(this);
		panel.add(loadBtn);
		
		insertBtn = new JButton("Insert");
		insertBtn.setBounds(200,350,80,30);
		insertBtn.addActionListener(this);
		panel.add(insertBtn);
		
		updateBtn = new JButton("Update");
		updateBtn.setBounds(300,350,80,30);
		updateBtn.addActionListener(this);
		updateBtn.setEnabled(false);
		panel.add(updateBtn);
		
		deleteBtn = new JButton("Delete");
		deleteBtn.setBounds(400,350,80,30);
		deleteBtn.addActionListener(this);
		deleteBtn.setEnabled(false);
		panel.add(deleteBtn);
		
		refreshBtn = new JButton("Refresh");
		refreshBtn.setBounds(500,350,80,30);
		refreshBtn.addActionListener(this);
		refreshBtn.setEnabled(false);
		panel.add(refreshBtn);
		
		getAllBtn = new JButton("Get All");
		getAllBtn.setBounds(500,310,80,30);
		getAllBtn.addActionListener(this);
		panel.add(getAllBtn);
		
		backBtn = new JButton("Back");
		backBtn.setBounds(600, 400, 80, 30);
		backBtn.addActionListener(this);
		panel.add(backBtn);
		
		this.add(panel);
	}
	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();
		
		if(command.equals(loadBtn.getText()))
		{
			if(!renterIdTF.getText().equals("") || !renterIdTF.getText().equals(null))
			{
				Renterinfo e = er.searchRenter(renterIdTF.getText());
				if(e!= null)
				{
					nameTF.setText(e.getName());
					occupationTF.setText(e.getOccupation());
					AddressTF.setText(e.getAddress());
					phonenumberTF.setText(e.getPhoneNumber()+"");
					NIDTF.setText(e.getNID()+"");
					
					renterIdTF.setEnabled(false);
					nameTF.setEnabled(true);
					occupationTF.setEnabled(true);
					AddressTF.setEnabled(true);
					phonenumberTF.setEnabled(true);
					NIDTF.setEnabled(true);
					
					updateBtn.setEnabled(true);
					deleteBtn.setEnabled(true);
					refreshBtn.setEnabled(true);
					insertBtn.setEnabled(false);
					loadBtn.setEnabled(false);
				}
				else
				{
					JOptionPane.showMessageDialog(this,"Invaild ID");
				}
			}
		}
		else if(command.equals(insertBtn.getText()))
		{
			Renterinfo e = new Renterinfo();
			User u = new User();
			Random rd = new Random();
			int x = rd.nextInt(9999999)+10000000;
			
			e.setRenterId(renterIdTF.getText());
			e.setName(nameTF.getText());
			e.setOccupation(occupationTF.getText());
			e.setAddress(AddressTF.getText());
			e.setPhoneNumber(Integer.parseInt(phonenumberTF.getText()));
			e.setNID(NIDTF.getText());
			
			u.setUserId(renterIdTF.getText());
			u.setPassword(x+"");
			u.setStatus(1);
			
		
			
			er.insertInDB(e);
			ur.insertUser(u);
			
			JOptionPane.showMessageDialog(this, "Inserted, Id: "+renterIdTF.getText()+"and Password: "+x);
			
			renterIdTF.setText("");
			nameTF.setText("");
			occupationTF.setText("");
			AddressTF.setText("");
			phonenumberTF.setText("");
			NIDTF.setText("");
			
			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
			
		}
		else if(command.equals(refreshBtn.getText()))
		{
			renterIdTF.setText("");
			nameTF.setText("");
			occupationTF.setText("");
			AddressTF.setText("");
			phonenumberTF.setText("");
			NIDTF.setText("");
			
			renterIdTF.setEnabled(true);
			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
		}
		else if(command.equals(updateBtn.getText()))
		{
			Renterinfo e = new Renterinfo();
			
			e.setRenterId(renterIdTF.getText());
			e.setName(nameTF.getText());
			e.setOccupation(occupationTF.getText());
			e.setAddress(AddressTF.getText());
			e.setPhoneNumber(Integer.parseInt(phonenumberTF.getText()));
			e.setNID(NIDTF.getText());
			
			er.updateInDB(e);
			
			JOptionPane.showMessageDialog(this, "Updated");
			
			renterIdTF.setText("");
			nameTF.setText("");
			occupationTF.setText("");
			AddressTF.setText("");
			phonenumberTF.setText("");
			NIDTF.setText("");
			
			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
			
			renterIdTF.setEnabled(true);
			nameTF.setEnabled(true);
			occupationTF.setEnabled(true);
			AddressTF.setEnabled(true);
			phonenumberTF.setEnabled(true);
			NIDTF.setEnabled(true);
		}
		else if(command.equals(deleteBtn.getText()))
		{
			er.deleteFromDB(renterIdTF.getText());
			ur.deleteUser(renterIdTF.getText());
			
			JOptionPane.showMessageDialog(this,"Deleted");
			
			renterIdTF.setText("");
			nameTF.setText("");
			occupationTF.setText("");
			AddressTF.setText("");
			phonenumberTF.setText("");
			NIDTF.setText("");
			
			renterIdTF.setEnabled(true);
			nameTF.setEnabled(true);
			occupationTF.setEnabled(true);
			AddressTF.setEnabled(true);
			phonenumberTF.setEnabled(true);
			NIDTF.setEnabled(true);
	
			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
		}
		else if(command.equals(getAllBtn.getText()))
		{
			String data[][] = er.getAllRenter();
			String head[] = {"Id", "Name", "Occupation", "Address", "Phone Number", "NID"};
			
			panel.remove(renterinfoTableSP);
			
			renterinfoTable = new JTable(data,head);
			renterinfoTable.setEnabled(false);
			renterinfoTableSP = new JScrollPane(renterinfoTable);
			renterinfoTableSP.setBounds(350, 50, 700, 250);
			panel.add(renterinfoTableSP);
			
			panel.revalidate();
			panel.repaint();
			
		}
		else if(command.equals(backBtn.getText()))
		{
			OwnerHome mh = new OwnerHome(user);
			mh.setVisible(true);
			this.setVisible(false);
		}
		else{}
		
	}
	

}