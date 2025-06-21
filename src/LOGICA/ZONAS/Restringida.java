package LOGICA.ZONAS;

import java.io.Serializable;

public class Restringida extends Zona implements Serializable {


    private final int capacidadMaxima = 1000;

    public Restringida(String codigo, String descripcion) {
        super(codigo, descripcion);
    }


    @Override
    public String toString() {
        return super.toString() +( tipoZona() == 'R'? ("\n  Capacidad máxima: " + capacidadMaxima+"\n\n" ):"\n\n");
    }

    @Override
    public char tipoZona(){return 'R';}

    @Override
    public boolean zonaLlena(){
        return !(conjuntoPersona.size() < capacidadMaxima);
    }
}
