package showroom;
public class HeavyVehicle extends Vehicle {
    private double weight;

    HeavyVehicle(String modelNumber, int enginePower, String tireSize, double weight) {
        this.modelNumber = modelNumber;
        this.engineType = 3;
        this.enginePower = enginePower;
        this.tireSize = tireSize;
        this.weight = weight;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }
    public double getWeight() {
        return weight;
    }
}