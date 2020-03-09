package com.revature.data;

import com.revature.beans.Rarity;

public interface RarityDao {
	public int addRarity(Rarity r);
	public Rarity getRarity(int id);
	public void updateRarity(Rarity r);
	public void deleteRarity(Rarity r);
}
