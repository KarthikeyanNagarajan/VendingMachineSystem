package com.karthik.VendingMachine.State;

import com.karthik.VendingMachine.Service.VendingMachine;

public class CoinInsertedState implements State
{
	VendingMachine vendingMachine;

	public CoinInsertedState(VendingMachine vendingMachine)
	{
		this.vendingMachine = vendingMachine;
	}

	@Override
	public void insertCoin(double amount)
	{
		vendingMachine.setAmount(vendingMachine.getAmount() + amount);
	}

	@Override
	public void pressButton(int aisleNumber)
	{
		vendingMachine.setVendingMachineCurrentState(vendingMachine.getProductSelectionState());
		vendingMachine.getVendingMachineCurrentState().pressButton(aisleNumber);
	}

	@Override
	public void dispense(int aisleNumber)
	{
		System.out.println("Product Not Chosen !!!");
	}

}
