package com.revature.data;

import com.revature.beans.Microtransaction;

public interface MicrotransactionDao {
	public int addMicrotransaction(Microtransaction m);
	public Microtransaction getMicrotransaction(int id);
	public void updateMicrotransaction(Microtransaction m);
	public void deleteMicrotransaction(Microtransaction m);
}
