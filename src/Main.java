import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.regex.Pattern;

/**
 * Created by Alexey Lozovoy 25.04.2019
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("Введите грузоподъемность вашей машины...");
        Shipping shipping = new Shipping();
        Truck truck = shipping.shippingProduct();
        System.out.println("Введите товары для перевозки в формате \"название_предмета/вес/цена\" + " +
                "пробел + следующий товар, после ввода последнего товара нажмите Enter...");
        ArrayList<Product> products = shipping.productsList();
        Collections.sort(products);
        Collections.reverse(products);
        shipping.transportationProducts(products, truck);

    }
}
