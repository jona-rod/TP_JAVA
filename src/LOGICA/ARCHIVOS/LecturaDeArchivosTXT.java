package LOGICA.ARCHIVOS;

import LOGICA.GESTION.Gestion;
import LOGICA.PERSONAS.*;
import LOGICA.REPORTES.ReporteDeDatos;
import LOGICA.ZONAS.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class LecturaDeArchivosTXT {
    ReporteDeDatos informe;

    //agrego el constructor
    public LecturaDeArchivosTXT() {
        informe = new ReporteDeDatos();
    }

    public void leeZonas(Gestion ConjuntoZonas) {
        informe.agregaError("\n------------- REPORTE DE ZONAS -------------\n");
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
                    String ubicacion= "";//agrego la variable nula porque sino da error de resolucion
                    if(cat == 'S'){ //agrego el la condicion si es stand
                        ubicacion = bloque[3];
                    }
                    if (cat == 'C') {
                        ConjuntoZonas.agregarZona(new Comun(id, descripcion));
                    } else if (cat == 'E') {
                        ConjuntoZonas.agregarZona(new Escenario(id, descripcion));
                    } else if (cat == 'R') {
                        ConjuntoZonas.agregarZona(new Restringida(id, descripcion));
                    } else {
                        ConjuntoZonas.agregarZona(new Stand(id, descripcion, ubicacion));
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
        if (cat == 'S') {
            if (bloque.length != 4) {
                throw new StringIndexOutOfBoundsException("Error: cantidad de datos distinta a la esperada.");
            }
            if (bloque[3].length() > 25) {
                throw new IllegalArgumentException("Error: Ubicacion excede 25 caracteres");
            }// que valide si es una zona valida y si existe la ubicacion del stand
        } else if (bloque.length != 3) {
            throw new StringIndexOutOfBoundsException("Error: cantidad de datos distitna a la esperada.");
        }

        if (cat != 'C' && cat != 'E' && cat != 'R' && cat != 'S') {
            throw new IllegalArgumentException("Error: la categoria debe ser 'C'(comun) o 'E'(escenario) o 'R'(restringida)");
        }
        if (bloque[1].length() != 4) {
            throw new IllegalArgumentException("Error: ID debe tener 4 caracteres");
        }
        String TipoZ = bloque[2];
        if (bloque[2].length() > 25) {
            throw new IllegalArgumentException("Error: Descripcion excede 25 caracteres");
        }
    /*    if (!NombresZonas.pertenece(TipoZ)) {
            throw new IllegalArgumentException("Error: Zona no incluida dentro del festival");
        }*/
    }

    public void leeEventos(Gestion conjuntoZonas /*Gestion listadoPersonas*/) {
        informe.agregaError("\n------------- REPORTE DE EVENTOS -------------\n");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        try {
            BufferedReader lector = new BufferedReader(new FileReader("src/LOGICA/ARCHIVOS/Eventos.txt"));
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
                    //Persona persona = (Persona) listadoPersonas.buscaPersonaPorId(artista);
                    Evento nuevoEvento = new Evento(fechaHora, artista);
                    escenario.cargaEvento(nuevoEvento);
                    //persona.agregaEventoArtista(nuevoEvento);

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
                throw new IllegalArgumentException("Campo en posición " + (i + 1) + " está vacío o es nulo");
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
        if (bloque[1].length() > 25) {
            throw new IllegalArgumentException("Nombre de artista inválido. Solo se permiten 25 caracteres");
        }

        // Validación 5: Formato de ID de escenario (ES seguido de 2 dígitos)
        if (!bloque[2].matches("^[E]S\\d{2}$")) {
            throw new IllegalArgumentException("ID de escenario inválido. Formato esperado: ES##, (Ej: ES01)");
        }
    }

    public void leePersonas(Gestion listadoPersonas) {
        informe.agregaError("\n------------- REPORTE DE PERSONAS -------------\n");

        try {
            BufferedReader lector = new BufferedReader(new FileReader("src/LOGICA/ARCHIVOS/PERSONAS.txt"));
            String linea = "";
            while ((linea = lector.readLine()) != null) {
                String[] bloque = linea.split(";");
                try {
                    validaDatosPersonas(bloque);
                    char per = bloque[0].charAt(0);
                    String idPersona = bloque[1];
                    String nombre = bloque[2];
                    String idZona = bloque[3];
                    String idStand ="";
                    if(per == 'C'){
                        idStand = bloque[4];
                    }
                    if (per == 'C')
                        listadoPersonas.cargaPersona(new Comerciante(idPersona, nombre, idStand), idZona);
                    else if (per == 'A')
                        listadoPersonas.cargaPersona(new Artista(idPersona, nombre), idZona);
                    else if(per == 'H')//por helper que es ayudante en ingles
                        listadoPersonas.cargaPersona(new Asistente(idPersona, nombre), idZona);
                    else
                        listadoPersonas.cargaPersona(new Staff(idPersona, nombre), idZona);
                } catch (StringIndexOutOfBoundsException e) {
                    informe.agregaError("Error en linea " + linea + " - " + e.getMessage()); //le agregue cont como prueba temporal
                } catch (IllegalArgumentException e) {
                    informe.agregaError("Error de datos en la linea: " + linea + "-" + e.getMessage());
                } catch (Exception e) {
                    informe.agregaError("Error en linea " + linea + " - " + e.getMessage());
                }
            }
            lector.close();
        } catch (IOException e) {
            informe.agregaError("Error al leer el archivo " + e.getMessage());
        }
    }
    public void validaDatosPersonas(String[] bloque) throws IllegalArgumentException,StringIndexOutOfBoundsException {
        char per = bloque[0].charAt(0);
        if (per == 'C') {
            if (bloque.length != 5)
                throw new StringIndexOutOfBoundsException("Error: cantidad de datos distinta a la esperada.");
            if (bloque[4].length() != 4) {
                throw new IllegalArgumentException("Error: El id de stand no tiene la cantidad de caracteres correctos");
            }
        } else if (bloque.length != 4) {
            throw new StringIndexOutOfBoundsException("Error: cantidad de datos distitna a la esperada.");
        }
        if (per != 'C' && per != 'A' && per != 'H' && per != 'S') {
            throw new IllegalArgumentException("Error: la persona debe ser: 'C' (Comerciante), 'A' (Artista), 'H' (Asistente) o 'S' (Staff) ");
        }
        if (bloque[1].length() != 6) {
            throw new IllegalArgumentException("Error: ID debe tener 6 caracteres");
        }
        if (bloque[2].length() > 25) {
            throw new IllegalArgumentException("Error: Nombre excede 25 caracteres");
        }
        if(bloque[3].length() != 4){
            throw new IllegalArgumentException("Error: idZona debe tener 4 caracteres");
        }
    }
    public void leeAccesos(Gestion listadoPersonas){
        informe.agregaError("\n------------- REPORTE DE ACCESOS -------------\n");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        try {
            BufferedReader lector = new BufferedReader(new FileReader("src/LOGICA/ARCHIVOS/Accesos.txt"));
            String linea = "";
            while ((linea = lector.readLine()) != null) {
                String[] bloque = linea.split(";");
                try {
                    validaDatosAccesos(bloque);
                    // Parseo de datos
                    String idPersona = bloque[0];
                    Zona zona = listadoPersonas.buscarZonaPorCodigo(bloque[1]);
                    LocalDateTime fechaHora = LocalDateTime.parse(bloque[2], formatter);
                    int  minPer = Integer.parseInt(bloque[3]);
                    boolean estado = Boolean.parseBoolean(bloque[4]);

                    // Buscar persona y agregar listado de acceso
                    Persona persona = (Persona) listadoPersonas.buscaPersonaPorId(idPersona);
                    Acceso nuevoAcceso = new Acceso(zona,fechaHora,minPer,estado);
                    persona.cargaAcceso(nuevoAcceso);
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
    public void validaDatosAccesos(String[] bloque) throws IllegalArgumentException {
        // Verificar que el bloque tenga exactamente 5 elementos
        if (bloque.length != 5) {
            throw new IllegalArgumentException("La línea debe contener exactamente 5 campos separados por ';'");
        }

        // Validar ID Persona (no vacío)
        if (bloque[0] == null || bloque[0].trim().isEmpty()) {
            throw new IllegalArgumentException("El ID de persona no puede estar vacío");
        }

        // Validar código de zona (no vacío)
        if (bloque[1] == null || bloque[1].trim().isEmpty()) {
            throw new IllegalArgumentException("El código de zona no puede estar vacío");
        }

        // Validar fecha/hora (formato correcto se validará al parsear)
        if (bloque[2] == null || bloque[2].trim().isEmpty()) {
            throw new IllegalArgumentException("La fecha/hora no puede estar vacía");
        }

        // Validar minutos permanencia (número entero positivo)
        try {
            int minutos = Integer.parseInt(bloque[3]);
            if (minutos < 0) {
                throw new IllegalArgumentException("Los minutos de permanencia deben ser un número positivo");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Los minutos de permanencia deben ser un número entero válido");
        }

        // Validar estado (true/false)
        if (!bloque[4].equalsIgnoreCase("true") && !bloque[4].equalsIgnoreCase("false")) {
            throw new IllegalArgumentException("El estado debe ser 'true' o 'false'");
        }
    }
    public void leeHabilitadas(Gestion listadoPersonas){
        informe.agregaError("\n------------- REPORTE DE ZONAS HABILITADAS -------------\n");
        try {
            BufferedReader lector = new BufferedReader(new FileReader("src/LOGICA/ARCHIVOS/ZonasHabilitadas.txt"));
            String linea = "";
            while ((linea = lector.readLine()) != null) {
                String[] bloque = linea.split(";");
                try {
                    validaDatosHabilitadas(bloque);
                    // Parseo de datos
                    String idPersona = bloque[0];
                    String idZona = bloque[1];

                    // Buscar persona y agregar listado de acceso
                    Persona persona = (Persona) listadoPersonas.buscaPersonaPorId(idPersona);
                    Zona zona = (Zona) listadoPersonas.buscarZonaPorCodigo(idZona);
                    persona.cargaZonaAutorizada(zona);
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
    public void validaDatosHabilitadas(String[] bloque) throws IllegalArgumentException,StringIndexOutOfBoundsException {
        if (bloque.length != 2) {
            throw new StringIndexOutOfBoundsException("Error: cantidad de datos distinta a la esperada.");
        }
        if (bloque[0].length() != 6) {
            throw new IllegalArgumentException("Error: ID Persona debe tener 6 caracteres");
        }
        if (bloque[1].length() != 4) {
            throw new IllegalArgumentException("Error: ID Zona debe tener 4 caracteres");
        }
    }

    public void generaInformeDatos(){
        informe.generaInforme();
    }
}

