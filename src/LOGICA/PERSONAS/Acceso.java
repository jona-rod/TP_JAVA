package LOGICA.PERSONAS;

import LOGICA.ZONAS.Zona;

import LOGICA.ZONAS.Zona;

public class Acceso{
    Zona zona;
    String fecha;
    String hora;
    int cantidadMinutosPermanencia;
    boolean estado;

    public Acceso(Zona zona, String fecha, String hora, int cantidadMinutosPermanencia, boolean estado) {
        this.zona = zona;
        this.fecha = fecha;
        this.hora = hora;
        this.cantidadMinutosPermanencia = cantidadMinutosPermanencia;
        this.estado = estado;
    }


    public String getFecha() {
        return fecha;
    }
    public void setEstado(boolean estado){
        this.estado=estado;
    }

    public String getHora() {
        return hora;
    }

    public int getCantidadMinutosPermanencia() {
        return cantidadMinutosPermanencia;
    }

    public boolean isEstado() {
        return estado;
    }
}
