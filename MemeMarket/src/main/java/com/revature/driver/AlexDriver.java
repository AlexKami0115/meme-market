package com.revature.driver;

import com.revature.beans.Card;
import com.revature.beans.OwnedCard;
import com.revature.beans.Patron;
import com.revature.data.CardDao;
import com.revature.data.CardHibernate;
import com.revature.data.OwnedCardDao;
import com.revature.data.OwnedCardHibernate;
import com.revature.data.PatronDao;
import com.revature.data.PatronHibernate;
import com.revature.data.TradeDao;
import com.revature.data.TradeHibernate;
import com.revature.data.TradeStatusDao;
import com.revature.data.TradeStatusHibernate;


//u = ud.getUser("UserTest", "UserTestPass111");
// log in tests here. if null, no user. 

public class AlexDriver {
	
	public static void main(String[] args) {
		CardDao cd = new CardHibernate();
		PatronDao pd = new PatronHibernate();
		OwnedCardDao ocd = new OwnedCardHibernate();
		
//		Card c = new Card();
//		Card c2 = new Card();
//		
//		c.setImage("cardImageUrl1");
//		c.setCardText("cardTextHere1");
//		
//		c2.setImage("cardImageUrl2");
//		c2.setCardText("cardTextHere2");
//		
//		
//		
//		cd.addCard(c);
//		cd.addCard(c2);
//		
//		System.out.println(c);
//		System.out.println(c2);
		
//		Patron p1 = pd.getPatron(1);
//		Patron p2 = pd.getPatron(2);
//		
//		Card c1 = cd.getCard(1);
//		Card c2 = cd.getCard(2);
//		
//		OwnedCard oc1 = new OwnedCard();
//		oc1.setCard(c1);
//		oc1.setPatron(p1);
//		
//		OwnedCard oc2 = new OwnedCard();
//		oc2.setCard(c2);
//		oc2.setPatron(p2);
//		
//		ocd.addOwnedCard(oc1);
//		ocd.addOwnedCard(oc2);
//		
//		System.out.println(oc1);
//		System.out.println(oc2);
		
		
		
	}

}
