package LOGICA.PERSONAS;

import LOGICA.ZONAS.Zona;

import LOGICA.ZONAS.Zona;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * clase Acceso, agrega los accesos de la personas a cada zona del festival, tiene un constructor, getEstado devuelve si el
 * acceso fue aceptado, getZona devuelve la zona del acceso,getFecha devuelve la fecha en la que se hizo el acceso, setEstado
 * carga el estado, getCantidadMinutosPermanencia devuelve el tiempo que estuvo en la zona, toString de la zona
 */
public class Acceso implements Serializable{

    /**
     * zona en la que es el acceso
     */
    Zona zona;
    /**
     * fecha y hora en la que se hace el acceso
     */
    LocalDateTime fechaHora;
    /**
     * minutos que esta en la zona
     */
    int cantidadMinutosPermanencia;
    /**
     * se hizo o no se hizo el acceso
     */
    boolean estado;

    /**
     * constructor de la clase Acceso
     * @param zona
     * @param fechaHora
     * @param cantidadMinutosPermanencia
     * @param estado
     */
    public Acceso(Zona zona, LocalDateTime fechaHora, int cantidadMinutosPermanencia, boolean estado) {
        this.zona = zona;
        this.fechaHora = fechaHora;
        this.cantidadMinutosPermanencia = cantidadMinutosPermanencia;
        this.estado = estado;
    }

    /**
     * devuelve el estado del acceso
     * @return true o false
     */
    public boolean getEstado() { return estado; }

    /**
     * devuelve la zona del acceso
     * @return zona del acceso
     */
    public Zona getZona() { return zona; }

    /**
     * devuelve la fecha del acceso
     * @return fecha del acceso
     */
    public LocalDateTime getFecha() {
        return fechaHora;
    }

    public void setFecha(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    /**
     * carga el estado del acceso
     * @param estado
     */
    public void setEstado(boolean estado){
        this.estado=estado;
    }

    /**
     * devuelve los minutos que estuvo en la zona
     * @return minutos de permanencia
     */
    public int getCantidadMinutosPermanencia() {
        return cantidadMinutosPermanencia;
    }

    /**
     * toString de la clase
     * @return texto con el id de la zona, el nombre de la zona, la fecha y hora del acceso, los minutos de permanencia en la zona
     * y el estado del acceso
     */
    @Override
    public String toString() {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return "Id: " + zona.getCodigo() + "\t "+ "Descripcion: " + zona.getDescripcion() + "\t "+"Fecha y hora: "+ fechaHora.format(formato).toString()+ "\t " + "Permanencia: "+ cantidadMinutosPermanencia + " minutos\t " +"Estado: " + (estado?"HABILITADO":"DENEGADO");
    }

}
