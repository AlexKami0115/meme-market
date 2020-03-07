package com.revature.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TradeStatus")
public class TradeStatus {
	@Id
	@SequenceGenerator(name="tradestatus", sequenceName="TradeStatus_seq", allocationSize=1)
	@GeneratedValue(generator="tradestatus", strategy=GenerationType.SEQUENCE)
	private Integer id;
	private String statusName;
	
	//CONSTRUCTORS
	public TradeStatus() {
		super();
	}
	
	public TradeStatus(Integer id, String statusName) {
		super();
		this.id = id;
		this.statusName = statusName;
	}
	
	// GETTERS AND SETTERS
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	// HASHCODE, EQUALS, TOSTRING
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((statusName == null) ? 0 : statusName.hashCode());
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
		TradeStatus other = (TradeStatus) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (statusName == null) {
			if (other.statusName != null)
				return false;
		} else if (!statusName.equals(other.statusName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TradeStatus [id=" + id + ", statusName=" + statusName + "]";
	}

}
