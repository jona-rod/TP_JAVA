package LOGICA.ZONAS;

import java.util.Comparator;

public class Stand extends Restringida{

    String ubicacion;
    String responsable;

    public Stand(String codigo, String descripcion, String ubicacion) {
        super(codigo,descripcion);
        this.ubicacion = ubicacion; //agrego asignacion faltante
    }

    public String getUbicacion(){ return ubicacion; }

    public void setUbicacion(String ubicacion){this.ubicacion = ubicacion;}

    public String getResponsable(){ return responsable; }
    public void setResponsable(String responsable){this.responsable = responsable;}

    public static final Comparator<Stand> POR_RESPONSABLE =
            Comparator.comparing(Stand::getResponsable, String.CASE_INSENSITIVE_ORDER);

    @Override
    public String toString() {
        return super.toString()+"\nUbicacion:  "+getUbicacion()+"\nResponsable: "+ (responsable!=null?responsable.toString():"no tiene responsable");
    }

    @Override
    public boolean zonaLlena(){
        return !(conjuntoPersona.size() < 5);
    }

    @Override
    public char tipoZona(){return 'S';} //faltaba redefinir el metodo
}
