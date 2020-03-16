package com.revature.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Card;
import com.revature.beans.PackTier;
import com.revature.beans.Rarity;
import com.revature.data.CardDao;
import com.revature.data.PackTierDao;

@Service
public class CardServiceHibernate implements CardService {
	@Autowired
	private CardDao cd;
	@Autowired
	private PackTierDao ptd;

	@Override
	public int addCard(Card c) {
		return cd.addCard(c);
	}

	@Override
	public Card getCard(int id) {
		return cd.getCard(id);
	}

	@Override
	public Set<Card> genCardPack(int packTierId){
		PackTier pt = ptd.getPackTier(packTierId);
		return genCardPack(pt);
	}
	
	@Override
	public Set<Card> genCardPack(PackTier pt){
		Set<Card> cardPack = new HashSet<>();
		List<Rarity> rl = new ArrayList<>(pt.getPackRarities());
		int totalWeight = 0;
		int randWeightNumber;
		Map<Rarity, List<Card>> crm = new HashMap<>();
		
		for(int i=0;i<rl.size();i++) {
			totalWeight += rl.get(i).getWeight();
			Set<Card> cs = cd.getCardsByRarity(rl.get(i));
			crm.put(rl.get(i), new ArrayList<Card>(cs));
		}
		Random rand = new Random();
		randWeightNumber = rand.nextInt(totalWeight);
		for(int i=0;i<pt.getNumOfCards();i++) {
			int subTotalWeight = 0;
			for(int j=0;i<rl.size();j++) {
				if(randWeightNumber >= subTotalWeight && randWeightNumber < subTotalWeight + rl.get(j).getWeight()) {
					List<Card> cl = crm.get(rl.get(j));
					cardPack.add(cl.get(rand.nextInt(cl.size())));
					break;
				}
				subTotalWeight += rl.get(j).getWeight();
			}
			
		}
		return cardPack;
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
