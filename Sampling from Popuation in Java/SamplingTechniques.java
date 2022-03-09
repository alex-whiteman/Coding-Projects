import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
public class SamplingTechniques {     
    public static void main(String[] args){

        //create a list to store Numbers.txt as a usable datatype
        ArrayList<Double> numberList = new ArrayList<Double>();
        try{
            File numberFile = new File("Numbers.txt");
            Scanner scan = new Scanner(numberFile);
            while(scan.hasNextLine()){
                numberList.add(scan.nextDouble());
            }
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
        
        //calls to various methods of sampling and printing results
        System.out.println("SRS mean (60): "+SamplingTechniques.getSRSMean(numberList,60)+"\n");
        System.out.println("SRS mean (100): "+SamplingTechniques.getSRSMean(numberList,100)+"\n");
        System.out.println("SRS mean (200): "+SamplingTechniques.getSRSMean(numberList,200)+"\n");
        System.out.println("Stratified mean (60): "+SamplingTechniques.getStratifiedMean(numberList,60)+"\n");
        System.out.println("Stratified mean (100): "+SamplingTechniques.getStratifiedMean(numberList,100)+"\n");
        System.out.println("Stratified mean (200): "+SamplingTechniques.getStratifiedMean(numberList,200)+"\n");
        System.out.println("Cluster mean (60): "+SamplingTechniques.getClusterMean(numberList,60)+"\n");
        System.out.println("Cluster mean (100): "+SamplingTechniques.getClusterMean(numberList,100)+"\n");
        System.out.println("Cluster mean (200): "+SamplingTechniques.getClusterMean(numberList,200)+"\n");  
        System.out.println("Systematic mean (60): "+SamplingTechniques.getSystematicMean(numberList,60)+"\n");  
        System.out.println("Systematic mean (100): "+SamplingTechniques.getSystematicMean(numberList,100)+"\n");  
        System.out.println("Systematic mean (200): "+SamplingTechniques.getSystematicMean(numberList,200)+"\n");      

    }

    //get mean method used to simplify code-- simply returns the mean
    //based on sample size for any given arraylist
    public static double getMean(ArrayList<Double> numbers, int sampleSize){
        double total = 0;
        for(int i = 0; i < sampleSize; i++){
            total += numbers.get(i);
        }
        return total / sampleSize;
    }

    //get mean by positon in arrayList. This is used to simplify code in the Cluster sampling method
    public static double getMeanByPosition(ArrayList<Double> numbers, int startPosition, int length){
        double total = 0;
        if (startPosition < 1){
            startPosition = 1;
        }
        for(int i = startPosition-1; i < startPosition+length-1; i++){
            total += numbers.get(i);
        }
        return total / length;
    }

    //Simple random sampling method
    public static double getSRSMean(ArrayList<Double> numbers, int sampleSize){
        //put numbers in random order
        Collections.shuffle(numbers);
        return SamplingTechniques.getMean(numbers, sampleSize);
    }

    //Stratified sampling method
    public static double getStratifiedMean(ArrayList<Double> numbers, int sampleSize){
        
        //create four ArrayLists to store the grouped numbers
        ArrayList<Double> g1 = new ArrayList<Double>();
        ArrayList<Double> g2 = new ArrayList<Double>();
        ArrayList<Double> g3 = new ArrayList<Double>();
        ArrayList<Double> g4 = new ArrayList<Double>();
        
        //sort the numbers based on given constraints
        for(int i=0; i<numbers.size();i++){
            if(numbers.get(i) < 70.0)
                g1.add(numbers.get(i));
            if(numbers.get(i) >= 70.0 && numbers.get(i) < 80.0)
                g2.add(numbers.get(i));
            if(numbers.get(i) >= 80.0 && numbers.get(i) < 90.0)
                g3.add(numbers.get(i));
            if(numbers.get(i) > 90.0)
                g4.add(numbers.get(i));
        }

        //randomize the lists
        Collections.shuffle(g1);
        Collections.shuffle(g2);
        Collections.shuffle(g3);
        Collections.shuffle(g4);
        
        //calculate results and return value
        double result = 0;
        result += SamplingTechniques.getMean(g1,sampleSize/4);
        result += SamplingTechniques.getMean(g2,sampleSize/4);
        result += SamplingTechniques.getMean(g3,sampleSize/4);
        result += SamplingTechniques.getMean(g4,sampleSize/4);
        return result/4;
    }

    //Cluster sampling method
    public static double getClusterMean(ArrayList<Double> numbers, int sampleSize){
        //population of roughly 2000 entries with 20 entries per cluster gives a total of 100 clusters.
        //clusters are grouped in the order in which they are read by the Numbers.txt file.
        //For this method, a random number generator will be used to pick a number between 0 and 99 in order to
        //determine which cluster will be used for the sample population
        
        //numberOfGroups refers to the number of clusters to be randomly selected
        int numberOfGroups = sampleSize/20;
        
        //this next step generates numbers to which random clusters will be selected
        ArrayList<Integer> randomNumbers = new ArrayList<Integer>();
        int temp = 0;
        for(int i = 0;i < numberOfGroups; i++){
            temp = (int)(Math.random()*99);
            //take the random number and multiply by 20 to get position in ArrayList
            temp = temp*20;
            randomNumbers.add(temp);
        }

        //the randomly chosen clusters are now calculated for their individual means and added together
        //the cluster variable in the method call to getMeanByPosition is multiplied by 100 in order
        //to determine the start position for the cluster in the array
        double total = 0;
        for(int clusterStartPosition:randomNumbers){
            total += SamplingTechniques.getMeanByPosition(numbers, clusterStartPosition, 20);
        }
        
        //finally, divide the total of all the cluster means by number of clusters to produce the
        //cluster sample mean.
        return total/numberOfGroups;
    }

    //Systematic sampling
    public static double getSystematicMean(ArrayList<Double> numbers, int sampleSize){
        //determine k value first
        int kValue = Math.round(numbers.size()/sampleSize);
        
        //due to the nature of for loops in java, I opted to shuffle the entire ArrayList in order to determine a random starting position
        //so that an out of bounds exception does not occur.
        Collections.shuffle(numbers);
        
        //after shuffling, I then calculated the mean by taking each k'th value and dividing that value by the sample size
        double total = 0;
        for(int i = 0; i < sampleSize; i++){
            total += numbers.get(i*kValue);
        }
        
        //the division stated in the previous comment takes place here, the product is then returned
        return total/sampleSize;
    }

}