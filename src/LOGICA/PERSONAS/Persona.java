package LOGICA.PERSONAS;

import LOGICA.PERSONAS.Acceso;
import LOGICA.ZONAS.Comun;
import LOGICA.ZONAS.Evento;
import LOGICA.ZONAS.Zona;

import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Persona {
        String id;
        String nombre;
        ArrayList<Acceso> listaAccesos;
        ArrayList<Zona> zonasAutorizadas;

    public Persona(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
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

    public ArrayList<Acceso> getAccesos() {
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
        for(Acceso acceso : listaAccesos){
            if(acceso.getEstado()){
                return acceso.getZona().getCodigo();
            }
        }
        return null;
    }

    public void agregaEventoArtista(Evento evento){};

}
