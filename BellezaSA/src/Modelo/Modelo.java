/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;

/**
 *
 * @author Belleza S.A
 */
public class Modelo extends ConexionBD {

    public Modelo() throws IOException, SQLException {

    }

    /**
     * Metodo para escrir un acrchivo stup.txt para la configuracion de la
     * conexion a una base de datos
     *
     * @param ip
     * @param usuario
     * @param pass
     */
    public void EscribeBdconf(String ip, String usuario, String pass) {
        FileOutputStream f = null;

        String s;
        char c;
        try {

            f = new FileOutputStream("setup.txt");

            s = ip + "," + usuario + "," + pass;
            for (int i = 0; i < s.length(); i++) {
                c = s.charAt(i);
                f.write(c);

            }

        } catch (IOException g) {
            g.getStackTrace();
        } finally {
            try {
                f.close();
            } catch (IOException g) {
                g.getStackTrace();
            }
        }
    }
}
