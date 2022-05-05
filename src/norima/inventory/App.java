package norima.inventory;

import java.util.Scanner;

public class App {

    public static class UserInput {
        private static Scanner input = new Scanner(System.in);

        public static int askForNumber(int lowerLimit, int upperLimit, String question) {
            int userSelection;

            while (true) {
                System.out.print(question + ": ");
                try {
                    userSelection = Integer.parseInt(input.nextLine());
                    if (userSelection > upperLimit || userSelection < lowerLimit) {
                        System.out.println("Your input is invalid. Please try again.");
                        continue;
                    }
                } catch (Exception e) {
                    System.out.println("Your choice is invalid. Please try again.");
                    continue;
                }
                return userSelection;
            }
        }

        public static int askForNumber(String question) {
            while (true) {
                System.out.print(question + ": ");
                try {
                    int userSelection = Integer.parseInt(input.nextLine());
                    if (userSelection >= 1) {
                        return userSelection;
                    } else {
                        System.out.println("Please enter a positive number. Try again.");
                    }

                } catch (Exception e) {
                    System.out.println("Your input is invalid. Please try again.");
                }
            }
        }

        public static Boolean askForConfirmation(String question) {
            String userSelection;
            while (true) {
                System.out.print(question + ": ");
                userSelection = input.nextLine();
                if (userSelection.equalsIgnoreCase("y")) {
                    return true;
                } else if (userSelection.equalsIgnoreCase("n")) {
                    return false;
                } else {
                    System.out.println("Invalid answer. Please try again.");
                }
            }
        }
    }

    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        System.out.println("Welcome to the Inventory!");

        while (true) {
            System.out.println("What would you like to do?");
            System.out.println("[1] Add an item");
            System.out.println("[2] Discontinue an item");
            System.out.println("[3] Display item's stock");
            System.out.println("[0] Quit");

            int choice = UserInput.askForNumber(0, 3, "Your choice");

            switch (choice) {
                case 0: {
                    System.exit(0);
                }
                case 1: {
                    inventory.addItem();
                    break;
                }
                case 2: {
                    int stockNumber = UserInput
                            .askForNumber("What item do you want to discontinue? (Provide the Stock Number)");
                    inventory.discontinueItem(stockNumber);
                    break;
                }
                case 3: {
                    int stockNumber = UserInput
                            .askForNumber("What item do you want to show? (Provide the Stock Number)");
                    inventory.displayItemStock(stockNumber);
                    break;
                }
                default: {
                    break;
                }
            }

        }
    }
}
