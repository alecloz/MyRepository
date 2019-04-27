
public class Truck {
    private int weight;

    public Truck(int weight) {
        if (weight >= 0){
            this.weight = weight;
        }
        else if (weight < 0) {
            throw new IllegalArgumentException("Грузоподъемность авто не может быть отрицательной...");
        }
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {

        if (weight >= 0){
            this.weight = weight;
        }
        else if (weight < 0) {
            throw new IllegalArgumentException("Грузоподъемность авто не может быть отрицательной...");
        }

    }
}
