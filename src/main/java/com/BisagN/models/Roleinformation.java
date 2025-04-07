/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BisagN.models;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author rdp
 */
@Entity
@Table(name = "roleinformation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Roleinformation.findAll", query = "SELECT r FROM Roleinformation r"),
    @NamedQuery(name = "Roleinformation.findByRoleId", query = "SELECT r FROM Roleinformation r WHERE r.roleId = :roleId"),
    @NamedQuery(name = "Roleinformation.findByRole", query = "SELECT r FROM Roleinformation r WHERE r.role = :role"),
    @NamedQuery(name = "Roleinformation.findByRoleType", query = "SELECT r FROM Roleinformation r WHERE r.roleType = :roleType"),
    @NamedQuery(name = "Roleinformation.findByRoleUrl", query = "SELECT r FROM Roleinformation r WHERE r.roleUrl = :roleUrl"),
    @NamedQuery(name = "Roleinformation.findByAccessLvl", query = "SELECT r FROM Roleinformation r WHERE r.accessLvl = :accessLvl"),
    @NamedQuery(name = "Roleinformation.findBySubAccessLvl", query = "SELECT r FROM Roleinformation r WHERE r.subAccessLvl = :subAccessLvl"),
    @NamedQuery(name = "Roleinformation.findByStaffLvl", query = "SELECT r FROM Roleinformation r WHERE r.staffLvl = :staffLvl")})
public class Roleinformation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "role_id")
    private Integer roleId;
    @Basic(optional = false)
    @Column(name = "role")
    private String role;
    @Column(name = "role_type")
    private String roleType;
    @Column(name = "role_url")
    private String roleUrl;
    @Column(name = "access_lvl")
    private String accessLvl;
    @Column(name = "sub_access_lvl")
    private String subAccessLvl;
    @Column(name = "staff_lvl")
    private String staffLvl;


    public Roleinformation() {
    }

    public Roleinformation(Integer roleId) {
        this.roleId = roleId;
    }

    public Roleinformation(Integer roleId, String role) {
        this.roleId = roleId;
        this.role = role;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRoleType() {
        return roleType;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }

    public String getRoleUrl() {
        return roleUrl;
    }

    public void setRoleUrl(String roleUrl) {
        this.roleUrl = roleUrl;
    }

    public String getAccessLvl() {
        return accessLvl;
    }

    public void setAccessLvl(String accessLvl) {
        this.accessLvl = accessLvl;
    }

    public String getSubAccessLvl() {
        return subAccessLvl;
    }

    public void setSubAccessLvl(String subAccessLvl) {
        this.subAccessLvl = subAccessLvl;
    }

    public String getStaffLvl() {
        return staffLvl;
    }

    public void setStaffLvl(String staffLvl) {
        this.staffLvl = staffLvl;
    }

   

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (roleId != null ? roleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Roleinformation)) {
            return false;
        }
        Roleinformation other = (Roleinformation) object;
        if ((this.roleId == null && other.roleId != null) || (this.roleId != null && !this.roleId.equals(other.roleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.BisagN.models.Roleinformation[ roleId=" + roleId + " ]";
    }
    
}
