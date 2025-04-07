package com.BisagN.FFL.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.BisagN.FFL.models.TbUserAlumniEjournal;


public interface EjournalApprovalRepository  extends JpaRepository<TbUserAlumniEjournal, Integer>  {
	
	
	@Query(value = "FROM TbUserAlumniEjournal WHERE approvalStatus = 'Pending' and instituteMap=?1 and (?2 is null or CONCAT(lower(name),lower(description),lower(author),lower(category),lower(publisher),lower(language)) LIKE %?2%) ",
		       countQuery = "SELECT COUNT(*) FROM TbUserAlumniEjournal WHERE approvalStatus = 'Pending' and instituteMap=?1 and (?2 is null or CONCAT(lower(name),lower(description),lower(author),lower(category),lower(publisher),lower(language)) LIKE %?2%)")
		Page<TbUserAlumniEjournal> LoadjournalApprovalData(Integer id,String search, Pageable pageable);
	

}