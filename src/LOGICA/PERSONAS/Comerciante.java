package LOGICA.PERSONAS;

public class Comerciante extends Persona {

        String suStand;

        public Comerciante(String identificador,String nombre, String suStand) {
            super(identificador,nombre);
            this.suStand = suStand;
        }

    @Override
    public char tipoPersona() {
        return 'C';
    }
}
