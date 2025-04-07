package com.BisagN.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.BisagN.models.TB_LDAP_MODULE_MASTER;
import com.BisagN.models.TB_LDAP_SUBMODULE_MASTER;

@Repository
public interface SubModuleMasterRepository extends JpaRepository<TB_LDAP_SUBMODULE_MASTER,Integer>{


	@Query("FROM TB_LDAP_SUBMODULE_MASTER U")
	public List<TB_LDAP_SUBMODULE_MASTER> LoadSubModuleData();

	@Query("FROM TB_LDAP_SUBMODULE_MASTER U where submodule_name = ?2 and module.id=?1")
	public List CheckSubModuleNameexist(int modulename, String submodname);
	
	@Query(value = "SELECT sm.id,mm.module_name,sm.submodule_name FROM tb_ldap_submodule_master sm inner join tb_ldap_module_master mm on mm.id=sm.module_id where"
			+ " (:search is null or CONCAT(lower(mm.module_name),lower(sm.submodule_name)) LIKE %:search%) group by mm.module_name,sm.id",nativeQuery = true)
	List<Map<String,Object>> LoadSubModuleDataList(String search,Pageable pageable);
	
	@Query(value = "SELECT count(*) FROM tb_ldap_submodule_master sm inner join tb_ldap_module_master mm on mm.id=sm.module_id where (:search is null or CONCAT(lower(mm.module_name),lower(sm.submodule_name)) LIKE %:search%) ", nativeQuery = true)
	public int  LoadSubModuleDataListCount(String search);
	
	@Query(value = "FROM TB_LDAP_SUBMODULE_MASTER where module_id=:id")
	List<TB_LDAP_SUBMODULE_MASTER> LoadSubModuleData2(@Param("id") int id);
	
	@Query("From TB_LDAP_SUBMODULE_MASTER where module.id=:id")
	public List<TB_LDAP_SUBMODULE_MASTER> LoadSubModuleData1(@Param("id") int id);
}
