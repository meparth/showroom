import java.util.Scanner;
public class ManageShowroom {
    private int nVisitors;
    protected Scanner scanner = new Scanner(System.in);

    ManageShowroom(){
        nVisitors = 0;
        System.out.println("Welcome to Vehicle Showroom Exploration!");
    }

    protected void welcomeRequest(){
        System.out.println("What do you want to do?\n" +
                            "enter ( 1 ) for adding a new vehicle\n"+
                            "enter ( 2 ) for removing a vehicle\n"+
                            "enter ( 3 ) for inquiry\n");
        int option = scanner.nextInt();
        if(option==1) addVehicle();
        // else if(option==2) removeVehicle();
        // else if(option==3) inquire();
        else{
            System.out.println("Please enter a valid option!");
            welcomeRequest();
        }
    }



    protected void addVehicle(){
        System.out.println("What type of vehicle do you want to add?\n" +
                            "enter ( 1 ) for Normal Vehicle\n"+
                            "enter ( 2 ) for Sports Vehicle\n"+
                            "enter ( 3 ) for Heavy Vehicle\n");
        int option = scanner.nextInt();
        // if(option==1) 
    }

    protected void addNormalVehicle(){

        // NormalVehicle normalVehicle = new NormalVehicle(modelNumber, engineType, enginePower, tireSize)
    }
}