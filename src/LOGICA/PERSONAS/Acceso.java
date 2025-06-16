package LOGICA.PERSONAS;

import LOGICA.ZONAS.Zona;

import LOGICA.ZONAS.Zona;

import java.time.LocalDate;

public class Acceso{
    Zona zona;
    LocalDate fechaHora;
    int cantidadMinutosPermanencia;
    boolean estado;

    public Acceso(Zona zona, LocalDate fechaHora, int cantidadMinutosPermanencia, boolean estado) {
        this.zona = zona;
        this.fechaHora = fechaHora;
        this.cantidadMinutosPermanencia = cantidadMinutosPermanencia;
        this.estado = estado;
    }


    public boolean getEstado() { return estado; }
    public Zona getZona() { return zona; }
    public LocalDate getFecha() {
        return fechaHora;
    }
    public void setEstado(boolean estado){
        this.estado=estado;
    }

    public int getCantidadMinutosPermanencia() {
        return cantidadMinutosPermanencia;
    }

}
