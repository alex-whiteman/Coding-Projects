public class Processes {
    private int pnumber;
    private int pburst;
    private int ppriority;

    //this class is responsible for creating process objects so they can be processed
    //among the various cpu scheduling classes
    public Processes(int number, int burst, int priority){
        pnumber = number;
        pburst = burst;
        ppriority = priority;
    }

    //get methods for processes class
    public int getProcessNum(){
        return pnumber;
    }
    public int getBurst(){
        return pburst;
    }
    public int getPriority(){
        return ppriority;
    }
    
    //set methods for processes class
    public void setProcessNum(int num){
        pnumber = num;
    }
    public void setBurst(int burst){
        pburst = burst;
    }
    public void setPriority(int priority){
        ppriority = priority;
    }
    public void subBurst(int amount){
        pburst = pburst-amount;
    }
}
