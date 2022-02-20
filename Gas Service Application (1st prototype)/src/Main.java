import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args) throws SQLException, IOException {
        Admin admin = new Admin();
        User user = new User();
        Login login = new Login();

        Payment pay = new Payment();
        signUp signUp = new signUp();
        Driver d = new Driver();

        Scanner keyb = new Scanner(System.in);
        Scanner in = new Scanner(System.in);

        // System asks user if they are admin or user
        if (login.userOrAdmin() == false && login.loginAdmin() == true)
        {
            System.out.println("\nWelcome Administrator,");
            byte answer = 0;

            while (answer != 5)
            {
                System.out.print("Would you like to see today's numbers," +
                        "\nyes or no?: ");
                String input = keyb.nextLine();

                String fixedInput = input.toLowerCase();

                if (fixedInput.equals("yes"))
                {
                    System.out.println(admin.getActiveDriverNum());
                    System.out.println(admin.getActiveOrderNum());
                    System.out.println(admin.getCompletedOrders());
                    System.out.println(admin.getRevenue());
                }else
                    break;
            }
            System.out.println("See you later Administrator!");
        }else
        {
            System.out.println("Welcome User, \n");

            System.out.println("Would you like to sign up or login?");
            System.out.print("Enter sign up or login: ");
            String userIn = keyb.nextLine();

            userIn.toLowerCase();

            int count = 0;

            if (userIn.equals("sign up"))
            {
                signUp.checkUsernames(signUp.promptUser());
            }
            //if the person logging in is a user, use this section of code
            if(login.userLogin(login.promptUser()) == true)
            {
                boolean on = true;
                while (on)
                {
                    System.out.println("\nWelcome " + user.getUsername());

                    System.out.println("1: Would you like to put in an order? \n" +
                            "2: If you'd like to put in your payment info, car info, and your address.\n" +
                            "3: If you'd like to logout. \n" +
                            "4: If you'd like to change your username and password.");

                    int input = keyb.nextInt();

                    if (input == 1)
                    {
                        // Call order methods
                        System.out.println("Order Method not complete yet.");
                    } else if (input == 2)
                    {
                        pay.setPaymentInfo();
                        System.out.println("Is the following information correct? Please enter yes, or no");

                        System.out.println(pay.getCardType() + "\t" + pay.getDebitOrCredit() + "\t" +
                                pay.getCardNumber() + "\t" + pay.getCardExpirationMonth()
                                + "\t" + pay.getCardExpirationYear() + "\t" + pay.getCardCVV());

                        String paymentinfo = in.nextLine();
                        paymentinfo.toLowerCase();

                        if (paymentinfo.equals("yes"))
                        {
                            user.setCarTypeYear();

                            System.out.println("Your car info:");
                            System.out.println(user.getCarType());
                            System.out.println(user.getCarYear());

                        } else if (paymentinfo.equals("no"))
                        {
                            pay.setPaymentInfo();
                        }
                    } else if (input == 3)
                    {
                        System.out.println("Logging out. Goodbye " + user.getUsername() + "!");
                        break;
                    } else if (input == 4)
                    {
                        keyb = new Scanner(System.in);
                        System.out.println("Please enter your new username: ");
                        String username = keyb.nextLine();
                        user.replaceUsername(username);

                        keyb = new Scanner(System.in);
                        System.out.println("Please enter your new password: ");
                        String pass = keyb.nextLine();
                        user.replacePassword(pass);

                        break;
                    }
                }
            }
        }
    }
}
