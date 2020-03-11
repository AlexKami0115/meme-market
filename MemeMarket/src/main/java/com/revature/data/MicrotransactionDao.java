package com.revature.data;

import com.revature.beans.Microtransaction;

public interface MicrotransactionDao {
	public int addMicrotransaction(Microtransaction m);
	public Microtransaction getMicrotransaction(int id);
	public boolean updateMicrotransaction(Microtransaction m);
	public boolean deleteMicrotransaction(Microtransaction m);
}
