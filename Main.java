import java.util.ArrayList;

/*********************************************************************
 * Runs all simulations 
 * @author Manzoor Ahmed
 * 
 * ******************************************************************/

public class Main
{
	public static void main(String[] args)
	{
		int runs = 5;
		int processCount = 20;
		int simulationRuns = 5;
	
		int averageWaitTime = 0;
		int averageTurnaroundTime = 0;
		int averageResponseTime = 0;
		int averageThroughput = 0;
		System.out.println("First Come First Serve\n");
        for (int i = 0; i < simulationRuns; i++)
        {
        	System.out.println("Run: " + (i+1));
        	ProcessFactory ph = new ProcessFactory();
        	ph.generateProcesses(processCount);
        	ArrayList<Process> arrivalList = ph.arrivalSort();
        	FirstComeFirstServed fcfs = new FirstComeFirstServed(); 
            fcfs.simulate(arrivalList);
            averageWaitTime += fcfs.averageWaitTime;
            averageTurnaroundTime += fcfs.averageTurnaroundTime;
            averageResponseTime += fcfs.averageResponseTime;
            averageThroughput += fcfs.throughput;
        }
		
        averageWaitTime /= simulationRuns;
        averageTurnaroundTime /= simulationRuns;
        averageResponseTime /= simulationRuns;
        averageThroughput /= simulationRuns;
        System.out.println("Average WaitTime for " + simulationRuns + " runs : " + averageWaitTime);
        System.out.println("Average TurnaroundTime for " + simulationRuns + " runs : " + averageTurnaroundTime);
        System.out.println("Average ResponseTime for " + simulationRuns + " runs : " + averageResponseTime);
        System.out.println("Average Throughput for " + simulationRuns + " runs : " + averageThroughput + "\n");
        
        System.out.println("-----------------------------------------------------------------------------------");
        
        averageWaitTime = 0;
		averageTurnaroundTime = 0;
		averageResponseTime = 0;
		averageThroughput = 0;
		System.out.println("Shortest Job First\n");
        
		for (int i = 0; i < simulationRuns; i++)
        {
        	System.out.println("Run: " + (i+1));
        	ProcessFactory ph = new ProcessFactory();
        	ph.generateProcesses(processCount);
        	ArrayList<Process> burstList = ph.burstSort();
        	FirstComeFirstServed fcfs = new FirstComeFirstServed(); 
            fcfs.simulate(burstList);
            averageWaitTime += fcfs.averageWaitTime;
            averageTurnaroundTime += fcfs.averageTurnaroundTime;
            averageResponseTime += fcfs.averageResponseTime;
            averageThroughput += fcfs.throughput;
        }
		
        averageWaitTime /= simulationRuns;
        averageTurnaroundTime /= simulationRuns;
        averageResponseTime /= simulationRuns;
        averageThroughput /= simulationRuns;
        System.out.println("Average WaitTime for " + simulationRuns + " runs : " + averageWaitTime);
        System.out.println("Average TurnaroundTime for " + simulationRuns + " runs : " + averageTurnaroundTime);
        System.out.println("Average ResponseTime for " + simulationRuns + " runs : " + averageResponseTime);
        System.out.println("Average Throughput for " + simulationRuns + " runs : " + averageThroughput);
        
        System.out.println("-----------------------------------------------------------------------------------");
        
        averageWaitTime = 0;
		averageTurnaroundTime = 0;
		averageResponseTime = 0;
		averageThroughput = 0;
		System.out.println("Highest Priority First Nonpreemptive\n");
        
		for (int i = 0; i < simulationRuns; i++)
        {
        	System.out.println("Run: " + (i+1));
        	ProcessFactory ph = new ProcessFactory();
        	ph.generateProcesses(processCount);
        	ArrayList<Process> priorityList = ph.prioritySort();
        	HighestPriorityFirstNonPreemptive hpfnp = new HighestPriorityFirstNonPreemptive(); 
        	hpfnp.simulate(priorityList);
            averageWaitTime += hpfnp.averageWaitTime;
            averageTurnaroundTime += hpfnp.averageTurnaroundTime;
            averageResponseTime += hpfnp.averageResponseTime;
            averageThroughput += hpfnp.throughput;
        }
		
        averageWaitTime /= simulationRuns;
        averageTurnaroundTime /= simulationRuns;
        averageResponseTime /= simulationRuns;
        averageThroughput /= simulationRuns;
        System.out.println("Average WaitTime for " + simulationRuns + " runs : " + averageWaitTime);
        System.out.println("Average TurnaroundTime for " + simulationRuns + " runs : " + averageTurnaroundTime);
        System.out.println("Average ResponseTime for " + simulationRuns + " runs : " + averageResponseTime);
        System.out.println("Average Throughput for " + simulationRuns + " runs : " + averageThroughput);
        
        System.out.println("-----------------------------------------------------------------------------------");
        
        averageWaitTime = 0;
		averageTurnaroundTime = 0;
		averageResponseTime = 0;
		averageThroughput = 0;
		System.out.println("Highest Priority First Preemptive\n");
		
        for (int i = 0; i < simulationRuns; i++)
        {
        	System.out.println("Run: " + (i+1));
        	ProcessFactory ph = new ProcessFactory();
        	ph.generateProcesses(processCount);
        	ArrayList<Process> arrivalList = ph.arrivalSort();
        	HighestPriorityFirstPreemptive hpfp = new HighestPriorityFirstPreemptive(); 
        	hpfp.simulate(arrivalList);
            averageWaitTime += hpfp.averageWaitTime;
            averageTurnaroundTime += hpfp.averageTurnaroundTime;
            averageResponseTime += hpfp.averageResponseTime;
            averageThroughput += hpfp.throughput;
        }
		
        averageWaitTime /= simulationRuns;
        averageTurnaroundTime /= simulationRuns;
        averageResponseTime /= simulationRuns;
        averageThroughput /= simulationRuns;
        System.out.println("Average WaitTime for " + simulationRuns + " runs : " + averageWaitTime);
        System.out.println("Average TurnaroundTime for " + simulationRuns + " runs : " + averageTurnaroundTime);
        System.out.println("Average ResponseTime for " + simulationRuns + " runs : " + averageResponseTime);
        System.out.println("Average Throughput for " + simulationRuns + " runs : " + averageThroughput);
	}
}
