/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Modelo_TPV;
import Vista.Interfaz;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author  ESAÚ || MACARENA || SAMUEL
 */
public class Controlador_TPV extends Controlador implements ActionListener, MouseListener {

    Modelo_TPV mo_tp = new Modelo_TPV();

    public Controlador_TPV(Interfaz vista) {
        super(vista);
    }

    public enum AccionMVC {

        //Panel Tpv
        Salir,
        Facturar,
        Limpiar,
         //Dialogo Facturar
        FacFacturar,
        FacCerrar,
        //Panel Facturas
        VerFac
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
        //Añadimos la accion de los botones coorespondientes al panel TPV
        super.vista.btnSalirTPV.setActionCommand("Salir");
        super.vista.btnSalirTPV.addActionListener(this);       
        super.vista.btnFacturarTPV.setActionCommand("Facturar");
        super.vista.btnFacturarTPV.addActionListener(this);
        super.vista.btnAniadirCliente.setActionCommand("AnyadirCli");
        super.vista.btnAniadirCliente.addActionListener(this);
        super.vista.btnLimpiar.setActionCommand("Limpiar");
        super.vista.btnLimpiar.addActionListener(this);
        //Añadimos la acccion de los botones correspondientes al panel Facturas
        super.vista.btnDevolucion.setActionCommand("VerFac");
        super.vista.btnDevolucion.addActionListener(this);
        //Añadimos la accion de los botones correspondientes al dialogo Facturar
        super.vista.btnFactura.setActionCommand("FacFacturar");
        super.vista.btnFactura.addActionListener(this);
        super.vista.btnCancelarFactura.setActionCommand("FacCerrar");
        super.vista.btnCancelarFactura.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (Controlador_TPV.AccionMVC.valueOf(e.getActionCommand())) {
            /**
             *
             */
            //Comienzo del control del panel TPV 
            case Salir:
                System.exit(1);
                break;
            case Facturar:
                super.vista.DiaFactura.setSize(415, 330);
                int xF = (int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 2 - super.vista.DiaFactura.getWidth() / 2);
                int yF = (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 2 - super.vista.DiaFactura.getHeight() / 2);
                super.vista.DiaFactura.setLocation(xF, yF);
                super.vista.DiaFactura.setVisible(true);
                break;
            case Limpiar:
                super.vista.tablaFacturacion.setModel(new DefaultTableModel());
                break;
            //Cierre del control del panel TPV
                //Comienzo del control del panel Facturas
            case VerFac:
                super.vista.DiaDevolucion.setSize(500, 500);
                int xdev = (int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 2 - super.vista.DiaDevolucion.getWidth() / 2);
                int ydev = (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 2 - super.vista.DiaDevolucion.getHeight() / 2);
                super.vista.DiaDevolucion.setLocation(xdev, ydev);
                super.vista.DiaDevolucion.setVisible(true);

            //Cierre dle control del panel Facturas
                //Comienzo del control del dialogo de Facturacion
            case FacCerrar:
                super.vista.DiaFactura.dispose();
                break;
            //Cierre del control del dialogo de Facturacion
        }
    }
}
