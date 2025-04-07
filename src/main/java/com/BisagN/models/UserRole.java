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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "userroleinformation", uniqueConstraints = {
		@UniqueConstraint(columnNames = "user_role_id"),
		@UniqueConstraint(columnNames = "user_id") })
public class UserRole {
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Basic(optional = false)
	    @Column(name = "user_role_id")
	    private Integer user_role_id;
	 	
	    @JoinColumn(name = "role_id", referencedColumnName = "role_id")
	    @NotNull
	    @ManyToOne(optional = false)//,cascade = CascadeType.PERSIST
		private Role role_id;
	    
	    @JoinColumn(name = "user_id", referencedColumnName = "userid")
	    @ManyToOne(optional = false)//,cascade = CascadeType.PERSIST
		private UserLogin userid;
	    
		@Column(name = "created_on")
		private Date created_on;
		
		@Column(name = "modified_on")
		private Date modified_on;
	   
		public UserLogin getUserid() {
			return userid;
		}
		public void setUserid(UserLogin userid) {
			this.userid = userid;
		}
		public Role getRole_id() {
			return role_id;
		}
		public void setRole_id(Role role_id) {
			this.role_id = role_id;
		}
		public UserRole() {
	    }
	    public UserRole(Integer user_role_id) {
	        this.user_role_id = user_role_id;
    }

		public Integer getUser_role_id() {
			return user_role_id;
		}


		public void setUser_role_id(Integer user_role_id) {
			this.user_role_id = user_role_id;
		}
	
		public Date getCreated_on() {
			return created_on;
		}
		public void setCreated_on(Date created_on) {
			this.created_on = created_on;
		}
		public Date getModified_on() {
			return modified_on;
		}
		public void setModified_on(Date modified_on) {
			this.modified_on = modified_on;
		}



		

	
//	    public UserRole(Integer roleId) {
//	        this.roleId = roleId;
//	    }
//
//	    public UserRole(Integer roleId, String role) {
//	        this.roleId = roleId;
//	        this.role = role;
//	    }
//
//	    public Integer getRoleId() {
//	        return roleId;
//	    }
//
//	    public void setRoleId(Integer roleId) {
//	        this.roleId = roleId;
//	    }
	    
	
}