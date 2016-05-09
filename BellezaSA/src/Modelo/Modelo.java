/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.StringTokenizer;

/**
 *
 * @author Belleza S.A
 */
public class Modelo extends ConexionBD {

    public Modelo() {

    }

    /**
     * Metodo que usamos para recuperar los datos para poder visualizarlos en el
     * Dialogo de configuracion
     *
     * @return String [] - Con los datos de la base de datos
     * @throws IOException
     */
    public String[] GetBdconf() throws IOException {
        String[] data = new String[3];
        String s;
        BufferedReader f = new BufferedReader(new FileReader("setup.txt"));

        while ((s = f.readLine()) != null) {
            StringTokenizer g = new StringTokenizer(s, ",");
            for (int i = 0; i < 3; i++) {
                data[i] = g.nextToken();
            }
        }

        return data;
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
