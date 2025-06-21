package persistencia;
import logica.gestion.Gestion;
import logica.personas.Persona;
import logica.zonas.Stand;
import logica.zonas.Zona;

import java.io.*;
import java.util.ArrayList;
import java.util.TreeMap;

/**
 * Clase abstracta que maneja la carga y almacenamiento de datos de Gestion en archivos binarios utilizando serialización
 *
 * Esta clase proporciona métodos estáticos para cargar y guardar los datos principales del sistema
 *
 * @version 2.0
 */
public abstract class ArchivosSerializados {

    /**
     * Carga los datos desde los archivos serializados
     *
     * @param gestion El objeto Gestion donde se cargarán los datos
     */
    public static void cargarDatos(Gestion gestion) {
        cargarZonas(gestion.getConjuntoZonas(), gestion.getListadoZonas(), gestion.getListadoStands());
        cargarPersonas(gestion.getListadoPersonas());
    }

    /**
     * Guarda los datos en archivos serializados
     *
     * @param gestion El objeto Gestion que contiene los datos a guardar
     */
    public static void guardarDatos(Gestion gestion) {
        guardarZonas(gestion.getConjuntoZonas());
        guardarPersonas(gestion.getListadoPersonas());
    }

    // Métodos para Zonas
    private static void cargarZonas(TreeMap<String, Zona> conjuntoZonas, ArrayList<Zona> listadoZonas, ArrayList<Stand> listadoStands) {
        try (ObjectInputStream cargaSerializados = new ObjectInputStream(new FileInputStream("src/persistencia/archivos/zonasSerializado.dat"))) {
            Zona zona;
            while (true) {
                zona = (Zona) cargaSerializados.readObject();
                conjuntoZonas.put(zona.getCodigo(), zona);
                if(zona.tipoZona() != 'S') {
                    listadoZonas.add(zona);
                } else {
                    listadoStands.add((Stand) zona);
                }
            }
        } catch (EOFException e) {
            // Fin del archivo, se ignora
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al cargar zonas: " + e.getMessage());
        }
    }

    private static void guardarZonas(TreeMap<String, Zona> conjuntoZonas) {
        try (ObjectOutputStream serializa = new ObjectOutputStream(new FileOutputStream("src/persistencia/archivos/zonasSerializado.dat"))) {
            for (Zona zona : conjuntoZonas.values()) {
                serializa.writeObject(zona);
            }
        } catch (IOException e) {
            System.err.println("Error al guardar zonas: " + e.getMessage());
        }
    }

    // Métodos para Personas
    private static void cargarPersonas(TreeMap<String, Persona> listadoPersonas) {
        try (ObjectInputStream cargaSerializados = new ObjectInputStream(new FileInputStream("src/persistencia/archivos/personasSerializado.dat"))) {
            Persona persona;
            while (true) {
                persona = (Persona) cargaSerializados.readObject();
                listadoPersonas.put(persona.getId(), persona);
            }
        } catch (EOFException e) {
            // Fin del archivo, se ignora
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al cargar personas: " + e.getMessage());
        }
    }

    private static void guardarPersonas(TreeMap<String, Persona> listadoPersonas) {
        try (ObjectOutputStream serializa = new ObjectOutputStream(new FileOutputStream("src/persistencia/archivos/personasSerializado.dat"))) {
            for (Persona persona : listadoPersonas.values()) {
                serializa.writeObject(persona);
            }
        } catch (IOException e) {
            System.err.println("Error al guardar personas: " + e.getMessage());
        }
    }

    /**
     * Verifica si los archivos serializados existen
     *
     * @return true si alguno de los archivos no existe, false si ambos existen
     */
    public static boolean archivosNoExisten() {
        File fZonas = new File("src/persistencia/archivos/zonasSerializado.dat");
        File fPersonas = new File("src/persistencia/archivos/personasSerializado.dat");
        return !(fZonas.exists() && fPersonas.exists());
    }
}