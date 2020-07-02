public class SportsVehicle extends Vehicle {
    protected boolean turbo;

    SportsVehicle(int modelNumber, int enginePower, double tireSize, boolean turbo) {
        this.modelNumber = modelNumber;
        this.engineType = "oil";
        this.enginePower = enginePower;
        this.tireSize = tireSize;
        this.turbo = turbo;
    }
    
}

