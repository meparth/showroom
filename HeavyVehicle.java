public class HeavyVehicle extends Vehicle {
    protected double weight;

    HeavyVehicle(String modelNumber, int enginePower, String tireSize, double weight) {
        this.modelNumber = modelNumber;
        this.engineType = 3;
        this.enginePower = enginePower;
        this.tireSize = tireSize;
        this.weight = weight;
    }
}