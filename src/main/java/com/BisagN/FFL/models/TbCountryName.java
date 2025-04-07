
package com.BisagN.FFL.models;

import java.io.Serializable;
import java.util.Collection;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


@Entity
@Table(name = "tb_country_name")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbCountryName.findAll", query = "SELECT t FROM TbCountryName t"),
    @NamedQuery(name = "TbCountryName.findById", query = "SELECT t FROM TbCountryName t WHERE t.id = :id"),
    @NamedQuery(name = "TbCountryName.findByCountryName", query = "SELECT t FROM TbCountryName t WHERE t.countryName = :countryName"),
    @NamedQuery(name = "TbCountryName.findByFlagImage", query = "SELECT t FROM TbCountryName t WHERE t.flagImage = :flagImage")})
public class TbCountryName implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "country_name")
    private String countryName;
    @Column(name = "flag_image")
    private String flagImage;
    @Column(name = "country_code")
    private String country_code;
  

    public TbCountryName() {
    }

    public TbCountryName(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getFlagImage() {
        return flagImage;
    }

    public void setFlagImage(String flagImage) {
        this.flagImage = flagImage;
    }
  
    public String getCountry_code() {
		return country_code;
	}

	public void setCountry_code(String country_code) {
		this.country_code = country_code;
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
        if (!(object instanceof TbCountryName)) {
            return false;
        }
        TbCountryName other = (TbCountryName) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication3.TbCountryName[ id=" + id + " ]";
    }
    
}
