package com.BisagN.FFL.models;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_bulletin")
public class TbBulletin {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "title", nullable = false)
    String title;

    @Column(name = "description", nullable = false)
    String description;
    
    @Column(name = "approvalstatus")
    String aprovalstatus;
    
    @Column(name = "created_by")
    String created_by;
    
    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(name = "date", nullable = false)
    LocalDate date;

    @OneToMany(mappedBy = "bulletin", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    List<TbBulletinComments> comments;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public List<TbBulletinComments> getComments() {
        return comments;
    }

    public void setComments(List<TbBulletinComments> comments) {
        this.comments = comments;
    }

	public String getAprovalstatus() {
		return aprovalstatus;
	}

	public void setAprovalstatus(String aprovalstatus) {
		this.aprovalstatus = aprovalstatus;
	}

	public String getCreated_by() {
		return created_by;
	}

	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}
    
}
