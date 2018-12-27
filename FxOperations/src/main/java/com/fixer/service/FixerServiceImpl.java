package com.fixer.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fixer.bean.CurrencyRates;
import com.fixer.bean.FixerCurrencyRates;
import com.fixer.dao.IFixerDao;
import com.google.gson.Gson;

@Service
public class FixerServiceImpl implements IFixerService {

	@Autowired
	private IFixerDao dao;
	
	@Value("${serviceURL}")
	private String url;

	public void saveCurrencyData() throws Exception {
		
		/*@Value("${serviceURL}")
		String url = "http://data.fixer.io/api/latest?access_key=3f7057be8442376d17ac5a2b7fa57801";
		*/
		
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		// optional default is GET
		con.setRequestMethod("GET");
		// add request header
		con.setRequestProperty("User-Agent", "Mozilla/5.0");
		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		Gson gson = new Gson();

		FixerCurrencyRates tempObj = gson.fromJson(response.toString(), FixerCurrencyRates.class);

		dao.saveCurrencyData(tempObj);

	}

	public void deleteTotalCurrencyRates() {
		dao.deleteFxData();

	}

	public boolean loginCheck(String email, String password) {
	boolean isboolean=	dao.loginCheck(email, password);
	return isboolean;
		
		
	}

	public List<CurrencyRates> listCurrencyRates() {
		return  dao.listOfCurrencyRates();
	}

	

}
