package entity;

import java.lang.*;
public class Renterinfo
{
	private String renterId;
	private String name;
	private String occupation;
	private String Address ;
	private int phonenumber;
	private String NID;
	public Renterinfo(){}
	public Renterinfo(String renterId, String name, String occupation, String Address, int phonenumber, String NID)
	{
		this.renterId = renterId;
		this.name = name;
		this.occupation = occupation;
		this.Address = Address;
		this.phonenumber = phonenumber;
		this.NID = NID ;
	}
	
	public void setRenterId(String renterId){this.renterId = renterId;}
	public void setName(String name){this.name = name;}
	public void setOccupation(String occupation){this.occupation = occupation;}
	public void setAddress(String Address){this.Address = Address;}
	public void setPhoneNumber(int phonenumber){ this.phonenumber = phonenumber;}
	public void setNID(String NID) { this.NID = NID; }
	
	public String getRenterId(){return renterId;}
	public String getName(){return name;}
	public String getOccupation(){return occupation;}
	public String getAddress(){return Address;}
	public int getPhoneNumber() { return phonenumber;}
	public String getNID() { return NID; }
	
}