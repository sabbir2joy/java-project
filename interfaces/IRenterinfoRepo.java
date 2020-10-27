package interfaces;

import java.lang.*;

import entity.*;

public interface IRenterinfoRepo
{
	public void insertInDB(Renterinfo r);
	public void deleteFromDB(String renterId);
	public void updateInDB(Renterinfo r);
	public Renterinfo searchRenter(String renterId);
	public String[][] getAllRenter();
}