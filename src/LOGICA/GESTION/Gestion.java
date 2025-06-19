package LOGICA.GESTION;

import LOGICA.PERSONAS.Acceso;
import LOGICA.PERSONAS.Comerciante;
import LOGICA.PERSONAS.Persona;
import LOGICA.REPORTES.ReporteAcceso;
import LOGICA.ZONAS.Restringida;
import LOGICA.ZONAS.Stand;
import LOGICA.ZONAS.Zona;

import java.sql.SQLOutput;
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

    public ArrayList<Zona> getListadoZonas(){
        return listadoZonas;
    }
    public TreeMap<String, Zona> getConjuntoZonas(){
        return conjuntoZonas;
    }

    public ArrayList<Stand> getListadoStands(){
        return listadoStands;
    }
//2 agrego
    public TreeMap<String, Persona> getListadoPersonas(){
        return listadoPersonas;
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

    public void cargaPersona(Persona persona,String idZona, char per) throws Exception {
        String mensaje = "La persona con id:  " + persona.getId() + ", Nombre : " + persona.getNombre() + " no pudo registrarse";
        if(conjuntoZonas.get(idZona) != null) {

            if(! conjuntoZonas.get(idZona).zonaLlena()){
           //     if (persona.habilitado(conjuntoZonas.get(idZona))) {
                    conjuntoZonas.get(idZona).agregaPersona(persona);
                    listadoPersonas.put(persona.getId(), persona);

                    if(per == 'R'){
                        Stand st = (Stand) conjuntoZonas.get(idZona);
                        st.setResponsable(persona.getNombre());


                     }
              //  else {
               //     throw new Exception("Zona sin acceso habilitado para la persona - " + mensaje); //comento porque al realizar la carga metodo habilitaod() no tiene referencia a lista
               // }
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
        if(conjuntoZonas.get(codigo.trim()) == null)
            throw new IllegalArgumentException("La zona marcada no existe.");
        return conjuntoZonas.get(codigo.trim());
    }
    public Persona buscaPersonaPorId(String idPersona){
        if(idPersona == null || idPersona.trim().isEmpty()){
            throw new IllegalArgumentException("El código de persona no puede ser nulo o vacío");
        }
        if(listadoPersonas.get(idPersona.trim()) == null){
            throw new IllegalArgumentException("La persona marcada no existe.");
        }
        return listadoPersonas.get(idPersona.trim());
    }
    public void muevePersona(String idPersona, String idZonaDestino) throws IllegalArgumentException, Exception {

        if(listadoPersonas.containsKey(idPersona)){
            if(conjuntoZonas.containsKey(idZonaDestino)) {
                Acceso nuevo = new Acceso(conjuntoZonas.get(idZonaDestino), LocalDateTime.now(), 30, false);
                Persona per = listadoPersonas.get(idPersona);
                String zonaOrigen = per.zonaActual();
                StringBuilder mensaje = new StringBuilder();

                if (!conjuntoZonas.get(idZonaDestino).zonaLlena()) {
                    if (per.habilitado(conjuntoZonas.get(idZonaDestino))) {
                        nuevo.setEstado(true);

                        conjuntoZonas.get(idZonaDestino).agregaPersona(listadoPersonas.get(per.getId()));//3agrego .getId
                        conjuntoZonas.get(zonaOrigen).eliminaPersona(idPersona);
                        mensaje.append("ACCESO ACEPTADO").append("\n").append("Nombre: ").append(per.getNombre()).append("\n").append("Id: ").append(idPersona).append("\n").append("Cambio de zona de ").append(zonaOrigen).append(" - ").append(conjuntoZonas.get(zonaOrigen).getDescripcion()).append(" hacia ").append(idZonaDestino).append(" - ").append(conjuntoZonas.get(idZonaDestino).getDescripcion()).append("\n\n");
                    } else {
                        mensaje.append("ACCESO DENEGADO").append("\n").append("Nombre: ").append(per.getNombre()).append("\n").append("Id: ").append(idPersona).append("\n").append("No tiene habilitación de acceso a la zona: ").append(idZonaDestino).append(" - ").append(conjuntoZonas.get(idZonaDestino).getDescripcion()).append("\n\n");
                        reporte.agregaAcceso(mensaje.toString());
                        listadoPersonas.get(idPersona).cargaAcceso(nuevo);
                        throw new Exception("ACCESO DENEGADO, la persona no tiene habilitación para ingresar a la zona");

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

    public String muestraListadoPersonas(){
        StringBuilder sb = new StringBuilder();
        for (Persona persona : listadoPersonas.values()) {
            char tp = persona.tipoPersona();
            String tipoPersona;
            if(tp == 'A')
                tipoPersona = "Artista";
            else if (tp == 'H') {
                tipoPersona = "Asistente";
            } else if (tp == 'C') {
                tipoPersona = "Comerciante";
            }else
                tipoPersona = "Staff";

            sb.append("ID: ").append(persona.getId()).append("\t").append("\t Nombre: ").append(persona.getNombre()).append("\t").append("\t Tipo Persona: ").append(tipoPersona).append("\t").append("\t Zona Actual: ").append(persona.zonaActual()).append("\n");
        }
        return sb.toString();
    }

}
