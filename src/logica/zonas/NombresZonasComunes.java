package logica.zonas;

/**
 * enumeracion de las distintas zonas comunes. Contiene un pertenece que retorna si una zona esta en la enumeracion
 */
public enum NombresZonasComunes {
    Plaza_central,Patio_de_comidas,Zona_de_descanso,Zona_de_compras;

    /**
     * metodo para validar si una zona pertenece a la enumeracion
     * @param TipoZ
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
