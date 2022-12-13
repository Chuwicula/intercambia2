/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author nicol
 */
@Entity
@Table(name = "estadoelemento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estadoelemento.findAll", query = "SELECT e FROM Estadoelemento e"),
    @NamedQuery(name = "Estadoelemento.findByIdestadoelemento", query = "SELECT e FROM Estadoelemento e WHERE e.idestadoelemento = :idestadoelemento"),
    @NamedQuery(name = "Estadoelemento.findByNombreestadoelemento", query = "SELECT e FROM Estadoelemento e WHERE e.nombreestadoelemento = :nombreestadoelemento")})
public class Estadoelemento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idestadoelemento")
    private Integer idestadoelemento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombreestadoelemento")
    private String nombreestadoelemento;

    public Estadoelemento() {
    }

    public Estadoelemento(Integer idestadoelemento) {
        this.idestadoelemento = idestadoelemento;
    }

    public Estadoelemento(Integer idestadoelemento, String nombreestadoelemento) {
        this.idestadoelemento = idestadoelemento;
        this.nombreestadoelemento = nombreestadoelemento;
    }

    public Integer getIdestadoelemento() {
        return idestadoelemento;
    }

    public void setIdestadoelemento(Integer idestadoelemento) {
        this.idestadoelemento = idestadoelemento;
    }

    public String getNombreestadoelemento() {
        return nombreestadoelemento;
    }

    public void setNombreestadoelemento(String nombreestadoelemento) {
        this.nombreestadoelemento = nombreestadoelemento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idestadoelemento != null ? idestadoelemento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estadoelemento)) {
            return false;
        }
        Estadoelemento other = (Estadoelemento) object;
        if ((this.idestadoelemento == null && other.idestadoelemento != null) || (this.idestadoelemento != null && !this.idestadoelemento.equals(other.idestadoelemento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Estadoelemento[ idestadoelemento=" + idestadoelemento + " ]";
    }
    
}
