package com.fixer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.fixer.bean.CurrencyRates;
import com.fixer.bean.Login;
import com.fixer.service.IFixerService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(path = "/")
@Api(value = "FixerControllerAPI", produces = MediaType.APPLICATION_JSON_VALUE)
public class FixerController {
	@Autowired
	private IFixerService service;
	
	@GetMapping(value="/")
	public ModelAndView getLoginPage() {
	ModelAndView mav=new ModelAndView("/login.html");
	return mav;	
		}
	
	

    /* @GetMapping(value="/loginCheck")
	public ModelAndView getFixerData( @ModelAttribute("login") Login login,@RequestParam(value = "error", required = false) String error) {
		String email=login.getEmail();
		String password=login.getPassword();
		System.out.println();
		
		boolean value=service.getFixerData(email, password);
		if(value== true) {
		
		ModelAndView mav=new ModelAndView("/loginSuccess.html");
		return mav;	
	}
		else {
			
			ModelAndView model = new ModelAndView("/login.html");
			model.addObject("error", " *Invalid Credentials provided.");
			return model;
		}
	}*/
	
	@PostMapping(value="/loginCheck")
	public String loginCheck(@ModelAttribute("login") Login login) {
		String email=login.getEmail();
		String password=login.getPassword();
		System.out.println("email="+email);
		System.out.println("pwd="+password);
		boolean value=service.loginCheck(email,password);
		System.out.println("gopi="+value);
		if(value == true) {
			String str="loginSuccess";
			return str;
		}else {
			String str="Invalid Creditinals";
			return str;
		}
		
		
	}
     @GetMapping(value="/getFxData")
     @ApiOperation("Gets the fixer currency rates ")
     @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = CurrencyRates.class)})
     public List<CurrencyRates> getFxData() {
    	List<CurrencyRates> rates= service.listCurrencyRates();
		return rates;
     }
     
     
     
     
	@GetMapping(value="/save")
	public void saveData() {
		try {
			service.saveCurrencyData();
			System.out.println("successfully save");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	@GetMapping(value="/delete")
	public void deleteData() {
		
		service.deleteTotalCurrencyRates();
	}
		
	}