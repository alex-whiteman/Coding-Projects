import java.util.ArrayList;
import java.util.Scanner;

public class CPU_Scheduler {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        int p_num;
        int p_burst;
        int p_priority;
        String question;
        boolean check;
        ArrayList<Processes> processList = new ArrayList(); 
        ArrayList<Processes> processList2 = new ArrayList(); 
        ArrayList<Processes> processList3 = new ArrayList(); 
        ArrayList<Processes> processList4 = new ArrayList(); 
       
        check = true;
        //this section grabs input from the user to create process objects
        while (check == true){
            System.out.println("Please enter a process number");
            p_num = input.nextInt();
            System.out.println("Please enter the burst time");
            p_burst = input.nextInt();
            System.out.println("Please enter the priority number");
            p_priority = input.nextInt();
            processList.add(new Processes(p_num,p_burst,p_priority));
            System.out.println("Would you like to enter another process? (enter 'yes' or 'no')");
            question = input.next();
            if (question.equalsIgnoreCase("no")){
                check = false;
            }
        }
        input.close();

        //creates different lists for each test
        for(int i=0;i<processList.size();i++){
            processList2.add(new Processes(processList.get(i).getProcessNum(),processList.get(i).getBurst(),processList.get(i).getPriority()));
            processList3.add(new Processes(processList.get(i).getProcessNum(),processList.get(i).getBurst(),processList.get(i).getPriority()));
            processList4.add(new Processes(processList.get(i).getProcessNum(),processList.get(i).getBurst(),processList.get(i).getPriority()));
        }


        //displays input
        for(int i=0;i<processList.size();i++){
            System.out.println("Process ID: "+processList.get(i).getProcessNum()+"  "+"Burst Time: "+processList.get(i).getBurst()+"  "+"Priority: "+processList.get(i).getPriority()+"  ");
        }

        //runs the FCFS process scheduler
        FCFS test1 = new FCFS(processList);
        test1.runScheduler();

        //runs the SJF scheculer
        SJF test2 = new SJF(processList2);
        test2.runScheduler();

        //runs the NPP scheduler
        NPP test3 = new NPP(processList3);
        test3.runScheduler();

        //runs the round robin scheduler
        RR test4 = new RR(processList4);
        test4.runScheduler();
    }
}