package interfaces;

import java.lang.*;

import entity.*;

public interface IOwnerRepo
{	
	public void insertInDB(Owner o);
	public void deleteFromDB(String ownerId);
	public void updateInDB(Owner o);
	public Owner searchOwner(String ownerId);
	public String[][] getAllOwner();
	
}
