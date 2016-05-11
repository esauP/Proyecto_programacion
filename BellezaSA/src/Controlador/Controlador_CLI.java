/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Modelo_CLI;
import Vista.Interfaz;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author ESAÚ || MACARENA || SAMUEL
 */
public class Controlador_CLI extends Controlador implements ActionListener, MouseListener {

    Modelo_CLI mo_cl = new Modelo_CLI();

    public Controlador_CLI(Interfaz vista) {
        super(vista);
    }

    public enum AccionMVC {

        //Panel Clientes
        AnyadirCli,
        ModificarCli,
        ElminarCli,
        VerCli,
        // Dialogo Añadir Cliente
        CliGuardar,
        CliCerrar,
    }

    public void Iniciar() {
//        try {
//            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
//            SwingUtilities.updateComponentTreeUI(vista);
//            vista.setVisible(true);
//        } catch (UnsupportedLookAndFeelException ex) {
//        } catch (ClassNotFoundException ex) {
//        } catch (InstantiationException ex) {
//        } catch (IllegalAccessException ex) {
//        }
        //Añadimos la accion de los botones correspondientes al panel Clientes
        super.vista.btnAniadeClientes.setActionCommand("AnyadirCli");
        super.vista.btnAniadeClientes.addActionListener(this);
        super.vista.btnModificaClientes.setActionCommand("ModificarCli");
        super.vista.btnModificaClientes.addActionListener(this);
        super.vista.btnEliminarClientes.setActionCommand("EliminarCli");
        super.vista.btnEliminarClientes.addActionListener(this);
        super.vista.btnVerClientes.setActionCommand("VerCli");
        super.vista.btnVerClientes.addActionListener(this);
        // Añadimos la accion de los botones correspondientes al dialogo añadirClientes
        super.vista.btnGuardarCliente.setActionCommand("CliGuardar");
        super.vista.btnGuardarCliente.addActionListener(this);
        super.vista.btnCancelarCliente.setActionCommand("CliCerrar");
        super.vista.btnCancelarCliente.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (Controlador_CLI.AccionMVC.valueOf(e.getActionCommand())) {
            /**
             *
             */
            //Comienzo del control del panel del panel Clientes
            case AnyadirCli:
                super.vista.DiaAñadirCLi.setSize(900, 570);
                int xc = (int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 2 - super.vista.DiaAñadirCLi.getWidth() / 2);
                int yc = (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 2 - super.vista.DiaAñadirCLi.getHeight() / 2);
                super.vista.DiaAñadirCLi.setLocation(xc, yc);
                super.vista.DiaAñadirCLi.setVisible(true);
                break;
            case ModificarCli:
                this.mo_cl.Modificar();
                break;
            case ElminarCli:
                this.mo_cl.Eliminar();
                break;
            case VerCli:
                this.mo_cl.Buscar();
                break;
            //Cierre del control del panel Clientes
            //Comienzo del control del dialogo Añadir Cliente
            case CliGuardar:
                this.mo_cl.Insertar();
                break;
            case CliCerrar:
                super.vista.DiaAñadirCLi.dispose();
                break;
            //Cierre del control del dialogo Añadir Cliente

        }
    }

}
