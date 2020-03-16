package com.revature.controllers;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Card;
import com.revature.services.CardService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class PackController {
	@Autowired
	private CardService cs;

	@CrossOrigin(origins="http://localhost:4200")
	@GetMapping(path="/pick-card-pack/{id}")
	public ResponseEntity<Set<Card>> getCardPack(@PathVariable Integer id) {
		return ResponseEntity.ok(cs.genCardPack(id));
	}
}

/*
@RestController
@CrossOrigin(origins="http://localhost:4200")
public class RarityController {
	@Autowired
	private RarityService rs;
	
	@GetMapping(path="/rarity")
	public ResponseEntity<Set<Rarity>> getRarities() {
		return ResponseEntity.ok(rs.getRarities());
	}
	
	@GetMapping(path="/rarity/{id}")
	public ResponseEntity<Rarity> getRarity(@PathVariable Integer id) {
		return ResponseEntity.ok(rs.getRarity(id));
	}

}
*/