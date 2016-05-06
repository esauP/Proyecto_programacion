/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.Interfaz;
import java.io.IOException;
import java.sql.SQLException;

/**
 *
 * @author Usuario
 */
public class Main {
    public static void main (String [] args) throws SQLException, IOException{
      new Controlador( new Interfaz() ).Iniciar() ;
    }
}
