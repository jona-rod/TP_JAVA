package LOGICA.ZONAS;

public enum NombresZonas {
    Plaza_central,Patio_de_comidas,Zona_de_descanso,Zona_de_compras;
    public static boolean pertenece(String TipoZ) {
        for (NombresZonas gen : NombresZonas.values()) {
            if (gen.name().equalsIgnoreCase(TipoZ)) {
                return true;
            }
        }
        return false;
    }
}
