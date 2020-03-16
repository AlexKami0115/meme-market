package com.revature.controllers;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Tag;
import com.revature.services.TagService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class TagController {
	@Autowired
	private TagService rs;
	
	@GetMapping(path="/tag")
	public ResponseEntity<Set<Tag>> getTags() {
		return ResponseEntity.ok(rs.getTags());
	}
	
	@GetMapping(path="/tag/{id}")
	public ResponseEntity<Tag> getTag(@PathVariable Integer id) {
		return ResponseEntity.ok(rs.getTag(id));
	}

}
