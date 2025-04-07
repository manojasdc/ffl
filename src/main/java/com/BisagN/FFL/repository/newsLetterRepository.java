package com.BisagN.FFL.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.BisagN.FFL.models.TbNewsLetter;
import com.BisagN.FFL.models.TbUserAlumniEjournal;

public interface newsLetterRepository extends JpaRepository<TbNewsLetter, Integer> {

	@Query(value = "From TbNewsLetter where status = '1' and createdBy=?1 and (?2 is null or CONCAT(lower(description),lower(newsLetterName)) LIKE %?2%)", countQuery = "select count(*) From TbNewsLetter where status ='1' and createdBy=?1 and (?2 is null or CONCAT(lower(description),lower(newsLetterName)) LIKE %?2%)")
	Page<TbNewsLetter> loadNewsLetterData(Integer created_by, String search, Pageable pageable);

	@Query(value = "From TbNewsLetter where status = '1' and instituteMap=?1 and (?2 is null or CONCAT(lower(description),lower(newsLetterName)) LIKE %?2%)", countQuery = "select count(*) From TbNewsLetter where status ='1' and instituteMap=?1 and (?2 is null or CONCAT(lower(description),lower(newsLetterName)) LIKE %?2%)")
	Page<TbNewsLetter> loadNewsLetterData1(Integer created_by, String search, Pageable pageable);

	@Query(value = "From TbNewsLetter where status = '1'and (?1 is null or CONCAT(lower(description),lower(newsLetterName)) LIKE %?1%)", countQuery = "select count(*) From TbNewsLetter where status ='1' and (?1 is null or CONCAT(lower(description),lower(newsLetterName)) LIKE %?1%)")
	Page<TbNewsLetter> loadNewsLetterData2(String search, Pageable pageable);

	@Query(value = "select * from tb_news_letter where institute_map=?3 and status='1'  order by id desc limit ?2 offset ?1", nativeQuery = true)
	List<TbNewsLetter> getAllData(int currentPage, int totalperpage, Integer created_by);

	@Query(value = "select * from tb_news_letter where institute_map=?1 and status='1'  order by id desc limit 6", nativeQuery = true)
	List<TbNewsLetter> getAllData1(Integer created_by);

	@Query(value = "FROM TbNewsLetter WHERE approvalStatus = 'Pending' and instituteMap=?1 and (?2 is null or CONCAT(lower(description),lower(newsLetterName)) LIKE %?2%)", countQuery = "SELECT COUNT(*) FROM TbNewsLetter WHERE approvalStatus = 'Pending' and instituteMap=?1 and (?2 is null or CONCAT(lower(description),lower(newsLetterName)) LIKE %?2%)")
	Page<TbNewsLetter> LoadNewsLetterApprovalData(Integer id, String search, Pageable pageable);

	@Query(value = "select count(*) from tb_news_letter", nativeQuery = true)
	Integer LoadNewsLettersDashboard1(Integer instituteid);

	@Query("FROM TbNewsLetter where lower(newsLetterName) =?1")
	public List checkNewsletterExists(String newsLetterName);

}
