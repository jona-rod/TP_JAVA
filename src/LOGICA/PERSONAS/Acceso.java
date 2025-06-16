package LOGICA.PERSONAS;

import LOGICA.ZONAS.Zona;

import LOGICA.ZONAS.Zona;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Acceso{
    Zona zona;
    LocalDateTime fechaHora;
    int cantidadMinutosPermanencia;
    boolean estado;

    public Acceso(Zona zona, LocalDateTime fechaHora, int cantidadMinutosPermanencia, boolean estado) {
        this.zona = zona;
        this.fechaHora = fechaHora;
        this.cantidadMinutosPermanencia = cantidadMinutosPermanencia;
        this.estado = estado;
    }


    public boolean getEstado() { return estado; }
    public Zona getZona() { return zona; }
    public LocalDateTime getFecha() {
        return fechaHora;
    }
    public void setEstado(boolean estado){
        this.estado=estado;
    }

    public int getCantidadMinutosPermanencia() {
        return cantidadMinutosPermanencia;
    }

    @Override
    public String toString() {
        return "Id: " + zona.getCodigo() + " - "+ "Descripcion: " + zona.getDescripcion() + " - "+"Fecha y hora: "+ fechaHora.toString()+ " - " + "Permanencia: "+ cantidadMinutosPermanencia + " - " +"Estado: " + estado;
    }

}
