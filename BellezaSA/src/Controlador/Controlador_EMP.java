/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Modelo_EMP;
import Vista.Interfaz;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

/**
 *
 * @author ESAÚ || MACARENA || SAMUEL
 */
public class Controlador_EMP extends Controlador implements ActionListener, MouseListener {

    Modelo_EMP mo_em = new Modelo_EMP();

    public Controlador_EMP(Interfaz vista) {
        super(vista);
    }

    public enum AccionMVC {

        //Panel Empleados

        AnyadirEmp,
        ModificarEmp,
        ElminarEmp,
        VerEmp,
        //Dialogo Epmpleado
        EmpGuardar,
        EmpCerrar,
    }

    public void Iniciar() {

        //Añadimos la accion de los botones correspondientes al panel Empleados
        super.vista.btnAniadeEmpleado.setActionCommand("AnyadirEmp");
        super.vista.btnAniadeEmpleado.addActionListener(this);
        super.vista.btnModificarEmpleado.setActionCommand("ModificarEmp");
        super.vista.btnModificarEmpleado.addActionListener(this);
        super.vista.btnEliminarEmpleado.setActionCommand("EliminarEmp");
        super.vista.btnEliminarEmpleado.addActionListener(this);
        super.vista.btnVerEmpleado.setActionCommand("VerEmp");
        super.vista.btnVerEmpleado.addActionListener(this);
        // Añadimos la accion de los botones correspondientes al dialogo AñadirEmpleados
        super.vista.btnGuardarEmpleado.setActionCommand("EmpGuardar");
        super.vista.btnGuardarEmpleado.addActionListener(this);
        super.vista.btnCancelarEmpleado.setActionCommand("EmpCerrar");
        super.vista.btnCancelarEmpleado.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (Controlador_EMP.AccionMVC.valueOf(e.getActionCommand())) {
            /**
             *
             */
            //Comienzo del control del panel Empleados
            case AnyadirEmp:
                super.vista.DiaAñadirEmp.setSize(1200, 380);
                int xem = (int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 2 - super.vista.DiaAñadirEmp.getWidth() / 2);
                int yem = (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 2 - super.vista.DiaAñadirEmp.getHeight() / 2);
                super.vista.DiaAñadirEmp.setLocation(xem, yem);
                super.vista.DiaAñadirEmp.setVisible(true);
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
            // Comienzo del control del dialogo Añadir Empleados
            case EmpGuardar:
                this.mo_em.Insertar();
                break;
            case EmpCerrar:
                super.vista.DiaAñadirEmp.dispose();
            //Cierre del control del dialogo Añadir Empleados
        }
    }
}
