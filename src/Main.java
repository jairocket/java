import java.util.*;
import java.util.stream.Collectors;
import java.util.Scanner;

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


        Product shirt2 = new Product("shirt2", 16.99);
        Product pants2 = new Product("pants2", 21.99);
        //Lists
        ArrayList<Product> products = new ArrayList<>();
        products.add(shirt);
        products.add(pants);
        products.add(shirt2);
        products.add(pants2);
        System.out.println(products); //[Product@4617c264, Product@36baf30c, Product@7a81197d, Product@5ca881b5]

        //Filter

        List<Product> expensiveProducts = products.stream().filter(cloth -> cloth.getPrice() > 20.0).collect(Collectors.toList());
        System.out.println(expensiveProducts); //[Product@4617c264, Product@36baf30c, Product@5ca881b5]

        List<Product> cheapProducts = products.stream().filter(cloth -> cloth.getPrice() < 20.0).collect(Collectors.toList());
        System.out.println(cheapProducts); //[Product@7a81197d]

        //Map

        List<String> productNames = products.stream().map(cloth -> cloth.getName()).collect(Collectors.toList());
        System.out.println(productNames); //[shirt, default, shirt2, pants2]

        //FlatMap

        List<List<Double>> moreExpensivePrices = expensiveProducts.stream().map(product -> Arrays.asList(product.getPrice())).collect(Collectors.toList());
        List<List<Double>> lessExpensivePrices = cheapProducts.stream().map(product -> Arrays.asList(product.getPrice())).collect(Collectors.toList());
        System.out.println(moreExpensivePrices); //[[26.4], [25.45], [21.99]]

        System.out.println(moreExpensivePrices.stream().flatMap(Collection::stream).collect(Collectors.toList()));


            Scanner input = new Scanner(System.in);
            System.out.println("Para ver os preços dos produtos mais caros, digite 1");
            System.out.println("Para ver os preços dos produtos mais baratos, digite 2");
            int number = input.nextInt();
            switch (number){
                case 1:
                    System.out.println(moreExpensivePrices.stream().flatMap(Collection::stream).collect(Collectors.toList()));
                    break;
                case 2:
                    System.out.println(lessExpensivePrices.stream().flatMap(Collection::stream).collect(Collectors.toList()));
                    break;
                default:
                    System.out.println("Escolha inválida");
            }





    }

}
