package showroom;
import java.util.*;
public class ManageShowroom {
    private Scanner scanner = new Scanner(System.in);
    private int nVisitors;
    private int nVisitorsForSports;
    private ArrayList<NormalVehicle> listNormalVehicle;
    private ArrayList<SportsVehicle> listSportsVehicle;
    private ArrayList<HeavyVehicle> listHeavyVehicle;

    ManageShowroom(){
        nVisitors = 30;
        nVisitorsForSports = 20;
        listNormalVehicle = new ArrayList<>();
        listSportsVehicle = new ArrayList<>();
        listHeavyVehicle = new ArrayList<>();

        // calling the welcome texts
        welcome();

        // random init
        // NormalVehicle newNormalVehicle = new NormalVehicle("112", 1, 123, "DDS3");
        // listNormalVehicle.add(newNormalVehicle);
        // NormalVehicle anotherNewNormalVehicle = new NormalVehicle("11", 2, 11, "HHHY6");
        // listNormalVehicle.add(anotherNewNormalVehicle);
    }

    private void welcome(){
        /**
         * welcome screen with fancy lettering
         */
        System.out.println("\n\n\n\n");
        for(int i=0 ; i<25 ; i++) System.out.format("  *");
        System.out.format("\n%60s\n", "Welcome to Vehicle Showroom Exploration!");
        for(int i=0 ; i<25 ; i++) System.out.format("  *");
        System.out.println("\n\n");
    }


    
    
    protected Object getOption(String type){
        /**
         * A helper function to get inputs from user
         * type: "int" for getting typical integer responses from user
         *       "string" for getting a string response
         *       "bool" for boolean response
         *       "double" for double response
         * cast the returned object to desirable data type
         */
        System.out.print(">>> ");

        try {
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
            
        } catch (Exception e) {
            System.out.println("\n>> Encountered an error. Let's try this again!");
            scanner.nextLine();
            welcomeRequest();
        }
        
        return (Object) null;
    }
    
   
    protected void welcomeRequest(){
        /**
         * The very first prompt to be shown to the user
         * After a request is processed, this will be called again.
         */
        System.out.println("\n* What do you want to do?\n" +
                            "  enter ( 1 ) for adding a new vehicle\n"+
                            "  enter ( 2 ) for removing a vehicle\n"+
                            "  enter ( 3 ) for inquiry\n"+
                            "  enter ( 4 ) to exit");
        
        int option = (int) getOption("int");

        if(option==1) addVehicle();
        else if(option==2) removeVehicle();
        else if(option==3) inquire();
        else if(option==4){
            System.out.println("\n ** Goodbye! **\n");
            return;
        }else{
            System.out.println("\n>> Please enter a valid option!\n");
        }
        welcomeRequest(); 
    }


    protected void addVehicle(){
        /**
         * This is to be called while adding a new vehicle
         * At first the type of the vehicle will be asked and will be 
         * redirected to respective vehicle adding methods 
         */
        System.out.println("\n* What type of vehicle do you want to add?\n" +
                            "  enter ( 1 ) for Normal Vehicle\n"+
                            "  enter ( 2 ) for Sports Vehicle\n"+
                            "  enter ( 3 ) for Heavy Vehicle\n");

        int option = (int)getOption("int"); 
        if(option==Vehicle.vehicleTypeMapRev.get("Normal")) addNormalVehicle();
        else if(option==Vehicle.vehicleTypeMapRev.get("Sports")) addSportsVehicle();
        else if(option==Vehicle.vehicleTypeMapRev.get("Heavy")) addHeavyVehicle();
        else{
            System.out.println("\n>> Please enter a valid option!\n");
            addVehicle();
        } 
    }

    protected void removingNotPossible(){
        System.out.println("\n>> Sorry, there is no vehicle listed in the preferred selection!");
    }

    protected void removeVehicle(){
        /**
         * To remove a vehicle, at first the type of the removable vehicle will be prompted
         * Then a list of the desired vehicle will be shown
         */

        System.out.println("\n* Which type of vehicle do you want to remove?\n"+
                            "  enter ( 1 ) for Normal Vehicle\n"+
                            "  enter ( 2 ) for Sports Vehicle\n"+
                            "  enter ( 3 ) for Heavy Vehicle\n");
        int type = (int)getOption("int"); 
        // showVehiclesHeader();
        if(type==Vehicle.vehicleTypeMapRev.get("Normal")){
            if(listNormalVehicle.size()==0){
                removingNotPossible();
                // welcomeRequest();
                return;
            }
            showVehiclesHeader();
            for(int i=0 ; i<listNormalVehicle.size() ; i++){
                prettyPrintVehicle(listNormalVehicle.get(i), type, i);
            }
        }else if(type==Vehicle.vehicleTypeMapRev.get("Sports")){
            if(listSportsVehicle.size()==0){
                removingNotPossible();
                // welcomeRequest();
                return;
            }
            showVehiclesHeader();
            for(int i=0 ; i<listSportsVehicle.size() ; i++){
                prettyPrintVehicle(listSportsVehicle.get(i), type, i);
            }
        }else if(type==Vehicle.vehicleTypeMapRev.get("Heavy")){
            if(listHeavyVehicle.size()==0){
                removingNotPossible();
                // welcomeRequest();
                return;
            }
            showVehiclesHeader();
            for(int i=0 ; i<listHeavyVehicle.size() ; i++){
                prettyPrintVehicle(listHeavyVehicle.get(i), type, i);
            }
        }else{
            System.out.println("\n>> Please enter a valid option!\n");
            removeVehicle();
            return;
        }
        System.out.println("\n* Of the above, which one do you want to remove?\n");
        int choice = (int)getOption("int");

        try{
            removeParticularVehicle(type, choice);
        }catch(Exception e){
            System.out.println("\n>> An error occurred");
            return;
        }
        // confirm done
        System.out.println("\n>> Vehicle is removed from the showroom.");
    }
    
    private void removeParticularVehicle(int type, int choice){
        /**
         * Given the type of the vehicle and index, it will be removed here.
         */
        if(type==Vehicle.vehicleTypeMapRev.get("Normal")){
            listNormalVehicle.remove(choice-1);
        }else if(type==Vehicle.vehicleTypeMapRev.get("Sports")){
            listSportsVehicle.remove(choice-1);
            nVisitors-=nVisitorsForSports;
        }else if(type==Vehicle.vehicleTypeMapRev.get("Heavy")){
            listHeavyVehicle.remove(choice-1);
        }
    }

    protected void inquire(){
        /**
         * The user can see a list of all the vehicles and number of visitors
         * So there will be two options for inquiry
         */
        System.out.println("\n* What do you wish to see?\n" +
                            "  enter ( 1 ) for list of vehicles\n" +
                            "  enter ( 2 ) for expected visitor count");
        int option = (int)getOption("int");
        if(option==1){
            showVehicles();
        }else if(option==2){
            showVisitors();
        }else{
            System.out.println("\n>> Please enter a valid option!\n");
            inquire();
        }
    }

    private void showVisitors() {
        /**
         * Shows current visitor count
         */
        System.out.format("\n>> The current expected visitor count is %d\n\n", nVisitors);
    }

    private void showVehiclesHeader(){
        /**
         * This function is called whenever a list of vehicle details is needed
         * prints the header of that table.
         */
        System.out.format("\n\n  %3s %15s %20s %15s %10s %10s %10s %10s\n",   "#", "Vehicle Type", "Model No.", "Engine Type", "Power", "Tire", "Turbo", "Weight");
        System.out.format(    "  %3s %15s %20s %15s %10s %10s %10s %10s\n", "---", "------------", "---------", "-----------", "-----", "----", "-----", "------");
        System.out.println();
    }

    private void prettyPrintVehicle(Object vehicle, int type, int serial) {
        /**
         * A particular vehicle can be printed with this
         * type:   (1) normal, (2) sports, (3) heavy 
         * serial: (index+1) of the vehicle in the list
         */

        serial++;
        int enginePower = 0;
        String modelNumber = "", tireSize = "", engineType = "", turbo = "N/A", weight = "N/A";
        String vehicleType = Vehicle.vehicleTypeMap.get(type);
        if(type==Vehicle.vehicleTypeMapRev.get("Normal")){
            NormalVehicle v = (NormalVehicle) vehicle;
            modelNumber = v.getModelNumber();
            enginePower = v.getEnginePower();
            engineType = Vehicle.engineTypeMap.get(v.getEngineType());
            tireSize = v.getTireSize();
        }else if(type==Vehicle.vehicleTypeMapRev.get("Sports")){
            SportsVehicle v = (SportsVehicle) vehicle;
            modelNumber = v.getModelNumber();
            enginePower = v.getEnginePower();
            engineType = Vehicle.engineTypeMap.get(v.getEngineType());
            tireSize = v.getTireSize();
            turbo = (v.isTurbo() ? "Yes" : "No");
        }else if(type==Vehicle.vehicleTypeMapRev.get("Heavy")){
            HeavyVehicle v = (HeavyVehicle) vehicle;
            modelNumber = v.getModelNumber();
            enginePower = v.getEnginePower();
            engineType = Vehicle.engineTypeMap.get(v.getEngineType());
            tireSize = v.getTireSize();
            weight = String.valueOf(v.getWeight());
        }else{
            // err?
        }
        System.out.format("  %3d %15s %20s %15s %10d %10s %10s %10s\n", 
                    serial, vehicleType, modelNumber, engineType, enginePower, tireSize, turbo, weight);
    }
    
    private void showVehicles() {
        /**
         * showVehicles() prints the details of all vehicles of all types
         */
        showVehiclesHeader();
        int i, j, k;
        for(i=0 ; i<listNormalVehicle.size() ; i++){
            NormalVehicle currentVehicle = listNormalVehicle.get(i);
            prettyPrintVehicle(currentVehicle, Vehicle.vehicleTypeMapRev.get("Normal"), i);
        }
        for(j=0 ; j<listSportsVehicle.size() ; j++){
            SportsVehicle currentVehicle = listSportsVehicle.get(j);
            prettyPrintVehicle(currentVehicle, Vehicle.vehicleTypeMapRev.get("Sports"), i+j);
        }
        for(k=0 ; k<listHeavyVehicle.size() ; k++){
            HeavyVehicle currentVehicle = listHeavyVehicle.get(k);
            prettyPrintVehicle(currentVehicle, Vehicle.vehicleTypeMapRev.get("Heavy"), i+j+k);
        }
        
        System.out.println("\n");
    }


    // the prompts for descriptions of vehicles while adding new ones
    private String promptModelNumber(){
        System.out.println("\n* Enter the Model Number:");
        return (String)getOption("string");
    }
    private int promptEnginePower(){
        System.out.println("\n* Enter Engine Power (in HP):");
        return (int)getOption("int");
    }
    private String promptTireSize(){
        System.out.println("\n* Enter the code for the tire size:");
        return (String)getOption("string");
    }
    private boolean promptTurbo(){
        System.out.println("\n* Enter if the vehicle is turbo enabled:\n"+
                            "  enter ( 1 ) for yes,\n"+
                            "  enter ( 0 ) for no.");
        return ((int) getOption("int") == 1);
    }
    private double promptWeight(){
        System.out.println("\n* Enter the weights of the vehicle (in kg):");
        return (double)getOption("double");
    }
    private int promptEngineType(){
        System.out.println("\n* What is the Engine type?\n"+
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
         * Gets information from user and creates a normal vehicle
         * needed info: model no, engine type, engine power, tire size
         */
        String modelNumber = promptModelNumber();
        int engineType = promptEngineType();
        if(engineType!=1 && engineType!=2 && engineType!=3){
            System.out.println("\n>> Please enter a valid option!\n");
            addNormalVehicle();
            return;
        }
        int enginePower = promptEnginePower();
        String tireSize = promptTireSize();
        
        NormalVehicle newNormalVehicle = new NormalVehicle(modelNumber, engineType, enginePower, tireSize);
        listNormalVehicle.add(newNormalVehicle); 
        confirmAdded();
    }



    protected void addSportsVehicle(){
        /**
         * Gets information from user and creates a sport vehicle
         * useful info: model no, engine power, tire size, turbo
         */
        String modelNumber = promptModelNumber();
        int enginePower = promptEnginePower();
        String tireSize = promptTireSize();
        boolean turbo = promptTurbo();

        SportsVehicle newSportsVehicle = new SportsVehicle(modelNumber, enginePower, tireSize, turbo);
        listSportsVehicle.add(newSportsVehicle);
        nVisitors+=nVisitorsForSports;
        confirmAdded();
    }

    protected void addHeavyVehicle(){
        /**
         * Gets information from user and creates a heavy vehicle
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