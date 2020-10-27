package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import repository.*;
import entity.*;


public class OwnerFrame extends JFrame implements ActionListener
{
	private JLabel ownerIdLabel, ownerNameLabel;
	private JTextField ownerIdTF, ownerNameTF;
	private JButton loadBtn, updateBtn, deleteBtn, refreshBtn, getAllBtn, backBtn;
	private JPanel panel;
	private JTable ownerTable;
	private JScrollPane ownerTableSP;
	
	private User user;
	private OwnerRepo or;
	private UserRepo ur;
	
	
	public OwnerFrame(User user)
	{
		super("Owner Frame");
		this.setSize(800,450);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.user = user;
		
		or = new OwnerRepo();
		ur = new UserRepo();
		
		panel = new JPanel();
		panel.setLayout(null);
		
		
		
		String data[][] = {{"", ""}};
		
		String head[] = {"ownerId", "Name"};
		
		ownerTable = new JTable(data,head);
		ownerTableSP = new JScrollPane(ownerTable);
		ownerTableSP.setBounds(350, 100, 400, 150);
		ownerTable.setEnabled(false);
		panel.add(ownerTableSP);
		
		ownerIdLabel = new JLabel("ownerId :");
		ownerIdLabel.setBounds(100,100,100,30);
		panel.add(ownerIdLabel);
		
		ownerIdTF = new JTextField();
		ownerIdTF.setBounds(220,100,100,30);
		panel.add(ownerIdTF);
		
		ownerNameLabel = new JLabel("name :");
		ownerNameLabel.setBounds(100,150,100,30);
		panel.add(ownerNameLabel);
		
		ownerNameTF = new JTextField();
		ownerNameTF.setBounds(220,150,100,30);
		panel.add(ownerNameTF);
		
		
		loadBtn = new JButton("Load");
		loadBtn.setBounds(100,300,80,30);
		loadBtn.addActionListener(this);
		panel.add(loadBtn);
		
		
		
		updateBtn = new JButton("Update");
		updateBtn.setBounds(300,300,80,30);
		updateBtn.addActionListener(this);
		updateBtn.setEnabled(false);
		panel.add(updateBtn);
		
		deleteBtn = new JButton("Delete");
		deleteBtn.setBounds(400,300,80,30);
		deleteBtn.addActionListener(this);
		deleteBtn.setEnabled(false);
		panel.add(deleteBtn);
		
		refreshBtn = new JButton("Refresh");
		refreshBtn.setBounds(500,300,80,30);
		refreshBtn.addActionListener(this);
		refreshBtn.setEnabled(false);
		panel.add(refreshBtn);
		
		getAllBtn = new JButton("Get All");
		getAllBtn.setBounds(500,260,80,30);
		getAllBtn.addActionListener(this);
		panel.add(getAllBtn);
		
		backBtn = new JButton("Back");
		backBtn.setBounds(600, 350, 80, 30);
		backBtn.addActionListener(this);
		panel.add(backBtn);
		
		this.add(panel);
	}
	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();
		
		if(command.equals(loadBtn.getText()))
		{
			if(!ownerIdTF.getText().equals("") || !ownerIdTF.getText().equals(null))
			{
				Owner e = or.searchOwner(ownerIdTF.getText());
				if(e!= null)
				{
					ownerNameTF.setText(e.getOwnerName()+"");
					
					ownerIdTF.setEnabled(false);
					ownerNameTF.setEnabled(true);
					
					
					updateBtn.setEnabled(true);
					deleteBtn.setEnabled(true);
					refreshBtn.setEnabled(true);
					loadBtn.setEnabled(false);
				}
				else
				{
					JOptionPane.showMessageDialog(this,"Invaild ID");
				}
			}
		}
		
		else if(command.equals(refreshBtn.getText()))
		{
			ownerIdTF.setText("");
			ownerNameTF.setText("");
			
			
			ownerIdTF.setEnabled(true);
			loadBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
		}
		else if(command.equals(updateBtn.getText()))
		{
			Owner e = new Owner();
			
			e.setOwnerId(ownerIdTF.getText());
			e.setOwnerName(ownerNameTF.getText());
			
			
			or.updateInDB(e);
			
			JOptionPane.showMessageDialog(this, "Updated");
			
			ownerIdTF.setText("");
			ownerNameTF.setText("");
			
			
			loadBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
			
			ownerIdTF.setEnabled(true);
			ownerNameTF.setEnabled(true);
			
		}
		else if(command.equals(deleteBtn.getText()))
		{
			or.deleteFromDB(ownerIdTF.getText());
			ur.deleteUser(ownerIdTF.getText());
			
			JOptionPane.showMessageDialog(this,"Deleted");
			
			ownerIdTF.setText("");
			ownerNameTF.setText("");
			
			
			ownerIdTF.setEnabled(true);
			ownerNameTF.setEnabled(true);
			
	
			loadBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
		}
		else if(command.equals(getAllBtn.getText()))
		{
			String data[][] = or.getAllOwner();
			String head[] = {"ownerId", "name"};
			
			panel.remove(ownerTableSP);
			
			ownerTable = new JTable(data,head);
			ownerTable.setEnabled(false);
			ownerTableSP = new JScrollPane(ownerTable);
			ownerTableSP.setBounds(350, 100, 400, 150);
			panel.add(ownerTableSP);
			
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