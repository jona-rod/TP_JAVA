package LOGICA.ARCHIVOS;

import LOGICA.GESTION.Gestion;
import LOGICA.ZONAS.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

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
            throw new StringIndexOutOfBoundsException("Error: cantidad de datos distitna a la esperada.");
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
        if (bloque[1].length() != 6) {
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
}