package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Card;
import com.revature.services.CardService;

@RestController
public class CardController {
	@Autowired
	private CardService cs;
	
	@GetMapping(path="/card/{id}")
	private ResponseEntity<Card> addCard(@PathVariable Integer id) {
		Card c = cs.getCard(id);
		System.out.println(c);
		return ResponseEntity.ok(c);
	}
}
