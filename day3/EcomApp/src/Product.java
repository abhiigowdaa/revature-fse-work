public class Product {

    String productname;
    int stockQuantity;
    double productprice;

    public Product(String productname,double productprice, int stockQuantity)
    {
        this.productname=productname;
        this.stockQuantity=stockQuantity;
        this.productprice=productprice;
    }

    public void reduceStock(int quantity)
    {
        this.stockQuantity-= quantity;
        System.out.println("Inventory Updated for "+productname+". New stock: "+stockQuantity);
    }
}
