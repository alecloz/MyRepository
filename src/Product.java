
public class Product implements Comparable<Product> {
    private String name;
    private int weight;
    private int price;

    public Product(String name, int weight, int price) {
        this.name = name;
        if (weight > 0) {
            this.weight = weight;
        }
        else
        throw new IllegalArgumentException("Вес товара должен быть больше нуля...");
        if (price >= 0) {
            this.price = price;
        }
        else
            throw new IllegalArgumentException("Цена товара не может быть отрицательной...");
    }

    public void setName(String name) {
            this.name = name;
    }

    public void setPrice(int price) {
        if (price >= 0)
            this.price = price;
        else
            throw new IllegalArgumentException("Цена товара не может быть отрицательной...");
    }

    public void setWeight(int weight) {
        if (weight > 0){
            this.weight = weight;
        }
        else
            throw new IllegalArgumentException("Вес товара должен быть больше нуля...");
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
        return Integer.compare(this.price, otherPrice.price);
    }

    @Override
    public String toString() {
        String sb = "Product{" + "name = " + name +
                ", price = " + price +
                ", weight = " + weight +
                '}';
        return sb;
    }
}
