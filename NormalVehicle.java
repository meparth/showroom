public class NormalVehicle extends Vehicle {
    NormalVehicle(int modelNumber, String engineType, int enginePower, double tireSize) {
        if(engineType!="oil" || engineType!="gas" || engineType!="diesel"){
            System.out.println("Check the engine please!");
        }
        this.modelNumber = modelNumber;
        this.engineType = engineType;
        this.enginePower = enginePower;
        this.tireSize = tireSize;

    }
}