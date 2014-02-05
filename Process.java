/*********************************************************************
 * Process with given attributes
 * @author Manzoor Ahmed
 * 
 * ******************************************************************/
public class Process implements Comparable
{
	public int compareTo(Object p) {return 0;}
	
	char name;
	int priority;
	int arrivalTime;
	int burstTime;
	int startTime;
        
	char getName() {return this.name;}
	int getPriority() {return this.priority;}
	int getArrivalTime() {return this.arrivalTime;}
	int getBurstTime() {return this.burstTime;}
	int getStartTime() {return this.startTime;}
        
	void setName(char name) {this.name = name;}
	void setPriority(int priority) {this.priority = priority;}
	void setArrivalTime(int arrivalTime) {this.arrivalTime = arrivalTime;}
	void setBurstTime(int burstTime) {this.burstTime = burstTime;}
	void setStartTime(int startTime) {this.startTime = startTime;}
}
