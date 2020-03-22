package com.revature.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.revature.beans.Trade;
import com.revature.data.TradeDao;

public class TradeServiceHibernate implements TradeService {
	@Autowired
	private TradeDao td;
	
	@Override
	public int addTrade(Trade tr) {
		return td.addTrade(tr);
	}

	@Override
	public Trade getTrade(int id) {
		return td.getTrade(id);
	}

	@Override
	public boolean updateTrade(Trade tr) {
		return td.updateTrade(tr);
	}

	@Override
	public boolean deleteTrade(Trade tr) {
		return td.deleteTrade(tr);
	}

}
