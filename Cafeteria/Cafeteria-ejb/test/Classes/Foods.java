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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Rodrigo
 */
@Entity
@Table(name = "foods")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Foods.findAll", query = "SELECT f FROM Foods f")
    , @NamedQuery(name = "Foods.findByIdFood", query = "SELECT f FROM Foods f WHERE f.idFood = :idFood")
    , @NamedQuery(name = "Foods.findByFoodName", query = "SELECT f FROM Foods f WHERE f.foodName = :foodName")
    , @NamedQuery(name = "Foods.findByFoodAvailability", query = "SELECT f FROM Foods f WHERE f.foodAvailability = :foodAvailability")
    , @NamedQuery(name = "Foods.findByFoodDescription", query = "SELECT f FROM Foods f WHERE f.foodDescription = :foodDescription")})
public class Foods implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_FOOD")
    private Integer idFood;
    @Size(max = 50)
    @Column(name = "FOOD_NAME")
    private String foodName;
    @Column(name = "FOOD_AVAILABILITY")
    private Short foodAvailability;
    @Size(max = 200)
    @Column(name = "FOOD_DESCRIPTION")
    private String foodDescription;
    @JoinTable(name = "menus_has_foods", joinColumns = {
        @JoinColumn(name = "ID_FOOD", referencedColumnName = "ID_FOOD")}, inverseJoinColumns = {
        @JoinColumn(name = "ID_MENU", referencedColumnName = "ID_MENU")})
    @ManyToMany
    private Collection<Menus> menusCollection;

    public Foods() {
    }

    public Foods(Integer idFood) {
        this.idFood = idFood;
    }

    public Integer getIdFood() {
        return idFood;
    }

    public void setIdFood(Integer idFood) {
        this.idFood = idFood;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public Short getFoodAvailability() {
        return foodAvailability;
    }

    public void setFoodAvailability(Short foodAvailability) {
        this.foodAvailability = foodAvailability;
    }

    public String getFoodDescription() {
        return foodDescription;
    }

    public void setFoodDescription(String foodDescription) {
        this.foodDescription = foodDescription;
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
        hash += (idFood != null ? idFood.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Foods)) {
            return false;
        }
        Foods other = (Foods) object;
        if ((this.idFood == null && other.idFood != null) || (this.idFood != null && !this.idFood.equals(other.idFood))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Classes.Foods[ idFood=" + idFood + " ]";
    }
    
}
