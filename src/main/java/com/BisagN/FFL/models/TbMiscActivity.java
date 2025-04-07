
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
@Table(name = "tb_misc_activity")
@XmlRootElement
public class TbMiscActivity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id; 
    @Column(name = "misc_title")
    @NotEmpty(message = "Title is mandatory")
    @Size(min = 2, max=100, message = "Title must be between 2 and 100 characters long") 
    private String miscTitle;	
    @Column(name = "misc_description")
	@NotEmpty(message = "Description is mandatory")
    @Size(min = 2, max=256, message = "Description must be between 2 and 256 characters long") 
    private String miscDescription;
    @Column(name = "misc_photo")
    private String miscPhoto;
//    @Column(name = "year")
//	@NotNull(message = "Year is mandatory")
//    private String year;
    @Column(name = "created_by")
    private Integer createdBy;
    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Column(name = "modify_by")
    private Integer modifyBy;
    @Column(name = "modify_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifyDate;
    @Column(name = "status")
    private Character status;
    @Column(name = "institute_map")
    private Integer instituteMap;
	@Column(name = "approval_status")
	private String approvalStatus;
	@Column(name = "rejected_remarks")
	private String rejectedRemarks;
	@Column(name = "image")
	private String image;
	@Column(name = "userid")
	private String userid;
    public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public TbMiscActivity() {
    }

    public TbMiscActivity(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMiscTitle() {
        return miscTitle;
    }

    public void setMiscTitle(String miscTitle) {
        this.miscTitle = miscTitle;
    }

    public String getMiscDescription() {
        return miscDescription;
    }

    public void setMiscDescription(String miscDescription) {
        this.miscDescription = miscDescription;
    }

    public String getMiscPhoto() {
        return miscPhoto;
    }

    public void setMiscPhoto(String miscPhoto) {
        this.miscPhoto = miscPhoto;
    }
//
//    public String getYear() {
//        return year;
//    }
//
//    public void setYear(String year) {
//        this.year = year;
//    }
//    
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

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public Character getStatus() {
        return status;
    }

    public void setStatus(Character status) {
        this.status = status;
    }
    
    

   

    public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Integer getInstituteMap() {
		return instituteMap;
	}

	public void setInstituteMap(Integer instituteMap) {
		this.instituteMap = instituteMap;
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
        if (!(object instanceof TbMiscActivity)) {
            return false;
        }
        TbMiscActivity other = (TbMiscActivity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication3.TbMiscActivity[ id=" + id + " ]";
    }
    
}