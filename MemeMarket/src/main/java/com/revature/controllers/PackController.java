package com.revature.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Card;
import com.revature.beans.User;
import com.revature.services.CardService;
import com.revature.services.UserService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class PackController {
	@Autowired
	private CardService cs;
	@Autowired
	private UserService us;

	@CrossOrigin(origins="http://localhost:4200")
	@GetMapping(path="/pick-card-pack/{id}")
	public ResponseEntity<List<Card>> getCardPack(@PathVariable Integer id, HttpSession session) {
		User u = (User) session.getAttribute("loggedUser");
		System.out.println("----------------------" + u);
		List<Card> cardSet = cs.genCardPack(id, u);
		if(cardSet == null) {return ResponseEntity.badRequest().build();}
		// u = us.getUser(u);
		us.updateUser(u);
		session.setAttribute("loggedUser", u);
		return ResponseEntity.ok(cardSet);
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