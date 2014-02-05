import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

/***************************************************************************
 * Simulation of Highest Priority First Pre-emptive Process Scheduling Algorithm
 * @author Manzoor Ahmed
 * @author Igor Sorokin
 * @author Islam Ashfaq
 ************************************************************************/
 
public class HighestPriorityFirstPreemptive
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
        	int currentArrivalTime = p.arrivalTime;
        	int currentBurstTime = p.burstTime;
        	int currentPriority = p.priority;
        	System.out.println(name + " Priority: " + currentPriority + " Arrival: " + currentArrivalTime + " Burst: " + currentBurstTime);
        	
        	Process n = l.get(i+1);
        	char nextName = n.name;
        	int nextArrivalTime = n.arrivalTime;
        	int nextBurstTime = n.burstTime;
        	int nextPriority = n.priority;
        	System.out.println(nextName +" Priority: " + nextPriority + " Arrival: " + nextArrivalTime + " Burst: " + nextBurstTime + "\n");
        		
        	if (currentPriority < nextPriority && i+1 < l.size()-1)
    		{
        		waitTime[i] = timer - currentArrivalTime;
        		//Swaps Them
        		l.add(i, n);//top
        		l.remove(i+2);//removes old next
        			
        		Process nn = l.get(i+2);
        		int nextnextArrivalTime = nn.arrivalTime;
            	int nextnextBurstTime = nn.burstTime;
            	if ((nextBurstTime - (nextnextArrivalTime - nextArrivalTime)) > nextnextArrivalTime)
            	{
            		l.add(i+1, n);//second
            		l.add(i+2, p);//third
            	}
            	else
            	{
                	timer += nextBurstTime; 
            	}
        	}
        	else
        	{
        		//if arrivalTime hasn't come yet, waitTime is zero EX: P1(1a,1b) P2(3a,3b) P2.waitTime = 0 
        		if ((timer - currentArrivalTime) <= 0) waitTime[i] = 0; 
        		else waitTime[i] = timer - currentArrivalTime; //waitTime is how long since arrivalTime
        	
        		if (currentArrivalTime > timer) timer = currentArrivalTime + currentBurstTime; //timer skips forward to next arrivalTime
        		else timer += currentBurstTime; //timer skips forward to after currentBurstTime
        	
        		turnAroundTime[i] = waitTime[i]+currentBurstTime;
        	}
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
