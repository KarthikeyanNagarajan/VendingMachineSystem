package com.karthik.VendingMachine.Inventory;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Inventory
{
	private Map<Integer, Product> aisleProductMap;
	private Map<Integer, Integer> productIdToCountMap;
	Queue<Integer> availableAisles;

	public Inventory(int aisleNumber)
	{
		availableAisles = new LinkedList<>();
		for (int i = 1; i <= aisleNumber; i++)
			availableAisles.add(i);

		aisleProductMap = new HashMap<>();
		productIdToCountMap = new HashMap<>();
	}

	public void addProduct(Product product)
	{
		int productId = product.getId();
		Integer productCount = productIdToCountMap.getOrDefault(productId, 0);
		if (productCount == 0)
		{
			if (availableAisles.isEmpty())
				System.out.println("Out Of Space");

			aisleProductMap.put(availableAisles.poll(), product);
		}
		productIdToCountMap.put(productId, productCount + 1);
	}

	public Product getProduct(int aisleNumber)
	{
		return aisleProductMap.get(aisleNumber);
	}

	public boolean checkIfProductAvailable(int productId)
	{
		int productCount = productIdToCountMap.getOrDefault(productId, 0);
		return productCount > 0;
	}

	public void deductProductCount(int aisleNumber)
	{
		int productId = aisleProductMap.get(aisleNumber).getId();
		int updatedProductCount = productIdToCountMap.get(productId) - 1;
		if (updatedProductCount == 0)
		{
			productIdToCountMap.remove(productId);
			aisleProductMap.remove(aisleNumber);
			availableAisles.add(aisleNumber);
		}
		else
			productIdToCountMap.put(productId, updatedProductCount);
	}
}
