package LOGICA.ARCHIVOS;

import LOGICA.GESTION.Gestion;
import LOGICA.ZONAS.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class LecturaDeArchivosTXT {
    informeDeDatos informe;
    public void leeZonas(Gestion ConjuntoZonas) {
        try {
            BufferedReader lector = new BufferedReader(new FileReader("src/LOGICA/ARCHIVOS/ZONAS.txt"));
            String linea = "";
            while ((linea = lector.readLine()) != null) {
                String[] bloque = linea.split(";");
                try {
                    validaDatosZona(bloque);
                    char cat = bloque[0].charAt(0);
                    String id = bloque[1];
                    String descripcion = bloque[2];
                    String ubicacion = bloque[3];
                    if (cat == 'C') {
                        ConjuntoZonas.agregarZona(new Comun(id, descripcion));
                    } else if (cat == 'E') {
                        ConjuntoZonas.agregarZona(new Escenario(id, descripcion));
                    } else if(cat == 'R'){
                        ConjuntoZonas.agregarZona(new Restringida(id, descripcion));
                    }else{
                        ConjuntoZonas.agregarZona(new Stand(id,descripcion,ubicacion));

                    }
                } catch (StringIndexOutOfBoundsException e) {
                    informe.agregaError("Error en linea " + linea + " - " + e.getMessage());
                } catch (IllegalArgumentException e) {
                    informe.agregaError("Error de datos en la linea: " + linea + "-" + e.getMessage());
                }
            }

            lector.close();
        } catch (IOException e) {
            informe.agregaError("Error al leer el archivo " + e.getMessage());
        }

    }

    public void validaDatosZona(String[] bloque) throws IllegalArgumentException, StringIndexOutOfBoundsException, NumberFormatException {
        char cat = bloque[0].charAt(0);
        if(cat == 'S'){
        if(bloque.length != 4){
            throw new StringIndexOutOfBoundsException("Error: cantidad de datos distinta a la esperada.");
        }
            String desc = bloque[3];
            if (bloque[3].length() > 25) {
                throw new IllegalArgumentException("Error: Ubicacion excede 25 caracteres");
            }
        }else if(bloque.length != 3){
        throw new StringIndexOutOfBoundsException("Error: cantidad de datos distitna a la esperada.");
        }

        if (cat != 'C' && cat != 'E' && cat != 'R') {
            throw new IllegalArgumentException("Error: la categoria debe ser 'C'(comun) o 'E'(escenario) o 'R'(restringida)");
        }
        String id = bloque[1];
        if (bloque[1].length() != 4) {
            throw new IllegalArgumentException("Error: ID debe tener 6 caracteres");
        }
        String TipoZ = bloque[2];
        if (bloque[2].length() > 25) {
            throw new IllegalArgumentException("Error: Descripcion excede 25 caracteres");
        }
        if (!NombresZonas.pertenece(TipoZ)) {
            throw new IllegalArgumentException("Error: Zona no incluida dentro del festival");
        }
    }
    public void leeEventos(Gestion conjuntoZonas){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        try {
            BufferedReader lector = new BufferedReader(new FileReader("src/LOGICA/ARCHIVOS/ZONAS.txt"));
            String linea = "";
            while ((linea = lector.readLine()) != null) {
                String[] bloque = linea.split(";");
                try {
                    validaDatosEventos(bloque);
                    // Parseo de datos
                    LocalDateTime fechaHora = LocalDateTime.parse(bloque[0], formatter);
                    String artista = bloque[1];
                    String idEscenario = bloque[2];

                    // Buscar escenario y agregar evento
                    Escenario escenario = (Escenario) conjuntoZonas.buscarZonaPorCodigo(idEscenario);
                    if (escenario != null) {
                        Evento nuevoEvento = new Evento(fechaHora, artista);
                        escenario.cargaEvento(nuevoEvento);
                    }
                } catch (StringIndexOutOfBoundsException e) {
                    informe.agregaError("Error en linea " + linea + " - " + e.getMessage());
                } catch (IllegalArgumentException e) {
                    informe.agregaError("Error de datos en la linea: " + linea + "-" + e.getMessage());
                }
            }

            lector.close();
        } catch (IOException e) {
            informe.agregaError("Error al leer el archivo " + e.getMessage());
        }

    }
    private void validaDatosEventos(String[] bloque) throws IllegalArgumentException {
        // Validación 1: Estructura básica del array
        if (bloque == null || bloque.length != 3) {
            throw new IllegalArgumentException("Formato de línea inválido. Se esperaban exactamente 3 campos separados por ';'");
        }

        // Validación 2: Campos no vacíos
        for (int i = 0; i < bloque.length; i++) {
            if (bloque[i] == null || bloque[i].trim().isEmpty()) {
                throw new IllegalArgumentException("Campo en posición " + (i+1) + " está vacío o es nulo");
            }
            bloque[i] = bloque[i].trim(); // Limpiar espacios
        }

        // Validación 3: Formato de fecha (dd/MM/yyyy HH:mm:ss)
        try {
            LocalDateTime.parse(bloque[0], DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Formato de fecha inválido. Use dd/MM/yyyy HH:mm:ss. Error: " + e.getMessage());
        }

        // Validación 4: Artista (solo letras, espacios y caracteres básicos)
        if (bloque[1].length() < 25) {
            throw new IllegalArgumentException("Nombre de artista inválido. Solo se permiten 25 caracteres");
        }

        // Validación 5: Formato de ID de escenario (ES seguido de 2 dígitos)
        if (!bloque[2].matches("^[E]S\\d{2}$")) {
            throw new IllegalArgumentException("ID de escenario inválido. Formato esperado: ES##, (Ej: ES01)");
        }
    }
}
