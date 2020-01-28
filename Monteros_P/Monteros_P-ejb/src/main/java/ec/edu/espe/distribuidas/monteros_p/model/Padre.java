/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.monteros_p.model;

import ec.edu.espe.distribuidas.monteros_p.enums.EstadoCivilPadreEnums;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Paula
 */
@Entity
@Table(name = "Padre")
public class Padre implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "Codigo", nullable = false)
    private Integer codigo;
    @Column(name = "Nombre", nullable = false, length = 100)
    private String nombre;
    @Enumerated(value = EnumType.STRING)
    @Column(name = "ESTADO_CIVIL", nullable = false, length = 1)
    private EstadoCivilPadreEnums estadoCivil;
    @OneToMany(mappedBy = "padre", fetch = FetchType.LAZY)
    private List<Hijo> listaAdmAula;

    public Padre() {
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public EstadoCivilPadreEnums getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(EstadoCivilPadreEnums estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public List<Hijo> getListaAdmAula() {
        return listaAdmAula;
    }

    public void setListaAdmAula(List<Hijo> listaAdmAula) {
        this.listaAdmAula = listaAdmAula;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.codigo);
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
        final Padre other = (Padre) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Padre{" + "codigo=" + codigo + ", nombre=" + nombre + ", estadoCivil=" + estadoCivil + ", listaAdmAula=" + listaAdmAula + '}';
    }
    
    

}
