package logica.personas;

import logica.zonas.Zona;

/**
 * clase Staff, se encarga de crear las personas del staff, tiene como metodos: el constructor, tipoPersona que devuelve
 * el caracter S, habilitado que devuelve true ya que el staff puede ingresar a cualquier zona
 */
public class Staff extends Persona {
    /**
     * constructor de la clase Staff
     * @param id
     * @param nombre
     */
    public Staff(String id, String nombre) {
        super(id, nombre);
    }

    /**
     * indica que tipo de persona es
     * @return S para indicar que la persona es Staff
     */
    @Override
    public char tipoPersona() {
        return 'S';
    }

    /**
     * devuelve si la persona esta habilitada para ingresar a una zona
     * @param zona
     * @return true, ya que el staff esta habilitado para ingresar a todas las zonas
     */
    @Override
    public boolean habilitado(Zona zona) {
        return  true;
    }
}
