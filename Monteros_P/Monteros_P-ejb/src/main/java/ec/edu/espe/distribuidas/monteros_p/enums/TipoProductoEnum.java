/*
 * ESPE - DCC - APLICACIONES DISTRIBUIDAS
 * Sistema: Monteros_P-ejb
 * 
 * Creado: 28/01/2020 - 7:24:59
 * 
 * Los contenidos de este archivo son propiedad privada y estan protegidos por la licencia BSD.
 * 
 * 
 * Se puede utilizar, reproducir o copiar el contenido de este archivo.
 */
package ec.edu.espe.distribuidas.monteros_p.enums;

/**
 *
 * @author Paula
 */
public enum TipoProductoEnum {
    
    /**
     * Representa al valor Casado.
     */
    N("Nuevo"),
    /**
     * Representa al valor Soltero.
     */
    A("Antiguo"),
    /**
     * Representa al valor Divorciado.
     */
    F("Frecuente");
    
    private final String text;

    private TipoProductoEnum(String text) {
        this.text = text;
    }

    /**
     * Retorna el texto asociadado al elemento de la enumeraci\u00F3n.
     *
     * @return Texto asociado al elemento de la enumeraci\u00F3n.
     */
    public String getText() {
        return this.text;
    }
    
    
}
