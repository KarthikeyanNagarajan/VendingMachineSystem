package com.karthik.VendingMachine.State;

import com.karthik.VendingMachine.Inventory.Inventory;
import com.karthik.VendingMachine.Inventory.Product;
import com.karthik.VendingMachine.Service.VendingMachine;

public class DispenseState implements State
{
	VendingMachine vendingMachine;

	public DispenseState(VendingMachine vendingMachine)
	{
		this.vendingMachine = vendingMachine;
	}

	@Override
	public void insertCoin(double amount)
	{
		throw new IllegalStateException("Product Getting Dispense");
	}

	@Override
	public void pressButton(int aisleNumber)
	{
		throw new IllegalStateException("Product Getting Dispense");
	}

	@Override
	public void dispense(int aisleNumber)
	{
		Inventory inventory = vendingMachine.getInventory();
		Product product = inventory.getProduct(aisleNumber);

		inventory.deductProductCount(aisleNumber);

		double change = vendingMachine.getAmount() - product.getPrice();
		vendingMachine.setAmount(0);

		vendingMachine.setVendingMachineCurrentState(vendingMachine.getNoCoinState());

		System.out.println("Product With id " + product.getId() + " getting dispensed. Change is " + change);
	}

}
