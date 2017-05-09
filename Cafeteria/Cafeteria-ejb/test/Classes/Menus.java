/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Rodrigo
 */
@Entity
@Table(name = "menus")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Menus.findAll", query = "SELECT m FROM Menus m")
    , @NamedQuery(name = "Menus.findByIdMenu", query = "SELECT m FROM Menus m WHERE m.idMenu = :idMenu")
    , @NamedQuery(name = "Menus.findByMenuPrice", query = "SELECT m FROM Menus m WHERE m.menuPrice = :menuPrice")
    , @NamedQuery(name = "Menus.findByMenuAvailability", query = "SELECT m FROM Menus m WHERE m.menuAvailability = :menuAvailability")})
public class Menus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_MENU")
    private Integer idMenu;
    @Column(name = "MENU_PRICE")
    private Integer menuPrice;
    @Column(name = "MENU_AVAILABILITY")
    private Short menuAvailability;
    @ManyToMany(mappedBy = "menusCollection")
    private Collection<Foods> foodsCollection;
    @JoinTable(name = "orders_has_menus", joinColumns = {
        @JoinColumn(name = "ID_MENU", referencedColumnName = "ID_MENU")}, inverseJoinColumns = {
        @JoinColumn(name = "ID_ORDER", referencedColumnName = "ID_ORDER")})
    @ManyToMany
    private Collection<Orders> ordersCollection;
    @JoinColumn(name = "ID_DATE", referencedColumnName = "ID_DATE")
    @ManyToOne
    private Dates idDate;

    public Menus() {
    }

    public Menus(Integer idMenu) {
        this.idMenu = idMenu;
    }

    public Integer getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(Integer idMenu) {
        this.idMenu = idMenu;
    }

    public Integer getMenuPrice() {
        return menuPrice;
    }

    public void setMenuPrice(Integer menuPrice) {
        this.menuPrice = menuPrice;
    }

    public Short getMenuAvailability() {
        return menuAvailability;
    }

    public void setMenuAvailability(Short menuAvailability) {
        this.menuAvailability = menuAvailability;
    }

    @XmlTransient
    public Collection<Foods> getFoodsCollection() {
        return foodsCollection;
    }

    public void setFoodsCollection(Collection<Foods> foodsCollection) {
        this.foodsCollection = foodsCollection;
    }

    @XmlTransient
    public Collection<Orders> getOrdersCollection() {
        return ordersCollection;
    }

    public void setOrdersCollection(Collection<Orders> ordersCollection) {
        this.ordersCollection = ordersCollection;
    }

    public Dates getIdDate() {
        return idDate;
    }

    public void setIdDate(Dates idDate) {
        this.idDate = idDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMenu != null ? idMenu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Menus)) {
            return false;
        }
        Menus other = (Menus) object;
        if ((this.idMenu == null && other.idMenu != null) || (this.idMenu != null && !this.idMenu.equals(other.idMenu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Classes.Menus[ idMenu=" + idMenu + " ]";
    }
    
}
