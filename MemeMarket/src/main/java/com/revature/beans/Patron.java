package com.revature.beans;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

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
	
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "patronId")
	private List<OwnedCard> ownedCards;

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

	public List<OwnedCard> getOwnedCards() {
		return ownedCards;
	}

	public void setOwnedCards(List<OwnedCard> ownedCards) {
		this.ownedCards = ownedCards;
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
