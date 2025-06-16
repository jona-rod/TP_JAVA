package LOGICA.ZONAS;

public class Restringida extends Zona {


    private final int capacidadMaxima = 1000;

    public Restringida(String codigo, String descripcion) {
        super(codigo, descripcion);
    }


    @Override
    public char tipoZona(){return 'R';}

    @Override
    public boolean zonaLlena(){
        return !(conjuntoPersona.size() < capacidadMaxima);
    }
}
