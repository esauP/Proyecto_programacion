/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Modelo_BD;
import Vista.Interfaz;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ESAÚ || MACARENA || SAMUEL
 */
public class Controlador_MENU extends Controlador implements ActionListener, MouseListener {

    Modelo_BD mo_bd = new Modelo_BD();

    public Controlador_MENU(Interfaz vista) {
        super(vista);
    }

    public enum AccionMVC {

        /**
         * Menu bar y menu item
         */
        //Configuracion BD
        AbrirDiaConf,
        //Archivo
        AbrirDiaEmpresa,
        AbrirDiaIncre,
        AbrirDiaAdmin,
        //Listados
        AbrirLisPrecio,
        AbrirLisFactura,
        AbrirLisFacEmple,
        AbrirLisFacCli,
        // Dialogo Configuración
        DiaconfBtnGua,
        DiaconfBtnCan,
        //Dialogo Datos Empresa
        DiaEmpreGuardar,
        DiaEmpreSalir,
        //Dialogo Incrementar Precios
        DiaIncIncrementar,
        DiaIncSalir,
        //Dialogo Administracion Empleado

        //Dialogo Listado Precio
        DiaPreConsulta,
        //Dialogo Listado Factura
        DiaFacConsulta,
        //Dialogo Listado Empleado
        DiaEmpConsulta,
        //Dialogo Listado Cliente
        DiaCliConsulta,

    }

    public void Iniciar() {
        /**
         * Seccion de Menu bar y menu item
         */
        // Configuracion Base de datos
        super.vista.menuConexion.setActionCommand("AbrirDiaConf");
        super.vista.menuConexion.addActionListener(this);
        //Menu Archivo
        super.vista.menuIncPrecio.setActionCommand("AbrirDiaIncre");
        super.vista.menuIncPrecio.addActionListener(this);
        super.vista.menuEmpresa.setActionCommand("AbrirDiaEmpresa");
        super.vista.menuEmpresa.addActionListener(this);
        super.vista.menuAdminEmp.setActionCommand("AbrirDiaAdmin");
        super.vista.menuAdminEmp.addActionListener(this);
        super.vista.menuSalir.setActionCommand("Salir");
        super.vista.menuSalir.addActionListener(this);
        //Menu Listados
        super.vista.menuLisPrecio.setActionCommand("AbrirLisPrecio");
        super.vista.menuLisPrecio.addActionListener(this);
        super.vista.menuLisEmpleado.setActionCommand("AbrirLisFacEmple");
        super.vista.menuLisEmpleado.addActionListener(this);
        super.vista.menuLisClientes.setActionCommand("AbrirLisFacCli");
        super.vista.menuLisClientes.addActionListener(this);
        super.vista.menuLisFacturas.setActionCommand("AbrirLisFactura");
        super.vista.menuLisFacturas.addActionListener(this);
        /**
         * Seccion de los botones de los dialogos
         */
        // Añadimos la accion de los botones correspondientes al dialogo para la configuración de la base de datos
        super.vista.BtnDiaConGuar.setActionCommand("DiaconfBtnGua");
        super.vista.BtnDiaConGuar.addActionListener(this);
        super.vista.BtnDiaConCan.setActionCommand("DiaconfBtnCan");
        super.vista.BtnDiaConCan.addActionListener(this);

        //Añadimos la accion de los botones correspondientes al dialogo Datos de la empresa
        super.vista.btnGuardarEmpresa.setActionCommand("DiaEmpreConsulta");
        super.vista.btnGuardarEmpresa.addActionListener(this);
        super.vista.btnSalirEmpresa.setActionCommand("DiaEmpreSalir");
        super.vista.btnSalirEmpresa.addActionListener(this);
        //Añadimos la accion de los botones correspondienetes al dialogo Incrementa Precios
        super.vista.btnIncrementar.setActionCommand("DiaIncIncrementar");
        super.vista.btnIncrementar.addActionListener(this);
        super.vista.btnSalirIncremento.setActionCommand("DiaIncSalir");
        super.vista.btnSalirIncremento.addActionListener(this);
        //Añadimos la accion de los botones correspondientes al dialogo Adminstracion Empleados

        //Añadimos la accion de los botones correspondientes al dialogo Listado Precios
        super.vista.btnPrecios.setActionCommand("DiaPreConsulta");
        super.vista.btnPrecios.addActionListener(this);
        //Añadimos la accion de los botones correspondientes al dialogo Listado Facturas Empresa
        super.vista.btnFacturaEmpresa.setActionCommand("DiaFacConsulta");
        super.vista.btnFacturaEmpresa.addActionListener(this);
        //Añadimos la accion de los botones correspondientes al dialogo Listado Facturas Empleados
        super.vista.btnFacturaEmpleado.setActionCommand("DiaFacEmpleado");
        super.vista.btnFacturaEmpleado.addActionListener(this);
        //Añadimos la accion de los botones correspondientes al dialogo Listado Facturas Cliente
        super.vista.btnFacturaCliente.setActionCommand("DiaFacCliente");
        super.vista.btnFacturaCliente.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (Controlador_MENU.AccionMVC.valueOf(e.getActionCommand())) {
            /**
             * En esta seccion controlamos el menu bar y sus menu item
             */
            // Incio del control del Menu item Configuracion de la base de datos
            case AbrirDiaConf:
                super.vista.DiaConfBd.setSize(360, 230);
                int xB = (int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 2 - super.vista.DiaConfBd.getWidth() / 2);
                int yB = (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 2 - super.vista.DiaConfBd.getHeight() / 2);
                super.vista.DiaConfBd.setLocation(xB, yB);

                String[] temp = null;

                try {
                    temp = this.mo_bd.GetBdconf();

                } catch (IOException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
                super.vista.TxtDiaIP.setText(temp[0]);
                super.vista.TxtDiaUsu.setText(temp[1]);
                super.vista.TxtDiaPass.setText(temp[2]);
                super.vista.DiaConfBd.setVisible(true);
                break;
            // Cierre del control del Menu item Configuracion de la base de datos
            // Incio del control del Menu item Datos de la Empresa
            case AbrirDiaEmpresa:
                super.vista.DiaDatosEmpresa.setSize(570, 450);
                int xe = (int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 2 - super.vista.DiaDatosEmpresa.getWidth() / 2);
                int ye = (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 2 - super.vista.DiaDatosEmpresa.getHeight() / 2);
                super.vista.DiaDatosEmpresa.setLocation(xe, ye);
                super.vista.DiaDatosEmpresa.setVisible(true);
                break;
            // Cierre del control del Menu item Datos de la Empresa
            // Incio del control del Menu item Incremento de Precio
            case AbrirDiaIncre:
                super.vista.DiaIncrementoPrecios.setSize(590, 300);
                int xp = (int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 2 - super.vista.DiaIncrementoPrecios.getWidth() / 2);
                int yp = (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 2 - super.vista.DiaIncrementoPrecios.getHeight() / 2);
                super.vista.DiaIncrementoPrecios.setLocation(xp, yp);
                super.vista.DiaIncrementoPrecios.setVisible(true);
                break;
            // Cierre del control del Menu item Incremento de precio
            // Incio del control del Menu item Administracion de empleados
            case AbrirDiaAdmin:
                super.vista.DiaAdministracionEmpleados.setSize(570, 330);
                int xa = (int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 2 - super.vista.DiaAdministracionEmpleados.getWidth() / 2);
                int ya = (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 2 - super.vista.DiaAdministracionEmpleados.getHeight() / 2);
                super.vista.DiaAdministracionEmpleados.setLocation(xa, ya);
                super.vista.DiaAdministracionEmpleados.setVisible(true);
                break;
            // Cierre del control del Menu item Administracion de empleados
            // Incio del control del Menu item Listado de precios
            case AbrirLisPrecio:
                super.vista.DiaListaPrecios.setSize(340, 170);
                int xls = (int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 2 - super.vista.DiaListaPrecios.getWidth() / 2);
                int yls = (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 2 - super.vista.DiaListaPrecios.getHeight() / 2);
                super.vista.DiaListaPrecios.setLocation(xls, yls);
                super.vista.DiaListaPrecios.setVisible(true);
                break;
            // Cierre del control del Menu item Listado de precios
            // Incio del control del Menu item Administracion de empleados
            case AbrirLisFactura:
                super.vista.DiaListaFacturas.setSize(370, 140);
                int xlf = (int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 2 - super.vista.DiaListaFacturas.getWidth() / 2);
                int ylf = (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 2 - super.vista.DiaListaFacturas.getHeight() / 2);
                super.vista.DiaListaFacturas.setLocation(xlf, ylf);
                super.vista.DiaListaFacturas.setVisible(true);
                break;
            // Cierre del control del Menu item Administracion de empleados
            // Incio del control del Menu item Administracion de empleados
            case AbrirLisFacCli:
                super.vista.DiaFacturaCliente.setSize(390, 260);
                int xfc = (int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 2 - super.vista.DiaFacturaCliente.getWidth() / 2);
                int yfc = (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 2 - super.vista.DiaFacturaCliente.getHeight() / 2);
                super.vista.DiaFacturaCliente.setLocation(xfc, yfc);
                super.vista.DiaFacturaCliente.setVisible(true);
                break;
            // Cierre del control del Menu item Administracion de empleados
            // Incio del control del Menu item Administracion de empleados
            case AbrirLisFacEmple:
                super.vista.DiaFacturaEmpleado.setSize(450, 280);
                int xfe = (int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 2 - super.vista.DiaFacturaEmpleado.getWidth() / 2);
                int yfe = (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 2 - super.vista.DiaFacturaEmpleado.getHeight() / 2);
                super.vista.DiaFacturaEmpleado.setLocation(xfe, yfe);
                super.vista.DiaFacturaEmpleado.setVisible(true);
                break;
            // Cierre del control del Menu item Administracion de empleados

            /**
             * En esta seccion controlamos los botones de los Dialogos
             */
            //Comienzo del control del Dialogo de configuración de la base de datos
            case DiaconfBtnGua:
                String ip,
                 usu,
                 pass;
                ip = super.vista.TxtDiaIP.getText();
                usu = super.vista.TxtDiaUsu.getText();
                pass = super.vista.TxtDiaPass.getText();
                if (!ip.isEmpty() || !usu.isEmpty() || !pass.isEmpty()) {
                    this.mo_bd.EscribeBdconf(ip, usu, pass);
                    super.vista.DiaConfBd.dispose();
                } else {
                    JOptionPane.showMessageDialog(vista, "Debe introducir Datos para poder guardarlos en el fichero de configuracion");
                }
                break;
            case DiaconfBtnCan:
                super.vista.DiaConfBd.dispose();
                break;
            //Cierre del control del dialogo de configuración de la base de datos

            //Comienzo del control del dialogo Empresa
            case DiaEmpreGuardar:

                break;
            case DiaEmpreSalir:
                super.vista.DiaDatosEmpresa.dispose();
                break;
            //Cierre del control del dialogo Empresa

            //Comienzo del control del dialogo Incrementar precios
            case DiaIncIncrementar:

                break;
            case DiaIncSalir:
                super.vista.DiaIncrementoPrecios.dispose();
                break;
            //Cierre del control del dialogo Incrementar precios

            //Comienzo del control del dialogo Adminstracion de empleados
            //Cierre del control del dialogo Administracion de empleados
            //Comienzo del control del dialogo Listado de precios
            case DiaPreConsulta:
                break;
            //Cierre del control del dialogo Listado de precios

            //Comienzo del control del dialogo Listado de facturas
            case DiaFacConsulta:
                break;
            //Cierre del control del dialogo Listado de facturas

            //Comienzo del control del dialogo Listado de facturas de clientes
            case DiaCliConsulta:
                break;
            //Cierre del control del dialogo Listado de facturas de clientes

            //Comienzo del control del dialogo Listado de facturacion por empleado
            case DiaEmpConsulta:
                break;
            //Cierre del control del dialogo Listado de facturacion por empleado

            /**
             * En esta seccion controlamos los botones de los paneles
             */
        }
    }
}
