/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Rodrigo
 */
@Entity
@Table(name = "dates")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dates.findAll", query = "SELECT d FROM Dates d")
    , @NamedQuery(name = "Dates.findByIdDates", query = "SELECT d FROM Dates d WHERE d.idDates = :idDates")
    , @NamedQuery(name = "Dates.findByDatesDate", query = "SELECT d FROM Dates d WHERE d.datesDate = :datesDate")})
public class Dates implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_dates")
    private Integer idDates;
    @Column(name = "dates_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datesDate;
    @JoinTable(name = "deliverys_has_dates", joinColumns = {
        @JoinColumn(name = "dates_id_dates", referencedColumnName = "id_dates")}, inverseJoinColumns = {
        @JoinColumn(name = "deliverys_id_deliverys", referencedColumnName = "id_deliverys")})
    @ManyToMany
    private Collection<Deliverys> deliverysCollection;
    @JoinTable(name = "users_has_dates", joinColumns = {
        @JoinColumn(name = "dates_id_dates", referencedColumnName = "id_dates")}, inverseJoinColumns = {
        @JoinColumn(name = "users_id_users", referencedColumnName = "id_users")})
    @ManyToMany
    private Collection<Users> usersCollection;

    public Dates() {
    }

    public Dates(Integer idDates) {
        this.idDates = idDates;
    }

    public Integer getIdDates() {
        return idDates;
    }

    public void setIdDates(Integer idDates) {
        this.idDates = idDates;
    }

    public Date getDatesDate() {
        return datesDate;
    }

    public void setDatesDate(Date datesDate) {
        this.datesDate = datesDate;
    }

    @XmlTransient
    public Collection<Deliverys> getDeliverysCollection() {
        return deliverysCollection;
    }

    public void setDeliverysCollection(Collection<Deliverys> deliverysCollection) {
        this.deliverysCollection = deliverysCollection;
    }

    @XmlTransient
    public Collection<Users> getUsersCollection() {
        return usersCollection;
    }

    public void setUsersCollection(Collection<Users> usersCollection) {
        this.usersCollection = usersCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDates != null ? idDates.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dates)) {
            return false;
        }
        Dates other = (Dates) object;
        if ((this.idDates == null && other.idDates != null) || (this.idDates != null && !this.idDates.equals(other.idDates))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Models.Dates[ idDates=" + idDates + " ]";
    }
    
}
