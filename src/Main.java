import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Alexey Lozovoy 25.04.2019
 */
public class Main {

    public static void main(String[] args) {


        //Truck truck = new Truck(100000);

        System.out.println("Введите грузоподъемность вашей машины...");
        Shipping shipping = new Shipping();
        Truck truck = shipping.selectWeightTruck();
        System.out.println("Введите товары для перевозки в формате \"название_предмета/вес/цена\" + " +
                "пробел + следующий товар, после ввода последнего товара нажмите Enter...");
        ArrayList<Product> products = shipping.productsList();
        Collections.sort(products);
        Collections.reverse(products);
        shipping.transportationProducts(products, truck);

    }
}
