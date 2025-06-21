package LOGICA.ZONAS;

import java.io.Serializable;

/**
 * clase Restringida, crea todas las zonas restringidas, tiene un constructor,el metod toString, el metodo tipoZona
 * que devuelve el caracter R para indicar que la zona es Restringida, y el metodo zonaLlena que devuelve true si el conjunto
 * de persona es igual o mayor a la capacidad maxima y false si es menor
 */
public class Restringida extends Zona implements Serializable{

    /**
     * identificador de capacidad ,maxima en las zonas restringidas
     */
    private final int capacidadMaxima = 1000;

    /**
     * constructor de la zona Restringida
     * @param codigo
     * @param descripcion
     */
    public Restringida(String codigo, String descripcion) {
        super(codigo, descripcion);
    }

    /**
     * toString de Restringida
     * @return un texto que muestra la capacidad maxima de la zona
     */
    @Override
    public String toString() {
        return super.toString() +( tipoZona() == 'R'? ("\n  Capacidad máxima: " + capacidadMaxima+"\n\n" ):"\n\n");
    }

    /**
     * devuelve el tipo de zona
     * @return el caracter R para indicar que es zona Restringida
     */
    @Override
    public char tipoZona(){return 'R';}

    /**
     * indica si la zona esta llena
     * @return true si el conjunto de personas es mayor a la capacidad maxima y false si es menor
     */
    @Override
    public boolean zonaLlena(){
        return !(conjuntoPersona.size() < capacidadMaxima);
    }
}
