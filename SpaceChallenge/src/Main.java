import java.io.File;
import java.util.ArrayList;

public class Main {
            public static void main(String [] args) throws Exception {
                Simulation simulation = new Simulation();
                File file1 = new File("phase-1.txt");
                ArrayList<Item> item1 = new ArrayList<Item>();
                item1 = simulation.loadItems(file1);
                File file2 = new File("phase-2.txt");
                ArrayList<Item> item2 = new ArrayList<Item>();
                item2 = simulation.loadItems(file2);

                ArrayList<Rocket> u1RocketFleetP1 = simulation.loadU1(item1);
                ArrayList<Rocket> u1RocketFleetP2 = simulation.loadU1(item2);

                double totalBudgetU1Phase1 = simulation.runSimulation(u1RocketFleetP1);
                double totalBudgetU1Phase2 = simulation.runSimulation(u1RocketFleetP2);

                System.out.println("Total budget for phase1 and phase2 via U1 = "+(totalBudgetU1Phase1+totalBudgetU1Phase2));

                ArrayList<Rocket> u2RocketFleetP1 = simulation.loadU2(item1);
                ArrayList<Rocket> u2RocketFleetP2 = simulation.loadU2(item2);

                double totalBudgetU2Phase1 = simulation.runSimulation(u2RocketFleetP1);
                double totalBudgetU2Phase2 = simulation.runSimulation(u2RocketFleetP2);

                System.out.println("Total budget for phase1 and phase2 via U2 Rocket = " +(totalBudgetU2Phase1+totalBudgetU2Phase2));
            }
}
