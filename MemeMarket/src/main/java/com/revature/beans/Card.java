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
	
	
}
