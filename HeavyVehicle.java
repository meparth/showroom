public class HeavyVehicle extends Vehicle {
    protected double weight;

    HeavyVehicle(int modelNumber, int enginePower, double tireSize, double weight) {
        this.modelNumber = modelNumber;
        this.engineType = "diesel";
        this.enginePower = enginePower;
        this.tireSize = tireSize;
        this.weight = weight;
    }
}