package com.fixer.bean;


import java.io.Serializable;
import java.util.Map;

//import javax.persistence.Entity;
//@Entity
public class FixerCurrencyRates implements Serializable  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean success;
	private int timestamp;
	private String base;
	private String date;
	private Map<String,String> rates;
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public int getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(int timestamp) {
		this.timestamp = timestamp;
	}
	public String getBase() {
		return base;
	}
	public void setBase(String base) {
		this.base = base;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	
	public Map<String, String> getRates() {
		return rates;
	}
	public void setRates(Map<String, String> rates) {
		this.rates = rates;
	}
	@Override
	public String toString() {
		return "FixerCurrencyRates [success=" + success + ", timestamp=" + timestamp + ", base=" + base + ", date="
				+ date + ", rates=" + rates + "]";
	}
	

}
