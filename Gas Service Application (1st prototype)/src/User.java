import java.util.Scanner;

public class User {
    public User(){

    }

    // Set the users username
    public void setUsername(String x){
        String username = x;
        DBConnect.insertData("INSERT INTO `login` (`id`) VALUES ('"+username+"'");
    }

    // Set the users password
    public void setPassword(String x){
        String password = x;
        DBConnect.insertData("INSERT INTO `login` (`password`) VALUES ('"+password+"'");
    }

    //replaces current password with new
    //NEEDS password replaced with method
    public void replacePassword(String pass) {
        DBConnect.insertData("UPDATE fuel_truck_app.login SET password ='"+pass
        +"'WHERE password = '1234'");
    }
    //replaces current username with new
    //needs 
    public void replaceUsername(String username) {
        DBConnect.insertData("UPDATE fuel_truck_app.login SET id ='"+username
        +"'WHERE id = 'user1'");
    }

    String carType;
    String carYear;
    // Let's the user set what type of car they have
    public void setCarTypeYear(){
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter the type of car you own: ");
        carType = in.nextLine();
        System.out.println("Please enter the year of your car: ");
        carYear = in.nextLine();
        System.out.println("Is the following information correct? Please enter Y for yes, N for No.");
        System.out.println(carType);
        System.out.println(carYear);
        String carInfo = in.nextLine();
        if (carInfo == "Y") {
            System.out.println("Proceed");
        } else if (carInfo == "N") {
            setCarTypeYear();
        }

    }

    // Let's the user set their address
    public void setAddress() {
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter your address: ");
        String address = in.nextLine();
        System.out.println("Is this correct? Type Y for yes, N for No.");
        System.out.println(address);
        String input = in.nextLine();
        if (input == "Y") {
            System.out.println("Setting this as your main address...");
        } else if (input == "N") {
            setAddress();
        }
    }

    public String getCarType(){
        String carType = this.carType; //Hook up to database
        return carType;
    }

    public String getCarYear(){
        String carYear = this.carYear; // Hook up to database
        return carYear;
    }

    public String getAddress(){
        String address = null; // Hook up to database
        return address;
    }

    // Return the users username
   public String getUsername(){
       String username = null; // Hook up to data base
       return username;
   }

   // Return the users password
    public String getPassword(){
       String password = null; // Hook up to data base
       return password;
    }

}