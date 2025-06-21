package controladora;

import logica.gestion.Gestion;
import logica.listados.ListadoStands;
import logica.listados.ListadoZonas;

/**
 * clase Controladora se encarga de manejar los distintos metodos que se usan en las ventanas, tiene como metodos:
 * un constructor, MuestraListadoPersonas devuelve el listado de todas la personas, verificarPersona verifica si la persona
 * existe en el listado de persona recibiendo por parametro el id de la persona, muestraPersona muestra el contenido y los datos
 * de la persona que contiene el id pasado por parametro, muestraListadoZonasConPersonas muestra e listado de las zonas con
 * los datos y cada persona que esta en esa zona con los datos, muevePersona mueve una persona de una zona a otra, siempre y cuando
 * este habilitada la persona para ingresar a la otra zona, guardaDatos guarda los datos, generaListadoZonas crea un listado de
 * todas las zonas, verificarZona verifica que la zona exista, muestraZona devuelve la zona que contiene el id pasado por parametro,
 * generaListadoStands crea el listado de los stands
 */
public class Controladora {
    /**
     * contiene todas los metodos que se utilizan
     */
    private Gestion gestion;

    /**
     * constructor de la clase Controladora
     * @param gestion
     */
    public Controladora(Gestion gestion) {
        this.gestion = gestion;
    }

    // VENTANA MUESTRA DATOS DE PERSONA
    // 1

    /**
     * devuelve el listado de todas las personas que hay en el festival
     * @return listado de personas
     */
    public String muestraListadoPersonas(){
        return gestion.muestraListadoPersonas();
    }

    //2

    /**
     * verifica que la persona que contiene el id pasado por parametro este en el festival
     * @param id
     * @return persona con identficador recibido por parametro
     */
    public boolean verificarPersona(String id){
        return gestion.getListadoPersonas().get(id) != null;
    }

    //3

    /**
     * muestra los datos de la persona que contiene el id pasado por parametro
     * @param id
     * @return toString de la persona
     */
    public String muestraPersona(String id){
        return gestion.getListadoPersonas().get(id).toString();
    }

    // VENTANA MUEVE PERSONA

    //4

    /**
     * muestra el listado de las zonas con las personas que tiene cada una, ordenado por cantidad de gente de mayor a menor
     * @return
     */
    public String muestraListadoZonasConPersonas(){
        return gestion.muestraListadoZonasConPersonas();
    }

    //5

    /**
     * mueve una persona de una zona a otra, siempre y cuando la misma este habilitada para entrar a la otra zona
     * @param idPersona
     * @param idZona
     * @throws IllegalArgumentException
     * @throws Exception
     */
    public void muevePersona(String idPersona, String idZona) throws IllegalArgumentException,Exception {
        try{

            gestion.muevePersona(idPersona, idZona);

        }catch (IllegalArgumentException e){
            throw new IllegalArgumentException(e.getMessage());
        } catch(Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //6

    /**
     * guarda los datos
     */
    public void guardaDatos(){
        gestion.guardarDatos();
    }

    //VENTANA ZONAS
    //7

    /**
     * genera un listado de las zonas ordenadas alfabeticamente por el nombre de los responsables
     * @return listado de zonas
     */
    public String generaListadoZonas(){
        ListadoZonas listado = new ListadoZonas();  // 7 generaListadoZonas
        String list = listado.generaListado(gestion);
        return list;
    }

    //8

    /**
     * verifica que el id recibido por parametro pertenezca a una zona, y devuelve la zona que contiene ese id
     * @param idZona
     * @return zona con id pasado por parametro
     */
    public boolean verificarZona(String idZona){
        return gestion.getConjuntoZonas().containsKey(idZona);
    }

    //9

    /**
     * muestra los datos de la zona que contiene el id pasado por parametro
     * @param idZona
     * @return datos de la zona
     */
    public String muestraZona(String idZona){
        return gestion.getConjuntoZonas().get(idZona).toString();
    }

    //VENTANA ZONAS
    //10

    /**
     * genera el listado de los stands ordenados alfabeticamente por el nombre de los responsables
     * @return listado de stands
     */
    public String generaListadoStands(){
        ListadoStands listado = new ListadoStands();
        String lista = listado.generarListado(gestion);
        return lista;
    }




}
