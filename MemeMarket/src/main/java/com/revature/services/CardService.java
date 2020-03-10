package com.revature.services;

import com.revature.beans.Card;

public interface CardService {
	public int addCard(Card c);
	public Card getCard(int id);
	public void updateCard(Card c);
	public void deleteCard(Card c);
}
