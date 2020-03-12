package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

//Done

@Entity
@Table(name="OwnedCards")
public class OwnedCard {
	@Id
	@SequenceGenerator(name="ownedCard", sequenceName="OwnedCards_seq", allocationSize=1)
	@GeneratedValue(generator="ownedCard", strategy=GenerationType.SEQUENCE)
	private Integer id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cardId")
	private Card card;
	
	@Column
	private Integer showcased;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}

	public Integer getShowcased() {
		return showcased;
	}

	public void setShowcased(Integer showcased) {
		this.showcased = showcased;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((card == null) ? 0 : card.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((showcased == null) ? 0 : showcased.hashCode());
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
		OwnedCard other = (OwnedCard) obj;
		if (card == null) {
			if (other.card != null)
				return false;
		} else if (!card.equals(other.card))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (showcased == null) {
			if (other.showcased != null)
				return false;
		} else if (!showcased.equals(other.showcased))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "OwnedCard [id=" + id + ", card=" + card + ", showcased=" + showcased + "]";
	}

	public OwnedCard() {
		super();
	}

	
	
}
