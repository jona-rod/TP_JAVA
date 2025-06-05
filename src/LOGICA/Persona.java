package LOGICA;

import java.util.ArrayList;

public abstract class Persona {
        String id;
        String nombre;
        ArrayList<Acceso> accesos;
        ArrayList<String> zonasAutorizadas;

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

    public ArrayList<String> getZonasAutorizadas() {
        return zonasAutorizadas;
    }

    public void cargaAcceso(String zona, String fecha, String hora, int cantidadMinutosPermanencia, boolean estado) {
        accesos.add(new Acceso(zona,fecha,hora,cantidadMinutosPermanencia,estado));
    }

    public void cargaZonaAutorizada(String zona) {
        zonasAutorizadas.add(zona);
    }

    public boolean habilitado(String zonaAVerificar){} //busca en el atributo "zonasHabilitadas" y devuelve si está habilitado (reedefine en cada subclase)


}
