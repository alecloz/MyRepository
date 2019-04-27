import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;


public class Shipping {

    private ArrayList<ArrayList<String>> group = new ArrayList<>(2);
    private ArrayList<Integer> priceSumProducts = new ArrayList<>();

    public Truck selectWeightTruck() {
        int weight = 0;
        boolean truckNotSelected = true;

        while (truckNotSelected) {
            try {
                Scanner scanner = new Scanner(System.in);
                weight = scanner.nextInt();
                if (weight >= 0) {
                    truckNotSelected = false;
                } else {
                    System.out.println("Грузоподъемность авто не может быть отрицательной...");
                }
            } catch (Exception e) {
                System.out.println("Требуется ввести числовое значение...");
            }
        }
        Truck truck = new Truck(weight);
        return truck;
    }

    public ArrayList<Product> productsList() {

        String productsRead;
        ArrayList<Product> products = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        productsRead = scanner.nextLine();
        Pattern pattern = Pattern.compile("\\s");
        String[] separateProducts = pattern.split(productsRead);

        for (String s1 : separateProducts) {
            int weight = 0;
            int price = 0;
            String[] nameWeightPrice = s1.split("/");
            try {
                weight = Integer.parseInt(nameWeightPrice[1]);
            } catch (NumberFormatException e) {
                System.out.println("Вес товара указан неправильно!");
                System.exit(0);
            } catch (Exception e) {
                e.getStackTrace();
                System.exit(0);
            }
            try {
                price = Integer.parseInt(nameWeightPrice[2]);
            } catch (NumberFormatException e) {
                System.out.println("Цена товара указана неправильно!");
                System.exit(0);
            } catch (Exception e) {
                e.getStackTrace();
                System.exit(0);
            }
            products.add(new Product(nameWeightPrice[0], weight, price));
        }
        return products;
    }

    public int truckFilling(ArrayList<Product> products, Truck truck) {
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

    public void compareTruckFilling(int first, int second){
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
