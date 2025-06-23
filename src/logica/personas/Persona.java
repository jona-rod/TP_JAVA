package logica.personas;

import logica.zonas.Evento;
import logica.zonas.Zona;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.LinkedHashSet;

/**
 * clase Persona, implementa Serializable, es una clase abstracta de la cual derivan los distintos tipos de personas. tiene los metodos: cosntructor,
 * getId devuelve el identificador de la persona, setId carga el identificador de la persona, getNombre devuelve el nombre de
 * la persona, setNombre carga el nombre de la persona, getAccesos devuelve la lista de accesos de la persona, getZonasAutorizadas
 * devuelve la lista de zonas autorizadas de la persona, cargaAcceso carga un acceso a la lista de accesos de la persona
 * cargaZonasAutorizadas carga una zona autorizasa a la cual puede ingresar la persona, tipoPersona abstracta, habilitado abstracta
 * zonaHabilitada devuelve si una zona esta habilitada a ingresar la persona,zonaActual indica la zona en la cual tuvo el ultimo
 * acceso aceptado la persona, muestraListaAccesosPersona muestra una lista de los accesos que tuvo la persona,
 * muestraListaZonasAutorizadasPersona muestra una lista de las zonas a la que puede ingresar la persona, toString, ultimoAcceso
 * devuelve el ultimo acceso que fue aceptado de la persona, calculaMinutosPermanencia devuelve el tiempo que estuvo en el
 * ultimo acceso la persona
 */
public abstract class Persona implements Serializable {
    /**
     * identificador unico de la persona
      */
        String id;
    /**
     * nombre de la persona
     */
        String nombre;
        LinkedHashSet<Acceso> listaAccesos;
        ArrayList<Zona> zonasAutorizadas;

    /**
     * constructor de la clase
     * @param id identificador unico de la persona
     * @param nombre nombre de la persona
     */
    public Persona(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.listaAccesos = new LinkedHashSet<>();
        this.zonasAutorizadas = new ArrayList<>();
    }

    /**
     * devuelve el identificador unico de la persona
     * @return el id
     */
    public String getId() {
        return id;
    }

    /**
     * carga el identificador unico de la persona
     * @param id identificador unico de la persona
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * devuelve el nombre de la persona
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * carga el nombre de la persona
     * @param nombre nombre de la persona
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    /**
     * devuelve la lista de accesos que tiene la persona, tanto aceptados como denegados
     * @return ListaAccesos
     */
    public LinkedHashSet<Acceso> getAccesos() {
        return listaAccesos;
    }

    /**
     * devuelve las zonas autorizaddas a la que puede ingresar una persona
     * @return zonasAutorizadas
     */
    public ArrayList<Zona> getZonasAutorizadas() {
        return zonasAutorizadas;
    }

    /**
     * carga en ListaAccesos un acceso nuevo que tuvo la persona
     * @param ac acceso para agregarle a la persona
     */
    public void cargaAcceso(Acceso ac) {
        listaAccesos.add(ac);
    }

    /**
     * carga en zonasAutorizadas una nueva zona autorizada para la persona
     * @param zona zona para agregar a las zonas autorizadas para la persona
     */
    public void cargaZonaAutorizada(Zona zona) {zonasAutorizadas.add(zona);}

    /**
     * abstracta que se utilizan en las clases hijo
     * @return null
     */
    public abstract char tipoPersona();

    /**
     * abstracta que se usa en las clases hijo,//busca en el atributo "zonasHabilitadas" y devuelve si está habilitado
     * (reedefine en cada subclase)
     * @param zona para ver si esta habilitado a ingresar
     * @return null
     */
    public abstract boolean habilitado(Zona zona);

    /**
     * devuelve si una zona esta dentro de las zonas autorizadas de la persona
     * @param zona para comprobar si esta dentro de las zonas autorizadas de la persona
     * @return true si la zona esta dentro de la zonas autorizadas, false si no lo esta
     */
    protected boolean zonaHabilitada(Zona zona){
        for(Zona z : zonasAutorizadas){
            if(z.getCodigo().equalsIgnoreCase( zona.getCodigo())){
                return true;
            }
        }
        return false;
    };

    /**
     * devuelve la zona en la que hizo el ultimo acceso aceptado la persona
     * @return identificador de la zona en la que esta la persona actualmente, o null si no esta en ninguna zona
     */
    public String zonaActual(){
        for(Acceso acceso : listaAccesos.reversed()){
            if(acceso.getEstado()){
                return acceso.getZona().getCodigo();
            }
        }
        return null;
    }

    /**
     * devuelve el ultimo acceso valido de la persona
     * @return ultimo acceso valido
     */
    public Acceso ultimoAcceso(){
        if(listaAccesos!=null && listaAccesos.size()>0){
            for(Acceso acceso : listaAccesos.reversed()){
                if(acceso.getEstado()){
                    return acceso;
                }
            }
        }
        return null;
    }

    /**
     * devuelve el tiempo que estuvo en el ultimo acceso la persona, cuando hace un cambio de zona
     * @return diferencia entre hora de entrada y hora de salida de la zona
     */
    public long calculaMinutosPermanencia() {
        Acceso ultimoAcceso = ultimoAcceso();
        LocalDateTime fechaHoraUltimoAcceso = ultimoAcceso.getFecha();
        return ChronoUnit.MINUTES.between(fechaHoraUltimoAcceso, LocalDateTime.now());
    }
    /**
     * carga un objeto Evento al objeto Artista
     * @param evento objeto Evento
     */
    public void agregaEventoArtista(Evento evento){};

    /**
     * muestra en texto una lista de los accesos que hizo la persona
     * @return el texto con todos los accesos de la persona
     */
    public String muestraListaAccesosPersona(){
        StringBuilder sb = new StringBuilder();
        sb.append("\t Lista de accesos\n\t -------------\n\n");
        for(Acceso acceso : listaAccesos.reversed()){
            sb.append("\t ").append(acceso.toString()).append("\n\n");
        }
        return sb.toString();
    }

    /**
     * muestra en texto las zonas a las que esta habilitada a entrar la persona
     * @return el texto con las zonas autorizadas, teniendo su identificador y descripcion
     */
    public String muestraListaZonasAutorizadasPersona(){
        StringBuilder sb = new StringBuilder();
        sb.append("\t Lista de zonas autorizadas\n\t ---------------------\n\n");
        for(Zona zona : zonasAutorizadas){
            sb.append("\t ").append("Id: ").append(zona.getCodigo()).append("\t  ").append("Descripción: ").append(zona.getDescripcion()).append("\n\n");
        }
        sb.append("\n..........................................................................................................................................................................................................................................................................\n\n");
        return sb.toString();
    }

    /**
     * muestra listado de pesonas
     * @return String
     */

    public String muestraPersonaListado(){
        return  "\t ID : " + id + "\t\t Nombre : " + nombre + "\n\n";
    }

    /**
     * toString de la zona Persona
     * @return String texto con id,nombre,lista de accesos y lista de zonas autorizadas
     */
    @Override
    public String toString() {

        return "..........................................................................................................................................................................................................................................................................\n\n" +
                 " ID : " + id + "\n \n Nombre : " + nombre + "\n\n" +" Zona actual: " + zonaActual() + "\n\n" +
                "\n..........................................................................................................................................................................................................................................................................\n\n" +
                muestraListaAccesosPersona()+
                "\n..........................................................................................................................................................................................................................................................................\n\n" +
                muestraListaZonasAutorizadasPersona();
    }

}
