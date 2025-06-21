package LOGICA.PERSONAS;

import LOGICA.ZONAS.Zona;

import LOGICA.ZONAS.Zona;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Acceso implements Serializable {
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
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return "Id: " + zona.getCodigo() + "\t "+ "Descripcion: " + zona.getDescripcion() + "\t "+"Fecha y hora: "+ fechaHora.format(formato).toString()+ "\t " + "Permanencia: "+ cantidadMinutosPermanencia + " minutos\t " +"Estado: " + (estado?"HABILITADO":"DENEGADO");
    }

}
