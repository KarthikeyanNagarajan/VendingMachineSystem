package com.karthik.VendingMachine.Service;

import com.karthik.VendingMachine.Inventory.Inventory;
import com.karthik.VendingMachine.Inventory.Product;
import com.karthik.VendingMachine.State.CoinInsertedState;
import com.karthik.VendingMachine.State.DispenseState;
import com.karthik.VendingMachine.State.NoCoinState;
import com.karthik.VendingMachine.State.State;

public class VendingMachine
{
	private NoCoinState noCoinState;
	private CoinInsertedState coinInsertedState;
	private DispenseState dispenseState;
	private State vendingMachineCurrentState;
	private Inventory inventory;
	private double amount;

	public VendingMachine(int AISLE_COUNT)
	{
		noCoinState = new NoCoinState(this);
		coinInsertedState = new CoinInsertedState(this);
		dispenseState = new DispenseState(this);
		vendingMachineCurrentState = noCoinState;
		amount = 0.0;
		inventory = new Inventory(AISLE_COUNT);
	}

	public NoCoinState getNoCoinState()
	{
		return noCoinState;
	}

	public void setNoCoinState(NoCoinState noCoinState)
	{
		this.noCoinState = noCoinState;
	}

	public CoinInsertedState getCoinInsertedState()
	{
		return coinInsertedState;
	}

	public void setCoinInsertedState(CoinInsertedState coinInsertedState)
	{
		this.coinInsertedState = coinInsertedState;
	}

	public DispenseState getDispenseState()
	{
		return dispenseState;
	}

	public void setDispenseState(DispenseState dispenseState)
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
		this.vendingMachineCurrentState.dispense(aisleNumber);
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
