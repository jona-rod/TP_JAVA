package LOGICA.ZONAS;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Evento {
    LocalDateTime fechaYhora;
    String artista;

    public Evento(LocalDateTime fecha, String artista) {
        this.fechaYhora = fecha;
        this.artista = artista;
    }
    public LocalDateTime getFechaYhora() {
        return fechaYhora;
    }

    public String getArtista() {
        return artista;
    }

    @Override
    public String toString() {
        return artista + " - " + fechaYhora;
    }
}
