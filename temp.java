import java.util.*;

public class temp {
    public static void main(String[] args){
        // Runner runner = new Runner();
        // runner.run();
        // String str = "Something";
        // String str2 = "Some other thing";
        // int p = 100;
        // System.out.format("%25d %25s\n", p, str2);
        // for(int i=0 ; i<75 ; i++)
        //     System.out.format(".");
        // System.out.format("\n%25s %25s\n", str, str2);
        NormalVehicle nv = new NormalVehicle(12, 2, 2, "werw");
        SportsVehicle nv2 = new SportsVehicle(121, 3, "werw2", true);
        
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