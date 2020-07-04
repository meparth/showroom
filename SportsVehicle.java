package showroom;
public class SportsVehicle extends Vehicle {
    private Boolean turbo;

    SportsVehicle(String modelNumber, int enginePower, String tireSize, Boolean turbo) {
        setModelNumber(modelNumber);
        setEngineType(Vehicle.engineTypeMapRev.get("oil"));
        setEnginePower(enginePower);
        setTireSize(tireSize);
        setTurbo(turbo);
    }
    public void setTurbo(Boolean turbo) {
        this.turbo = turbo;
    }
    public Boolean getTurbo(){
        return turbo;
    }
    
}

