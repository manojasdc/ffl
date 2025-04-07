/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.BisagN.FFL.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author bisag
 */
@Entity
@Table(name = "tb_profile_dtl")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbProfileDtl.findAll", query = "SELECT t FROM TbProfileDtl t"),
    @NamedQuery(name = "TbProfileDtl.findById", query = "SELECT t FROM TbProfileDtl t WHERE t.id = :id"),
    @NamedQuery(name = "TbProfileDtl.findByPhoto", query = "SELECT t FROM TbProfileDtl t WHERE t.photo = :photo"),
    @NamedQuery(name = "TbProfileDtl.findByName", query = "SELECT t FROM TbProfileDtl t WHERE t.name = :name"),
    @NamedQuery(name = "TbProfileDtl.findByEmailId", query = "SELECT t FROM TbProfileDtl t WHERE t.emailId = :emailId"),
    @NamedQuery(name = "TbProfileDtl.findByContactNo", query = "SELECT t FROM TbProfileDtl t WHERE t.contactNo = :contactNo"),
    @NamedQuery(name = "TbProfileDtl.findByGender", query = "SELECT t FROM TbProfileDtl t WHERE t.gender = :gender"),
    @NamedQuery(name = "TbProfileDtl.findByCreatedBy", query = "SELECT t FROM TbProfileDtl t WHERE t.createdBy = :createdBy"),
    @NamedQuery(name = "TbProfileDtl.findByAddress", query = "SELECT t FROM TbProfileDtl t WHERE t.address = :address"),
    @NamedQuery(name = "TbProfileDtl.findByDateOfBirth", query = "SELECT t FROM TbProfileDtl t WHERE t.dateOfBirth = :dateOfBirth")})
public class TbProfileDtl implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "photo")
    private String photo;
    @Column(name = "name")
    private String name;
    @Column(name = "email_id")
    private String emailId;
    @Column(name = "contact_no")
    private String contactNo;
    @Column(name = "gender")
    private String gender;
    @Column(name = "created_by")
    private Integer createdBy;

	@Column(name = "address")
    private String address;
    @Column(name = "date_of_birth")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOfBirth;
	@Column(name = "status")
	private String status;

    public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public TbProfileDtl() {
    }
    public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}


    public TbProfileDtl(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }



    public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
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
        if (!(object instanceof TbProfileDtl)) {
            return false;
        }
        TbProfileDtl other = (TbProfileDtl) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication4.TbProfileDtl[ id=" + id + " ]";
    }
    
}
