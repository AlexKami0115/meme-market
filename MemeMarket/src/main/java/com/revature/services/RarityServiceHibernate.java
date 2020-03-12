package com.revature.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Rarity;
import com.revature.data.RarityDao;

@Service
public class RarityServiceHibernate implements RarityService {
	@Autowired
	private RarityDao rd;
	
	@Override
	public Set<Rarity> getRarities() {
		// TODO Auto-generated method stub
		return rd.getRarities();
	}

	@Override
	public Rarity getRarity(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
