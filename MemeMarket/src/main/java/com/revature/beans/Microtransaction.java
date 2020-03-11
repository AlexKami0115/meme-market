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
@Table(name="Microtransations")
public class Microtransaction {
	@Id
	@SequenceGenerator(name="microtransations", sequenceName="Microtransations_seq", allocationSize=1)
	@GeneratedValue(generator="microtransations", strategy=GenerationType.SEQUENCE)
	private Integer id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "patronId")
	private Patron patron;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "packTierId")
	private PackTier packTier;
	
	@Column
	private Timestamp transDate;

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

	public PackTier getPackTier() {
		return packTier;
	}

	public void setPackTier(PackTier packTier) {
		this.packTier = packTier;
	}

	public Timestamp getTransDate() {
		return transDate;
	}

	public void setTransDate(Timestamp transDate) {
		this.transDate = transDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((packTier == null) ? 0 : packTier.hashCode());
		result = prime * result + ((patron == null) ? 0 : patron.hashCode());
		result = prime * result + ((transDate == null) ? 0 : transDate.hashCode());
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
		Microtransaction other = (Microtransaction) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (packTier == null) {
			if (other.packTier != null)
				return false;
		} else if (!packTier.equals(other.packTier))
			return false;
		if (patron == null) {
			if (other.patron != null)
				return false;
		} else if (!patron.equals(other.patron))
			return false;
		if (transDate == null) {
			if (other.transDate != null)
				return false;
		} else if (!transDate.equals(other.transDate))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Microtransation [id=" + id + ", patron=" + patron + ", packTier=" + packTier + ", transDate="
				+ transDate + "]";
	}

	public Microtransaction() {
		super();
	}
	
	
}
