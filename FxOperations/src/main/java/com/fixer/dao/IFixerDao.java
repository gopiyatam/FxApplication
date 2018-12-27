package com.fixer.dao;

import java.util.List;

import com.fixer.bean.CurrencyRates;
import com.fixer.bean.FixerCurrencyRates;

public interface IFixerDao {
	public void saveCurrencyData(FixerCurrencyRates rates) throws Exception;
	public void deleteFxData();
    public boolean loginCheck(String email,String password);
    
    public List<CurrencyRates> listOfCurrencyRates();
}
