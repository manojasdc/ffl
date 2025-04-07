//package com.BisagN.FFL.repository;
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
//public interface AlumniApprovalRepository extends JpaRepository<TbAlumniDetails, Integer> {
//
//	@Query(value = "FROM TbAlumniDetails WHERE approvalStatus = 'Pending' and instituteMap=?1 and (?2 is null or CONCAT(lower(line1), lower(line2),lower(countryId.countryName),lower(stateId.stateName),lower(cityId.cityName),pincode) LIKE %?2%) ", countQuery = "SELECT COUNT(*) FROM TbAlumniDetails WHERE approvalStatus = 'Pending' and instituteMap=?1 and (?2 is null or CONCAT(lower(line1), lower(line2),lower(countryId.countryName),lower(stateId.stateName),lower(cityId.cityName),pincode) LIKE %?2%)")
//	Page<TbAlumniDetails> LoadalumniApprovalData(Integer id, String search, Pageable pageable);
//
//}                                                                                                                              