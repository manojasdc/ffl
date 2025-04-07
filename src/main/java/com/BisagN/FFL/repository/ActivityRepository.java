package com.BisagN.FFL.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.BisagN.FFL.models.TbMiscActivity;

@Repository
public interface ActivityRepository extends JpaRepository<TbMiscActivity, Integer> {

	@Query(value = "SELECT * FROM tb_misc_activity U where status = '1'", nativeQuery = true)
	List<TbMiscActivity> getyeardata();

	@Query(value = "From TbMiscActivity where status = '1' and createdBy=?1 and (?2 is null or CONCAT(lower(miscTitle),lower(miscDescription)) LIKE %?2%)", countQuery = "select count(*) From TbMiscActivity where status = '1' and createdBy=?1 and (?2 is null or CONCAT(lower(miscTitle),lower(miscDescription)) LIKE %?2%)")
	Page<TbMiscActivity> LoadActivityDetail(Integer id, String search, Pageable pageable);

	@Query(value = "select *  from tb_misc_activity where status='1' and institute_map=?3 and approval_status='Approved' limit ?2 offset ?1", nativeQuery = true)
	List<TbMiscActivity> LoadActivityDashboard(int currentPage, int totalperpage, Integer userid);

	@Query(value = "select count(*) from tb_misc_activity where status='1' and institute_map=?1 and approval_status='Approved'", nativeQuery = true)
	Integer LoadActivityDashboard1(Integer instituteid);

	/// count of blogs adminDashboard
	@Query(value = "select count(*) from tb_misc_activity ", nativeQuery = true)
	Integer Loadallblogs();

//	@Query(value = "SELECT ins.institute_name as institute, COUNT(a.id)\n" + "FROM tb_institute_detail ins\n"
//			+ "LEFT JOIN userloginchild l ON l.institute_id = ins.id\n"
//			+ "LEFT JOIN tb_misc_activity a ON a.institute_map = l.user_id AND a.year=?1 AND  a.approval_status='Approved'\n"
//			+ "GROUP BY ins.id\n" + "ORDER BY ins.institute_name", nativeQuery = true)
//	List getallinstituteblogchart(String year);
	
	@Query(value = "SELECT ins.institute_name as institute, COUNT(a.id)\n" + "FROM tb_institute_detail ins\n"
			+ "LEFT JOIN userloginchild l ON l.institute_id = ins.id\n"
			+ "LEFT JOIN tb_misc_activity a ON a.institute_map = l.user_id  AND  a.approval_status='Approved'\n"
			+ "GROUP BY ins.id\n" + "ORDER BY ins.institute_name", nativeQuery = true)
	List getallinstituteblogchart();

	@Query("FROM TbMiscActivity where  lower(miscTitle) =?1")
	public List checkmiscactExists(String miscTitle);

}
