package LOGICA.PERSONAS;
import LOGICA.ZONAS.Evento;
import LOGICA.ZONAS.Zona;

import java.util.ArrayList;

public class Artista extends Persona {
    ArrayList<Evento> eventosDelArtista = new ArrayList<>();

    public Artista(String identificador, String nom) {
        super(identificador, nom);
    }

    public void agregaEvento(){
    }

    public String muestraEventosDeArtista(){
        StringBuilder sb = new StringBuilder();
        sb.append("Lista de eventos del artista\n");
        for (Evento evento : eventosDelArtista) {
            sb.append("\t").append(evento.toString()).append("\n");
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return super.toString() + muestraEventosDeArtista();
    }

    @Override
    public char tipoPersona() {
        return 'A';
    }

    @Override
    public boolean habilitado(Zona zona) {
        return zonaHabilitada(zona);
    }

    @Override
    public void agregaEventoArtista(Evento evento){
        eventosDelArtista.add(evento);
    }

}
