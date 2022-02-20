package semesterProject;

import java.io.IOException;

public class Run {
    //this class simply initiates the program, and calls constructors
    //to each class that is needed to download the articles.
    public static void main(String [] args) {
        run();
    }

    private static void run() {
        System.out.println("Running...");
        NewsDownloaderGuardian guardian = new NewsDownloaderGuardian();
        System.out.println("\nDownloading article urls...");
        guardian.download();
        GuardianNews fileCreator = new GuardianNews("GuardianLinks.dat");
        System.out.println("\nAttempting to create article files...");
        try{
            fileCreator.generateFiles();
        }catch (IOException e){
            e.printStackTrace();
        }
        System.out.println("\nFiles successfully generated!");
    }
}
