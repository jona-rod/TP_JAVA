package logica.zonas;

/**
 * enumeracion de las distintas zonas comunes. Contiene un pertenece que retorna si una zona esta en la enumeracion
 */
public enum NombresZonasComunes {
    /**
     * Plaza central del establecimiento
     */
    Plaza_central,

    /**
     * Área dedicada a locales de comida
     */
    Patio_de_comidas,

    /**
     * Zona designada para descanso
     */
    Zona_de_descanso,

    /**
     * Área destinada a tiendas y comercios
     */
    Zona_de_compras;

    /**
     * metodo para validar si una zona pertenece a la enumeracion
     * @param TipoZ String descripcion de la zona a buscar
     * @return true si la zona pertenece a la enumeracion, false si la zona no pertenece
     */
    public static boolean pertenece(String TipoZ) {
        for (NombresZonasComunes gen : NombresZonasComunes.values()) {
            if (gen.name().equalsIgnoreCase(TipoZ)) {
                return true;
            }
        }
        return false;
    }
}
