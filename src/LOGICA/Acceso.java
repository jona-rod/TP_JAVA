package LOGICA;

public class Acceso{
    String zona;
    String fecha;
    String hora;
    int cantidadMinutosPermanencia;
    boolean estado;

    public Acceso(String zona, String fecha, String hora, int cantidadMinutosPermanencia, boolean estado) {
        this.zona = zona;
        this.fecha = fecha;
        this.hora = hora;
        this.cantidadMinutosPermanencia = cantidadMinutosPermanencia;
        this.estado = estado;
    }

    public String getZona() {
        return zona;
    }

    public String getFecha() {
        return fecha;
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
