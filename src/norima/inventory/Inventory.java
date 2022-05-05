package norima.inventory;

import java.util.ArrayList;
import java.util.Scanner;

public class Inventory {
    private static Scanner input = new Scanner(System.in);
    private ArrayList<Item> items = new ArrayList<>();

    public void addItem() {
        System.out.print("Name of item: ");
        String name = input.nextLine();
        System.out.print("Amount of stock: ");
        int amountInStock = input.nextInt();

        items.add(new Item(name, amountInStock));
    }

    public void discontinueItem(int stockNumber) {
        boolean found = false;
        for (Item item : items) {
            if (item.getStockNumber() == stockNumber) {
                item.discontinueItem();
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Item not found.");
        }
    }

    public void displayItemStock(int stockNumber) {
        boolean found = false;
        for (Item item : items) {
            if (item.getStockNumber() == stockNumber) {
                System.out.println("This item has an amount in stock of " + item.getAmountInStock());
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Item not found.");
        }
    }
}
