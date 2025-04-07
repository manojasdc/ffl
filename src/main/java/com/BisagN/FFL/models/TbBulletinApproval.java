package com.BisagN.FFL.models;

import javax.persistence.*;

@Entity
@Table(name = "tb_bulletin_approval")
public class TbBulletinApproval {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;  // Primary Key

    private Integer bulletin_id;
    private String username;
    private String approveStatus;
     
    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBulletin_id() {
        return bulletin_id;
    }

    public void setBulletin_id(Integer bulletin_id) {
        this.bulletin_id = bulletin_id;
    }

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String isApproveStatus() {
		return approveStatus;
	}

	public void setApproveStatus(String approveStatus) {
		this.approveStatus = approveStatus;
	}

}
