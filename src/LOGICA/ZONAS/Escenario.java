package LOGICA.ZONAS;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase escenario, se encarga de crear todas las zonas escenario, como metodos tiene el constructor, getEventos que devuelve
 * la lista de eventos que va a haber en ese escenario, muestraEventos que arma una lista con los eventos que habra en el escenario,
 * toString que llama a muestraEventos para mostrar los eventos del escenario, tipoZona que devuelve E para indicar
 * que la clase es Escenario, zonaLlena que devuelve true o false, dependiendo si la cantidad de gente es menor o mayor a
 * capacidadMaxima y cargaEvento que añaden los eventos al escenario
 */
public class Escenario extends Zona {
    /**
     *lista de los eventos del escenario
     */
    List<Evento> eventos;
    /**
     * identificador de capacidadMaxima en cada escenario
     */
    private static final int capacidadMaxima = 5;

    /**
     * constructor de la zona
     * @param codigo
     * @param descripcion
     */
    public Escenario(String codigo, String descripcion) {
        super(codigo, descripcion);
        this.eventos = new ArrayList<>();
    }

    /**
     * copia de lista de eventos
     * @return copia  de la lista de eventos para evitar modificaciones externas
     */
    public List<Evento> getEventos() {
        return new ArrayList<>(eventos); //
    }

    /**
     * muestra de eventos del escenario
     * @return el toString de evento que muestra todos los datos de cada evento
     */
    public String muestraEventos(){
        StringBuilder sb = new StringBuilder();
        sb.append("  \tLISTA DE EVENTOS\n\t---------------\n\n\n");
        for (Evento evento : eventos){
            sb.append("\t").append(evento.toString() + "\n\n");
        }
        return sb.toString();
    }

    /**
     * toString de Escenario
     * @return el metodo muestraEventos
     */
    @Override
    public String toString() {
        return super.toString() +"\n" +muestraEventos()+ "\n  Capacidad máxima: " + capacidadMaxima + "\n\n";
    }

    /**
     * indica tipo de zona
     * @return caracter E para indicar que es Escenario
     */
    @Override
    public char tipoZona(){return 'E';}

    /**
     * indica si la zona esta llena
     * @return true si el conjunto de personas que hay en el escenario es mayor a capacidad maxima, y false si es menor
     */
    @Override
    public boolean zonaLlena(){
        return !(conjuntoPersona.size() < capacidadMaxima);
    }

    /**
     * carga los eventos de los escenarios
     * @param evento
     */
    @Override
    public void cargaEvento(Evento evento) {
        eventos.add(evento);
    }
}
