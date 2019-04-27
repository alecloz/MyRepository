import java.util.ArrayList;
import java.util.Collections;


public class Main {

    public static void main(String[] args) {
        System.out.println("Test output");
        System.out.println("Введите грузоподъемность вашей машины...");
        Shipping shipping = new Shipping();
        Truck truck = shipping.selectWeightTruck();
        System.out.println("Введите товары для перевозки в формате \"название_предмета/вес/цена\" + " +
                "пробел + следующий товар, после ввода последнего товара нажмите Enter...");
        ArrayList<Product> products = shipping.productsList();
        Collections.sort(products);
        int firstResult = shipping.transportationProducts(products, truck);
        Collections.reverse(products);
        int secondResult = shipping.transportationProducts(products, truck);
        shipping.compare(firstResult, secondResult);
    }
}
