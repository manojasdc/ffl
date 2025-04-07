package com.BisagN.FFL.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.BisagN.FFL.models.TbRegistrationDetail;


public interface RegistrationRepository extends JpaRepository<TbRegistrationDetail, Integer>{

	@Query(value = "SELECT r FROM TbRegistrationDetail r where r.alumniName=?1")
	List<TbRegistrationDetail> loadAlumninameData(String username);
	
	@Query(value = "select *  from tb_registration_detail where registration_status='Accepted' and institute_id=?3 limit ?2 offset ?1", nativeQuery = true)
	List<TbRegistrationDetail> LoadAlumniDashboard(int currentPage,int totalperpage,int aluminiinstituteid);
	
	@Query(value = "select count(*) from tb_registration_detail_child where  registration_status='Accepted' and institute_id=?1", nativeQuery = true )
	Integer LoadAlumniDashboard1(int username);
	
	
	@Query(value = "WITH months AS (\n"
			+ "  SELECT \n"
			+ "    TO_CHAR(DATE_TRUNC('month', DATE(?1 || '-01-01') + INTERVAL '1 month' * (LEVEL - 1)), 'Month') AS month,\n"
			+ "    DATE_TRUNC('month', DATE(?1 || '-01-01') + INTERVAL '1 month' * (LEVEL - 1)) AS month_start\n"
			+ "  FROM \n"
			+ "    GENERATE_SERIES(1, 12, 1) AS LEVEL\n"
			+ ")\n"
			+ "SELECT \n"
			+ "  m.month,\n"
			+ "  COALESCE(SUM(CASE WHEN r.gender = 'Male' THEN 1 ELSE 0 END), 0) AS male_count,\n"
			+ "  COALESCE(SUM(CASE WHEN r.gender = 'Female' THEN 1 ELSE 0 END), 0) AS female_count,\n"
			+ "  COALESCE(COUNT(r.id), 0) AS total_count\n"
			+ "FROM \n"
			+ "  months m\n"
			+ "  LEFT JOIN tb_registration_detail r \n"
			+ "    ON DATE_TRUNC('month', r.created_date) = m.month_start\n"
			+ "    AND EXTRACT(YEAR FROM r.created_date) = ?1\n"
			+ "GROUP BY \n"
			+ "  m.month, m.month_start\n"
			+ "ORDER BY \n"
			+ "  m.month_start", nativeQuery = true)
	List  getInstituteWiseAlumni(Integer year); 
	
	
	@Query(value = "WITH months AS (\n"
			+ "	SELECT TO_CHAR(DATE_TRUNC('month', DATE(?1 || '-01-01') + INTERVAL '1 month' * (LEVEL - 1)), 'Month') AS month,\n"
			+ "			 DATE_TRUNC('month', DATE(?1 || '-01-01') + INTERVAL '1 month' * (LEVEL - 1)) AS month_start\n"
			+ "			FROM \n"
			+ "			GENERATE_SERIES(1, 12, 1) AS LEVEL\n"
			+ "			)\n"
			+ "			SELECT m.month,COALESCE(COUNT(DISTINCT CASE WHEN r.gender = 'Male' AND ins.institute_name like %?2% THEN r.id ELSE NULL END), 0) AS male_count,\n"
			+ "	         COALESCE(COUNT(DISTINCT CASE WHEN r.gender = 'Female' AND ins.institute_name like %?2% THEN r.id ELSE NULL END), 0) AS female_count,\n"
			+ "	         COALESCE(COUNT(DISTINCT CASE WHEN ins.institute_name LIKE %?2% THEN r.id END), 0) AS total_count\n"
			+ "			FROM months m LEFT JOIN tb_registration_detail r ON DATE_TRUNC('month', r.created_date) = m.month_start \n"
			+ "	        LEFT JOIN tb_registration_detail_child rc ON rc.registration_id = r.id LEFT JOIN tb_institute_detail ins ON ins.id = rc.institute_id  \n"
			+ "	        WHERE EXTRACT(YEAR FROM r.created_date) = ?1 OR r.created_date IS NULL GROUP BY\n"
			+ "			m.month, m.month_start\n"
			+ "			ORDER BY m.month_start", nativeQuery = true)
			List   getInstituteWiseAlumni1(Integer year, String instid);
	
	@Query(value = "WITH months AS (\n"
			+ "  SELECT \n"
			+ "    TO_CHAR(DATE_TRUNC('month', DATE(?1 || '-01-01') + INTERVAL '1 month' * (LEVEL - 1)), 'Month') AS month,\n"
			+ "    DATE_TRUNC('month', DATE(?1 || '-01-01') + INTERVAL '1 month' * (LEVEL - 1)) AS month_start\n"
			+ "  FROM \n"
			+ "    GENERATE_SERIES(1, 12, 1) AS LEVEL\n"
			+ ")\n"
			+ "SELECT \n"
			+ "  m.month,\n"
			+ "  COALESCE(COUNT(DISTINCT CASE WHEN r.gender = 'Male'  and  r.country_id= ?2 THEN r.id ELSE NULL END), 0) AS male_count,\n"
			+ "  COALESCE(COUNT(DISTINCT CASE WHEN r.gender = 'Female' and  r.country_id= ?2 THEN r.id ELSE NULL END), 0) AS female_count,\n"
			+ "  COALESCE(COUNT(DISTINCT CASE WHEN  r.country_id= ?2 THEN r.id ELSE NULL END), 0) AS total_count\n"
			+ "FROM \n"
			+ "  months m\n"
			+ "  LEFT JOIN tb_registration_detail r \n"
			+ "    ON DATE_TRUNC('month', r.created_date) = m.month_start\n"
			+ "    AND EXTRACT(YEAR FROM r.created_date) = ?1\n"
			+ "  LEFT JOIN tb_registration_detail_child c \n"
			+ "    ON r.id = c.registration_id \n"
			+ "    \n"
			+ "GROUP BY \n"
			+ "  m.month, m.month_start\n"
			+ "ORDER BY \n"
			+ "  m.month_start", nativeQuery = true)
	List getusersinembasychart(Integer year, Integer countryid);
	
	
	@Query("From TbRegistrationDetail where userid = ?1 ")
	TbRegistrationDetail FindDataByUserId(int parseInt);
	
	@Query(value = "select count(*),passout_year from tb_registration_detail_child group by passout_year order by passout_year",
			nativeQuery = true)
	List getPassoutData();
	
	@Query(value = "select count(*),passout_year from tb_registration_detail_child where institute_id = ?1 group by passout_year order by passout_year",
			nativeQuery = true)
	List getPassoutData1(Integer instid);
	
		
}
