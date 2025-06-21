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
        sb.append("\t Lista de eventos del artista\n\t ----------------------\n\n");
        if(eventosDelArtista.isEmpty()){
            sb.append("\t El artista no tiene eventos\n\n");
            sb.append("\n..........................................................................................................................................................................................................................................................................\n\n");

        }
        else{
            for (Evento evento : eventosDelArtista) {
                sb.append("\t").append(evento.toString()).append("\n");
                sb.append("\n..........................................................................................................................................................................................................................................................................\n\n");

            }
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
        return zonaHabilitada(zona) || zona.tipoZona() == 'C';
    }

    @Override
    public void agregaEventoArtista(Evento evento){
        eventosDelArtista.add(evento);
    }

}
