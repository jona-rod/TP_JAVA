package LOGICA.ZONAS;

import java.util.Comparator;

/***
 * clase Stand, se encarga de crear los distintos stands que estan en las zonas comunes, cuenta con un constructor, un
 * metodo getUbicacion que devuelve la ubicacion del stand, setUbicacion que carga la ubicacion del stand, getResponsable
 * que devuelve la persona responsable del stand, setResponsable que carga el responsable del stand, toString que devuelve
 * un texto con la ubicacion y el responsable, zonaLlena que devuelve si la zona esta llena, y tipo de zona que devuelve una
 * S para indicar que la zona es un Stand
 */
public class Stand extends Restringida{
    /**
     * tiene el id de la zona comun donde esta el stand
     */
    String ubicacion;
    /**
     * tiene nombre de la persona responsable
     */
    String responsable="";

    /**
     * constructor de la clase Stand
     * @param codigo
     * @param descripcion
     * @param ubicacion
     */
    public Stand(String codigo, String descripcion, String ubicacion) {
        super(codigo,descripcion);
        this.ubicacion = ubicacion; //agrego asignacion faltante
    }

    /**
     * devuelve la ubicacion del stand
     * @return el id de la zona en la que esta el stand
     */
    public String getUbicacion(){ return ubicacion; }

    /**
     * carga la ubicacion
     * @param ubicacion
     */
    public void setUbicacion(String ubicacion){this.ubicacion = ubicacion;}

    /**
     * devuelve el responsable del stand
     * @return el nombre del responsable del stand
     */
    public String getResponsable(){ return responsable; }

    /**
     * carga el responsble del stand
     * @param responsable
     */
    public void setResponsable(String responsable){this.responsable = responsable;}

    /**
     * compara por el nombre de los responsables para ordenar el listando en orden alfabetico
     */
    public static final Comparator<Stand> POR_RESPONSABLE =
            Comparator.comparing(Stand::getResponsable, String.CASE_INSENSITIVE_ORDER);

    /**
     * toString de zona stand
     * @return texto con la ubicacion de la zona, nombre del responsable
     */
    @Override
    public String toString() {
        return super.toString()+"\nUbicacion:  "+getUbicacion()+"\nResponsable: "+ (responsable!=null?responsable.toString():"no tiene responsable");
    }

    /**
     * indica si la zona esta llena
     * @return devuelve true si el conjunto de personas es mayor a 5, false si es menor a 5
     */
    @Override
    public boolean zonaLlena(){
        return !(conjuntoPersona.size() < 5);
    }

    /**
     * indica el tipo de la zona
     * @return S indicando que la zona es Stand
     */
    @Override
    public char tipoZona(){return 'S';} //faltaba redefinir el metodo
}
