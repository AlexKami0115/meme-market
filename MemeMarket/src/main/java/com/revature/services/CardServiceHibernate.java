package com.revature.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Card;
import com.revature.data.CardDao;

@Service
public class CardServiceHibernate implements CardService {
	@Autowired
	private CardDao cd;

	@Override
	public int addCard(Card c) {
		return cd.addCard(c);
	}

	@Override
	public Card getCard(int id) {
		// TODO Auto-generated method stub
		return cd.getCard(id);
	}

	@Override
	public boolean updateCard(Card c) {
		return cd.updateCard(c);
	}

	@Override
	public boolean deleteCard(Card c) {
		return cd.deleteCard(c);
	}

}
