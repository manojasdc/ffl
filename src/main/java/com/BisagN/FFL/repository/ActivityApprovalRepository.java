package com.BisagN.FFL.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.BisagN.FFL.models.TbMiscActivity;

@Repository
public interface ActivityApprovalRepository extends JpaRepository<TbMiscActivity, Integer> {

//	@Query(value = "FROM TbMiscActivity WHERE approvalStatus = 'Pending' and instituteMap=?1 and (?2 is null or CONCAT(lower(miscTitle),lower(miscDescription)) LIKE %?2%)", countQuery = "SELECT COUNT(*) FROM TbMiscActivity WHERE approvalStatus = 'Pending' and instituteMap=?1  and (?2 is null or CONCAT(lower(miscTitle),lower(miscDescription)) LIKE %?2)")
//	Page<TbMiscActivity> LoadActivityApprovalData(Integer id, String search, Pageable pageable);

	@Query(value = "FROM TbMiscActivity WHERE approvalStatus = ?2 and instituteMap=?1 and (?3 is null or CONCAT(lower(miscTitle),lower(miscDescription)) LIKE %?3%)", countQuery = "SELECT COUNT(*) FROM TbMiscActivity WHERE approvalStatus = ?2 and instituteMap=?1  and (?3 is null or CONCAT(lower(miscTitle),lower(miscDescription)) LIKE %?3)")
	Page<TbMiscActivity> LoadActivityApprovalData(Integer id, String approvalStatus,String search, Pageable pageable);
}