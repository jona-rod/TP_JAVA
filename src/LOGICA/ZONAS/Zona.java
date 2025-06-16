package LOGICA.ZONAS;

import LOGICA.PERSONAS.Persona;

import java.util.TreeMap;

public abstract class Zona {

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

    public int concurrencia(){
        return conjuntoPersona.size();
    }


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

}


