package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

//Done

@Entity
@Table(name="Rarity")
public class Rarity implements Comparable<Rarity>{
	@Id
	@SequenceGenerator(name="rarity", sequenceName="Rarity_seq", allocationSize=1)
	@GeneratedValue(generator="rarity", strategy=GenerationType.SEQUENCE)
	private Integer id;
	@Column(name="rarityName")
	private String name;
	@Column(name="rarityWeight")
	private Integer weight;
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
	public Integer getWeight() {
		return weight;
	}
	public void setWeight(Integer weight) {
		this.weight = weight;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((weight == null) ? 0 : weight.hashCode());
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
		Rarity other = (Rarity) obj;
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
		if (weight == null) {
			if (other.weight != null)
				return false;
		} else if (!weight.equals(other.weight))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Rarity [id=" + id + ", name=" + name + ", weight=" + weight + "]";
	}
	public Rarity() {
		super();
	}
	@Override
	public int compareTo(Rarity r) {
		if(this.id.equals(r.id)) return 0;
		if(this.id == null) return -1;
		if(r.getId() == null) return 1;
		return this.id.compareTo(r.id);
	}
	
	
	
}
