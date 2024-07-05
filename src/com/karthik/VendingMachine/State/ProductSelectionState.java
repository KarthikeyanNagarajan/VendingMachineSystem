package com.karthik.VendingMachine.State;

import com.karthik.VendingMachine.Inventory.Inventory;
import com.karthik.VendingMachine.Inventory.Product;
import com.karthik.VendingMachine.Service.VendingMachine;

public class ProductSelectionState implements State
{
	VendingMachine vendingMachine;

	public ProductSelectionState(VendingMachine vendingMachine)
	{
		this.vendingMachine = vendingMachine;
	}

	@Override
	public void insertCoin(double amount)
	{
		System.out.println("Product Not Chosen !!!");
	}

	@Override
	public void pressButton(int aisleNumber)
	{
		Inventory inventory = vendingMachine.getInventory();
		Product product = inventory.getProduct(aisleNumber);

		if (!vendingMachine.hasSufficientAmount(product.getPrice()))
		{
			System.out.println("Insufficient Amount !!!. Collect Back Cash " + vendingMachine.getAmount());
			vendingMachine.setAmount(0);
			vendingMachine.setVendingMachineCurrentState(vendingMachine.getIdleState());
			return;
		}

		if (!inventory.checkIfProductAvailable(product.getId()))
		{
			System.out.println("Product Not Available !!!. Collect Back Cash " + vendingMachine.getAmount());
			vendingMachine.setAmount(0);
			vendingMachine.setVendingMachineCurrentState(vendingMachine.getIdleState());
			return;
		}

		vendingMachine.setVendingMachineCurrentState(vendingMachine.getProductDispenseState());
		vendingMachine.getVendingMachineCurrentState().dispense(aisleNumber);
	}

	@Override
	public void dispense(int aisleNumber)
	{
		System.out.println("Product Not Chosen !!!");
	}

}
