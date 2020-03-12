package com.revature.driver;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.beans.Card;
import com.revature.beans.OwnedCard;
import com.revature.beans.Trade;
import com.revature.data.OwnedCardDao;
import com.revature.data.OwnedCardHibernate;
import com.revature.data.TradeDao;
import com.revature.data.TradeHibernate;
import com.revature.data.TradeStatusDao;
import com.revature.data.TradeStatusHibernate;
import com.revature.services.CardService;

@Component
public class JeffDriver {
	static TradeDao td = new TradeHibernate();
	static TradeStatusDao tsd = new TradeStatusHibernate();
	static OwnedCardDao ocd = new OwnedCardHibernate();
	
	@Autowired
	private static CardService cs;
	
	public static void main(String[] args) {
		
		
		testCardService();
		
//		Trade tr = td.getTrade(2);
//		System.out.println(tr);
//		
//		td.deleteTrade(tr);
		
//		testTradeService();
		
		
	}

	public static void testTradeService() {
		// TODO Auto-generated method stub
		// Creating a new trade
		Trade t1 = new Trade();
		// Get a list of ownedcards to trade
		List<OwnedCard> ocl = new ArrayList<>();
		ocl.add(ocd.getOwnedCard(1));
		ocl.add(ocd.getOwnedCard(2));
		// Set the patrons who own the cards
		// Convert List to Set and set cards to be traded
		t1.setCardsToBeTraded(new HashSet<OwnedCard>(ocl));
		// Set trade status
		t1.setTradeStatus(tsd.getTradeStatus(1));
		// Add trade to DB
		int id = td.addTrade(t1);
		
		System.out.println(td.getTrade(id));
	}
	
	@Autowired
	public static void testCardService() {
		
		Card c = new Card();
		c.setCardText("Jeff's Test Card");
		c.setImage("http://someurl.com/path/to/img.png");
		c.setMemeText("My name Jeff");
		
		cs.addCard(c);
	}

}
