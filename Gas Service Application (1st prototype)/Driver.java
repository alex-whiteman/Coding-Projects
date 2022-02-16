public class Driver{
    public Driver(){}

    public void setDriverID(int id){
            DBConnect.insertData("INSERT INTO `drivers` (`driverID`) VALUES ('"+id+"');");
    }
    public void setVehicleID(int id){

    }

}