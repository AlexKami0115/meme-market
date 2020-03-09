package com.revature.data;

import com.revature.beans.Card;

public interface CardDao {
	public int addCard(Card c);
	public Card getCard(int id);
	public void updateCard(Card c);
	public void deleteCard(Card c);
}
