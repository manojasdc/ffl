/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BisagN.FFL.models;

import java.io.Serializable;
import java.util.Collection;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_state_name")
@NamedQueries({
    @NamedQuery(name = "TbStateName.findAll", query = "SELECT t FROM TbStateName t"),
    @NamedQuery(name = "TbStateName.findById", query = "SELECT t FROM TbStateName t WHERE t.id = :id"),
    @NamedQuery(name = "TbStateName.findByStateName", query = "SELECT t FROM TbStateName t WHERE t.stateName = :stateName")})
public class TbStateName implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "state_name")
    private String stateName;
    @JoinColumn(name = "country_id", referencedColumnName = "id")
    @ManyToOne
    private TbCountryName countryId;
    @OneToMany(mappedBy = "stateId")
    private Collection<TbCityName> tbCityNameCollection;
   

    public TbStateName() {
    }

    public TbStateName(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public TbCountryName getCountryId() {
        return countryId;
    }

    public void setCountryId(TbCountryName countryId) {
        this.countryId = countryId;
    }

    public Collection<TbCityName> getTbCityNameCollection() {
        return tbCityNameCollection;
    }

    public void setTbCityNameCollection(Collection<TbCityName> tbCityNameCollection) {
        this.tbCityNameCollection = tbCityNameCollection;
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
        if (!(object instanceof TbStateName)) {
            return false;
        }
        TbStateName other = (TbStateName) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mavenproject1.TbStateName[ id=" + id + " ]";
    }
    
}
