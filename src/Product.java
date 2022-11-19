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

    public double getPrice(){
        return this.price;
    }
    public String getName(){
        return this.name;
    }
    public void showNameSize(){
        System.out.println(this.name.length());
    }
}


