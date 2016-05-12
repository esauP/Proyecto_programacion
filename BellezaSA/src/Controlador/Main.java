/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.Interfaz;

/**
 *
 * @author ESAÚ || MACARENA || SAMUEL
 */
public class Main {

    public static void main(String[] args) {
        Interfaz vista=new Interfaz();
        new Controlador_TPV(vista).Iniciar();
        new Controlador_CLI(vista).Iniciar();
        new Controlador_EMP(vista).Iniciar();
        new Controlador_MENU(vista).Iniciar();
        new Controlador_PROD(vista).Iniciar();
        new Controlador_PROV(vista).Iniciar();
        new Controlador(vista).Iniciar();

    }
}
