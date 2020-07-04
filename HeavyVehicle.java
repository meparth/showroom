package showroom;
public class HeavyVehicle extends Vehicle {
    private double weight;
    HeavyVehicle(String modelNumber, int enginePower, String tireSize, double weight) {
        setModelNumber(modelNumber);
        setEngineType(Vehicle.engineTypeMapRev.get("diesel"));
        setEnginePower(enginePower);
        setTireSize(tireSize);
        setWeight(weight);
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }
    public double getWeight() {
        return weight;
    }
}