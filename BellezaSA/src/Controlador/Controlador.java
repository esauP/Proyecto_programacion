/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.Interfaz;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author ESAÚ || MACARENA || SAMUEL
 */
public class Controlador implements ActionListener, MouseListener {

    Interfaz vista;
    Controlador_TPV ctpv;
    Controlador_CLI ccli;
    Controlador_EMP cemp;
    Controlador_MENU cmen;
    Controlador_PROD cprod;
    Controlador_PROV cprov;

    public Controlador(Interfaz vista) {
        this.vista = vista;
        //Asignamos los radioButton a su grupo correspondiente
        this.vista.GrupoBtnPago.add(this.vista.radioEfectivo);
        this.vista.GrupoBtnPago.add(this.vista.radioTarjeta);

        this.vista.GrupoBtnIncrementa.add(this.vista.radioCantidad);
        this.vista.GrupoBtnIncrementa.add(this.vista.radioPorcentaje);
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

        

        ctpv.Iniciar();

        ccli.Iniciar();
        cemp.Iniciar();
        cprod.Iniciar();
        cprov.Iniciar();
        cmen.Iniciar();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
     
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
