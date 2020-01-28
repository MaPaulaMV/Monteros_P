/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.monteros_p.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author Paula
 */
@Entity
@Table(name = "Hijo")
public class Hijo implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private HijoPK pk;

    @Column(name = "Nombre", nullable = false)
    private String nombre;

    @ManyToOne
    @PrimaryKeyJoinColumn(name = "CODIGOPADRE", referencedColumnName = "Codigo")
    private Padre padre;

    public Hijo() {
    }

    public HijoPK getPk() {
        return pk;
    }

    public void setPk(HijoPK pk) {
        this.pk = pk;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Padre getPadre() {
        return padre;
    }

    public void setPadre(Padre padre) {
        this.padre = padre;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.pk);
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
        final Hijo other = (Hijo) obj;
        if (!Objects.equals(this.pk, other.pk)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Hijo{" + "pk=" + pk + ", nombre=" + nombre + ", padre=" + padre + '}';
    }

}
