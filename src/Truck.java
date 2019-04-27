/**
 * Created by Alexey Lozovoy 25.04.2019
 */
public class Truck {
    private int weight;

    public Truck(int weight) {
        if (weight >= 100 && weight <= 10000){
            this.weight = weight;
        }
        else if (weight < 100) {
            throw new IllegalArgumentException("Слишком маленькая грузоподъемность авто...");
        }
        else if (weight > 10000) {
            throw new IllegalArgumentException("Слишком большая грузоподъемность авто...");
        }
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {

        if (weight >= 100 && weight <= 10000){
            this.weight = weight;
        }
        else if (weight < 100) {
            throw new IllegalArgumentException("Слишком маленькая грузоподъемность авто...");
        }
        else if (weight > 10000) {
            throw new IllegalArgumentException("Слишком большая грузоподъемность авто...");
        }

    }
}
