package com.revature.data;

import java.util.List;

import com.revature.beans.OwnedCard;
import com.revature.beans.Patron;

public interface OwnedCardDao {
	
	public int addOwnedCard(OwnedCard oc);
	public OwnedCard getOwnedCard(int id);
	public boolean updateOwnedCard(OwnedCard oc);
	public boolean deleteOwnedCard(OwnedCard oc);
}
