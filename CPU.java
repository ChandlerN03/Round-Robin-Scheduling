import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class CPU {
    protected static LinkedList<Process> queue = new LinkedList<>();
    protected static ArrayList<Process> finishedProcesses = new ArrayList<Process>();

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);


        //FIX THIS
        System.out.println("fileName");
        //String filename = keyboard.next();
        System.out.println("time Quantum");
        int timeQuantum = 3;
        ProcessCreator p1 = new ProcessCreator("processes.csv");

        queue = p1.fillQueue();
        int clock = 0;
        int switchCount = 0;
        int switchTime = 2;
        int idleTime = 0;
        int cpuUtil;
        System.out.println("<----------- Process Execution --------->\n");
        while(!queue.isEmpty()){
            Process curr = queue.pop(); //pop will give the process
            //info
            System.out.println(" Time: "+clock+"\n PID: "+curr.getPid()+"\n Arrival Time: "+
                    curr.arrivalTime+"\n Current Burst time: "+curr.getRemainBT());
            int timer = timeQuantum;
            while(timer > 0 && (curr.getRemainBT() > 0)){
                if(curr.getResponseTime() == -1){
                    curr.setResponseTime(clock);
                }
                curr.decrementBT();
                    clock++;
                    timer--;
                }
            if(!queue.isEmpty() && (queue.peek().getArrivalTime() > clock) ){
                while((timer > 0 && (curr.getRemainBT() > 0))){
                    curr.decrementBT();
                    clock++;
                    timer--;
                }
            }
            if(!queue.isEmpty()){
                idleTime += switchTime;
                clock += switchTime;
                switchCount++;

            }

            if(curr.getRemainBT() > 0){
                System.out.println(" remaining burst time: "+curr.getRemainBT());
                queue.add(curr);
            }
            else{ //the process has been completed
                finishedProcesses.add(curr);
                curr.setCompletionTime(clock);
                curr.calcTAT();
                curr.calcWaitingTime();
                System.out.println(" Response time: "+curr.getResponseTime());
                System.out.println(" Process "+curr.getPid()+" completed at "+ curr.getCompletionTime()+"ms");
            }
            System.out.println();
        }
        int totalWaitTime = 0;
        int totalTAT = 0;
        for(int i = 0; i < finishedProcesses.size();i++){
            totalWaitTime += finishedProcesses.get(i).getWaitingTime();
            totalTAT += finishedProcesses.get(i).getTurnAT();
        }
        cpuUtil = (int)Math.round((1 - ((double)idleTime/clock))* 100);
        double avgWaitTime = (double)totalWaitTime/ finishedProcesses.size();
        double avgTurnaroundTime = (double)totalTAT / finishedProcesses.size();

        System.out.println("<-----------Process Info----------->");
        for(int i = 0; i < finishedProcesses.size();i++){
            System.out.println(" PID: "+finishedProcesses.get(i).getPid());
            System.out.println(" Arrival Time: "+finishedProcesses.get(i).getArrivalTime()+"ms");
            System.out.println(" Burst Time: "+finishedProcesses.get(i).getBurstTime()+"ms");
            System.out.println(" Completion Time: "+finishedProcesses.get(i).getCompletionTime()+"ms");
            System.out.println(" Turnaround Time: "+finishedProcesses.get(i).getTurnAT()+"ms");
            System.out.println(" Waiting Time: "+finishedProcesses.get(i).getWaitingTime()+"ms");
            System.out.println(" Response TIme: "+finishedProcesses.get(i).getResponseTime()+"ms\n");

        }
        System.out.println("<-----------Overall Info----------->");
        System.out.println(" Time Quantum: "+timeQuantum);
        System.out.println(" CPU Utilization: "+cpuUtil+"%");
        System.out.println(" Total Time: "+clock+"ms");
        System.out.println(" Idle Time: "+idleTime+"ms");
        System.out.println(" Context Switch Count: "+switchCount);
        System.out.printf(" Average Wait Time: %.2f ms \n",avgWaitTime);
        System.out.printf(" Average Turnaround Time: %.2f ms \n",avgTurnaroundTime);
    }
}
