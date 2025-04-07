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

import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author rdp
 */
@Entity
@Table(name = "tb_thought_dtl")
@NamedQueries({
    @NamedQuery(name = "TbThoughtDtl.findAll", query = "SELECT t FROM TbThoughtDtl t"),
    @NamedQuery(name = "TbThoughtDtl.findById", query = "SELECT t FROM TbThoughtDtl t WHERE t.id = :id"),
    @NamedQuery(name = "TbThoughtDtl.findByThoughtOfDay", query = "SELECT t FROM TbThoughtDtl t WHERE t.thoughtOfDay = :thoughtOfDay"),
    @NamedQuery(name = "TbThoughtDtl.findByCreatedBy", query = "SELECT t FROM TbThoughtDtl t WHERE t.createdBy = :createdBy"),
    @NamedQuery(name = "TbThoughtDtl.findByCreatedDate", query = "SELECT t FROM TbThoughtDtl t WHERE t.createdDate = :createdDate"),
    @NamedQuery(name = "TbThoughtDtl.findByModifyBy", query = "SELECT t FROM TbThoughtDtl t WHERE t.modifyBy = :modifyBy"),
    @NamedQuery(name = "TbThoughtDtl.findByModifyDate", query = "SELECT t FROM TbThoughtDtl t WHERE t.modifyDate = :modifyDate"),
    @NamedQuery(name = "TbThoughtDtl.findByStatus", query = "SELECT t FROM TbThoughtDtl t WHERE t.status = :status")})
public class TbThoughtDtl implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
   
    @Column(name = "thought_of_day")
    private String thoughtOfDay;
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

    public TbThoughtDtl() {
    }

    public TbThoughtDtl(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getThoughtOfDay() {
        return thoughtOfDay;
    }

    public void setThoughtOfDay(String thoughtOfDay) {
        this.thoughtOfDay = thoughtOfDay;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbThoughtDtl)) {
            return false;
        }
        TbThoughtDtl other = (TbThoughtDtl) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.BisagN.models.TbThoughtDtl[ id=" + id + " ]";
    }
    
}
