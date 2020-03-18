package com.revature.services;

import java.util.Set;

import com.revature.beans.Card;
import com.revature.beans.PackTier;
import com.revature.beans.Rarity;
import com.revature.beans.User;

public interface CardService {
	public int addCard(Card c);
	public Card getCard(int id);
	public Set<Card> genCardPack(int packTierId, User u);
	public Set<Card> genCardPack(PackTier pt, User u);
	public boolean updateCard(Card c);
	public boolean deleteCard(Card c);
}
