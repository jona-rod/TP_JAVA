package LOGICA.ZONAS;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Evento {
    LocalDate fecha;
    LocalDateTime hora;
    String artista;

    //  idPeronsa; 20236151430 ;

    // String fecha = bloque[1]

    // new evento ( idPersona,  dt1 )

    LocalDateTime dt1 = LocalDateTime.of(2023, 6, 15, 14, 30);

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
