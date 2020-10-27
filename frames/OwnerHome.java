package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import repository.*;
import entity.*;


public class OwnerHome extends JFrame implements ActionListener
{
	JButton logoutBtn, manageOwnerBtn, renterinfoBtn, renterbalanceBtn;
	JPanel panel;
	
	User user;
	
	public OwnerHome(User user)
	{
		super("Welcome in owner Home");
		this.setSize(800,450);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.user = user;
		
		panel = new JPanel();
		panel.setLayout(null);
		
		logoutBtn = new JButton("Logout");
		logoutBtn.setBounds(600, 100, 150, 30);
		logoutBtn.addActionListener(this);
		panel.add(logoutBtn);
		
		
		manageOwnerBtn = new JButton("Manage owner");
		manageOwnerBtn.setBounds(50, 100, 150, 30);
		manageOwnerBtn.addActionListener(this);
		panel.add(manageOwnerBtn);
		
		renterinfoBtn = new JButton("Renterinfo");
		renterinfoBtn.setBounds(225, 100, 150, 30);
		renterinfoBtn.addActionListener(this);
		panel.add(renterinfoBtn);
		
		
		renterbalanceBtn = new JButton("Renter Balance");
		renterbalanceBtn.setBounds(400, 100, 150, 30);
		renterbalanceBtn.addActionListener(this);
		panel.add(renterbalanceBtn);
		
		this.add(panel);
	
		
	}
	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();
		
		if(command.equals(logoutBtn.getText()))
		{
			LoginFrame lf = new LoginFrame();
			lf.setVisible(true);
			this.setVisible(false);
		}
		else if(command.equals(manageOwnerBtn.getText()))
		{
			if(user.getStatus()==0)
			{
				OwnerFrame mf = new OwnerFrame(user);
				mf.setVisible(true);
				this.setVisible(false);
			}
			else
			{
				JOptionPane.showMessageDialog(this, "Access Denied");
			}
		}
		else if(command.equals(renterinfoBtn.getText()))
		{
			if(user.getStatus()==0)
			{
				RenterinfoFrame am = new RenterinfoFrame(user);
				am.setVisible(true);
				this.setVisible(false);
				
			}
			else
			{
				JOptionPane.showMessageDialog(this, "Access Denied");
			}
		}
		else if(command.equals(renterbalanceBtn.getText()))
		{
			if(user.getStatus()==0 || user.getStatus()==1)
			{
				RenterbalanceFrame bf = new RenterbalanceFrame(user);
				bf.setVisible(true);
				this.setVisible(false);
			}
			else{}
		}
		else{}
	}
}