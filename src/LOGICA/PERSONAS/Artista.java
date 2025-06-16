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


    @Override
    public char tipoPersona() {
        return 'A';
    }

    @Override
    public boolean habilitado(Zona zona) {
        return zona.tipoZona() == 'C' || zonaHabilitada(zona);
    }

    @Override
    public void agregaEventoArtista(Evento evento){
        eventosDelArtista.add(evento);
    }

}
