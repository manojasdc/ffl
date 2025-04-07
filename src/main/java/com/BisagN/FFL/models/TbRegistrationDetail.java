
package com.BisagN.FFL.models;

import java.io.Serializable;
import java.util.Collection;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author bisag
 */
@Entity
@Table(name = "tb_registration_detail")
@XmlRootElement
public class TbRegistrationDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "alumni_name")
    private String alumniName;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "email_id")
    private String emailId;
    @Column(name = "contact_number")
    private String contactNumber;
    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Column(name = "password")
    private String passworddd;
    
	@Column(name = "gender")
    private String gender;
	
	@Column(name = "userid")
    private Integer userid;
	
    public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	@OneToMany(mappedBy = "registrationId")
    private Collection<TbRegistrationDetailChild> tbRegistrationDetailChildCollection;
    @JoinColumn(name = "country_id", referencedColumnName = "id")
    @ManyToOne
    private TbCountryName countryId;

    public TbRegistrationDetail() {
    }

    public TbRegistrationDetail(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAlumniName() {
        return alumniName;
    }

    public void setAlumniName(String alumniName) {
        this.alumniName = alumniName;
    }

    public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
    public String getPassworddd() {
		return passworddd;
	}

	public void setPassworddd(String passworddd) {
		this.passworddd = passworddd;
	}

//    public String getRegistrationStatus() {
//        return registrationStatus;
//    }
//
//    public void setRegistrationStatus(String registrationStatus) {
//        this.registrationStatus = registrationStatus;
//    }

//    public Integer getInstituteId() {
//        return instituteId;
//    }
//
//    public void setInstituteId(Integer instituteId) {
//        this.instituteId = instituteId;
//    }
//
//    public String getRollNumber() {
//        return rollNumber;
//    }
//
//    public void setRollNumber(String rollNumber) {
//        this.rollNumber = rollNumber;
//    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
    

    public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@XmlTransient
    public Collection<TbRegistrationDetailChild> getTbRegistrationDetailChildCollection() {
        return tbRegistrationDetailChildCollection;
    }

    public void setTbRegistrationDetailChildCollection(Collection<TbRegistrationDetailChild> tbRegistrationDetailChildCollection) {
        this.tbRegistrationDetailChildCollection = tbRegistrationDetailChildCollection;
    }

    public TbCountryName getCountryId() {
        return countryId;
    }

    public void setCountryId(TbCountryName countryId) {
        this.countryId = countryId;
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
        if (!(object instanceof TbRegistrationDetail)) {
            return false;
        }
        TbRegistrationDetail other = (TbRegistrationDetail) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication4.TbRegistrationDetail[ id=" + id + " ]";
    }
    
}
