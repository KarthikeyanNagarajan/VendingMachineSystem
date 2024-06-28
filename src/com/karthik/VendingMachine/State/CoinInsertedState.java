package com.karthik.VendingMachine.State;

import com.karthik.VendingMachine.Inventory.Inventory;
import com.karthik.VendingMachine.Inventory.Product;
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
		Inventory inventory = vendingMachine.getInventory();
		Product product = inventory.getProduct(aisleNumber);

		if (!vendingMachine.hasSufficientAmount(product.getPrice()))
			throw new IllegalStateException("Insufficient Amount");

		if (!inventory.checkIfProductAvailable(product.getId()))
			throw new IllegalStateException("Product Not Available");

		vendingMachine.setVendingMachineCurrentState(vendingMachine.getDispenseState());
	}

	@Override
	public void dispense(int aisleNumber)
	{
		throw new IllegalStateException("Product Not Chosen");
	}

}
