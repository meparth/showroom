import java.util.*;
// package showroom;

public class Vehicle {
    protected int modelNumber;
    protected int engineType;
    protected int enginePower;
    protected String tireSize;

    

    Vehicle(){
        this.modelNumber = 1;
        this.engineType = 1;
        this.enginePower = 520;
        this.tireSize = "P225/70R16 91S";
    }
    
    public static void emne(){
        System.out.println("------Emne called-------");

    }
    public void shout(){
        System.out.println("Shout called againnnnnn");
    }

    public void getDetails(){
        System.out.print("Model: ");
        System.out.print(this.modelNumber);
        System.out.print("\nEngine Type: ");
        System.out.print(this.engineType);
        System.out.print("Engine Power: ");
        System.out.print(this.enginePower);
        System.out.print("\nTire Size: ");
        System.out.print(this.tireSize);
        System.out.print("\n");
    }


}