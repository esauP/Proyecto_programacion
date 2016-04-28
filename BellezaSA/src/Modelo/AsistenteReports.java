/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;


import java.util.ArrayList;
import java.util.List;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

/**
 *
 * @author SAMUEL
 */
public class AsistenteReports implements JRDataSource {

    private List<pruebaReports> lista = new ArrayList<pruebaReports>();
    private int indiceActual = -1;
    /**
     * Metodo que hereda de la interfaz que va leyendo los datos de una coleccion
     * @throws JRException 
     * @return Retorna true o false si indiceActual+1 es mayor del tamaño del arrayList
     */
    @Override
    public boolean next() throws JRException {
        return ++indiceActual < lista.size();//Va sumando 1 al indice que toma las posiciones en el arraylist
    }
    /**
     *@param prueba introduce nuevos asistentes en el arraylist
     */
    public void addAsistente(pruebaReports prueba) {
        this.lista.add(prueba);
    }
    /**
     * @param jrf recoge los elmentos que estan diseñados en el reporte si se llaman como el atributo de la clase 
     * pruebaReports recoge la posicion del arraylist y el atributo que le pertenezca
     * @return retorna el valor del objeto String o Integer ...
     * @throws JRException
     */
    @Override
    public Object getFieldValue(JRField jrf) throws JRException {
        Object valor = null;

        if ("id".equals(jrf.getName())) {
            valor = lista.get(indiceActual).getId();//To change body of generated methods, choose Tools | Templates.
        } else if ("nombre".equals(jrf.getName())) {
            valor = lista.get(indiceActual).getNombre();
        } else if ("apellido".equals(jrf.getName())) {
            valor = lista.get(indiceActual).getApellido();
        }else if("dni".equals(jrf.getName())){
            valor= lista.get(indiceActual).getDni();
        }
        return valor;
    }
}
