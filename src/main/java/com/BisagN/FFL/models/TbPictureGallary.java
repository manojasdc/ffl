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
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "tb_picture_gallary")
@XmlRootElement
public class TbPictureGallary implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "category")
    private String category;
    @NotEmpty(message = "Description is mandatory")
    @Size(min = 2, max=128, message = "Picture Description must be between 2 and 256 characters long") 
	@Column(name = "description")
	private String description;
    @Column(name = "image_upload")
    private String imageUpload;
    @Column(name = "status")
    private Character status;
    @Column(name = "created_by")
    private Integer createdBy;
    @Column(name = "institute_map")
    private Integer instituteMap;
    @Column(name = "approval_status")
    private String approvalStatus;
    @Column(name = "rejected_remarks")
    private String rejectedRemarks;
    public TbPictureGallary() {
    }

    public TbPictureGallary(Integer id) {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUpload() {
        return imageUpload;
    }

    public void setImageUpload(String imageUpload) {
        this.imageUpload = imageUpload;
    }

    public Character getStatus() {
        return status;
    }
	public Integer getInstituteMap() {
		return instituteMap;
	}

	public void setInstituteMap(Integer instituteMap) {
		this.instituteMap = instituteMap;
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
        if (!(object instanceof TbPictureGallary)) {
            return false;
        }
        TbPictureGallary other = (TbPictureGallary) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication2.TbPictureGallary[ id=" + id + " ]";
    }
    
}
