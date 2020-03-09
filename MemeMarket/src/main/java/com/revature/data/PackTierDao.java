package com.revature.data;

import com.revature.beans.PackTier;

public interface PackTierDao {
	public int addPackTier(PackTier pt);
	public PackTier getPackTier(int id);
	public void updatePackTier(PackTier pt);
	public void deletePackTier(PackTier pt);
}
