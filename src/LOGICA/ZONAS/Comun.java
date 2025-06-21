package LOGICA.ZONAS;

/**
 * Clase que se encarga de crear todas las zonas Comun, tiene un metodo tipoZona que se encarga de returnar el caracter C para
 * saber que es clase comun, y un metodo zonaLlena que devuelve false, ya que las zonas comunes no se pueden llenar, estos dos
 * metodos son abstractos de la clase Zona
 */
public class Comun extends Zona {
    /**
     * Constructor de la clse Comun
     * @param codigo
     * @param descripcion
     */
    public Comun(String codigo, String descripcion) {
        super(codigo, descripcion);
    }

    /**
     * Indica que tipo de zona es
     * @return el caracter c para indicar que es zona comun
     */
    @Override
    public char tipoZona(){return 'C';}

    /**
     * indica si la zona esta llena
     * @return false, ya que las zonas comun no se pueden llenar
     */
    @Override
    public boolean zonaLlena(){return false;}
}
