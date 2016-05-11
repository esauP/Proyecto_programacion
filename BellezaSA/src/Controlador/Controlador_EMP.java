/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.Interfaz;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Usuario
 */
public class Controlador_EMP extends Controlador{

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
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            SwingUtilities.updateComponentTreeUI(vista);
            vista.setVisible(true);
        } catch (UnsupportedLookAndFeelException ex) {
        } catch (ClassNotFoundException ex) {
        } catch (InstantiationException ex) {
        } catch (IllegalAccessException ex) {
        }
        //Añadimos la accion de los botones correspondientes al panel Empleados
        this.vista.btnAniadeEmpleado.setActionCommand("AnyadirEmp");
        this.vista.btnAniadeEmpleado.addActionListener(this);
        this.vista.btnModificarEmpleado.setActionCommand("ModificarEmp");
        this.vista.btnModificarEmpleado.addActionListener(this);
        this.vista.btnEliminarEmpleado.setActionCommand("EliminarEmp");
        this.vista.btnEliminarEmpleado.addActionListener(this);
        this.vista.btnVerEmpleado.setActionCommand("VerEmp");
        this.vista.btnVerEmpleado.addActionListener(this);
        // Añadimos la accion de los botones correspondientes al dialogo AñadirEmpleados
        this.vista.btnGuardarEmpleado.setActionCommand("EmpGuardar");
        this.vista.btnGuardarEmpleado.addActionListener(this);
        this.vista.btnCancelarEmpleado.setActionCommand("EmpCerrar");
        this.vista.btnCancelarEmpleado.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (Controlador_EMP.AccionMVC.valueOf(e.getActionCommand())) {
            /**
             *
             */
 //Comienzo del control del panel Empleados
            case AnyadirEmp:
                this.vista.DiaAñadirEmp.setSize(1200, 380);
                int xem = (int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 2 - this.vista.DiaAñadirEmp.getWidth() / 2);
                int yem = (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 2 - this.vista.DiaAñadirEmp.getHeight() / 2);
                this.vista.DiaAñadirEmp.setLocation(xem, yem);
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
                // Comienzo del control del dialogo Añadir Empleados
            case EmpGuardar:
                this.mo_em.Insertar();
                break;
            case EmpCerrar:
                this.vista.DiaAñadirEmp.dispose();
            //Cierre del control del dialogo Añadir Empleados
        }
    }
}
