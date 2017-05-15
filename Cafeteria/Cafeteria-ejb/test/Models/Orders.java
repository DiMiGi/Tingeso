/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Rodrigo
 */
@Entity
@Table(name = "orders")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Orders.findAll", query = "SELECT o FROM Orders o")
    , @NamedQuery(name = "Orders.findByIdOrders", query = "SELECT o FROM Orders o WHERE o.ordersPK.idOrders = :idOrders")
    , @NamedQuery(name = "Orders.findByOrdersAddress", query = "SELECT o FROM Orders o WHERE o.ordersAddress = :ordersAddress")
    , @NamedQuery(name = "Orders.findByOrdersManager", query = "SELECT o FROM Orders o WHERE o.ordersManager = :ordersManager")
    , @NamedQuery(name = "Orders.findByMenusIdMenus", query = "SELECT o FROM Orders o WHERE o.ordersPK.menusIdMenus = :menusIdMenus")})
public class Orders implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected OrdersPK ordersPK;
    @Size(max = 45)
    @Column(name = "orders_address")
    private String ordersAddress;
    @Size(max = 45)
    @Column(name = "orders_manager")
    private String ordersManager;
    @ManyToMany(mappedBy = "ordersCollection")
    private Collection<Foods> foodsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orders")
    private Collection<Users> usersCollection;

    public Orders() {
    }

    public Orders(OrdersPK ordersPK) {
        this.ordersPK = ordersPK;
    }

    public Orders(int idOrders, int menusIdMenus) {
        this.ordersPK = new OrdersPK(idOrders, menusIdMenus);
    }

    public OrdersPK getOrdersPK() {
        return ordersPK;
    }

    public void setOrdersPK(OrdersPK ordersPK) {
        this.ordersPK = ordersPK;
    }

    public String getOrdersAddress() {
        return ordersAddress;
    }

    public void setOrdersAddress(String ordersAddress) {
        this.ordersAddress = ordersAddress;
    }

    public String getOrdersManager() {
        return ordersManager;
    }

    public void setOrdersManager(String ordersManager) {
        this.ordersManager = ordersManager;
    }

    @XmlTransient
    public Collection<Foods> getFoodsCollection() {
        return foodsCollection;
    }

    public void setFoodsCollection(Collection<Foods> foodsCollection) {
        this.foodsCollection = foodsCollection;
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
        hash += (ordersPK != null ? ordersPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Orders)) {
            return false;
        }
        Orders other = (Orders) object;
        if ((this.ordersPK == null && other.ordersPK != null) || (this.ordersPK != null && !this.ordersPK.equals(other.ordersPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Models.Orders[ ordersPK=" + ordersPK + " ]";
    }
    
}
