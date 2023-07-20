package com.oop.model;

public class Payment {

	private String PID;
	private String Reason;
	private String UsedCard;
	private double Amount;
	private String PaidDate;
	public String getPID() {
		return PID;
	}
	public void setPID(String pID) {
		PID = pID;
	}
	public String getReason() {
		return Reason;
	}
	public void setReason(String reason) {
		Reason = reason;
	}
	public String getUsedCard() {
		return UsedCard;
	}
	public void setUsedCard(String usedCard) {
		UsedCard = usedCard;
	}
	public double getAmount() {
		return Amount;
	}
	public void setAmount(double amount) {
		Amount = amount;
	}
	public String getPaidDate() {
		return PaidDate;
	}
	public void setPaidDate(String paidDate) {
		PaidDate = paidDate;
	}
	
	
}
