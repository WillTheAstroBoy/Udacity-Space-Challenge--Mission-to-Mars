public class U1 extends Rocket {

    U1(){
        this.cost = 100;
        this.rocketWeight = 10000;
        this.cargoLimit = 8000;
        this.maxWeight =  cargoLimit +rocketWeight;
        this.cargoCarried = 0;
    }
    public boolean launch(){
        double random = (Math.random()*100);
        double probability = 5*(cargoCarried/cargoLimit);
        if (random>=probability){
            return true;
        }
        else{
            return  false;
        }
    }
    public  boolean land(){
        double random = Math.random()*100;
        double probability = 1*(cargoCarried/cargoLimit);
        if (random>=probability){
            return true;
        }
        else{
            return false;
        }
    }

}
