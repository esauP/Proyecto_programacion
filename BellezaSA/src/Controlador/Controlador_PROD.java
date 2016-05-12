/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Modelo_PROD;
import Vista.Interfaz;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

/**
 *
 * @author ESAÚ || MACARENA || SAMUEL
 */
public class Controlador_PROD extends Controlador implements ActionListener, MouseListener {

    Modelo_PROD mo_prod = new Modelo_PROD();

    public Controlador_PROD(Interfaz vista) {
        super(vista);
    }

    public enum AccionMVC {

        //Panel Productos
        AnyadirProd,
        ModificarProd,
        ElminarProd,
        VerProd,
        //Diaolgo Productos
        ProdGuardar,
        ProdCerrar,
    }

    public void Iniciar() {

        //Añadimos la accion de los botones correspondientes al panel Productos
        super.vista.btnAniadeProductos.setActionCommand("AnyadirProd");
        super.vista.btnAniadeProductos.addActionListener(this);
        super.vista.btnModificarProductos.setActionCommand("ModificarProd");
        super.vista.btnModificarProductos.addActionListener(this);
        super.vista.btnEliminarProductos.setActionCommand("EliminarProd");
        super.vista.btnEliminarProductos.addActionListener(this);
        super.vista.btnVerProductos.setActionCommand("VerProd");
        super.vista.btnVerProductos.addActionListener(this);
        //Añadimos la accion de los botones correspondientes al dialogo AñadirProductos
        super.vista.btnGuardarProducto.setActionCommand("ProdGuardar");
        super.vista.btnGuardarProducto.addActionListener(this);
        super.vista.btnSalirProducto.setActionCommand("ProdCerrar");
        super.vista.btnSalirProducto.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (Controlador_PROD.AccionMVC.valueOf(e.getActionCommand())) {
            /**
             *
             */
//Comienzo del control del panel Productos
            case AnyadirProd:
                super.vista.DiaAñadirPro.setSize(770, 650);
                int xpr = (int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 2 - super.vista.DiaAñadirPro.getWidth() / 2);
                int ypr = (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 2 - super.vista.DiaAñadirPro.getHeight() / 2);
                super.vista.DiaAñadirPro.setLocation(xpr, ypr);
                super.vista.DiaAñadirPro.setVisible(true);
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
            //Comienzo del control del dialogo Añadir Productos
            case ProdGuardar:
                this.mo_prod.Insertar();
                break;
            case ProdCerrar:
                super.vista.DiaAñadirPro.dispose();
                break;
            //Cierre del contrl del dialogo Añadir Productos
        }
    }
}
