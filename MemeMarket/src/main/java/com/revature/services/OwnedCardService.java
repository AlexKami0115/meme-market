package com.revature.services;

import com.revature.beans.Card;
import com.revature.beans.OwnedCard;
import com.revature.beans.User;

public interface OwnedCardService {
	public void addOwnedCard(OwnedCard oc, User u);
	public void addOwnedCard(Card c, User u);
}
