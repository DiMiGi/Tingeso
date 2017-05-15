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
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Rodrigo
 */
@Entity
@Table(name = "users")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u")
    , @NamedQuery(name = "Users.findByIdUsers", query = "SELECT u FROM Users u WHERE u.idUsers = :idUsers")
    , @NamedQuery(name = "Users.findByUsersName", query = "SELECT u FROM Users u WHERE u.usersName = :usersName")
    , @NamedQuery(name = "Users.findByUsersPass", query = "SELECT u FROM Users u WHERE u.usersPass = :usersPass")
    , @NamedQuery(name = "Users.findByUsersEmail", query = "SELECT u FROM Users u WHERE u.usersEmail = :usersEmail")})
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_users")
    private Integer idUsers;
    @Size(max = 45)
    @Column(name = "users_name")
    private String usersName;
    @Size(max = 45)
    @Column(name = "users_pass")
    private String usersPass;
    @Size(max = 45)
    @Column(name = "users_email")
    private String usersEmail;
    @ManyToMany(mappedBy = "usersCollection")
    private Collection<Dates> datesCollection;
    @JoinColumns({
        @JoinColumn(name = "orders_id_orders", referencedColumnName = "id_orders")
        , @JoinColumn(name = "orders_menus_id_menus", referencedColumnName = "menus_id_menus")})
    @ManyToOne(optional = false)
    private Orders orders;

    public Users() {
    }

    public Users(Integer idUsers) {
        this.idUsers = idUsers;
    }

    public Integer getIdUsers() {
        return idUsers;
    }

    public void setIdUsers(Integer idUsers) {
        this.idUsers = idUsers;
    }

    public String getUsersName() {
        return usersName;
    }

    public void setUsersName(String usersName) {
        this.usersName = usersName;
    }

    public String getUsersPass() {
        return usersPass;
    }

    public void setUsersPass(String usersPass) {
        this.usersPass = usersPass;
    }

    public String getUsersEmail() {
        return usersEmail;
    }

    public void setUsersEmail(String usersEmail) {
        this.usersEmail = usersEmail;
    }

    @XmlTransient
    public Collection<Dates> getDatesCollection() {
        return datesCollection;
    }

    public void setDatesCollection(Collection<Dates> datesCollection) {
        this.datesCollection = datesCollection;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsers != null ? idUsers.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if ((this.idUsers == null && other.idUsers != null) || (this.idUsers != null && !this.idUsers.equals(other.idUsers))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Models.Users[ idUsers=" + idUsers + " ]";
    }
    
}
