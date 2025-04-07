package com.BisagN.FFL.models;

import javax.persistence.*;

@Entity
@Table(name = "tb_bulletin_comments")
public class TbBulletinComments {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;

	@Column(name = "comment", nullable = false)
	private String comment;

	@ManyToOne
	@JoinColumn(name = "bulletin_id", nullable = false)
	TbBulletin bulletin;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	} 

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public TbBulletin getBulletin() {
		return bulletin;
	}

	@Override
	public String toString() {
		return "TbBulletinComments [id=" + id + ", comment=" + comment + ", bulletin=" + bulletin + "]";
	}
	
	
}
