package com.revature.data;

import com.revature.beans.PurchaseLevel;

public interface PurchaseLevelDao {
	public int addPurchaseLevel(PurchaseLevel pl);
	public PurchaseLevel getPurchaseLevel(int id);
	public boolean updatePurchaseLevel(PurchaseLevel pl);
	public boolean deletePurchaseLevel(PurchaseLevel pl);
}
