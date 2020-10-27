package entity;

import java.lang.*;
public class RenterBalance
{
	private String renterbalanceId;
	private double electricitybill;
	private double waterbill;
	private double gasbill ;
	private double homeservicebill;
	private double houserent ;
	private double penalty;
	public RenterBalance(){}
	public RenterBalance(String renterbalanceId, double electricitybill, double waterbill, double gasbill, double homeservicebill, double houserent, double penalty)
	{
		this.renterbalanceId = renterbalanceId;
		this.electricitybill = electricitybill ;
		this.waterbill = waterbill;
		this.gasbill = gasbill;
		this.homeservicebill = homeservicebill;
		this.houserent = houserent ;
		this.penalty = penalty;
	}
	
	public void setRBId(String renterbalanceId){this.renterbalanceId = renterbalanceId;}
	public void setEbill(double electricitybill){this.electricitybill = electricitybill;}
	public void setWbill(double waterbill){this.waterbill = waterbill;}
	public void setGbill(double gasbill){this.gasbill = gasbill;}
	public void setHomeService(double homeservicebill){ this.homeservicebill = homeservicebill;}
	public void setHRent(double houserent) { this.houserent = houserent; }
	public void setPenalty(double penalty) { this.penalty = penalty ;}
	
	public String getRBId(){return renterbalanceId;}
	public double getEbill(){return electricitybill;}
	public double getWbill(){return waterbill;}
	public double getGbill(){return gasbill;}
	public double getHomeService() { return homeservicebill;}
	public double getHRent () {  return houserent ; }
	public double getPenalty() { return penalty; }
	
}