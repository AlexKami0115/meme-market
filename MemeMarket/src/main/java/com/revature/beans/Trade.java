package com.revature.beans;

import java.util.List;

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
@Table(name="Trades")
public class Trade {
	@Id
	@SequenceGenerator(name="trade", sequenceName="Trade_seq", allocationSize=1)
	@GeneratedValue(generator="trade", strategy=GenerationType.SEQUENCE)
	private Integer id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "patronOneId")
	private Patron patronOne;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "patronTwoId")
	private Patron patronTwo;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="TradeOwnedCards",
			joinColumns=@JoinColumn(name="tradeId"),
			inverseJoinColumns=@JoinColumn(name="ownedCardsId"))
	private List<OwnedCard> ownedCards;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "tradeStatus")
	private TradeStatus tradeStatus;

}	
