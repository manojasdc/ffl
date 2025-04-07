package com.BisagN.models;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

//@Entity
//@Table(name = "tb_ldap_user_master", uniqueConstraints = {
//@UniqueConstraint(columnNames = "id") })
public class TB_LDAP_USER_MASTER {
	@Basic(optional = false)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@NotEmpty(message = "login name should not be empty")

	@Pattern(regexp = "^[a-zA-Z0-9_]+$", message = "login Name must be Valid and in number and alphabet")
//	@Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*[0-9])[a-zA-Z0-9]+$", message = "login Name must be Valid and in number and alphabet")
	@Column(name = "login_name")
	private String login_name;

	@NotEmpty(message = "username should not be empty")
//	@Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*[0-9])[a-zA-Z0-9]+$", message = "user Name must be Valid and in number and alphabet")
	@Column(name = "username", unique = true, nullable = false, length = 45)
	private String user_name;

	@Column(name = "army_no")
	@NotEmpty(message = "army number should not be empty")
	private String army_no;

	@Column(name = "password", nullable = false, length = 45)
	@NotEmpty(message = "Password should not be empty")
	private String user_password;

	@NotEmpty(message = "RePassword  should not be empty")
	private String user_re_password;

	@NotNull(message = "Role should not be empty")
	private int user_role_id;

	private String role_ro_type;
	private String school_name;

	private String school_short_name;
	
	private int instituteId;

	public int getInstituteId() {
		return instituteId;
	}

	public void setInstituteId(int instituteId) {
		this.instituteId = instituteId;
	}

	public String getSchool_name() {
		return school_name;
	}

	public void setSchool_name(String school_name) {
		this.school_name = school_name;
	}

	public String getSchool_short_name() {
		return school_short_name;
	}

	public void setSchool_short_name(String school_short_name) {
		this.school_short_name = school_short_name;
	}

	public String getRole_ro_type() {
		return role_ro_type;
	}

	public void setRole_ro_type(String role_ro_type) {
		this.role_ro_type = role_ro_type;
	}

	public String getLogin_name() {
		return login_name;
	}

	public void setLogin_name(String login_name) {
		this.login_name = login_name;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getArmy_no() {
		return army_no;
	}

	public void setArmy_no(String army_no) {
		this.army_no = army_no;
	}

	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

	public String getUser_re_password() {
		return user_re_password;
	}

	public void setUser_re_password(String user_re_password) {
		this.user_re_password = user_re_password;
	}

	public int getUser_role_id() {
		return user_role_id;
	}

	public void setUser_role_id(int user_role_id) {
		this.user_role_id = user_role_id;
	}

}
