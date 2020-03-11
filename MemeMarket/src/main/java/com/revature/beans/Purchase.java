package com.revature.beans;

import java.sql.Timestamp;

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

import com.fasterxml.jackson.annotation.JsonManagedReference;

//Done

@Entity
@Table(name="Purchases")
public class Purchase {
	@Id
	@SequenceGenerator(name="purchases", sequenceName="Purchases_seq", allocationSize=1)
	@GeneratedValue(generator="purchases", strategy=GenerationType.SEQUENCE)
	private Integer id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "patronId")
	private Patron patron;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "purchaseLevelId")
	private PurchaseLevel purchaseLevel;
	
	@Column
	private Timestamp purchaseDate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Patron getPatron() {
		return patron;
	}

	public void setPatron(Patron patron) {
		this.patron = patron;
	}

	public PurchaseLevel getPurchaseLevel() {
		return purchaseLevel;
	}

	public void setPurchaseLevel(PurchaseLevel purchaseLevel) {
		this.purchaseLevel = purchaseLevel;
	}

	public Timestamp getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Timestamp purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((patron == null) ? 0 : patron.hashCode());
		result = prime * result + ((purchaseDate == null) ? 0 : purchaseDate.hashCode());
		result = prime * result + ((purchaseLevel == null) ? 0 : purchaseLevel.hashCode());
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
		Purchase other = (Purchase) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (patron == null) {
			if (other.patron != null)
				return false;
		} else if (!patron.equals(other.patron))
			return false;
		if (purchaseDate == null) {
			if (other.purchaseDate != null)
				return false;
		} else if (!purchaseDate.equals(other.purchaseDate))
			return false;
		if (purchaseLevel == null) {
			if (other.purchaseLevel != null)
				return false;
		} else if (!purchaseLevel.equals(other.purchaseLevel))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Purchase [id=" + id + ", patron=" + patron + ", purchaseLevel=" + purchaseLevel + ", purchaseDate="
				+ purchaseDate + "]";
	}

	public Purchase() {
		super();
	}
	
	
}
