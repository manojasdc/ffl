package com.BisagN.FFL.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.BisagN.FFL.models.TbInstituteDetail;
import com.BisagN.models.Role;

@Repository
public interface InstituteRepository extends JpaRepository<TbInstituteDetail, Integer> {

	@Query(value = "FROM TbInstituteDetail order by institute_name ASC ")
	List<TbInstituteDetail> LoadInstituteData();

	@Query(value = "select id From tb_institute_detail where institute_name LIKE %?1% limit 1", nativeQuery = true)
	Integer instituteid(String instname);

	@Query(value = "select count(*) from tb_institute_detail ", nativeQuery = true)
	Integer Loadallnoofinstitute();

	@Query(value = "SELECT count(DISTINCT institute_name) FROM tb_institute_detail", nativeQuery = true)
	Integer InstituteCount();
	
	@Query(value = "select institute_name from tb_institute_detail where id in( select institute_id from logininformation where userid = ?1)", nativeQuery = true)
	String FindInsName(Integer instituteMap);	

}
