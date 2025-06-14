package LOGICA.PERSONAS;

import LOGICA.PERSONAS.Acceso;
import LOGICA.ZONAS.Comun;
import LOGICA.ZONAS.Zona;

import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Persona {
        String id;
        String nombre;
        ArrayList<Acceso> listaAccesos;
        ArrayList<Zona> zonasAutorizadas;
        String idZonaActual;

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

    public void muestraDatos(){
        System.out.println(id);
        System.out.println(nombre);
        muestraAccesos();
    }

    public ArrayList<Acceso> getAccesos() {
        return accesos;
    }

    public ArrayList<Zona> getZonasAutorizadas() {
        return zonasAutorizadas;
    }

    public void cargaAcceso(Acceso ac) {
        listaAccesos.add(ac);
    }

    public abstract char tipoPersona();

    public void cargaZonaAutorizada(Zona zona) {zonasAutorizadas.add(zona);}

    public boolean habilitado(Zona zona){ return false ;} //busca en el atributo "zonasHabilitadas" y devuelve si está habilitado (reedefine en cada subclase)

    public void muestraAccesos(){
        zonasAutorizadas.forEach(zona->{
            zona.muestra();
        });
    }

    public String getIdZonaActual() {
        return idZonaActual;
    }
    public void setIdZonaActual(String idZonaActual) {
        this.idZonaActual = idZonaActual;
    }
}
