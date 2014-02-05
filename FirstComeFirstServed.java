import java.util.ArrayList;
import java.util.Arrays;

/***********************************************************************
 * Simulation of First Come First Served Process Scheduling Algorithm
 * 
 * @author Manzoor Ahmed
 * @author Igor Sorokin
 * 
 ***********************************************************************/

public class FirstComeFirstServed
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
        	
        	if ((timer - arrivalTime) <= 0) waitTime[i] = 0; //if arrivalTime hasn't come yet, waitTime is zero EX: P1(1a,1b) P2(3a,3b) P2.waitTime = 0 
        	else waitTime[i] = timer - arrivalTime; //waitTime is how long since arrivalTime
        	if (arrivalTime > timer) timer = arrivalTime + burstTime; //timer skips forward to next arrivalTime
        	else timer += burstTime; //timer skips forward to after currentBurstTime
        	
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
