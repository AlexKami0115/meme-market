package com.revature.data;

import com.revature.beans.OwnedCard;

public interface OwnedCardDao {
	
	public int addOwnedCard(OwnedCard oc);
	public OwnedCard getOwnedCard(int id);
	public void updateOwnedCard(OwnedCard oc);
	public void deleteOwnedCard(OwnedCard oc);

}
