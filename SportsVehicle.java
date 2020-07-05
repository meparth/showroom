package showroom;
public class SportsVehicle extends Vehicle {
    private boolean turbo;
    SportsVehicle(String modelNumber, int enginePower, String tireSize, boolean turbo) {
        setModelNumber(modelNumber);
        setEngineType(Vehicle.engineTypeMapRev.get("oil"));
        setEnginePower(enginePower);
        setTireSize(tireSize);
        setTurbo(turbo);
    }
    public void setTurbo(boolean turbo) {
        this.turbo = turbo;
    }
    public boolean isTurbo(){
        return turbo;
    }
    
}

