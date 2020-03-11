package com.revature.data;

import com.revature.beans.Trade;

public interface TradeDao {
	
	public int addTrade(Trade tr);
	public Trade getTrade(int id);
	public boolean updateTrade(Trade tr);
	public boolean deleteTrade(Trade tr);
}
