# Vending Machine System

This Repository contains codebase for Vending Machine System which uses **Singleton and State Design Pattern** . 

## Requirements

1. The machine should contain Aisle Count and Maximum Product Count of 3 slots.
2. The machine should contain products such as Chips, Chocolates, Ice-Cream with prices 10, 30, 50 respectively.
3. The machine should accept coins and notes of different denominations.
4. The machine should keep track of the total balance of coin inserted.
5. The machine should dispense the selected product.
6. The machine should return change if balance is excess.
7. The machine should keep track of the available products and their quantities in the Inventory.
8. The machine should errors, such as insufficient funds or out-of-stock products.

## Classes/Interfaces Details

1. The Product class represents a product in the vending machine, with properties such as product_id, name and price.
2. The Inventory class manages the available products and their quantities in the vending machine.
3. The State interface defines the behavior of the vending machine in different states with functionalities such as insertCoin, pressButton, dispense. It enables us to implement **state Design Pattern**.
4. The IdleState, CoinInsertedState, ProductSelectionState, and ProductDispenseState classes implement the State interface and define the specific behaviors for each state.
5. The VendingMachine class is the main class that represents the vending machine. It follows the **Singleton pattern** to ensure only one instance of the vending machine exists.
6. The VendingMachine class maintains the vendingMachineCurrentState, Inventory, total balance, and provides methods for state transitions.
7. The Main class demonstrates the usage of the vending machine by adding products to the Inventory, selecting products, inserting coins, dispensing products, and returning change.
