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

@Entity
@Table(name="Cards")
public class Card {
	@Id
	@SequenceGenerator(name="card", sequenceName="Cards_seq", allocationSize=1)
	@GeneratedValue(generator="card", strategy=GenerationType.SEQUENCE)
	private Integer id;
	
	@Column(name="cardImage")
	private String image;
	private String cardText;
	private String memeText;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "rarityId")
	private Rarity rarity;
	
	//CONSTRUCTORS
	public Card() {
		super();
	}
	
	public Card(Integer id, String image, String cardText, String memeText, Rarity rarity) {
		super();
		this.id = id;
		this.image = image;
		this.cardText = cardText;
		this.memeText = memeText;
		this.rarity = rarity;
	}
	
	// GETTERS AND SETTERS
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getCardText() {
		return cardText;
	}

	public void setCardText(String cardText) {
		this.cardText = cardText;
	}

	public String getMemeText() {
		return memeText;
	}

	public void setMemeText(String memeText) {
		this.memeText = memeText;
	}

	public Rarity getRarity() {
		return rarity;
	}

	public void setRarity(Rarity rarity) {
		this.rarity = rarity;
	}
	
	// HASHCODE, EQUALS, TOSTRING
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cardText == null) ? 0 : cardText.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((image == null) ? 0 : image.hashCode());
		result = prime * result + ((memeText == null) ? 0 : memeText.hashCode());
		result = prime * result + ((rarity == null) ? 0 : rarity.hashCode());
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
		Card other = (Card) obj;
		if (cardText == null) {
			if (other.cardText != null)
				return false;
		} else if (!cardText.equals(other.cardText))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (image == null) {
			if (other.image != null)
				return false;
		} else if (!image.equals(other.image))
			return false;
		if (memeText == null) {
			if (other.memeText != null)
				return false;
		} else if (!memeText.equals(other.memeText))
			return false;
		if (rarity == null) {
			if (other.rarity != null)
				return false;
		} else if (!rarity.equals(other.rarity))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Card [id=" + id + ", image=" + image + ", cardText=" + cardText + ", memeText=" + memeText + ", rarity="
				+ rarity + "]";
	}
	

}
