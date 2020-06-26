public class Rocket implements SpaceShip {
     double rocketWeight;
     double cargoLimit;
     double maxWeight;
     double cargoCarried;
     double cost;

     Rocket(){
         rocketWeight = 0;
         cargoLimit = 0;
         maxWeight = 0;
         cargoCarried = 0;
         cost = 0;
     }

    public boolean launch() {
        return  true;
    }
    public  boolean land(){
        return  true;
    }
    public final void carry(Item item){
        cargoCarried += item.weight;
    }
    public final boolean canCarry(Item item){
         double totalWeight = cargoCarried + item.weight;
         if (totalWeight <= cargoLimit){
             return true;
         }
         else{
             return false;
         }
    }
}
