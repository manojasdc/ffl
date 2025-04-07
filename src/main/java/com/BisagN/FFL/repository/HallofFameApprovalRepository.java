package com.BisagN.FFL.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.BisagN.FFL.models.TbHallOfFame;
import com.BisagN.FFL.models.TbUserAlumniEjournal;

public interface HallofFameApprovalRepository extends JpaRepository<TbHallOfFame, Integer> {

	@Query(value = "FROM TbHallOfFame WHERE approvalStatus = 'Pending' and instituteMap=?1 and (?2 is null or CONCAT(lower(achievement)) LIKE %?2%)", countQuery = "SELECT COUNT(*) FROM TbHallOfFame WHERE approvalStatus = 'Pending' and instituteMap=?1 and (?2 is null or CONCAT(lower(achievement)) LIKE %?2%)")
	Page<TbHallOfFame> LoadhallofFameApprovalData(Integer id, String search, Pageable pageable);

}                                                                                                                              