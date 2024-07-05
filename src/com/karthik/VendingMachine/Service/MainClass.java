package com.karthik.VendingMachine.Service;

import com.karthik.VendingMachine.Inventory.Product;

public class MainClass
{
	public static void main(String[] args)
	{
		int AISLE_COUNT = 3;
		int MAX_PRODUCT_COUNT = 3;
		VendingMachine vendingMachine = new VendingMachine(AISLE_COUNT);

		Product chips = new Product(1, "Chips", 10.0);
		Product chocolate = new Product(2, "Chocolate", 30.0);
		Product iceCream = new Product(3, "Ice-Cream", 50.0);

		for (int i = 0; i < MAX_PRODUCT_COUNT; i++)
			vendingMachine.addProduct(chips);

		for (int i = 0; i < MAX_PRODUCT_COUNT; i++)
			vendingMachine.addProduct(chocolate);

		for (int i = 0; i < MAX_PRODUCT_COUNT; i++)
			vendingMachine.addProduct(iceCream);

		vendingMachine.insertCoin(5.0);
		vendingMachine.insertCoin(35.0);
		vendingMachine.pressButton(2);
	}
}
