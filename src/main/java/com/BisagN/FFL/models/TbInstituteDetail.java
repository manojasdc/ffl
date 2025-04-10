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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author rdp
 */
@Entity
@Table(name = "tb_institute_detail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbInstituteDetail.findAll", query = "SELECT t FROM TbInstituteDetail t"),
    @NamedQuery(name = "TbInstituteDetail.findById", query = "SELECT t FROM TbInstituteDetail t WHERE t.id = :id"),
    @NamedQuery(name = "TbInstituteDetail.findByInstituteName", query = "SELECT t FROM TbInstituteDetail t WHERE t.instituteName = :instituteName")})
public class TbInstituteDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "institute_name")
    private String instituteName;

    public TbInstituteDetail() {
    }

    public TbInstituteDetail(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInstituteName() {
        return instituteName;
    }

    public void setInstituteName(String instituteName) {
        this.instituteName = instituteName;
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
        if (!(object instanceof TbInstituteDetail)) {
            return false;
        }
        TbInstituteDetail other = (TbInstituteDetail) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication1.TbInstituteDetail[ id=" + id + " ]";
    }
    
}
