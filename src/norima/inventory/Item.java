package norima.inventory;

public class Item {
    public static int STOCK_NUMBER_CURRENT = 1000;
    private int stockNumber;
    private int amountInStock;
    private String name;

    public Item(String name, int amountInStock) {
        this.stockNumber = STOCK_NUMBER_CURRENT;
        this.name = name;
        this.amountInStock = amountInStock;
        STOCK_NUMBER_CURRENT++;
    }

    public void discontinueItem() {
        this.name = "discontinued";
        this.amountInStock = 0;
    }

    public int getAmountInStock() {
        return amountInStock;
    }

    public String getName() {
        return name;
    }

    public int getStockNumber() {
        return stockNumber;
    }

    public void setAmountInStock(int amountInStock) {
        this.amountInStock = amountInStock;
    }

}
