package LOGICA.ZONAS;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Evento implements Serializable {

    LocalDateTime fechaHora;
    String artista;

    public Evento(LocalDateTime fechaHora, String artista) {
        this.fechaHora = fechaHora;
        this.artista = artista;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public String getArtista() {
        return artista;
    }

    @Override
    public String toString() {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return artista + " - " + fechaHora.format(formato).toString();
    }
}
