package com.fixer.bean;

public class CurrencyRates {

	private int id;
	private String baseCurrency;
	private String toCurrency;
	private String fxRate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBaseCurrency() {
		return baseCurrency;
	}

	public void setBaseCurrency(String baseCurrency) {
		this.baseCurrency = baseCurrency;
	}

	public String getToCurrency() {
		return toCurrency;
	}

	public void setToCurrency(String toCurrency) {
		this.toCurrency = toCurrency;
	}

	public String getFxRate() {
		return fxRate;
	}

	public void setFxRate(String fxRate) {
		this.fxRate = fxRate;
	}

	@Override
	public String toString() {
		return "CurrencyRates [id=" + id + ", baseCurrency=" + baseCurrency + ", toCurrency=" + toCurrency + ", fxRate="
				+ fxRate + "]";
	}

	

}
