/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hdi;

import java.sql.*;
import javax.swing.JOptionPane;


/**
 *
 * @author Ashu
 */
public class Connect {
    private static Connection con;
    //private static String urlstring;

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("java.sql.DriverManager");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "password");
        }
        catch (ClassNotFoundException ex) {
            // log an exception.
            JOptionPane.showMessageDialog(null, ex); 
        }
        return con;
}
}