/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.monteros_p.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

/**
 *
 * @author Paula
 */
@Embeddable
public class HijoPK implements Serializable {
    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CodigoHijo", nullable = false)
    private Integer codigoHijo;
    @Column(name = "CodigoPadre", nullable = false)
    private Integer codigoPadre;

    public HijoPK() {
    }

    
    public Integer getCodigoHijo() {
        return codigoHijo;
    }

    public void setCodigoHijo(Integer codigoHijo) {
        this.codigoHijo = codigoHijo;
    }

    public Integer getCodigoPadre() {
        return codigoPadre;
    }

    public void setCodigoPadre(Integer codigoPadre) {
        this.codigoPadre = codigoPadre;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.codigoHijo);
        hash = 23 * hash + Objects.hashCode(this.codigoPadre);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final HijoPK other = (HijoPK) obj;
        if (!Objects.equals(this.codigoHijo, other.codigoHijo)) {
            return false;
        }
        if (!Objects.equals(this.codigoPadre, other.codigoPadre)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "HijoPK{" + "codigoHijo=" + codigoHijo + ", codigoPadre=" + codigoPadre + '}';
    }
    
    
}
