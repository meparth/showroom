import java.util.*;
public class ManageShowroom {
    protected Scanner scanner = new Scanner(System.in);
    private int nVisitors;
    // why not array?
    private ArrayList<NormalVehicle> listNormalVehicle;
    private ArrayList<SportsVehicle> listSportsVehicle;
    private ArrayList<HeavyVehicle> listHeavyVehicle;

    public static Map<Integer, String> engineTypeMap;
   
    ManageShowroom(){
        nVisitors = 30;
        engineTypeMap = new HashMap<>();
        engineTypeMap.put(1, "oil");
        engineTypeMap.put(2, "gas");
        engineTypeMap.put(3, "diesel");
        listNormalVehicle = new ArrayList<>();
        listSportsVehicle = new ArrayList<>();
        listHeavyVehicle = new ArrayList<>();

        System.out.println("Welcome to Vehicle Showroom Exploration!");
    }
    
    protected Object getOption(String type){
        /**
         * call with "int" for getting typical integer responses from user
         * "string" for getting a string response
         * "bool" for boolean response
         * "double" for double response
         */
        System.out.print(">>> ");

        switch(type){
            case "int":
                return scanner.nextInt();
            case "string":
                scanner.nextLine();
                return scanner.nextLine();
            case "bool":
                return scanner.nextBoolean();
            case "double":
                return scanner.nextDouble();
        }
            
        return (Object) null;
    }
    
   
    protected void welcomeRequest(){
        /**
         * The very first prompt that'd be shown to the user
         */
        System.out.println("What do you want to do?\n" +
                            "enter ( 1 ) for adding a new vehicle\n"+
                            "enter ( 2 ) for removing a vehicle\n"+
                            "enter ( 3 ) for inquiry\n");
        
        int option = (int) getOption("int");

        if(option==1) addVehicle();
        else if(option==2) removeVehicle();
        else if(option==3) inquire();
        else{
            System.out.println("Please enter a valid option!");
            welcomeRequest();
        }
        welcomeRequest(); // ask if wanna quit
    }


    protected void addVehicle(){
        System.out.println("What type of vehicle do you want to add?\n" +
                            "enter ( 1 ) for Normal Vehicle\n"+
                            "enter ( 2 ) for Sports Vehicle\n"+
                            "enter ( 3 ) for Heavy Vehicle\n");

        int option = (int)getOption("int");

        if(option==1) addNormalVehicle();
        else if(option==2) addSportsVehicle();
        else if(option==3) addHeavyVehicle();
        else{
            System.out.println("Please enter a valid option!");
            addVehicle();
        } 
    }

    
    
    protected void removeVehicle(){
        // what type to be removed -> which one (show a list)
        // remove and adjust nVisitor
    }

    protected void inquire(){
        /**
         * The user can see a list of all the vehicles and number of visitors
         * So there will be two options for inquiry
         */
        System.out.println("What do you wish to see?\n" +
                            "enter ( 1 ) for list of vehicles\n" +
                            "enter ( 2 ) for expected visitor count");
        int option = (int)getOption("int");
        if(option==1){
            showVehicles();
        }else if(option==2){

        }else{
            // wat
        }
        // the showing part in another function



    }
    
    private void showVehicles() {
        // prettify :|
        // head row for attribute names
        // apatoto normal gula show koro
        for(int i=0 ; i<listNormalVehicle.size() ; i++){
            // System.out.print(listNormalVehicle.get(i).modelNumber);
            NormalVehicle currentVehicle = listNormalVehicle.get(i);
            System.out.println(currentVehicle.modelNumber +
                                 "  " +
                                 currentVehicle.engineType +
                                 "  " +
                                 currentVehicle.tireSize);
        }
        System.out.println("---done---");
    }

    protected void addNormalVehicle() {
        /**
         * useful info: model no, engine type, engine power, tire size
         */
        System.out.println("Enter the Model Number:");
        int modelNumber = (int) getOption("int");

        System.out.println("Enter Engine type:\n"+
                            "( 1 ) for oil type,\n"+
                            "( 2 ) for gas type,\n"+
                            "( 3 ) for diesel type");
        int engineType = (int)getOption("int");
        if(engineType!=1 || engineType!=2 || engineType!=3){
            // error, check this.
        }

        System.out.println("Enter Engine Power:");
        int enginePower = (int)getOption("int");

        System.out.println("Enter the code for the tire size:");
        String tireSize = (String)getOption("string");
        
        NormalVehicle newNormalVehicle = new NormalVehicle(modelNumber, engineType, enginePower, tireSize);
        listNormalVehicle.add(newNormalVehicle);
    }

    protected void addSportsVehicle(){
        /**
         * useful info: model no, engine power, tire size, turbo
         */
        System.out.println("Enter the Model Number:");
        int modelNumber = (int) getOption("int");

        System.out.println("Enter Engine Power:");
        int enginePower = (int)getOption("int");

        System.out.println("Enter the code for the tire size:");
        String tireSize = (String)getOption("string");

        System.out.println("Enter if the vehicle is turbo enabled:\n"+
                            "( 1 ) for yes,\n"+
                            "( 0 ) for no.");
        Boolean turbo = ((int) getOption("int") == 1);
        SportsVehicle newSportsVehicle = new SportsVehicle(modelNumber, enginePower, tireSize, turbo);
        listSportsVehicle.add(newSportsVehicle);
        nVisitors+=20;
    }

    protected void addHeavyVehicle(){
        /**
         * useful info: model no, engine power, tire size, weight
         */
        System.out.println("Enter the Model Number:");
        int modelNumber = (int) getOption("int");

        System.out.println("Enter Engine Power:");
        int enginePower = (int)getOption("int");

        System.out.println("Enter the code for the tire size:");
        String tireSize = (String)getOption("string");

        System.out.println("Enter the weight of the vehicle:");
        double weight = (double)getOption("double");

        HeavyVehicle newHeavyVehicle = new HeavyVehicle(modelNumber, enginePower, tireSize, weight);
        listHeavyVehicle.add(newHeavyVehicle);
    }

    

}