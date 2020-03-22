package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Trade;
import com.revature.services.TradeService;

@RestController
@CrossOrigin(origins= {"http://localhost:4200"})
public class TradeController {
	@Autowired
	private TradeService ts;
	
	@PostMapping(path="/trade")
	private ResponseEntity<Trade> addCard(@RequestBody Trade t) {
		ts.addTrade(t);
		return ResponseEntity.ok(t);
	}
}
