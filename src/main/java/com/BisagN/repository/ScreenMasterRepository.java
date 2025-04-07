package com.BisagN.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.BisagN.models.TB_LDAP_SCREEN_MASTER;


	@Repository
	public interface ScreenMasterRepository  extends JpaRepository<TB_LDAP_SCREEN_MASTER,Integer>{
		
		@Query("FROM TB_LDAP_SCREEN_MASTER where screen_name=?1")
		public List CheckScreenNameexist(String screen_name);
		
		@Query(value = "select sc.id,sc.screen_name,sc.screen_url,mm.module_name,sm.submodule_name from tb_ldap_screen_master sc "
				+ "left join tb_ldap_module_master mm on sc.screen_module_id = mm.id "
				+ "left join tb_ldap_submodule_master sm on  sc.screen_submodule_id =sm.id"
				+ " where (:search is null or CONCAT(lower(sc.screen_name),lower(sc.screen_url),lower(mm.module_name),lower(sm.submodule_name)) LIKE %:search%)  ",nativeQuery = true)
		List<Map<String, Object>> LoadScreenDataList(String search, org.springframework.data.domain.Pageable pageable);
	
		//group by mm.module_name,sm.id ORDER BY mm.module_name ASC
		
		
		@Query(value = "select count(*) from tb_ldap_screen_master sc left join tb_ldap_module_master mm on sc.screen_module_id = mm.id "
				+ "left join tb_ldap_submodule_master sm on  sc.screen_submodule_id =sm.id "
				+ "where (:search is null or CONCAT(lower(sc.screen_name),lower(sc.screen_url),lower(mm.module_name),lower(sm.submodule_name)) LIKE %:search%) ", nativeQuery = true)
		public int  LoadScreenMasterDataListCount(String search);

		
		
		@Query("From TB_LDAP_SCREEN_MASTER where sub_module.id=:id ")
		public List<TB_LDAP_SCREEN_MASTER> getScreenName(@Param("id") int id);
}
