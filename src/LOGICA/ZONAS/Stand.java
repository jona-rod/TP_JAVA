package LOGICA.ZONAS;

public class Stand extends Restringida {

    String ubicacion;

    public Stand(String codigo, String descripcion, String ubicacion) {
        super(codigo,descripcion);
    }

    public String getUbicacion(){ return ubicacion; }

    public void setUbicacion(String ubicacion){this.ubicacion = ubicacion;}


    @Override
    public boolean zonaLlena(){
        return !(conjuntoPersona.size() < 1);
    }

}
