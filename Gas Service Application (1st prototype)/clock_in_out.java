import java.util.Scanner;

public class clock_in_out {

    private long clockInTime;
    private long clockOutTime;

    Scanner keyboard = new Scanner(System.in);

    private final int admincode = 0001;

    public void clockInOut() {
        System.out.println("Please enter your admin code: ");
        int code = keyboard.nextInt();

        if (code == admincode) {
            System.out.println("Hello! Would you like to clock in? Type Y for yes. If you are already clocked in and need to clock" +
                    "out, type N");
            String input = keyboard.nextLine();
            if (input.equals("Y")) {
                clockInTime = System.currentTimeMillis(); // Act's as if time is at 0
                System.out.println("You've successfully clocked in!");
            } else if (input.equals("N")) {
                clockOutTime = (System.currentTimeMillis()/60000) - clockInTime;
                System.out.println("You've successfully clocked out! Your time on the clock was " +
                        clockOutTime + " minutes.");
            }
        } else {
            System.out.println("There was an error while logging in. Please try again.");
            clockInOut();
        }
    }
}
