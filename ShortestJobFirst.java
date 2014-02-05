
import java.util.ArrayList;
import java.util.Arrays;


/********************************************************
 * Simulates Shortest Job First Process Scheduling Algorithm
 * @author Manzoor Ahmed
 * @author Igor Sorokin
 * CS 149
 ***********************************************************/

public class ShortestJobFirst 
{
	int averageWaitTime = 0;
	int averageTurnaroundTime = 0;
	int averageResponseTime = 0;
	int throughput = 0;
	
	void simulate(ArrayList<Process> l) 
    { 
		int[] waitTime = new int[l.size()-1];
        int[] turnAroundTime = new int[l.size()-1];
        int timer = l.get(0).arrivalTime;
        boolean flag = true;
        
        for (int i = 0; i < l.size()-1; i++) 
        {
        	Process p = l.get(i);
        	char name = p.name;
        	int arrivalTime = p.arrivalTime;
        	int burstTime = p.burstTime;
        	System.out.println(name + " Arrival: " + arrivalTime + " Burst: " + burstTime);
        	
        	if ((timer - arrivalTime) <= 0) waitTime[i] = 0; 
        	else waitTime[i] = timer - arrivalTime; 
        	if (arrivalTime > timer) timer = arrivalTime + burstTime; 
        	else timer += burstTime; 
        	
        	turnAroundTime[i] = waitTime[i]+burstTime;
        	
        	if (timer >= 100 && flag) {throughput = i+1; flag = false;}
        }
		
		if (throughput == 0) throughput = l.size()-1;
        System.out.println("WaitTimes: " + Arrays.toString(waitTime));
        for (int w : waitTime) averageWaitTime += w;
        averageWaitTime /= l.size()-1;
        averageResponseTime = averageWaitTime;
        System.out.println("Average WaitTime: " + averageWaitTime);
        System.out.println("TurnaroundTimes: " + Arrays.toString(turnAroundTime));
        for (int t : turnAroundTime) averageTurnaroundTime += t;
        averageTurnaroundTime /= l.size()-1;
        System.out.println("Average TurnaroundTimes: " + averageTurnaroundTime);
        System.out.println("Throughput: " + throughput + "\n");
    }
}
