import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MyShell{
    public static void main(String[] args) throws java.io.IOException {
        String commandLine;
        List<String> history = new ArrayList<String>();
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        ProcessBuilder p = new ProcessBuilder();
        //this section sets the current directory to C:\\Users\(your user name here)
        File directory = new File(System.getProperty("user.home"));
        p.directory(directory);
        while (true) {
            List<String> List = new ArrayList<String>();
            List.add("cmd.exe");
            List.add("/C");
            // read what the user enters
            System.out.print("mysh>");
            commandLine = console.readLine();
            history.add(commandLine);
            String[] commands = commandLine.split(" ");
            int size = commands.length;
            // if the user entered a return, just loop again
            if (commandLine.equals(""))
            continue;
            //if the user entered exit, end the program
            else if (commandLine.equalsIgnoreCase("exit")){
				System.out.println("Goodbye");
                break;
			}
            //checks for cd command, based on style of cd command, different
            //implementations are performed
            //if only "cd" is entered, the working directory is printed.
            //otherwise, the process will 
            else if(commandLine.contains("cd")){
                if(commandLine.length()>3){

                    directory = new File(p.directory() + File.separator + commandLine.substring(3));
                    //checks to see if the specified directory is valid.
                    //if the directory is valid, change the directory to the
                    //specified directory, otherwise, display an error message.
                    if (directory.isDirectory()){
                        p.directory(directory);
                        List.add("cd");
                        //adds the additional commands following the cd command that is
                        //inputted from the user
                        for (int i=1; i<size; i++) {
                            List.add(commands[i]);
                        }
                        if(!commandLine.substring(3).equals(".."))
                            System.out.println(p.directory());
                    }
                    else {
                        System.out.println("File/directory does not exist");
                        continue;
                    }
                //the "cd" command is implemented here, which simply prints
                //the current working directory
                }else{
                    List.add("cd");
                }
            }
            //this section is responsible for checking for 'dir', then
            //prints all the files located inside the directory.
            else if(commandLine.equalsIgnoreCase("dir")){
                List.add(commandLine);
            }
            //this section is responsible for checking if there is any history and
            //displaying that history if there is any to show.    
            else if(commandLine.equalsIgnoreCase("history")){
                if(history.size() == 1){
                    System.out.println("No history to show!");
                }else{
                    for (String line : history)
                    System.out.println(line);
                }
                continue;
            }    
            //this section is responsible for repeating the last command entered
            //if there are no previous commands, it will display an error message.
            else if (commandLine.equals("!!")){
                if (history.size() == 1){
                    System.out.println("No history to execute!");
                    continue;
                }
                else {
                    String command = history.get(history.size()-2);
                    String[] words = command.split(" ");
                    for(String word : words){
                        List.add(word);
                    }
                }
            }
            //if 'help' is entered, list all capable functions of the program.
            else if(commandLine.equalsIgnoreCase("help")){
                System.out.println("Help Section");
                System.out.println("______________________________________________________________________________________");
                System.out.println("Command:               Description:");
                System.out.println("cd                     prints the current working directiory");
                System.out.println("cd (filepath)          changed the working directory to that of the filepath");
                System.out.println("cd ..                  changed the working directory to the parent working directory");
                System.out.println("dir                    prints all the files within the specified directory");
                System.out.println("history                displays all previously entered commands");
                System.out.println("!!                     re-runs the previously entered command(to function correctly,");
                System.out.println("                       the previously entered command must be a function of cmd.exe.");
                System.out.println("exit                   exits the program.");
                System.out.println("______________________________________________________________________________________");
                System.out.println();
            }
            //if command is not recognized, display error message and loop again.
            else{
                System.out.println("Command not recognized.\n Please use a recognized command.\n Type'help' for recognized commands.");
                continue;
            }

            try{
                p.command(List);
                Process p1 = p.start();
                BufferedReader br = new BufferedReader(new InputStreamReader(p1.getInputStream()));
                String string;
                while ((string = br.readLine()) != null)
                System.out.println(string);
            } catch(IOException e){
                e.printStackTrace();
                continue;
            }    
        }
    }
}