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

    public Connection connect() {
        String connectionURL = "jdbc:jtds:sqlserver://memorygame.database.windows.net:1433;DatabaseName=BuckDB;user=riste@memorygame;password=Ristov123;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
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

    public ArrayList<Business> getBusiness() {
        conn = connect();
        if(conn != null) {
            try{
                String sqlStatement = "SELECT * FROM Businesses";
                Statement smt = conn.createStatement();
                ResultSet set = smt.executeQuery(sqlStatement);
                ArrayList<Business> allBusinesses = new ArrayList<Business>();

                while (set.next()) {
                    String category = set.getString(9);
                    int image = 0;
                    switch (category) {
                        case "Services":
                            image = R.drawable.ic_services;
                            break;
                        case "Fun":
                            image = R.drawable.ic_fun;
                            break;
                        case "Industry":
                            image = R.drawable.ic_industry;
                            break;
                        case "Education":
                            image = R.drawable.ic_education;
                            break;
                        default:
                            image = R.drawable.ic_web;
                            break;
                    }
                    allBusinesses.add(new Business(
                            set.getString(2),
                            set.getString(3),
                            set.getString(11),
                            Double.parseDouble(set.getString(4)),
                            Double.parseDouble(set.getString(5)),
                            set.getString(6),
                            set.getString(7),
                            set.getString(8),
                            category,
                            image
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
