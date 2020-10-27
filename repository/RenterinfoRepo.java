package repository;

import java.lang.*;
import java.util.ArrayList;
import entity.*;
import interfaces.*;

public class RenterinfoRepo implements IRenterinfoRepo
{
	/**/
	DatabaseConnection dbc;
	
	public RenterinfoRepo()
	{
		dbc = new DatabaseConnection();
	}
    
	public void insertInDB(Renterinfo r)
	{
		String query = "INSERT INTO renterinfo VALUES ('"+r.getRenterId()+"','"+r.getName()+"','"+r.getOccupation()+"','"+r.getAddress()+"','"+r.getPhoneNumber()+"','"+r.getNID()+"');";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}
	public void deleteFromDB(String renterId)
	{
		String query = "DELETE from renterinfo WHERE renterId='"+renterId+"';";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception e){System.out.println(e.getMessage());}
	}
	public void updateInDB(Renterinfo r)
	{
         String query = "UPDATE renterinfo SET name='"+r.getName()+"', occupation = '"+r.getOccupation()+"', Address = '"+r.getAddress()+"', phone_number = '"+r.getPhoneNumber()+"', NID = '"+r.getNID()+"' WHERE renterId ='"+r.getRenterId()+"'";		
		try{
	
			dbc.openConnection();
			dbc.st.executeUpdate(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}
	public  Renterinfo searchRenter( String renterId )
	{
		Renterinfo r = null;
		String query = "SELECT `name`, `occupation`, `Address`,`phone_number`,`NID` FROM `renterinfo` WHERE `renterId`='"+renterId+"';";     
		try
		{
		
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
		
			while(dbc.result.next())
			{
				
				
				String name = dbc.result.getString("name");
				String occupation = dbc.result.getString("occupation");
				String Address = dbc.result.getString("Address");
			    int phonenumber = dbc.result.getInt("phone_number");
				String NID = dbc.result.getString("NID");
				


				
				
				r = new Renterinfo();
				r.setRenterId(renterId);
				r.setName(name);
				r.setOccupation(occupation);
				r.setAddress(Address);
				r.setPhoneNumber(phonenumber);
				r.setNID(NID);
			}
			
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
		dbc.closeConnection();
		return r;
		}
	public String[][] getAllRenter()
	{
		ArrayList<Renterinfo> ar = new ArrayList<Renterinfo>();
		String query = "SELECT * FROM renterinfo;";  
		
		try
		{
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
			
		
			while(dbc.result.next())
			{
				String renterId = dbc.result.getString("renterId");
				String name = dbc.result.getString("name");
				String occupation = dbc.result.getString("occupation");
				String Address = dbc.result.getString("Address");
				int phonenumber = dbc.result.getInt("phone_number");
				String NID = dbc.result.getString("NID");

				
				Renterinfo r = new Renterinfo(renterId,name,occupation,Address,phonenumber,NID);
				ar.add(r);
			}
		}
		catch(Exception r){System.out.println(r.getMessage());}
		dbc.closeConnection();
		
		
		Object obj[] = ar.toArray();
		String data[][] = new String [ar.size()][6];
		
		for(int i=0; i<obj.length; i++)
		{
			data[i][0] = ((Renterinfo)obj[i]).getRenterId();
			data[i][1] = ((Renterinfo)obj[i]).getName();
			data[i][2] = ((Renterinfo)obj[i]).getOccupation();
			data[i][3] = ((Renterinfo)obj[i]).getAddress();
			data[i][4] = (((Renterinfo)obj[i]).getPhoneNumber())+"";
            data[i][5] = (((Renterinfo)obj[i]).getNID())+"";
		}
		return data;
	}
}	