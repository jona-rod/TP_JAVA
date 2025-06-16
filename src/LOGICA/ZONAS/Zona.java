package LOGICA.ZONAS;

import LOGICA.PERSONAS.Persona;

import java.util.TreeMap;

public abstract class Zona implements Comparable<Zona>{

    String codigo;
    String descripcion;
    TreeMap<String, Persona> conjuntoPersona;   //String es el id de persona


    public Zona(String codigo, String descripcion) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.conjuntoPersona = new TreeMap<String, Persona>();
    }


    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public TreeMap<String, Persona> getConjuntoPersona() {
        return conjuntoPersona;
    }

    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public abstract char tipoZona();

    public abstract boolean zonaLlena();

    public int concurrencia(){return conjuntoPersona.size();}


    public void muestra() {
        System.out.println(codigo);
        System.out.println(descripcion);
    }

    public void agregaPersona(Persona per){
        conjuntoPersona.put(per.getId(), per);
    }

    public void eliminaPersona(String idPersona) {
        conjuntoPersona.remove(idPersona);
    }

    public void cargaEvento(Evento evento){};

    public String muestraListaPersonasEnZona(){
        StringBuilder sb = new StringBuilder();
        sb.append("LISTA DE PERSONAS EN ZONA\n");
        for(Persona persona : conjuntoPersona.values()){
            sb.append("\t").append(persona.toString()).append("\n");
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return "ID : " + codigo + "\n Descripcion: " + descripcion + "\n Tipo Zona: " + tipoZona() + "\n" + muestraListaPersonasEnZona() + "\nCantidad de personas en la zona: " + concurrencia();
    }

    @Override
    public int compareTo(Zona otra) {
        return Integer.compare(otra.concurrencia(), this.concurrencia());
    }

}


