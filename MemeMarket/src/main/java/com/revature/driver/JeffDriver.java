package com.revature.driver;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import com.revature.beans.OwnedCard;
import com.revature.beans.Trade;
import com.revature.data.OwnedCardDao;
import com.revature.data.OwnedCardHibernate;
import com.revature.data.TradeDao;
import com.revature.data.TradeHibernate;
import com.revature.data.TradeStatusDao;
import com.revature.data.TradeStatusHibernate;

public class JeffDriver {
	
	public static void main(String[] args) {
		TradeDao td = new TradeHibernate();
		TradeStatusDao tsd = new TradeStatusHibernate();
		OwnedCardDao ocd = new OwnedCardHibernate();
		
//		Trade tr = td.getTrade(2);
//		System.out.println(tr);
//		
//		td.deleteTrade(tr);
		
		// Creating a new trade
		Trade t1 = new Trade();
		// Get a list of ownedcards to trade
		List<OwnedCard> ocl = new ArrayList<>();
		ocl.add(ocd.getOwnedCard(1));
		ocl.add(ocd.getOwnedCard(2));
		// Set the patrons who own the cards
		t1.setPatronOne(ocl.get(0).getPatron());
		t1.setPatronTwo(ocl.get(1).getPatron());
		// Convert List to Set and set cards to be traded
		t1.setCardsToBeTraded(new HashSet<OwnedCard>(ocl));
		// Set trade status
		t1.setTradeStatus(tsd.getTradeStatus(1));
		// Add trade to DB
		int id = td.addTrade(t1);
		
		System.out.println(td.getTrade(id));
	}

}
