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
        this.listaAccesos = new ArrayList<>();
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

    public ArrayList<Acceso> getAccesos() {
        return listaAccesos;
    }

    public ArrayList<Zona> getZonasAutorizadas() {
        return zonasAutorizadas;
    }

    public void cargaAcceso(Acceso ac) {
        listaAccesos.add(ac);
    }

    public void cargaZonaAutorizada(Zona zona) {
        zonasAutorizadas.add(zona);
    }


    public abstract char tipoPersona();

    public abstract boolean habilitado(Zona zona);//busca en el atributo "zonasHabilitadas" y devuelve si está habilitado (reedefine en cada subclase)

    protected boolean zonaHabilitada(Zona zona) {
        return zonasAutorizadas.contains(zona);
    }

    public String zonaActual() {
        String zonaAct = null;
        for (Acceso acceso : listaAccesos) {
            if (acceso.getEstado()) {
                zonaAct = acceso.getZona().getCodigo();
            }
        }
        System.out.println(zonaAct);
        return zonaAct;
    }

    public void agregaEventoArtista(Evento evento) {
    }

    ;

    public String muestraListaAccesosPersona() {
        StringBuilder sb = new StringBuilder();
        sb.append("Lista de accesos\n");
        for (Acceso acceso : listaAccesos) {
            sb.append("\t").append(acceso.toString()).append("\n");
        }
        return sb.toString();
    }

    public String muestraListaZonasAutorizadasPersona() {
        StringBuilder sb = new StringBuilder();
        sb.append("Lista de zonas autorizadas\n");
        for (Zona zona : zonasAutorizadas) {
            sb.append("\t").append("Id: ").append(zona.getCodigo()).append(" - ").append("Descripción: ").append(zona.getDescripcion()).append("\n");
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return "\n\tId : " + id + " \n\tNombre : " + nombre; /*+ "\n" + muestraListaAccesosPersona() + "\n" + muestraListaZonasAutorizadasPersona()*comento temporalmente para prueba*/
    }

}
