package LOGICA.PERSONAS;

import LOGICA.ZONAS.Zona;

/**
 * clase Comerciante, cre las personas que son comerciantes, cuenta con los metodos: constructor, toString, tipoPersona que indica
 * que tipo de persona es y habilitado que indica si laperosna puede ingresar o no a determinada zona
 */
public class Comerciante extends Persona {
    /**
     * constructor de la clase Comerciante
     * @param identificador
     * @param nombre
     */
        public Comerciante(String identificador,String nombre) {
            super(identificador,nombre);

        }

    /**
     * @return el texto de la clase padre (Persona)
     */
    @Override
    public String toString() {
            return super.toString();
    }

    /**
     * indica el tipo de persona que es
     * @return el caracter C para indicar que es un comerciante
     */
    @Override
    public char tipoPersona() {
        return 'C';
    }

    /**
     * indica las zonas a la que esta habilitado a entrar el comerciante
     * @param zona
     * @return true si la zona recibida puede ingresar, false si no puede ingresar
     */
    @Override
    public boolean habilitado(Zona zona) {
            return zonaHabilitada(zona) ||zona.tipoZona() == 'C';
    }
}
