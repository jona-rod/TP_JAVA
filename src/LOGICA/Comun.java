package LOGICA;

public class Comun extends Zona {
    int capacidadMax;

    public Comun(String codigo, String descripcion) {
        super(codigo, descripcion);
    }
<<<<<<< HEAD
    int CapacidadMax;
    @Override
    public String toString() {
        return "Zona Común [" + codigo + "] " + descripcion;
    }
=======

    public void setCapacidadMax(int capacidadMax) {this.capacidadMax = capacidadMax;}

    public int getCapacidadMax() {return capacidadMax;}
>>>>>>> d5d087bceccd24df0c4530b9b92baebee59be36f
}
