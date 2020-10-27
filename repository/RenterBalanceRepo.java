package repository;
import java.lang.*;
import java.util.ArrayList;
import entity.*;
import interfaces.*;

public class RenterBalanceRepo implements IRenterBalanceRepo
{
	DatabaseConnection dbc;
	
	public RenterBalanceRepo()
	{
		dbc = new DatabaseConnection();
	}
	
	public void insertInDB(RenterBalance b)
	{
		String query = "INSERT INTO renterbalance VALUES ('"+b.getRBId()+"','"+b.getEbill()+"','"+b.getWbill()+"','"+b.getGbill()+"','"+b.getHomeService()+"','"+b.getHRent()+"',"+b.getPenalty()+");";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}
	
	public void deleteFromDB(String renterbalanceId)
	{
		String query = "DELETE from renterbalance WHERE renterbalanceId='"+renterbalanceId+"';";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception e){System.out.println(e.getMessage());}
	}
	public void updateInDB(RenterBalance b)
	{
		String query = "UPDATE renterbalance SET electricitybill='"+b.getEbill()+"', waterbill = '"+b.getWbill()+"',gasbill = '"+b.getGbill()+"',homeservicebill = '"+b.getHomeService()+"',houserent = '"+b.getHRent()+"', penalty = '"+b.getPenalty()+"' WHERE renterbalanceId='"+b.getRBId()+"'";
		
		try
		{
			dbc.openConnection();
			dbc.st.executeUpdate(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}
	
	
	public RenterBalance searchRenterBalance(String renterbalanceId)
	{
		RenterBalance rb = null;
		String query = "SELECT `electricitybill`, `waterbill`, `gasbill`,`homeservicebill`,`houserent`,`penalty` FROM `renterBalance` WHERE `renterbalanceId`='"+renterbalanceId+"';";     
		try
		{
		
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
		
			while(dbc.result.next())
			{
				
				double electricitybill = dbc.result.getDouble("electricitybill");
				double waterbill = dbc.result.getDouble("waterbill");
				double gasbill = dbc.result.getDouble("gasbill");
				double homeservicebill = dbc.result.getDouble("homeservicebill");
				double houserent = dbc.result.getDouble("houserent");
				double penalty = dbc.result.getDouble("penalty");
				
				rb = new RenterBalance();
				rb.setRBId(renterbalanceId);
				rb.setEbill(electricitybill);
				rb.setWbill(waterbill);
				rb.setGbill(gasbill);
				rb.setHomeService(homeservicebill);
				rb.setHRent(houserent);
				rb.setPenalty(penalty);
			}
			
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
		dbc.closeConnection();
		return rb;
	}
	public String[][] getAllRenterBalance()
	{
		ArrayList<RenterBalance> ar = new ArrayList<RenterBalance>();
		String query = "SELECT * FROM renterbalance;";  
		
		try
		{
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
			
		
			while(dbc.result.next())
			{
				String renterbalanceId = dbc.result.getString("renterbalanceId");
				double electricitybill = dbc.result.getDouble("electricitybill");
				double waterbill = dbc.result.getDouble("waterbill");
				double gasbill = dbc.result.getDouble("gasbill");
				double homeservicebill = dbc.result.getDouble("homeservicebill");
				double houserent = dbc.result.getDouble("houserent");
				double penalty = dbc.result.getDouble("penalty");
				
				RenterBalance re = new RenterBalance(renterbalanceId,electricitybill,waterbill,gasbill,homeservicebill,houserent,penalty);
				ar.add(re);
			}
		}
		catch(Exception re){System.out.println(re.getMessage());}
		dbc.closeConnection();
		
		
		Object obj[] = ar.toArray();
		String data[][] = new String [ar.size()][7];
		
		for(int i=0; i<obj.length; i++)
		{
			data[i][0] = ((RenterBalance)obj[i]).getRBId();
			data[i][1] = (((RenterBalance)obj[i]).getEbill())+"";
			data[i][2] = (((RenterBalance)obj[i]).getWbill())+"";
			data[i][3] = (((RenterBalance)obj[i]).getGbill())+"";
			data[i][4] = (((RenterBalance)obj[i]).getHomeService())+"";
			data[i][5] = (((RenterBalance)obj[i]).getHRent())+"";
			data[i][6] = (((RenterBalance)obj[i]).getPenalty())+"";
		}
		return data;
	}
	
}