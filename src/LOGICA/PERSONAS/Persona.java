package LOGICA.PERSONAS;

import LOGICA.ZONAS.Comun;
import LOGICA.ZONAS.Zona;

import java.util.ArrayList;

public abstract class Persona {
        String id;
        String nombre;
        ArrayList<Acceso> accesos;
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
        return accesos;
    }

    public ArrayList<Zona> getZonasAutorizadas() {
        return zonasAutorizadas;
    }

    public void cargaAcceso(Zona zona, String fecha, String hora, int cantidadMinutosPermanencia) {
       Acceso ac=new Acceso(zona,fecha,hora,cantidadMinutosPermanencia,false);
       if ( zona instanceof Comun){
           ac.setEstado(true);
           accesos.add(ac);
       }
    }

    public void cargaZonaAutorizada(Zona zona) {zonasAutorizadas.add(zona);}

    public boolean habilitado(String zonaAVerificar){ return false ;} //busca en el atributo "zonasHabilitadas" y devuelve si está habilitado (reedefine en cada subclase)


}
