package logica.zonas;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


/**
 * Clase Evento, se encarga de crear los eventos de todos los escenarios, tiene un constructor, un metodo getFechaHora que
 * devuelve la fecha y la hora de un determinado evento, un getArtista que devuelve el artista que toca, y un toString
 * que muestra el artista y fecha y hora en la que es el evento
 */
public class Evento implements Serializable {
    /**
     * fecha y hora del evento
     */
    LocalDateTime fechaHora;
    /**
     * contiene el id del artista
     */
    String artista;

    /**
     * constructor de la clase
     * @param fechaHora
     * @param artista
     */
    public Evento(LocalDateTime fechaHora, String artista) {
        this.fechaHora = fechaHora;
        this.artista = artista;
    }

    /**
     * @return la fecha y hora del evento
     */
    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    /**
     * @return el artista del evento
     */
    public String getArtista() {
        return artista;
    }

    /**
     * toString de Evento
     * @return devuelve el artista y la fecha y hora del evento
     */
    @Override
    public String toString() {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return artista + " - " + fechaHora.format(formato).toString();
    }
}
