package com.revature.beans;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Patrons")
// @Inheritence(strategy=InheritanceType.JOINED) each class has its table and querying a subclass entity requires joining the tables
public class Patron {
	@Id
	@SequenceGenerator(name="patrons", sequenceName="Patrons_seq", allocationSize=1)
	@GeneratedValue(generator="patrons", strategy=GenerationType.SEQUENCE)
	private Integer id;
	private Integer stonks;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy="patron")
	private List<OwnedCard> ownedCards;
	
	//TODO make sure to remove from toString etc.
	@OneToMany(fetch = FetchType.LAZY, mappedBy="patron")
	private List<Comment> comments;
	
	//TODO make sure to remove from toString etc.
	@OneToOne(fetch = FetchType.LAZY, mappedBy="patron")
	private User user;

}
