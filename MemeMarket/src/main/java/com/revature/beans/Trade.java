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

//Done

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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Patron getPatronOne() {
		return patronOne;
	}

	public void setPatronOne(Patron patronOne) {
		this.patronOne = patronOne;
	}

	public Patron getPatronTwo() {
		return patronTwo;
	}

	public void setPatronTwo(Patron patronTwo) {
		this.patronTwo = patronTwo;
	}

	public List<OwnedCard> getOwnedCards() {
		return ownedCards;
	}

	public void setOwnedCards(List<OwnedCard> ownedCards) {
		this.ownedCards = ownedCards;
	}

	public TradeStatus getTradeStatus() {
		return tradeStatus;
	}

	public void setTradeStatus(TradeStatus tradeStatus) {
		this.tradeStatus = tradeStatus;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((ownedCards == null) ? 0 : ownedCards.hashCode());
		result = prime * result + ((patronOne == null) ? 0 : patronOne.hashCode());
		result = prime * result + ((patronTwo == null) ? 0 : patronTwo.hashCode());
		result = prime * result + ((tradeStatus == null) ? 0 : tradeStatus.hashCode());
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
		Trade other = (Trade) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (ownedCards == null) {
			if (other.ownedCards != null)
				return false;
		} else if (!ownedCards.equals(other.ownedCards))
			return false;
		if (patronOne == null) {
			if (other.patronOne != null)
				return false;
		} else if (!patronOne.equals(other.patronOne))
			return false;
		if (patronTwo == null) {
			if (other.patronTwo != null)
				return false;
		} else if (!patronTwo.equals(other.patronTwo))
			return false;
		if (tradeStatus == null) {
			if (other.tradeStatus != null)
				return false;
		} else if (!tradeStatus.equals(other.tradeStatus))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Trade [id=" + id + ", patronOne=" + patronOne + ", patronTwo=" + patronTwo + ", ownedCards="
				+ ownedCards + ", tradeStatus=" + tradeStatus + "]";
	}

	public Trade() {
		super();
	}
	
	
}	
