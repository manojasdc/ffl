package com.BisagN.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.BisagN.models.Role;
import com.BisagN.models.TB_LDAP_MODULE_MASTER;

@Repository
public interface ModuleMasterRepository  extends JpaRepository<TB_LDAP_MODULE_MASTER,Integer>{

	@Query("FROM TB_LDAP_MODULE_MASTER U where U.module_name=?1")
	public Role findByModuleName(String role);

	@Query("FROM TB_LDAP_MODULE_MASTER U")
	public List<TB_LDAP_MODULE_MASTER> LoadModuleDataList();

	@Query("FROM TB_LDAP_MODULE_MASTER U")
	public List<TB_LDAP_MODULE_MASTER> LoadModuleData();

	@Query("FROM TB_LDAP_MODULE_MASTER where module_name=?1")
	public List CheckModuleNameexist(String modulename);
	
	@Query(value = "FROM TB_LDAP_MODULE_MASTER U where (?1 is null or CONCAT(lower(U.module_name)) LIKE %?1%)", countQuery = "select count(*) From TB_LDAP_MODULE_MASTER")
	Page<TB_LDAP_MODULE_MASTER> LoadModuleData(String search,Pageable pageable);
	
	@Query("FROM TB_LDAP_MODULE_MASTER U ")
	public List<TB_LDAP_MODULE_MASTER> LoadModuleData1();
	
}
