package com.BisagN.FFL.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.BisagN.FFL.models.TbCountryName;


@Repository
public interface CountryRepository extends JpaRepository<TbCountryName, Integer> {
	
	@Query(value = "FROM TbCountryName ORDER BY country_name ASC")
	List<TbCountryName> LoadCountryData();
	
	@Query(value = "FROM TbCountryName where id != '-1' ORDER BY id ASC")
	List<TbCountryName> LoadData();

	@Query(value = "select count(*) from tb_country_name ", nativeQuery = true )
	Integer Loadallcounties();
	
//	@Query(value = "SELECT \n"
//			+ "  SUM(CASE WHEN rc.passout_year = ?1 AND rc.registration_status='Accepted' AND r.gender = 'Male' THEN 1 ELSE 0 END) AS male_count,\n"
//			+ "  SUM(CASE WHEN rc.passout_year = ?1 AND rc.registration_status='Accepted' AND r.gender = 'Female' THEN 1 ELSE 0 END) AS female_count,\n"
//			+ "  SUM(CASE WHEN rc.passout_year = ?1 AND rc.registration_status='Accepted' THEN 1 ELSE 0 END) AS total_count,\n"
//			+ "  c.country_name AS country\n"
//			+ "  \n"
//			+ "FROM \n"
//			+ "  tb_country_name c\n"
//			+ "  LEFT JOIN tb_registration_detail r ON r.country_id = c.id\n"
//			+ "  LEFT JOIN tb_registration_detail_child rc ON rc.registration_id = r.id\n"
//			+ "GROUP BY \n"
//			+ "  c.country_name",nativeQuery = true)
//	List getcountryuserChart(Integer year);
	
//	@Query(value = "SELECT \n"
//			+ "  SUM(CASE WHEN rc.passout_year = ?1 AND rc.registration_status='Accepted'  AND rc.institute_id=?2 AND r.gender = 'Male' THEN 1 ELSE 0 END) AS male_count,\n"
//			+ "  SUM(CASE WHEN rc.passout_year = ?1 AND rc.registration_status='Accepted'  AND rc.institute_id=?2 AND r.gender = 'Female' THEN 1 ELSE 0 END) AS female_count,\n"
//			+ "  SUM(CASE WHEN rc.passout_year = ?1 AND rc.registration_status='Accepted'  AND rc.institute_id=?2 THEN 1 ELSE 0 END) AS total_count,\n"
//			+ "  c.country_name AS country\n"
//			+ "  \n"
//			+ "FROM \n"
//			+ "  tb_country_name c\n"
//			+ "  LEFT JOIN tb_registration_detail r ON r.country_id = c.id\n"
//			+ "  LEFT JOIN tb_registration_detail_child rc ON rc.registration_id = r.id\n"
//			+ "GROUP BY \n"
//			+ "  c.country_name",nativeQuery = true)
//	List getcountryuserChart1(Integer year, Integer instid);
	
//	@Query(value = "FROM TbCountryName where lower(countryName) like %?1%")
//	List<TbCountryName> findbycountryname(String countryname);
	
	@Query(value = "FROM TbCountryName where id = ?1")
	List<TbCountryName> findbycountryname(Integer countryname);
	
	@Query(value = "SELECT \n"
			+ "  SUM(CASE WHEN  rc.registration_status='Accepted'  AND rc.institute_id=?1 AND r.gender = 'Male' THEN 1 ELSE 0 END) AS male_count,\n"
			+ "  SUM(CASE WHEN  rc.registration_status='Accepted'  AND rc.institute_id=?1 AND r.gender = 'Female' THEN 1 ELSE 0 END) AS female_count,\n"
			+ "  SUM(CASE WHEN  rc.registration_status='Accepted'  AND rc.institute_id=?1 THEN 1 ELSE 0 END) AS total_count,\n"
			+ "  c.country_name AS country\n"
			+ "  \n"
			+ "FROM \n"
			+ "  tb_country_name c\n"
			+ "  LEFT JOIN tb_registration_detail r ON r.country_id = c.id\n"
			+ "  LEFT JOIN tb_registration_detail_child rc ON rc.registration_id = r.id\n"
			+ "GROUP BY \n"
			+ "  c.country_name",nativeQuery = true)
	List getcountryuserChart1( Integer instid);
	
	@Query(value = "SELECT \n"
			+ "  SUM(CASE WHEN  rc.registration_status='Accepted' AND r.gender = 'Male' THEN 1 ELSE 0 END) AS male_count,\n"
			+ "  SUM(CASE WHEN  rc.registration_status='Accepted' AND r.gender = 'Female' THEN 1 ELSE 0 END) AS female_count,\n"
			+ "  SUM(CASE WHEN rc.registration_status='Accepted' THEN 1 ELSE 0 END) AS total_count,\n"
			+ "  c.country_name AS country\n"
			+ "  \n"
			+ "FROM \n"
			+ "  tb_country_name c\n"
			+ "  LEFT JOIN tb_registration_detail r ON r.country_id = c.id\n"
			+ "  LEFT JOIN tb_registration_detail_child rc ON rc.registration_id = r.id\n"
			+ "GROUP BY \n"
			+ "  c.country_name",nativeQuery = true)
	List getcountryuserChart();
	
	
}