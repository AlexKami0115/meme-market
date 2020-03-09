package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

//Done

@Entity
@Table(name="Cards")
public class Card {
	@Id
	@SequenceGenerator(name="card", sequenceName="Cards_seq", allocationSize=1)
	@GeneratedValue(generator="card", strategy=GenerationType.SEQUENCE)
	private Integer id;
	
	@Column(name="cardImage")
	private String image;
	@Column
	private String cardText;
	@Column
	private String memeText;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="CardTags",
			joinColumns=@JoinColumn(name="cardId"),
			inverseJoinColumns=@JoinColumn(name="tagId"))
	private Tag tag;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "rarityId")
	private Rarity rarity;

	public Card() {
		super();
	}

	@Override
	public String toString() {
		return "Card [id=" + id + ", image=" + image + ", cardText=" + cardText + ", memeText=" + memeText + ", tag="
				+ tag + ", rarity=" + rarity + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cardText == null) ? 0 : cardText.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((image == null) ? 0 : image.hashCode());
		result = prime * result + ((memeText == null) ? 0 : memeText.hashCode());
		result = prime * result + ((rarity == null) ? 0 : rarity.hashCode());
		result = prime * result + ((tag == null) ? 0 : tag.hashCode());
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
		if (tag == null) {
			if (other.tag != null)
				return false;
		} else if (!tag.equals(other.tag))
			return false;
		return true;
	}

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

	public Tag getTag() {
		return tag;
	}

	public void setTag(Tag tag) {
		this.tag = tag;
	}

	public Rarity getRarity() {
		return rarity;
	}

	public void setRarity(Rarity rarity) {
		this.rarity = rarity;
	}
	
	
}
