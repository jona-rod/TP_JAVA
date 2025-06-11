package LOGICA.MANEJADORAS;

import LOGICA.PERSONAS.Persona;
import LOGICA.ZONAS.Zona;

import java.util.HashMap;
import java.util.TreeMap;


public class Gestion {
    HashMap<String, Persona> conjuntoPersonas=new HashMap<>();
    TreeMap<String, Zona> conjuntoZonas=new TreeMap<>();
    HashMap <String,Persona> zonasEscenario=new HashMap<>();
    HashMap <String,Persona> zonasComunes=new HashMap<>();
    HashMap <String,Persona> zonasRestringidas=new HashMap<>();


}
