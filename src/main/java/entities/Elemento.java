/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author nicol
 */
@Entity
@Table(name = "elemento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Elemento.findAll", query = "SELECT e FROM Elemento e"),
    @NamedQuery(name = "Elemento.findByIdelemento", query = "SELECT e FROM Elemento e WHERE e.idelemento = :idelemento"),
    @NamedQuery(name = "Elemento.findByNombreelemento", query = "SELECT e FROM Elemento e WHERE e.nombreelemento = :nombreelemento"),
    @NamedQuery(name = "Elemento.findByDescripcion", query = "SELECT e FROM Elemento e WHERE e.descripcion = :descripcion"),
    @NamedQuery(name = "Elemento.findElementosDisponibles", query = "SELECT e FROM Elemento e WHERE e.idusuario != :usuario and e.idestadoelemento.idestadoelemento = :estado")
})
public class Elemento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idelemento")
    private Integer idelemento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombreelemento")
    private String nombreelemento;
    @Size(max = 200)
    @Column(name = "descripcion")
    private String descripcion;
    @JoinColumn(name = "idcategoria", referencedColumnName = "idcategoria")
    @ManyToOne(optional = false)
    private Categoria idcategoria;
    @JoinColumn(name = "idestadoelemento", referencedColumnName = "idestadoelemento")
    @ManyToOne(optional = false)
    private Estadoelemento idestadoelemento;

    @JoinColumn(name = "idusuario", referencedColumnName = "idusuario")
    @ManyToOne(optional = false)
    private Usuario idusuario;
    @OneToMany(mappedBy = "elemento")
    private List<Solicitud> solicitudes;

    public Elemento() {
    }

    public Elemento(Integer idelemento) {
        this.idelemento = idelemento;
    }

    public Elemento(Integer idelemento, String nombreelemento) {
        this.idelemento = idelemento;
        this.nombreelemento = nombreelemento;
    }

    public Integer getIdelemento() {
        return idelemento;
    }

    public void setIdelemento(Integer idelemento) {
        this.idelemento = idelemento;
    }

    public String getNombreelemento() {
        return nombreelemento;
    }

    public void setNombreelemento(String nombreelemento) {
        this.nombreelemento = nombreelemento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Categoria getIdcategoria() {
        return idcategoria;
    }

    public void setIdcategoria(Categoria idcategoria) {
        this.idcategoria = idcategoria;
    }

    public Estadoelemento getIdestadoelemento() {
        return idestadoelemento;
    }

    public void setIdestadoelemento(Estadoelemento idestadoelemento) {
        this.idestadoelemento = idestadoelemento;
    }

    public Usuario getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Usuario idusuario) {
        this.idusuario = idusuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idelemento != null ? idelemento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Elemento)) {
            return false;
        }
        Elemento other = (Elemento) object;
        if ((this.idelemento == null && other.idelemento != null) || (this.idelemento != null && !this.idelemento.equals(other.idelemento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Elemento[ idelemento=" + idelemento + " ]";
    }

}
