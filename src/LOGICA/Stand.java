package LOGICA;

public class Stand extends Restringida{
    String id;
    String ubicacion;
    String comerciante;

    public Stand(String codigo, String descripcion){
        super(codigo,descripcion);
    }

    public String getUbicacion(){ return ubicacion; }
    public String getComerciante(){ return comerciante; }
    public String getId(){ return id; }

    public void setUbicacion(String ubicacion){this.ubicacion = ubicacion;}
    public void setComerciante(String comerciante){this.comerciante = comerciante;}
    public void setId(String id){ this.id = id; }

}
