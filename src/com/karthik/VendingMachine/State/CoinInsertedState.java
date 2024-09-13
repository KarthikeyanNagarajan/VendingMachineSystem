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
		System.out.println(amount + " coin is inserted.");
		vendingMachine.setAmount(vendingMachine.getAmount() + amount);
		System.out.println("Total -> " + vendingMachine.getAmount());
	}

	@Override
	public void pressButton(int aisleNumber)
	{
		System.out.println("Button " + aisleNumber + " is pressed.");
		vendingMachine.setVendingMachineCurrentState(vendingMachine.getProductSelectionState());
		vendingMachine.getVendingMachineCurrentState().pressButton(aisleNumber);
	}

	@Override
	public void dispense(int aisleNumber)
	{
		System.out.println("Product Not Chosen !!!");
	}

}
