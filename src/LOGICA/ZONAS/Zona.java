package LOGICA.ZONAS;

public abstract class Zona {

    String codigo;
    String descripcion;


    public Zona(String codigo, String descripcion) {
        this.codigo = codigo;
        this.descripcion = descripcion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void muestra(){
        System.out.println(codigo);
        System.out.println(descripcion);
    }
}
