public class U2 extends  Rocket {

        U2(){
            this.rocketWeight = 18000;
            this.cargoLimit = 11000;
            this.maxWeight = rocketWeight+cargoLimit;
            this.cargoCarried = 0;
            this.cost = 120;
        }
        public boolean launch(){
            double random = Math.random()*100;
            double probability = 4*(cargoCarried/cargoLimit);
            if (random>=probability){
                return true;
            }
            else{
                return false;
            }
        }
        public boolean land(){
            double random = Math.random()*100;
            double probability = 8*(cargoCarried/cargoLimit);
            if (random>= probability){
                return  true;
            }
            else{
                return false;
            }
        }
}
