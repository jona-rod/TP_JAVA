package LOGICA.GESTIONES;

import LOGICA.PERSONAS.Persona;

import java.util.HashMap;

public class GestionPersonas {
    HashMap<String, Persona> conjuntoPersonas;

    public void muestraDatos(String personBuscada) {
        Persona buscada = conjuntoPersonas.get(personBuscada);
        if (buscada != null) {
            buscada.muestraDatos();
        }
    }
}
