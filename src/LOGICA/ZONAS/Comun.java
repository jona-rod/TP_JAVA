package LOGICA.ZONAS;

public class Comun extends Zona {

    public Comun(String codigo, String descripcion) {
        super(codigo, descripcion);
    }


    @Override
    public char tipoZona(){return 'C';}

    @Override
    public boolean zonaLlena(){return false;}
}
