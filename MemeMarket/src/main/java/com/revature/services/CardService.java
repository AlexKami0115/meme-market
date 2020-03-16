package com.revature.services;

import java.util.Set;

import com.revature.beans.Card;
import com.revature.beans.PackTier;
import com.revature.beans.Rarity;

public interface CardService {
	public int addCard(Card c);
	public Card getCard(int id);
	public Set<Card> genCardPack(int packTierId);
	public Set<Card> genCardPack(PackTier pt);
	public boolean updateCard(Card c);
	public boolean deleteCard(Card c);
}
