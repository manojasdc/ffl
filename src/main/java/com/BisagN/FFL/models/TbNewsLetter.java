
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
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author bisag
 */
@Entity
@Table(name = "tb_news_letter")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "TbNewsLetter.findAll", query = "SELECT t FROM TbNewsLetter t"),
		@NamedQuery(name = "TbNewsLetter.findById", query = "SELECT t FROM TbNewsLetter t WHERE t.id = :id"),
		@NamedQuery(name = "TbNewsLetter.findByDescription", query = "SELECT t FROM TbNewsLetter t WHERE t.description = :description"),
		@NamedQuery(name = "TbNewsLetter.findByUploadPdf", query = "SELECT t FROM TbNewsLetter t WHERE t.uploadPdf = :uploadPdf"),
		@NamedQuery(name = "TbNewsLetter.findByCreatedBy", query = "SELECT t FROM TbNewsLetter t WHERE t.createdBy = :createdBy"),
		@NamedQuery(name = "TbNewsLetter.findByCreatedDate", query = "SELECT t FROM TbNewsLetter t WHERE t.createdDate = :createdDate"),
		@NamedQuery(name = "TbNewsLetter.findByModifiedBy", query = "SELECT t FROM TbNewsLetter t WHERE t.modifiedBy = :modifiedBy"),
		@NamedQuery(name = "TbNewsLetter.findByModifiedDate", query = "SELECT t FROM TbNewsLetter t WHERE t.modifiedDate = :modifiedDate"),
		@NamedQuery(name = "TbNewsLetter.findByStatus", query = "SELECT t FROM TbNewsLetter t WHERE t.status = :status") })
public class TbNewsLetter implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id")
	private Integer id;
	@Column(name = "description")
	@NotEmpty(message = "News Letter Description is mandatory")
    @Size(min = 2, max=256, message = "News Letter Description must be between 2 and 256 characters long") 
	private String description;
	@Column(name = "news_letter_name")
	@NotEmpty(message = "News Letter Name is mandatory")
	@Size(min = 2, max = 100, message = "News Letter Name must be between 2 and 100 characters long")
    @Pattern(regexp = "[a-zA-Z0-9\\s]*", message = "Invalid News Letter Name. Only alphanumeric characters and spaces are allowed.")
	private String newsLetterName;
	@Column(name = "upload_pdf")
	private String uploadPdf;
	@Column(name = "created_by")
	private Integer createdBy;
	@Column(name = "created_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;
	@Column(name = "modified_by")
	private Integer modifiedBy;
	@Column(name = "modified_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifiedDate;
	@Column(name = "status")
	private Character status;
	@Column(name = "approval_status")
	private String approvalStatus;
	@Column(name = "rejected_remarks")
	private String rejectedRemarks;
	@Column(name = "institute_map")
	private Integer instituteMap;

	public TbNewsLetter() {
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

	public Integer getInstituteMap() {
		return instituteMap;
	}

	public void setInstituteMap(Integer instituteMap) {
		this.instituteMap = instituteMap;
	}

	public TbNewsLetter(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUploadPdf() {
		return uploadPdf;
	}

	public void setUploadPdf(String uploadPdf) {
		this.uploadPdf = uploadPdf;
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

	public Integer getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(Integer modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public Character getStatus() {
		return status;
	}

	public void setStatus(Character status) {
		this.status = status;
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
		if (!(object instanceof TbNewsLetter)) {
			return false;
		}
		TbNewsLetter other = (TbNewsLetter) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "javaapplication3.TbNewsLetter[ id=" + id + " ]";
	}

	public String getNewsLetterName() {
		return newsLetterName;
	}

	public void setNewsLetterName(String newsLetterName) {
		this.newsLetterName = newsLetterName;
	}

}
