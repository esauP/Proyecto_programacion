/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Modelo_BD;
import Modelo.Modelo_CLI;
import Modelo.Modelo_EMP;
import Modelo.Modelo_PROD;
import Modelo.Modelo_PROV;
import Modelo.Modelo_TPV;
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
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ESAÚ || MACARENA || SAMUEL
 */
public class Controlador implements ActionListener, MouseListener {

    Interfaz vista;
    Modelo_BD mo_bd = new Modelo_BD();
    Modelo_TPV mo_tp = new Modelo_TPV();
    Modelo_CLI mo_cl = new Modelo_CLI();
    Modelo_EMP mo_em = new Modelo_EMP();
    Modelo_PROD mo_prod = new Modelo_PROD();
    Modelo_PROV mo_prov = new Modelo_PROV();

    public Controlador(Interfaz vista) {
        this.vista = vista;
        //Asignamos los radioButton a su grupo correspondiente
        this.vista.GrupoBtnPago.add(this.vista.radioEfectivo);
        this.vista.GrupoBtnPago.add(this.vista.radioTarjeta);

        this.vista.GrupoBtnIncrementa.add(this.vista.radioCantidad);
        this.vista.GrupoBtnIncrementa.add(this.vista.radioPorcentaje);
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

        /**
         * Seccion de Menu bar y menu item
         */
        // Configuracion Base de datos
        this.vista.menuConexion.setActionCommand("AbrirDiaConf");
        this.vista.menuConexion.addActionListener(this);
        //Menu Archivo
        this.vista.menuIncPrecio.setActionCommand("AbrirDiaIncre");
        this.vista.menuIncPrecio.addActionListener(this);
        this.vista.menuEmpresa.setActionCommand("AbrirDiaEmpresa");
        this.vista.menuEmpresa.addActionListener(this);
        this.vista.menuAdminEmp.setActionCommand("AbrirDiaAdmin");
        this.vista.menuAdminEmp.addActionListener(this);
        this.vista.menuSalir.setActionCommand("Salir");
        this.vista.menuSalir.addActionListener(this);
        //Menu Listados
        this.vista.menuLisPrecio.setActionCommand("AbrirLisPrecio");
        this.vista.menuLisPrecio.addActionListener(this);
        this.vista.menuLisEmpleado.setActionCommand("AbrirLisFacEmple");
        this.vista.menuLisEmpleado.addActionListener(this);
        this.vista.menuLisClientes.setActionCommand("AbrirLisFacCli");
        this.vista.menuLisClientes.addActionListener(this);
        this.vista.menuLisFacturas.setActionCommand("AbrirLisFactura");
        this.vista.menuLisFacturas.addActionListener(this);
        /**
         * Seccion de los botones de los dialogos
         */
        // Añadimos la accion de los botones correspondientes al dialogo para la configuración de la base de datos
        this.vista.BtnDiaConGuar.setActionCommand("DiaconfBtnGua");
        this.vista.BtnDiaConGuar.addActionListener(this);
        this.vista.BtnDiaConCan.setActionCommand("DiaconfBtnCan");
        this.vista.BtnDiaConCan.addActionListener(this);
      
        
        
       
        
        //Añadimos la accion de los botones correspondientes al dialogo Datos de la empresa
        this.vista.btnGuardarEmpresa.setActionCommand("DiaEmpreConsulta");
        this.vista.btnGuardarEmpresa.addActionListener(this);
        this.vista.btnSalirEmpresa.setActionCommand("DiaEmpreSalir");
        this.vista.btnSalirEmpresa.addActionListener(this);
        //Añadimos la accion de los botones correspondienetes al dialogo Incrementa Precios
        this.vista.btnIncrementar.setActionCommand("DiaIncIncrementar");
        this.vista.btnIncrementar.addActionListener(this);
        this.vista.btnSalirIncremento.setActionCommand("DiaIncSalir");
        this.vista.btnSalirIncremento.addActionListener(this);
        //Añadimos la accion de los botones correspondientes al dialogo Adminstracion Empleados

        //Añadimos la accion de los botones correspondientes al dialogo Listado Precios
        this.vista.btnPrecios.setActionCommand("DiaPreConsulta");
        this.vista.btnPrecios.addActionListener(this);
        //Añadimos la accion de los botones correspondientes al dialogo Listado Facturas Empresa
        this.vista.btnFacturaEmpresa.setActionCommand("DiaFacConsulta");
        this.vista.btnFacturaEmpresa.addActionListener(this);
        //Añadimos la accion de los botones correspondientes al dialogo Listado Facturas Empleados
        this.vista.btnFacturaEmpleado.setActionCommand("DiaFacEmpleado");
        this.vista.btnFacturaEmpleado.addActionListener(this);
        //Añadimos la accion de los botones correspondientes al dialogo Listado Facturas Cliente
        this.vista.btnFacturaCliente.setActionCommand("DiaFacCliente");
        this.vista.btnFacturaCliente.addActionListener(this);
        /**
         * Seccion de los botones de los paneles
         */

       
        
        
       
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (AccionMVC.valueOf(e.getActionCommand())) {
            /**
             * En esta seccion controlamos el menu bar y sus menu item
             */
            // Incio del control del Menu item Configuracion de la base de datos
            case AbrirDiaConf:
                this.vista.DiaConfBd.setSize(360, 230);
                int xB = (int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 2 - this.vista.DiaConfBd.getWidth() / 2);
                int yB = (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 2 - this.vista.DiaConfBd.getHeight() / 2);
                this.vista.DiaConfBd.setLocation(xB, yB);

                String[] temp = null;

                try {
                    temp = this.mo_bd.GetBdconf();

                } catch (IOException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
                this.vista.TxtDiaIP.setText(temp[0]);
                this.vista.TxtDiaUsu.setText(temp[1]);
                this.vista.TxtDiaPass.setText(temp[2]);
                this.vista.DiaConfBd.setVisible(true);
                break;
            // Cierre del control del Menu item Configuracion de la base de datos
            // Incio del control del Menu item Datos de la Empresa
            case AbrirDiaEmpresa:
                this.vista.DiaDatosEmpresa.setSize(570, 450);
                int xe = (int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 2 - this.vista.DiaDatosEmpresa.getWidth() / 2);
                int ye = (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 2 - this.vista.DiaDatosEmpresa.getHeight() / 2);
                this.vista.DiaDatosEmpresa.setLocation(xe, ye);
                this.vista.DiaDatosEmpresa.setVisible(true);
                break;
            // Cierre del control del Menu item Datos de la Empresa
            // Incio del control del Menu item Incremento de Precio
            case AbrirDiaIncre:
                this.vista.DiaIncrementoPrecios.setSize(590, 300);
                int xp = (int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 2 - this.vista.DiaIncrementoPrecios.getWidth() / 2);
                int yp = (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 2 - this.vista.DiaIncrementoPrecios.getHeight() / 2);
                this.vista.DiaIncrementoPrecios.setLocation(xp, yp);
                this.vista.DiaIncrementoPrecios.setVisible(true);
                break;
            // Cierre del control del Menu item Incremento de precio
            // Incio del control del Menu item Administracion de empleados
            case AbrirDiaAdmin:
                this.vista.DiaAdministracionEmpleados.setSize(570, 330);
                int xa = (int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 2 - this.vista.DiaAdministracionEmpleados.getWidth() / 2);
                int ya = (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 2 - this.vista.DiaAdministracionEmpleados.getHeight() / 2);
                this.vista.DiaAdministracionEmpleados.setLocation(xa, ya);
                this.vista.DiaAdministracionEmpleados.setVisible(true);
                break;
            // Cierre del control del Menu item Administracion de empleados
            // Incio del control del Menu item Listado de precios
            case AbrirLisPrecio:
                this.vista.DiaListaPrecios.setSize(340, 170);
                int xls = (int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 2 - this.vista.DiaListaPrecios.getWidth() / 2);
                int yls = (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 2 - this.vista.DiaListaPrecios.getHeight() / 2);
                this.vista.DiaListaPrecios.setLocation(xls, yls);
                this.vista.DiaListaPrecios.setVisible(true);
                break;
            // Cierre del control del Menu item Listado de precios
            // Incio del control del Menu item Administracion de empleados
            case AbrirLisFactura:
                this.vista.DiaListaFacturas.setSize(370, 140);
                int xlf = (int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 2 - this.vista.DiaListaFacturas.getWidth() / 2);
                int ylf = (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 2 - this.vista.DiaListaFacturas.getHeight() / 2);
                this.vista.DiaListaFacturas.setLocation(xlf, ylf);
                this.vista.DiaListaFacturas.setVisible(true);
                break;
            // Cierre del control del Menu item Administracion de empleados
            // Incio del control del Menu item Administracion de empleados
            case AbrirLisFacCli:
                this.vista.DiaFacturaCliente.setSize(390, 260);
                int xfc = (int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 2 - this.vista.DiaFacturaCliente.getWidth() / 2);
                int yfc = (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 2 - this.vista.DiaFacturaCliente.getHeight() / 2);
                this.vista.DiaFacturaCliente.setLocation(xfc, yfc);
                this.vista.DiaFacturaCliente.setVisible(true);
                break;
            // Cierre del control del Menu item Administracion de empleados
            // Incio del control del Menu item Administracion de empleados
            case AbrirLisFacEmple:
                this.vista.DiaFacturaEmpleado.setSize(450, 280);
                int xfe = (int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 2 - this.vista.DiaFacturaEmpleado.getWidth() / 2);
                int yfe = (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 2 - this.vista.DiaFacturaEmpleado.getHeight() / 2);
                this.vista.DiaFacturaEmpleado.setLocation(xfe, yfe);
                this.vista.DiaFacturaEmpleado.setVisible(true);
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
                ip = this.vista.TxtDiaIP.getText();
                usu = this.vista.TxtDiaUsu.getText();
                pass = this.vista.TxtDiaPass.getText();
                if (!ip.isEmpty() || !usu.isEmpty() || !pass.isEmpty()) {
                    this.mo_bd.EscribeBdconf(ip, usu, pass);
                    this.vista.DiaConfBd.dispose();
                } else {
                    JOptionPane.showMessageDialog(vista, "Debe introducir Datos para poder guardarlos en el fichero de configuracion");
                }
                break;
            case DiaconfBtnCan:
                this.vista.DiaConfBd.dispose();
                break;
            //Cierre del control del dialogo de configuración de la base de datos
            
            
            
           
            //Comienzo del control del dialogo Empresa
            case DiaEmpreGuardar:

                break;
            case DiaEmpreSalir:
                this.vista.DiaDatosEmpresa.dispose();
                break;
            //Cierre del control del dialogo Empresa
                
            //Comienzo del control del dialogo Incrementar precios
            case DiaIncIncrementar:

                break;
            case DiaIncSalir:
                this.vista.DiaIncrementoPrecios.dispose();
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

    @Override
    public void mouseClicked(MouseEvent e) {
//        if (e.getButton() == 1)//boton izquierdo
//        {
//            int fila = this.vista.Tabla.rowAtPoint(e.getPoint());
//            if (fila > -1) {
//                id = (String.valueOf(this.vista.Tabla.getValueAt(fila, 0)));
//                this.vista.txtNombre.setText(String.valueOf(this.vista.Tabla.getValueAt(fila, 1)));
//                this.vista.txtApaterno.setText(String.valueOf(this.vista.Tabla.getValueAt(fila, 2)));
//                this.vista.txtAmaterno.setText(String.valueOf(this.vista.Tabla.getValueAt(fila, 3)));
//                this.vista.txtemail.setText(String.valueOf(this.vista.Tabla.getValueAt(fila, 4)));
//            }
//        }
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
