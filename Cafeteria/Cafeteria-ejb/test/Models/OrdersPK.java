/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Rodrigo
 */
@Embeddable
public class OrdersPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_orders")
    private int idOrders;
    @Basic(optional = false)
    @NotNull
    @Column(name = "menus_id_menus")
    private int menusIdMenus;

    public OrdersPK() {
    }

    public OrdersPK(int idOrders, int menusIdMenus) {
        this.idOrders = idOrders;
        this.menusIdMenus = menusIdMenus;
    }

    public int getIdOrders() {
        return idOrders;
    }

    public void setIdOrders(int idOrders) {
        this.idOrders = idOrders;
    }

    public int getMenusIdMenus() {
        return menusIdMenus;
    }

    public void setMenusIdMenus(int menusIdMenus) {
        this.menusIdMenus = menusIdMenus;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idOrders;
        hash += (int) menusIdMenus;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrdersPK)) {
            return false;
        }
        OrdersPK other = (OrdersPK) object;
        if (this.idOrders != other.idOrders) {
            return false;
        }
        if (this.menusIdMenus != other.menusIdMenus) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Models.OrdersPK[ idOrders=" + idOrders + ", menusIdMenus=" + menusIdMenus + " ]";
    }
    
}
