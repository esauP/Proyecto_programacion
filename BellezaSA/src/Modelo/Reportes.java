/*
 * Clase creada para convertir a pdf
 */
package Modelo;

import java.io.*;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author SAMUEL
 */
public class Reportes {
    public static void main (String[]args) throws FileNotFoundException, JRException{
        InputStream entrada=null;
        AsistenteReports nuevo=new AsistenteReports();
        String master="src/Modelo/report1.jasper";
        
        for(int i=0;i<5;i++){
            pruebaReports asists=new pruebaReports(i,"Asistente de nombre"+i,"apellido"+1,"direccion"+i,"dni"+i);//introduce en el arraylist varios asistentes
            nuevo.addAsistente(asists);
        }
        
        try{
            entrada=new FileInputStream("src/Modelo/report1.jrxml");//el fichero que utilizara el Jreport para convertir
        }catch(FileNotFoundException e){
            JOptionPane.showMessageDialog(null, "Error al abrir el archivo: "+e.getMessage());
        }
        
        try{
            JasperDesign jasper=JRXmlLoader.load(entrada);
            JasperReport jasperito=JasperCompileManager.compileReport(jasper);
            JasperPrint informe = JasperFillManager.fillReport(jasperito, null, nuevo);
            
            JasperExportManager.exportReportToPdfFile(informe, "src/Files/report1.pdf");
        }catch(JRException e){
            JOptionPane.showMessageDialog(null, "Error al cargar el fichero jasper"+e.getMessage());
        }
        try{
            master = "src/Clases/reporte01.jasper";
         
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"error en cargar");
        }
        
//        try{
//            JasperDesign jasper=JRXmlLoader.load(entrada);
//            JasperReport jasperito=JasperCompileManager.compileReport(jasper);
//            JasperPrint informe = JasperFillManager.fillReport(master, null, nuevo);
//            JasperViewer.viewReport(informe, false);
//            JasperExportManager.exportReportToPdfFile(informe, "src/Files/report1.pdf");
//        }catch(JRException e){
//             JOptionPane.showMessageDialog(null,"error mostrar"+e.getMessage());
//        }
    }
    
}
