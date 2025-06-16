package LOGICA.PERSONAS;

import LOGICA.ZONAS.Zona;

public class Asistente extends Persona {

    public Asistente(String id, String nombre) {
        super(id, nombre);
    }


    @Override
    public char tipoPersona() {
        return 'S';
    }

    @Override
    public boolean habilitado(Zona zona) {
        return zona.tipoZona() == 'C' || zona.tipoZona() == 'E';
    }


}

