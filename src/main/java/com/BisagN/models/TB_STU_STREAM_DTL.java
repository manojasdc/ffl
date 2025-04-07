package com.BisagN.models;


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

/**
 *
 * @author rdp
 */
@Entity
@Table(name = "tb_stu_stream_dtl")
/*
 * @NamedQueries({
 * 
 * @NamedQuery(name = "TB_STU_STREAM_DTL.findAll", query =
 * "SELECT t FROM TB_STU_STREAM_DTL t"),
 * 
 * @NamedQuery(name = "TB_STU_STREAM_DTL.findById", query =
 * "SELECT t FROM TB_STU_STREAM_DTL t WHERE t.id = :id"),
 * 
 * @NamedQuery(name = "TB_STU_STREAM_DTL.findByStreamName", query =
 * "SELECT t FROM TB_STU_STREAM_DTL t WHERE t.streamName = :streamName"),
 * 
 * @NamedQuery(name = "TB_STU_STREAM_DTL.findByStatus", query =
 * "SELECT t FROM TB_STU_STREAM_DTL t WHERE t.status = :status"),
 * 
 * @NamedQuery(name = "TB_STU_STREAM_DTL.findByCreatedBy", query =
 * "SELECT t FROM TB_STU_STREAM_DTL t WHERE t.createdBy = :createdBy"),
 * 
 * @NamedQuery(name = "TB_STU_STREAM_DTL.findByCreatedDate", query =
 * "SELECT t FROM TB_STU_STREAM_DTL t WHERE t.createdDate = :createdDate"),
 * 
 * @NamedQuery(name = "TB_STU_STREAM_DTL.findByModifyBy", query =
 * "SELECT t FROM TB_STU_STREAM_DTL t WHERE t.modifyBy = :modifyBy"),
 * 
 * @NamedQuery(name = "TB_STU_STREAM_DTL.findByModifyDate", query =
 * "SELECT t FROM TB_STU_STREAM_DTL t WHERE t.modifyDate = :modifyDate")})
 */
public class TB_STU_STREAM_DTL implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @NotEmpty(message = "stream Name is mandatory")
    @NotNull(message = "stream Name is mandatory")
    @Pattern(regexp = "^[a-zA-Z]*$",message = "stream Name must be Valid and in alphabet")
    @Column(name = "stream_name")
    private String streamName;
    @Column(name = "status")
    private Character status;
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

    public TB_STU_STREAM_DTL() {
    }

    public TB_STU_STREAM_DTL(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStreamName() {
        return streamName;
    }

    public void setStreamName(String streamName) {
        this.streamName = streamName;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TB_STU_STREAM_DTL)) {
            return false;
        }
        TB_STU_STREAM_DTL other = (TB_STU_STREAM_DTL) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.BisagN.models.TB_STU_STREAM_DTL[ id=" + id + " ]";
    }
}