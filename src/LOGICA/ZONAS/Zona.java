package LOGICA.ZONAS;

import LOGICA.PERSONAS.Persona;

import java.io.Serializable;
import java.util.TreeMap;

public abstract class Zona implements Comparable<Zona>, Serializable {

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
        sb.append("\n\tLISTA DE PERSONAS\n\t----------------\n\n");
        for(Persona persona : conjuntoPersona.values()){
            sb.append(persona.muestraPersonaListado()).append("\n");
        }
        return sb.toString();
    }


    @Override
    public String toString() {
        String tz;
        char tipoZona = tipoZona();
        if(tipoZona == 'C'){
            tz = "Común";
        }else if(tipoZona == 'E'){
            tz = "Escenario";
        }else if(tipoZona == 'R'){
            tz = "Restringida";
        }else{
            tz = "Stand";
        }

        return "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n"+
               "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n\n"+

                "  ID DE ZONA : " + codigo + "\n\n  DESCRIPCIÓN : " + descripcion + "\n\n  Tipo Zona: " + tz + "\n\n" + muestraListaPersonasEnZona()+ "\n  Cantidad de personas : " + concurrencia()+"\n";
    }

    @Override
    public int compareTo(Zona otra) {
        return Integer.compare(otra.concurrencia(), this.concurrencia());
    }

}


