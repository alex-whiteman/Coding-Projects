import java.util.ArrayList;

public class RR {

    private int turnaround;
    private int count;
    private ArrayList<Processes> process = new ArrayList();

    public RR(ArrayList<Processes> processList) {
        process=processList;
    }

    public void runScheduler() {
        System.out.println("\nRound Robin Scheduler: (Time Quantum = 2)");

        //counts the total of all burst lengths
        for(int i=0;i<process.size();i++){
            count = count+process.get(i).getBurst();
        }

        //loops until all processes have no burst times remaining
        while(turnaround <= count){
            //subtracts each process burst time by 2
            for(int i=0;i<process.size();i++){
                process.get(i).subBurst(2);
            }
            //organize processes by specific burst time values, if burst time 
            //equals 0 or -1, the process has completed. Display corresponding data   
            for(int i=0;i<process.size();i++){
                if(process.get(i).getBurst()==0){
                    turnaround=turnaround+2;
                    System.out.println("Process ID: "+process.get(i).getProcessNum()+"    "+"Turnaround time: "+turnaround);
                }
                else if(process.get(i).getBurst()==-1){
                    turnaround++;
                    System.out.println("Process ID: "+process.get(i).getProcessNum()+"    "+"Turnaround time: "+turnaround);
                }
                else if(process.get(i).getBurst()>0)
                    turnaround=turnaround+2;
                else
                    continue;
            }
            //remove those processes that are completed
            for(int i=0;i<process.size();i++){
                if(process.get(i).getBurst()<=0){
                    process.remove(i);
                }
            }
        }
    }
}
