public class Process {
    protected int pid;
    protected int arrivalTime;
    protected int burstTime;
    protected int remainBT;
    protected int completionTime;// the clock time it got completed
    protected int turnAT; //turnaround time(completion time - burstTime)
    protected int waitingTime; //turnaround time - burst time
    protected int responseTime;
    protected int throughPut;


    public Process(int pid,int arrivalTime, int burstTime){
        this.pid = pid;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        remainBT = burstTime;
        responseTime = -1;

    }
    public void setArrivalTIme(int arrivalTime){
        this.arrivalTime = arrivalTime;
    }
    public int getArrivalTime() {
        return arrivalTime;
    }
    public void setBurstTime(int burstTime){this.burstTime = burstTime;}
    public int getBurstTime(){return burstTime;}
    public void setPid(int pid){
        this.pid = pid;
    }
    public int getPid(){
        return pid;
    }
    public void decrementBT(){
        remainBT--;
    }
    public int getRemainBT(){
        return remainBT;
    }
    public void setCompletionTime(int time){
        completionTime = time;
    }
    public int getCompletionTime(){
        return completionTime;
    }
    public void calcTAT(){ //calculates the turnaround time
        turnAT = completionTime - arrivalTime;
    }
    public int getTurnAT(){
        return turnAT;
    }
    public void calcWaitingTime(){// calculates the waiting time
        waitingTime = turnAT - burstTime;
    }
    public int getWaitingTime(){
        return waitingTime;
    }
    public void setResponseTime(int currTime){
        responseTime = currTime - arrivalTime;
    }
    public int getResponseTime(){
        return responseTime;

    }

}
