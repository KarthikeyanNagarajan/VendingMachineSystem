package com.karthik.VendingMachine.State;

import com.karthik.VendingMachine.Inventory.Inventory;
import com.karthik.VendingMachine.Inventory.Product;
import com.karthik.VendingMachine.Service.VendingMachine;

public class ProductDispenseState implements State
{
	VendingMachine vendingMachine;

	public ProductDispenseState(VendingMachine vendingMachine)
	{
		this.vendingMachine = vendingMachine;
	}

	@Override
	public void insertCoin(double amount)
	{
		System.out.println("Product Getting Dispense !!!");
	}

	@Override
	public void pressButton(int aisleNumber)
	{
		System.out.println("Product Getting Dispense !!!");
	}

	@Override
	public void dispense(int aisleNumber)
	{
		Inventory inventory = vendingMachine.getInventory();
		Product product = inventory.getProduct(aisleNumber);

		inventory.deductProductCount(aisleNumber);
		double change = vendingMachine.getAmount() - product.getPrice();

		System.out.println(product.getName() + " is getting dispensed. Collect Back Cash " + change);

		vendingMachine.setAmount(0);
		vendingMachine.setVendingMachineCurrentState(vendingMachine.getIdleState());
	}

}
