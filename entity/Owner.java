package entity;

import java.lang.*;

public class Owner
{
	private String ownerId;
	private String name;

	
	
	public Owner(){}
	public Owner(String ownerId, String name)
	{
		this.ownerId = ownerId;
		this.name = name;
		
	}
	
	public void setOwnerId(String ownerId){this.ownerId = ownerId;}
	public void setOwnerName(String name){this.name = name;}
	
	
	public String getOwnerId(){return ownerId;}
	public String getOwnerName(){return name;}
	
	
}
