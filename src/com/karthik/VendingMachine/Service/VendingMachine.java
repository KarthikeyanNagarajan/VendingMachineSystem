package com.karthik.VendingMachine.Service;

import com.karthik.VendingMachine.Inventory.Inventory;
import com.karthik.VendingMachine.Inventory.Product;
import com.karthik.VendingMachine.State.CoinInsertedState;
import com.karthik.VendingMachine.State.IdleState;
import com.karthik.VendingMachine.State.ProductDispenseState;
import com.karthik.VendingMachine.State.ProductSelectionState;
import com.karthik.VendingMachine.State.State;

public class VendingMachine
{
	private IdleState idleState;
	private CoinInsertedState coinInsertedState;
	private ProductSelectionState selectionState;
	private ProductDispenseState dispenseState;
	private State vendingMachineCurrentState;
	private Inventory inventory;
	private double amount;

	public VendingMachine(int AISLE_COUNT)
	{
		idleState = new IdleState(this);
		coinInsertedState = new CoinInsertedState(this);
		selectionState = new ProductSelectionState(this);
		dispenseState = new ProductDispenseState(this);
		vendingMachineCurrentState = idleState;
		amount = 0.0;
		inventory = new Inventory(AISLE_COUNT);
	}

	public IdleState getIdleState()
	{
		return idleState;
	}

	public void setIdleState(IdleState idleState)
	{
		this.idleState = idleState;
	}

	public CoinInsertedState getCoinInsertedState()
	{
		return coinInsertedState;
	}

	public void setCoinInsertedState(CoinInsertedState coinInsertedState)
	{
		this.coinInsertedState = coinInsertedState;
	}

	public ProductSelectionState getProductSelectionState()
	{
		return selectionState;
	}

	public void setProductSelectionState(ProductSelectionState selectionState)
	{
		this.selectionState = selectionState;
	}

	public ProductDispenseState getProductDispenseState()
	{
		return dispenseState;
	}

	public void setProductDispenseState(ProductDispenseState dispenseState)
	{
		this.dispenseState = dispenseState;
	}

	public State getVendingMachineCurrentState()
	{
		return vendingMachineCurrentState;
	}

	public void setVendingMachineCurrentState(State vendingMachineCurrentState)
	{
		this.vendingMachineCurrentState = vendingMachineCurrentState;
	}

	public Inventory getInventory()
	{
		return inventory;
	}

	public void setInventory(Inventory inventory)
	{
		this.inventory = inventory;
	}

	public double getAmount()
	{
		return amount;
	}

	public void setAmount(double amount)
	{
		this.amount = amount;
	}

	public boolean hasSufficientAmount(double expectedAmount)
	{
		return expectedAmount <= this.amount;
	}

	public void insertCoin(double amount)
	{
		this.vendingMachineCurrentState.insertCoin(amount);
		System.out.println(amount + " coin is inserted.");
	}

	public void pressButton(int aisleNumber)
	{
		this.vendingMachineCurrentState.pressButton(aisleNumber);
	}

	public void addProduct(Product product)
	{
		try
		{
			this.inventory.addProduct(product);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
