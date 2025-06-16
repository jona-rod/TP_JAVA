package LOGICA.GESTION;

import LOGICA.PERSONAS.Acceso;
import LOGICA.PERSONAS.Persona;
import LOGICA.ZONAS.Restringida;
import LOGICA.ZONAS.Stand;
import LOGICA.ZONAS.Zona;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.TreeSet;

public class Gestion {

    TreeMap<String, Zona> conjuntoZonas; // < idZona , Zona >

    TreeMap<String,Persona> listadoPersonas; //<idPersona , Persona>

    ArrayList<Zona> listadoZonas;   //lista auxiliar para generar listado ordenado de zonas

    ArrayList<Stand> listadoStands; //lista auxiliar para generar listado ordenado de stands



    public Gestion (){
        conjuntoZonas = new TreeMap<>();
        listadoPersonas = new TreeMap<>();
        listadoZonas = new ArrayList<>();
        listadoStands = new ArrayList<>();
    }




    public void agregarZona(Zona zona) {
        conjuntoZonas.put(zona.getCodigo(), zona);
        if(zona.tipoZona() != 'S')//zona
            listadoZonas.add(zona);
        else //stand
            listadoStands.add(Stand);

    }

    public void eliminarZona(Zona zona) {
        conjuntoZonas.remove(zona.getCodigo());
        if(zona.tipoZona() != 'S')
            listadoZonas.remove(zona);
        else
            listadoStands.remove(zona);
    }

`


    public void muevePersona(String idPersona, String idZonaDestino){

        Acceso nuevo = new Acceso(listadoZonas.get(idZonaDestino), LocalDate.now(),30,false);
        Persona per = listadoPersonas.get(idPersona);
        String zonaActual = per.getIdZonaActual();
        if(per.tipoPersona() != 'S'){
            nuevo.setEstado(true);
            conjuntoZonas.get(per.getIdZonaActual()).getConjuntoPersona().remove(idPersona);
            per.setIdZonaActual(idZonaDestino);

        }
        if(per.habilitado(listadoZonas.get(idZonaDestino)) || conjuntoZonas.get(idZonaDestino).) {
            nuevo.setEstado(true);
            per.setIdZonaActual(idZonaDestino);

        }
        listadoPersonas.get(idPersona).getAccesos().add(nuevo);



    }
    public  Zona buscarZonaPorCodigo(String codigo) {
        if (codigo == null || codigo.trim().isEmpty()) {
            throw new IllegalArgumentException("El código de zona no puede ser nulo o vacío");
        }
        return conjuntoZonas.get(codigo.trim());
    }



}
