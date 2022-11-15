import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        //Optional
        String shirtName = "shirt";
        double shirtPrice = 26.40;
        Product shirt = new Product(shirtName, shirtPrice);
        shirt.showNameSize(); //5

        String socksName = null;
        double socksPrice = 5.45;
        Product socks = new Product(socksName, socksPrice);
        //socks.showNameSize(); Exception in thread "main" java.lang.NullPointerException

        String pantsName = null;
        pantsName = Optional.ofNullable(pantsName).orElseGet(() -> "default");
        double pantsPrice = 25.45;
        Product pants = new Product(pantsName, pantsPrice);
        pants.showNameSize(); //7

    }

}
