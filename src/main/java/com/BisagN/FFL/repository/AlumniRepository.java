//package com.BisagN.FFL.repository;
//
//import java.util.List;
//
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//
//import com.BisagN.FFL.models.TbAlumniDetails;
//import com.BisagN.FFL.models.TbHallOfFame;
//import com.BisagN.FFL.models.TbUserAlumniEjournal;
//
//public interface AlumniRepository extends JpaRepository<TbAlumniDetails, Integer> {
//
//
//	@Query(value = "From TbAlumniDetails where status = '1'and createdBy=?1  and (?2 is null or CONCAT(lower(line1), lower(line2),lower(countryId.countryName),lower(stateId.stateName),lower(cityId.cityName),pincode) LIKE %?2%)", countQuery = "select count(*) From TbAlumniDetails where status = '1'  and (?2 is null or CONCAT(lower(line1), lower(line2),lower(countryId.countryName),lower(stateId.stateName),lower(cityId.cityName),pincode) LIKE %?2%)")
//	Page<TbAlumniDetails> LoadAlumniDetails(Integer id,String search, Pageable pageable);
//	
//	@Query(value = "select * From tb_alumni_details where institute_map=?1 and created_by=?2 and approval_status='Approved' order by id desc limit 1", nativeQuery = true)
//	List<TbAlumniDetails> alumnidetails(Integer instid, Integer createdby); 
//	
//	@Query(value = "select count(l) from logininformation l inner join userroleinformation u on u.user_id=l.userid innerjoin roleinformation r on r.roleId=u.userRoleId where r.role='USER'", nativeQuery = true )
//	Integer Loadallalumni();
//	
//
//}                                                                                                                              