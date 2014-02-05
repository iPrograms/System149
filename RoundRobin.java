import java.util.ArrayList;
import java.util.PriorityQueue;

/*********************************************************************
 * Simulates Shortest Job First Process Scheduling Algorithm
 * @author Manzoor Ahmed
 * @author Igor Sorokin
 * 
 * ******************************************************************/
 
public class RoundRobin {

    int averageWaitTime = 0;
    int averageTurnaroundTime = 0;
    int averageResponseTime = 0;
    int throughput = 0;

    public void simulate(ArrayList<Process> l) {

        int[] waitTime = new int[l.size() - 1];
        int[] turnAroundTime = new int[l.size() - 1];
        int timer = 0;
        boolean flag = true;

        for (int i = 0; i < l.size() - 1; i++) {
            Process p = l.get(i);
            char name = p.name;
            int arrivalTime = p.arrivalTime;
            int currentBurstTime = p.burstTime;

            System.out.println(name + " Arrival: " + arrivalTime + " Burst: " + currentBurstTime);

            //if done running
            if (p.burstTime == 0) {

                l.remove(i);

                waitTime[i] = timer - arrivalTime;
                timer++;
                continue;
            } else {
                //still has more bursts
                p.burstTime--;
                l.remove(i);        //remove from the list
                l.add(p);           // add at the end of list
                timer++;

                if (timer >= 100 && flag) {
                    throughput = i + 1;
                    flag = false;
                }
            }
        }
    }
}
