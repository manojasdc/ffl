/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.BisagN.FFL.models;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.BisagN.models.UserLogin;


@Entity
@Table(name = "userloginchild")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Userloginchild.findAll", query = "SELECT u FROM Userloginchild u"),
    @NamedQuery(name = "Userloginchild.findById", query = "SELECT u FROM Userloginchild u WHERE u.id = :id")})
public class Userloginchild implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "user_id", referencedColumnName = "userid")
    @ManyToOne
    private UserLogin userId;
    @JoinColumn(name = "institute_id", referencedColumnName = "id")
    @ManyToOne
    private TbInstituteDetail instituteId;

    public Userloginchild() {
    }

    public Userloginchild(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UserLogin getUserId() {
        return userId;
    }

    public void setUserId(UserLogin userId) {
        this.userId = userId;
    }

    public TbInstituteDetail getInstituteId() {
        return instituteId;
    }

    public void setInstituteId(TbInstituteDetail instituteId) {
        this.instituteId = instituteId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Userloginchild)) {
            return false;
        }
        Userloginchild other = (Userloginchild) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication4.Userloginchild[ id=" + id + " ]";
    }
    
}
