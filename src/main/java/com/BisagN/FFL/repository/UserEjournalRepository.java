package com.BisagN.FFL.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.BisagN.FFL.models.TbUserAlumniEjournal;

public interface UserEjournalRepository  extends JpaRepository<TbUserAlumniEjournal, Integer>  {
	
	@Query(value = "From TbUserAlumniEjournal where status = '1' and createdBy=?1  and (?2 is null or CONCAT(lower(name),lower(description),lower(author),lower(category),lower(publisher),lower(language)) LIKE %?2%)", countQuery = "select count(*) From TbUserAlumniEjournal where status ='1' and createdBy=?1 and (?2 is null or CONCAT(lower(name),lower(description),lower(author),lower(category),lower(publisher),lower(language)) LIKE %?2%)")
	Page<TbUserAlumniEjournal> LoadUserejournalData(Integer created_by,String search, Pageable pageable);
	
	@Query(value = "From TbUserAlumniEjournal where status = '1' and instituteMap=?1  and (?2 is null or CONCAT(lower(name),lower(description),lower(author),lower(category),lower(publisher),lower(language)) LIKE %?2%)", countQuery = "select count(*) From TbUserAlumniEjournal where status ='1' and instituteMap=?1   and (?2 is null or CONCAT(lower(name),lower(description),lower(author),lower(category),lower(publisher),lower(language)) LIKE %?2%)")
	Page<TbUserAlumniEjournal> LoadUserejournalData1(Integer created_by,String search, Pageable pageable);
	
	@Query(value = "From TbUserAlumniEjournal where status = '1'  and (?1 is null or CONCAT(lower(name),lower(description),lower(author),lower(category),lower(publisher),lower(language)) LIKE %?1%)", countQuery = "select count(*) From TbUserAlumniEjournal where status ='1'   and (?1 is null or CONCAT(lower(name),lower(description),lower(author),lower(category),lower(publisher),lower(language)) LIKE %?1%)")
	Page<TbUserAlumniEjournal> LoadUserejournalData2(String search, Pageable pageable);

	@Query(value = "select * from tb_user_alumni_ejournal where status='1' and institute_map=?3  limit ?2 offset ?1", nativeQuery = true)
	List<TbUserAlumniEjournal> LoadJournalDashboard(int currentPage,int totalperpage,Integer userid);
	
	@Query(value = "select count(*) from tb_user_alumni_ejournal where status='1' and institute_map=?1 ", nativeQuery = true )
	Integer LoadJournalDashboard1(Integer instituteid);
	
	@Query("FROM TbUserAlumniEjournal where lower(name) =?1")
	public List checkUserejournalExists(String name);
//	@Query("FROM TbUserAlumniEjournal where lower(name) =?1 and to_char(publisherDate,'yyyy-MM-dd') =?2")
//	public List checkUserejournalExists(String name, String publisherDate);
}