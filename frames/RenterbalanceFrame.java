package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import repository.*;
import entity.*;


public class RenterbalanceFrame extends JFrame implements ActionListener
{
	private JLabel userIdLabel, electricitybillLabel, waterbillLabel, gasbillLabel, homeservicebillLabel , houserentLabel ,penaltyLabel;
	private JTextField userIdTF, electricitybillTF, waterbillTF, gasbillTF , homeservicebillTF , houserentTF , penaltyTF;
	private JButton loadBtn, insertBtn, updateBtn, deleteBtn, refreshBtn, getAllBtn, backBtn;
	private JPanel panel;
	private JTable renterbalanceTable;
	private JScrollPane renterbalanceTableSP;
	
	private User user;
	private RenterBalanceRepo rbr;
	private UserRepo ur;
	
	
	public RenterbalanceFrame(User user)
	{
		super("Renter Balance");
		this.setSize(1100,700);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.user = user;
		
		rbr = new RenterBalanceRepo();
		ur = new UserRepo();
		
		panel = new JPanel();
		panel.setLayout(null);
		
		
		
		String data[][] = {{"", "", "", "", "", ""}};
		
		String head[] = {"electricitbill", "waterbill", "gasbill", "homeservicebill", "houserent", "penalty"};
		
		renterbalanceTable = new JTable(data,head);
		renterbalanceTableSP = new JScrollPane(renterbalanceTable);
		renterbalanceTableSP.setBounds(300, 80, 700, 300);
		renterbalanceTable.setEnabled(false);
		panel.add(renterbalanceTableSP);
		
		userIdLabel = new JLabel("userId :");
		userIdLabel.setBounds(50,80,100,30);
		panel.add(userIdLabel);
		
		userIdTF = new JTextField();
		userIdTF.setBounds(150,80,100,30);
		panel.add(userIdTF);
		
		electricitybillLabel = new JLabel("electricitybill :");
		electricitybillLabel.setBounds(50,120,100,30);
		panel.add(electricitybillLabel);
		
		electricitybillTF= new JTextField();
		electricitybillTF.setBounds(150,120,100,30);
		panel.add(electricitybillTF);
		
		waterbillLabel = new JLabel("waterbill: ");
		waterbillLabel.setBounds(50,160,100,30);
		panel.add(waterbillLabel);
		
		waterbillTF = new JTextField();
		waterbillTF.setBounds(150,160,100,30);
		panel.add(waterbillTF);
		
		gasbillLabel = new JLabel("gasbill: ");
		gasbillLabel.setBounds(50,200,100,30);
		panel.add(gasbillLabel);
		
		gasbillTF = new JTextField();
		gasbillTF.setBounds(150,200,100,30);
		panel.add(gasbillTF);
		
		homeservicebillLabel = new JLabel("homeservicebill: ");
		homeservicebillLabel.setBounds(50,240,100,30);
		panel.add(homeservicebillLabel);
		
		homeservicebillTF = new JTextField();
		homeservicebillTF.setBounds(150,240,100,30);
		panel.add(homeservicebillTF);
		
		houserentLabel = new JLabel("houserent: ");
		houserentLabel.setBounds(50,280,100,30);
		panel.add(houserentLabel);
		
		houserentTF = new JTextField();
		houserentTF.setBounds(150,280,100,30);
		panel.add(houserentTF);
		
		penaltyLabel = new JLabel("penalty: ");
		penaltyLabel.setBounds(50,320,100,30);
		panel.add(penaltyLabel);
		
		penaltyTF = new JTextField();
		penaltyTF.setBounds(150,320,100,30);
		panel.add(penaltyTF);
		
		
		
	
		loadBtn = new JButton("Load");
		loadBtn.setBounds(30,500,80,30);
		loadBtn.addActionListener(this);
		panel.add(loadBtn);
		
		insertBtn = new JButton("Insert");
		insertBtn.setBounds(120,500,80,30);
		insertBtn.addActionListener(this);
		panel.add(insertBtn);
		
		updateBtn = new JButton("Update");
		updateBtn.setBounds(210,500,80,30);
		updateBtn.addActionListener(this);
		updateBtn.setEnabled(false);
		panel.add(updateBtn);
		
		deleteBtn = new JButton("Delete");
		deleteBtn.setBounds(300,500,80,30);
		deleteBtn.addActionListener(this);
		deleteBtn.setEnabled(false);
		panel.add(deleteBtn);
		
		refreshBtn = new JButton("Refresh");
		refreshBtn.setBounds(390,500,80,30);
		refreshBtn.addActionListener(this);
		refreshBtn.setEnabled(false);
		panel.add(refreshBtn);
		
		backBtn = new JButton("Back");
		backBtn.setBounds(920,600,80,30);
		backBtn.addActionListener(this);
		panel.add(backBtn);
		
		getAllBtn = new JButton("Get All");
		getAllBtn.setBounds(920, 420, 80, 30);
		getAllBtn.addActionListener(this);
		panel.add(getAllBtn);
		
		this.add(panel);
	}
	
	
	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();
		
		if(command.equals(loadBtn.getText()))
		{
			if(!userIdTF.getText().equals("") || !userIdTF.getText().equals(null))
			{
				RenterBalance rb = rbr.searchRenterBalance(userIdTF.getText());
				
				
				if(rb!= null)
				{
					electricitybillTF.setText(rb.getEbill()+"");
					waterbillTF.setText(rb.getWbill()+"");
				    gasbillTF.setText(rb.getGbill()+"");
					homeservicebillTF.setText(rb.getHomeService()+"");
					houserentTF.setText(rb.getHRent()+"");
                    penaltyTF.setText(rb.getPenalty()+"");
					
					userIdTF.setEnabled(false);
					electricitybillTF.setEnabled(true);
					waterbillTF.setEnabled(true);
					gasbillTF.setEnabled(true);
					homeservicebillTF.setEnabled(true);
					houserentTF.setEnabled(true);
					penaltyTF.setEnabled(true);


					
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
			if(user.getStatus()==0)
			{
		    
		    RenterBalance rb = new RenterBalance();
			User u = new User();
			
			rb.setRBId(userIdTF.getText());
			rb.setEbill(Double.parseDouble(electricitybillTF.getText()));
			rb.setWbill(Double.parseDouble(waterbillTF.getText()));
			rb.setGbill(Double.parseDouble(gasbillTF.getText()));
			rb.setHomeService(Double.parseDouble(homeservicebillTF.getText()));
			rb.setHRent(Double.parseDouble(houserentTF.getText()));
			rb.setPenalty(Double.parseDouble(penaltyTF.getText()));
			
			u.setUserId(userIdTF.getText());
			
			rbr.insertInDB(rb);
			ur.insertUser(u);
			}
			else
			{
				JOptionPane.showMessageDialog(this, "Access Denied");
			}
			
			
			JOptionPane.showMessageDialog(this, "Inserted, Id: "+userIdTF.getText());
			
			userIdTF.setText("");
			electricitybillTF.setText("");
			waterbillTF.setText("");
			gasbillTF.setText("");
		    homeservicebillTF.setText("");
			houserentTF.setText("");
			penaltyTF.setText("");

			
			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
			
		}
		else if(command.equals(refreshBtn.getText()))
		{
			userIdTF.setText("");
			electricitybillTF.setText("");
			waterbillTF.setText("");
			gasbillTF.setText("");
			homeservicebillTF.setText("");
			houserentTF.setText("");
			penaltyTF.setText("");
			
			userIdTF.setEnabled(true);
			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
		}
		else if(command.equals(updateBtn.getText()))
		{
			if(user.getStatus()==0)
			{
		    RenterBalance rb = new RenterBalance();
			rb.setRBId(userIdTF.getText());
			rb.setEbill(Double.parseDouble(electricitybillTF.getText()));
			rb.setWbill(Double.parseDouble(waterbillTF.getText()));
			rb.setGbill(Double.parseDouble(gasbillTF.getText()));
			rb.setHomeService(Double.parseDouble(homeservicebillTF.getText()));
			rb.setHRent(Double.parseDouble(houserentTF.getText()));
			rb.setPenalty(Double.parseDouble(penaltyTF.getText()));
			
			rbr.updateInDB(rb);
			
			JOptionPane.showMessageDialog(this, "Hurrah ! Updated");
			
			userIdTF.setText("");
			electricitybillTF.setText("");
			waterbillTF.setText("");
			gasbillTF.setText("");
			homeservicebillTF.setText("");
			houserentTF.setText("");
			penaltyTF.setText("");

			
			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
			
			userIdTF.setEnabled(true);
			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
			}
			else
			{
				JOptionPane.showMessageDialog(this, "Access Denied");
			}
			
		}
		else if(command.equals(deleteBtn.getText()))
		{
						if(user.getStatus()==0)
						{
			rbr.deleteFromDB(userIdTF.getText());
			ur.deleteUser(userIdTF.getText());
			
			JOptionPane.showMessageDialog(this,"Deleted!");
			
			userIdTF.setText("");
			electricitybillTF.setText("");
			waterbillTF.setText("");
			gasbillTF.setText("");
			homeservicebillTF.setText("");
			houserentTF.setText("");
			penaltyTF.setText("");
			
			
			userIdTF.setEnabled(true);
			userIdTF.setEnabled(true);
			userIdTF.setEnabled(true);
			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
	
			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
						}
				else
			{
				JOptionPane.showMessageDialog(this, "Access Denied");
			}
						
		}
		else if(command.equals(getAllBtn.getText()))
		{
			String data[][] = rbr.getAllRenterBalance();
			String head[] = {"renterbalanceId", "electricitybill", "waterbill", "gasbill", "homeservicebill", "houserent",  "penalty"};
			
			panel.remove(renterbalanceTableSP);
			
			renterbalanceTable = new JTable(data,head);
			renterbalanceTable.setEnabled(false);
			renterbalanceTableSP = new JScrollPane(renterbalanceTable);
			renterbalanceTableSP.setBounds(300, 80, 700, 300);
			panel.add(renterbalanceTableSP);
			
			panel.revalidate();
			panel.repaint();
			
		}
		else if(command.equals(backBtn.getText()))
		{
			OwnerHome oh = new OwnerHome(user);
			oh.setVisible(true);
			this.setVisible(false);
		}
		else{}
		
	}	

}
	