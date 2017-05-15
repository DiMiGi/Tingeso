/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Rodrigo
 */
@Entity
@Table(name = "deliverys")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Deliverys.findAll", query = "SELECT d FROM Deliverys d")
    , @NamedQuery(name = "Deliverys.findByIdDeliverys", query = "SELECT d FROM Deliverys d WHERE d.idDeliverys = :idDeliverys")
    , @NamedQuery(name = "Deliverys.findByDeliverysHour", query = "SELECT d FROM Deliverys d WHERE d.deliverysHour = :deliverysHour")
    , @NamedQuery(name = "Deliverys.findByDeliverysAvailable", query = "SELECT d FROM Deliverys d WHERE d.deliverysAvailable = :deliverysAvailable")})
public class Deliverys implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_deliverys")
    private Integer idDeliverys;
    @Column(name = "deliverys_hour")
    private Integer deliverysHour;
    @Column(name = "deliverys_available")
    private Short deliverysAvailable;
    @ManyToMany(mappedBy = "deliverysCollection")
    private Collection<Dates> datesCollection;

    public Deliverys() {
    }

    public Deliverys(Integer idDeliverys) {
        this.idDeliverys = idDeliverys;
    }

    public Integer getIdDeliverys() {
        return idDeliverys;
    }

    public void setIdDeliverys(Integer idDeliverys) {
        this.idDeliverys = idDeliverys;
    }

    public Integer getDeliverysHour() {
        return deliverysHour;
    }

    public void setDeliverysHour(Integer deliverysHour) {
        this.deliverysHour = deliverysHour;
    }

    public Short getDeliverysAvailable() {
        return deliverysAvailable;
    }

    public void setDeliverysAvailable(Short deliverysAvailable) {
        this.deliverysAvailable = deliverysAvailable;
    }

    @XmlTransient
    public Collection<Dates> getDatesCollection() {
        return datesCollection;
    }

    public void setDatesCollection(Collection<Dates> datesCollection) {
        this.datesCollection = datesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDeliverys != null ? idDeliverys.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Deliverys)) {
            return false;
        }
        Deliverys other = (Deliverys) object;
        if ((this.idDeliverys == null && other.idDeliverys != null) || (this.idDeliverys != null && !this.idDeliverys.equals(other.idDeliverys))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Models.Deliverys[ idDeliverys=" + idDeliverys + " ]";
    }
    
}
