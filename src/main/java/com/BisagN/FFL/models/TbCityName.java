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

/**
 *
 * @author bisag
 */
@Entity
@Table(name = "tb_city_name")
@NamedQueries({
    @NamedQuery(name = "TbCityName.findAll", query = "SELECT t FROM TbCityName t"),
    @NamedQuery(name = "TbCityName.findById", query = "SELECT t FROM TbCityName t WHERE t.id = :id"),
    @NamedQuery(name = "TbCityName.findByCityName", query = "SELECT t FROM TbCityName t WHERE t.cityName = :cityName")})
public class TbCityName implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "city_name")
    private String cityName;
    @JoinColumn(name = "country_id", referencedColumnName = "id")
    @ManyToOne
    private TbCountryName countryId;
    @JoinColumn(name = "state_id", referencedColumnName = "id")
    @ManyToOne
    private TbStateName stateId;
  

    public TbCityName() {
    }

    public TbCityName(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public TbCountryName getCountryId() {
        return countryId;
    }

    public void setCountryId(TbCountryName countryId) {
        this.countryId = countryId;
    }

    public TbStateName getStateId() {
        return stateId;
    }

    public void setStateId(TbStateName stateId) {
        this.stateId = stateId;
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
        if (!(object instanceof TbCityName)) {
            return false;
        }
        TbCityName other = (TbCityName) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mavenproject1.TbCityName[ id=" + id + " ]";
    }
    
}
