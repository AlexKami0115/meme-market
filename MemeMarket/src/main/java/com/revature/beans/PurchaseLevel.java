package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="PurchaseLevels")
public class PurchaseLevel {
	@Id
	@SequenceGenerator(name="purchaselevel", sequenceName="PurchaseLevels_seq", allocationSize=1)
	@GeneratedValue(generator="purchaselevel", strategy=GenerationType.SEQUENCE)
	private Integer id;
	@Column(name="levelName")
	private String name;
	@Column(name="levelCost")
	private Integer cost;
	@Column
	private Integer stonkAmount;
	
	// CONSTRUCTORS
	public PurchaseLevel() {
		super();
	}
	
	public PurchaseLevel(Integer id, String name, Integer cost, Integer stonkAmount) {
		super();
		this.id = id;
		this.name = name;
		this.cost = cost;
		this.stonkAmount = stonkAmount;
	}
	
    // GETTERS AND SETTERS
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

	public Integer getCost() {
		return cost;
	}

	public void setCost(Integer cost) {
		this.cost = cost;
	}

	public Integer getStonkAmount() {
		return stonkAmount;
	}

	public void setStonkAmount(Integer stonkAmount) {
		this.stonkAmount = stonkAmount;
	}

	// HASHCODE, EQUALS, TOSTRING
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cost == null) ? 0 : cost.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((stonkAmount == null) ? 0 : stonkAmount.hashCode());
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
		PurchaseLevel other = (PurchaseLevel) obj;
		if (cost == null) {
			if (other.cost != null)
				return false;
		} else if (!cost.equals(other.cost))
			return false;
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
		if (stonkAmount == null) {
			if (other.stonkAmount != null)
				return false;
		} else if (!stonkAmount.equals(other.stonkAmount))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PurchaseLevel [id=" + id + ", name=" + name + ", cost=" + cost + ", stonkAmount=" + stonkAmount + "]";
	}
	
	
}
