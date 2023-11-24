# Round-Robin-Scheduling
## CPU Scheduling
CPU scheduling is done to help maximize CPU utilization. The CPU scheduler selects from numerous processes that are in the ready queue and allocates CPU to one of them. Scheduling has criteria to evaluate its algorithm which are CPU utilization, throughput, turnaround time, waiting time, and response time. The selection for which process gets chosen is based on the algorithm for example first come first serve does all processes until completion based on who arrived first. 
## Round Robin 
Round Robin is one of the CPU scheduling algorithms, it uses something called a time quantum which is chosen before the first process enters, each process is given a CPU for the length of the time quantum, so it follows a first come first serve for the order of processes that enter, if a process still has burst time remaining after the time quantum is up it will go to the back of the queue and context switches to the next process in the queue. 

My program is a simulation of a round-robin algorithm. In the program, you enter a file with processes along with its arrival time and burst time. You also enter the time quantum you will have throughout the round-robin algorithm and you will be able to see how the processes take turns having the CPU, in the end, you will be able to see the completion time, turnaround time, waiting time for each process, the clock and the average turnaround time and waiting time for the whole file. You can also see how much of the CPU was utilized with this program.

To get the program to work you run the program and enter the fileName or enter the default “processes.csv” and then enter the time quantum you want for the process. 

Time Quantum: 3

![Alt text](image-1.png)
![Alt text](image.png)

TIME QUANTUM: 6 

![Alt text](image-2.png)
![Alt text](image-3.png)

TIME QUANTUM: 5

![Alt text](image-4.png)
![Alt text](image-5.png)

TIME QUANTUM: 8 

![Alt text](image-6.png)
![Alt text](image-7.png)

TIME QUANTUM: 10

![Alt text](image-8.png)
![Alt text](image-9.png)


