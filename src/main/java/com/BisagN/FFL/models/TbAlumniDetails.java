//package com.BisagN.FFL.models;
//
//import java.io.Serializable;
//import java.util.Date;
//import javax.persistence.Basic;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.NamedQueries;
//import javax.persistence.NamedQuery;
//import javax.persistence.Table;
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;
//import javax.validation.constraints.NotEmpty;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Pattern;
//
//@Entity
//@Table(name = "tb_alumni_details")
//public class TbAlumniDetails implements Serializable {
//
//    private static final long serialVersionUID = 1L;
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Basic(optional = false)
//    @Column(name = "id")
//    private Integer id;
//    @Column(name = "profile_picture")
//    private String profilePicture;
//	@NotEmpty(message = "Line 1 is mandatory")
//	@NotNull(message = "Line 1 is mandatory")
//	//@Pattern(regexp = "^[a-zA-Z0-9,&. ]*$", message = "Please Enter Valid line1 ")
//    @Column(name = "line1")
//    private String line1;
//    @Column(name = "institute_map")
//    private Integer instituteMap;
//    @Column(name = "rejected_remarks")
//    private String rejectedRemarks;
//    @Column(name = "approval_status")
//    private String approvalStatus;
//    @Column(name = "created_by")
//    private Integer createdBy;
//    @Column(name = "created_date")
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date createdDate;
//    @Column(name = "modify_by")
//    private Integer modifyBy;
//    @Column(name = "modifed_date")
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date modifedDate;
//    @Column(name = "status")
//    private String status;
//    @NotEmpty(message = "line 2 is mandatory")
//	@NotNull(message = "line 2 is mandatory")
//	//@Pattern(regexp = "^[a-zA-Z0-9,&. ]*$", message = "Please Enter Valid line 2 ")
//    @Column(name = "line2")
//    private String line2;
//    @NotEmpty(message = "Pincode is mandatory")
//  	@NotNull(message = "Pincode is mandatory")
//    @Column(name = "pincode")
//    private String pincode;
//    @JoinColumn(name = "city_id", referencedColumnName = "id")
//    @ManyToOne
//    private TbCityName cityId;
//    @JoinColumn(name = "country_id", referencedColumnName = "id")
//    @ManyToOne
//    private TbCountryName countryId;
//    @JoinColumn(name = "state_id", referencedColumnName = "id")
//    @ManyToOne
//    private TbStateName stateId;
//
//    public TbAlumniDetails() {
//    }
//
//    public TbAlumniDetails(Integer id) {
//        this.id = id;
//    }
//
//    public String getProfilePicture() {
//        return profilePicture;
//    }
//
//    public void setProfilePicture(String profilePicture) {
//        this.profilePicture = profilePicture;
//    }
//
//    public String getLine1() {
//        return line1;
//    }
//
//    public void setLine1(String line1) {
//        this.line1 = line1;
//    }
//
//    public Integer getInstituteMap() {
//        return instituteMap;
//    }
//
//    public void setInstituteMap(Integer instituteMap) {
//        this.instituteMap = instituteMap;
//    }
//
//    public String getRejectedRemarks() {
//        return rejectedRemarks;
//    }
//
//    public void setRejectedRemarks(String rejectedRemarks) {
//        this.rejectedRemarks = rejectedRemarks;
//    }
//
//    public String getApprovalStatus() {
//        return approvalStatus;
//    }
//
//    public void setApprovalStatus(String approvalStatus) {
//        this.approvalStatus = approvalStatus;
//    }
//
//    public Integer getCreatedBy() {
//        return createdBy;
//    }
//
//    public void setCreatedBy(Integer createdBy) {
//        this.createdBy = createdBy;
//    }
//
//    public Date getCreatedDate() {
//        return createdDate;
//    }
//
//    public void setCreatedDate(Date createdDate) {
//        this.createdDate = createdDate;
//    }
//
//    public Integer getModifyBy() {
//        return modifyBy;
//    }
//
//    public void setModifyBy(Integer modifyBy) {
//        this.modifyBy = modifyBy;
//    }
//
//    public Date getModifedDate() {
//        return modifedDate;
//    }
//
//    public void setModifedDate(Date modifedDate) {
//        this.modifedDate = modifedDate;
//    }
//
//    public String getStatus() {
//        return status;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public String getLine2() {
//        return line2;
//    }
//
//    public void setLine2(String line2) {
//        this.line2 = line2;
//    }
//
//    public String getPincode() {
//        return pincode;
//    }
//
//    public void setPincode(String pincode) {
//        this.pincode = pincode;
//    }
//
//    public TbCityName getCityId() {
//        return cityId;
//    }
//
//    public void setCityId(TbCityName cityId) {
//        this.cityId = cityId;
//    }
//
//    public TbCountryName getCountryId() {
//        return countryId;
//    }
//
//    public void setCountryId(TbCountryName countryId) {
//        this.countryId = countryId;
//    }
//
//    public TbStateName getStateId() {
//        return stateId;
//    }
//
//    public void setStateId(TbStateName stateId) {
//        this.stateId = stateId;
//    }
//
//    @Override
//    public int hashCode() {
//        int hash = 0;
//        hash += (id != null ? id.hashCode() : 0);
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object object) {
//        // TODO: Warning - this method won't work in the case the id fields are not set
//        if (!(object instanceof TbAlumniDetails)) {
//            return false;
//        }
//        TbAlumniDetails other = (TbAlumniDetails) object;
//        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
//            return false;
//        }
//        return true;
//    }
//
//    @Override
//    public String toString() {
//        return "com.mycompany.mavenproject1.TbAlumniDetails[ id=" + id + " ]";
//    }
//    
//}