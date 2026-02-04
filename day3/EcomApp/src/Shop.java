public class Shop {

    public static void main(String[] args)
    {
        Product laptop =new Product("Mackbook Air",940000.00,50);
        Product IPhone = new Product("iphone 17",150000.00,20);

        System.out.println("Processing order for "+laptop.productname);
        laptop.reduceStock(5);

        System.out.println("Stock of laptop is"+ laptop.stockQuantity);
        System.out.println("stock of phone is "+IPhone.stockQuantity);
    }
}
