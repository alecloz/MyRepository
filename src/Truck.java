/**
 * Created by Alexey Lozovoy 25.04.2019
 */
public class Truck {
    private int weight;

    public Truck(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        if (weight >= 1000 && weight <= 10000)
            this.weight = weight;
    }
}
