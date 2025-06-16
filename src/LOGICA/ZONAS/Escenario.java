package LOGICA.ZONAS;

import java.util.ArrayList;
import java.util.List;
public class Escenario extends Zona {

    List<Evento> eventos;
    private static final int capacidadMaxima = 1000;

    public Escenario(String codigo, String descripcion) {
        super(codigo, descripcion);
        this.eventos = new ArrayList<>();
    }

    public List<Evento> getEventos() {
        return new ArrayList<>(eventos); // Devuelve copia para evitar modificaciones externas
    }
    @Override
    public String toString() {
        return "Escenario [" + codigo + "] " + descripcion + " (Capacidad: " + capacidadMaxima + ")";
    }
    @Override
    public char tipoZona(){return 'E';}

    @Override
    public boolean zonaLlena(){
        return !(conjuntoPersona.size() < capacidadMaxima);
    }

    @Override
    public void cargaEvento(Evento evento) {
        eventos.add(evento);
    }
}
