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

/**
 *
 * @author Usuario
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
        this.vista.GrupoBtnPago.add(this.vista.radioEfectivo);
        this.vista.GrupoBtnPago.add(this.vista.radioTarjeta);
    }

    public enum AccionMVC {

        // Dialogo Añadir Cliente
        CliGuardar,
        CliCerrar,
        //Dialogo Facturar
        FacFacturar,
        FacCerrar,
        //Dialogo Epmpleado
        EmpGuardar,
        EmpCerrar,
        //Diaolgo Productos
        ProdGuardar,
        ProdCerrar,
        //Dialogo Proveedores
        ProvGuardar,
        ProvCerrar,
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
        VerProv
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
        // Añadimos la accion de los botones correspondientes al dialogo añadirClientes
        this.vista.btnGuardarCliente.setActionCommand("CliGuardar");
        this.vista.btnGuardarCliente.addActionListener(this);
        this.vista.btnCancelarCliente.setActionCommand("CliCerrar");
        this.vista.btnCancelarCliente.addActionListener(this);
        //Añadimos la accion de los botones correspondientes al dialogo Facturar
        this.vista.btnFactura.setActionCommand("FacFacturar");
        this.vista.btnFactura.addActionListener(this);
        this.vista.btnCancelarFactura.setActionCommand("FacCerrar");
        this.vista.btnCancelarFactura.addActionListener(this);
        // Añadimos la accion de los botones correspondientes al dialogo AñadirEmpleados
        this.vista.btnGuardarEmpleado.setActionCommand("EmpGuardar");
        this.vista.btnGuardarEmpleado.addActionListener(this);
        this.vista.btnCancelarEmpleado.setActionCommand("EmpCerrar");
        this.vista.btnCancelarEmpleado.addActionListener(this);
        //Añadimos la accion de los botones correspondientes al dialogo AñadirProductos
        this.vista.btnGuardarProducto.setActionCommand("ProdGuardar");
        this.vista.btnGuardarProducto.addActionListener(this);
        this.vista.btnSalirProducto.setActionCommand("ProdCerrar");
        this.vista.btnSalirProducto.addActionListener(this);
        // Añadimos la accion de los botones correspondientes al dialogo AñadirProveedores
        this.vista.btnGuardarProveedor.setActionCommand("ProvGuardar");
        this.vista.btnGuardarProveedor.addActionListener(this);
        this.vista.btnCancelarProveedor.setActionCommand("ProvCerrar");
        this.vista.btnCancelarProveedor.addActionListener(this);
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
            //Comienzo del control del dialogo Añadir Cliente
            case CliGuardar:
                this.mo_cl.Insertar();
                break;
            case CliCerrar:
                this.vista.DiaAñadirCLi.dispose();
                break;
            //Cierre del control del dialogo Añadir Cliente

            //Comienzo del control del Dialogo de configuración de la base de datos
            case AbrirDia:
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
            // Comienzo del control del dialogo AñadirEmpleados
            case EmpGuardar:
                this.mo_em.Insertar();
                break;
            case EmpCerrar:
                this.vista.DiaAñadirEmp.dispose();
            //Cierre del control del dialogo AñadirEmpleados
            //Comienzo del control del panel TPV 
            case Salir:
                System.exit(1);
                break;
            case Facturar:
                this.vista.DiaFactura.setSize(415, 330);
                int xF = (int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 2 - this.vista.DiaFactura.getWidth() / 2);
                int yF = (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 2 - this.vista.DiaFactura.getHeight() / 2);
                this.vista.DiaFactura.setLocation(xF, yF);
                this.vista.DiaFactura.setVisible(true);

                break;
            //Cierre del control del panel TPV
            //Comienzo del control del panel del panel Clientes
            case AnyadirCli:
                this.vista.DiaAñadirCLi.setSize(896, 545);
                int xc = (int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 2 - this.vista.DiaAñadirCLi.getWidth() / 2);
                int yc = (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 2 - this.vista.DiaAñadirCLi.getHeight() / 2);
                this.vista.DiaAñadirCLi.setLocation(xc, yc);
                this.vista.DiaAñadirCLi.setVisible(true);
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
            //Cierre del contrl del panel Clientes
            //Comienzo del control del panel Productos
            case AnyadirProd:
                this.vista.DiaAñadirPro.setSize(713, 587);
                 int xpr = (int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 2 - this.vista.DiaAñadirPro.getWidth() / 2);
                int ypr = (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 2 - this.vista.DiaAñadirPro.getHeight() / 2);
                this.vista.DiaAñadirPro.setLocation(xpr, ypr);
                this.vista.DiaAñadirPro.setVisible(true);
                break;
            case ModificarProd:
                this.mo_prod.Modificar();
                break;
            case ElminarProd:
                this.mo_prod.Eliminar();
                break;
            case VerProd:
                this.mo_prod.Buscar();
                break;
            //Cierre del control del panel Productos

            //Comienzo del control del panel Empleados
            case AnyadirEmp:
                this.vista.DiaAñadirEmp.setSize(1177, 341);
                 int xe = (int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 2 - this.vista.DiaAñadirEmp.getWidth() / 2);
                int ye = (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 2 - this.vista.DiaAñadirEmp.getHeight() / 2);
                this.vista.DiaAñadirEmp.setLocation(xe, ye);
                this.vista.DiaAñadirEmp.setVisible(true);
                break;
            case ModificarEmp:
                this.mo_em.Modificar();
                break;
            case ElminarEmp:
                this.mo_em.Eliminar();
                break;
            case VerEmp:
                this.mo_em.Buscar();
                break;
                //Cierre del control del panel Empleados

            //Comienzo del contol del panel Proveedores
            case AnyadirProv:
                this.vista.DiaAñadirProve.setSize(1177, 378);
                 int xp = (int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 2 - this.vista.DiaAñadirProve.getWidth() / 2);
                int yp = (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 2 - this.vista.DiaAñadirProve.getHeight() / 2);
                this.vista.DiaAñadirProve.setLocation(xp, yp);
                this.vista.DiaAñadirProve.setVisible(true);
                break;
            case ModificarProv:
                this.mo_prov.Modificar();
                break;
            case ElminarProv:
                this.mo_prov.Eliminar();
                break;
            case VerProv:
                this.mo_prov.Buscar();
                break;
            //Cierre del control del panel Proveedores

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
