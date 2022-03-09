import java.util.ArrayList;

public class SJF {
    private int turnaround;
    private ArrayList<Processes> temp = new ArrayList();
    private ArrayList<Processes> p = new ArrayList();

    public SJF(ArrayList<Processes> processList) {
        p = processList;
    }

    public void runScheduler() {
        System.out.println("\nShortest Job First Scheduler:");

        //sort the list based on burst size
        int pos;
        for (int i=0;i<p.size();i++){ 
            pos = i; 
            for (int j=i+1;j<p.size();j++){
                if (p.get(j).getBurst() < p.get(pos).getBurst()){
                    pos = j;
                }
            }
            temp.add(p.get(pos));
            p.set(pos, p.get(i));
            p.set(i, temp.get(i));   
        }

        //output calculation results
        for(int i=0;i<p.size();i++){
            turnaround = turnaround + p.get(i).getBurst();
            System.out.println("Process ID: "+p.get(i).getProcessNum()+"    "+"Turnaround time: "+turnaround);
        }
    }

}
