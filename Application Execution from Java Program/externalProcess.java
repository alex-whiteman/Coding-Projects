import java.io.IOException;
import java.util.Scanner;

public class externalProcess {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        String userCommand;
        String currentCommand;
        //this loop creates an infinite loop that stops when "exit" is typed
        //otherwise, this section takes a string from the user
        //in the form of a file path in order to run any program installed in
        //the computer.
        while(true){
            //gather user input
            System.out.println("Please enter a command: (type \"exit\" to exit)");
            userCommand = input.nextLine();
            //if user input equals "exit", end process and close scanner
            if (userCommand.equals("exit")==true){
                input.close();
                break;
            }           
            else{
                //set the user input to the variable currentCommand
                currentCommand = userCommand;
                //try to run the path given by the user. If the path is valid
                //(meaning there is a program that exists at the given path),
                //run that program. Otherwise, throw an exception stating the
                //file path does not exist or is not an executable file.
                try{    
                    Runtime newCommand = Runtime.getRuntime();
                    Process command = newCommand.exec(currentCommand);
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }   
    }
}
