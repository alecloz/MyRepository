/**
 * Created by Alexey Lozovoy 25.04.2019
 */
public class Product implements Comparable<Product> {
    private String name;
    private int weight;
    private int price;

    public Product(String name, int weight, int price) {
        this.name = name;
        this.weight = weight;
        this.price = price;
    }

    public void setName(String name) {
        int checkName;
        if (name.length() <= 1) {
            System.out.println("Имя товара состоит больше чем с одной буквы...");
            return;
        }
        try {
            checkName = Integer.parseInt(name);
            System.out.println("Имя товара не может состоять из цифр...");
        } catch (Exception e) {
            this.name = name;
        }
    }

    public void setPrice(int price) {
        if (price > 0)
            this.price = price;
    }

    public void setWeight(int weight) {
        if (weight > 0 && weight < 10000)
            this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public int compareTo(Product otherPrice) {
        if (this.price == otherPrice.price) {
            return 0;
        } else if (this.price < otherPrice.price) {
            return -1;
        } else {
            return 1;
        }
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Product{");
        sb.append("name = ").append(name);
        sb.append(", price = ").append(price);
        sb.append(", weight = ").append(weight);
        sb.append('}');
        return sb.toString();
    }
}
