import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;

/*********************************************************************
 * Generate Process with random names 
 * @author Manzoor Ahmed
 * @author Igor Sorokin
 * ******************************************************************/


public class ProcessFactory
{
	ArrayList<Process> l = new ArrayList<Process>();
	String names = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	Random randNum = new Random();
	
	ArrayList<Process> generateProcesses(int processCount)
	{
		for (int i = 0; i <= processCount; i++)
		{
			Process p = new Process();
			p.setName(names.charAt(i));
			p.setPriority(randNum.nextInt(4)+1); 	 //1-4
			p.setArrivalTime(randNum.nextInt(99)+1); //1-100
			p.setBurstTime(randNum.nextInt(10)+1);   //1-10
			p.setStartTime(randNum.nextInt(99)+1);   //1-100
			l.add(p);
		}
		return l;
	}
	
	ArrayList<Process> prioritySort()
	{
		Object[] qObj = l.toArray();
		
		Arrays.sort(qObj, 0, l.size()-1, 
			new Comparator()
			{
				public int compare(Object p1, Object p2)
				{
					if (((Process)p1).priority < ((Process)p2).priority) return -1;
					else 
						if (((Process)p1).priority == ((Process)p2).priority) return 0;
						else return 1;
				}
			});
		return new ArrayList(Arrays.asList(qObj));
	}
	
	ArrayList<Process> arrivalSort()
	{
		Object[] qObj = l.toArray();
		
		Arrays.sort(qObj, 0, l.size(), 
			new Comparator()
			{
				public int compare(Object p1, Object p2)
				{
					if (((Process)p1).arrivalTime < ((Process)p2).arrivalTime) return -1;
					else 
						if (((Process)p1).arrivalTime == ((Process)p2).arrivalTime) return 0;
						else return 1;
				}
			});
		return new ArrayList(Arrays.asList(qObj));
	}
	
	ArrayList<Process> burstSort()
	{
		Object[] qObj = l.toArray();
		
		Arrays.sort(qObj, 0, l.size()-1, 
			new Comparator()
			{
				public int compare(Object p1, Object p2)
				{
					if (((Process)p1).burstTime < ((Process)p2).burstTime) return -1;
					else 
						if (((Process)p1).burstTime == ((Process)p2).burstTime) return 0;
						else return 1;
				}
			});
		return new ArrayList(Arrays.asList(qObj));
	}
	
	ArrayList<Process> startSort()
	{
		Object[] qObj = l.toArray();
		
		Arrays.sort(qObj, 0, l.size()-1, 
			new Comparator()
			{
				public int compare(Object p1, Object p2)
				{
					if (((Process)p1).startTime < ((Process)p2).startTime) return -1;
					else 
						if (((Process)p1).startTime == ((Process)p2).startTime) return 0;
						else return 1;
				}
			});
		return new ArrayList(Arrays.asList(qObj));
	}
}
