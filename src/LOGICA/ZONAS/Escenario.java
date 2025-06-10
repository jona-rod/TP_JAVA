package LOGICA.ZONAS;

import java.util.ArrayList;
import java.util.List;
public class Escenario extends Zona {

    int cantidadPersonas;
    List<Evento> eventos;
    static final int capacidadMaxima = 1000;

    public Escenario(String codigo, String descripcion) {
        super(codigo, descripcion);
        this.cantidadPersonas = capacidadMaxima;
        this.eventos = new ArrayList<>();
    }

    public int getCantidadPersonas() {
        return cantidadPersonas;
    }

    public void setCantidadPersonas(int cantidadPersonas) {
        this.cantidadPersonas = cantidadPersonas;
    }


    public void agregarEvento(Evento evento) {
        eventos.add(evento);
    }

    public List<Evento> getEventos() {
        return new ArrayList<>(eventos); // Devuelve copia para evitar modificaciones externas
    }
    @Override
    public String toString() {
        return "Escenario [" + codigo + "] " + descripcion + " (Capacidad: " + capacidadMaxima + ")";
    }
}
