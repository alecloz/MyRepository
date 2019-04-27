
public class Truck {
    private int weight;

    Truck(int weight) {
        if (weight >= 0){
            this.weight = weight;
        }
        else {
            throw new IllegalArgumentException("Грузоподъемность авто не может быть отрицательной...");
        }
    }

    int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {

        if (weight >= 0){
            this.weight = weight;
        }
        else {
            throw new IllegalArgumentException("Грузоподъемность авто не может быть отрицательной...");
        }

    }
}
