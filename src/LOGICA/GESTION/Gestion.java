package LOGICA.GESTION;

import LOGICA.ARCHIVOS.ArchivosSerializados;
import LOGICA.PERSONAS.Acceso;
import LOGICA.PERSONAS.Comerciante;
import LOGICA.PERSONAS.Persona;
import LOGICA.REPORTES.ReporteAcceso;
import LOGICA.ZONAS.Restringida;
import LOGICA.ZONAS.Stand;
import LOGICA.ZONAS.Zona;

import java.io.Serializable;
import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * clase Gestion, es la encargada de gestionar las principales funcionalidades del software, tiene como metodos: un constructor,
 * getListadoZonas que devuelve el listado de todas las zonas que hay en el festival ordenada por cantidad de gente, getConjuntoZonas
 * devuelve todas las zonas que hay en el festival, permitiendo tener acceso directo a cada zona, getListadoStands devuelve
 * un listado con todos los stands del festival ordenados alfabeticamente por el nombre del responsable de cada stand, getListadoPersonas
 * devuelve un listado de todas las personas del festival permitiendo tener acceso directo a cada una de ellas, agregarZona
 * agrega una nueva zona al festival, eliminarZona elimina una zona del festival, cargaPersona carga una nueva persona al festival
 * buscarZonaPorCodigo busca una zona teniendo como parametro el identificador de la misma, buscaPersonaPorId busca una persona
 * teniendo como parametro la identificacion de la misma, muevePersona mueve una persona de una zona a otra, siempre y cuando
 * esta este habilitada para entrar a la otra zona, muestraListadoPersona muestra un texto con un listado de todas las personas
 * con todos sus datos
 */
    /**
     * contiene todas las zonas del festival
     */
public class Gestion implements Serializable {

    TreeMap<String, Zona> conjuntoZonas; // < idZona , Zona >
    /**
     * contiene todas las personas del festival
     */
    TreeMap<String,Persona> listadoPersonas; //<idPersona , Persona>
    /**
     * contiene las zonas del festival ordenadas por cantidad de gente, de mayor a menor
     */
    ArrayList<Zona> listadoZonas;   //lista auxiliar para generar listado ordenado de zonas
    /**
     * contiene todos los stands del festival ordenados alfabeticamente por el nombre del responsable de cada stand
     */
    ArrayList<Stand> listadoStands; //lista auxiliar para generar listado ordenado de stands
    /**
     * genera un reporte de los accesos de las personas
     */
    ReporteAcceso reporte;


    /**
     * constructor de la clase Gestion
     * crea e inicializa los conjuntos y listados
     */
    public Gestion (){
        conjuntoZonas = new TreeMap<>();
        listadoPersonas = new TreeMap<>();
        listadoZonas = new ArrayList<>();
        listadoStands = new ArrayList<>();
        reporte = new ReporteAcceso();



    }

    public void guardarDatos() {
        ArchivosSerializados.guardarDatos(this);
    }

    /**
     * devuelve el listado con las zonas ordenadas por cantidad de gente
     * @return listadoZonas
     */
    public ArrayList<Zona> getListadoZonas(){
        return listadoZonas;
    }

    /**
     * devuelve el conjunto de todas las zonas, permitiendo tener acceso directo a traves del id
     * @return conjuntoZonas
     */
    public TreeMap<String, Zona> getConjuntoZonas(){
        return conjuntoZonas;
    }

    /**
     * devuelve el listado de stands ordenado alfabeticamente por los nombres de los responsables de cada stand
     * @return listadoStands
     */
    public ArrayList<Stand> getListadoStands(){
        return listadoStands;
    }

    /**
     * devuelve el listado de todas las personas, permitiendo acceso directo a traves del id
     * @return listadoPersonas
     */
    public TreeMap<String, Persona> getListadoPersonas(){
        return listadoPersonas;
    }

    /**
     * agrega una nueva zona al festival, si una zona distinta a stand la agrega a conjuntoZonas si es un stand lo agrega
     * a listadoStands
     * @param zona
     */
    public void agregarZona(Zona zona) {
        conjuntoZonas.put(zona.getCodigo(), zona);
        if(zona.tipoZona() != 'S')//zona
            listadoZonas.add(zona);
        else //stand
            listadoStands.add((Stand) zona);

    }

    /**
     * elimina una zona del festival
     * @param zona
     */
    public void eliminarZona(Zona zona) {
        conjuntoZonas.remove(zona.getCodigo());
        if(zona.tipoZona() != 'S')
            listadoZonas.remove(zona);
        else
            listadoStands.remove(zona);
    }

    /**
     * añade una nueva persona al festival, cargandola con sus datos a listadoPersonas, tambien carga si debe el responsable
     * de los stands
     * @param persona
     * @param idZona
     * @param per
     * @throws Exception
     */
    public void cargaPersona(Persona persona,String idZona, char per) throws Exception {
        String mensaje = "La persona con id:  " + persona.getId() + ", Nombre : " + persona.getNombre() + " no pudo registrarse";
        if(conjuntoZonas.get(idZona) != null) {
            if(! conjuntoZonas.get(idZona).zonaLlena()){
                    conjuntoZonas.get(idZona).agregaPersona(persona);
                    listadoPersonas.put(persona.getId(), persona);

                    if(per == 'R'){
                        Stand st = (Stand) conjuntoZonas.get(idZona);
                        st.setResponsable(persona.getNombre());
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

    /**
     * busca una zona a traves del id con acceso directo en conjuntoZonas
     * @param codigo
     * @return zona que contiene el id enviado como parametro
     */
    public  Zona buscarZonaPorCodigo(String codigo) {
        if (codigo == null || codigo.trim().isEmpty()) {
            throw new IllegalArgumentException("El código de zona no puede ser nulo o vacío");
        }
        if(conjuntoZonas.get(codigo.trim()) == null)
            throw new IllegalArgumentException("La zona marcada no existe.");
        return conjuntoZonas.get(codigo.trim());
    }

    /**
     * busca una persona a traves del id con acceso directo en listadoPersonas
     * @param idPersona
     * @return persona que contiene el id enviado como parametro
     */
    public Persona buscaPersonaPorId(String idPersona){
        if(idPersona == null || idPersona.trim().isEmpty()){
            throw new IllegalArgumentException("El código de persona no puede ser nulo o vacío");
        }
        if(listadoPersonas.get(idPersona.trim()) == null){
            throw new IllegalArgumentException("La persona marcada no existe.");
        }
        return listadoPersonas.get(idPersona.trim());
    }

    /**
     * se encarga de mover una persona de una zona a otra, sacando del listado de personas de la zona en la que estaba y agregando
     * en el listado de personas de la nueva zona, esto lo hace si la persona esta habilitada para ingresar a la nueva zona
     * sino lo esta tira una excepecion y queda unicamente como un acceso denegado
     * @param idPersona
     * @param idZonaDestino
     * @throws IllegalArgumentException
     */
    public void muevePersona(String idPersona, String idZonaDestino) throws IllegalArgumentException, Exception {

        if(listadoPersonas.containsKey(idPersona)){
            if(conjuntoZonas.containsKey(idZonaDestino)) {
                Acceso nuevo = new Acceso(conjuntoZonas.get(idZonaDestino), LocalDateTime.now(), 30, false);
                Persona per = listadoPersonas.get(idPersona);
                String zonaOrigen = per.zonaActual();
                StringBuilder mensaje = new StringBuilder();

                if (!conjuntoZonas.get(idZonaDestino).zonaLlena()) {
                    if (per.habilitado(conjuntoZonas.get(idZonaDestino))) {
                        System.out.printf("ingresa al habilitado en mueve personas");
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

    /**
     * muestra un texto con un listado de todas las personas del festival, con los datos de cada uno de ellos
     * @return el listado de las personas
     */
    public String muestraListadoPersonas(){
        StringBuilder sb = new StringBuilder();
        sb.append("\n    ID  \t \t  NOMBRE  \t \t  TIPO  \t \t  ZONA ACTUAL  \n\n");
        for (Persona persona : listadoPersonas.values()) {
            if (persona != null && persona.zonaActual() != null) {
                String descripcion = conjuntoZonas.get(persona.zonaActual()).getDescripcion() ;
                char tp = persona.tipoPersona();
                String tipoPersona;
                if (tp == 'A')
                    tipoPersona = "Artista";
                else if (tp == 'H') {
                    tipoPersona = "Asistente";
                } else if (tp == 'C') {
                    tipoPersona = "Comerciante";
                } else
                    tipoPersona = "Staff";


                sb.append("........................................................................................................................................................................................................................................................................................................")
                        .append("\n\n  ID: ").append(persona.getId()).append("\t").append("\t").append(persona.getNombre()).append("\t").append(tipoPersona).append("\t\t").append(persona.zonaActual()).append("  -  ").append(descripcion).append("\t  ( ").append(conjuntoZonas.get(persona.zonaActual()).tipoZona()).append(" )") .append("\n\n");
            }
        }
        return sb.toString();
    }

    public String muestraListadoZonasConPersonas(){
        StringBuilder sb = new StringBuilder();
        for(Zona zona : conjuntoZonas.values()){
            sb.append(zona.toString()).append("\n");
        }
        return sb.toString();
    }
}
