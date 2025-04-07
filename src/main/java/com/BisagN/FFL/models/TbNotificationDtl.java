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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author rdp
 */
@Entity
@Table(name = "tb_notification_dtl")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbNotificationDtl.findAll", query = "SELECT t FROM TbNotificationDtl t"),
    @NamedQuery(name = "TbNotificationDtl.findByDescription", query = "SELECT t FROM TbNotificationDtl t WHERE t.description = :description"),
    @NamedQuery(name = "TbNotificationDtl.findByNotificationFromId", query = "SELECT t FROM TbNotificationDtl t WHERE t.notificationFromId = :notificationFromId"),
    @NamedQuery(name = "TbNotificationDtl.findByNotificationToId", query = "SELECT t FROM TbNotificationDtl t WHERE t.notificationToId = :notificationToId"),
    @NamedQuery(name = "TbNotificationDtl.findByReadStatus", query = "SELECT t FROM TbNotificationDtl t WHERE t.readStatus = :readStatus"),
    @NamedQuery(name = "TbNotificationDtl.findByCreatedBy", query = "SELECT t FROM TbNotificationDtl t WHERE t.createdBy = :createdBy"),
    @NamedQuery(name = "TbNotificationDtl.findByCreatedDate", query = "SELECT t FROM TbNotificationDtl t WHERE t.createdDate = :createdDate"),
    @NamedQuery(name = "TbNotificationDtl.findByModifiedBy", query = "SELECT t FROM TbNotificationDtl t WHERE t.modifiedBy = :modifiedBy"),
    @NamedQuery(name = "TbNotificationDtl.findByModifiedDate", query = "SELECT t FROM TbNotificationDtl t WHERE t.modifiedDate = :modifiedDate"),
    @NamedQuery(name = "TbNotificationDtl.findByStatus", query = "SELECT t FROM TbNotificationDtl t WHERE t.status = :status"),
    @NamedQuery(name = "TbNotificationDtl.findByModuleId", query = "SELECT t FROM TbNotificationDtl t WHERE t.moduleId = :moduleId"),
    @NamedQuery(name = "TbNotificationDtl.findById", query = "SELECT t FROM TbNotificationDtl t WHERE t.id = :id")})
public class TbNotificationDtl implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "description")
    private String description;
    @Column(name = "notification_from_id")
    private Integer notificationFromId;
    @Column(name = "notification_to_id")
    private Integer notificationToId;
    @Column(name = "read_status")
    private Character readStatus;
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
    @Column(name = "module_id")
    private String moduleId;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    public TbNotificationDtl() {
    }

    public TbNotificationDtl(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getNotificationFromId() {
        return notificationFromId;
    }

    public void setNotificationFromId(Integer notificationFromId) {
        this.notificationFromId = notificationFromId;
    }

    public Integer getNotificationToId() {
        return notificationToId;
    }

    public void setNotificationToId(Integer notificationToId) {
        this.notificationToId = notificationToId;
    }

    public Character getReadStatus() {
        return readStatus;
    }

    public void setReadStatus(Character readStatus) {
        this.readStatus = readStatus;
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

    public String getModuleId() {
        return moduleId;
    }

    public void setModuleId(String moduleId) {
        this.moduleId = moduleId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
        if (!(object instanceof TbNotificationDtl)) {
            return false;
        }
        TbNotificationDtl other = (TbNotificationDtl) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication1.TbNotificationDtl[ id=" + id + " ]";
    }
}
    