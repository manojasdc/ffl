package com.BisagN.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.BisagN.models.Role;
import com.BisagN.models.UserLogin;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

	@Query("FROM Role U where U.role=?1")
	public Role findRole_url(String role);

	@Query(value = "SELECT t.msg from tb_hd_mercuries t WHERE t.valid_upto >= now()", nativeQuery = true)
	public List<String> getLayoutlist();

	@Query(value = "SELECT nextval('login_visitor_count')", nativeQuery = true)
	public int VisitorCounter();
	
	@Query(value = "SELECT * FROM roleinformation where access_lvl=?1", nativeQuery = true)
	List<Role> LoadRoleData(String access_level);

	@Query(value = "SELECT * FROM roleinformation where role = 'ADMIN' or role = 'EMBASSY ADMIN'", nativeQuery = true)
	List<Role> LoadRoleData2();
	
	@Query(value = "SELECT * FROM roleinformation where role = 'USER'", nativeQuery = true)
	List<Role> LoadRoleData1();

	@Query("FROM Role where role=?1")
	public List CheckRoleNameexist(String rolename);
	
	@Query(value="select role_id from roleinformation where role='USER'", nativeQuery = true)
	public Integer getroleid();
	
	@Query("FROM TB_LDAP_ROLEMASTER ro JOIN  TB_LDAP_SCREEN_MASTER sc on ro.screen.id = sc.id where sc.screen_url=?1 and ro.roleid=?2")
	public List ScreenRedirect(String screen_url, Integer roleid);
	
	@Query("From Role order by role")
	public List<Role> getRoleType();

}
