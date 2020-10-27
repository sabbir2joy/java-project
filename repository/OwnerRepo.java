package repository;

import java.lang.*;
import java.util.ArrayList;
import entity.*;
import interfaces.*;

public class OwnerRepo implements IOwnerRepo
{
	DatabaseConnection dbc;
	
	public OwnerRepo()
	{
		dbc = new DatabaseConnection();
	}
	
	public void insertInDB(Owner o)
	{
		String query = "INSERT INTO owner VALUES ('"+o.getOwnerId()+"',"+o.getOwnerName()+");";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}
	
	public void deleteFromDB(String ownerId)
	{
		String query = "DELETE from owner WHERE ownerId='"+ownerId+"';";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception e){System.out.println(e.getMessage());}
	}
	
	public void updateInDB(Owner o)
	{
		String query = "UPDATE owner SET Name='"+o.getOwnerName()+"' WHERE ownerId='"+o.getOwnerId()+"'";
		
		try
		{
			dbc.openConnection();
			dbc.st.executeUpdate(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}
	
	public Owner searchOwner(String ownerId)
	{
		Owner m = null;
		String query = "SELECT `Name` FROM `owner` WHERE `ownerId`='"+ownerId+"';";     
		try
		{
		
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
		
			while(dbc.result.next())
			{
				
				String name = dbc.result.getString("name");
				
				
				m = new Owner();
				m.setOwnerId(ownerId);
				m.setOwnerName(name);
			
				
			}
			
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
		dbc.closeConnection();
		return m;
	}
	
	public String[][] getAllOwner()
	{
		ArrayList<Owner> ar = new ArrayList<Owner>();
		String query = "SELECT * FROM owner;";  
		
		try
		{
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
			
		
			while(dbc.result.next())
			{
				String ownerId = dbc.result.getString("ownerId");
				String name = dbc.result.getString("Name");
				
				
				Owner o2 = new Owner(ownerId,name);
				ar.add(o2);
			}
		}
		catch(Exception o2){System.out.println(o2.getMessage());}
		dbc.closeConnection();
		
		
		Object obj[] = ar.toArray();
		String data[][] = new String [ar.size()][2];
		
		for(int i=0; i<obj.length; i++)
		{
			data[i][0] = ((Owner)obj[i]).getOwnerId();
			data[i][1] = ((Owner)obj[i]).getOwnerName();
			
		}
		return data;
	}
		
}
