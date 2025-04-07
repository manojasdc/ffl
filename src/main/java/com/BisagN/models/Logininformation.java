/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BisagN.models;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author rdp
 */
@Entity
@Table(name = "logininformation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Logininformation.findAll", query = "SELECT l FROM Logininformation l"),
    @NamedQuery(name = "Logininformation.findByUserid", query = "SELECT l FROM Logininformation l WHERE l.userid = :userid"),
    @NamedQuery(name = "Logininformation.findByUsername", query = "SELECT l FROM Logininformation l WHERE l.username = :username"),
    @NamedQuery(name = "Logininformation.findByPassword", query = "SELECT l FROM Logininformation l WHERE l.password = :password"),
    @NamedQuery(name = "Logininformation.findByEnabled", query = "SELECT l FROM Logininformation l WHERE l.enabled = :enabled"),
    @NamedQuery(name = "Logininformation.findByAccountnonexpired", query = "SELECT l FROM Logininformation l WHERE l.accountnonexpired = :accountnonexpired"),
    @NamedQuery(name = "Logininformation.findByAccountnonlocked", query = "SELECT l FROM Logininformation l WHERE l.accountnonlocked = :accountnonlocked"),
    @NamedQuery(name = "Logininformation.findByCredentialsnonexpired", query = "SELECT l FROM Logininformation l WHERE l.credentialsnonexpired = :credentialsnonexpired"),
    @NamedQuery(name = "Logininformation.findByLoginName", query = "SELECT l FROM Logininformation l WHERE l.loginName = :loginName"),
    @NamedQuery(name = "Logininformation.findByCreatedOn", query = "SELECT l FROM Logininformation l WHERE l.createdOn = :createdOn"),
    @NamedQuery(name = "Logininformation.findByModifiedOn", query = "SELECT l FROM Logininformation l WHERE l.modifiedOn = :modifiedOn"),
    @NamedQuery(name = "Logininformation.findByAcDcDate", query = "SELECT l FROM Logininformation l WHERE l.acDcDate = :acDcDate"),
    @NamedQuery(name = "Logininformation.findByArmyNo", query = "SELECT l FROM Logininformation l WHERE l.armyNo = :armyNo"),
    @NamedQuery(name = "Logininformation.findByCreatedBy", query = "SELECT l FROM Logininformation l WHERE l.createdBy = :createdBy"),
    @NamedQuery(name = "Logininformation.findByRoleMap", query = "SELECT l FROM Logininformation l WHERE l.roleMap = :roleMap")})
public class Logininformation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "userid")
    private Integer userid;
    @Basic(optional = false)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @Column(name = "enabled")
    private short enabled;
    @Basic(optional = false)
    @Column(name = "accountnonexpired")
    private short accountnonexpired;
    @Basic(optional = false)
    @Column(name = "accountnonlocked")
    private short accountnonlocked;
    @Basic(optional = false)
    @Column(name = "credentialsnonexpired")
    private short credentialsnonexpired;
    @Column(name = "login_name")
    private String loginName;
    @Column(name = "created_on")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;
    @Column(name = "modified_on")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedOn;
    @Column(name = "ac_dc_date")
    private String acDcDate;
    @Column(name = "army_no")
    private String armyNo;
    @Column(name = "created_by")
    private String createdBy;
    @Column(name = "role_map")
    private Integer roleMap;
   

    public Logininformation() {
    }

    public Logininformation(Integer userid) {
        this.userid = userid;
    }

    public Logininformation(Integer userid, String username, String password, short enabled, short accountnonexpired, short accountnonlocked, short credentialsnonexpired) {
        this.userid = userid;
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.accountnonexpired = accountnonexpired;
        this.accountnonlocked = accountnonlocked;
        this.credentialsnonexpired = credentialsnonexpired;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public short getEnabled() {
        return enabled;
    }

    public void setEnabled(short enabled) {
        this.enabled = enabled;
    }

    public short getAccountnonexpired() {
        return accountnonexpired;
    }

    public void setAccountnonexpired(short accountnonexpired) {
        this.accountnonexpired = accountnonexpired;
    }

    public short getAccountnonlocked() {
        return accountnonlocked;
    }

    public void setAccountnonlocked(short accountnonlocked) {
        this.accountnonlocked = accountnonlocked;
    }

    public short getCredentialsnonexpired() {
        return credentialsnonexpired;
    }

    public void setCredentialsnonexpired(short credentialsnonexpired) {
        this.credentialsnonexpired = credentialsnonexpired;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
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

    public String getAcDcDate() {
        return acDcDate;
    }

    public void setAcDcDate(String acDcDate) {
        this.acDcDate = acDcDate;
    }

    public String getArmyNo() {
        return armyNo;
    }

    public void setArmyNo(String armyNo) {
        this.armyNo = armyNo;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Integer getRoleMap() {
        return roleMap;
    }

    public void setRoleMap(Integer roleMap) {
        this.roleMap = roleMap;
    }

  

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userid != null ? userid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Logininformation)) {
            return false;
        }
        Logininformation other = (Logininformation) object;
        if ((this.userid == null && other.userid != null) || (this.userid != null && !this.userid.equals(other.userid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.BisagN.models.Logininformation[ userid=" + userid + " ]";
    }
    
}
