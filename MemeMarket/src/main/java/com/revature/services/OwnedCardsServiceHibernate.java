package com.revature.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Card;
import com.revature.beans.OwnedCard;
import com.revature.beans.User;
import com.revature.data.OwnedCardDao;
import com.revature.data.UserDao;

@Service
public class OwnedCardsServiceHibernate implements OwnedCardService{
	@Autowired
	OwnedCardDao ocd;
	@Autowired
	UserDao ud;
	
	@Override
	public void addOwnedCard(OwnedCard oc, User u) {
		oc.setPatronId(u.getPatron().getId());
		oc.setId(ocd.addOwnedCard(oc));
		u.getPatron().getOwnedCards().add(oc);
	}
	@Override
	public void addOwnedCard(Card c, User u) {
		OwnedCard oc = new OwnedCard();
		oc.setCard(c);
		addOwnedCard(oc, u);
	}
}
