package com.revature.data;

import com.revature.beans.TradeStatus;

public interface TradeStatusDao {
	public int addTradeStatus(TradeStatus ts);
	public TradeStatus getTradeStatus(int id);
	public void updateTradeStatus(TradeStatus ts);
	public void deleteTradeStatus(TradeStatus ts);
}
