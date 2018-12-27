package com.fixer.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.fixer.bean.CurrencyRates;
import com.fixer.bean.FixerCurrencyRates;



@Repository
public class FixerDaoImpl implements IFixerDao {
	@Autowired
	private JdbcTemplate jt;

	public void saveCurrencyData(FixerCurrencyRates rates) throws Exception {

		Map<String, String> map = rates.getRates();
		for (Map.Entry<String, String> entry : map.entrySet()) {
			
			/*String key=entry.getKey();
			String value=entry.getValue();*/
			
			String sql = "insert into currencyrates(base_currency,to_currency,fx_rate) values(?,?,?)";
			int count = jt.update(sql, rates.getBase(), entry.getKey(), entry.getValue());

		};
		
	}

	public void deleteFxData() {
		// FixerCurrencyRates rates=new FixerCurrencyRates();

		String sql = "delete from currencyrates where base_currency=?";
		int count = jt.update(sql, "EUR");
		System.out.println(count);

	}

	public boolean loginCheck(String email, String password) {

		String sql = "select count(*) as count from login where email=? and password=?";
		int i = jt.queryForObject(sql, Integer.class, new Object[] { email, password });

		if (i == 1) {
			return true;
		} else 
			return false;
	}

	public List<CurrencyRates> listOfCurrencyRates() {
		String sql="select * from currencyrates";
		return  jt.query(sql, new RowMapper<CurrencyRates>() {
			public CurrencyRates mapRow(ResultSet rs, int rowNum) throws SQLException {
				CurrencyRates rates=new CurrencyRates();
				rates.setId(rs.getInt("id"));
				rates.setBaseCurrency(rs.getString("base_currency"));
				rates.setToCurrency(rs.getString("to_currency"));
				rates.setFxRate(rs.getString("fx_rate"));
				return rates;
			}
	
	
	});
}
	}


	
		
	
