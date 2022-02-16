import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class signUp
{
    Scanner keyb = new Scanner(System.in);
    File file = new File("Usernames.txt");


    public void saveUsername(String userName) throws IOException
    {
        PrintWriter printWriter = new PrintWriter(new FileWriter(file.getAbsoluteFile(), true));

        printWriter.println();
        printWriter.print(userName);

        printWriter.close();
    }

    public String promptUser()
    {
        System.out.print("Enter Username: ");
        String username = keyb.nextLine();

        return username;
    }

    public boolean checkUsernames(String userN) throws IOException
    {
        Scanner reader = new Scanner(file);
        ArrayList<String> arrayList = new ArrayList<>();
        boolean check = false;

        while (reader.hasNextLine())
        {
            String data = reader.nextLine();
            arrayList.add(data);
        }

        reader.close();

        if (arrayList.contains(userN)){
            System.out.println("Username Unavailable");
            check = true;
            checkUsernames(promptUser());
        }else if (!arrayList.contains(userN))
        {
            System.out.println("Username Saved!");
            saveUsername(userN);
            check = false;
        }

        return check;
    }
}
