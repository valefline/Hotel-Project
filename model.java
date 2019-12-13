package p3model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

public class model {

    public model() {

    }

    public int checkAvailableRooms(String beginDate, String leavingDate) {
        Connection conn = null;
        int returnInt = 0;

        String query = "select HotelRooms from Rooms where HotelRooms NOT IN (select RoomNum from Reservation where  BegDate>= '" + beginDate + "' and   LevDate<= '" + leavingDate + "');";
        try {
            // db parameters
            String url = "jdbc:sqlite:./HotelModel.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);

            // System.out.println("Connection to SQLite has been established.");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            System.out.println(query);
            int counter = 0;
            while (rs.next()) {
                counter++;
                returnInt = rs.getInt("HotelRooms");
                System.out.println(" Room: " + returnInt + "is available");
            }
            System.out.println("counter is " + counter);
            // System.out.println("updated");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }

        return returnInt;

    }

    public void makeReservation(String username, String beginDate, String leavingDate, int RID, int RoomNum) {
        Connection conn = null;
        int returnInt = 0;

        String query = "insert into Reservation (ReservationID,RoomNum,BegDate,LevDate,Username) values (" + RID + "," + RoomNum + ",'" + beginDate + "' ,'" + leavingDate + "','" + username + "');";
        try {
            // db parameters
            String url = "jdbc:sqlite:./HotelModel.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);

            // System.out.println("Connection to SQLite has been established.");
            Statement stmt = conn.createStatement();

            System.out.println(query);
            // stmt.setInt(1,RID );
            // stmt.setInt(2,RoomNum );
            // stmt.setString(3,beginDate);
            // stmt.setString(4,leavingDate);
            //stmt.setString(5,username);

            stmt.executeUpdate(query);
            System.out.println("updated");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }

    }

    public void makeCustomer(String fname, String lname, String username) {

        Connection conn = null;
        int returnInt = 0;

        String query = "insert into Customer (Username,F_Name,L_Name) values ('" + username + "','" + fname + "','" + lname + "');";
        try {
            // db parameters
            String url = "jdbc:sqlite:./HotelModel.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);

            // System.out.println("Connection to SQLite has been established.");
            Statement stmt = conn.createStatement();

            System.out.println(query);
            // stmt.setInt(1,RID );
            // stmt.setInt(2,RoomNum );
            // stmt.setString(3,beginDate);
            // stmt.setString(4,leavingDate);
            //stmt.setString(5,username);

            stmt.executeUpdate(query);
            System.out.println("updated");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }

    }

    public void paymentInfo(String CreditCardNum, String ExpDate, String CVV, String Address, String State, String Zipcode, String Username) {

        Connection conn = null;

        String query = "insert into Payment (CreditCardNum,ExpDate,CVV,Address,State,Zipcode,Username) values ('" + CreditCardNum + "','" + ExpDate + "','" + CVV + "','" + Address + "','" + State + "','" + Zipcode + "','" + Username + "');";
        try {

            String url = "jdbc:sqlite:./HotelModel.db";

            conn = DriverManager.getConnection(url);

            Statement stmt = conn.createStatement();

            System.out.println(query);

            stmt.executeUpdate(query);
            System.out.println("updated");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }

    }

}
