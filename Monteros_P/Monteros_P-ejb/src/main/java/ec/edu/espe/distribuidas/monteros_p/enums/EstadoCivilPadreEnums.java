/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.monteros_p.enums;

/**
 *
 * @author Paula
 */
public enum EstadoCivilPadreEnums {

    /**
     * Representa al valor Casado.
     */
    C("Casado"),
    /**
     * Representa al valor Soltero.
     */
    S("SOLTERO"),
    /**
     * Representa al valor Divorciado.
     */
    D("DIVORCIADO");
    private final String text;

    private EstadoCivilPadreEnums(String text) {
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
