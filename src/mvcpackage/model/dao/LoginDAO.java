package mvcpackage.model.dao;

// importing the bean class to use getters and setters
import mvcpackage.model.bean.Login;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {

    // method boolean that returns true or false depending on if the query returns a result or not
    // the method takes a object of Login type as parameter
    public static boolean validate(Login loginBean) throws ClassNotFoundException {

        boolean status = false; //will evaluate if the query returned a result or not
        PreparedStatement pstmt = null;
        Connection conn = null;
        ResultSet rs = null;

        // registering the JDBC driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        try{
            // stablish a connection
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbBlog?serverTimezone=Australia/Sydney",
                    "root", "mysql");

            // define a prepared statement
            pstmt = conn.prepareStatement("SELECT * from users" +
                    " where username = ?" +
                    " and password = ?");

            // get the value from the java bean (helper) class.
            // the java bean object will be created with information submited through the form
            pstmt.setString(1, loginBean.getUsername());
            pstmt.setString(2, loginBean.getPassword());

            rs = pstmt.executeQuery();

            status = rs.next(); // if this is true, it means that the query returned something

        } catch (SQLException e) {
            e.printStackTrace(System.err);
            System.err.println("SQLSTATE: " + ((SQLException) e).getSQLState());
            System.err.println("Error code: " + ((SQLException) e).getErrorCode());
            System.err.println("Message: " + e.getMessage());

        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (Exception e) {}
                    rs = null;
            }

            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (Exception e) {}
                    pstmt = null;
            }

            if (conn != null) {
                try{
                    conn.close();
                } catch (Exception e) {
                    conn = null;
                }
            }

        }

        return status;

    }

}
