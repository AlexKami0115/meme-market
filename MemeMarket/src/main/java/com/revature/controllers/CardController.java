package com.revature.controllers;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Card;
import com.revature.beans.Comment;
import com.revature.services.CardService;
import com.revature.services.CommentService;

@RestController
@CrossOrigin(origins= {"http://localhost:4200"})
public class CardController {
	@Autowired
	private CardService cs;
	
	@Autowired
	private CommentService commentService;
	
	@GetMapping(path="/card/{id}")
	private ResponseEntity<Card> getCard(@PathVariable Integer id) {
		Card c = cs.getCard(id);
		System.out.println(c);
		return ResponseEntity.ok(c);
	}
	
	@GetMapping(path="/card")
	private ResponseEntity<Set<Card>> getCards() {
		Set<Card> cardSet = cs.getCards();
		return ResponseEntity.ok(cardSet);
	}
	
	@PostMapping(path="/card")
	private ResponseEntity<Card> addCard(@RequestBody Card c) {
		cs.addCard(c);
		return ResponseEntity.ok(c);
	}
	
	@PostMapping(path="/addComment")
	private ResponseEntity<Comment> addComment(@RequestBody Comment comment) {
		System.out.println("comment: " + comment);
		commentService.addComment(comment);
		return ResponseEntity.ok(comment);
	}
	
	@DeleteMapping(path="/card/{id}")
	private ResponseEntity<Card> deleteCard(@PathVariable Integer id) {
		if (cs.deleteCard(cs.getCard(id))) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping(path="/ownedCards/{id}")
	private ResponseEntity<Card> deleteComment(@PathVariable Integer id) {
		Comment comment = commentService.getComment(id);
		if (commentService.deleteComment(comment)) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
