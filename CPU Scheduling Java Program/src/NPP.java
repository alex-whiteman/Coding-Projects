import java.util.ArrayList;

public class NPP {

    private int turnaround;
    private ArrayList<Processes> temp = new ArrayList();
    private ArrayList<Processes> temp2 = new ArrayList();
    private ArrayList<Processes> p = new ArrayList();
    
    public NPP(ArrayList<Processes> processList) {
        p=processList;
    }

    public void runScheduler() {
        System.out.println("\nNon-Preemptive Priority Scheduler:");
        //sort the list based on priority
        int pos;
        for (int i=0;i<p.size();i++){ 
            pos = i; 
            for (int j=i+1;j<p.size();j++){
                if (p.get(j).getPriority() > p.get(pos).getPriority()){
                    pos = j;
                }
            }
            temp.add(p.get(pos));
            p.set(pos, p.get(i));
            p.set(i, temp.get(i));   
        }

        //sort priority brackets based on their burst sizes
        for (int i=0;i<p.size();i++){ 
            pos = i; 
            for (int j=i+1; j<p.size(); j++){
                if(p.get(j).getPriority() == p.get(pos).getPriority()){
                    if (p.get(j).getBurst() < p.get(pos).getBurst()){
                        pos = j;
                    }
                }
            }
            temp2.add(p.get(pos));
            p.set(pos, p.get(i));
            p.set(i, temp2.get(i));   
        }

        //output the calculation results
        for(int i=0;i<p.size();i++){
            turnaround = turnaround + p.get(i).getBurst();
            System.out.println("Process ID: "+p.get(i).getProcessNum()+"    "+"Turnaround time: "+turnaround);
        }
    }
}
