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
	private State idleState;
	private State coinInsertedState;
	private State selectionState;
	private State dispenseState;
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

	public State getIdleState()
	{
		return idleState;
	}

	public void setIdleState(State idleState)
	{
		this.idleState = idleState;
	}

	public State getCoinInsertedState()
	{
		return coinInsertedState;
	}

	public void setCoinInsertedState(State coinInsertedState)
	{
		this.coinInsertedState = coinInsertedState;
	}

	public State getProductSelectionState()
	{
		return selectionState;
	}

	public void setProductSelectionState(State selectionState)
	{
		this.selectionState = selectionState;
	}

	public State getProductDispenseState()
	{
		return dispenseState;
	}

	public void setProductDispenseState(State dispenseState)
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
