import java.io.FileReader;
import java.util.*;

public class ProcessCreator {
    private String fileName;
    private int timeQuantum;
    private HashMap<Integer, ArrayList<Process>> processTable = new HashMap<Integer, ArrayList<Process>>();
    //why do i need a arraylist?
    public ProcessCreator(String fileName){
        //I will read from file create proccesses and store in the table
        FileReader reader = null;
        String[] tmp;
        try{
            reader = new FileReader("./"+fileName);

        }catch (Exception e){
            System.out.println("File not found");
        }
        Scanner keyboard = new Scanner(reader);
        keyboard.nextLine(); //skips the first line with the title for each column
        do{
            tmp = keyboard.nextLine().split(",");

            int pid = Integer.parseInt(tmp[0]);
            int arrivalTime = Integer.parseInt(tmp[1]);
            int burstTime = Integer.parseInt(tmp[2]);

            if (!processTable.containsKey(arrivalTime)) { //if a process with the same arrival time exist
                processTable.put(arrivalTime, new ArrayList<Process>());
            }
            processTable.get(arrivalTime).add(new Process(pid, arrivalTime, burstTime));
        }while(keyboard.hasNextLine());
    }

    public LinkedList fillQueue(){
        LinkedList<Process> queue = new LinkedList<Process>();
        ArrayList<Process> finishedProcess = new ArrayList<>();
        for(ArrayList<Process> plist: processTable.values()){
            for(Process p: plist){

                queue.add(p);
            }
        }
        return queue;

    }

}
