import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
/*
This class is responsible for connecting to the database
and inserting or removing data, depending on the method used.
*/
public class DBConnect
{
    private static String url = "jdbc:mysql://localhost:3306/fuel_truck_app";
    private static String username = "root";
    private static String password = "1234";
    
    //use this to retrieve data from a table
    public static ResultSet getValResultSet(String sql)
    {
        ResultSet rs = null;
        try{
            Connection con = DriverManager.getConnection(url,username,password);
            Statement stmt = con.createStatement();    
            rs = stmt.executeQuery(sql);
            
        }catch(Exception e){
            System.out.println(e);
        }
        return rs;
    }

    //use this to insert or change data on a table
    public static void updateData(String sql)
    {
        try{
            Connection con = DriverManager.getConnection(url,username,password);    
            PreparedStatement ps = con.prepareStatement(sql);
            ps.executeUpdate();
            ps.close();
            
        }catch(Exception e){
            System.out.println(e);
        }
    }
    public static void insertData(String sql){

    }
}


