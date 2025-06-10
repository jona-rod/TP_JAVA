package LOGICA.ZONAS;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Evento {
    LocalDate fecha;
    LocalDateTime hora;
    String artista;

    public Evento(LocalDate fecha, LocalDateTime hora, String artista) {
        this.fecha = fecha;
        this.hora = hora;
        this.artista = artista;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public LocalDateTime getHora() {
        return hora;
    }

    public String getArtista() {
        return artista;
    }

    @Override
    public String toString() {
        return artista + " - " + fecha + " " + hora;
    }
}
