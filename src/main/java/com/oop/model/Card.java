package com.oop.model;

public class Card {
	private String CardNum;
	private String ExMonth;
	private String CVC;
	private String PaymentNet;
	private String bankName;
	
	public String getCardNum() {
		return CardNum;
	}
	public void setCardNum(String cardNum) {
		CardNum = cardNum;
	}
	public String getExMonth() {
		return ExMonth;
	}
	public void setExMonth(String exMonth) {
		ExMonth = exMonth;
	}
	public String getCVC() {
		return CVC;
	}
	public void setCVC(String cVC) {
		CVC = cVC;
	}
	public String getPaymentNet() {
		return PaymentNet;
	}
	public void setPaymentNet(String paymentNet) {
		PaymentNet = paymentNet;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	
	
}
