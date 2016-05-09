/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Modelo;
import Vista.Interfaz;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Usuario
 */
public class Controlador implements ActionListener, MouseListener {

    Interfaz vista;
    Modelo mo = new Modelo();

    public Controlador(Interfaz vista) {

        this.vista = vista;
    }

    public enum AccionMVC {

        // Dialogo Configuración
        AbrirDia,
        DiaconfBtnGua,
        DiaconfBtnCan,
        //Panel Tpv
        Salir,
        Facturar,
        //Panel Clientes
        AnyadirCli,
        ModificarCli,
        ElminarCli,
        VerCli,
        //Panel Empleados
        AnyadirEmp,
        ModificarEmp,
        ElminarEmp,
        VerEmp,
        //Panel Productos
        AnyadirProd,
        ModificarProd,
        ElminarProd,
        VerProd,
        //Panel Proveedores
        AnyadirProv,
        ModificarProv,
        ElminarProv,
        VerProv,
    }

    public void Iniciar() {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            SwingUtilities.updateComponentTreeUI(vista);
            vista.setVisible(true);
        } catch (UnsupportedLookAndFeelException ex) {
        } catch (ClassNotFoundException ex) {
        } catch (InstantiationException ex) {
        } catch (IllegalAccessException ex) {
        }
        //Colocamos la ventana en el centro de la pantalla
        this.vista.setLocationRelativeTo(null);
        // Añadimos la accion de los botones correspondientes al dialogo para la configuración de la base de datos
        this.vista.menuConexion.setActionCommand("AbrirDia");
        this.vista.menuConexion.addActionListener(this);
        this.vista.BtnDiaConGuar.setActionCommand("DiaconfBtnGua");
        this.vista.BtnDiaConGuar.addActionListener(this);
        this.vista.BtnDiaConCan.setActionCommand("DiaconfBtnCan");
        this.vista.BtnDiaConCan.addActionListener(this);
        //Añadimos la accion de los botones coorespondientes al panel TPV
        this.vista.btnSalirTPV.setActionCommand("Salir");
        this.vista.btnSalirTPV.addActionListener(this);
        this.vista.btnFacturarTPV.setActionCommand("Facturar");
        this.vista.btnFacturarTPV.addActionListener(this);

        //Añadimos la accion de los botones correspondientes al panel Clientes
        this.vista.btnAniadeClientes.setActionCommand("AñadirCli");
        this.vista.btnAniadeClientes.addActionListener(this);
        this.vista.btnModificaClientes.setActionCommand("ModificarCli");
        this.vista.btnModificaClientes.addActionListener(this);
        this.vista.btnEliminarClientes.setActionCommand("EliminarCli");
        this.vista.btnEliminarClientes.addActionListener(this);
        this.vista.btnVerClientes.setActionCommand("VerCli");
        this.vista.btnVerClientes.addActionListener(this);
        //Añadimos la accion de los botones correspondientes al panel Empleados
        this.vista.btnAniadeEmpleado.setActionCommand("AnyadirEmp");
        this.vista.btnAniadeEmpleado.addActionListener(this);
        this.vista.btnModificarEmpleado.setActionCommand("ModificarEmp");
        this.vista.btnModificarEmpleado.addActionListener(this);
        this.vista.btnEliminarEmpleado.setActionCommand("EliminarEmp");
        this.vista.btnEliminarEmpleado.addActionListener(this);
        this.vista.btnVerEmpleado.setActionCommand("VerEmp");
        this.vista.btnVerEmpleado.addActionListener(this);
        //Añadimos la accion de los botones correspondientes al panel Proveedores
        this.vista.btnAniadeProveedores.setActionCommand("AnyadirProv");
        this.vista.btnAniadeProveedores.addActionListener(this);
        this.vista.btnModificaProveedores.setActionCommand("ModificarProv");
        this.vista.btnModificaProveedores.addActionListener(this);
        this.vista.btnEliminarProveedores.setActionCommand("EliminarProv");
        this.vista.btnEliminarProveedores.addActionListener(this);
        this.vista.btnVerProveedores.setActionCommand("VerProv");
        this.vista.btnVerProveedores.addActionListener(this);
        //Añadimos la accion de los botones correspondientes al panel Productos
        this.vista.btnAniadeProductos.setActionCommand("AnyadirProd");
        this.vista.btnAniadeProductos.addActionListener(this);
        this.vista.btnModificarProductos.setActionCommand("ModificarProd");
        this.vista.btnModificarProductos.addActionListener(this);
        this.vista.btnEliminarProductos.setActionCommand("EliminarProd");
        this.vista.btnEliminarProductos.addActionListener(this);
        this.vista.btnVerProductos.setActionCommand("VerProd");
        this.vista.btnVerProductos.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (AccionMVC.valueOf(e.getActionCommand())) {
            //Parte del switch que controla el Dialogo de configuración de la base de datos
            case AbrirDia:
                this.vista.DiaConfBd.setSize(360, 230);
                int xB = (int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 2 - this.vista.DiaConfBd.getWidth() / 2);
                int yB = (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 2 - this.vista.DiaConfBd.getHeight() / 2);
                this.vista.DiaConfBd.setLocation(xB, yB);

                String[] temp = null;

                try {
                    temp = this.mo.GetBdconf();

                } catch (IOException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
                this.vista.TxtDiaIP.setText(temp[0]);
                this.vista.TxtDiaUsu.setText(temp[1]);
                this.vista.TxtDiaPass.setText(temp[2]);
                this.vista.DiaConfBd.setVisible(true);
                break;
            case DiaconfBtnGua:
                String ip,
                 usu,
                 pass;
                ip = this.vista.TxtDiaIP.getText();
                usu = this.vista.TxtDiaUsu.getText();
                pass = this.vista.TxtDiaPass.getText();
                if (!ip.isEmpty() || !usu.isEmpty() || !pass.isEmpty()) {
                    this.mo.EscribeBdconf(ip, usu, pass);
                    this.vista.DiaConfBd.dispose();
                } else {
                    JOptionPane.showMessageDialog(vista, "Debe introducir Datos para poder guardarlos en el fichero de configuracion");
                }
                break;
            case DiaconfBtnCan:
                this.vista.DiaConfBd.dispose();
                break;
            //Cierre del control del dialogo de configuración de la base de datos
            //Comienzo del control del panel TPV 
            case Salir:
                System.exit(1);
                break;
            case Facturar:
                this.vista.DiaConfBd.setSize(360, 230);
                int xF = (int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 2 - this.vista.DiaFactura.getWidth() / 2);
                int yF = (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 2 - this.vista.DiaFactura.getHeight() / 2);
                this.vista.DiaFactura.setLocation(xF, yF);
                this.vista.DiaFactura.setVisible(true);

                break;
            //Cierre del control del panel TPV
            //Comienzo del control del panel del panel Clientes
            case AnyadirCli:
                break;
            case ModificarCli:
                break;
            case ElminarCli:
                break;
            case VerCli:
                break;
            //Cierre del contrl del panel Clientes

            //Comienzo del control del panel Productos
            case AnyadirProd:
                break;
            case ModificarProd:
                break;
            case ElminarProd:
                break;
            case VerProd:
                break;
            //Cierre del control del panel Productos

            //Comienzo del control del panel Empleados
            case AnyadirEmp:
                break;
            case ModificarEmp:
                break;
            case ElminarEmp:
                break;
            case VerEmp:
                break;
                //Cierre del control del panel Empleados

            //Comienzo del contol del panel Proveedores
            case AnyadirProv:
                break;
            case ModificarProv:
                break;
            case ElminarProv:
                break;
            case VerProv:
                break;
            //Cierre del control del panel Proveedores

        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}
