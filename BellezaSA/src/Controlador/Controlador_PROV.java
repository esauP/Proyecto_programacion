/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Modelo_PROV;
import Vista.Interfaz;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

/**
 *
 * @author ESAÚ || MACARENA || SAMUEL
 */
public class Controlador_PROV extends Controlador implements ActionListener, MouseListener {

    Modelo_PROV mo_prov = new Modelo_PROV();

    public Controlador_PROV(Interfaz vista) {
        super(vista);
    }

    public enum AccionMVC {

        //Panel Proveedores

        AnyadirProv,
        ModificarProv,
        ElminarProv,
        VerProv,
        //Dialogo Proveedores
        ProvGuardar,
        ProvCerrar,
    }

    public void Iniciar() {

        //Añadimos la accion de los botones correspondientes al panel Proveedores
        super.vista.btnAniadeProveedores.setActionCommand("AnyadirProv");
        super.vista.btnAniadeProveedores.addActionListener(this);
        super.vista.btnModificaProveedores.setActionCommand("ModificarProv");
        super.vista.btnModificaProveedores.addActionListener(this);
        super.vista.btnEliminarProveedores.setActionCommand("EliminarProv");
        super.vista.btnEliminarProveedores.addActionListener(this);
        super.vista.btnVerProveedores.setActionCommand("VerProv");
        super.vista.btnVerProveedores.addActionListener(this);
        // Añadimos la accion de los botones correspondientes al dialogo AñadirProveedores
        super.vista.btnGuardarProveedor.setActionCommand("ProvGuardar");
        super.vista.btnGuardarProveedor.addActionListener(this);
        super.vista.btnCancelarProveedor.setActionCommand("ProvCerrar");
        super.vista.btnCancelarProveedor.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (Controlador_PROV.AccionMVC.valueOf(e.getActionCommand())) {
            /**
             *
             */
            //Comienzo del contol del panel Proveedores
            case AnyadirProv:
                super.vista.DiaAñadirProve.setSize(1177, 380);
                int xpro = (int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 2 - super.vista.DiaAñadirProve.getWidth() / 2);
                int ypro = (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 2 - super.vista.DiaAñadirProve.getHeight() / 2);
                super.vista.DiaAñadirProve.setLocation(xpro, ypro);
                super.vista.DiaAñadirProve.setVisible(true);
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
            //Comienzo del control del dialogo Añadir Proveedores
            case ProvGuardar:
                this.mo_prov.Insertar();
                break;
            case ProvCerrar:
                super.vista.DiaAñadirProve.dispose();
                break;
            //Cierre del control del dialogo Añadir Proveedores
        }
    }
}
