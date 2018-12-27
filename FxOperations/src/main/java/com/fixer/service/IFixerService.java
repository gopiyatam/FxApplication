package com.fixer.service;

import java.util.List;

import com.fixer.bean.CurrencyRates;

public interface IFixerService {

	public void saveCurrencyData() throws Exception ;
	public void deleteTotalCurrencyRates();
	
	public boolean loginCheck(String email,String password);
	
	public List<CurrencyRates> listCurrencyRates();

}
