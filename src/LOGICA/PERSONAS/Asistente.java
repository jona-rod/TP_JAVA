package LOGICA.PERSONAS;

import LOGICA.ZONAS.Zona;

/**
 * Clase Asistente, carga todos los asitentes que tiene el festival, cuenta con los metodos: constructor, tipoPersona indica
 * que la persona es un asistente, habilitado indica las zonas a las que pueden entrar los asistentes
 */
public class Asistente extends Persona {
    /**
     * constructor de la clase Asistente
     * @param id
     * @param nombre
     */
    public Asistente(String id, String nombre) {
        super(id, nombre);
    }

    /**
     * indica el tipo de persona
     * @return caracter H para indicar que es Asistente (El caracter A ya se usa para artista, no se puede repetir)
     */
    @Override
    public char tipoPersona() {
        return 'H';
    }

    /**
     * indica si la persona esta habilitada para ingresar a una zona
     * @param zona
     * @return true si la persona esta habilitada, false si la persona no esta habilitada
     */
    @Override
    public boolean habilitado(Zona zona) {
        return zonaHabilitada(zona) || zona.tipoZona() == 'C' ||zona.tipoZona() == 'E';
    }


}

