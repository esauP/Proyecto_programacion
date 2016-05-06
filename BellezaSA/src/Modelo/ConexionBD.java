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
    private String user = "";
    private String bd = user + "_BellezaSA";
    private String password = "";
    private String host = "";
    private String server = "jdbc:mysql://" + host + "/" + bd;

    public ConexionBD() throws IOException, SQLException {

        /**
         * Leemos el archivo configuracion de los datos de acceso de la base de
         * datos
         */
        leer();
        /**
         * Asignamos los valores para los datos de conexion
         */
        this.server = "jdbc:mysql://" + this.host + "/" + this.bd;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = (Connection) DriverManager.getConnection(this.server, this.user, this.password);
            System.out.println("Conexion a base de datos " + this.server + " ...OK");
        } catch (ClassNotFoundException ex) {
            System.out.println("Error cargando el Driver Mysql JDBC ...Fail");
        }
    }

    public Connection getConexion() {
        return this.conexion;
    }

    /**
     * Nos sirve para comprobar que los datos estan correctamente introducidos
     */
    public void leer() throws IOException {
        BufferedReader h = new BufferedReader(new FileReader("setup.txt"));
        String z = null;
        while ((z = h.readLine()) != null) {

            StringTokenizer g = new StringTokenizer(z, ",");
            for (int i = 0; i < g.countTokens(); i++) {

                this.host = g.nextToken();
                this.user = g.nextToken();
                this.password = g.nextToken();
            }
            System.out.println(host);
            System.out.println("");
            System.out.println(user);
            System.out.println("");
            System.out.println(password);
            System.out.println("");
            System.out.println(server);
        }
    }
}
