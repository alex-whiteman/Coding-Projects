import java.util.ArrayList;

public class FCFS {
    private int turnaround;
    private ArrayList<Processes> p = new ArrayList();
    public FCFS(ArrayList<Processes> processList) {
        p=processList;
    }
    
    public void runScheduler() {
        System.out.println("\nFirst Come First Serve Scheduler:");
        for(int i=0;i<p.size();i++){
            turnaround = turnaround + p.get(i).getBurst();
            System.out.println("Process ID: "+p.get(i).getProcessNum()+"    "+"Turnaround time: "+turnaround);
        }
    }
   
}
