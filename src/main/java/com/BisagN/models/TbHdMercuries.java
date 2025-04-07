/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author rdp
 */
@Entity
@Table(name = "tb_hd_mercuries")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbHdMercuries.findAll", query = "SELECT t FROM TbHdMercuries t"),
    @NamedQuery(name = "TbHdMercuries.findById", query = "SELECT t FROM TbHdMercuries t WHERE t.id = :id"),
    @NamedQuery(name = "TbHdMercuries.findByCreatedBy", query = "SELECT t FROM TbHdMercuries t WHERE t.createdBy = :createdBy"),
    @NamedQuery(name = "TbHdMercuries.findByCreatedOn", query = "SELECT t FROM TbHdMercuries t WHERE t.createdOn = :createdOn"),
    @NamedQuery(name = "TbHdMercuries.findByMsg", query = "SELECT t FROM TbHdMercuries t WHERE t.msg = :msg"),
    @NamedQuery(name = "TbHdMercuries.findByStatus", query = "SELECT t FROM TbHdMercuries t WHERE t.status = :status"),
    @NamedQuery(name = "TbHdMercuries.findByUserid", query = "SELECT t FROM TbHdMercuries t WHERE t.userid = :userid"),
    @NamedQuery(name = "TbHdMercuries.findByValidUpto", query = "SELECT t FROM TbHdMercuries t WHERE t.validUpto = :validUpto")})
public class TbHdMercuries implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "created_by")
    private String createdBy;
    @Column(name = "created_on")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;
    @Column(name = "msg")
    private String msg;
    @Column(name = "status")
    private String status;
    @Basic(optional = false)
    @Column(name = "userid")
    private int userid;
    @Column(name = "valid_upto")
    @Temporal(TemporalType.TIMESTAMP)
    private Date validUpto;

    public TbHdMercuries() {
    }

    public TbHdMercuries(Integer id) {
        this.id = id;
    }

    public TbHdMercuries(Integer id, int userid) {
        this.id = id;
        this.userid = userid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public Date getValidUpto() {
        return validUpto;
    }

    public void setValidUpto(Date validUpto) {
        this.validUpto = validUpto;
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
        if (!(object instanceof TbHdMercuries)) {
            return false;
        }
        TbHdMercuries other = (TbHdMercuries) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.BisagN.models.TbHdMercuries[ id=" + id + " ]";
    }
    
}
