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

@Entity
@Table(name = "tb_user_alumni_ejournal")
@XmlRootElement
public class TbUserAlumniEjournal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "category")
    @NotEmpty(message = "category should not be empty")
    private String category;
    @Column(name = "name")
    @NotEmpty(message = "Title should not be empty")
    @Size(min = 2, max=100, message = "Title must be between 2 and 100 characters long") 
    private String name;
    @Column(name = "description")
    @NotEmpty(message = "Description should not be empty")
    @Size(min = 2, max=125, message = "Description must be between 2 and 125 characters long") 
    private String description; 
    @Column(name = "upload_pdf")
    private String uploadPdf;
    @Column(name = "approval_status")
    private String approvalStatus;
    @Column(name = "rejected_remarks")
    private String rejectedRemarks;
    @Column(name = "status")
    private Character status;
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
    @Column(name = "institute_map")
    private Integer instituteMap;
    @Column(name = "publisher")
    @NotEmpty(message = "publisher should not be empty")
    @Size(min = 2, max=125, message = "Publisher must be between 2 and 125 characters long") 
    private String publisher;
    @Column(name = "publisher_date")
    @Temporal(TemporalType.DATE)
    private Date publisherDate;
    @Column(name = "language")
    @NotEmpty(message = "Language should not be empty")
    @Size(min = 2, max=100, message = "Language must be between 2 and 100 characters long") 
    private String language;
    @Column(name = "book_length")
    @NotNull(message = "book Length should not be null")
//    @Size(max=4, message = "book Length Should  Should Contains Only 4 Digits.") 
    private Integer bookLength;
    @Column(name = "cover_photo")
    private String coverPhoto;
    @Column(name = "author")
    @NotEmpty(message = "Author should not be empty")
    @Size(min = 2, max=100, message = "Author must be between 2 and 100 characters long") 

    private String author;

    public TbUserAlumniEjournal() {
    }

    public TbUserAlumniEjournal(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Character getStatus() {
        return status;
    }

    public void setStatus(Character status) {
        this.status = status;
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

    public Integer getInstituteMap() {
        return instituteMap;
    }

    public void setInstituteMap(Integer instituteMap) {
        this.instituteMap = instituteMap;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Date getPublisherDate() {
        return publisherDate;
    }

    public void setPublisherDate(Date publisherDate) {
        this.publisherDate = publisherDate;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Integer getBookLength() {
        return bookLength;
    }

    public void setBookLength(Integer bookLength) {
        this.bookLength = bookLength;
    }

    public String getCoverPhoto() {
        return coverPhoto;
    }

    public void setCoverPhoto(String coverPhoto) {
        this.coverPhoto = coverPhoto;
    }
    
    public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
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
        if (!(object instanceof TbUserAlumniEjournal)) {
            return false;
        }
        TbUserAlumniEjournal other = (TbUserAlumniEjournal) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.BisagN.FFL.models.TbUserAlumniEjournal[ id=" + id + " ]";
    }
    
}
