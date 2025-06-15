package LOGICA.PERSONAS;

public class Asistente extends Persona {

    public Asistente(String id, String nombre) {
        super(id, nombre);
    }


    @Override
    public char tipoPersona() {
        return 'S';
    }


}

