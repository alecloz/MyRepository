import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Created by Alexey Lozovoy 25.04.2019
 */
public class Shipping {


    public Truck selectWeightTruck() {
        int weight = 0;
        boolean TruckNotSelected = true;
        Scanner scanner = new Scanner(System.in);
        while (TruckNotSelected) {
            try {
                weight = scanner.nextInt();
                if (weight >= 100 && weight <= 10000) {
                    TruckNotSelected = false;
                } else if (weight < 100) {
                    throw new IllegalArgumentException("Слишком маленькая грузоподъемность авто...");
                } else if (weight > 10000) {
                    throw new IllegalArgumentException("Слишком большая грузоподъемность авто...");
                }
            } catch (Exception e) {
                System.out.println("Требуется ввести числовое значение...");
            }
        }
        Truck truck = new Truck(weight);
        return truck;
    }   //Создаем грузовик с указанной грузоподъемностью (от 100 до 10000)

    public ArrayList<Product> productsList() {

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

    public void transportationProducts(ArrayList<Product> products, Truck truck) {
        int weightSum = 0;
        int weight;
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
                System.out.print(product.getName() + " ");
            }
        }
        System.out.print(priceSum + " ");
    }   //заполняем грузовик товарами, в первую очередь дорогими

}
