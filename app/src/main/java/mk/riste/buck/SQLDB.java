package mk.riste.buck;

import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SQLDB {
    Connection conn;

    // ToDo: Proper Connection String
    public Connection connect() {
        String connectionURL = "";
        Connection connection = null;

        try{
            Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection(connectionURL);
        }
        catch (Exception e) {
            Log.e("Error ", " " + e.toString());
        }

        return connection;

    }
    // ToDo: Assign Random Image from ArrayList
    public ArrayList<Business> getBusiness() {
        conn = connect();
        if(conn != null) {
            try{
                String sqlStatement = "SELECT * FROM Businesses";
                Statement smt = conn.createStatement();
                ResultSet set = smt.executeQuery(sqlStatement);
                ArrayList<Business> allBusinesses = new ArrayList<Business>();

                while (set.next()) {
                    allBusinesses.add(new Business(
                            set.getString(2),
                            set.getString(3),
                            set.getString(11),
                            Double.parseDouble(set.getString(4)),
                            Double.parseDouble(set.getString(5)),
                            set.getString(6),
                            set.getString(7),
                            set.getString(8),
                            set.getString(9),
                            R.drawable.ic_logo
                    ));
                }

                return allBusinesses;
            }
            catch (Exception e) {
                Log.e("Error: ", "" + e.getMessage());
            }
            finally {
                try {
                    conn.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }

        return  null;
    }
    private int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    private String createInsertQuery(String Name, String Address, String Latitude, String Longitude, String Email, String Telephone, String Website, String Category, String Description){
        String imageIndex = Integer.toString(getRandomNumber(0, 30));
        return "INSERT INTO [dbo].[Businesses]" +
                "VALUES ('" + Name + "', '" + Address  +"', '" + Longitude + "', '" + Latitude +"', '" + Email + "', '" + Telephone + "', '" + Website + "', '" + Category + "', '" + imageIndex + "', '" + Description + "')";
    }

    public void  addBusiness(String Name, String Address, String Latitude, String Longitude, String Email, String Telephone, String Website, String Category, String Description) {
        conn = connect();
        if(conn != null) {
            try{
                String sqlStatement = createInsertQuery(Name, Address, Latitude, Longitude, Email, Telephone, Website, Category, Description);
                Statement smt = conn.createStatement();
                smt.executeUpdate(sqlStatement);
            }
            catch (Exception e) {
                Log.e("Error: ", "" + e.getMessage());
            }
            finally {
                try {
                    conn.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }
}
