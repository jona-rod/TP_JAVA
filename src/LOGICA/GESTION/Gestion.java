package LOGICA.GESTION;

import LOGICA.PERSONAS.Acceso;
import LOGICA.PERSONAS.Persona;
import LOGICA.REPORTES.ReporteAcceso;
import LOGICA.ZONAS.Restringida;
import LOGICA.ZONAS.Stand;
import LOGICA.ZONAS.Zona;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.TreeSet;

public class Gestion {

    TreeMap<String, Zona> conjuntoZonas; // < idZona , Zona >

    TreeMap<String,Persona> listadoPersonas; //<idPersona , Persona>

    ArrayList<Zona> listadoZonas;   //lista auxiliar para generar listado ordenado de zonas

    ArrayList<Stand> listadoStands; //lista auxiliar para generar listado ordenado de stands

    ReporteAcceso reporte;



    public Gestion (){
        conjuntoZonas = new TreeMap<>();
        listadoPersonas = new TreeMap<>();
        listadoZonas = new ArrayList<>();
        listadoStands = new ArrayList<>();
        reporte = new ReporteAcceso();

    }

    public void agregarZona(Zona zona) {
        conjuntoZonas.put(zona.getCodigo(), zona);
        if(zona.tipoZona() != 'S')//zona
            listadoZonas.add(zona);
        else //stand
            listadoStands.add((Stand) zona);

    }

    public void eliminarZona(Zona zona) {
        conjuntoZonas.remove(zona.getCodigo());
        if(zona.tipoZona() != 'S')
            listadoZonas.remove(zona);
        else
            listadoStands.remove(zona);
    }

    public void cargaPersona(Persona persona,String idZona) throws Exception {

        String mensaje = "La persona con id:  " + persona.getId() + ", Nombre : " + persona.getNombre() + " no pudo registrarse";
        if(conjuntoZonas.get(idZona) != null) {
            if(! conjuntoZonas.get(idZona).zonaLlena()){
                if (persona.habilitado(conjuntoZonas.get(idZona))) {
                    conjuntoZonas.get(idZona).agregaPersona(persona);
                    listadoPersonas.put(persona.getId(), persona);
                }
                else {
                    throw new Exception("Zona sin acceso habilitado para la persona - " + mensaje);
                }
            }
            else {
                throw new Exception("Zona con capacidad completa - " + mensaje);
            }
        }
        else {
            throw new Exception("Zona no existe - " + mensaje);
        }
    }
    public  Zona buscarZonaPorCodigo(String codigo) {
        if (codigo == null || codigo.trim().isEmpty()) {
            throw new IllegalArgumentException("El código de zona no puede ser nulo o vacío");
        }
        return conjuntoZonas.get(codigo.trim());
    }

    public void muevePersona(String idPersona, String idZonaDestino) throws IllegalArgumentException{

        if(listadoPersonas.containsKey(idPersona)){
            if(conjuntoZonas.containsKey(idZonaDestino)) {
                Acceso nuevo = new Acceso(conjuntoZonas.get(idZonaDestino), LocalDateTime.now(), 30, false);
                Persona per = listadoPersonas.get(idPersona);
                String zonaOrigen = per.zonaActual();
                StringBuilder mensaje = new StringBuilder();

                if (!conjuntoZonas.get(idZonaDestino).zonaLlena()) {
                    if (per.habilitado(conjuntoZonas.get(idZonaDestino))) {
                        nuevo.setEstado(true);
                        conjuntoZonas.get(idZonaDestino).agregaPersona(listadoPersonas.get(per));
                        conjuntoZonas.get(zonaOrigen).eliminaPersona(idPersona);
                        mensaje.append("ACCESO ACEPTADO").append("\n").append("Nombre: ").append(per.getNombre()).append("\n").append("Id: ").append(idPersona).append("\n").append("Cambio de zona de ").append(zonaOrigen).append(" - ").append(conjuntoZonas.get(zonaOrigen).getDescripcion()).append(" hacia ").append(idZonaDestino).append(" - ").append(conjuntoZonas.get(idZonaDestino).getDescripcion()).append("\n\n");
                    } else {
                        mensaje.append("ACCESO DENEGADO").append("\n").append("Nombre: ").append(per.getNombre()).append("\n").append("Id: ").append(idPersona).append("\n").append("No tiene habilitación de acceso a la zona: ").append(idZonaDestino).append(" - ").append(conjuntoZonas.get(idZonaDestino).getDescripcion()).append("\n\n");
                    }
                } else {
                    mensaje.append("ACCESO DENEGADO").append("\n").append("Nombre: ").append(per.getNombre()).append("\n").append("Id: ").append(idPersona).append("\n").append("No puede acceder debido a capacidad completa de la zona: ").append(idZonaDestino).append(" - ").append(conjuntoZonas.get(idZonaDestino).getDescripcion()).append("\n\n");

                }
                reporte.agregaAcceso(mensaje.toString());
                listadoPersonas.get(idPersona).cargaAcceso(nuevo);

            }else{
                throw new IllegalArgumentException("La zona no existe");
            }
        }else{
            throw new IllegalArgumentException("La persona no existe");
        }
    }
}
