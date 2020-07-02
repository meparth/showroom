// package showroom;

public class Vehicle {

    protected int modelNumber;
    protected String engineType;
    protected int enginePower;
    protected double tireSize;

    Vehicle(){
        this.modelNumber = 1;
        this.engineType = "oil";
        this.enginePower = 520;
        this.tireSize = 3.33;
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