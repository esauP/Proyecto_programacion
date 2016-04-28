/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Usuario
 */
public class ConexionBD {

    private static Connection conexion;
    private static String bd = "dam43_BellezaSA";
    private static String user = "dam43";
    private static String password = "salesianas";
    private static String host = "192.168.28.2:3306";
    private static String server = "jdbc:mysql://" + host + "/" + bd;

    public static void main(String[] args) throws SQLException {
        
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = (Connection) DriverManager.getConnection(server, user, password);
            System.out.println("Conexion a base de datos " + server + " ...OK");
        } catch (ClassNotFoundException ex) {
            System.out.println("Error cargando el Driver Mysql JDBC ...Fail");
        }
    }

}
