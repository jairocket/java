public class Product {
    private String name;
    private double price;

    public Product(String name, double price){
        this.name = name;
        this.price = price;
    }

    public void show(){
        System.out.println(this.name + this.price);
    }
    public void showNameSize(){System.out.println(this.name.length());}
}

