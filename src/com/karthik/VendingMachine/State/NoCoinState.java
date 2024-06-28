package com.karthik.VendingMachine.State;

import com.karthik.VendingMachine.Service.VendingMachine;

public class NoCoinState implements State
{
	VendingMachine vendingMachine;

	public NoCoinState(VendingMachine vendingMachine)
	{
		this.vendingMachine = vendingMachine;
	}

	@Override
	public void insertCoin(double amount)
	{
		vendingMachine.setAmount(amount);
		vendingMachine.setVendingMachineCurrentState(vendingMachine.getCoinInsertedState());
	}

	@Override
	public void pressButton(int aisleNumber)
	{
		throw new IllegalStateException("No Coin Inserted");
	}

	@Override
	public void dispense(int aisleNumber)
	{
		throw new IllegalStateException("No Coin Inserted");
	}

}
