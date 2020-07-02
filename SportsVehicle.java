public class SportsVehicle extends Vehicle {
    protected boolean turbo;

    SportsVehicle(int modelNumber, int enginePower, String tireSize, boolean turbo) {
        this.modelNumber = modelNumber;
        this.engineType = 1;
        this.enginePower = enginePower;
        this.tireSize = tireSize;
        this.turbo = turbo;
    }
    
}

