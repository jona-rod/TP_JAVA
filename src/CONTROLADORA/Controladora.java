package CONTROLADORA;

import LOGICA.GESTION.Gestion;
import LOGICA.LISTADOS.ListadoStands;
import LOGICA.LISTADOS.ListadoZonas;

public class Controladora {

    private Gestion gestion;


    public Controladora(Gestion gestion) {
        this.gestion = gestion;
    }

    // VENTANA MUESTRA DATOS DE PERSONA
    // 1
    public String muestraListadoPersonas(){
        return gestion.muestraListadoPersonas();
    }

    //2
    public boolean verificarPersona(String id){
        return gestion.getListadoPersonas().get(id) != null;
    }

    //3
    public String muestraPersona(String id){
        return gestion.getListadoPersonas().get(id).toString();
    }

    // VENTANA MUEVE PERSONA

    //4
    public String muestraListadoZonasConPersonas(){
        return gestion.muestraListadoZonasConPersonas();
    }

    //5
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
    public void guardaDatos(){
        gestion.guardarDatos();
    }

    //VENTANA ZONAS
    //7
    public String generaListadoZonas(){
        ListadoZonas listado = new ListadoZonas();  // 7 generaListadoZonas
        String list = listado.generaListado(gestion);
        return list;
    }

    //8
    public boolean verificarZona(String idZona){
        return gestion.getConjuntoZonas().containsKey(idZona);
    }

    //9
    public String muestraZona(String idZona){
        return gestion.getConjuntoZonas().get(idZona).toString();
    }

    //VENTANA ZONAS
    //10
    public String generaListadoStands(){
        ListadoStands listado = new ListadoStands();
        String lista = listado.generarListado(gestion);
        return lista;
    }




}
