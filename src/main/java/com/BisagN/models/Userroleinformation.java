/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BisagN.models;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author rdp
 */
@Entity
@Table(name = "userroleinformation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Userroleinformation.findAll", query = "SELECT u FROM Userroleinformation u"),
    @NamedQuery(name = "Userroleinformation.findByUserRoleId", query = "SELECT u FROM Userroleinformation u WHERE u.userRoleId = :userRoleId"),
    @NamedQuery(name = "Userroleinformation.findByCreatedOn", query = "SELECT u FROM Userroleinformation u WHERE u.createdOn = :createdOn"),
    @NamedQuery(name = "Userroleinformation.findByModifiedOn", query = "SELECT u FROM Userroleinformation u WHERE u.modifiedOn = :modifiedOn")})
public class Userroleinformation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "user_role_id")
    private Integer userRoleId;
    @Column(name = "created_on")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;
    @Column(name = "modified_on")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedOn;
    @JoinColumn(name = "user_id", referencedColumnName = "userid")
    @OneToOne(optional = false)
    private UserLogin userId;
    @JoinColumn(name = "role_id", referencedColumnName = "role_id")
    @ManyToOne(optional = false)
    private Role roleId;

    public Userroleinformation() {
    }

    public Userroleinformation(Integer userRoleId) {
        this.userRoleId = userRoleId;
    }

    public Integer getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(Integer userRoleId) {
        this.userRoleId = userRoleId;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Date getModifiedOn() {
        return modifiedOn;
    }

    public void setModifiedOn(Date modifiedOn) {
        this.modifiedOn = modifiedOn;
    }

    public UserLogin getUserId() {
        return userId;
    }

    public void setUserId(UserLogin userId) {
        this.userId = userId;
    }

    public Role getRoleId() {
        return roleId;
    }

    public void setRoleId(Role roleId) {
        this.roleId = roleId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userRoleId != null ? userRoleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Userroleinformation)) {
            return false;
        }
        Userroleinformation other = (Userroleinformation) object;
        if ((this.userRoleId == null && other.userRoleId != null) || (this.userRoleId != null && !this.userRoleId.equals(other.userRoleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.BisagN.models.Userroleinformation[ userRoleId=" + userRoleId + " ]";
    }
    
}
