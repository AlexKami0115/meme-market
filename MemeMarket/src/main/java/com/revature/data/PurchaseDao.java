package com.revature.data;

import com.revature.beans.Purchase;

public interface PurchaseDao {
	public int addPurchase(Purchase p);
	public Purchase getPurchase(int id);
	public void updatePurchase(Purchase p);
	public void deletePurchase(Purchase p);
}
