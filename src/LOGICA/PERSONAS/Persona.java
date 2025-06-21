package LOGICA.PERSONAS;

import LOGICA.PERSONAS.Acceso;
import LOGICA.ZONAS.Comun;
import LOGICA.ZONAS.Evento;
import LOGICA.ZONAS.Zona;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashSet;

public abstract class Persona implements Serializable {
        String id;
        String nombre;
        LinkedHashSet<Acceso> listaAccesos;
        ArrayList<Zona> zonasAutorizadas;

    public Persona(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.listaAccesos = new LinkedHashSet<>();
        this.zonasAutorizadas = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LinkedHashSet<Acceso> getListaAccesos() {
        return listaAccesos;
    }

    public ArrayList<Zona> getZonasAutorizadas() {
        return zonasAutorizadas;
    }

    public void cargaAcceso(Acceso ac) {
        listaAccesos.add(ac);
    }

    public void cargaZonaAutorizada(Zona zona) {zonasAutorizadas.add(zona);}


    public abstract char tipoPersona();

    public abstract boolean habilitado(Zona zona);//busca en el atributo "zonasHabilitadas" y devuelve si está habilitado (reedefine en cada subclase)

    protected boolean zonaHabilitada(Zona zona){
        return zonasAutorizadas.contains(zona);
    };

    public String zonaActual(){
        for(Acceso acceso : listaAccesos.reversed()){
            if(acceso.getEstado()){
                return acceso.getZona().getCodigo();
            }
        }
        return null;
    }

   //1 public void agregaEventoArtista(Evento evento) {
    //}

    public void agregaEventoArtista(Evento evento){};

    public String muestraListaAccesosPersona(){
        StringBuilder sb = new StringBuilder();
        sb.append("\t Lista de accesos\n\t -------------\n\n");
        for(Acceso acceso : listaAccesos.reversed()){
            sb.append("\t ").append(acceso.toString()).append("\n\n");
        }
        return sb.toString();
    }

    public String muestraListaZonasAutorizadasPersona(){
        StringBuilder sb = new StringBuilder();
        sb.append("\t Lista de zonas autorizadas\n\t ---------------------\n\n");
        for(Zona zona : zonasAutorizadas){
            sb.append("\t ").append("Id: ").append(zona.getCodigo()).append("\t  ").append("Descripción: ").append(zona.getDescripcion()).append("\n\n");
        }
        sb.append("\n..........................................................................................................................................................................................................................................................................\n\n");
        return sb.toString();
    }

    public String muestraPersonaListado(){
        return  "\t ID : " + id + "\t\t Nombre : " + nombre + "\n\n";
    }

    @Override
    public String toString() {

        return "..........................................................................................................................................................................................................................................................................\n\n" +
                 " ID : " + id + "\n \n Nombre : " + nombre + "\n\n" +
                "\n..........................................................................................................................................................................................................................................................................\n\n" +
                muestraListaAccesosPersona()+
                "\n..........................................................................................................................................................................................................................................................................\n\n" +
                muestraListaZonasAutorizadasPersona();
    }

}
