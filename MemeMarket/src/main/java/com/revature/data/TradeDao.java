package com.revature.data;

import com.revature.beans.Trade;

public interface TradeDao {
	
	public int addTrade(Trade tr);
	public Trade getTrade(int id);
	public void updateTrade(Trade tr);
	public void deleteTrade(Trade tr);
}
