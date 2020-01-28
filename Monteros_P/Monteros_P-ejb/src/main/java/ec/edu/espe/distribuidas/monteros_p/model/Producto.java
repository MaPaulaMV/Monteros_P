/*
 * ESPE - DCC - APLICACIONES DISTRIBUIDAS
 * Sistema: Monteros_P-ejb
 * 
 * Creado: 28/01/2020 - 7:18:03
 * 
 * Los contenidos de este archivo son propiedad privada y estan protegidos por la licencia BSD.
 * 
 * 
 * Se puede utilizar, reproducir o copiar el contenido de este archivo.
 */
package ec.edu.espe.distribuidas.monteros_p.model;

import ec.edu.espe.distribuidas.monteros_p.enums.TipoProductoEnum;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Paula
 */
@Entity
@Table(name="Producto")
public class Producto implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="Codigo",nullable=false)
    private Integer codigo;
    
    @Column(name = "Nombre",nullable = false, length=150)
    private String nombre;
    
    @Column(name="Precio",nullable=false,length = 12,precision=2)
    private BigDecimal precio;
    
    @Enumerated(value = EnumType.STRING)
    @Column(name = "Tipo",nullable = false,length = 1)
    private TipoProductoEnum tipo;

    public Producto() {
    }

    public Producto(Integer codigo) {
        this.codigo = codigo;
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

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public TipoProductoEnum getTipo() {
        return tipo;
    }

    public void setTipo(TipoProductoEnum tipo) {
        this.tipo = tipo;
    }    
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.codigo);
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
        final Producto other = (Producto) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Producto{" + "codigo=" + codigo + '}';
    }
    
    
}
