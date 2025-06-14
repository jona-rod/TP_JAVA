package LOGICA.PERSONAS;
import LOGICA.ZONAS.Evento;

import java.util.ArrayList;

public class Artista extends Persona {
    ArrayList<Evento> evenAsis=new ArrayList<>();
    public Artista(String identificador, String nom) {

        super(identificador, nom);
    }

    @Override
    public char tipoPersona() {
        return 'A';
    }

    public void agregaEvento(){

    }
}
