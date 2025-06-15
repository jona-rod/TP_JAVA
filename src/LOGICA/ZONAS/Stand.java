package LOGICA.ZONAS;

public class Stand extends Restringida {
 //    String id; ya tiene id
    String ubicacion;
//    String comerciante; va a estar en el conjunto de personas

    public Stand(String codigo, String descripcion){
        super(codigo,descripcion);
    }

    public String getUbicacion(){ return ubicacion; }
   // public String getComerciante(){ return comerciante; }
    public String getId(){ return id; }

    public void setUbicacion(String ubicacion){this.ubicacion = ubicacion;}
   // public void setComerciante(String comerciante){this.comerciante = comerciante;}
    public void setId(String id){ this.id = id; }

    @Override
    public boolean zonaLlena(){
        return !(conjuntoPersona.size() < 1);
    }

}
