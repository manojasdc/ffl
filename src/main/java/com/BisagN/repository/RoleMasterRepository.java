package com.BisagN.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.BisagN.models.Role;
import com.BisagN.models.TB_LDAP_ROLEMASTER;

@Repository
public interface RoleMasterRepository extends JpaRepository<TB_LDAP_ROLEMASTER, Integer> {

//	@Query("From TB_LDAP_ROLEMASTER order by role_type")
//	public List<TB_LDAP_ROLEMASTER> getRoleType();
	
//	@Query("FROM TB_LDAP_ROLEMASTER U where (?1 is null or CONCAT(lower(U.screen.screen_name),lower(U.module.module_name),lower(U.sub_module.submodule_name)) LIKE %?1%)")
//	public List<TB_LDAP_ROLEMASTER> LoadRoleMasterData(String search);
	

	@Query(value = "FROM TB_LDAP_ROLEMASTER U where (?1 is null or CONCAT(lower(U.screen.screen_name),lower(U.module.module_name),lower(U.sub_module.submodule_name)) LIKE %?1%)"
			, countQuery = "select count(*) From TB_LDAP_ROLEMASTER U where (?1 is null or CONCAT(lower(U.screen.screen_name),lower(U.module.module_name),lower(U.sub_module.submodule_name)) LIKE %?1%)")
	Page<TB_LDAP_ROLEMASTER> LoadRoleMasterData1(String search, Pageable pageable);
	

	
	
	@Query("FROM TB_LDAP_ROLEMASTER where roleid=?1 and  module.id=?2 and sub_module.id=?3 and screen.id=?4")
	List<TB_LDAP_ROLEMASTER> CheckRoleNameexist1(Integer rolename,Integer module,Integer sub_module,Integer screen);
	
}
