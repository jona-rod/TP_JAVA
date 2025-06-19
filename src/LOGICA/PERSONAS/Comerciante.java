package LOGICA.PERSONAS;

import LOGICA.ZONAS.Zona;

public class Comerciante extends Persona {

        String suStand;

        public Comerciante(String identificador,String nombre) {
            super(identificador,nombre);

        }


    @Override
    public String toString() {
            return super.toString();
    }

    @Override
    public char tipoPersona() {
        return 'C';
    }

    @Override
    public boolean habilitado(Zona zona) {
            return zonaHabilitada(zona) ||zona.tipoZona() == 'C';
    }
}
