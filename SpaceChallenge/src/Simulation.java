import java.util.ArrayList;
import  java.util.Scanner;
import  java.io.File;

public class Simulation {

    public ArrayList<Item> loadItems(File file) throws  Exception{

        Scanner scanner = new Scanner(file);
        ArrayList<Item> item = new ArrayList<Item>();
        while (scanner.hasNextLine()){
            Item item1 = new Item();
            String [] stringArray;
            stringArray =  scanner.nextLine().split("=");
            item1.name = stringArray[0];
            item1.weight =  Integer.parseInt(stringArray[1]);
            item.add(item1);
        }
        return  item;
    }

    public ArrayList<Rocket> loadU1(ArrayList<Item> item){
        ArrayList<Rocket> u1 = new ArrayList<>();
        int j=0; // keeps the count of item which are loaded into the u1 rocket
        while(j!=item.size()){
            Rocket u1Rocket = new U1();
            for (int i=j; i<item.size(); i++){
                if (u1Rocket.canCarry(item.get(i))){
                    u1Rocket.carry(item.get(i));
                    j++;
                    //System.out.println(u1Rocket.cargoCarried);
                }
                /* There is a big catch this method doesn't fill the rocket to their full potential
               but as long as canCarry return true then it adds the u1Rocket to arraylist of u1 rockets
                else if (u1Rocket.cargoCarried == u1Rocket.cargoLimit || i == item.size()-1){
               */
                else{
                    //u1.add(u1Rocket);
                    break;
                }
            } u1.add(u1Rocket);
        }
        return  u1;
    }
    public ArrayList<Rocket> loadU2(ArrayList<Item> item){
        ArrayList<Rocket> u2 = new ArrayList<>();
        int j=0;
        while(j!=item.size()){
            Rocket u2Rocket = new U2();
            for (int i=j; i<item.size(); i++){
                if (u2Rocket.canCarry(item.get(i))){
                    u2Rocket.carry(item.get(i));
                    j++;
                } else{
                   // u2.add(u2Rocket);
                    break;
                }
            }u2.add(u2Rocket);
        }
        return u2;
    }
    public double runSimulation( ArrayList<Rocket> rocket){
        double totalBudget = 0;
        for (int i=0; i<rocket.size(); i++){
            if (rocket.get(i).launch()){
                if (rocket.get(i).land()){
                    totalBudget += rocket.get(i).cost;
                }else{
                    totalBudget+= rocket.get(i).cost;
                    if (rocket.get(i).launch()){
                        if (rocket.get(i).land()){
                            totalBudget += rocket.get(i).cost;
                        }
                    }
                }
            }else{
                totalBudget += rocket.get(i).cost;
                if (rocket.get(i).launch()){
                    if (rocket.get(i).land()){
                        totalBudget += rocket.get(i).cost;
                    }
                }
            }
        }
        return totalBudget;
    }
}
