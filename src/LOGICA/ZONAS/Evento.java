package LOGICA.ZONAS;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Evento {

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
        return artista + " - " + fechaHora.toString();
    }
}
