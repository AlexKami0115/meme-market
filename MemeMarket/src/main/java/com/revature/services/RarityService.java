package com.revature.services;

import java.util.Set;

import com.revature.beans.Rarity;

public interface RarityService {
	public Set<Rarity> getRarities();
	public Rarity getRarity(Integer id);
}
