package com.revature.beans;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Comments")
public class Comment {
	@Id
	@SequenceGenerator(name="comments", sequenceName="Comments_seq", allocationSize=1)
	@GeneratedValue(generator="comments", strategy=GenerationType.SEQUENCE)
	private Integer id;
	
	
	//TODO make sure to remove from toString etc.
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cardId")
	private Card card;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "patronId")
	private Patron patron;
	
	private String commentText;
	private Timestamp timeOfComment;
}
