import java.util.Scanner;
public class ShowroomExplore{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        
        // ManageShowroom showroom = new ManageShowroom();

        System.out.println("option 1, 2, 3");
        int option = scanner.nextInt();
        if(option==1){
            System.out.println("option 5, 6, 7");
            System.out.print(">>>");
            int anotheroption = scanner.nextInt();
            if(anotheroption==5){
                System.out.println("option 4");
                int yetanotheroption = scanner.nextInt();
                if(yetanotheroption==4){
                    System.out.println("yu passed.");
                }
            }
        }


        // showroom.addVehicle();
        // System.out.println("what do you want? 1-> add, 2-> remove, 3-> inquire");
        // int choice;
        // choice = scanner.nextInt();
        // if(choice==1){

        // }else if(choice==2){

        // }else if(choice==3){

        // }else{
        //     System.out.println("Please enter a valid choice!");
        // }
        // Vehicle v = new Vehicle();
        // // v.shout();

        // v.getDetails();
        // // Vehicle.emne();
        // Vehicle v2 = new Vehicle();
        // v2.getDetails();
    }
    
    


}