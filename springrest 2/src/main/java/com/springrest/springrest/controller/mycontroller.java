package com.springrest.springrest.controller;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;





@RestController
public class mycontroller {
	
	 @Autowired
	 private AtmService atmService;
	
	
	@RequestMapping("/userInfo")
	public List<atm> home() {
		return atmService.getuserInfo();
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/withdraw/{acc}")
	public String withdraw(@RequestBody atm atmx,@PathVariable String acc) {
		
		return atmService.withdraw(acc,atmx);
	}
	@RequestMapping(method=RequestMethod.PUT, value="/deposit/{acc}")
	public String deposit(@RequestBody atm atmx,@PathVariable String acc) {
		
		return atmService.deposit(acc,atmx);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/openacccount")
	public String openAccount(@RequestBody atm atmx) {
		return atmService.openAccount(atmx);
	}
}