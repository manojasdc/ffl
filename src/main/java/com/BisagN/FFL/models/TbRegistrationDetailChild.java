
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

/**
 *
 * @author bisag
 */
@Entity
@Table(name = "tb_registration_detail_child")
@XmlRootElement
@NamedQueries({
		@NamedQuery(name = "TbRegistrationDetailChild.findAll", query = "SELECT t FROM TbRegistrationDetailChild t"),
		@NamedQuery(name = "TbRegistrationDetailChild.findById", query = "SELECT t FROM TbRegistrationDetailChild t WHERE t.id = :id"),
		@NamedQuery(name = "TbRegistrationDetailChild.findByPassoutYear", query = "SELECT t FROM TbRegistrationDetailChild t WHERE t.passoutYear = :passoutYear"),
		@NamedQuery(name = "TbRegistrationDetailChild.findByRollNumber", query = "SELECT t FROM TbRegistrationDetailChild t WHERE t.rollNumber = :rollNumber") })
public class TbRegistrationDetailChild implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id")
	private Integer id;
	@Column(name = "passout_year")
	private Integer passoutYear;
	@Column(name = "roll_number")
	private String rollNumber;
	@Column(name = "registration_status")
	private String registrationStatus;
	@Column(name = "embasy_status")
	private String embasyStatus;
	@JoinColumn(name = "institute_id", referencedColumnName = "id")
	@ManyToOne
	private TbInstituteDetail instituteId;
	@JoinColumn(name = "registration_id", referencedColumnName = "id")
	@ManyToOne
	private TbRegistrationDetail registrationId;

	public TbRegistrationDetailChild() {
	}

	public TbRegistrationDetailChild(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPassoutYear() {
		return passoutYear;
	}

	public void setPassoutYear(Integer passoutYear) {
		this.passoutYear = passoutYear;
	}

	public String getRollNumber() {
		return rollNumber;
	}

	public void setRollNumber(String rollNumber) {
		this.rollNumber = rollNumber;
	}

	public TbInstituteDetail getInstituteId() {
		return instituteId;
	}

	public void setInstituteId(TbInstituteDetail instituteId) {
		this.instituteId = instituteId;
	}

	public TbRegistrationDetail getRegistrationId() {
		return registrationId;
	}

	public void setRegistrationId(TbRegistrationDetail registrationId) {
		this.registrationId = registrationId;
	}

	public String getRegistrationStatus() {
		return registrationStatus;
	}

	public void setRegistrationStatus(String registrationStatus) {
		this.registrationStatus = registrationStatus;
	}

	public String getEmbasyStatus() {
		return embasyStatus;
	}

	public void setEmbasyStatus(String embasyStatus) {
		this.embasyStatus = embasyStatus;
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
		if (!(object instanceof TbRegistrationDetailChild)) {
			return false;
		}
		TbRegistrationDetailChild other = (TbRegistrationDetailChild) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "javaapplication4.TbRegistrationDetailChild[ id=" + id + " ]";
	}

}
