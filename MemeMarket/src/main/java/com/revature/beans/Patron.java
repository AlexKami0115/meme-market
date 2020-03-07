package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Patrons")
// @Inheritence(strategy=InheritanceType.JOINED) each class has its table and querying a subclass entity requires joining the tables
public class Patron {
	@Id
	@SequenceGenerator(name="patrons", sequenceName="Patrons_seq", allocationSize=1)
	@GeneratedValue(generator="patrons", strategy=GenerationType.SEQUENCE)
	private Integer id;
	private String username;
	@Column(name="pass")
	private String password;
	private Integer stonks;
	
	// CONSTRUCTORS	
	public Patron() {
		super();
	}
	
	public Patron(Integer id) {
		super();
		this.id = id;
	}
	
	public Patron(Integer id, String username, String password, Integer stonks) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.stonks = stonks;
	}
	
	// GETTERS & SETTERS
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getStonks() {
		return stonks;
	}

	public void setStonks(Integer stonks) {
		this.stonks = stonks;
	}
	
	// HASHCODE, EQUALS, AND TOSTRING
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((stonks == null) ? 0 : stonks.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (stonks == null) {
			if (other.stonks != null)
				return false;
		} else if (!stonks.equals(other.stonks))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Patron [id=" + id + ", username=" + username + ", password=" + password + ", stonks=" + stonks + "]";
	}


}
