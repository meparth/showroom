package showroom;
import java.util.*;
public class ManageShowroom {
    protected Scanner scanner = new Scanner(System.in);
    private int nVisitors;
    // why not array?
    private ArrayList<NormalVehicle> listNormalVehicle;
    private ArrayList<SportsVehicle> listSportsVehicle;
    private ArrayList<HeavyVehicle> listHeavyVehicle;

    // public static Map<Integer, String> engineTypeMap;
    // public static Map<Integer, String> vehicleTypeMap;

   
    ManageShowroom(){
        nVisitors = 30;
        // engineTypeMap = new HashMap<>();
        // engineTypeMap.put(1, "oil");
        // engineTypeMap.put(2, "gas");
        // engineTypeMap.put(3, "diesel");

        // vehicleTypeMap = new HashMap<>();
        // vehicleTypeMap.put(1, "Normal");
        // vehicleTypeMap.put(2, "Sports");
        // vehicleTypeMap.put(3, "Heavy");

        listNormalVehicle = new ArrayList<>();
        listSportsVehicle = new ArrayList<>();
        listHeavyVehicle = new ArrayList<>();
        welcome();

        // random 
        NormalVehicle newNormalVehicle = new NormalVehicle("112", 1, 123, "DDS3");
        listNormalVehicle.add(newNormalVehicle);
        NormalVehicle anotherNewNormalVehicle = new NormalVehicle("11", 2, 11, "HHHY6");
        listNormalVehicle.add(anotherNewNormalVehicle);
    }

    private void welcome(){
        System.out.println("\n\n\n\n");
        for(int i=0 ; i<25 ; i++) System.out.format("  *");
        System.out.format("\n%60s\n", "Welcome to Vehicle Showroom Exploration!");
        for(int i=0 ; i<25 ; i++) System.out.format("  *");
        System.out.println("\n\n");
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
        System.out.println("* What do you want to do?\n" +
                            "  enter ( 1 ) for adding a new vehicle\n"+
                            "  enter ( 2 ) for removing a vehicle\n"+
                            "  enter ( 3 ) for inquiry\n"+
                            "  enter ( 4 ) to exit");
        
        int option = (int) getOption("int");

        if(option==1) addVehicle();
        else if(option==2) removeVehicle();
        else if(option==3) inquire();
        else if(option==4){
            System.out.println("\n  Goodbye!\n");
            return;
        }else{
            // err
        }
        welcomeRequest(); 
    }


    protected void addVehicle(){
        System.out.println("* What type of vehicle do you want to add?\n" +
                            "  enter ( 1 ) for Normal Vehicle\n"+
                            "  enter ( 2 ) for Sports Vehicle\n"+
                            "  enter ( 3 ) for Heavy Vehicle\n");

        int option = (int)getOption("int"); 
        // this can be integrated with all three methods
        if(option==1) addNormalVehicle();
        else if(option==2) addSportsVehicle();
        else if(option==3) addHeavyVehicle();
        else{
            System.out.println(">> Please enter a valid option!\n");
            addVehicle();
        } 
    }

    
    private void removeParticularVehicle(int type, int choice){
        if(type==1){
            listNormalVehicle.remove(choice-1);
        }else if(type==2){
            listSportsVehicle.remove(choice-1);
        }else if(type==3){
            listHeavyVehicle.remove(choice-1);
        }
    }
    protected void removeVehicle(){
        // what type to be removed -> which one (show a list)
        // remove and adjust nVisitor

        System.out.println("* Which type of vehicle do you want to remove?\n"+
                            "  enter ( 1 ) for Normal Vehicle\n"+
                            "  enter ( 2 ) for Sports Vehicle\n"+
                            "  enter ( 3 ) for Heavy Vehicle\n");
        int type = (int)getOption("int"); 

        if(type==1){
            //normal
            for(int i=0 ; i<listNormalVehicle.size() ; i++){
                prettyPrintVehicle(listNormalVehicle.get(i), type, i);
            }
        }else if(type==2){
            //sports
            for(int i=0 ; i<listSportsVehicle.size() ; i++){
                prettyPrintVehicle(listSportsVehicle.get(i), type, i);
            }
        }else if(type==3){
            //heavy
            for(int i=0 ; i<listHeavyVehicle.size() ; i++){
                prettyPrintVehicle(listHeavyVehicle.get(i), type, i);
            }
        }else{
            // err
        }
        System.out.println("* Of the above, which one do you want to remove?\n");
        int choice = (int)getOption("int");
        removeParticularVehicle(type, choice);

    }

    protected void inquire(){
        /**
         * The user can see a list of all the vehicles and number of visitors
         * So there will be two options for inquiry
         */
        System.out.println("* What do you wish to see?\n" +
                            "  enter ( 1 ) for list of vehicles\n" +
                            "  enter ( 2 ) for expected visitor count");
        int option = (int)getOption("int");
        if(option==1){
            showVehicles();
        }else if(option==2){
            showVisitors();
        }else{
            // wat
        }
    }

    private void showVisitors() {
        System.out.format("\n>> The current expected visitor count is %d\n\n", nVisitors);
    }

    private void showVehiclesHeader(){
        System.out.format("  %3s %15s %20s %15s %10s %10s %10s %10s\n",   "#", "Vehicle Type", "Model No.", "Engine Type", "Power", "Tire", "Turbo", "Weight");
        System.out.format("  %3s %15s %20s %15s %10s %10s %10s %10s\n", "---", "------------", "---------", "-----------", "-----", "----", "-----", "------");
    }
    private void prettyPrintVehicle(Object vehicle, int type, int serial) {
        /**
         * a particular vehicle can be printed with this
         * type: normal (1), sports (2), heavy (3)
         * serial: index of the vehicle in the list
         */
        serial++;
        int enginePower;
        String modelNumber, tireSize, engineType, turbo = "N/A", weight = "N/A";
        String vehicleType = Vehicle.vehicleTypeMap.get(type);
        if(type==1){
            NormalVehicle v = (NormalVehicle) vehicle;
            modelNumber = v.getModelNumber();
            enginePower = v.getEnginePower();
            engineType = Vehicle.engineTypeMap.get(v.getEngineType());
            tireSize = v.getTireSize();
        }else if(type==2){
            SportsVehicle v = (SportsVehicle) vehicle;
            modelNumber = v.getModelNumber();
            enginePower = v.getEnginePower();
            engineType = Vehicle.engineTypeMap.get(v.getEngineType());
            tireSize = v.getTireSize();
            turbo = (v.getTurbo() ? "Yes" : "No");
        }else{
            HeavyVehicle v = (HeavyVehicle) vehicle;
            modelNumber = v.getModelNumber();
            enginePower = v.getEnginePower();
            engineType = Vehicle.engineTypeMap.get(v.getEngineType());
            tireSize = v.getTireSize();
            weight = String.valueOf(v.getWeight());
        }
        System.out.format("  %3d %15s %20s %15s %10d %10s %10s %10s\n", 
                    serial, vehicleType, modelNumber, engineType, enginePower, tireSize, turbo, weight);
    }
    
    private void showVehicles() {
        // serial no, vehicle type
        showVehiclesHeader();
        int i, j, k;
        for(i=0 ; i<listNormalVehicle.size() ; i++){
            NormalVehicle currentVehicle = listNormalVehicle.get(i);
            prettyPrintVehicle(currentVehicle, 1, i);
        }
        for(j=0 ; j<listSportsVehicle.size() ; j++){
            SportsVehicle currentVehicle = listSportsVehicle.get(j);
            prettyPrintVehicle(currentVehicle, 2, i+j);
        }
        for(k=0 ; k<listHeavyVehicle.size() ; k++){
            HeavyVehicle currentVehicle = listHeavyVehicle.get(k);
            prettyPrintVehicle(currentVehicle, 3, i+j+k);
        }
        
        System.out.println("\n");
    }

    // the prompts for descriptions of vehicles while adding new ones
    private String promptModelNumber(){
        System.out.println("* Enter the Model Number:");
        return (String)getOption("string");
    }
    private int promptEnginePower(){
        System.out.println("* Enter Engine Power (in HP):");
        return (int)getOption("int");
    }
    private String promptTireSize(){
        System.out.println("* Enter the code for the tire size:");
        return (String)getOption("string");
    }
    private boolean promptTurbo(){
        System.out.println("* Enter if the vehicle is turbo enabled:\n"+
                            "  enter ( 1 ) for yes,\n"+
                            "  enter ( 0 ) for no.");
        return ((int) getOption("int") == 1);
    }
    private double promptWeight(){
        System.out.println("* Enter the weights of the vehicle (in kg):");
        return (double)getOption("double");
    }
    private int promptEngineType(){
        System.out.println("* What is the Engine type?\n"+
                            "  enter ( 1 ) for oil type,\n"+
                            "  enter ( 2 ) for gas type,\n"+
                            "  enter ( 3 ) for diesel type");
        return (int)getOption("int");
    }
    private void confirmAdded(){
        System.out.println("\n>> The vehicle has been added!\n");
    }

    protected void addNormalVehicle() {
        /**
         * useful info: model no, engine type, engine power, tire size
         */
        String modelNumber = promptModelNumber();
        int engineType = promptEngineType();
        if(engineType!=1 || engineType!=2 || engineType!=3){
            // error, check this.
        }
        int enginePower = promptEnginePower();
        String tireSize = promptTireSize();
        
        NormalVehicle newNormalVehicle = new NormalVehicle(modelNumber, engineType, enginePower, tireSize);
        listNormalVehicle.add(newNormalVehicle);

        confirmAdded();
    }



    protected void addSportsVehicle(){
        /**
         * useful info: model no, engine power, tire size, turbo
         */
        String modelNumber = promptModelNumber();
        int enginePower = promptEnginePower();
        String tireSize = promptTireSize();
        Boolean turbo = promptTurbo();

        SportsVehicle newSportsVehicle = new SportsVehicle(modelNumber, enginePower, tireSize, turbo);
        listSportsVehicle.add(newSportsVehicle);
        nVisitors+=20;
        confirmAdded();
    }

    protected void addHeavyVehicle(){
        /**
         * useful info: model no, engine power, tire size, weight
         */
        String modelNumber = promptModelNumber();
        int enginePower = promptEnginePower();
        String tireSize = promptTireSize();
        double weight = promptWeight(); 

        HeavyVehicle newHeavyVehicle = new HeavyVehicle(modelNumber, enginePower, tireSize, weight);
        listHeavyVehicle.add(newHeavyVehicle);
        confirmAdded();
    }
}