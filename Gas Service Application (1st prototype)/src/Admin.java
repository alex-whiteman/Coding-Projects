import java.sql.ResultSet;
import java.sql.SQLException;

public class Admin
{
    //Returns Active driver count
    public int getActiveDriverNum() throws SQLException
    {
        int drivers = 0;
        String sql="SELECT * FROM drivers WHERE status = 'active'";
        ResultSet rs = DBConnect.getValResultSet(sql);
        while(rs.next()!=false){
            drivers++;
        }
        System.out.print("\nActive \nDrivers: ");
        return drivers;
    }

    //Returns number of active orders
    public int getActiveOrderNum() throws SQLException
    {
        int activeOrders = 0;
        String sql="SELECT * FROM orders WHERE status = 'active'";
        ResultSet rs = DBConnect.getValResultSet(sql);
        while(rs.next()){
            activeOrders++;
        }

        System.out.print("\nActive \nOrders: ");
        return activeOrders;
    }

    //Returns completed orders
    public int getCompletedOrders() throws SQLException
    {
        int compOrders = 0;
        String sql = "Select * from orders where status = 'completed'";
        ResultSet rs = DBConnect.getValResultSet(sql);
        while(rs.next()){
            compOrders++;
        }
        System.out.print("\nCompleted \nOrders: ");
        return compOrders;
    }

    //Returns revenue
    public double getRevenue() throws SQLException
    {
        double total = 0;
        String sql = "Select * from orders";
        ResultSet rs = DBConnect.getValResultSet(sql);
        while(rs.next()){
            total = total+rs.getDouble("orderTotal");
        }

        System.out.print("\nTotal \nRevenue: $");
        return total;
    }
}
