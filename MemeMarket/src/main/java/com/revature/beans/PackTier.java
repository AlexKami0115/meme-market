package com.revature.beans;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

//Done

@Entity
@Table(name="PackTiers")
public class PackTier {
	@Id
	@SequenceGenerator(name="packtier", sequenceName="PackTiers_seq", allocationSize=1)
	@GeneratedValue(generator="packtier", strategy=GenerationType.SEQUENCE)
	private Integer id;
	
	@Column(name="tierName")
	private String name;
	@Column
	private Integer tierPrice;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="PackTiersRarity",
			joinColumns=@JoinColumn(name="packTiersId"),
			inverseJoinColumns=@JoinColumn(name="RarityId"))
	private Set<Rarity> packRarities;
	
	private int numOfCards;

	public int getNumOfCards() {
		return numOfCards;
	}

	public void setNumOfCards(int numOfCards) {
		this.numOfCards = numOfCards;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getTierPrice() {
		return tierPrice;
	}

	public void setTierPrice(Integer tierPrice) {
		this.tierPrice = tierPrice;
	}

	public Set<Rarity> getPackRarities() {
		return packRarities;
	}

	public void setPackRarities(Set<Rarity> packRarities) {
		this.packRarities = packRarities;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + numOfCards;
		result = prime * result + ((packRarities == null) ? 0 : packRarities.hashCode());
		result = prime * result + ((tierPrice == null) ? 0 : tierPrice.hashCode());
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
		PackTier other = (PackTier) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (numOfCards != other.numOfCards)
			return false;
		if (packRarities == null) {
			if (other.packRarities != null)
				return false;
		} else if (!packRarities.equals(other.packRarities))
			return false;
		if (tierPrice == null) {
			if (other.tierPrice != null)
				return false;
		} else if (!tierPrice.equals(other.tierPrice))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PackTier [id=" + id + ", name=" + name + ", tierPrice=" + tierPrice + ", packRarities=" + packRarities
				+ ", numOfCards=" + numOfCards + "]";
	}

	public PackTier() {
		super();
	}
}
