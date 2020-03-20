package com.revature.data;

import java.util.Set;

import com.revature.beans.Card;
import com.revature.beans.Rarity;

public interface CardDao {
	public int addCard(Card c);
	public Card getCard(int id);
	public Set<Card> getCardsByRarity(Rarity r);
	public boolean updateCard(Card c);
	public boolean deleteCard(Card c);
	public Set<Card> getCards();
}
