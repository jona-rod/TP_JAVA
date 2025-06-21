package LOGICA.PERSONAS;
import LOGICA.ZONAS.Evento;
import LOGICA.ZONAS.Zona;

import java.util.ArrayList;

/**
 * clase Artista, crea las personas artista que tiene el festival, cuenta con los metodos: constructor, muestraEventosDeArtista
 * que muestra una lista con los eventos que tiene el artista, toString arma un texto con el muestraEventosDeArtista, tipoPersona
 * devuelve el caracter A indicando que la persona es un artista, habilitado, devuelve si el artista esta habilitado a una zona determinada
 * AgregaEventoArtista añade un evento a la lista de eventos del artista
 */
public class Artista extends Persona {

    /**
     * contiene los eventos del artista
     */
    ArrayList<Evento> eventosDelArtista = new ArrayList<>();

    /**
     * constructor de la clase Artista
     * @param identificador
     * @param nom
     */
    public Artista(String identificador, String nom) {
        super(identificador, nom);
    }

    /**
     * muestra los eventos del artista
     * @return texto con los eventos del artista
     */
    public String muestraEventosDeArtista(){
        StringBuilder sb = new StringBuilder();
        sb.append("Lista de eventos del artista\n");
        for (Evento evento : eventosDelArtista) {
            sb.append("\t").append(evento.toString()).append("\n");
        }
        return sb.toString();
    }

    /**
     * toString de la clase
     * @return texto con los datos del artista
     */
    @Override
    public String toString() {
        return super.toString() + muestraEventosDeArtista();
    }

    /**
     * devuelve el tipo de persona del artista
     * @return caracter A, indicando que es un artista
     */
    @Override
    public char tipoPersona() {
        return 'A';
    }

    /**
     * indica si el artista esta habilitado para entrar a una zona
     * @param zona
     * @return true si esta habilitado para ingresar y false si no esta habilitado
     */
    @Override
    public boolean habilitado(Zona zona) {
        return zonaHabilitada(zona) || zona.tipoZona() == 'C';
    }

    /**
     * añade un evento a la lista de eventos del artista
     * @param evento
     */
    @Override
    public void agregaEventoArtista(Evento evento){
        eventosDelArtista.add(evento);
    }

}
