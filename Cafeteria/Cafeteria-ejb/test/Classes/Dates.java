/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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
    , @NamedQuery(name = "Dates.findByIdDate", query = "SELECT d FROM Dates d WHERE d.idDate = :idDate")
    , @NamedQuery(name = "Dates.findByDateDay", query = "SELECT d FROM Dates d WHERE d.dateDay = :dateDay")
    , @NamedQuery(name = "Dates.findByRealDate", query = "SELECT d FROM Dates d WHERE d.realDate = :realDate")})
public class Dates implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_DATE")
    private Integer idDate;
    @Size(max = 12)
    @Column(name = "DATE_DAY")
    private String dateDay;
    @Column(name = "REAL_DATE")
    @Temporal(TemporalType.DATE)
    private Date realDate;
    @OneToMany(mappedBy = "idDate")
    private Collection<Menus> menusCollection;

    public Dates() {
    }

    public Dates(Integer idDate) {
        this.idDate = idDate;
    }

    public Integer getIdDate() {
        return idDate;
    }

    public void setIdDate(Integer idDate) {
        this.idDate = idDate;
    }

    public String getDateDay() {
        return dateDay;
    }

    public void setDateDay(String dateDay) {
        this.dateDay = dateDay;
    }

    public Date getRealDate() {
        return realDate;
    }

    public void setRealDate(Date realDate) {
        this.realDate = realDate;
    }

    @XmlTransient
    public Collection<Menus> getMenusCollection() {
        return menusCollection;
    }

    public void setMenusCollection(Collection<Menus> menusCollection) {
        this.menusCollection = menusCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDate != null ? idDate.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dates)) {
            return false;
        }
        Dates other = (Dates) object;
        if ((this.idDate == null && other.idDate != null) || (this.idDate != null && !this.idDate.equals(other.idDate))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Classes.Dates[ idDate=" + idDate + " ]";
    }
    
}
