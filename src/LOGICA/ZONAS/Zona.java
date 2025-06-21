package LOGICA.ZONAS;

import LOGICA.PERSONAS.Persona;

import java.util.TreeMap;

/**
 * Clase Zona, es una clase abstracta que contiene los metodos necesarios que tienen el resto de clases que heredan de ella
 * tiene un constructor, getCodigo que devuelve el codigo (id) de la zona, setCodigo que carga el codigo de una zona,getConjuntoPersona
 * devuelve una copia del conjunto de personas de la zona, get descripcion devuelve el nombre de la zona, setDescripcion
 * carga el nombre de la zona, tipoZona abstracta, zonaLlena abstracta, concurrencia devuelve la cantidad de personas que
 *  hay en la zona, agregaPersona añade persona a la zona, eliminaPersona saca persona de la zona, cargaEvento añade un evento
 *  MuestraListaPersonasEnZona arma una lista de todas las personas de la zona con sus datos, toString muestra la descripcion
 *  el id y el conjunto de personas de la zona, compareTo compara una zona con otra por cantidad de personas que hay en cada una
 *  se usa para ordenar el listado de zonas por cantidad de personas
 */
public abstract class Zona implements Comparable<Zona>{
    /**
     * identificador unico de la zona
     */
    String codigo;
    /**
     * nombre de la zona
     */
    String descripcion;
    /**
     * personas que estan dentro de la zona
     */
    TreeMap<String, Persona> conjuntoPersona;   //String es el id de persona

    /**
     * constructor de la clase Zona
     * @param codigo
     * @param descripcion
     */
    public Zona(String codigo, String descripcion) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.conjuntoPersona = new TreeMap<String, Persona>();
    }

    /**
     * devuelve el codigo
     * @return el identificador de la zona
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * carga el codigo de la zona
     * @param codigo
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * devuelve el conjunto de personas
     * @return una copia del conjuntoPersona
     */
    public TreeMap<String, Persona> getConjuntoPersona() {
        return conjuntoPersona;
    }

    /**
     * indica la descripcion(nombre) de la zona
     * @return la descripcion de la zona
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * carga la descripcion de la zona
     * @param descripcion
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * clase abstracta de la zona
     * @return null
     */
    public abstract char tipoZona();

    /**
     * clase abstracta de zona llena
     * @return null
     */
    public abstract boolean zonaLlena();

    /**
     * indica la cantidad de personas en la zona
     * @return cantidad de personas en la zona
     */
    public int concurrencia(){return conjuntoPersona.size();}

    /**
     * muestra el codigo y la descripcion de la zona
     */
    public void muestra() {
        System.out.println(codigo);
        System.out.println(descripcion);
    }

    /**
     * agrega una persona a la zona
     * @param per
     */
    public void agregaPersona(Persona per){
        conjuntoPersona.put(per.getId(), per);
    }

    /**
     * elimina una persona de la zona
     * @param idPersona
     */
    public void eliminaPersona(String idPersona) {
        conjuntoPersona.remove(idPersona);
    }

    /**
     * carga un evento
     * @param evento
     */
    public void cargaEvento(Evento evento){};

    /**
     * muestra una lista de personas de la zona
     * @return un texto con todas las personas y sus datos que hay en la zona
     */
    public String muestraListaPersonasEnZona(){
        StringBuilder sb = new StringBuilder();
        sb.append("\nLISTA DE PERSONAS EN ZONA\n");
        for(Persona persona : conjuntoPersona.values()){
            sb.append("\t").append(persona.toString()).append("\n");
        }
        return sb.toString();
    }

    /**
     * toString de la clase
     * @return texto con el codigo, la descripcion y el tipo de la zona
     */
    @Override
    public String toString() {
        return "\nID : " + codigo + "\nDescripcion: " + descripcion + "\nTipo Zona: " + tipoZona() + "\n\t" + muestraListaPersonasEnZona()+ /*lo comente para prueba hasta que carga de datos este completa*/ "\nCantidad de personas en la zona: " + concurrencia();
    }

    /**
     *compara las zonas por la cantidad de gente que hay en cada una
     * @param otra the object to be compared.
     * @return
     */
    @Override
    public int compareTo(Zona otra) {
        return Integer.compare(otra.concurrencia(), this.concurrencia());
    }

}