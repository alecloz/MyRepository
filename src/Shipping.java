import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Pattern;

/**
 * Created by Alexey Lozovoy 25.04.2019
 */
public class Shipping {


    public Truck shippingProduct() {
        int weight = 0;
        boolean yesNo = true;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (yesNo) {
            try {
                weight = Integer.parseInt(reader.readLine());
            } catch (Exception e) {
                System.out.println("Требуется ввести числовое значение...");
                continue;
            }
            if (weight < 1000 || weight > 10000) {
                System.out.println("В нашем парке нет машин с такой грузоподъемностью. Введите значение снова...");
            } else
                break;
        }
        Truck truck = new Truck(weight);
        return truck;
    }   //Создаем грузовик с указанной грузоподъемностью (от 1000 до 10000)

    public ArrayList<Product> productsList() {

        String productsRead = "";
        int weight;
        int price;
        ArrayList<Product> products = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            productsRead = bufferedReader.readLine();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Pattern pattern = Pattern.compile("\\s");
        String[] productsArray = pattern.split(productsRead);

        for (String s1 : productsArray) {

            productsArray = s1.split("/");
            try {
                weight = Integer.parseInt(productsArray[1]);
            } catch (Exception e) {
                System.out.println("Вес товара указан неправильно!");
                break;
            }
            try {
                price = Integer.parseInt(productsArray[2]);
            } catch (Exception e) {
                System.out.println("Цена товара указана неправильно!");
                break;
            }
            products.add(new Product(productsArray[0], weight, price));
        }
        return products;
    }   //Создаем ArrayList с объектами Product

    public void transportationProducts(ArrayList<Product> products, Truck truck) {
        int weightSum = 0;
        int weight = 0;
        int priceSum = 0;
        for (Product product : products) {
            weight = product.getWeight();
            if (truck.getWeight() >= weightSum) {
                weightSum += weight;
                priceSum += product.getPrice();
                System.out.print(product.getName() + " ");
            }
        }
        System.out.print(priceSum + " ");
    }   //заполняем грузовик товарами, в первую очередь дорогими

}
