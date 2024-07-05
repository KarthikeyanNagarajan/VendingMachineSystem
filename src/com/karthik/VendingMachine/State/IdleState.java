package com.karthik.VendingMachine.State;

import com.karthik.VendingMachine.Service.VendingMachine;

public class IdleState implements State
{
	VendingMachine vendingMachine;

	public IdleState(VendingMachine vendingMachine)
	{
		this.vendingMachine = vendingMachine;
	}

	@Override
	public void insertCoin(double amount)
	{
		vendingMachine.setVendingMachineCurrentState(vendingMachine.getCoinInsertedState());
		vendingMachine.getVendingMachineCurrentState().insertCoin(amount);
	}

	@Override
	public void pressButton(int aisleNumber)
	{
		System.out.println("Please Insert a Coin !!!");
	}

	@Override
	public void dispense(int aisleNumber)
	{
		System.out.println("Please Insert a Coin !!!");
	}

}
