
package com.BisagN.FFL.models;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "tb_hall_of_fame")
@XmlRootElement

public class TbHallOfFame implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "photo")
	private String photo;
	@Column(name = "achievement")
    @NotEmpty(message = "Achievment is mandatory")  
    @Size(min = 2, max=256, message = "Achievment must be between 2 and 256 characters long") 
	private String achievement;
	@Column(name = "created_by")
	private Integer createdBy;
	@Column(name = "created_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;
	@Column(name = "modify_by")
	private Integer modifyBy;
	@Column(name = "modifed_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifedDate;
	@Column(name = "status")
	private String status;
	@Column(name = "institute_map")
	private Integer instituteMap;
	@Column(name = "approval_status")
	private String approvalStatus;
	@Column(name = "rejected_remarks")
	private String rejectedRemarks;

	public TbHallOfFame() {

	}

	public TbHallOfFame(Integer id) {
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

	public String getAchievement() {
		return achievement;
	}

	public void setAchievement(String achievement) {
		this.achievement = achievement;
	}

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Integer getModifyBy() {
		return modifyBy;
	}

	public void setModifyBy(Integer modifyBy) {
		this.modifyBy = modifyBy;
	}

	public Date getModifedDate() {
		return modifedDate;
	}

	public void setModifedDate(Date modifedDate) {
		this.modifedDate = modifedDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getInstituteMap() {
		return instituteMap;
	}

	public void setInstituteMap(Integer instituteMap) {
		this.instituteMap = instituteMap;
	}

	public String getApprovalStatus() {
		return approvalStatus;
	}

	public void setApprovalStatus(String approvalStatus) {
		this.approvalStatus = approvalStatus;
	}

	public String getRejectedRemarks() {
		return rejectedRemarks;
	}

	public void setRejectedRemarks(String rejectedRemarks) {
		this.rejectedRemarks = rejectedRemarks;
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
		if (!(object instanceof TbHallOfFame)) {
			return false;
		}
		TbHallOfFame other = (TbHallOfFame) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "javaapplication3.TbHallOfFame[ id=" + id + " ]";
	}

}
