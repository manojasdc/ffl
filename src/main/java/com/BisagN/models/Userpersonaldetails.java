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
@Table(name = "userpersonaldetails")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Userpersonaldetails.findAll", query = "SELECT u FROM Userpersonaldetails u"),
    @NamedQuery(name = "Userpersonaldetails.findByUserid", query = "SELECT u FROM Userpersonaldetails u WHERE u.userid = :userid"),
    @NamedQuery(name = "Userpersonaldetails.findByFirstname", query = "SELECT u FROM Userpersonaldetails u WHERE u.firstname = :firstname"),
    @NamedQuery(name = "Userpersonaldetails.findByEmail", query = "SELECT u FROM Userpersonaldetails u WHERE u.email = :email"),
    @NamedQuery(name = "Userpersonaldetails.findByMobilenumber", query = "SELECT u FROM Userpersonaldetails u WHERE u.mobilenumber = :mobilenumber"),
    @NamedQuery(name = "Userpersonaldetails.findByServicetype", query = "SELECT u FROM Userpersonaldetails u WHERE u.servicetype = :servicetype"),
    @NamedQuery(name = "Userpersonaldetails.findByStatus", query = "SELECT u FROM Userpersonaldetails u WHERE u.status = :status"),
    @NamedQuery(name = "Userpersonaldetails.findByNeetregno", query = "SELECT u FROM Userpersonaldetails u WHERE u.neetregno = :neetregno"),
    @NamedQuery(name = "Userpersonaldetails.findByAadhaarnumber", query = "SELECT u FROM Userpersonaldetails u WHERE u.aadhaarnumber = :aadhaarnumber"),
    @NamedQuery(name = "Userpersonaldetails.findByGender", query = "SELECT u FROM Userpersonaldetails u WHERE u.gender = :gender"),
    @NamedQuery(name = "Userpersonaldetails.findByDob", query = "SELECT u FROM Userpersonaldetails u WHERE u.dob = :dob"),
    @NamedQuery(name = "Userpersonaldetails.findByAddress", query = "SELECT u FROM Userpersonaldetails u WHERE u.address = :address"),
    @NamedQuery(name = "Userpersonaldetails.findByAttemptnumber", query = "SELECT u FROM Userpersonaldetails u WHERE u.attemptnumber = :attemptnumber"),
    @NamedQuery(name = "Userpersonaldetails.findByPrevregnum", query = "SELECT u FROM Userpersonaldetails u WHERE u.prevregnum = :prevregnum"),
    @NamedQuery(name = "Userpersonaldetails.findByCreateby", query = "SELECT u FROM Userpersonaldetails u WHERE u.createby = :createby"),
    @NamedQuery(name = "Userpersonaldetails.findByCreatedate", query = "SELECT u FROM Userpersonaldetails u WHERE u.createdate = :createdate"),
    @NamedQuery(name = "Userpersonaldetails.findByModifyby", query = "SELECT u FROM Userpersonaldetails u WHERE u.modifyby = :modifyby"),
    @NamedQuery(name = "Userpersonaldetails.findByModifydate", query = "SELECT u FROM Userpersonaldetails u WHERE u.modifydate = :modifydate"),
    @NamedQuery(name = "Userpersonaldetails.findByPrioritymarks", query = "SELECT u FROM Userpersonaldetails u WHERE u.prioritymarks = :prioritymarks"),
    @NamedQuery(name = "Userpersonaldetails.findByNeetmarks", query = "SELECT u FROM Userpersonaldetails u WHERE u.neetmarks = :neetmarks"),
    @NamedQuery(name = "Userpersonaldetails.findByApptype", query = "SELECT u FROM Userpersonaldetails u WHERE u.apptype = :apptype"),
    @NamedQuery(name = "Userpersonaldetails.findByCategory", query = "SELECT u FROM Userpersonaldetails u WHERE u.category = :category"),
    @NamedQuery(name = "Userpersonaldetails.findByChancebeingavailed", query = "SELECT u FROM Userpersonaldetails u WHERE u.chancebeingavailed = :chancebeingavailed"),
    @NamedQuery(name = "Userpersonaldetails.findByDegree", query = "SELECT u FROM Userpersonaldetails u WHERE u.degree = :degree"),
    @NamedQuery(name = "Userpersonaldetails.findByCollegeoruniversity", query = "SELECT u FROM Userpersonaldetails u WHERE u.collegeoruniversity = :collegeoruniversity"),
    @NamedQuery(name = "Userpersonaldetails.findByYearofpassing", query = "SELECT u FROM Userpersonaldetails u WHERE u.yearofpassing = :yearofpassing"),
    @NamedQuery(name = "Userpersonaldetails.findByDegreeordiplomacertno", query = "SELECT u FROM Userpersonaldetails u WHERE u.degreeordiplomacertno = :degreeordiplomacertno"),
    @NamedQuery(name = "Userpersonaldetails.findByDiplomasubject", query = "SELECT u FROM Userpersonaldetails u WHERE u.diplomasubject = :diplomasubject"),
    @NamedQuery(name = "Userpersonaldetails.findByRound", query = "SELECT u FROM Userpersonaldetails u WHERE u.round = :round"),
    @NamedQuery(name = "Userpersonaldetails.findByRoundstatus", query = "SELECT u FROM Userpersonaldetails u WHERE u.roundstatus = :roundstatus"),
    @NamedQuery(name = "Userpersonaldetails.findByMiddlename", query = "SELECT u FROM Userpersonaldetails u WHERE u.middlename = :middlename"),
    @NamedQuery(name = "Userpersonaldetails.findByLastname", query = "SELECT u FROM Userpersonaldetails u WHERE u.lastname = :lastname"),
    @NamedQuery(name = "Userpersonaldetails.findByYear", query = "SELECT u FROM Userpersonaldetails u WHERE u.year = :year")})
public class Userpersonaldetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "userid")
    private Long userid;
    @Column(name = "firstname")
    private String firstname;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Column(name = "mobilenumber")
    private String mobilenumber;
    @Basic(optional = false)
    @Column(name = "servicetype")
    private String servicetype;
    @Column(name = "status")
    private Character status;
    @Basic(optional = false)
    @Column(name = "neetregno")
    private String neetregno;
    @Column(name = "aadhaarnumber")
    private String aadhaarnumber;
    @Column(name = "gender")
    private String gender;
    @Column(name = "dob")
    private String dob;
    @Column(name = "address")
    private String address;
    @Column(name = "attemptnumber")
    private String attemptnumber;
    @Column(name = "prevregnum")
    private String prevregnum;
    @Column(name = "createby")
    private Integer createby;
    @Column(name = "createdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdate;
    @Column(name = "modifyby")
    private Integer modifyby;
    @Column(name = "modifydate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifydate;
    @Column(name = "prioritymarks")
    private String prioritymarks;
    @Column(name = "neetmarks")
    private String neetmarks;
    @Column(name = "apptype")
    private String apptype;
    @Column(name = "category")
    private String category;
    @Column(name = "chancebeingavailed")
    private String chancebeingavailed;
    @Column(name = "degree")
    private String degree;
    @Column(name = "collegeoruniversity")
    private String collegeoruniversity;
    @Column(name = "yearofpassing")
    private String yearofpassing;
    @Column(name = "degreeordiplomacertno")
    private String degreeordiplomacertno;
    @Column(name = "diplomasubject")
    private String diplomasubject;
    @Basic(optional = false)
    @Column(name = "round")
    private int round;
    @Column(name = "roundstatus")
    private String roundstatus;
    @Column(name = "middlename")
    private String middlename;
    @Column(name = "lastname")
    private String lastname;
    @Column(name = "year")
    private String year;

    public Userpersonaldetails() {
    }

    public Userpersonaldetails(Long userid) {
        this.userid = userid;
    }

    public Userpersonaldetails(Long userid, String email, String servicetype, String neetregno, int round) {
        this.userid = userid;
        this.email = email;
        this.servicetype = servicetype;
        this.neetregno = neetregno;
        this.round = round;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobilenumber() {
        return mobilenumber;
    }

    public void setMobilenumber(String mobilenumber) {
        this.mobilenumber = mobilenumber;
    }

    public String getServicetype() {
        return servicetype;
    }

    public void setServicetype(String servicetype) {
        this.servicetype = servicetype;
    }

    public Character getStatus() {
        return status;
    }

    public void setStatus(Character status) {
        this.status = status;
    }

    public String getNeetregno() {
        return neetregno;
    }

    public void setNeetregno(String neetregno) {
        this.neetregno = neetregno;
    }

    public String getAadhaarnumber() {
        return aadhaarnumber;
    }

    public void setAadhaarnumber(String aadhaarnumber) {
        this.aadhaarnumber = aadhaarnumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAttemptnumber() {
        return attemptnumber;
    }

    public void setAttemptnumber(String attemptnumber) {
        this.attemptnumber = attemptnumber;
    }

    public String getPrevregnum() {
        return prevregnum;
    }

    public void setPrevregnum(String prevregnum) {
        this.prevregnum = prevregnum;
    }

    public Integer getCreateby() {
        return createby;
    }

    public void setCreateby(Integer createby) {
        this.createby = createby;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Integer getModifyby() {
        return modifyby;
    }

    public void setModifyby(Integer modifyby) {
        this.modifyby = modifyby;
    }

    public Date getModifydate() {
        return modifydate;
    }

    public void setModifydate(Date modifydate) {
        this.modifydate = modifydate;
    }

    public String getPrioritymarks() {
        return prioritymarks;
    }

    public void setPrioritymarks(String prioritymarks) {
        this.prioritymarks = prioritymarks;
    }

    public String getNeetmarks() {
        return neetmarks;
    }

    public void setNeetmarks(String neetmarks) {
        this.neetmarks = neetmarks;
    }

    public String getApptype() {
        return apptype;
    }

    public void setApptype(String apptype) {
        this.apptype = apptype;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getChancebeingavailed() {
        return chancebeingavailed;
    }

    public void setChancebeingavailed(String chancebeingavailed) {
        this.chancebeingavailed = chancebeingavailed;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getCollegeoruniversity() {
        return collegeoruniversity;
    }

    public void setCollegeoruniversity(String collegeoruniversity) {
        this.collegeoruniversity = collegeoruniversity;
    }

    public String getYearofpassing() {
        return yearofpassing;
    }

    public void setYearofpassing(String yearofpassing) {
        this.yearofpassing = yearofpassing;
    }

    public String getDegreeordiplomacertno() {
        return degreeordiplomacertno;
    }

    public void setDegreeordiplomacertno(String degreeordiplomacertno) {
        this.degreeordiplomacertno = degreeordiplomacertno;
    }

    public String getDiplomasubject() {
        return diplomasubject;
    }

    public void setDiplomasubject(String diplomasubject) {
        this.diplomasubject = diplomasubject;
    }

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public String getRoundstatus() {
        return roundstatus;
    }

    public void setRoundstatus(String roundstatus) {
        this.roundstatus = roundstatus;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userid != null ? userid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Userpersonaldetails)) {
            return false;
        }
        Userpersonaldetails other = (Userpersonaldetails) object;
        if ((this.userid == null && other.userid != null) || (this.userid != null && !this.userid.equals(other.userid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.BisagN.models.Userpersonaldetails[ userid=" + userid + " ]";
    }
    
}
