package interfaces;

import java.lang.*;

import entity.*;

public interface IRenterBalanceRepo
{
	public void insertInDB(RenterBalance b);
	public void deleteFromDB(String renterbalanceId);
	public void updateInDB(RenterBalance b);
	public RenterBalance searchRenterBalance(String renterbalanceId);
	public String[][] getAllRenterBalance();
}