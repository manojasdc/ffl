package com.BisagN.models;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "logininformation", uniqueConstraints = { @UniqueConstraint(columnNames = "userid"),
		@UniqueConstraint(columnNames = "username") })
public class UserLogin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "userid", unique = true, nullable = false)
	private Integer userId;
	@Column(name = "username", unique = true, nullable = false, length = 45)
	@NotEmpty(message = "username should not be empty")
	private String userName;
	@Column(name = "password", nullable = false, length = 45)
	@NotEmpty(message = "Password should not be empty")
	private String password;
	@Column(name = "enabled", nullable = false, length = 4)
	private int enabled;
	@Column(name = "accountnonexpired")
	private int accountnonexpired;
	@Column(name = "accountnonlocked")
	private int accountnonlocked;
	@Column(name = "credentialsnonexpired")
	private int credentialsnonexpired;
	@Column(name = "ac_dc_date")
	private String ac_dc_date;
	@Column(name = "login_name")
	@NotEmpty(message = "login name should not be empty")
	private String login_name;
	@Column(name = "army_no")
	@NotEmpty(message = "army number should not be empty")
	private String army_no;
	@Column(name = "created_by")
	private String created_by;
	@Column(name = "created_on")
	private Date created_on;
	@Column(name = "role_map")
	private int role_map;
	@Column(name = "institute_id")
	private Integer instituteId;
	@Column(name = "attempt_captcha_count")
	private Integer attempt_captcha_count;
	@Column(name = "cap_locked_date")
	private Date cap_locked_date;

	@Column(name = "role_ro_type")
	private String roleRoType;

	public String getRoleRoType() {
		return roleRoType;
	}

	public void setRoleRoType(String roleRoType) {
		this.roleRoType = roleRoType;
	}

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "userid")
	private Collection<UserRole> userroleinformationCollection;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Collection<UserRole> getUserroleinformationCollection() {
		return userroleinformationCollection;
	}

	public void setUserroleinformationCollection(Collection<UserRole> userroleinformationCollection) {
		this.userroleinformationCollection = userroleinformationCollection;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String string) {
		this.userName = string;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

	public int getAccountnonexpired() {
		return accountnonexpired;
	}

	public void setAccountnonexpired(int accountnonexpired) {
		this.accountnonexpired = accountnonexpired;
	}

	public int getAccountnonlocked() {
		return accountnonlocked;
	}

	public void setAccountnonlocked(int accountnonlocked) {
		this.accountnonlocked = accountnonlocked;
	}

	public int getCredentialsnonexpired() {
		return credentialsnonexpired;
	}

	public void setCredentialsnonexpired(int credentialsnonexpired) {
		this.credentialsnonexpired = credentialsnonexpired;
	}

	public String getAc_dc_date() {
		return ac_dc_date;
	}

	public void setAc_dc_date(String ac_dc_date) {
		this.ac_dc_date = ac_dc_date;
	}

	public String getLogin_name() {
		return login_name;
	}

	public void setLogin_name(String login_name) {
		this.login_name = login_name;
	}

	public String getArmy_no() {
		return army_no;
	}

	public void setArmy_no(String army_no) {
		this.army_no = army_no;
	}

	public String getCreated_by() {
		return created_by;
	}

	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}

	public Date getCreated_on() {
		return created_on;
	}

	public void setCreated_on(Date created_on) {
		this.created_on = created_on;
	}

	public int getRole_map() {
		return role_map;
	}

	public void setRole_map(int role_map) {
		this.role_map = role_map;
	}

//	public UserRole getUserRole() {
//		return userRole;
//	}
//
//	public void setUserRole(UserRole userRole) {
//		this.userRole = userRole;
//	}

	public Integer getInstituteId() {
		return instituteId;
	}

	public void setInstituteId(Integer instituteId) {
		this.instituteId = instituteId;
	}

	public Integer getAttempt_captcha_count() {
		return attempt_captcha_count;
	}

	public void setAttempt_captcha_count(Integer attempt_captcha_count) {
		this.attempt_captcha_count = attempt_captcha_count;
	}

	public Date getCap_locked_date() {
		return cap_locked_date;
	}

	public void setCap_locked_date(Date cap_locked_date) {
		this.cap_locked_date = cap_locked_date;
	}

	public UserLogin(int userId, String userName, String password, String login_name) {

		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.login_name = login_name;
	}

	public UserLogin() {
		super();
	}

}
