package com.BisagN.FFL.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_admin_setting")
public class TbAdminSetting {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;

	String imageurl;
	String flag;
	String text;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getImageurl() {
		return imageurl;
	}

	public void setImageurl(String imageurl) {
		this.imageurl = imageurl;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return "TbAdminSetting [imageurl=" + imageurl + ", flag=" + flag + ", text=" + text + "]";
	}

}
