import java.util.*;

public class temp {
    public static void main(String[] args){
        Runner runner = new Runner();
        runner.run();
    }
}

class Runner{
    protected ArrayList<NormalVehicle> listNormalVehicle;
    protected ArrayList<Vehicle> listVehicle;

    Runner(){

    }

    protected void run(){
        listNormalVehicle = new ArrayList<>();
        NormalVehicle newNormalVehicle = new NormalVehicle(123, 1, 144, "hhhe2");
        listNormalVehicle.add(newNormalVehicle);
        // Vehicle v = new Vehicle();
        // listVehicle.add(v);
        
        System.out.println("success -  " + newNormalVehicle.tireSize);
    }
}