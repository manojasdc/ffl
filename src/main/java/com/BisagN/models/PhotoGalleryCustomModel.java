package com.BisagN.models;

import java.util.Date;

public class PhotoGalleryCustomModel {
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	private int distincteventid;
    private String eventnamedata;
    
    private Date createddate;
	public int getDistincteventid() {
		return distincteventid;
	}
	public String getEventnamedata() {
		return eventnamedata;
	}

	public Date getCreateddate() {
		return createddate;
	}
	public void setDistincteventid(int distincteventid) {
		this.distincteventid = distincteventid;
	}
	public void setEventnamedata(String eventnamedata) {
		this.eventnamedata = eventnamedata;
	}

	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
	}
	public PhotoGalleryCustomModel(int distincteventid, String eventnamedata
		) {
		super();
		this.distincteventid = distincteventid;
		this.eventnamedata = eventnamedata;
		
	};

}
