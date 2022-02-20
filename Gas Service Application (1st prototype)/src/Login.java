import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Login
{
    File file = new File("Usernames.txt");
    Scanner keyb = new Scanner(System.in);
    Scanner reader = new Scanner(file);
    ArrayList<String> arrayList = new ArrayList<>();

    public Login() throws FileNotFoundException {
    }

    /*
    This method prompts the user to enter in whether they are an admin
    or a user. And then returns a boolean value.
     */
    public boolean userOrAdmin()
    {
        boolean choice = false;
        byte loopfix = 0;

        while (loopfix != 1)
        {
            System.out.print("Are you a user or an admin?: ");
            String input = keyb.nextLine();

            String uORa = input.toLowerCase();

            if (uORa.equals("user"))
            {
                choice = true;
                break;
            }
            else if (uORa.equals("admin"))
            {
                choice = false;
                break;
            }
            else
            {
                System.out.println("Enter either 'user' or 'admin' please: ");
            }
        }
        return choice;
    }

    public boolean loginAdmin()
    {
        boolean verify = false;
        boolean loop = false;

        //This try catch will traverse the AdminPins.txt to find the admin pins available
        ArrayList<Integer> adminPins = new ArrayList<>();
        try {
            File myObj = new File("AdminPins.txt");
            Scanner myReader = new Scanner(myObj);

            while (myReader.hasNextLine())
            {
                String data = myReader.nextLine();
                adminPins.add(Integer.parseInt(data));
            }

            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }


        /*
        This loop prompts the admin to enter their pin and loops
        if the pin was not available in the AdminPins.txt.
         */
        while (loop == false)
        {
            System.out.print("Please enter your 4 digit pin #: ");
            int input = keyb.nextInt();

            if (adminPins.contains(input) == true)
            {
                verify = true;
                break;
            } else
            {
                verify = false;
                System.out.println("Wrong pin please try again.");
            }
        }

        return verify;
    }

    public boolean userLogin(String username)
    {
        boolean check = false;

        while (reader.hasNextLine())
        {
            String line = reader.nextLine();

            arrayList.add(line);
        }

        if (arrayList.contains(username))
        {
            System.out.println("Valid Username.");
            check=true;
        }else if (!arrayList.contains(username))
        {
            System.out.println("Username Invalid.");
        }

        return check;
    }

    public String promptUser()
    {
        System.out.print("Enter login Username: ");
        String username = keyb.nextLine();

        return username;
    }
}
