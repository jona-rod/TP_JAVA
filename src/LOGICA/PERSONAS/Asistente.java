package LOGICA.PERSONAS;

import LOGICA.ZONAS.Zona;

public class Asistente extends Persona {

    public Asistente(String id, String nombre) {
        super(id, nombre);
    }


    @Override
    public char tipoPersona() {
        return 'H';
    }

    @Override
    public boolean habilitado(Zona zona) {
        return zonaHabilitada(zona) || zona.tipoZona() == 'C' ||zona.tipoZona() == 'E' || zona.tipoZona() == 'S';
    }


}

