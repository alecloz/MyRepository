import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;


class Shipping {

    private ArrayList<ArrayList<String>> group = new ArrayList<>(2);
    private ArrayList<Integer> priceSumProducts = new ArrayList<>();

    Truck selectWeightTruck() {
        int weight = 0;
        boolean TruckNotSelected = true;

        while (TruckNotSelected) {
            try {
                Scanner scanner = new Scanner(System.in);
                weight = scanner.nextInt();
                if (weight >= 0) {
                    TruckNotSelected = false;
                } else {
                    System.out.println("Грузоподъемность авто не может быть отрицательной...");
                }
            } catch (Exception e) {
                System.out.println("Требуется ввести числовое значение...");
            }
        }
        Truck truck = new Truck(weight);
        return truck;
    }   //Создаем грузовик с указанной грузоподъемностью (от 100 до 10000)

    ArrayList<Product> productsList() {

        String productsRead = "";
        ArrayList<Product> products = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        try {
            productsRead = scanner.nextLine();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }

        Pattern pattern = Pattern.compile("\\s");
        String[] productsArray = pattern.split(productsRead);

        for (String s1 : productsArray) {
            int weight = 0;
            int price = 0;
            productsArray = s1.split("/");
            try {
                weight = Integer.parseInt(productsArray[1]);
            } catch (NumberFormatException e) {
                System.out.println("Вес товара указан неправильно!");
                System.exit(0);
            } catch (Exception e) {
                e.getStackTrace();
                System.exit(0);
            }
            try {
                price = Integer.parseInt(productsArray[2]);
            } catch (NumberFormatException e) {
                System.out.println("Цена товара указана неправильно!");
                System.exit(0);
            } catch (Exception e) {
                e.getStackTrace();
                System.exit(0);
            }
            products.add(new Product(productsArray[0], weight, price));
        }
        return products;
    }   //Создаем ArrayList с объектами Product

    int transportationProducts(ArrayList<Product> products, Truck truck) {
        ArrayList<String> list = new ArrayList<>();
        int weightSum = 0;
        int weight = 0;
        int priceSum = 0;
        for (Product product : products) {
            weight = product.getWeight();
            if (truck.getWeight() >= weightSum) {
                weightSum += weight;
                if (truck.getWeight() < weightSum) {
                    weightSum -= weight;
                    continue;
                }
                priceSum += product.getPrice();
                list.add(product.getName());
            }
        }
        group.add(list);
        priceSumProducts.add(priceSum);
        return priceSum;
    }

    void compare(int first, int second){
        if(first > second) {
            for (String s : group.get(0)) {
                System.out.print(s + " ");
            }
            System.out.print(priceSumProducts.get(0));
        }
        else {
            for (String s : group.get(1)) {
                System.out.print(s + " ");
            }
            System.out.print(priceSumProducts.get(1));
        }
    }
}
