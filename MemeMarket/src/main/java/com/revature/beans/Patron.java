package com.revature.beans;

import java.util.Set; 

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//Done

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
	private Set<OwnedCard> ownedCards;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="patron",  cascade=CascadeType.ALL)
	@JsonIgnoreProperties({"patron", "hibernateLazyInitializer", "handler"})
	private Set<Comment> comments;
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy="patron")
	@JsonIgnoreProperties({"patron", "hibernateLazyInitializer", "handler"})
	private User user;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getStonks() {
		return stonks;
	}

	public void setStonks(Integer stonks) {
		this.stonks = stonks;
	}

	public Set<OwnedCard> getOwnedCards() {
		return ownedCards;
	}

	public void setOwnedCards(Set<OwnedCard> ownedCards) {
		this.ownedCards = ownedCards;
	}

	public Set<Comment> getComments() {
		return comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((ownedCards == null) ? 0 : ownedCards.hashCode());
		result = prime * result + ((stonks == null) ? 0 : stonks.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Patron other = (Patron) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (ownedCards == null) {
			if (other.ownedCards != null)
				return false;
		} else if (!ownedCards.equals(other.ownedCards))
			return false;
		if (stonks == null) {
			if (other.stonks != null)
				return false;
		} else if (!stonks.equals(other.stonks))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Patron [id=" + id + ", stonks=" + stonks + ", ownedCards=" + ownedCards + "]";
	}

	public Patron() {
		super();
	}

	
}
