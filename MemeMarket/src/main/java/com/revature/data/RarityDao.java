package com.revature.data;

import java.util.Set;

import com.revature.beans.Rarity;

public interface RarityDao {
	public int addRarity(Rarity r);
	public Rarity getRarity(int id);
	public Set<Rarity> getRarities();
	public boolean updateRarity(Rarity r);
	public boolean deleteRarity(Rarity r);
}
