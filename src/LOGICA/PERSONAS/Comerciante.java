package LOGICA.PERSONAS;

import LOGICA.ZONAS.Zona;

public class Comerciante extends Persona {

        String suStand;

        public Comerciante(String identificador,String nombre, String suStand) {
            super(identificador,nombre);
            this.suStand = suStand;
        }

        public String getSuStand() {
            return suStand;
        }

    @Override
    public String toString() {
            return super.toString()  + "\n\tStand a cargo: " + suStand;
    }

    @Override
    public char tipoPersona() {
        return 'C';
    }

    @Override
    public boolean habilitado(Zona zona) {
            return zona.tipoZona() == 'C' || zonaHabilitada(zona);
    }
}
