package showroom;
import java.util.*;
public class Vehicle {
    private String modelNumber;
    private int engineType;
    private int enginePower;
    private String tireSize;

    public static Map<Integer, String> engineTypeMap;
    public static Map<String, Integer> engineTypeMapRev;
    public static Map<Integer, String> vehicleTypeMap;
    public static Map<String, Integer> vehicleTypeMapRev;
    
    static {
        engineTypeMap = new HashMap<>();
        engineTypeMap.put(1, "oil");
        engineTypeMap.put(2, "gas");
        engineTypeMap.put(3, "diesel");

        engineTypeMapRev = new HashMap<>();
        engineTypeMapRev.put("oil", 1);
        engineTypeMapRev.put("gas", 2);
        engineTypeMapRev.put("diesel", 3);
        
        vehicleTypeMap = new HashMap<>();
        vehicleTypeMap.put(1, "Normal");
        vehicleTypeMap.put(2, "Sports");
        vehicleTypeMap.put(3, "Heavy");

        vehicleTypeMapRev = new HashMap<>();
        vehicleTypeMapRev.put("Normal", 1);
        vehicleTypeMapRev.put("Sports", 2);
        vehicleTypeMapRev.put("Heavy", 3);

    }

    Vehicle(){
        this.modelNumber = "Toyota Premio";
        this.engineType = 1;
        this.enginePower = 520;
        this.tireSize = "P225/70R16 91S";
    }
    
    
    public String getModelNumber() {
        return modelNumber;
    }
    public int getEnginePower() {
        return enginePower;
    }
    public int getEngineType() {
        return engineType;
    }
    public String getTireSize() {
        return tireSize;
    }
    public void setModelNumber(String modelNumber) {
        this.modelNumber = modelNumber;
    }
    public void setEnginePower(int enginePower) {
        this.enginePower = enginePower;
    }
    public void setEngineType(int engineType) {
        this.engineType = engineType;
    }
    public void setTireSize(String tireSize) {
        this.tireSize = tireSize;
    }


}