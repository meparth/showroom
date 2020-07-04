package showroom;
public class NormalVehicle extends Vehicle {
    NormalVehicle(String modelNumber, int engineType, int enginePower, String tireSize) {
        setModelNumber(modelNumber);
        setEnginePower(enginePower);
        setEngineType(engineType);
        setTireSize(tireSize);
    }
}