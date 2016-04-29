/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import com.mysql.jdbc.Connection;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.StringTokenizer;

/**
 *
 * @author Usuario
 */
public class ConexionBD {

    private static Connection conexion;
    private static String user = "";
    private static String bd = user + "_BellezaSA";
    private static String password = "";
    private static String host = "";
    private static String server = "jdbc:mysql://" + host + "/" + bd;

    public ConexionBD() throws IOException, SQLException {

        /**
         * Leemos el archivo configuracion de los datos de acceso de la base de
         * datos
         */
        leer();
        /**
         * Asignamos los valores para los datos de conexion
         */
        server = "jdbc:mysql://" + host + "/" + bd;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = (Connection) DriverManager.getConnection(server, user, password);
            System.out.println("Conexion a base de datos " + server + " ...OK");
        } catch (ClassNotFoundException ex) {
            System.out.println("Error cargando el Driver Mysql JDBC ...Fail");
        }
    }

    public java.sql.Connection getConexion() {
        return this.conexion;
    }

    /**
     * Nos sirve para comprobar que los datos estan correctamente introducidos
     */

//        System.out.println(host);
//        System.out.println("");
//        System.out.println(user);
//        System.out.println("");
//        System.out.println(password);
//        System.out.println("");
//        System.out.println(server);
    public static void leer() throws IOException {
        BufferedReader h = new BufferedReader(new FileReader("setup.txt"));
        String z = null;
        while ((z = h.readLine()) != null) {

            StringTokenizer g = new StringTokenizer(z, ",");
            for (int i = 0; i < g.countTokens(); i++) {

                host = g.nextToken();
                user = g.nextToken();
                password = g.nextToken();

            }
        }
    }
}
