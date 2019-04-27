
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
